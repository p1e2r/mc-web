// mc-web: persistent game files (worlds, options) in IndexedDB. MIT License.
// Java (mcweb.rt.Persist) restores everything at boot and pushes changed files here every few seconds.
const LW = globalThis.LWJGLWeb;
let dbp = null;
function db() {
  if (!dbp) {
    dbp = new Promise((resolve, reject) => {
      const r = indexedDB.open("mcweb", 1);
      r.onupgradeneeded = () => r.result.createObjectStore("files");
      r.onsuccess = () => resolve(r.result);
      r.onerror = () => reject(r.error);
    });
  }
  return dbp;
}
function store(mode) {
  return db().then((d) => d.transaction("files", mode).objectStore("files"));
}
const done = (req) => new Promise((resolve, reject) => { req.onsuccess = () => resolve(req.result); req.onerror = () => reject(req.error); });

LW.idbLoaded = [];
LW.idbLoadAll = async (prefix) => {
  const s = await store("readonly");
  const range = prefix ? IDBKeyRange.bound(prefix, prefix + "\uffff") : undefined;
  const keys = await done(s.getAllKeys(range));
  const vals = await done(s.getAll(range));
  LW.idbLoaded = keys.map((k, i) => [k, vals[i]]);
  return LW.idbLoaded.length;
};
LW.idbKey = (i) => LW.idbLoaded[i][0];
LW.idbSize = (i) => LW.idbLoaded[i][1].length;
LW.idbTake = (i, dst) => { new Uint8Array(dst.buffer, dst.byteOffset, dst.length).set(LW.idbLoaded[i][1]); LW.idbLoaded[i][1] = null; };
LW.idbDone = () => { LW.idbLoaded = []; };

let pendingWrites = 0;
const idleWaiters = [];
const checkIdle = () => { if (pendingWrites === 0) while (idleWaiters.length) idleWaiters.shift()(); };
LW.idbWaitIdle = (cb) => { idleWaiters.push(cb); checkIdle(); };
LW.idbPut = (path, bytes) => {
  pendingWrites++;
  store("readwrite").then((s) => done(s.put(bytes, path))).catch((e) => console.warn("[mc-web] could not save " + path, e))
    .finally(() => { pendingWrites--; checkIdle(); });
};
LW.idbDelete = (path) => {
  store("readwrite").then((s) => done(s.delete(path))).catch(() => {});
};
// warn before closing the tab while a save is still being written
addEventListener("beforeunload", (e) => { if (pendingWrites > 0) { e.preventDefault(); e.returnValue = ""; } });
