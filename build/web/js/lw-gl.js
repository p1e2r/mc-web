// lwjgl-web: desktop OpenGL 3.3 core emulated on WebGL2. MIT License.
// Functions take C-style arguments: pointers are numbers into JNI memory, or typed arrays when LWJGL
// called an array overload.
const LW = globalThis.LWJGLWeb;
const P = LW.mem;
let gl = null;

const GLI = (LW.gl = {});
const isArr = (x) => ArrayBuffer.isView(x);

// ---------------------------------------------------------------- object name tables
class Names {
  constructor(kind) { this.kind = kind; this.map = new Map(); this.next = 1; }
  add(obj) { const id = this.next++; this.map.set(id, obj); if (obj && typeof obj === "object") obj.__id = id; return id; }
  get(id) { return id ? this.map.get(id) || null : null; }
  del(id) { const o = this.map.get(id); this.map.delete(id); return o; }
  idOf(obj) { return obj ? obj.__id || 0 : 0; }
}
const T = {
  buffers: new Names("buffer"),
  textures: new Names("texture"),
  framebuffers: new Names("framebuffer"),
  renderbuffers: new Names("renderbuffer"),
  vaos: new Names("vao"),
  programs: new Names("program"), // programs and shaders share a namespace in GL
  samplers: new Names("sampler"),
  queries: new Names("query"),
  syncs: new Map(),
};
T.shaders = T.programs;

// ---------------------------------------------------------------- state we track ourselves
const S = {
  activeUnit: 0,
  boundTex: [], // per unit: {target -> id}
  texInfo: new Map(), // texture id -> {target, levels: [{w,h,ifmt}], ifmt}
  bufInfo: new Map(), // buffer id -> {size, usage, kind, map: {...}}
  boundBuf: {}, // target -> id
  vao: 0,
  vaoState: new Map(), // vao id -> attribs[]
  program: 0,
  unpack: { rowLength: 0, skipRows: 0, skipPixels: 0, alignment: 4 },
  pack: { rowLength: 0, skipRows: 0, skipPixels: 0, alignment: 4 },
  error: 0,
  uniformLocs: new Map(), // program id -> {name->int, list:[WebGLUniformLocation]}
  drawFb: 0,
  readFb: 0,
  textureBuffers: new Map(), // texture id -> {buffer, ifmt}
  shadows: new Map(),        // buffer id -> {u8, ver, lo, hi}: CPU copy of buffers sampled as texture buffers
};
const ATTR0 = () => [];
function attribsOf(vao) {
  let a = S.vaoState.get(vao);
  if (!a) { a = []; S.vaoState.set(vao, a); }
  return a;
}
function setError(e) { if (!S.error) S.error = e; }

// ---------------------------------------------------------------- constants
const E = {
  TEXTURE_2D: 0x0de1, TEXTURE_BUFFER: 0x8c2a, TEXTURE_CUBE_MAP: 0x8513, TEXTURE_2D_ARRAY: 0x8c1a, TEXTURE_3D: 0x806f,
  ARRAY_BUFFER: 0x8892, ELEMENT_ARRAY_BUFFER: 0x8893, UNIFORM_BUFFER: 0x8a11, COPY_READ: 0x8f36, COPY_WRITE: 0x8f37,
  PIXEL_PACK: 0x88eb, PIXEL_UNPACK: 0x88ec, DRAW_INDIRECT: 0x8f3f, TRANSFORM_FEEDBACK_BUFFER: 0x8c8e,
  FRAMEBUFFER: 0x8d40, READ_FRAMEBUFFER: 0x8ca8, DRAW_FRAMEBUFFER: 0x8ca9,
  RGBA: 0x1908, RGB: 0x1907, RED: 0x1903, RG: 0x8227, BGRA: 0x80e1, BGR: 0x80e0, ALPHA: 0x1906, LUMINANCE: 0x1909,
  DEPTH_COMPONENT: 0x1902, DEPTH_STENCIL: 0x84f9, RED_INTEGER: 0x8d94, RG_INTEGER: 0x8228, RGB_INTEGER: 0x8d98, RGBA_INTEGER: 0x8d99,
  UNSIGNED_BYTE: 0x1401, BYTE: 0x1400, UNSIGNED_SHORT: 0x1403, SHORT: 0x1402, UNSIGNED_INT: 0x1405, INT: 0x1404, FLOAT: 0x1406,
  HALF_FLOAT: 0x140b, UNSIGNED_INT_24_8: 0x84fa, UNSIGNED_INT_8_8_8_8: 0x8035, UNSIGNED_INT_8_8_8_8_REV: 0x8367,
  FLOAT_32_UNSIGNED_INT_24_8_REV: 0x8dad, UNSIGNED_INT_2_10_10_10_REV: 0x8368, UNSIGNED_INT_10F_11F_11F_REV: 0x8c3b,
  UNSIGNED_SHORT_5_6_5: 0x8363, UNSIGNED_SHORT_4_4_4_4: 0x8033, UNSIGNED_SHORT_5_5_5_1: 0x8034,
};

// ---------------------------------------------------------------- attach / extensions
let extFloatBlend = null, extColorFloat = null, extAniso = null, extTimer = null, extDebugInfo = null;
GLI.attach = (ctx) => {
  gl = ctx;
  extColorFloat = gl.getExtension("EXT_color_buffer_float");
  gl.getExtension("EXT_color_buffer_half_float");
  extFloatBlend = gl.getExtension("EXT_float_blend");
  gl.getExtension("OES_texture_float_linear");
  extAniso = gl.getExtension("EXT_texture_filter_anisotropic");
  extDebugInfo = gl.getExtension("WEBGL_debug_renderer_info");
  S.boundTex = [];
  for (let i = 0; i < 32; i++) S.boundTex.push({});
  LW.log("WebGL2 context ready:", gl.getParameter(gl.VERSION), extDebugInfo ? gl.getParameter(extDebugInfo.UNMASKED_RENDERER_WEBGL) : "");
};
const EXTENSIONS = ["GL_ARB_texture_filter_anisotropic", "GL_EXT_texture_filter_anisotropic"];
GLI.extensionList = () => EXTENSIONS.filter((e) => !e.includes("anisotropic") || extAniso);

// ---------------------------------------------------------------- helpers for pointer-or-array args
function wI(dst, i, v) { if (isArr(dst)) dst[i] = v; else P.si32(dst + i * 4, v); }
function wF(dst, i, v) { if (isArr(dst)) dst[i] = v; else P.sf32(dst + i * 4, v); }
function wD(dst, i, v) { if (isArr(dst)) dst[i] = v; else P.sf64(dst + i * 8, v); }
function wL(dst, i, v) { if (isArr(dst)) dst[i] = typeof dst[0] === "bigint" ? BigInt(Math.trunc(v)) : v; else P.si64(dst + i * 8, v); }
function rI(src, i) { return isArr(src) ? Number(src[i]) : P.i32(src + i * 4); }
function rU(src, i) { return isArr(src) ? Number(src[i]) >>> 0 : P.u32(src + i * 4); }
function rF(src, i) { return isArr(src) ? src[i] : P.f32(src + i * 4); }
function f32view(src, count) {
  if (isArr(src)) return src instanceof Float32Array ? src.subarray(0, count) : new Float32Array(src.buffer, src.byteOffset, count);
  if (LW.isShared() || src & 3) return new Float32Array(LW.copyBytes(src, count * 4).buffer);
  return new Float32Array(LW.dv().buffer, LW.dv().byteOffset + src, count);
}
function i32view(src, count) {
  if (isArr(src)) return src instanceof Int32Array ? src.subarray(0, count) : new Int32Array(src.buffer, src.byteOffset, count);
  if (LW.isShared() || src & 3) return new Int32Array(LW.copyBytes(src, count * 4).buffer);
  return new Int32Array(LW.dv().buffer, LW.dv().byteOffset + src, count);
}
function u32view(src, count) { const v = i32view(src, count); return new Uint32Array(v.buffer, v.byteOffset, count); }
function bytes(src, n) {
  if (isArr(src)) return new Uint8Array(src.buffer, src.byteOffset, Math.min(n, src.byteLength));
  return LW.viewBytes(src, n);
}
function str(p, len) {
  if (len != null && len >= 0) return new TextDecoder().decode(LW.copyBytes(p, len));
  return LW.cstr(p);
}
function writeStr(s, bufSize, lengthPtr, out) {
  const b = LW.encode(s || "");
  const n = Math.max(0, Math.min(b.length, bufSize - 1));
  if (out && bufSize > 0) {
    if (isArr(out)) { new Uint8Array(out.buffer, out.byteOffset).set(b.subarray(0, n)); new Uint8Array(out.buffer, out.byteOffset)[n] = 0; }
    else { LW.writeBytes(out, b.subarray(0, n)); P.si8(out + n, 0); }
  }
  if (lengthPtr) wI(lengthPtr, 0, n);
}

// ---------------------------------------------------------------- strings / queries
let staticStr = {};
GLI.glGetString = (name) => {
  switch (name) {
    case 0x1f00: return LW.staticCString("lwjgl-web");
    case 0x1f01: return LW.staticCString("WebGL2: " + (extDebugInfo ? gl.getParameter(extDebugInfo.UNMASKED_RENDERER_WEBGL) : gl.getParameter(gl.RENDERER)));
    case 0x1f02: return LW.staticCString("3.3.0 Core Profile lwjgl-web (WebGL2)");
    case 0x8b8c: return LW.staticCString("3.30 lwjgl-web");
    case 0x1f03: return LW.staticCString(GLI.extensionList().join(" "));
  }
  setError(0x500);
  return 0;
};
GLI.glGetStringi = (name, i) => (name === 0x1f03 ? LW.staticCString(GLI.extensionList()[i] || "") : 0);
// gl.getError() is a GPU sync point in WebGL and showed up at ~4% of frame time; only query the driver
// when debugging (LWJGLWeb.config.glErrors = true). Errors raised by this layer itself are always reported.
GLI.glGetError = () => {
  const e = S.error || (LW.config.glErrors ? gl.getError() : 0);
  S.error = 0;
  return e;
};

function getParam(pname) {
  switch (pname) {
    case 0x821b: return 3; // MAJOR_VERSION
    case 0x821c: return 3; // MINOR_VERSION
    case 0x821d: return GLI.extensionList().length; // NUM_EXTENSIONS
    case 0x9126: return 1; // CONTEXT_PROFILE_MASK core
    case 0x821e: return 0; // CONTEXT_FLAGS
    case 0x8b4a: return gl.getParameter(gl.MAX_VERTEX_UNIFORM_COMPONENTS);
    case 0x84ff: return extAniso ? gl.getParameter(extAniso.MAX_TEXTURE_MAX_ANISOTROPY_EXT) : 1; // MAX_TEXTURE_MAX_ANISOTROPY
    case 0x8c2b: return 65536; // MAX_TEXTURE_BUFFER_SIZE (emulated)
    case 0x919f: return 256; // TEXTURE_BUFFER_OFFSET_ALIGNMENT
    case 0x8069: return S.boundTex[S.activeUnit][E.TEXTURE_2D] || 0; // TEXTURE_BINDING_2D
    case 0x84e0: return gl.TEXTURE0 + S.activeUnit; // ACTIVE_TEXTURE
    case 0x8894: return S.boundBuf[E.ARRAY_BUFFER] || 0;
    case 0x8895: return S.vao ? (attribsOf(S.vao).ebo || 0) : 0;
    case 0x85b5: return S.vao; // VERTEX_ARRAY_BINDING
    case 0x8b8d: return S.program; // CURRENT_PROGRAM
    case 0x8ca6: return S.drawFb; // DRAW_FRAMEBUFFER_BINDING
    case 0x8caa: return S.readFb;
    case 0x8ca7: return T.renderbuffers.idOf(gl.getParameter(gl.RENDERBUFFER_BINDING));
    case 0x0cf2: return S.unpack.rowLength;
    case 0x0cf3: return S.unpack.skipRows;
    case 0x0cf4: return S.unpack.skipPixels;
    case 0x0cf5: return S.unpack.alignment;
    case 0x0d05: return S.pack.alignment;
    case 0x8e4f: return 0; // MAX_GEOMETRY... no
    case 0x9122: return 16; // MAX_FRAGMENT_INPUT_COMPONENTS-ish fallback
  }
  let v;
  try {
    v = gl.getParameter(pname);
  } catch (e) {
    v = null;
  }
  if (v === null && gl.getError()) {
    LW.warnOnce("getparam" + pname, "glGet: unsupported pname 0x" + pname.toString(16));
    return 0;
  }
  return v;
}
function putParam(v, dst, w, mode) {
  const vals = v == null ? [0] : typeof v === "object" && "length" in v ? Array.from(v) : [typeof v === "boolean" ? +v : typeof v === "object" ? 1 : v];
  for (let i = 0; i < vals.length; i++) w(dst, i, Number(vals[i]));
}
GLI.glGetIntegerv = (p, dst) => putParam(getParam(p), dst, wI);
GLI.glGetFloatv = (p, dst) => putParam(getParam(p), dst, wF);
GLI.glGetDoublev = (p, dst) => putParam(getParam(p), dst, wD);
GLI.glGetInteger64v = (p, dst) => putParam(getParam(p), dst, wL);
GLI.glGetBooleanv = (p, dst) => putParam(getParam(p), dst, (d, i, v) => (isArr(d) ? (d[i] = v ? 1 : 0) : P.si8(d + i, v ? 1 : 0)));
GLI.glGetIntegeri_v = (p, i, dst) => wI(dst, 0, Number(gl.getIndexedParameter(p, i)) || 0);
GLI.glIsEnabled = (cap) => (IGNORED_CAPS.has(cap) ? 0 : gl.isEnabled(cap) ? 1 : 0);

// ---------------------------------------------------------------- state
const IGNORED_CAPS = new Set([0x0bf2 /*COLOR_LOGIC_OP*/, 0x2a02 /*POLYGON_OFFSET_LINE*/, 0x2a01 /*POLYGON_OFFSET_POINT*/,
  0x92e0 /*DEBUG_OUTPUT*/, 0x8242 /*DEBUG_OUTPUT_SYNCHRONOUS*/, 0x8f9d /*PRIMITIVE_RESTART*/, 0x8642 /*PROGRAM_POINT_SIZE*/,
  0x864f /*DEPTH_CLAMP*/, 0x8db9 /*FRAMEBUFFER_SRGB*/, 0x809d /*MULTISAMPLE*/, 0x884f /*TEXTURE_CUBE_MAP_SEAMLESS*/,
  0x0b20 /*LINE_SMOOTH*/, 0x0b41 /*POLYGON_SMOOTH*/, 0x0b10 /*POINT_SMOOTH*/, 0x3000, 0x3001, 0x3002, 0x3003, 0x3004, 0x3005 /*CLIP_DISTANCEi*/,
  0x0de1 /*TEXTURE_2D (compat)*/, 0x0bc0 /*ALPHA_TEST*/, 0x0b50 /*LIGHTING*/, 0x0b57 /*COLOR_MATERIAL*/, 0x0b60 /*FOG*/,
  0x803a /*RESCALE_NORMAL*/, 0x0ba1 /*NORMALIZE*/, 0x809e, 0x809f, 0x80a0 /*SAMPLE_ALPHA_TO_*/]);
GLI.glEnable = (cap) => { if (!IGNORED_CAPS.has(cap) || cap === 0x809e) gl.enable(cap); };
GLI.glDisable = (cap) => { if (!IGNORED_CAPS.has(cap) || cap === 0x809e) gl.disable(cap); };
GLI.glEnablei = (cap) => GLI.glEnable(cap);
GLI.glDisablei = (cap) => GLI.glDisable(cap);
GLI.glViewport = (x, y, w, h) => gl.viewport(x, y, w, h);
GLI.glScissor = (x, y, w, h) => gl.scissor(x, y, w, h);
GLI.glClearColor = (r, g, b, a) => gl.clearColor(r, g, b, a);
GLI.glClearDepth = (d) => gl.clearDepth(d);
GLI.glClearDepthf = (d) => gl.clearDepth(d);
GLI.glClearStencil = (s) => gl.clearStencil(s);
GLI.glClear = (m) => gl.clear(m & 0x4500);
GLI.glColorMask = (r, g, b, a) => gl.colorMask(!!r, !!g, !!b, !!a);
GLI.glColorMaski = (i, r, g, b, a) => { if (i === 0) gl.colorMask(!!r, !!g, !!b, !!a); };
GLI.glDepthMask = (f) => gl.depthMask(!!f);
GLI.glDepthFunc = (f) => gl.depthFunc(f);
GLI.glDepthRange = (n, f) => gl.depthRange(n, f);
GLI.glDepthRangef = (n, f) => gl.depthRange(n, f);
GLI.glBlendFunc = (s, d) => gl.blendFunc(s, d);
GLI.glBlendFuncSeparate = (a, b, c, d) => gl.blendFuncSeparate(a, b, c, d);
GLI.glBlendFuncSeparatei = (i, a, b, c, d) => gl.blendFuncSeparate(a, b, c, d);
GLI.glBlendEquation = (m) => gl.blendEquation(m);
GLI.glBlendEquationSeparate = (a, b) => gl.blendEquationSeparate(a, b);
GLI.glBlendColor = (r, g, b, a) => gl.blendColor(r, g, b, a);
GLI.glCullFace = (m) => gl.cullFace(m);
GLI.glFrontFace = (m) => gl.frontFace(m);
GLI.glPolygonOffset = (f, u) => gl.polygonOffset(f, u);
GLI.glPolygonMode = () => {};
GLI.glLogicOp = () => {};
GLI.glLineWidth = (w) => gl.lineWidth(Math.max(1, Math.min(w, 1)));
GLI.glPointSize = () => {};
GLI.glStencilFunc = (f, r, m) => gl.stencilFunc(f, r, m);
GLI.glStencilFuncSeparate = (face, f, r, m) => gl.stencilFuncSeparate(face, f, r, m);
GLI.glStencilOp = (a, b, c) => gl.stencilOp(a, b, c);
GLI.glStencilOpSeparate = (face, a, b, c) => gl.stencilOpSeparate(face, a, b, c);
GLI.glStencilMask = (m) => gl.stencilMask(m);
GLI.glStencilMaskSeparate = (f, m) => gl.stencilMaskSeparate(f, m);
GLI.glHint = () => {};
GLI.glFinish = () => gl.finish();
GLI.glFlush = () => gl.flush();
GLI.glClipControl = () => {};
GLI.glProvokingVertex = () => {};
GLI.glPrimitiveRestartIndex = () => {};
GLI.glSampleCoverage = (v, i) => gl.sampleCoverage(v, !!i);

// ---------------------------------------------------------------- buffers
function bufTarget(t) {
  // WebGL has no TEXTURE_BUFFER / DRAW_INDIRECT bindings; use COPY_WRITE for data transfers instead.
  if (t === E.TEXTURE_BUFFER || t === E.DRAW_INDIRECT) return E.COPY_WRITE;
  return t;
}
function bufInfo(id) {
  let b = S.bufInfo.get(id);
  if (!b) { b = { size: 0, usage: 0x88e4, kind: null, map: null }; S.bufInfo.set(id, b); }
  return b;
}
GLI.glGenBuffers = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.buffers.add(null)); };
GLI.glCreateBuffers = GLI.glGenBuffers;
GLI.glDeleteBuffers = (n, ids) => {
  for (let i = 0; i < n; i++) {
    const id = rI(ids, i);
    const info = S.bufInfo.get(id);
    if (info && info.map) LW.free(info.map.ptr);
    const b = T.buffers.del(id);
    if (b) { if (b.data) gl.deleteBuffer(b.data); if (b.index) gl.deleteBuffer(b.index); }
    S.bufInfo.delete(id);
    S.shadows.delete(id);
    for (const k of Object.keys(S.boundBuf)) if (S.boundBuf[k] === id) S.boundBuf[k] = 0;
  }
};
GLI.glIsBuffer = (id) => (T.buffers.map.has(id) ? 1 : 0);
// WebGL forbids using one buffer both as ELEMENT_ARRAY_BUFFER and as any other target, so each GL buffer
// has up to two WebGL twins, kept in sync lazily through a CPU copy when the "other" twin is needed.
function glBufFor(id, target) {
  if (!id) return null;
  let o = T.buffers.get(id);
  if (!o) { o = {}; T.buffers.map.set(id, o); }
  const info = bufInfo(id);
  const index = target === E.ELEMENT_ARRAY_BUFFER;
  const slot = index ? "index" : "data";
  const other = index ? "data" : "index";
  if (!o[slot]) {
    o[slot] = gl.createBuffer();
    o[slot].__id = id;
    if (o[other] && info.size > 0) {
      // copy contents across
      const tmp = new Uint8Array(info.size);
      readBufferData(o[other], other === "index", 0, tmp);
      const t = index ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_WRITE_BUFFER;
      const prev = index ? currentEbo() : gl.getParameter(gl.COPY_WRITE_BUFFER_BINDING);
      gl.bindBuffer(t, o[slot]);
      gl.bufferData(t, tmp, info.usage);
      gl.bindBuffer(t, prev);
    } else if (info.size > 0) {
      const t = index ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_WRITE_BUFFER;
      const prev = index ? currentEbo() : gl.getParameter(gl.COPY_WRITE_BUFFER_BINDING);
      gl.bindBuffer(t, o[slot]);
      gl.bufferData(t, info.size, info.usage);
      gl.bindBuffer(t, prev);
    }
    o.stale = o.stale || {};
    o.stale[slot] = false;
  } else if (o.stale && o.stale[slot]) {
    o.stale[slot] = false;
    const tmp = new Uint8Array(info.size);
    readBufferData(o[other], other === "index", 0, tmp);
    const t = index ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_WRITE_BUFFER;
    const prev = index ? currentEbo() : gl.getParameter(gl.COPY_WRITE_BUFFER_BINDING);
    gl.bindBuffer(t, o[slot]);
    gl.bufferSubData(t, 0, tmp);
    gl.bindBuffer(t, prev);
  }
  return o[slot];
}
// stats, readable from the console: LWJGLWeb.glStats
const GS = LW.glStats = { readbacks: 0, readbackBytes: 0, writeThrough: 0 };
// upload `u8` at `offset` into one specific twin of a buffer (slot "data" or "index"), keeping GL bindings intact
function writeSlot(o, slot, offset, u8) {
  const webglBuf = o[slot];
  if (!webglBuf) return;
  const t = slot === "index" ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_WRITE_BUFFER;
  const prev = slot === "index" ? currentEbo() : gl.getParameter(gl.COPY_WRITE_BUFFER_BINDING);
  if (prev !== webglBuf) gl.bindBuffer(t, webglBuf);
  gl.bufferSubData(t, offset, u8);
  if (prev !== webglBuf) gl.bindBuffer(t, prev);
}
// after the twin for `target` received `u8` at `offset`, give the other twin the same bytes: a cheap upload instead
// of marking it stale and later reading the whole buffer back from the GPU (a pipeline stall)
function writeThrough(id, target, offset, u8) {
  const o = T.buffers.get(id);
  if (!o) return;
  const other = target === E.ELEMENT_ARRAY_BUFFER ? "data" : "index";
  if (!o[other]) return;
  if (o.stale && o.stale[other]) { markWritten(id, target); return; }   // already out of date: stays lazy
  writeSlot(o, other, offset, u8);
  GS.writeThrough++;
}
// CPU shadow of a buffer used as a texture buffer, so the emulation never has to read it back from the GPU.
function shadowOf(id) { return S.shadows.get(id); }
function shadowDirty(sh, lo, hi) { sh.ver++; sh.lo = Math.min(sh.lo, lo); sh.hi = Math.max(sh.hi, hi); }
function shadowWrite(id, offset, u8) {
  const sh = S.shadows.get(id);
  if (!sh) return;
  if (offset + u8.byteLength > sh.u8.byteLength) { const n = new Uint8Array(offset + u8.byteLength); n.set(sh.u8); sh.u8 = n; }
  sh.u8.set(u8, offset);
  shadowDirty(sh, offset, offset + u8.byteLength);
}
function ensureShadow(id) {
  let sh = S.shadows.get(id);
  if (sh) return sh;
  const info = bufInfo(id);
  sh = { u8: new Uint8Array(info.size), ver: 1, lo: 0, hi: info.size };
  const o = T.buffers.get(id);
  if (o && (o.data || o.index) && info.size) readBufferData(o.data || o.index, !o.data, 0, sh.u8);   // once
  S.shadows.set(id, sh);
  return sh;
}
function markWritten(id, target) {
  const o = T.buffers.get(id);
  if (!o) return;
  const slot = target === E.ELEMENT_ARRAY_BUFFER ? "index" : "data";
  const other = slot === "index" ? "data" : "index";
  if (o[other]) { o.stale = o.stale || {}; o.stale[other] = true; }
}
function currentEbo() { return gl.getParameter(gl.ELEMENT_ARRAY_BUFFER_BINDING); }
function readBufferData(webglBuf, isIndex, offset, dst) {
  GS.readbacks++; GS.readbackBytes += dst.byteLength;
  const t = isIndex ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_READ_BUFFER;
  const prev = isIndex ? currentEbo() : gl.getParameter(gl.COPY_READ_BUFFER_BINDING);
  gl.bindBuffer(t, webglBuf);
  gl.getBufferSubData(t, offset, dst);
  gl.bindBuffer(t, prev);
}
GLI.glBindBuffer = (target, id) => {
  const t = bufTarget(target);
  S.boundBuf[target] = id;
  if (target === E.ELEMENT_ARRAY_BUFFER && S.vao) attribsOf(S.vao).ebo = id;
  if (target === E.ELEMENT_ARRAY_BUFFER && !S.vao) S.defaultEbo = id;
  gl.bindBuffer(t, glBufFor(id, target));
};
GLI.glBindBufferBase = (target, index, id) => {
  if (target === E.UNIFORM_BUFFER || target === E.TRANSFORM_FEEDBACK_BUFFER) gl.bindBufferBase(target, index, glBufFor(id, target));
  S.boundBuf[target] = id;
};
GLI.glBindBufferRange = (target, index, id, offset, size) => {
  if (target === E.UNIFORM_BUFFER || target === E.TRANSFORM_FEEDBACK_BUFFER) gl.bindBufferRange(target, index, glBufFor(id, target), offset, size);
  S.boundBuf[target] = id;
};
function boundId(target) { return S.boundBuf[target] || 0; }
GLI.glBufferData = (target, size, data, usage) => {
  const id = boundId(target);
  const t = bufTarget(target);
  if (typeof size !== "number") { // array overload: (target, array, usage)
    usage = data;
    data = size;
    size = data.byteLength;
  }
  const info = bufInfo(id);
  info.size = size;
  info.usage = usage;
  const u8 = data ? bytes(data, size) : null;
  if (u8) gl.bufferData(t, u8, usage);
  else gl.bufferData(t, size, usage);
  const sh = shadowOf(id);
  if (sh) { sh.u8 = new Uint8Array(size); if (u8) sh.u8.set(u8.subarray(0, size)); sh.ver++; sh.lo = 0; sh.hi = size; }
  // Any twin must be resized too.
  const o = T.buffers.get(id);
  if (o) {
    const otherSlot = target === E.ELEMENT_ARRAY_BUFFER ? "data" : "index";
    if (o[otherSlot]) {
      const ot = otherSlot === "index" ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_WRITE_BUFFER;
      const prev = otherSlot === "index" ? currentEbo() : gl.getParameter(gl.COPY_WRITE_BUFFER_BINDING);
      gl.bindBuffer(ot, o[otherSlot]);
      if (u8) gl.bufferData(ot, u8, usage); else gl.bufferData(ot, size, usage);
      gl.bindBuffer(ot, prev);
      o.stale = o.stale || {};
      o.stale[otherSlot] = false;
    }
  }
};
GLI.glBufferStorage = (target, size, data, flags) => GLI.glBufferData(target, size, data, 0x88e8 /*DYNAMIC_DRAW*/);
GLI.glBufferSubData = (target, offset, size, data) => {
  if (typeof size !== "number") { data = size; size = data.byteLength; }
  const id = boundId(target);
  const u8 = bytes(data, size);
  gl.bufferSubData(bufTarget(target), offset, u8);
  writeThrough(id, target, offset, u8);
  shadowWrite(id, offset, u8);
};
GLI.glGetBufferSubData = (target, offset, size, data) => {
  if (typeof size !== "number") { data = size; size = data.byteLength; }
  const tmp = new Uint8Array(size);
  gl.getBufferSubData(bufTarget(target), offset, tmp);
  if (isArr(data)) new Uint8Array(data.buffer, data.byteOffset, size).set(tmp);
  else LW.writeBytes(data, tmp);
};
GLI.glCopyBufferSubData = (rt, wt, ro, wo, size) => {
  const r = boundId(rt), w = boundId(wt);
  const rb = glBufFor(r, E.COPY_READ), wb = glBufFor(w, E.COPY_WRITE);
  gl.bindBuffer(gl.COPY_READ_BUFFER, rb);
  gl.bindBuffer(gl.COPY_WRITE_BUFFER, wb);
  gl.copyBufferSubData(gl.COPY_READ_BUFFER, gl.COPY_WRITE_BUFFER, ro, wo, size);
  // the destination's element-array twin gets the same GPU->GPU copy from the source's element-array twin
  // (created once and then kept current by write-through), instead of a full read-back on its next use
  const wo2 = T.buffers.get(w);
  if (wo2 && wo2.index && !(wo2.stale && wo2.stale.index)) {
    const srcIdx = glBufFor(r, E.ELEMENT_ARRAY_BUFFER);
    gl.bindBuffer(gl.COPY_READ_BUFFER, srcIdx);
    gl.bindBuffer(gl.COPY_WRITE_BUFFER, wo2.index);
    gl.copyBufferSubData(gl.COPY_READ_BUFFER, gl.COPY_WRITE_BUFFER, ro, wo, size);
    GS.copyThrough = (GS.copyThrough || 0) + 1;
  } else markWritten(w, E.COPY_WRITE);
  const dsh = shadowOf(w);
  if (dsh) {
    const ssh = ensureShadow(r);   // the source (usually a staging buffer) gets its own CPU copy once
    shadowWrite(w, wo, ssh.u8.slice(ro, ro + size));
  }
  // restore the real bindings for those targets
  gl.bindBuffer(gl.COPY_READ_BUFFER, glBufFor(boundId(E.COPY_READ), E.COPY_READ));
  gl.bindBuffer(gl.COPY_WRITE_BUFFER, glBufFor(boundId(E.COPY_WRITE), E.COPY_WRITE));
};
// Mapping: hand out JS-heap memory, upload on unmap/flush.
const MAP_READ = 1, MAP_WRITE = 2, MAP_INVALIDATE_RANGE = 4, MAP_INVALIDATE_BUFFER = 8, MAP_FLUSH_EXPLICIT = 0x10, MAP_UNSYNCHRONIZED = 0x20;
function mapRange(id, target, offset, length, access) {
  const info = bufInfo(id);
  if (info.map) { setError(0x502); return 0; }
  const ptr = LW.malloc(Math.max(16, length));
  if (access & MAP_READ) {
    const tmp = new Uint8Array(length);
    readBufferData(glBufFor(id, target), target === E.ELEMENT_ARRAY_BUFFER, offset, tmp);
    LW.writeBytes(ptr, tmp);
  }
  info.map = { ptr, offset, length, access, target };
  return ptr;
}
function unmap(id) {
  const info = bufInfo(id);
  const m = info.map;
  if (!m) return 0;
  if (m.access & MAP_WRITE && !(m.access & MAP_FLUSH_EXPLICIT)) uploadMapped(id, m, 0, m.length);
  LW.free(m.ptr);
  info.map = null;
  return 1;
}
function uploadMapped(id, m, off, len) {
  const t = m.target === E.ELEMENT_ARRAY_BUFFER ? gl.ELEMENT_ARRAY_BUFFER : gl.COPY_WRITE_BUFFER;
  const prev = t === gl.ELEMENT_ARRAY_BUFFER ? currentEbo() : gl.getParameter(gl.COPY_WRITE_BUFFER_BINDING);
  gl.bindBuffer(t, glBufFor(id, m.target));
  const u8 = LW.viewBytes(m.ptr + off, len);   // zero-copy view: bufferSubData copies it right away
  gl.bufferSubData(t, m.offset + off, u8);
  gl.bindBuffer(t, prev);
  writeThrough(id, m.target, m.offset + off, u8);
  shadowWrite(id, m.offset + off, u8);
}
GLI.glMapBufferRange = (target, offset, length, access) => mapRange(boundId(target), target, offset, length, access);
GLI.glMapBuffer = (target, access) => {
  const id = boundId(target);
  const a = access === 0x88b8 ? MAP_READ : access === 0x88b9 ? MAP_WRITE : MAP_READ | MAP_WRITE;
  return mapRange(id, target, 0, bufInfo(id).size, a);
};
GLI.glUnmapBuffer = (target) => unmap(boundId(target));
GLI.glFlushMappedBufferRange = (target, offset, length) => {
  const id = boundId(target), m = bufInfo(id).map;
  if (m) uploadMapped(id, m, offset, length);
};
// DSA variants (only used if the extension were advertised)
GLI.glNamedBufferData = (id, size, data, usage) => { const p = S.boundBuf[E.COPY_WRITE]; GLI.glBindBuffer(E.COPY_WRITE, id); GLI.glBufferData(E.COPY_WRITE, size, data, usage); GLI.glBindBuffer(E.COPY_WRITE, p || 0); };
GLI.glNamedBufferSubData = (id, off, size, data) => { const p = S.boundBuf[E.COPY_WRITE]; GLI.glBindBuffer(E.COPY_WRITE, id); GLI.glBufferSubData(E.COPY_WRITE, off, size, data); GLI.glBindBuffer(E.COPY_WRITE, p || 0); };
GLI.glMapNamedBufferRange = (id, off, len, access) => mapRange(id, E.COPY_WRITE, off, len, access);
GLI.glUnmapNamedBuffer = (id) => unmap(id);
GLI.glFlushMappedNamedBufferRange = (id, off, len) => { const m = bufInfo(id).map; if (m) uploadMapped(id, m, off, len); };

// ---------------------------------------------------------------- vertex arrays
GLI.glGenVertexArrays = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.vaos.add(gl.createVertexArray())); };
GLI.glCreateVertexArrays = GLI.glGenVertexArrays;
GLI.glDeleteVertexArrays = (n, ids) => {
  for (let i = 0; i < n; i++) {
    const id = rI(ids, i);
    const v = T.vaos.del(id);
    if (v) gl.deleteVertexArray(v);
    S.vaoState.delete(id);
    if (S.vao === id) S.vao = 0;
  }
};
GLI.glIsVertexArray = (id) => (T.vaos.map.has(id) ? 1 : 0);
GLI.glBindVertexArray = (id) => {
  S.vao = id;
  gl.bindVertexArray(T.vaos.get(id));
  const ebo = id ? attribsOf(id).ebo : S.defaultEbo;
  S.boundBuf[E.ELEMENT_ARRAY_BUFFER] = ebo || 0;
};
GLI.glEnableVertexAttribArray = (i) => { gl.enableVertexAttribArray(i); const a = attribsOf(S.vao); (a[i] = a[i] || {}).enabled = true; };
GLI.glDisableVertexAttribArray = (i) => { gl.disableVertexAttribArray(i); const a = attribsOf(S.vao); (a[i] = a[i] || {}).enabled = false; };
function typeSize(t) {
  switch (t) {
    case E.BYTE: case E.UNSIGNED_BYTE: return 1;
    case E.SHORT: case E.UNSIGNED_SHORT: case E.HALF_FLOAT: return 2;
    case E.UNSIGNED_INT_2_10_10_10_REV: case 0x8d9f /*INT_2_10_10_10_REV*/: return 1; // packed: size*1 handled below
    default: return 4;
  }
}
function recordAttrib(i, size, type, norm, stride, offset, integer) {
  const a = attribsOf(S.vao);
  const prev = a[i] || {};
  const packed = type === E.UNSIGNED_INT_2_10_10_10_REV || type === 0x8d9f;
  a[i] = Object.assign(prev, {
    buffer: S.boundBuf[E.ARRAY_BUFFER] || 0, size, type, norm: !!norm, offset, integer,
    stride: stride || (packed ? 4 : size * typeSize(type)), rawStride: stride, applied: 0,
  });
}
GLI.glVertexAttribPointer = (i, size, type, norm, stride, offset) => {
  if (size === 0x80e1) size = 4; // GL_BGRA size: not supported, treat as 4
  gl.vertexAttribPointer(i, size, type, !!norm, stride, offset);
  recordAttrib(i, size, type, norm, stride, offset, false);
};
GLI.glVertexAttribIPointer = (i, size, type, stride, offset) => {
  gl.vertexAttribIPointer(i, size, type, stride, offset);
  recordAttrib(i, size, type, false, stride, offset, true);
};
GLI.glVertexAttribDivisor = (i, d) => { gl.vertexAttribDivisor(i, d); const a = attribsOf(S.vao); (a[i] = a[i] || {}).divisor = d; };
GLI.glVertexAttrib4f = (i, x, y, z, w) => gl.vertexAttrib4f(i, x, y, z, w);
GLI.glVertexAttrib1f = (i, x) => gl.vertexAttrib1f(i, x);
GLI.glVertexAttrib2f = (i, x, y) => gl.vertexAttrib2f(i, x, y);
GLI.glVertexAttrib3f = (i, x, y, z) => gl.vertexAttrib3f(i, x, y, z);
GLI.glVertexAttribI4i = (i, x, y, z, w) => gl.vertexAttribI4i(i, x, y, z, w);
GLI.glVertexAttribI4ui = (i, x, y, z, w) => gl.vertexAttribI4ui(i, x, y, z, w);
GLI.glVertexAttrib4fv = (i, v) => gl.vertexAttrib4fv(i, f32view(v, 4));

// ---------------------------------------------------------------- drawing
// WebGL2 has no base-vertex draws, so a base vertex is applied by pointing the VAO's per-vertex attributes `base`
// vertices further into their buffers. Which base is currently applied is remembered per attribute, so a run of draws
// only re-points attributes when the base changes and nothing is "restored" after each draw: a draw without a base
// vertex simply applies base 0 when the VAO is still shifted. (This used to re-point every attribute twice and
// query a binding with getParameter on every chunk-section draw.)
function applyBase(a, base) {
  if (!base && !a.shifted) return;
  let bound = -1;
  for (let i = 0; i < a.length; i++) {
    const at = a[i];
    if (!at || !at.enabled || at.divisor || !at.buffer || (at.applied || 0) === base) continue;
    if (bound !== at.buffer) { gl.bindBuffer(gl.ARRAY_BUFFER, glBufFor(at.buffer, E.ARRAY_BUFFER)); bound = at.buffer; }
    const off = at.offset + base * at.stride, stride = base ? at.stride : at.rawStride;
    if (at.integer) gl.vertexAttribIPointer(i, at.size, at.type, stride, off);
    else gl.vertexAttribPointer(i, at.size, at.type, at.norm, stride, off);
    at.applied = base;
  }
  a.shifted = base !== 0;
  if (bound !== -1) gl.bindBuffer(gl.ARRAY_BUFFER, glBufFor(S.boundBuf[E.ARRAY_BUFFER] || 0, E.ARRAY_BUFFER));
}
function withBaseVertex(base, fn) {
  applyBase(attribsOf(S.vao), base || 0);
  return fn();
}
function prepareDraw() {
  syncTextureBuffers();
  const a = attribsOf(S.vao);
  if (a.shifted) applyBase(a, 0);   // the previous draw on this VAO left a base vertex applied
}
const QUADS = 0x0007;
GLI.glDrawArrays = (mode, first, count) => { prepareDraw(); if (mode === QUADS) return LW.warnOnce("quads", "GL_QUADS is not supported"); gl.drawArrays(mode, first, count); };
GLI.glDrawArraysInstanced = (mode, first, count, inst) => { prepareDraw(); gl.drawArraysInstanced(mode, first, count, inst); };
GLI.glDrawArraysInstancedBaseInstance = (mode, first, count, inst, baseInst) => GLI.glDrawArraysInstanced(mode, first, count, inst);
GLI.glDrawElements = (mode, count, type, offset) => {
  prepareDraw();
  if (isArr(offset)) return LW.warnOnce("clientidx", "client-side index arrays are not supported");
  gl.drawElements(mode, count, type, offset);
};
GLI.glDrawElementsBaseVertex = (mode, count, type, offset, base) => { syncTextureBuffers(); withBaseVertex(base, () => gl.drawElements(mode, count, type, offset)); };
GLI.glDrawElementsInstanced = (mode, count, type, offset, inst) => { prepareDraw(); gl.drawElementsInstanced(mode, count, type, offset, inst); };
GLI.glDrawElementsInstancedBaseVertex = (mode, count, type, offset, inst, base) => { syncTextureBuffers(); withBaseVertex(base, () => gl.drawElementsInstanced(mode, count, type, offset, inst)); };
GLI.glDrawElementsInstancedBaseVertexBaseInstance = (mode, count, type, offset, inst, base) => GLI.glDrawElementsInstancedBaseVertex(mode, count, type, offset, inst, base);
GLI.glDrawRangeElements = (mode, start, end, count, type, offset) => { prepareDraw(); gl.drawRangeElements(mode, start, end, count, type, offset); };
GLI.glDrawRangeElementsBaseVertex = (mode, start, end, count, type, offset, base) => { syncTextureBuffers(); withBaseVertex(base, () => gl.drawElements(mode, count, type, offset)); };
GLI.glMultiDrawArrays = (mode, firsts, counts, n) => { prepareDraw(); for (let i = 0; i < n; i++) gl.drawArrays(mode, rI(firsts, i), rI(counts, i)); };
GLI.glMultiDrawElements = (mode, counts, type, offsets, n) => {
  prepareDraw();
  for (let i = 0; i < n; i++) gl.drawElements(mode, rI(counts, i), type, isArr(offsets) ? Number(offsets[i]) : P.ptr(offsets + i * 8));
};
GLI.glMultiDrawElementsBaseVertex = (mode, counts, type, offsets, n, bases) => {
  syncTextureBuffers();
  for (let i = 0; i < n; i++) {
    const off = isArr(offsets) ? Number(offsets[i]) : P.ptr(offsets + i * 8);
    const c = rI(counts, i);
    withBaseVertex(rI(bases, i), () => gl.drawElements(mode, c, type, off));
  }
};

// ---------------------------------------------------------------- textures
GLI.glGenTextures = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.textures.add(gl.createTexture())); };
GLI.glCreateTextures = (target, n, out) => GLI.glGenTextures(n, out);
GLI.glDeleteTextures = (n, ids) => {
  for (let i = 0; i < n; i++) {
    const id = rI(ids, i);
    const t = T.textures.del(id);
    if (t) gl.deleteTexture(t);
    S.texInfo.delete(id);
    S.textureBuffers.delete(id);
    for (const u of S.boundTex) for (const k in u) if (u[k] === id) u[k] = 0;
  }
};
GLI.glIsTexture = (id) => (T.textures.map.has(id) ? 1 : 0);
GLI.glActiveTexture = (unit) => { S.activeUnit = unit - 0x84c0; gl.activeTexture(unit); };
GLI.glBindTexture = (target, id) => {
  S.boundTex[S.activeUnit][target] = id;
  if (target === E.TEXTURE_BUFFER) {
    // Emulated: a TEXTURE_BUFFER is backed by a 2D texture that is bound to this unit only while a program that
    // samples a buffer texture draws (syncTextureBuffers / restoreTextureBuffers).
    return;
  }
  gl.bindTexture(target, T.textures.get(id));
  if (id) {
    const info = S.texInfo.get(id) || { target, levels: [] };
    info.target = target;
    S.texInfo.set(id, info);
  }
};
function boundTexId(target) { return S.boundTex[S.activeUnit][target] || 0; }
// Map desktop (internalformat, format, type) to a WebGL2-valid triple.
function texFormat(ifmt, fmt, type) {
  let swapRB = false;
  if (fmt === E.BGRA) { fmt = E.RGBA; swapRB = true; }
  if (fmt === E.BGR) { fmt = E.RGB; swapRB = true; }
  if (type === E.UNSIGNED_INT_8_8_8_8_REV) type = E.UNSIGNED_BYTE;
  if (type === E.UNSIGNED_INT_8_8_8_8) { type = E.UNSIGNED_BYTE; LW.warnOnce("8888", "UNSIGNED_INT_8_8_8_8 approximated"); }
  switch (ifmt) {
    case E.RGBA: case 4: ifmt = type === E.FLOAT ? 0x8814 : type === E.HALF_FLOAT ? 0x881a : 0x8058; break; // RGBA32F/RGBA16F/RGBA8
    case E.RGB: case 3: ifmt = type === E.FLOAT ? 0x8815 : type === E.HALF_FLOAT ? 0x881b : 0x8051; break;
    case E.RED: case 1: ifmt = type === E.FLOAT ? 0x822e : type === E.HALF_FLOAT ? 0x822d : 0x8229; break;
    case E.RG: case 2: ifmt = type === E.FLOAT ? 0x8230 : type === E.HALF_FLOAT ? 0x822f : 0x822b; break;
    case 0x8040: case E.LUMINANCE: ifmt = 0x8229; fmt = E.RED; break; // LUMINANCE8 -> R8
    case 0x803c: case E.ALPHA: ifmt = 0x8229; fmt = E.RED; break;
    case 0x8c43: case 0x8c41: ifmt = 0x8c43; break; // SRGB8_ALPHA8
    case 0x8059: ifmt = 0x8058; break; // RGB10_A2? keep RGBA8 fallback
    case E.DEPTH_COMPONENT: ifmt = type === E.FLOAT ? 0x8cac : type === E.UNSIGNED_SHORT ? 0x81a5 : 0x81a6; break;
    case 0x81a7: ifmt = type === E.FLOAT ? 0x8cac : 0x81a6; if (type !== E.FLOAT) type = E.UNSIGNED_INT; break; // DEPTH_COMPONENT32 -> 24
    case 0x81a6: if (type === E.FLOAT) ifmt = 0x8cac; else type = E.UNSIGNED_INT; break;
    case 0x81a5: if (type !== E.UNSIGNED_SHORT && type !== E.UNSIGNED_INT) type = E.UNSIGNED_SHORT; break;
    case 0x8cac: type = E.FLOAT; break;
    case E.DEPTH_STENCIL: ifmt = 0x88f0; type = E.UNSIGNED_INT_24_8; break; // DEPTH24_STENCIL8
    case 0x88f0: type = E.UNSIGNED_INT_24_8; fmt = E.DEPTH_STENCIL; break;
    case 0x8cad: type = E.FLOAT_32_UNSIGNED_INT_24_8_REV; fmt = E.DEPTH_STENCIL; break;
  }
  if (fmt === E.DEPTH_COMPONENT && type === E.UNSIGNED_BYTE) type = E.UNSIGNED_INT;
  return { ifmt, fmt, type, swapRB };
}
function bytesPerPixel(fmt, type) {
  const comps = { [E.RGBA]: 4, [E.RGB]: 3, [E.RED]: 1, [E.RG]: 2, [E.RGBA_INTEGER]: 4, [E.RGB_INTEGER]: 3, [E.RG_INTEGER]: 2,
    [E.RED_INTEGER]: 1, [E.DEPTH_COMPONENT]: 1, [E.DEPTH_STENCIL]: 1, [E.ALPHA]: 1, [E.LUMINANCE]: 1 }[fmt] || 4;
  switch (type) {
    case E.UNSIGNED_BYTE: case E.BYTE: return comps;
    case E.UNSIGNED_SHORT: case E.SHORT: case E.HALF_FLOAT: return comps * 2;
    case E.UNSIGNED_INT_24_8: case E.UNSIGNED_INT_2_10_10_10_REV: case E.UNSIGNED_INT_10F_11F_11F_REV: return 4;
    case E.FLOAT_32_UNSIGNED_INT_24_8_REV: return 8;
    case E.UNSIGNED_SHORT_5_6_5: case E.UNSIGNED_SHORT_4_4_4_4: case E.UNSIGNED_SHORT_5_5_5_1: return 2;
    default: return comps * 4;
  }
}
function typedFor(type, u8) {
  const al = u8.byteOffset;
  switch (type) {
    case E.FLOAT: return al & 3 ? new Float32Array(u8.slice().buffer) : new Float32Array(u8.buffer, al, u8.byteLength >> 2);
    case E.UNSIGNED_INT: case E.UNSIGNED_INT_24_8: case E.UNSIGNED_INT_2_10_10_10_REV: case E.UNSIGNED_INT_10F_11F_11F_REV:
      return al & 3 ? new Uint32Array(u8.slice().buffer) : new Uint32Array(u8.buffer, al, u8.byteLength >> 2);
    case E.INT: return al & 3 ? new Int32Array(u8.slice().buffer) : new Int32Array(u8.buffer, al, u8.byteLength >> 2);
    case E.UNSIGNED_SHORT: case E.HALF_FLOAT: case E.UNSIGNED_SHORT_5_6_5: case E.UNSIGNED_SHORT_4_4_4_4: case E.UNSIGNED_SHORT_5_5_5_1:
      return al & 1 ? new Uint16Array(u8.slice().buffer) : new Uint16Array(u8.buffer, al, u8.byteLength >> 1);
    case E.SHORT: return al & 1 ? new Int16Array(u8.slice().buffer) : new Int16Array(u8.buffer, al, u8.byteLength >> 1);
    case E.BYTE: return new Int8Array(u8.buffer, al, u8.byteLength);
    case E.FLOAT_32_UNSIGNED_INT_24_8_REV: return null;
    default: return u8;
  }
}
// Read pixel data for an upload from client memory, honouring the unpack state, into a tight array.
function readPixelsFromMemory(ptr, w, h, fmt, type, swapRB) {
  const bpp = bytesPerPixel(fmt, type);
  const rowLen = S.unpack.rowLength || w;
  const al = S.unpack.alignment;
  const stride = Math.ceil((rowLen * bpp) / al) * al;
  const start = S.unpack.skipRows * stride + S.unpack.skipPixels * bpp;
  const tight = w * bpp;
  const out = new Uint8Array(tight * h);
  const src = isArr(ptr) ? new Uint8Array(ptr.buffer, ptr.byteOffset, ptr.byteLength) : LW.u8();
  const base = isArr(ptr) ? 0 : ptr;
  for (let y = 0; y < h; y++) out.set(src.subarray(base + start + y * stride, base + start + y * stride + tight), y * tight);
  if (swapRB && bpp >= 3) for (let i = 0; i < out.length; i += bpp) { const t = out[i]; out[i] = out[i + 2]; out[i + 2] = t; }
  return out;
}
function withUnpackDefaults(fn) {
  // We pass tightly packed data, so WebGL's unpack state must be neutral while uploading.
  gl.pixelStorei(gl.UNPACK_ROW_LENGTH, 0);
  gl.pixelStorei(gl.UNPACK_SKIP_ROWS, 0);
  gl.pixelStorei(gl.UNPACK_SKIP_PIXELS, 0);
  gl.pixelStorei(gl.UNPACK_ALIGNMENT, 1);
  try { fn(); } finally {
    gl.pixelStorei(gl.UNPACK_ROW_LENGTH, S.unpack.rowLength);
    gl.pixelStorei(gl.UNPACK_SKIP_ROWS, S.unpack.skipRows);
    gl.pixelStorei(gl.UNPACK_SKIP_PIXELS, S.unpack.skipPixels);
    gl.pixelStorei(gl.UNPACK_ALIGNMENT, S.unpack.alignment);
  }
}
function recordLevel(target, level, w, h, ifmt) {
  const id = boundTexId(target === E.TEXTURE_2D || target === E.TEXTURE_2D_ARRAY || target === E.TEXTURE_3D ? target : E.TEXTURE_CUBE_MAP);
  if (!id) return;
  const info = S.texInfo.get(id) || { target, levels: [] };
  info.levels[level] = { w, h, ifmt };
  S.texInfo.set(id, info);
}
function pboBound() { return !!S.boundBuf[E.PIXEL_UNPACK]; }
// GL_PROXY_TEXTURE_2D: answer "would this fit" without touching WebGL.
const proxyLevels = [];
GLI.glTexImage2D = (target, level, ifmt, w, h, border, fmt, type, pixels) => {
  if (target === 0x8064) {
    const max = gl.getParameter(gl.MAX_TEXTURE_SIZE);
    proxyLevels[level] = w <= max && h <= max ? { w, h, ifmt } : { w: 0, h: 0, ifmt: 0 };
    return;
  }
  const f = texFormat(ifmt, fmt, type);
  recordLevel(target, level, w, h, f.ifmt);
  if (pboBound()) {
    gl.texImage2D(target, level, f.ifmt, w, h, 0, f.fmt, f.type, pixels || 0);
    return;
  }
  if (!pixels || (isArr(pixels) && pixels.length === 0)) {
    gl.texImage2D(target, level, f.ifmt, w, h, 0, f.fmt, f.type, null);
    return;
  }
  const data = readPixelsFromMemory(pixels, w, h, f.fmt, f.type, f.swapRB);
  withUnpackDefaults(() => gl.texImage2D(target, level, f.ifmt, w, h, 0, f.fmt, f.type, typedFor(f.type, data)));
};
GLI.glTexSubImage2D = (target, level, x, y, w, h, fmt, type, pixels) => {
  const id = boundTexId(target === E.TEXTURE_2D ? target : target);
  const info = S.texInfo.get(id);
  const ifmt = info && info.levels[level] ? info.levels[level].ifmt : 0x8058;
  const f = texFormat(ifmt, fmt, type);
  if (pboBound()) { gl.texSubImage2D(target, level, x, y, w, h, f.fmt, f.type, pixels || 0); return; }
  if (!pixels) return;
  const data = readPixelsFromMemory(pixels, w, h, f.fmt, f.type, f.swapRB);
  withUnpackDefaults(() => gl.texSubImage2D(target, level, x, y, w, h, f.fmt, f.type, typedFor(f.type, data)));
};
GLI.glTexImage3D = (target, level, ifmt, w, h, d, border, fmt, type, pixels) => {
  const f = texFormat(ifmt, fmt, type);
  if (!pixels) { gl.texImage3D(target, level, f.ifmt, w, h, d, 0, f.fmt, f.type, null); return; }
  const data = readPixelsFromMemory(pixels, w, h * d, f.fmt, f.type, f.swapRB);
  withUnpackDefaults(() => gl.texImage3D(target, level, f.ifmt, w, h, d, 0, f.fmt, f.type, typedFor(f.type, data)));
};
GLI.glTexSubImage3D = (target, level, x, y, z, w, h, d, fmt, type, pixels) => {
  const f = texFormat(0x8058, fmt, type);
  if (!pixels) return;
  const data = readPixelsFromMemory(pixels, w, h * d, f.fmt, f.type, f.swapRB);
  withUnpackDefaults(() => gl.texSubImage3D(target, level, x, y, z, w, h, d, f.fmt, f.type, typedFor(f.type, data)));
};
GLI.glTexStorage2D = (target, levels, ifmt, w, h) => {
  gl.texStorage2D(target, levels, ifmt, w, h);
  for (let l = 0; l < levels; l++) recordLevel(target, l, Math.max(1, w >> l), Math.max(1, h >> l), ifmt);
};
GLI.glTexStorage3D = (target, levels, ifmt, w, h, d) => gl.texStorage3D(target, levels, ifmt, w, h, d);
GLI.glCopyTexSubImage2D = (t, l, x, y, sx, sy, w, h) => gl.copyTexSubImage2D(t, l, x, y, sx, sy, w, h);
GLI.glCopyTexImage2D = (t, l, ifmt, x, y, w, h) => gl.copyTexImage2D(t, l, texFormat(ifmt, E.RGBA, E.UNSIGNED_BYTE).ifmt, x, y, w, h, 0);
GLI.glGenerateMipmap = (t) => gl.generateMipmap(t);
const IGNORED_TEXPARAMS = new Set([0x8501 /*LOD_BIAS*/, 0x1004 /*BORDER_COLOR*/, 0x8e42, 0x8e43, 0x8e44, 0x8e45, 0x8e46 /*SWIZZLE*/, 0x84fe + 1 /*dummy*/]);
function texParam(target, pname, v, isFloat) {
  if (target === E.TEXTURE_BUFFER) return;
  if (pname === 0x84fe) { if (extAniso) gl.texParameterf(target, pname, v); return; } // MAX_ANISOTROPY
  if (IGNORED_TEXPARAMS.has(pname)) {
    if (pname >= 0x8e42 && pname <= 0x8e46) LW.warnOnce("swizzle", "texture swizzle is not supported in WebGL2");
    return;
  }
  if (pname === 0x2803 || pname === 0x2802 || pname === 0x8072) { if (v === 0x812d /*CLAMP_TO_BORDER*/ || v === 0x2900 /*CLAMP*/) v = 0x812f; }
  if (isFloat) gl.texParameterf(target, pname, v);
  else gl.texParameteri(target, pname, v);
}
GLI.glTexParameteri = (t, p, v) => texParam(t, p, v, false);
GLI.glTexParameterf = (t, p, v) => texParam(t, p, v, true);
GLI.glTexParameteriv = (t, p, v) => texParam(t, p, rI(v, 0), false);
GLI.glTexParameterfv = (t, p, v) => texParam(t, p, rF(v, 0), true);
GLI.glGetTexParameteriv = (t, p, out) => wI(out, 0, Number(gl.getTexParameter(t, p)) || 0);
GLI.glGetTexLevelParameteriv = (target, level, pname, out) => {
  const info = target === 0x8064 ? { levels: proxyLevels } : S.texInfo.get(boundTexId(target));
  const l = info && info.levels[level];
  let v = 0;
  if (l) v = pname === 0x1000 ? l.w : pname === 0x1001 ? l.h : pname === 0x1003 ? l.ifmt : pname === 0x8071 ? 1 : 0;
  wI(out, 0, v);
};
GLI.glGetTexImage = (target, level, fmt, type, pixels) => {
  // Read back through a temporary framebuffer.
  const info = S.texInfo.get(boundTexId(target));
  const l = info && info.levels[level];
  if (!l) return;
  const fb = gl.createFramebuffer();
  const prev = gl.getParameter(gl.READ_FRAMEBUFFER_BINDING);
  gl.bindFramebuffer(gl.READ_FRAMEBUFFER, fb);
  gl.framebufferTexture2D(gl.READ_FRAMEBUFFER, gl.COLOR_ATTACHMENT0, target, T.textures.get(boundTexId(target)), level);
  readPixelsInto(0, 0, l.w, l.h, fmt, type, pixels);
  gl.bindFramebuffer(gl.READ_FRAMEBUFFER, prev);
  gl.deleteFramebuffer(fb);
};
GLI.glPixelStorei = (pname, v) => {
  switch (pname) {
    case 0x0cf2: S.unpack.rowLength = v; break;
    case 0x0cf3: S.unpack.skipRows = v; break;
    case 0x0cf4: S.unpack.skipPixels = v; break;
    case 0x0cf5: S.unpack.alignment = v; break;
    case 0x0d02: S.pack.rowLength = v; break;
    case 0x0d03: S.pack.skipRows = v; break;
    case 0x0d04: S.pack.skipPixels = v; break;
    case 0x0d05: S.pack.alignment = v; break;
    default: return; // SWAP_BYTES, LSB_FIRST, IMAGE_HEIGHT...: ignore
  }
  gl.pixelStorei(pname, v);
};
GLI.glPixelStoref = (p, v) => GLI.glPixelStorei(p, v | 0);
function readPixelsInto(x, y, w, h, fmt, type, pixels) {
  let swap = false;
  if (fmt === E.BGRA) { fmt = E.RGBA; swap = true; }
  if (type === E.UNSIGNED_INT_8_8_8_8_REV) type = E.UNSIGNED_BYTE;
  if (S.boundBuf[E.PIXEL_PACK]) { gl.readPixels(x, y, w, h, fmt, type, pixels || 0); return; }
  const bpp = bytesPerPixel(fmt, type);
  const tmp = new Uint8Array(w * h * bpp);
  gl.pixelStorei(gl.PACK_ROW_LENGTH, 0);
  gl.pixelStorei(gl.PACK_ALIGNMENT, 1);
  gl.readPixels(x, y, w, h, fmt, type, typedFor(type, tmp));
  gl.pixelStorei(gl.PACK_ROW_LENGTH, S.pack.rowLength);
  gl.pixelStorei(gl.PACK_ALIGNMENT, S.pack.alignment);
  if (swap) for (let i = 0; i < tmp.length; i += 4) { const t = tmp[i]; tmp[i] = tmp[i + 2]; tmp[i + 2] = t; }
  const rowLen = S.pack.rowLength || w;
  const stride = Math.ceil((rowLen * bpp) / S.pack.alignment) * S.pack.alignment;
  const dst = isArr(pixels) ? new Uint8Array(pixels.buffer, pixels.byteOffset, pixels.byteLength) : LW.u8();
  const base = isArr(pixels) ? 0 : pixels;
  for (let r = 0; r < h; r++) dst.set(tmp.subarray(r * w * bpp, (r + 1) * w * bpp), base + r * stride);
}
GLI.glReadPixels = (x, y, w, h, fmt, type, pixels) => readPixelsInto(x, y, w, h, fmt, type, pixels);
GLI.glReadBuffer = (m) => gl.readBuffer(m === 0x0404 || m === 0x0405 ? gl.BACK : m);

// Texture buffers (GL_TEXTURE_BUFFER) emulated with a 2D texture, width TB_WIDTH, re-uploaded before draws.
const TB_WIDTH = 4096;
const TBFMT = { 0x8235: [0x8d94, E.INT, 1, 4], 0x8236: [0x8d94, E.UNSIGNED_INT, 1, 4], 0x8232: [0x8d94, E.INT, 1, 1], 0x8231: [0x8d94, E.BYTE, 1, 1],
  0x8233: [0x8d94, E.SHORT, 1, 2], 0x8234: [0x8d94, E.UNSIGNED_SHORT, 1, 2], 0x822e: [E.RED, E.FLOAT, 1, 4], 0x8814: [E.RGBA, E.FLOAT, 4, 4],
  0x8d82: [0x8d99, E.INT, 4, 4], 0x8d70: [0x8d99, E.UNSIGNED_INT, 4, 4], 0x8058: [E.RGBA, E.UNSIGNED_BYTE, 4, 1], 0x8229: [E.RED, E.UNSIGNED_BYTE, 1, 1] };
GLI.glTexBuffer = (target, ifmt, bufferId) => {
  const id = boundTexId(E.TEXTURE_BUFFER);
  if (!id) return;
  let tb = S.textureBuffers.get(id);
  if (!tb) { tb = { tex: gl.createTexture(), w: 0, h: 0 }; S.textureBuffers.set(id, tb); }
  tb.buffer = bufferId;
  tb.ifmt = ifmt;
  tb.dirty = true;
  gl.bindTexture(gl.TEXTURE_2D, tb.tex);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
  const own = S.boundTex[S.activeUnit][E.TEXTURE_2D];
  gl.bindTexture(gl.TEXTURE_2D, own ? T.textures.get(own) : null);
};
// units whose TEXTURE_2D binding was replaced by a texture buffer's backing texture for the current draw
const tbUnits = [];
function restoreTextureBuffers() {
  if (!tbUnits.length) return;
  for (const u of tbUnits) {
    gl.activeTexture(gl.TEXTURE0 + u);
    const id = S.boundTex[u][E.TEXTURE_2D];
    gl.bindTexture(gl.TEXTURE_2D, id ? T.textures.get(id) : null);
  }
  tbUnits.length = 0;
  gl.activeTexture(gl.TEXTURE0 + S.activeUnit);
}
LW.glRestoreTextureBuffers = restoreTextureBuffers;
function syncTextureBuffers() {
  if (!S.textureBuffers.size) return;
  const prog = T.programs.get(S.program);
  if (!prog || !prog.texbuf) return;
  for (let u = 0; u < S.boundTex.length; u++) {
    const id = S.boundTex[u][E.TEXTURE_BUFFER];
    if (!id) continue;
    const tb = S.textureBuffers.get(id);
    if (!tb || !tb.buffer) continue;
    const f = TBFMT[tb.ifmt];
    if (!f) { LW.warnOnce("tbfmt" + tb.ifmt, "unsupported texture buffer format 0x" + tb.ifmt.toString(16)); continue; }
    const sh = ensureShadow(tb.buffer);
    const [fmt, type, comps, size] = f;
    const texel = comps * size, rowBytes = TB_WIDTH * texel;
    const count = Math.floor(sh.u8.byteLength / texel);
    const h = Math.max(1, Math.ceil(count / TB_WIDTH));
    gl.activeTexture(gl.TEXTURE0 + u);
    gl.bindTexture(gl.TEXTURE_2D, tb.tex);
    tbUnits.push(u);
    if (tb.ver === sh.ver && tb.h === h && tb.fmtUp === tb.ifmt && !tb.dirty) continue;   // unchanged: just bind
    // full upload when the size/format changed or another texture buffer consumed the dirty range; else dirty rows
    const full = tb.h !== h || tb.fmtUp !== tb.ifmt || tb.dirty || tb.ver !== sh.baseVer;
    const r0 = full ? 0 : Math.floor(sh.lo / rowBytes), r1 = full ? h : Math.min(h, Math.ceil(sh.hi / rowBytes));
    if (r1 > r0) {
      const raw = new Uint8Array((r1 - r0) * rowBytes);
      const srcEnd = Math.min(sh.u8.byteLength, r1 * rowBytes) - r0 * rowBytes;
      if (srcEnd > 0) raw.set(sh.u8.subarray(r0 * rowBytes, r0 * rowBytes + srcEnd));
      // integer formats narrower than 32 bits are widened (R8I/R16I -> R32I)
      let ifmtWebGL = tb.ifmt, data = typedFor(type, raw), t = type;
      if ((type === E.BYTE || type === E.SHORT || type === E.UNSIGNED_SHORT) && fmt === 0x8d94) {
        const src = type === E.BYTE ? new Int8Array(raw.buffer) : type === E.SHORT ? new Int16Array(raw.buffer) : new Uint16Array(raw.buffer);
        data = new Int32Array(src.length);
        data.set(src);
        ifmtWebGL = 0x8235;
        t = E.INT;
      }
      withUnpackDefaults(() => {
        if (full) gl.texImage2D(gl.TEXTURE_2D, 0, ifmtWebGL, TB_WIDTH, h, 0, fmt, t, data);
        else gl.texSubImage2D(gl.TEXTURE_2D, 0, 0, r0, TB_WIDTH, r1 - r0, fmt, t, data);
      });
      GS.tbUploads = (GS.tbUploads || 0) + 1; GS.tbRows = (GS.tbRows || 0) + (r1 - r0);
    }
    tb.ver = sh.ver; tb.h = h; tb.fmtUp = tb.ifmt; tb.dirty = false;
    sh.baseVer = sh.ver; sh.lo = Infinity; sh.hi = -Infinity;
  }
  gl.activeTexture(gl.TEXTURE0 + S.activeUnit);
}

// ---------------------------------------------------------------- samplers
GLI.glGenSamplers = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.samplers.add(gl.createSampler())); };
GLI.glCreateSamplers = GLI.glGenSamplers;
GLI.glDeleteSamplers = (n, ids) => { for (let i = 0; i < n; i++) { const s = T.samplers.del(rI(ids, i)); if (s) gl.deleteSampler(s); } };
GLI.glBindSampler = (unit, id) => gl.bindSampler(unit, T.samplers.get(id));
function samplerParam(id, p, v, isF) {
  const s = T.samplers.get(id);
  if (!s) return;
  if (p === 0x84fe) { if (extAniso) gl.samplerParameterf(s, p, v); return; }
  if (IGNORED_TEXPARAMS.has(p)) return;
  if ((p === 0x2802 || p === 0x2803 || p === 0x8072) && (v === 0x812d || v === 0x2900)) v = 0x812f;
  if (isF) gl.samplerParameterf(s, p, v);
  else gl.samplerParameteri(s, p, v);
}
GLI.glSamplerParameteri = (id, p, v) => samplerParam(id, p, v, false);
GLI.glSamplerParameterf = (id, p, v) => samplerParam(id, p, v, true);

// ---------------------------------------------------------------- framebuffers / renderbuffers
GLI.glGenFramebuffers = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.framebuffers.add(gl.createFramebuffer())); };
GLI.glCreateFramebuffers = GLI.glGenFramebuffers;
GLI.glDeleteFramebuffers = (n, ids) => {
  for (let i = 0; i < n; i++) {
    const id = rI(ids, i);
    const f = T.framebuffers.del(id);
    if (f) gl.deleteFramebuffer(f);
    if (S.drawFb === id) S.drawFb = 0;
    if (S.readFb === id) S.readFb = 0;
  }
};
GLI.glIsFramebuffer = (id) => (T.framebuffers.map.has(id) ? 1 : 0);
GLI.glBindFramebuffer = (target, id) => {
  if (target === E.FRAMEBUFFER || target === E.DRAW_FRAMEBUFFER) S.drawFb = id;
  if (target === E.FRAMEBUFFER || target === E.READ_FRAMEBUFFER) S.readFb = id;
  gl.bindFramebuffer(target, T.framebuffers.get(id));
};
GLI.glFramebufferTexture2D = (target, att, textarget, tex, level) => gl.framebufferTexture2D(target, att, textarget, T.textures.get(tex), level);
GLI.glFramebufferTexture = (target, att, tex, level) => {
  const info = S.texInfo.get(tex);
  gl.framebufferTexture2D(target, att, info && info.target === E.TEXTURE_CUBE_MAP ? 0x8515 : gl.TEXTURE_2D, T.textures.get(tex), level);
};
GLI.glFramebufferTextureLayer = (target, att, tex, level, layer) => gl.framebufferTextureLayer(target, att, T.textures.get(tex), level, layer);
GLI.glNamedFramebufferTexture = (fb, att, tex, level) => {
  const prev = gl.getParameter(gl.DRAW_FRAMEBUFFER_BINDING);
  gl.bindFramebuffer(gl.DRAW_FRAMEBUFFER, T.framebuffers.get(fb));
  GLI.glFramebufferTexture(gl.DRAW_FRAMEBUFFER, att, tex, level);
  gl.bindFramebuffer(gl.DRAW_FRAMEBUFFER, prev);
};
GLI.glFramebufferRenderbuffer = (target, att, rbt, rb) => gl.framebufferRenderbuffer(target, att, rbt, T.renderbuffers.get(rb));
GLI.glCheckFramebufferStatus = (target) => gl.checkFramebufferStatus(target);
GLI.glGenRenderbuffers = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.renderbuffers.add(gl.createRenderbuffer())); };
GLI.glDeleteRenderbuffers = (n, ids) => { for (let i = 0; i < n; i++) { const r = T.renderbuffers.del(rI(ids, i)); if (r) gl.deleteRenderbuffer(r); } };
GLI.glBindRenderbuffer = (t, id) => gl.bindRenderbuffer(t, T.renderbuffers.get(id));
GLI.glRenderbufferStorage = (t, ifmt, w, h) => {
  const map = { [E.DEPTH_COMPONENT]: 0x81a6, 0x81a7: 0x81a6, [E.RGBA]: 0x8058, [E.RGB]: 0x8051, [E.DEPTH_STENCIL]: 0x88f0 };
  gl.renderbufferStorage(t, map[ifmt] || ifmt, w, h);
};
GLI.glRenderbufferStorageMultisample = (t, s, ifmt, w, h) => gl.renderbufferStorageMultisample(t, s, ifmt, w, h);
GLI.glBlitFramebuffer = (a, b, c, d, e, f, g, h, mask, filter) => gl.blitFramebuffer(a, b, c, d, e, f, g, h, mask, filter);
GLI.glBlitNamedFramebuffer = (src, dst, a, b, c, d, e, f, g, h, mask, filter) => {
  const pr = gl.getParameter(gl.READ_FRAMEBUFFER_BINDING), pd = gl.getParameter(gl.DRAW_FRAMEBUFFER_BINDING);
  gl.bindFramebuffer(gl.READ_FRAMEBUFFER, T.framebuffers.get(src));
  gl.bindFramebuffer(gl.DRAW_FRAMEBUFFER, T.framebuffers.get(dst));
  gl.blitFramebuffer(a, b, c, d, e, f, g, h, mask, filter);
  gl.bindFramebuffer(gl.READ_FRAMEBUFFER, pr);
  gl.bindFramebuffer(gl.DRAW_FRAMEBUFFER, pd);
};
function fixDrawBuffer(b) {
  if (S.drawFb === 0) return b === 0 ? gl.NONE : gl.BACK;
  return b === 0x0404 || b === 0x0405 || b === 0x0408 ? gl.COLOR_ATTACHMENT0 : b;
}
GLI.glDrawBuffer = (b) => gl.drawBuffers([fixDrawBuffer(b)]);
GLI.glDrawBuffers = (n, bufs) => { const a = []; for (let i = 0; i < n; i++) a.push(fixDrawBuffer(rI(bufs, i))); gl.drawBuffers(a); };
GLI.glClearBufferfv = (buffer, drawbuffer, value) => gl.clearBufferfv(buffer, drawbuffer, f32view(value, buffer === 0x1801 ? 1 : 4));
GLI.glClearBufferiv = (buffer, drawbuffer, value) => gl.clearBufferiv(buffer, drawbuffer, i32view(value, buffer === 0x1802 ? 1 : 4));
GLI.glClearBufferuiv = (buffer, drawbuffer, value) => gl.clearBufferuiv(buffer, drawbuffer, u32view(value, 4));
GLI.glClearBufferfi = (buffer, drawbuffer, d, s) => gl.clearBufferfi(buffer, drawbuffer, d, s);
GLI.glInvalidateFramebuffer = (t, n, atts) => { const a = []; for (let i = 0; i < n; i++) a.push(rI(atts, i)); gl.invalidateFramebuffer(t, a); };

// ---------------------------------------------------------------- shaders & programs
GLI.glCreateShader = (type) => T.programs.add({ kind: "shader", type, obj: gl.createShader(type), src: "" });
GLI.glDeleteShader = (id) => { const s = T.programs.get(id); if (s && s.kind === "shader") { gl.deleteShader(s.obj); T.programs.del(id); } };
GLI.glShaderSource = (id, count, strings, lengths) => {
  const s = T.programs.get(id);
  let src = "";
  for (let i = 0; i < count; i++) {
    const p = P.ptr(strings + i * 8);
    const len = lengths ? rI(lengths, i) : -1;
    src += str(p, len >= 0 ? len : null);
  }
  s.src = src;
};
GLI.glCompileShader = (id) => {
  const s = T.programs.get(id);
  const translated = LW.glsl.translate(s.src, s.type);
  s.translated = translated;
  gl.shaderSource(s.obj, translated);
  gl.compileShader(s.obj);
  if (!gl.getShaderParameter(s.obj, gl.COMPILE_STATUS)) {
    console.groupCollapsed("[lwjgl-web] shader compile failed");
    console.log(gl.getShaderInfoLog(s.obj));
    console.log(translated);
    console.groupEnd();
  }
};
GLI.glGetShaderiv = (id, pname, out) => {
  const s = T.programs.get(id);
  let v = 0;
  if (!s) return setError(0x501);
  switch (pname) {
    case 0x8b81: v = gl.getShaderParameter(s.obj, gl.COMPILE_STATUS) ? 1 : 0; break;
    case 0x8b84: v = (gl.getShaderInfoLog(s.obj) || "").length + 1; break; // INFO_LOG_LENGTH
    case 0x8b88: v = s.src.length + 1; break; // SHADER_SOURCE_LENGTH
    case 0x8b4f: v = s.type; break;
    case 0x8b80: v = 0; break; // DELETE_STATUS
  }
  wI(out, 0, v);
};
GLI.glGetShaderInfoLog = (id, bufSize, length, out) => {
  const s = T.programs.get(id);
  writeStr(s ? gl.getShaderInfoLog(s.obj) : "", bufSize, length, out);
};
GLI.glCreateProgram = () => T.programs.add({ kind: "program", obj: gl.createProgram(), attribs: {} });
GLI.glDeleteProgram = (id) => { const p = T.programs.get(id); if (p && p.kind === "program") { gl.deleteProgram(p.obj); T.programs.del(id); S.uniformLocs.delete(id); } };
GLI.glAttachShader = (prog, sh) => {
  const p = T.programs.get(prog), s = T.programs.get(sh);
  if (s.type === 0x8b31) p.vsrc = s.src;
  if (/samplerBuffer/.test(s.src || "")) p.texbuf = true;
  gl.attachShader(p.obj, s.obj);
};
GLI.glDetachShader = (prog, sh) => { const p = T.programs.get(prog), s = T.programs.get(sh); if (p && s) gl.detachShader(p.obj, s.obj); };
GLI.glBindAttribLocation = (prog, idx, name) => gl.bindAttribLocation(T.programs.get(prog).obj, idx, str(name));
GLI.glBindFragDataLocation = () => {};
GLI.glLinkProgram = (id) => {
  const p = T.programs.get(id);
  gl.linkProgram(p.obj);
  S.uniformLocs.delete(id);
  if (!gl.getProgramParameter(p.obj, gl.LINK_STATUS)) console.warn("[lwjgl-web] program link failed:", gl.getProgramInfoLog(p.obj));
};
GLI.glValidateProgram = (id) => gl.validateProgram(T.programs.get(id).obj);
GLI.glUseProgram = (id) => { S.program = id; gl.useProgram(id ? T.programs.get(id).obj : null); };
GLI.glGetProgramiv = (id, pname, out) => {
  const p = T.programs.get(id);
  if (!p) return setError(0x501);
  let v = 0;
  switch (pname) {
    case 0x8b84: v = (gl.getProgramInfoLog(p.obj) || "").length + 1; break;
    case 0x8b87: v = 256; break; // ACTIVE_UNIFORM_MAX_LENGTH
    case 0x8b8a: v = 256; break; // ACTIVE_ATTRIBUTE_MAX_LENGTH
    case 0x8a35: v = 256; break; // ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH
    default: v = gl.getProgramParameter(p.obj, pname); v = typeof v === "boolean" ? +v : Number(v) || 0;
  }
  wI(out, 0, v);
};
GLI.glGetProgramInfoLog = (id, bufSize, length, out) => {
  const p = T.programs.get(id);
  writeStr(p ? gl.getProgramInfoLog(p.obj) : "", bufSize, length, out);
};
GLI.glGetAttribLocation = (prog, name) => gl.getAttribLocation(T.programs.get(prog).obj, str(name));
function locTable(prog) {
  let t = S.uniformLocs.get(prog);
  if (!t) { t = { byName: new Map(), list: [null] }; S.uniformLocs.set(prog, t); }
  return t;
}
GLI.glGetUniformLocation = (prog, namePtr) => {
  const p = T.programs.get(prog);
  if (!p) return -1;
  const name = str(namePtr);
  const t = locTable(prog);
  if (t.byName.has(name)) return t.byName.get(name);
  const loc = gl.getUniformLocation(p.obj, name);
  let id = -1;
  if (loc) { id = t.list.length; t.list.push(loc); }
  t.byName.set(name, id);
  return id;
};
function uloc(loc) {
  if (loc < 0) return null;
  const t = S.uniformLocs.get(S.program);
  return t ? t.list[loc] || null : null;
}
GLI.glUniform1i = (l, a) => gl.uniform1i(uloc(l), a);
GLI.glUniform2i = (l, a, b) => gl.uniform2i(uloc(l), a, b);
GLI.glUniform3i = (l, a, b, c) => gl.uniform3i(uloc(l), a, b, c);
GLI.glUniform4i = (l, a, b, c, d) => gl.uniform4i(uloc(l), a, b, c, d);
GLI.glUniform1ui = (l, a) => gl.uniform1ui(uloc(l), a);
GLI.glUniform1f = (l, a) => gl.uniform1f(uloc(l), a);
GLI.glUniform2f = (l, a, b) => gl.uniform2f(uloc(l), a, b);
GLI.glUniform3f = (l, a, b, c) => gl.uniform3f(uloc(l), a, b, c);
GLI.glUniform4f = (l, a, b, c, d) => gl.uniform4f(uloc(l), a, b, c, d);
for (const n of [1, 2, 3, 4]) {
  GLI[`glUniform${n}fv`] = (l, count, v) => { if (typeof count !== "number") { v = count; count = v.length / n; } gl[`uniform${n}fv`](uloc(l), f32view(v, count * n)); };
  GLI[`glUniform${n}iv`] = (l, count, v) => { if (typeof count !== "number") { v = count; count = v.length / n; } gl[`uniform${n}iv`](uloc(l), i32view(v, count * n)); };
  GLI[`glUniform${n}uiv`] = (l, count, v) => { if (typeof count !== "number") { v = count; count = v.length / n; } gl[`uniform${n}uiv`](uloc(l), u32view(v, count * n)); };
}
for (const [n, sz] of [["2", 4], ["3", 9], ["4", 16], ["2x3", 6], ["3x2", 6], ["2x4", 8], ["4x2", 8], ["3x4", 12], ["4x3", 12]]) {
  GLI[`glUniformMatrix${n}fv`] = (l, count, transpose, v) => {
    if (typeof count !== "number") { v = transpose; transpose = count; count = v.length / sz; }
    let data = f32view(v, count * sz);
    if (transpose) { data = transposeMats(data, n, count); }
    gl[`uniformMatrix${n}fv`](uloc(l), false, data);
  };
}
function transposeMats(data, n, count) {
  const [c, r] = n.includes("x") ? n.split("x").map(Number) : [Number(n), Number(n)];
  const out = new Float32Array(data.length);
  for (let k = 0; k < count; k++) for (let i = 0; i < c; i++) for (let j = 0; j < r; j++) out[k * c * r + j * c + i] = data[k * c * r + i * r + j];
  return out;
}
GLI.glGetUniformBlockIndex = (prog, name) => gl.getUniformBlockIndex(T.programs.get(prog).obj, str(name)) >>> 0;
GLI.glUniformBlockBinding = (prog, idx, binding) => gl.uniformBlockBinding(T.programs.get(prog).obj, idx, binding);
GLI.glGetActiveUniformBlockName = (prog, idx, bufSize, length, out) =>
  writeStr(gl.getActiveUniformBlockName(T.programs.get(prog).obj, idx), bufSize, length, out);
GLI.glGetActiveUniformBlockiv = (prog, idx, pname, out) => {
  const po = T.programs.get(prog).obj;
  if (pname === 0x8a41) { // UNIFORM_BLOCK_NAME_LENGTH (not in WebGL)
    const n = gl.getActiveUniformBlockName(po, idx);
    return wI(out, 0, n ? n.length + 1 : 0);
  }
  const v = gl.getActiveUniformBlockParameter(po, idx, pname);
  putParam(v, out, wI);
};
GLI.glGetActiveUniform = (prog, idx, bufSize, length, size, type, name) => {
  const info = gl.getActiveUniform(T.programs.get(prog).obj, idx);
  if (!info) return;
  if (size) wI(size, 0, info.size);
  if (type) wI(type, 0, info.type);
  writeStr(info.name, bufSize, length, name);
};
GLI.glGetActiveAttrib = (prog, idx, bufSize, length, size, type, name) => {
  const info = gl.getActiveAttrib(T.programs.get(prog).obj, idx);
  if (!info) return;
  if (size) wI(size, 0, info.size);
  if (type) wI(type, 0, info.type);
  writeStr(info.name, bufSize, length, name);
};

// ---------------------------------------------------------------- queries / sync / debug
GLI.glGenQueries = (n, out) => { for (let i = 0; i < n; i++) wI(out, i, T.queries.add({})); };
GLI.glDeleteQueries = (n, ids) => { for (let i = 0; i < n; i++) T.queries.del(rI(ids, i)); };
GLI.glBeginQuery = () => {};
GLI.glEndQuery = () => {};
GLI.glQueryCounter = () => {};
GLI.glGetQueryObjectiv = (id, pname, out) => wI(out, 0, pname === 0x8867 /*RESULT_AVAILABLE*/ ? 1 : 0);
GLI.glGetQueryObjectuiv = GLI.glGetQueryObjectiv;
GLI.glGetQueryObjecti64v = (id, pname, out) => wL(out, 0, pname === 0x8867 ? 1 : 0);
GLI.glGetQueryObjectui64v = GLI.glGetQueryObjecti64v;
let nextSync = 0x60000010;
GLI.glFenceSync = () => { const id = (nextSync += 16); T.syncs.set(id, true); return id; };
GLI.glDeleteSync = (id) => T.syncs.delete(id);
GLI.glClientWaitSync = () => 0x911a; // ALREADY_SIGNALED: our readbacks are synchronous anyway
GLI.glWaitSync = () => {};
GLI.glIsSync = (id) => (T.syncs.has(id) ? 1 : 0);
GLI.glGetSynciv = (sync, pname, bufSize, length, values) => { if (values) wI(values, 0, pname === 0x9114 ? 0x9119 : 0); if (length) wI(length, 0, 1); };
for (const n of ["glDebugMessageCallback", "glDebugMessageCallbackARB", "glDebugMessageControl", "glDebugMessageControlARB",
  "glObjectLabel", "glLabelObjectEXT", "glPushDebugGroup", "glPopDebugGroup", "glDebugMessageInsert", "glPushGroupMarkerEXT", "glPopGroupMarkerEXT"]) GLI[n] = () => {};
GLI.glGetGraphicsResetStatus = () => 0;

GLI.endFrame = () => {};

// ---------------------------------------------------------------- GL symbols for createCapabilities
// GL.createCapabilities resolves every function through glXGetProcAddress; we return a fake address
// for every name (so LWJGL treats all core functions as present) and dispatch by name.
LW.ffi.glXGetProcAddress = (name) => LW.symbol(LW.cstr(name));
LW.ffi.glXGetProcAddressARB = LW.ffi.glXGetProcAddress;
LW.ffi.glXGetCurrentContext = () => 0x40000010;
LW.ffi.glXGetCurrentDrawable = () => 0x40000010;
LW.ffi.glXGetCurrentDisplay = () => 0x40000020;

// ---------------------------------------------------------------- draw error diagnostics (mc-web)
// For the first draws, check gl.getError() after each call and describe the failing draw once per program.
(() => {
  let checks = 4000;
  const seen = new Set();
  const SAMPLERS = { 0x8b5e: "sampler2D", 0x8b62: "sampler2DShadow", 0x8dc1: "sampler2DArray", 0x8b60: "samplerCube", 0x8dca: "isampler2D", 0x8dd2: "usampler2D", 0x8b5f: "sampler3D" };
  function describe(name, err) {
    const p = T.programs.get(S.program);
    if (!p || seen.has(S.program)) return;
    seen.add(S.program);
    const out = [];
    const n = gl.getProgramParameter(p.obj, gl.ACTIVE_UNIFORMS);
    for (let i = 0; i < n; i++) {
      const u = gl.getActiveUniform(p.obj, i);
      if (!SAMPLERS[u.type]) continue;
      const unit = gl.getUniform(p.obj, gl.getUniformLocation(p.obj, u.name));
      const b = S.boundTex[unit] || {};
      const desc = Object.keys(b).filter(t => b[t]).map(t => {
        const info = S.texInfo.get(b[t]);
        const l0 = info && info.levels[0];
        return "0x" + (+t).toString(16) + "#" + b[t] + (l0 ? " ifmt=0x" + l0.ifmt.toString(16) + " " + l0.w + "x" + l0.h : "") + (S.textureBuffers.has(b[t]) ? " (texbuffer)" : "");
      }).join(", ");
      out.push(u.name + ":" + SAMPLERS[u.type] + " unit " + unit + " -> " + (desc || "nothing bound"));
    }
    const vs = (p.vsrc || "").split("\n").filter(l => /uniform|^in |^out /.test(l)).slice(0, 12).join(" | ");
    console.warn("[lwjgl-web] " + name + " failed with GL error 0x" + err.toString(16) + " in program " + S.program + ": " + out.join("; ") + " || " + vs);
  }
  for (const k of ["glDrawArrays", "glDrawArraysInstanced", "glDrawElements", "glDrawElementsBaseVertex", "glDrawElementsInstanced",
                   "glDrawElementsInstancedBaseVertex", "glDrawRangeElements", "glDrawRangeElementsBaseVertex"]) {
    const f = GLI[k];
    GLI[k] = (...a) => {
      try { f(...a); } finally { restoreTextureBuffers(); }
      if (checks > 0) { checks--; const e = gl.getError(); if (e) describe(k, e); }
    };
  }
})();
