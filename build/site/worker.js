// mc-web: Web Worker running one singleplayer world's server (MIT License). Loaded by js/lw-worker.js.
self.LWJGLWeb = { config: { heapMB: 256 }, isWorker: true };
for (const level of ["log", "info", "warn", "error"]) {
  const orig = console[level].bind(console);
  console[level] = (...a) => {
    orig(...a);
    try { postMessage({ type: "log", level: level === "info" ? "log" : level, text: a.map(String).join(" ") }); } catch (e) {}
  };
}
// the lw-*.js files are ES-module style (each declares its own `const LW`): run each in its own function scope
function runScoped(url) {
  const x = new XMLHttpRequest();
  x.open("GET", url, false);
  x.send();
  if (x.status !== 200) throw new Error(url + ": HTTP " + x.status);
  new Function(x.responseText + "\n//# sourceURL=" + url)();
}
importScripts("js/fflate.min.js", "js/stackdecode.js");
for (const f of ["js/lw-heap.js", "js/lw-core.js", "js/lw-idb.js", "js/lw-net.js"]) runScoped(f);
const LW = self.LWJGLWeb;

const pending = new Map();
LW.fetchFile = async (url) => {
  const r = await fetch(url);
  if (!r.ok) throw new Error(url + ": HTTP " + r.status);
  const b = new Int8Array(await r.arrayBuffer());
  if (!pending.has(url)) pending.set(url, []);
  pending.get(url).push(b);
  return b.length;
};
LW.takeFile = (url, dst) => { const q = pending.get(url); dst.set(q.shift()); if (!q.length) pending.delete(url); };

// events for the Java accept loop: connection ids (> 0) and -1 for "stop"
const events = [];
let waiter = null;
const pushEvent = (v) => { if (waiter) { const w = waiter; waiter = null; w(v); } else events.push(v); };
LW.workerNextEvent = (cb) => { if (events.length) cb(events.shift()); else waiter = cb; };
LW.workerPost = (m) => postMessage(m);
LW.workerStoppedSaved = () => postMessage({ type: "stopped" });

onmessage = async (e) => {
  const m = e.data || {};
  if (m.type === "start") {
    try {
      LW.N = LW.buildNatives(await (await fetch("natives.json")).json());
      LW.sigs = await (await fetch("sigs.json")).json();
      importScripts("classes.js");
      main(["--mcweb-server", m.settings]);
    } catch (err) {
      console.error("[mc-web] world worker failed:", String(err), err && err.stack);
      throw err;
    }
  } else if (m.type === "conn") {
    pushEvent(LW.netAdoptPort(e.ports[0]));
  } else if (m.type === "stop") {
    pushEvent(-1);
  }
};
