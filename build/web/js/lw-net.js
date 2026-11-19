// mc-web: WebSocket connections for multiplayer (through the mc-web relay). MIT License.
// Java (mcweb.rt.McNet) opens a socket, then waits for events and pulls received chunks out one at a time.
const LW = globalThis.LWJGLWeb;
const conns = new Map();
let nextId = 1;

// The relay normally sits behind the page server on the same origin (nginx in the Docker image proxies /relay).
// The local-play server (serve.py) has no proxy, so when /relay/health isn't answered here we fall back to :8091.
let relayBase = (location.protocol === "https:" ? "wss://" : "ws://") + location.host + "/relay";
fetch("relay/health").then((r) => { if (!r.ok) throw 0; }).catch(() => { relayBase = "ws://" + location.hostname + ":8091/relay"; });
function relayUrl(target) {
  const base = LW.config.relayUrl || relayBase;
  return base + "?target=" + encodeURIComponent(target);
}

// always deferred: this can be called from inside a running green thread (netClose), and resuming another
// TeaVM thread synchronously from there throws "Another thread is running"
function wake(c) {
  const w = c.waiter;
  if (w) { c.waiter = null; setTimeout(w, 0); }
}

// a connection over a MessagePort (singleplayer world running in a Web Worker); same API as WebSocket ones
function adoptPort(port) {
  const id = nextId++;
  const c = { q: [], state: 1, reason: "", waiter: null, ws: null };
  c.ws = { send: (b) => port.postMessage(b, [b.buffer]), close: () => { try { port.postMessage({ close: true }); port.close(); } catch (e) {} } };
  port.onmessage = (e) => {
    if (e.data && e.data.close) { if (c.state !== 2) { c.state = 2; c.reason = "World closed"; wake(c); } return; }
    c.q.push(new Int8Array(e.data));
    wake(c);
  };
  conns.set(id, c);
  return id;
}
LW.netAdoptPort = adoptPort;

LW.netOpen = (target) => {
  if (/^mcweb-worker(:\d+)?$/.test(target) && LW.worldWorkerConnect) {
    const id = adoptPort(LW.worldWorkerConnect());
    conns.get(id).onClose = () => LW.worldWorkerStop && LW.worldWorkerStop();
    return id;
  }
  const id = nextId++;
  const c = { q: [], state: 0, reason: "", waiter: null, ws: null };
  conns.set(id, c);
  try {
    const ws = new WebSocket(relayUrl(target));
    ws.binaryType = "arraybuffer";
    c.ws = ws;
    ws.onopen = () => { c.state = 1; wake(c); };
    ws.onmessage = (e) => { c.q.push(new Int8Array(e.data)); wake(c); };
    ws.onclose = (e) => {
      if (c.state !== 2) c.reason = e.reason || (c.state === 0 ? "Could not reach the relay (code " + e.code + ")" : "Connection closed (code " + e.code + ")");
      c.state = 2;
      wake(c);
    };
    ws.onerror = () => {};
  } catch (e) {
    c.state = 2;
    c.reason = String(e && e.message || e);
  }
  return id;
};
// 0 connecting, 1 open, 2 closed
LW.netState = (id) => (conns.get(id) || { state: 2 }).state;
LW.netReason = (id) => (conns.get(id) || { reason: "" }).reason;
// resolves on the next event, or after maxMs so queued Netty tasks still get run
LW.netWait = (id, maxMs, cb) => {
  const c = conns.get(id);
  if (!c || c.q.length || c.state === 2) { cb(); return; }
  let done = false;
  const once = () => { if (!done) { done = true; c.waiter = null; cb(); } };
  c.waiter = once;
  setTimeout(once, maxMs);
};
LW.netWaitOpen = (id, cb) => {
  const c = conns.get(id);
  if (!c || c.state !== 0) { cb(); return; }
  c.waiter = cb;
};
LW.netNextSize = (id) => { const c = conns.get(id); return c && c.q.length ? c.q[0].length : -1; };
LW.netTake = (id, dst) => { const c = conns.get(id); dst.set(c.q.shift()); };
LW.netSend = (id, bytes) => { const c = conns.get(id); if (c && c.ws && c.state === 1) c.ws.send(bytes); };
LW.netClose = (id) => {
  const c = conns.get(id);
  if (!c) return;
  if (c.state !== 2) c.reason = "Disconnected";
  c.state = 2;
  try { c.ws && c.ws.close(); } catch (e) {}
  wake(c);
  conns.delete(id);
  if (c.onClose) c.onClose();
};
