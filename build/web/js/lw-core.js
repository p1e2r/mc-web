// lwjgl-web core runtime: memory access, symbol registry, FFI dispatch, JNI native table builder.
// Loaded as a classic module before cheerpjInit; everything hangs off globalThis.LWJGLWeb.
// MIT License.

const LW = (globalThis.LWJGLWeb = globalThis.LWJGLWeb || {});

LW.config = Object.assign(
  {
    arenaMB: 96,          // JS-side heap carved out of Java native memory at boot
    longAsBigInt: false,  // CheerpJ expects `long` returns as plain numbers
    logMissing: true,     // log each unimplemented native/FFI function once
    traceFFI: false,      // log every FFI call (very slow)
    traceGL: false,       // log every GL call (very slow)
    pixelRatio: 1,        // canvas resolution multiplier (1 = CSS pixels)
  },
  LW.config || {}
);

const log = (LW.log = (...a) => console.log("[lwjgl-web]", ...a));
const warn = (LW.warn = (...a) => console.warn("[lwjgl-web]", ...a));
const warnedOnce = new Set();
LW.warnOnce = (key, ...a) => {
  if (warnedOnce.has(key)) return;
  warnedOnce.add(key);
  warn(...a);
};

// ---------------------------------------------------------------- memory
// TeaVM build: native memory is LWJGLWeb.H (lw-heap.js); its views track the resizable buffer.
LW.lib = null;
LW.setLib = () => {};
LW.dv = () => LW.H.dv;
LW.refreshMemory = () => {};
LW.u8 = () => LW.H.u8;
LW.isShared = () => false;

const P = (LW.mem = {
  i8: (p) => LW.dv().getInt8(p),
  u8: (p) => LW.dv().getUint8(p),
  i16: (p) => LW.dv().getInt16(p, true),
  u16: (p) => LW.dv().getUint16(p, true),
  i32: (p) => LW.dv().getInt32(p, true),
  u32: (p) => LW.dv().getUint32(p, true),
  f32: (p) => LW.dv().getFloat32(p, true),
  f64: (p) => LW.dv().getFloat64(p, true),
  i64: (p) => Number(LW.dv().getBigInt64(p, true)),
  ptr: (p) => Number(LW.dv().getBigUint64(p, true)),
  si8: (p, v) => LW.dv().setInt8(p, v),
  si16: (p, v) => LW.dv().setInt16(p, v, true),
  si32: (p, v) => LW.dv().setInt32(p, v | 0, true),
  su32: (p, v) => LW.dv().setUint32(p, v >>> 0, true),
  sf32: (p, v) => LW.dv().setFloat32(p, v, true),
  sf64: (p, v) => LW.dv().setFloat64(p, v, true),
  si64: (p, v) => LW.dv().setBigInt64(p, BigInt(Math.trunc(v)), true),
  sptr: (p, v) => LW.dv().setBigUint64(p, BigInt(Math.trunc(v)), true),
});
LW.POINTER_SIZE = 8;

// Non-shared copy of a memory range (safe to hand to WebGL / Blob / TextDecoder).
LW.copyBytes = (p, n) => LW.u8().slice(p, p + n);
// Zero-copy view when possible (not shared memory), else a copy.
LW.viewBytes = (p, n) => (LW.isShared() ? LW.copyBytes(p, n) : new Uint8Array(LW.dv().buffer, LW.dv().byteOffset + p, n));
LW.writeBytes = (p, bytes) => LW.u8().set(bytes, p);

const td = new TextDecoder("utf-8");
const te = new TextEncoder();
LW.cstr = (p, max) => {
  if (!p) return null;
  const m = LW.u8();
  let e = p;
  const lim = max != null ? p + max : m.length;
  while (e < lim && m[e] !== 0) e++;
  return td.decode(m.slice(p, e));
};
LW.encode = (s) => te.encode(s);

// Values handed to us may be typed arrays (Java array overloads) or pointers.
LW.isArr = (x) => ArrayBuffer.isView(x);
LW.num = (x) => (typeof x === "bigint" ? Number(x) : x);

// ---------------------------------------------------------------- heap (lw-heap.js)
LW.heapInit = () => {};
LW.malloc = (n) => LW.heap.malloc(n);
LW.calloc = (n) => LW.heap.calloc(n, 1);
LW.free = (p) => LW.heap.free(p);
LW.heapOwns = (p) => LW.heap.owns(p);
LW.blockSize = (p) => LW.heap.blockSize(p);
LW.realloc = (p, n) => LW.heap.realloc(p, n);
// Strings that live forever (glGetString results etc.)
const staticStrings = new Map();
LW.staticCString = (s) => {
  let p = staticStrings.get(s);
  if (p === undefined) {
    const b = te.encode(s);
    p = LW.malloc(b.length + 1);
    LW.writeBytes(p, b);
    LW.u8()[p + b.length] = 0;
    staticStrings.set(s, p);
  }
  return p;
};
LW.newCString = (s) => {
  const b = te.encode(s);
  const p = LW.malloc(b.length + 1);
  LW.writeBytes(p, b);
  LW.u8()[p + b.length] = 0;
  return p;
};

// ---------------------------------------------------------------- symbols & FFI
// Every C function the Java side asks for gets a fake address; calls come back through WebFFI.call.
const SYM_BASE = 0x20000000;
const symByName = new Map();
const symById = new Map();
LW.ffi = {}; // name -> function(...numberArgs) -> number | Promise<number>
LW.symbol = (name) => {
  let id = symByName.get(name);
  if (id === undefined) {
    id = SYM_BASE + symByName.size * 16;
    symByName.set(name, id);
    symById.set(id, name);
  }
  return id;
};
LW.symbolName = (id) => symById.get(id);
LW.resolveFFI = (name) => {
  if (LW.ffi[name]) return LW.ffi[name];
  if (LW.gl && LW.gl[name]) return LW.gl[name];
  return null;
};

// The upcall table (Java callbacks) lives in Java; ids are >= 0x10000000 and < 0x20000000.
LW.isUpcall = (id) => id >= 0x10000000 && id < 0x20000000;

// Call a Java callback with libffi-style arguments.
// types: string of chars per argument: p=pointer/long, i=int32, f=float, d=double
LW.invokeCallback = (id, types, args) => {
  if (!id) return;
  const n = types.length;
  const block = LW.malloc(16 + n * 8 + n * 8);
  const argv = block + 16;
  const vals = argv + n * 8;
  for (let i = 0; i < n; i++) {
    const vp = vals + i * 8;
    P.sptr(argv + i * 8, vp);
    const t = types[i];
    const v = args[i];
    if (t === "p") P.sptr(vp, v);
    else if (t === "i") P.si32(vp, v);
    else if (t === "f") P.sf32(vp, v);
    else if (t === "d") P.sf64(vp, v);
  }
  if (LW.deferUpcalls) {
    // run later from Java (WebEvents.drain), where green threads may suspend
    LW.pendingUpcalls.push(id, block, argv);
    return;
  }
  try {
    LW.upcallFn(id, block, argv);
  } catch (e) {
    warn("callback failed", e);
  } finally {
    LW.free(block);
  }
};
LW.deferUpcalls = false;
LW.pendingUpcalls = [];
LW.takeUpcall = (out) => {
  if (LW.pendingUpcalls.length === 0) return false;
  out[0] = LW.pendingUpcalls.shift(); out[1] = LW.pendingUpcalls.shift(); out[2] = LW.pendingUpcalls.shift();
  return true;
};

// ---------------------------------------------------------------- JNI native table builder
// Generated module files call LW.buildNatives([[class, method, descriptor], ...]).
function mangle(s) {
  let r = "";
  for (const ch of s) {
    if (ch === "/") r += "_";
    else if (ch === "_") r += "_1";
    else if (ch === ";") r += "_2";
    else if (ch === "[") r += "_3";
    else if (/[A-Za-z0-9]/.test(ch)) r += ch;
    else r += "_0" + ch.charCodeAt(0).toString(16).padStart(4, "0");
  }
  return r;
}
LW.natives = {}; // "SimpleClass.method" or "method" -> impl
const missingNatives = new Set();

function retConv(desc) {
  const r = desc.slice(desc.indexOf(")") + 1);
  if (r === "J") return LW.config.longAsBigInt ? (v) => BigInt(Math.trunc(v || 0)) : (v) => v || 0;
  if (r === "Z") return (v) => !!v;
  if (r === "V") return () => undefined;
  if (r === "F" || r === "D") return (v) => (v === undefined ? 0 : v);
  if (r.startsWith("L") || r.startsWith("[")) return (v) => (v === undefined ? null : v);
  return (v) => (v === undefined ? 0 : v | 0);
}

function findImpl(cls, name) {
  const simple = cls.slice(cls.lastIndexOf("/") + 1);
  const pkg = cls.slice(0, cls.lastIndexOf("/"));
  const N = LW.natives;
  if (N[simple + "." + name]) return N[simple + "." + name];
  if (pkg === "org/lwjgl/opengl") {
    const fn = name.startsWith("ngl") ? name.slice(1) : name;
    if (LW.gl && LW.gl[fn]) return LW.gl[fn];
    return null;
  }
  if (N[name]) return N[name];
  if (name[0] === "n" && N[name.slice(1)]) return N[name.slice(1)];
  return null;
}

LW.buildNatives = (table) => {
  const obj = {};
  for (const [cls, name, desc] of table) {
    const conv = retConv(desc);
    const label = cls.slice(cls.lastIndexOf("/") + 1) + "." + name;
    let impl = null;
    let resolved = false;
    const fn = function (lib, ...args) {
      LW.setLib(lib);
      if (!resolved) {
        impl = findImpl(cls, name);
        resolved = true;
      }
      for (let i = 0; i < args.length; i++) if (typeof args[i] === "bigint") args[i] = Number(args[i]);
      if (LW.config.traceGL && cls.startsWith("org/lwjgl/opengl")) log(label, args);
      if (!impl) {
        if (LW.config.logMissing && !missingNatives.has(label)) {
          missingNatives.add(label);
          warn("unimplemented native", label, desc);
        }
        return conv(0);
      }
      let r;
      try {
        r = impl(...args);
      } catch (e) {
        if (e instanceof RangeError) {
          // wasm memory grew since the cached view was taken: refresh and retry once
          LW.refreshMemory();
          r = impl(...args);
        } else {
          console.error("[lwjgl-web] native threw", label, e);
          throw e;
        }
      }
      if (r instanceof Promise) { LW.warnOnce("asyncn" + label, "async native called synchronously:", label); return conv(0); }
      return conv(r);
    };
    const shortRaw = "Java_" + cls.replace(/\//g, "_") + "_" + name;
    const shortMangled = "Java_" + mangle(cls) + "_" + mangle(name);
    const args = desc.slice(1, desc.indexOf(")"));
    obj[shortRaw] = fn;
    obj[shortMangled] = fn;
    obj[shortMangled + "__" + mangle(args)] = fn;
  }
  return new Proxy(obj, {
    get(t, k) {
      if (k in t) return t[k];
      if (typeof k === "string" && k.startsWith("Java_")) {
        LW.warnOnce("proxy" + k, "native requested but not generated:", k);
      }
      return undefined;
    },
  });
};

// ---------------------------------------------------------------- WebFFI natives (lwjglweb.js)
LW.webffi = {
  nsym(name) {
    const id = LW.symbol(name);
    if (!LW.resolveFFI(name) && LW.config.logMissing) LW.warnOnce("sym" + name, "symbol without implementation:", name);
    return id;
  },
  call(fn, sig, argsArr) {
    const name = LW.symbolName(fn);
    const args = Array.from(argsArr);
    if (LW.config.traceFFI) log("ffi", name, args);
    let f = name ? LW.resolveFFI(name) : null;
    if (!f) {
      if (LW.isUpcall(fn)) {
        LW.warnOnce("callupcall", "native code calling a Java callback directly is not supported", fn);
        return 0;
      }
      LW.warnOnce("ffi" + (name || fn), "unimplemented FFI function", name || "0x" + fn.toString(16), sig);
      return 0;
    }
    const r = f(...args);
    if (r instanceof Promise) { LW.warnOnce("async" + name, "async FFI function called synchronously:", name); return 0; }
    return r === undefined ? 0 : Number(r);
  },
  async init(info) {
    log("boot:", info);
    const WB = await LW.lib.org.lwjgl.web.WebBridge;
    const size = LW.config.arenaMB * 1048576;
    const base = await WB.malloc(size);
    if (!base) throw new Error("[lwjgl-web] could not allocate JS heap from Java");
    LW.heapInit(Number(base), size);
    if (LW.onInit) await LW.onInit();
  },
  // Self test: Java wrote 0x12345678 at p via Unsafe; JS checks it and writes back.
  selftest(p) {
    const v = P.i32(p);
    P.si32(p + 4, 0x0badcafe);
    log(`self-test: read 0x${(v >>> 0).toString(16)} at 0x${p.toString(16)} (expect 0x12345678)`);
    return v;
  },
};
LW.ffi.lwjglweb_selftest = (p) => LW.webffi.selftest(p);
