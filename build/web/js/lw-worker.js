// mc-web: page side of the singleplayer world worker (MIT License). The worker (worker.js) runs Minecraft's server
// for one world on a second CPU core; the game connects to it over MessagePorts (see lw-net.js, McWorker.java).
const LW = globalThis.LWJGLWeb;
let worker = null, stopping = false, stoppedResolve = null, stoppedPromise = null, stopTimer = 0;

function finish() {
  clearTimeout(stopTimer);
  const w = worker;
  worker = null;
  stopping = false;
  try { w && w.terminate(); } catch (e) {}
  if (stoppedResolve) { const r = stoppedResolve; stoppedResolve = null; r(); }
}

LW.worldWorkerStart = (settings) => new Promise((resolve, reject) => {
  if (worker) finish();
  stoppedPromise = new Promise((r) => (stoppedResolve = r));
  let ready = false;
  const t0 = performance.now();
  worker = new Worker("worker.js");
  worker.onmessage = (e) => {
    const m = e.data || {};
    if (m.type === "log") (console[m.level] || console.log)("[world] " + m.text);
    else if (m.type === "ready") {
      ready = true;
      console.log("[mc-web] world worker ready in", Math.round(performance.now() - t0), "ms");
      resolve();
    } else if (m.type === "stopped") {
      console.log("[mc-web] world saved and stopped");
      finish();
    }
  };
  worker.onerror = (e) => {
    console.error("[mc-web] world worker error:", e.message || e);
    if (!ready) { reject(new Error(e.message || "worker failed")); finish(); }
  };
  worker.postMessage({ type: "start", settings });
});

LW.worldWorkerConnect = () => {
  const ch = new MessageChannel();
  worker.postMessage({ type: "conn" }, [ch.port2]);
  return ch.port1;
};

LW.worldWorkerStop = () => {
  if (!worker || stopping) return;
  stopping = true;
  worker.postMessage({ type: "stop" });
  // the world normally saves within seconds; don't wait forever
  stopTimer = setTimeout(() => { console.warn("[mc-web] world worker did not stop in time"); finish(); }, 120000);
};

LW.worldWorkerStopped = () => stoppedPromise || Promise.resolve();

// closing the tab while a world runs: ask it to save (best effort)
addEventListener("beforeunload", (e) => { if (worker) { LW.worldWorkerStop(); e.preventDefault(); e.returnValue = ""; } });
