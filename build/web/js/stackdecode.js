// mc-web: turns JavaScript stack frames of TeaVM code into Java stack trace entries (MIT License).
// TeaVM calls $rt_decodeStack when it is defined; postprocess.sh wires it to this function.
globalThis.mcwebDecodeStack = (stack) => {
  const out = [];
  for (const line of String(stack).split("\n")) {
    const m = /at (?:\$rt_java\.)?([A-Za-z0-9_$]+) \(.*?:(\d+):\d+\)/.exec(line);
    if (!m) continue;
    const name = m[1];
    if (name.startsWith("$rt_") || name === "JavaError" || name.startsWith("jl_Throwable") || name.endsWith("Exception__init_") ||
        /Exception__init_\d*$/.test(name) || /Error__init_\d*$/.test(name)) continue;
    out.push({ className: name, methodName: "", fileName: "classes.js", lineNumber: +m[2] });
  }
  return out;
};
globalThis.mcwebClinitError = (cls, e) => {
  let msg = e;
  try { const j = e && e.$javaException !== undefined ? e : null; msg = String(e && e.message ? e.message : e); } catch (_) {}
  console.error("[mc-web] static initializer of " + cls + " failed: " + msg + "\n" + (e && e.stack ? e.stack.split("\n").slice(0, 40).join("\n") : ""));
};
globalThis.mcwebClinitStarts = new Map();
globalThis.mcwebClinitStart = (cls) => { mcwebClinitStarts.set(cls, new Error().stack); };
globalThis.mcwebSuspends = [];
globalThis.mcwebLastSuspend = new Map(); let mcwebSuspendSeq = 0;
globalThis.mcwebOnSuspend = (thr) => {
  if (mcwebSuspends.length < 30) mcwebSuspends.push(new Error().stack);
  mcwebLastSuspend.set(thr, { seq: ++mcwebSuspendSeq, at: performance.now(), stack: new Error().stack });
};
globalThis.mcwebDumpSuspends = () => [...mcwebLastSuspend.values()].sort((a, b) => b.seq - a.seq).map(v =>
  '#' + v.seq + ' @' + (v.at / 1000).toFixed(1) + 's\n' + v.stack.split('\n').slice(2, 40).map(l => l.replace(/\(http[^)]*\/classes\.js/, '(').trim()).join('\n')).join('\n----\n');

// mc-web: zero-delay scheduling for green-thread hand-offs. setTimeout(0) is clamped to >= 4 ms once
// nested, which made every thread hop (unpark, notify, yield) cost a few ms; a MessageChannel isn't clamped.
(() => {
  const q = new Map();
  let nextId = -1;
  const ch = new MessageChannel();
  ch.port1.onmessage = (e) => {
    const id = e.data, fn = q.get(id);
    if (fn) { q.delete(id); fn(); }
  };
  globalThis.mcwebSetTimeout = (fn, ms) => {
    if (!(ms >= 1)) { const id = nextId--; q.set(id, fn); ch.port2.postMessage(id); return id; }
    return setTimeout(fn, ms);
  };
  globalThis.mcwebClearTimeout = (id) => { if (id < 0) q.delete(id); else clearTimeout(id); };
})();

// mc-web: JVM-style class-init locking for TeaVM green threads. A static initializer that suspends left its
// class marked initialized, so other threads used half-built classes. The flag now holds the initializing
// thread until it finishes; other threads suspend here and retry (see postprocess.sh).
// jt/setJt: the Java thread object and TeaVM's setter, so the resumed thread runs as itself (Thread.currentThread())
globalThis.mcwebClinitWait = (flag, t, jt, setJt) => {
  if (flag === true || flag === false || !t || flag === t) return false;
  t.push(99);
  t.suspend((resume) => mcwebSetTimeout(() => { if (setJt) setJt(jt); resume(); }, 1));
  return true;
};
