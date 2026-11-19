// lwjgl-web: core system natives (memory access, libc, libffi), STB image, and stubs for
// FreeType / OpenAL / tinyfd / shaderc / spvc. MIT License.
const LW = globalThis.LWJGLWeb;
const P = LW.mem;
const N = LW.natives;

// ---------------------------------------------------------------- WebFFI (lwjglweb.js)
N["WebFFI.nsym"] = (name) => LW.webffi.nsym(name);
N["WebFFI.call"] = (fn, sig, args) => LW.webffi.call(fn, sig, args);
N["WebFFI.init"] = (info) => LW.webffi.init(info);

// ---------------------------------------------------------------- MemoryAccessJNI (fallback when Unsafe is unavailable)
N["MemoryAccessJNI.getPointerSize"] = () => LW.POINTER_SIZE;
for (const n of ["malloc", "calloc", "realloc", "free", "aligned_alloc", "aligned_free"]) N["MemoryAccessJNI." + n] = () => LW.symbol(n);
N["MemoryAccessJNI.ngetByte"] = (p) => P.i8(p);
N["MemoryAccessJNI.ngetShort"] = (p) => P.i16(p);
N["MemoryAccessJNI.ngetInt"] = (p) => P.i32(p);
N["MemoryAccessJNI.ngetLong"] = (p) => P.i64(p);
N["MemoryAccessJNI.ngetFloat"] = (p) => P.f32(p);
N["MemoryAccessJNI.ngetDouble"] = (p) => P.f64(p);
N["MemoryAccessJNI.ngetAddress"] = (p) => P.ptr(p);
N["MemoryAccessJNI.nputByte"] = (p, v) => P.si8(p, v);
N["MemoryAccessJNI.nputShort"] = (p, v) => P.si16(p, v);
N["MemoryAccessJNI.nputInt"] = (p, v) => P.si32(p, v);
N["MemoryAccessJNI.nputLong"] = (p, v) => P.si64(p, v);
N["MemoryAccessJNI.nputFloat"] = (p, v) => P.sf32(p, v);
N["MemoryAccessJNI.nputDouble"] = (p, v) => P.sf64(p, v);
N["MemoryAccessJNI.nputAddress"] = (p, v) => P.sptr(p, v);

N["MemoryUtil.memGlobalRefToObject"] = () => { throw new Error("memGlobalRefToObject is not supported"); };
N["SharedLibraryUtil.getLibraryPath"] = () => 0;

// ---------------------------------------------------------------- libc
function bytesOf(x) {
  return new Uint8Array(x.buffer, x.byteOffset, x.byteLength);
}
N["LibCString.nmemset"] = (dst, c, n) => {
  if (LW.isArr(dst)) bytesOf(dst).fill(c & 255, 0, n);
  else LW.u8().fill(c & 255, dst, dst + n);
  return LW.isArr(dst) ? 0 : dst;
};
function memmove(dst, src, n) {
  if (LW.isArr(dst) || LW.isArr(src)) {
    const s = LW.isArr(src) ? bytesOf(src).slice(0, n) : LW.copyBytes(src, n);
    if (LW.isArr(dst)) bytesOf(dst).set(s);
    else LW.writeBytes(dst, s);
    return LW.isArr(dst) ? 0 : dst;
  }
  LW.u8().copyWithin(dst, src, src + n);
  return dst;
}
N["LibCString.nmemcpy"] = memmove;
N["LibCString.nmemmove"] = memmove;
N["LibCString.nstrlen"] = (p) => {
  const m = LW.u8();
  let e = p;
  while (m[e] !== 0) e++;
  return e - p;
};
N["LibCString.nstrerror"] = (e) => LW.staticCString("error " + e);
N["LibCStdlib.nmalloc"] = (n) => LW.malloc(n);
N["LibCStdlib.ncalloc"] = (a, b) => LW.calloc(a * b);
N["LibCStdlib.nrealloc"] = (p, n) => LW.realloc(p, n);
N["LibCStdlib.nfree"] = (p) => LW.free(p);
N["LibCStdlib.naligned_alloc"] = (a, n) => LW.malloc(n);
N["LibCStdlib.naligned_free"] = (p) => LW.free(p);
N["LibCErrno.errno"] = () => 0;
N["LibCStdio.nfflush"] = () => 0;
// The allocator symbols, for code that calls malloc/free through function pointers.
LW.ffi.malloc = (n) => LW.malloc(n);
LW.ffi.calloc = (a, b) => LW.calloc(a * b);
LW.ffi.realloc = (p, n) => LW.realloc(p, n);
LW.ffi.free = (p) => LW.free(p);
LW.ffi.aligned_alloc = (a, n) => LW.malloc(n);
LW.ffi.aligned_free = (p) => LW.free(p);

// ---------------------------------------------------------------- libffi (only CIF preparation is needed; calls go through WebFFI)
const ffiTypes = {};
const FFI_TYPES = {
  void: [1, 1, 0], uint8: [1, 1, 5], sint8: [1, 1, 6], uint16: [2, 2, 7], sint16: [2, 2, 8],
  uint32: [4, 4, 9], sint32: [4, 4, 10], uint64: [8, 8, 11], sint64: [8, 8, 12], uchar: [1, 1, 5],
  schar: [1, 1, 6], ushort: [2, 2, 7], sshort: [2, 2, 8], uint: [4, 4, 9], sint: [4, 4, 10],
  ulong: [8, 8, 11], slong: [8, 8, 12], float: [4, 4, 2], double: [8, 8, 3], longdouble: [16, 16, 4], pointer: [8, 8, 14],
};
for (const [k, [size, align, type]] of Object.entries(FFI_TYPES)) {
  N["LibFFI.nffi_type_" + k] = () => {
    if (!ffiTypes[k]) {
      // struct ffi_type { size_t size; unsigned short alignment; unsigned short type; ffi_type **elements; }
      const p = LW.calloc(24);
      P.sptr(p, size);
      P.si16(p + 8, align);
      P.si16(p + 10, type);
      ffiTypes[k] = p;
    }
    return ffiTypes[k];
  };
}
const ABI = { FFI_WIN64: 1, FFI_GNUW64: 2, FFI_UNIX64: 2, FFI_EFI64: 1, FFI_SYSV: 1, FFI_STDCALL: 1, FFI_THISCALL: 1,
  FFI_FASTCALL: 1, FFI_MS_CDECL: 1, FFI_PASCAL: 1, FFI_REGISTER: 1, FFI_VFP: 1, FFI_FIRST_ABI: 1, FFI_LAST_ABI: 4, FFI_DEFAULT_ABI: 2 };
for (const [k, v] of Object.entries(ABI)) N["LibFFI." + k] = () => v;
N["LibFFI.FFI_TYPE_DOUBLE"] = () => 3;
N["LibFFI.ffi_get_default_abi"] = () => 2;
N["LibFFI.nffi_get_version"] = () => LW.staticCString("3.4.6-lwjgl-web");
N["LibFFI.ffi_get_version_number"] = () => 30406;
N["LibFFI.nffi_prep_cif"] = (cif, abi, nargs, rtype, atypes) => {
  P.si32(cif, abi);
  P.si32(cif + 4, nargs);
  P.sptr(cif + 8, atypes);
  P.sptr(cif + 16, rtype);
  return 0; // FFI_OK
};
N["LibFFI.nffi_prep_cif_var"] = (cif, abi, nfixed, ntotal, rtype, atypes) => N["LibFFI.nffi_prep_cif"](cif, abi, ntotal, rtype, atypes);
N["LibFFI.ffi_get_closure_size"] = () => 64;
N["LibFFI.nffi_closure_alloc"] = (size, code) => {
  const p = LW.calloc(size);
  P.sptr(code, p);
  return p;
};
N["LibFFI.nffi_closure_free"] = (p) => LW.free(p);
N["LibFFI.nffi_prep_closure_loc"] = () => 0;
N["LibFFI.nffi_call"] = () => LW.warnOnce("ffi_call", "ffi_call is not supported in lwjgl-web");
// struct ffi_cif { int abi; unsigned nargs; ffi_type **arg_types; ffi_type *rtype; unsigned bytes; unsigned flags; }
N["FFICIF.offsets"] = (buf) => {
  [0, 4, 8, 16, 24, 28].forEach((o, i) => P.si32(buf + i * 4, o));
  return 32;
};
// struct ffi_closure { char tramp[32]?; ffi_cif *cif; void (*fun)(...); void *user_data; } -- layout only matters to us
N["FFIClosure.offsets"] = (buf) => {
  [0, 40, 48, 56].forEach((o, i) => P.si32(buf + i * 4, o));
  return 64;
};
// struct ffi_type { size_t size; unsigned short alignment; unsigned short type; ffi_type **elements; }
N["FFIType.offsets"] = (buf) => {
  [0, 8, 10, 16].forEach((o, i) => P.si32(buf + i * 4, o));
  return 24;
};

// ---------------------------------------------------------------- PNG decoder (exact, no premultiplication)
function inflateZlib(bytes) {
  return globalThis.fflate.unzlibSync(bytes);
}
function paeth(a, b, c) {
  const p = a + b - c, pa = Math.abs(p - a), pb = Math.abs(p - b), pc = Math.abs(p - c);
  return pa <= pb && pa <= pc ? a : pb <= pc ? b : c;
}
function decodePNG(buf) {
  const d = new DataView(buf.buffer, buf.byteOffset, buf.byteLength);
  if (d.getUint32(0) !== 0x89504e47) throw new Error("not a PNG");
  let pos = 8, w = 0, h = 0, depth = 0, ctype = 0, interlace = 0, palette = null, trns = null;
  const idat = [];
  while (pos < buf.length) {
    const len = d.getUint32(pos), type = String.fromCharCode(...buf.subarray(pos + 4, pos + 8));
    const data = buf.subarray(pos + 8, pos + 8 + len);
    if (type === "IHDR") {
      w = d.getUint32(pos + 8); h = d.getUint32(pos + 12); depth = buf[pos + 16]; ctype = buf[pos + 17]; interlace = buf[pos + 20];
    } else if (type === "PLTE") palette = data.slice();
    else if (type === "tRNS") trns = data.slice();
    else if (type === "IDAT") idat.push(data);
    else if (type === "IEND") break;
    pos += 12 + len;
  }
  let total = 0;
  for (const c of idat) total += c.length;
  const z = new Uint8Array(total);
  let o = 0;
  for (const c of idat) { z.set(c, o); o += c.length; }
  const raw = inflateZlib(z);
  const channels = { 0: 1, 2: 3, 3: 1, 4: 2, 6: 4 }[ctype];
  const bpp = Math.max(1, (channels * depth) >> 3);
  const out = new Uint8Array(w * h * 4);
  let rp = 0;
  const passes = interlace
    ? [[0, 0, 8, 8], [4, 0, 8, 8], [0, 4, 4, 8], [2, 0, 4, 4], [0, 2, 2, 4], [1, 0, 2, 2], [0, 1, 1, 2]]
    : [[0, 0, 1, 1]];
  for (const [x0, y0, dx, dy] of passes) {
    const pw = Math.ceil((w - x0) / dx), ph = Math.ceil((h - y0) / dy);
    if (pw <= 0 || ph <= 0) continue;
    const stride = Math.ceil((pw * channels * depth) / 8);
    let prev = new Uint8Array(stride);
    for (let y = 0; y < ph; y++) {
      const ft = raw[rp++];
      const line = raw.slice(rp, rp + stride);
      rp += stride;
      for (let i = 0; i < stride; i++) {
        const a = i >= bpp ? line[i - bpp] : 0, b = prev[i], c = i >= bpp ? prev[i - bpp] : 0;
        if (ft === 1) line[i] = (line[i] + a) & 255;
        else if (ft === 2) line[i] = (line[i] + b) & 255;
        else if (ft === 3) line[i] = (line[i] + ((a + b) >> 1)) & 255;
        else if (ft === 4) line[i] = (line[i] + paeth(a, b, c)) & 255;
      }
      prev = line;
      for (let x = 0; x < pw; x++) {
        // rawSample: value in the image's own bit depth; sample: scaled to 8 bits (palette indices unscaled)
        const rawSample = (ch) => {
          if (depth === 8) return line[x * channels + ch];
          if (depth === 16) return (line[(x * channels + ch) * 2] << 8) | line[(x * channels + ch) * 2 + 1];
          const bit = (x * channels + ch) * depth;
          return (line[bit >> 3] >> (8 - depth - (bit & 7))) & ((1 << depth) - 1);
        };
        const sample = (ch) => {
          const v = rawSample(ch);
          if (depth === 8 || ctype === 3) return v;
          if (depth === 16) return v >> 8;
          return Math.round((v * 255) / ((1 << depth) - 1));
        };
        const di = ((y0 + y * dy) * w + (x0 + x * dx)) * 4;
        let r, g, b2, al = 255;
        if (ctype === 0) {
          r = g = b2 = sample(0);
          if (trns && trns.length >= 2 && rawSample(0) === ((trns[0] << 8) | trns[1])) al = 0;
        } else if (ctype === 2) {
          r = sample(0); g = sample(1); b2 = sample(2);
          if (trns && trns.length >= 6 &&
              rawSample(0) === ((trns[0] << 8) | trns[1]) && rawSample(1) === ((trns[2] << 8) | trns[3]) && rawSample(2) === ((trns[4] << 8) | trns[5])) al = 0;
        } else if (ctype === 3) {
          const idx = sample(0);
          r = palette[idx * 3]; g = palette[idx * 3 + 1]; b2 = palette[idx * 3 + 2];
          if (trns && idx < trns.length) al = trns[idx];
        } else if (ctype === 4) {
          r = g = b2 = sample(0); al = sample(1);
        } else {
          r = sample(0); g = sample(1); b2 = sample(2); al = sample(3);
        }
        out[di] = r; out[di + 1] = g; out[di + 2] = b2; out[di + 3] = al;
      }
    }
  }
  const comp = ctype === 0 ? (trns ? 2 : 1) : ctype === 4 ? 2 : ctype === 2 ? (trns ? 4 : 3) : ctype === 3 ? (trns ? 4 : 3) : 4;
  return { w, h, comp, rgba: out };
}
async function decodeOther(buf) {
  // Non-PNG fallback (JPEG etc.) through the browser; alpha is not premultiplied for opaque images.
  const bmp = await createImageBitmap(new Blob([buf]), { premultiplyAlpha: "none", colorSpaceConversion: "none" });
  const c = new OffscreenCanvas(bmp.width, bmp.height);
  const g = c.getContext("2d");
  g.drawImage(bmp, 0, 0);
  const id = g.getImageData(0, 0, bmp.width, bmp.height);
  return { w: bmp.width, h: bmp.height, comp: 4, rgba: new Uint8Array(id.data.buffer) };
}
function convertChannels(rgba, n, req) {
  if (req === 4) return rgba;
  const out = new Uint8Array(n * req);
  for (let i = 0; i < n; i++) {
    const r = rgba[i * 4], g = rgba[i * 4 + 1], b = rgba[i * 4 + 2], a = rgba[i * 4 + 3];
    if (req === 1) out[i] = Math.round(0.299 * r + 0.587 * g + 0.114 * b);
    else if (req === 2) { out[i * 2] = Math.round(0.299 * r + 0.587 * g + 0.114 * b); out[i * 2 + 1] = a; }
    else { out[i * 3] = r; out[i * 3 + 1] = g; out[i * 3 + 2] = b; }
  }
  return out;
}
let stbiFailure = null;
const bigAllocs = new Set();
function allocResult(n) { return LW.malloc(n); }
LW.decodeImage = (bytes) => {
  if (bytes[0] === 0x89 && bytes[1] === 0x50) return decodePNG(bytes);
  throw new Error("only PNG images are supported");
};
N["stbi_load_from_memory"] = (buffer, len, px, py, pcomp, req) => {
  try {
    const bytes = LW.copyBytes(buffer, len);
    const img = LW.decodeImage(bytes);
    const want = req || img.comp;
    const data = convertChannels(img.rgba, img.w * img.h, want);
    const p = allocResult(data.length);
    LW.writeBytes(p, data);
    if (px) P.si32(px, img.w);
    if (py) P.si32(py, img.h);
    if (pcomp) P.si32(pcomp, img.comp);
    return p;
  } catch (e) {
    stbiFailure = String(e && e.message ? e.message : e);
    LW.warn("stbi_load_from_memory failed:", stbiFailure);
    return 0;
  }
};
N["stbi_image_free"] = (p) => { if (p) LW.free(p); };
N["stbi_failure_reason"] = () => (stbiFailure ? LW.staticCString(stbiFailure) : 0);
N["LibSTB.setupMalloc"] = () => {};
N["stbi_info_from_memory"] = (buffer, len, px, py, pcomp) => {
  try {
    const img = LW.decodeImage(LW.copyBytes(buffer, len));
    if (px) P.si32(px, img.w);
    if (py) P.si32(py, img.h);
    if (pcomp) P.si32(pcomp, img.comp);
    return 1;
  } catch (e) {
    return 0;
  }
};
N["stbi_set_flip_vertically_on_load"] = () => {};
// Bilinear resize, uint8, any channel count (pixel_layout enum values 1..4 map to channel counts for the common ones)
function resize(input, iw, ih, istride, output, ow, oh, ostride, ch) {
  const m = LW.u8();
  istride = istride || iw * ch;
  ostride = ostride || ow * ch;
  const src = m.slice(input, input + istride * ih);
  for (let y = 0; y < oh; y++) {
    const sy = Math.min(ih - 1, ((y + 0.5) * ih) / oh - 0.5), y0 = Math.max(0, Math.floor(sy)), y1 = Math.min(ih - 1, y0 + 1), fy = Math.max(0, sy - y0);
    for (let x = 0; x < ow; x++) {
      const sx = Math.min(iw - 1, ((x + 0.5) * iw) / ow - 0.5), x0 = Math.max(0, Math.floor(sx)), x1 = Math.min(iw - 1, x0 + 1), fx = Math.max(0, sx - x0);
      for (let c = 0; c < ch; c++) {
        const a = src[y0 * istride + x0 * ch + c], b = src[y0 * istride + x1 * ch + c];
        const cc = src[y1 * istride + x0 * ch + c], d = src[y1 * istride + x1 * ch + c];
        m[output + y * ostride + x * ch + c] = Math.round((a * (1 - fx) + b * fx) * (1 - fy) + (cc * (1 - fx) + d * fx) * fy);
      }
    }
  }
  return output;
}
const LAYOUT_CH = { 1: 1, 2: 2, 3: 3, 4: 4, 5: 4, 6: 4, 7: 4, 8: 4, 9: 4, 10: 2, 11: 2 };
N["stbir_resize_uint8_linear"] = (input, iw, ih, istride, output, ow, oh, ostride, layout) =>
  resize(input, iw, ih, istride, output, ow, oh, ostride, LAYOUT_CH[layout] || 4);
N["stbir_resize_uint8_srgb"] = N["stbir_resize_uint8_linear"];
N["stbi_write_png_to_func"] = () => {
  LW.warnOnce("pngwrite", "stbi_write_png_to_func not supported (screenshots disabled)");
  return 0;
};
N["stbi_write_png"] = () => 0;

// ---------------------------------------------------------------- tinyfd
N["tinyfd_messageBox"] = (title, msg) => {
  console.warn("[tinyfd]", LW.cstr(title), LW.cstr(msg));
  return 1;
};
N["tinyfd_notifyPopup"] = (title, msg) => {
  console.warn("[tinyfd]", LW.cstr(title), LW.cstr(msg));
  return 1;
};
N["tinyfd_beep"] = () => {};
N["tinyfd_getGlobalChar"] = (name) => {
  const n = LW.cstr(name);
  if (n === "tinyfd_version") return LW.staticCString("3.18.2");
  if (n === "tinyfd_response") return LW.staticCString("");
  return 0;
};
N["tinyfd_getGlobalInt"] = () => 0;
N["tinyfd_setGlobalInt"] = () => 0;

// ---------------------------------------------------------------- FFI stubs for libraries we do not provide
const F = LW.ffi;
// FreeType: report failure so the game skips TrueType fonts (bitmap fonts still work).
F.FT_Init_FreeType = (p) => { if (p) P.sptr(p, 0); return 1; };
F.FT_Done_FreeType = () => 0;
F.FT_Done_Library = () => 0;
F.FT_Error_String = () => LW.staticCString("FreeType is not available in lwjgl-web");
F.FT_Library_Version = (lib, a, b, c) => { if (a) P.si32(a, 2); if (b) P.si32(b, 13); if (c) P.si32(c, 0); };
// OpenAL: no device. alcOpenDevice returns NULL; the game runs without sound.
F.alcOpenDevice = () => 0;
F.alcCloseDevice = () => 1;
F.alcGetError = () => 0;
F.alcIsExtensionPresent = () => 0;
F.alcGetProcAddress = (dev, name) => LW.symbol(LW.cstr(name));
F.alcGetEnumValue = () => 0;
F.alcGetString = (dev, p) => LW.staticCString("");
F.alcGetIntegerv = (dev, p, size, out) => {
  if (!out) return;
  if (p === 0x1000) P.si32(out, 1); // ALC_MAJOR_VERSION
  else if (p === 0x1001) P.si32(out, 1); // ALC_MINOR_VERSION
  else P.si32(out, 0);
};
F.alGetError = () => 0;
F.alGetString = () => LW.staticCString("");
F.alIsExtensionPresent = () => 0;
F.alGetProcAddress = (name) => LW.symbol(LW.cstr(name));
F.alcGetCurrentContext = () => 0;
F.alcMakeContextCurrent = () => 1;
// Vulkan / shaderc / spvc: not available; the game must run with --graphicsBackend opengl.
F.vkGetInstanceProcAddr = () => 0;
F.vkEnumerateInstanceVersion = () => -9; // VK_ERROR_INCOMPATIBLE_DRIVER
F.vkCreateInstance = () => -9;
F.shaderc_compiler_initialize = () => 0;
F.spvc_context_create = () => -1;
// jemalloc (if ever selected): route to our allocator
F.je_malloc = (n) => LW.malloc(n);
F.je_calloc = (a, b) => LW.calloc(a * b);
F.je_realloc = (p, n) => LW.realloc(p, n);
F.je_free = (p) => LW.free(p);
F.je_aligned_alloc = (a, n) => LW.malloc(n);

// ---------------------------------------------------------------- sun.misc.Unsafe raw-memory natives
// CheerpJ's Java 8 runtime lacks some address-only Unsafe accessors (e.g. getLong(long)). These are
// instance natives: (lib, self, address[, value]). The (Object, offset) forms are left to CheerpJ unless
// the object is null, in which case the offset is a raw address.
LW.unsafeNatives = (() => {
  const out = {};
  const T = {
    Byte: [(p) => P.i8(p), (p, v) => P.si8(p, v)],
    Short: [(p) => P.i16(p), (p, v) => P.si16(p, v)],
    Char: [(p) => P.u16(p), (p, v) => LW.dv().setUint16(p, v, true)],
    Int: [(p) => P.i32(p), (p, v) => P.si32(p, v)],
    Long: [(p) => P.i64(p), (p, v) => P.si64(p, v)],
    Float: [(p) => P.f32(p), (p, v) => P.sf32(p, v)],
    Double: [(p) => P.f64(p), (p, v) => P.sf64(p, v)],
    Address: [(p) => P.ptr(p), (p, v) => P.sptr(p, v)],
  };
  const num = (x) => (typeof x === "bigint" ? Number(x) : x);
  for (const [name, [get, put]] of Object.entries(T)) {
    const g = name === "Long" || name === "Address"
      ? (p) => { const v = LW.dv().getBigInt64(p, true); return LW.config.unsafeLongMode === "number" ? Number(v) : v; }
      : get;
    out["Java_sun_misc_Unsafe_get" + name] = (lib, self, a, b) => {
      LW.setLib(lib);
      if (b === undefined) return g(num(a));
      if (a == null) return g(num(b));
      throw new Error("[lwjgl-web] Unsafe.get" + name + "(Object, long) on a non-null object is not supported here");
    };
    const pt = name === "Long" || name === "Address" ? (p, v) => LW.dv().setBigInt64(p, BigInt.asIntN(64, typeof v === "bigint" ? v : BigInt(Math.trunc(v))), true) : (p, v) => put(p, num(v));
    out["Java_sun_misc_Unsafe_put" + name] = (lib, self, a, b, c) => {
      LW.setLib(lib);
      if (c === undefined) return pt(num(a), b);
      if (a == null) return pt(num(b), c);
      throw new Error("[lwjgl-web] Unsafe.put" + name + "(Object, long, v) on a non-null object is not supported here");
    };
  }
  return out;
})();
