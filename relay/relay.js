// mc-web relay (MIT License): WebSocket <-> TCP bridge so the browser build of Minecraft can join offline-mode
// servers. Every connection must carry a valid Cloudflare Access token, and may only reach allowlisted servers.
import http from "node:http";
import net from "node:net";
import dns from "node:dns/promises";
import { createRemoteJWKSet, jwtVerify } from "jose";
import { WebSocketServer } from "ws";

const env = (k, d) => (process.env[k] ?? d);
const PORT = +env("PORT", "8091");
const TEAM = env("CF_TEAM_DOMAIN", "");                       // e.g. chocobonetwork.cloudflareaccess.com
const AUD = env("CF_ACCESS_AUD", "");                         // Access application audience tag
const PUBLIC_HOST = env("PUBLIC_HOST", "");                   // e.g. mc-web.chocobonetwork.com (Origin check)
const ALLOWED_EMAILS = env("ALLOWED_EMAILS", "").split(",").map((s) => s.trim().toLowerCase()).filter(Boolean);
// "host:port" or "alias=host:port" (players then type just the alias in Minecraft)
const withPort = (t) => (/:\d+$/.test(t) ? t : t + ":25565");
const TARGETS = new Map();
let ANY = false;   // ALLOWED_TARGETS=* : any public server (private/LAN addresses still need an explicit entry)
for (const e of env("ALLOWED_TARGETS", "minecraft:25565").split(",").map((s) => s.trim()).filter(Boolean)) {
  if (e === "*") { ANY = true; continue; }
  const [alias, real] = e.includes("=") ? e.split("=", 2).map((x) => x.trim()) : [e, e];
  TARGETS.set(withPort(alias).toLowerCase(), withPort(real));
}
const MAX_PER_USER = +env("MAX_CONNECTIONS_PER_USER", "3");
const IDLE_MS = +env("IDLE_TIMEOUT_SECONDS", "300") * 1000;
const INSECURE = env("INSECURE_NO_AUTH", "") === "1";        // local testing only

if (!INSECURE && (!TEAM || !AUD)) {
  console.error("CF_TEAM_DOMAIN and CF_ACCESS_AUD are required (or INSECURE_NO_AUTH=1 for local tests)");
  process.exit(1);
}
const jwks = TEAM ? createRemoteJWKSet(new URL(`https://${TEAM}/cdn-cgi/access/certs`)) : null;
const perUser = new Map();
const log = (...a) => console.log(new Date().toISOString(), ...a);

async function identify(req) {
  if (INSECURE) return "local";
  const token = req.headers["cf-access-jwt-assertion"];
  if (!token) throw new Error("missing Cloudflare Access token");
  const { payload } = await jwtVerify(token, jwks, { issuer: `https://${TEAM}`, audience: AUD });
  const email = String(payload.email || "").toLowerCase();
  if (!email) throw new Error("token has no email");
  if (ALLOWED_EMAILS.length && !ALLOWED_EMAILS.includes(email)) throw new Error("email not allowed: " + email);
  return email;
}

function pickTarget(url) {
  const want = withPort(new URL(url, "http://x").searchParams.get("target") || [...TARGETS.keys()][0]).toLowerCase();
  let real = TARGETS.get(want);
  if (!real && ANY) {
    const m = /^([a-z0-9.-]{1,253}):(\d{1,5})$/.exec(want);
    if (!m || +m[2] < 1 || +m[2] > 65535) throw new Error("bad target: " + want);
    return { host: m[1], port: +m[2], name: want, open: true };
  }
  if (!real) throw new Error("target not allowed: " + want);
  const i = real.lastIndexOf(":");
  return { host: real.slice(0, i), port: +real.slice(i + 1), name: want === real ? real : want + " (" + real + ")" };
}

const server = http.createServer((req, res) => {
  if (req.url === "/relay/health") { res.writeHead(200, { "content-type": "text/plain" }); res.end("ok"); return; }
  if (req.url.startsWith("/relay/servers")) {
    // the game asks which servers it may join (shown in the multiplayer list)
    res.writeHead(200, { "content-type": "application/json" });
    res.end(JSON.stringify([...TARGETS.keys()]));
    return;
  }
  res.writeHead(426); res.end("WebSocket required");
});
const wss = new WebSocketServer({ noServer: true, maxPayload: 8 * 1024 * 1024 });

server.on("upgrade", async (req, socket, head) => {
  const reject = (code, why) => { log("rejected:", why); socket.write(`HTTP/1.1 ${code} ${why}\r\n\r\n`); socket.destroy(); };
  try {
    if (!req.url.startsWith("/relay")) return reject(404, "Not Found");
    if (PUBLIC_HOST && req.headers.origin && req.headers.origin !== `https://${PUBLIC_HOST}`) return reject(403, "Bad Origin");
    const user = await identify(req);
    const target = pickTarget(req.url);
    if ((perUser.get(user) || 0) >= MAX_PER_USER) return reject(429, "Too Many Connections");
    wss.handleUpgrade(req, socket, head, (ws) => bridge(ws, user, target));
  } catch (e) {
    reject(403, "Forbidden (" + e.message.replace(/[\r\n]/g, " ").slice(0, 80) + ")");
  }
});

// Like the real game: a server on the default port may publish an SRV record (_minecraft._tcp.<host>) with its real address.
async function resolveMinecraft(host, port) {
  if (port !== 25565 || net.isIP(host)) return [host, port];
  try {
    const srv = (await dns.resolveSrv("_minecraft._tcp." + host)).sort((a, b) => a.priority - b.priority)[0];
    if (srv) return [srv.name.replace(/\.$/, ""), srv.port];
  } catch {}
  return [host, port];
}

function isPrivate(ip) {
  ip = ip.replace(/^::ffff:/i, "");
  if (net.isIPv4(ip)) {
    const [a, b] = ip.split(".").map(Number);
    return a === 0 || a === 10 || a === 127 || (a === 100 && b >= 64 && b < 128) || (a === 169 && b === 254)
      || (a === 172 && b >= 16 && b < 32) || (a === 192 && b === 168) || a >= 224;
  }
  const l = ip.toLowerCase();
  return l === "::" || l === "::1" || l.startsWith("fc") || l.startsWith("fd") || l.startsWith("fe8") || l.startsWith("fe9")
    || l.startsWith("fea") || l.startsWith("feb") || l.startsWith("ff");
}

function bridge(ws, user, target) {
  perUser.set(user, (perUser.get(user) || 0) + 1);
  log(`open  ${user} -> ${target.name}`);
  const tcp = new net.Socket();
  tcp.setNoDelay(true);
  resolveMinecraft(target.host, target.port).then(async ([host, port]) => {
    if (host !== target.host || port !== target.port) log(`srv   ${target.host}:${target.port} -> ${host}:${port}`);
    if (target.open) {   // "*" targets: only public internet addresses
      const { address } = await dns.lookup(host);
      if (isPrivate(address)) throw new Error("private address not allowed: " + address);
      host = address;
    }
    if (!tcp.destroyed) tcp.connect({ host, port });
  }).catch((e) => tcp.destroy(e));
  let idle = setTimeout(() => ws.close(4000, "idle"), IDLE_MS);
  const touch = () => { clearTimeout(idle); idle = setTimeout(() => ws.close(4000, "idle"), IDLE_MS); };
  const pending = [];
  let connected = false, paused = false, closed = false;
  tcp.on("connect", () => { connected = true; for (const b of pending) tcp.write(b); pending.length = 0; });
  ws.on("message", (data) => { touch(); if (connected) tcp.write(data); else pending.push(data); });
  tcp.on("data", (b) => {
    touch();
    ws.send(b);
    // backpressure: pause the server side while the browser is slow to read
    if (!paused && ws.bufferedAmount > 4 * 1024 * 1024) {
      paused = true;
      tcp.pause();
      const t = setInterval(() => {
        if (closed || ws.bufferedAmount < 1024 * 1024) { clearInterval(t); paused = false; if (!closed) tcp.resume(); }
      }, 20);
    }
  });
  const close = (why) => {
    if (closed) return;
    closed = true;
    clearTimeout(idle);
    perUser.set(user, Math.max(0, (perUser.get(user) || 1) - 1));
    log(`close ${user} -> ${target.name} (${why})`);
    try { tcp.destroy(); } catch {}
    try { ws.close(); } catch {}
  };
  tcp.on("error", (e) => close("server: " + e.message));
  tcp.on("close", () => close("server closed"));
  ws.on("close", () => close("browser closed"));
  ws.on("error", (e) => close("browser: " + e.message));
}

server.listen(PORT, () => log(`mc-web relay on :${PORT}; allowed targets: ${[...TARGETS].length ? "" : "(none)"}${[...TARGETS].map(([a, r]) => a === r ? r : a + " -> " + r).join(", ")}${ANY ? ", any public server (*)" : ""}${INSECURE ? " (NO AUTH)" : ""}`));
