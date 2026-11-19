// mc-web: OpenAL 1.1 on top of Web Audio (the subset Minecraft uses). MIT License.
// Sources are Web Audio graphs (buffer sources -> gain -> panner -> master gain). Streaming sources keep a queue of
// buffers scheduled back to back; "processed" buffers are the ones whose scheduled end time has passed.
const LW = globalThis.LWJGLWeb;
const P = LW.mem;
const F = LW.ffi;

const AL = {
  NONE: 0, SOURCE_RELATIVE: 0x202, PITCH: 0x1003, POSITION: 0x1004, DIRECTION: 0x1005, VELOCITY: 0x1006, LOOPING: 0x1007,
  BUFFER: 0x1009, GAIN: 0x100a, ORIENTATION: 0x100f, SOURCE_STATE: 0x1010, INITIAL: 0x1011, PLAYING: 0x1012,
  PAUSED: 0x1013, STOPPED: 0x1014, BUFFERS_QUEUED: 0x1015, BUFFERS_PROCESSED: 0x1016, REFERENCE_DISTANCE: 0x1020,
  ROLLOFF_FACTOR: 0x1021, MAX_DISTANCE: 0x1023, SEC_OFFSET: 0x1024, SOURCE_TYPE: 0x1027, FREQUENCY: 0x2001,
  BITS: 0x2002, CHANNELS: 0x2003, SIZE: 0x2004, VENDOR: 0xb001, VERSION: 0xb002, RENDERER: 0xb003, EXTENSIONS: 0xb004,
  DISTANCE_MODEL: 0xd000, LINEAR_DISTANCE: 0xd003, LINEAR_DISTANCE_CLAMPED: 0xd004, INVERSE_DISTANCE_CLAMPED: 0xd002,
};
const FORMATS = { // format -> [channels, bytesPerSample, kind]
  0x1100: [1, 1, "u8"], 0x1101: [1, 2, "s16"], 0x1102: [2, 1, "u8"], 0x1103: [2, 2, "s16"],
  0x10010: [1, 4, "f32"], 0x10011: [2, 4, "f32"],
};

let ctx = null, master = null;
const buffers = new Map();   // id -> { audio: AudioBuffer|null, dur, freq, channels, bits, size }
const sources = new Map();   // id -> source state
let nextBuffer = 1, nextSource = 1;
const listener = { pos: [0, 0, 0], fwd: [0, 0, -1], up: [0, 1, 0], gain: 1 };

function ensureCtx() {
  if (ctx) return ctx;
  const AC = globalThis.AudioContext || globalThis.webkitAudioContext;
  if (!AC) return null;
  ctx = new AC({ latencyHint: "interactive" });
  master = ctx.createGain();
  master.connect(ctx.destination);
  // browsers start audio suspended until the user interacts with the page
  const resume = () => { if (ctx.state !== "running") ctx.resume().catch(() => {}); };
  for (const ev of ["mousedown", "keydown", "touchstart", "pointerdown"]) addEventListener(ev, resume, true);
  applyListener();
  return ctx;
}

function applyListener() {
  if (!ctx) return;
  const l = ctx.listener;
  const [x, y, z] = listener.pos, [fx, fy, fz] = listener.fwd, [ux, uy, uz] = listener.up;
  if (l.positionX) {
    const t = ctx.currentTime;
    l.positionX.setValueAtTime(x, t); l.positionY.setValueAtTime(y, t); l.positionZ.setValueAtTime(z, t);
    l.forwardX.setValueAtTime(fx, t); l.forwardY.setValueAtTime(fy, t); l.forwardZ.setValueAtTime(fz, t);
    l.upX.setValueAtTime(ux, t); l.upY.setValueAtTime(uy, t); l.upZ.setValueAtTime(uz, t);
  } else {
    l.setPosition(x, y, z);
    l.setOrientation(fx, fy, fz, ux, uy, uz);
  }
  master.gain.value = listener.gain;
}

// ---------------------------------------------------------------- ALC
const DEVICE = 0x51000, CONTEXT = 0x52000;
const DEVICE_NAME = "mc-web Web Audio";
let deviceList = 0;
F.alcOpenDevice = () => (ensureCtx() ? DEVICE : 0);
F.alcCloseDevice = () => 1;
F.alcCreateContext = () => (ensureCtx() ? CONTEXT : 0);
F.alcMakeContextCurrent = () => 1;
F.alcGetCurrentContext = () => (ctx ? CONTEXT : 0);
F.alcGetContextsDevice = () => DEVICE;
F.alcDestroyContext = () => {};
F.alcProcessContext = () => {};
F.alcSuspendContext = () => {};
F.alcGetError = () => 0;
F.alcIsExtensionPresent = (dev, name) => (ALC_EXTS.includes(LW.cstr(name)) ? 1 : 0);
F.alcGetProcAddress = (dev, name) => LW.symbol(LW.cstr(name));
F.alcGetEnumValue = () => 0;
F.alcGetString = (dev, p) => {
  if (p === 0x1013 || p === 0x1005 && !dev) { // ALC_ALL_DEVICES_SPECIFIER / device list: double-NUL terminated
    if (!deviceList) {
      const b = new TextEncoder().encode(DEVICE_NAME);
      deviceList = LW.malloc(b.length + 2);
      LW.writeBytes(deviceList, b);
      LW.u8()[deviceList + b.length] = 0;
      LW.u8()[deviceList + b.length + 1] = 0;
    }
    return deviceList;
  }
  if (p === 0x1004 || p === 0x1005 || p === 0x1012) return LW.staticCString(DEVICE_NAME);
  if (p === 0x1006) return LW.staticCString(ALC_EXTS.join(" ")); // ALC_EXTENSIONS
  return LW.staticCString("");
};
const ALC_INTS = { 0x1000: 1, 0x1001: 1, 0x1007: 48000, 0x1010: 255, 0x1011: 8, 0x313: 1, 0x1002: 5 };
F.alcGetIntegerv = (dev, p, size, out) => {
  if (!out) return;
  if (p === 0x1003) { // ALC_ALL_ATTRIBUTES
    const a = [0x1010, 255, 0x1011, 8, 0];
    for (let i = 0; i < Math.min(size, a.length); i++) P.si32(out + i * 4, a[i]);
    return;
  }
  P.si32(out, ALC_INTS[p] ?? 0);
};
F.alcResetDeviceSOFT = () => 1;

// ---------------------------------------------------------------- AL state queries
F.alGetError = () => 0;
// extensions this implementation really handles (per-source distance models, float32 buffers)
const AL_EXTS = ["AL_EXT_source_distance_model", "AL_EXT_LINEAR_DISTANCE", "AL_EXT_float32"];
const ALC_EXTS = ["ALC_ENUMERATE_ALL_EXT", "ALC_ENUMERATION_EXT"];
F.alIsExtensionPresent = (name) => (AL_EXTS.includes(LW.cstr(name)) ? 1 : 0);
F.alGetProcAddress = (name) => LW.symbol(LW.cstr(name));
F.alGetEnumValue = () => 0;
F.alGetString = (p) => LW.staticCString(p === AL.VERSION ? "1.1 mc-web" : p === AL.RENDERER ? "Web Audio" : p === AL.VENDOR ? "mc-web"
  : p === AL.EXTENSIONS ? AL_EXTS.join(" ") : "");
F.alEnable = () => {};
F.alDisable = () => {};
F.alIsEnabled = () => 0;
F.alDistanceModel = () => {};
F.alDopplerFactor = () => {};
F.alSpeedOfSound = () => {};
F.alGetInteger = () => 0;
F.alGetFloat = () => 0;

// ---------------------------------------------------------------- buffers
F.alGenBuffers = (n, out) => { for (let i = 0; i < n; i++) { const id = nextBuffer++; buffers.set(id, { audio: null, dur: 0 }); P.si32(out + i * 4, id); } };
F.alDeleteBuffers = (n, ids) => { for (let i = 0; i < n; i++) buffers.delete(P.i32(ids + i * 4)); };
F.alIsBuffer = (id) => (buffers.has(id) ? 1 : 0);
F.alBufferData = (id, format, data, size, freq) => {
  const b = buffers.get(id);
  const f = FORMATS[format];
  if (!b || !f || !ensureCtx()) return;
  const [ch, bps, kind] = f;
  const frames = Math.floor(size / (ch * bps));
  b.channels = ch; b.bits = bps * 8; b.size = size; b.freq = freq;
  if (frames <= 0) { b.audio = null; b.dur = 0; return; }
  const audio = ctx.createBuffer(ch, frames, freq);
  const bytes = LW.copyBytes(data, frames * ch * bps);
  const dv = new DataView(bytes.buffer);
  for (let c = 0; c < ch; c++) {
    const out = audio.getChannelData(c);
    for (let i = 0; i < frames; i++) {
      const o = (i * ch + c) * bps;
      out[i] = kind === "s16" ? dv.getInt16(o, true) / 32768 : kind === "u8" ? (bytes[o] - 128) / 128 : dv.getFloat32(o, true);
    }
  }
  b.audio = audio;
  b.dur = audio.duration;
};
F.alGetBufferi = (id, p, out) => {
  const b = buffers.get(id) || {};
  const v = p === AL.FREQUENCY ? b.freq : p === AL.BITS ? b.bits : p === AL.CHANNELS ? b.channels : p === AL.SIZE ? b.size : 0;
  if (out) P.si32(out, v | 0);
};

// ---------------------------------------------------------------- sources
function newSource() {
  return {
    state: AL.INITIAL, queue: [], cursor: 0, offset: 0, looping: false, relative: false, gainV: 1, pitch: 1,
    pos: [0, 0, 0], maxDist: 3.4e38, refDist: 1, rolloff: 1, model: AL.INVERSE_DISTANCE_CLAMPED, nodes: [],
    gain: null, panner: null, isStatic: false,
  };
}
F.alGenSources = (n, out) => { for (let i = 0; i < n; i++) { const id = nextSource++; sources.set(id, newSource()); P.si32(out + i * 4, id); } };
F.alDeleteSources = (n, ids) => {
  for (let i = 0; i < n; i++) {
    const id = P.i32(ids + i * 4);
    const s = sources.get(id);
    if (s) { stopNodes(s); disconnect(s); }
    sources.delete(id);
  }
};
F.alIsSource = (id) => (sources.has(id) ? 1 : 0);

function graph(s) {
  if (s.gain) return;
  s.gain = ctx.createGain();
  s.gain.gain.value = s.gainV;
  s.panner = ctx.createPanner();
  s.panner.panningModel = "equalpower";
  s.gain.connect(s.panner);
  s.panner.connect(master);
  applySpatial(s);
}
function disconnect(s) {
  if (!s.gain) return;
  try { s.gain.disconnect(); s.panner.disconnect(); } catch (e) {}
  s.gain = s.panner = null;
}
function applySpatial(s) {
  if (!s.panner) return;
  const p = s.panner;
  // relative sources are positioned around the listener (Minecraft uses (0,0,0) for music and UI sounds)
  const x = s.relative ? listener.pos[0] + s.pos[0] : s.pos[0];
  const y = s.relative ? listener.pos[1] + s.pos[1] : s.pos[1];
  const z = s.relative ? listener.pos[2] + s.pos[2] : s.pos[2];
  if (p.positionX) {
    const t = ctx.currentTime;
    p.positionX.setValueAtTime(x, t); p.positionY.setValueAtTime(y, t); p.positionZ.setValueAtTime(z, t);
  } else p.setPosition(x, y, z);
  const linear = s.model === AL.LINEAR_DISTANCE || s.model === AL.LINEAR_DISTANCE_CLAMPED;
  p.distanceModel = linear ? "linear" : "inverse";
  p.refDistance = Math.max(0, s.refDist);
  p.maxDistance = Math.max(p.refDistance + 1e-3, Math.min(s.maxDist, 1e30));
  p.rolloffFactor = linear ? Math.min(1, Math.max(0, s.rolloff)) : Math.max(0, s.rolloff);
}
function stopNodes(s) {
  for (const n of s.nodes) { try { n.node.onended = null; n.node.stop(); n.node.disconnect(); } catch (e) {} }
  s.nodes = [];
}
// schedule queue entries from s.cursor (starting s.offset seconds into it) back to back
function schedule(s) {
  graph(s);
  let t = ctx.currentTime + 0.005;
  for (let i = s.cursor; i < s.queue.length; i++) {
    const e = s.queue[i];
    t = scheduleEntry(s, e, t, i === s.cursor ? s.offset : 0);
  }
  s.offset = 0;
}
function scheduleEntry(s, e, t, offset) {
  const b = buffers.get(e.buffer);
  if (!b || !b.audio) { e.start = t; e.end = t; return t; }
  const node = ctx.createBufferSource();
  node.buffer = b.audio;
  node.playbackRate.value = s.pitch;
  node.loop = s.looping && s.isStatic;
  node.connect(s.gain);
  node.start(t, Math.min(offset, b.dur));
  e.start = t;
  e.end = node.loop ? Infinity : t + (b.dur - Math.min(offset, b.dur)) / s.pitch;
  e.scheduled = true;
  s.nodes.push({ node, entry: e });
  node.onended = () => { s.nodes = s.nodes.filter((n) => n.node !== node); };
  return e.end;
}
function processedCount(s) {
  if (s.state === AL.STOPPED) return s.queue.length;
  if (s.state !== AL.PLAYING) return s.queue.filter((e) => e.done).length;
  const now = ctx.currentTime;
  let n = 0;
  for (const e of s.queue) { if (e.done || (e.scheduled && e.end <= now)) n++; else break; }
  return n;
}
function updateState(s) {
  if (s.state !== AL.PLAYING || !ctx) return;
  const last = s.queue[s.queue.length - 1];
  if (!last || (last.scheduled && last.end <= ctx.currentTime)) {
    // ran out of data: OpenAL stops the source
    for (const e of s.queue) e.done = true;
    s.state = AL.STOPPED;
    stopNodes(s);
  }
}

F.alSourcei = (id, p, v) => {
  const s = sources.get(id);
  if (!s) return;
  if (p === AL.BUFFER) {
    stopNodes(s);
    s.queue = v ? [{ buffer: v }] : [];
    s.isStatic = !!v;
    s.cursor = 0; s.offset = 0;
    if (s.state !== AL.INITIAL) s.state = AL.STOPPED;
  } else if (p === AL.LOOPING) {
    s.looping = !!v;
    for (const n of s.nodes) n.node.loop = s.looping && s.isStatic;
  } else if (p === AL.SOURCE_RELATIVE) { s.relative = !!v; applySpatial(s); }
  else if (p === AL.DISTANCE_MODEL) { s.model = v; applySpatial(s); }
  else if (p === AL.REFERENCE_DISTANCE || p === AL.MAX_DISTANCE || p === AL.ROLLOFF_FACTOR) F.alSourcef(id, p, v);
};
F.alSource3i = (id, p, x, y, z) => F.alSource3f(id, p, x, y, z);
F.alSourcef = (id, p, v) => {
  const s = sources.get(id);
  if (!s) return;
  if (p === AL.GAIN) { s.gainV = v; if (s.gain) s.gain.gain.value = v; }
  else if (p === AL.PITCH) { s.pitch = Math.max(0.01, v); for (const n of s.nodes) n.node.playbackRate.value = s.pitch; }
  else if (p === AL.MAX_DISTANCE) { s.maxDist = v; applySpatial(s); }
  else if (p === AL.REFERENCE_DISTANCE) { s.refDist = v; applySpatial(s); }
  else if (p === AL.ROLLOFF_FACTOR) { s.rolloff = v; applySpatial(s); }
};
F.alSource3f = (id, p, x, y, z) => {
  const s = sources.get(id);
  if (!s) return;
  if (p === AL.POSITION) { s.pos = [x, y, z]; applySpatial(s); }
};
F.alSourcefv = (id, p, v) => { if (v) F.alSource3f(id, p, P.f32(v), P.f32(v + 4), P.f32(v + 8)); };
F.alSourceiv = (id, p, v) => { if (v) F.alSourcei(id, p, P.i32(v)); };
F.alGetSourcei = (id, p, out) => {
  const s = sources.get(id);
  let v = 0;
  if (s) {
    updateState(s);
    if (p === AL.SOURCE_STATE) v = s.state;
    else if (p === AL.BUFFERS_QUEUED) v = s.queue.length;
    else if (p === AL.BUFFERS_PROCESSED) v = s.isStatic ? 0 : processedCount(s);
    else if (p === AL.LOOPING) v = s.looping ? 1 : 0;
    else if (p === AL.SOURCE_RELATIVE) v = s.relative ? 1 : 0;
    else if (p === AL.BUFFER) v = s.queue.length ? s.queue[s.queue.length - 1].buffer : 0;
    else if (p === AL.SOURCE_TYPE) v = s.isStatic ? 0x1028 : s.queue.length ? 0x1029 : 0x1030;
  }
  if (out) P.si32(out, v);
};
F.alGetSourcef = (id, p, out) => {
  const s = sources.get(id);
  let v = 0;
  if (s) {
    if (p === AL.GAIN) v = s.gainV;
    else if (p === AL.PITCH) v = s.pitch;
    else if (p === AL.SEC_OFFSET && s.nodes.length) v = Math.max(0, (ctx.currentTime - s.nodes[0].entry.start) * s.pitch);
  }
  if (out) P.sf32(out, v);
};

function play(s) {
  if (!ensureCtx()) return;
  if (s.state === AL.PLAYING) { stopNodes(s); s.cursor = 0; s.offset = 0; for (const e of s.queue) { e.done = false; e.scheduled = false; } }
  else if (s.state !== AL.PAUSED) { s.cursor = 0; s.offset = 0; for (const e of s.queue) { e.done = false; e.scheduled = false; } }
  s.state = AL.PLAYING;
  schedule(s);
}
function pause(s) {
  if (s.state !== AL.PLAYING) return;
  const now = ctx.currentTime;
  let i = 0;
  for (; i < s.queue.length; i++) {
    const e = s.queue[i];
    if (!(e.scheduled && e.end <= now)) break;
    e.done = true;
  }
  s.cursor = i;
  const cur = s.queue[i];
  const b = cur && buffers.get(cur.buffer);
  s.offset = cur && cur.scheduled && b ? Math.max(0, (now - cur.start) * s.pitch) % Math.max(b.dur, 1e-6) : 0;
  stopNodes(s);
  for (let k = i; k < s.queue.length; k++) s.queue[k].scheduled = false;
  s.state = AL.PAUSED;
}
function stop(s) {
  stopNodes(s);
  for (const e of s.queue) { e.done = true; e.scheduled = false; }
  if (s.state !== AL.INITIAL) s.state = AL.STOPPED;
  else s.state = AL.STOPPED;
}
F.alSourcePlay = (id) => { const s = sources.get(id); if (s) play(s); };
F.alSourcePause = (id) => { const s = sources.get(id); if (s) pause(s); };
F.alSourceStop = (id) => { const s = sources.get(id); if (s) stop(s); };
F.alSourceRewind = (id) => { const s = sources.get(id); if (s) { stopNodes(s); s.state = AL.INITIAL; s.cursor = 0; s.offset = 0; } };
for (const [name, fn] of [["alSourcePlayv", "alSourcePlay"], ["alSourcePausev", "alSourcePause"], ["alSourceStopv", "alSourceStop"], ["alSourceRewindv", "alSourceRewind"]]) {
  F[name] = (n, ids) => { for (let i = 0; i < n; i++) F[fn](P.i32(ids + i * 4)); };
}
F.alSourceQueueBuffers = (id, n, ids) => {
  const s = sources.get(id);
  if (!s) return;
  if (s.isStatic) { s.queue = []; s.isStatic = false; }
  for (let i = 0; i < n; i++) {
    const e = { buffer: P.i32(ids + i * 4) };
    s.queue.push(e);
    if (s.state === AL.PLAYING && ctx) {
      const prev = s.queue[s.queue.length - 2];
      const t = Math.max(ctx.currentTime + 0.005, prev && prev.scheduled ? prev.end : 0);
      graph(s);
      scheduleEntry(s, e, t, 0);
    }
  }
};
F.alSourceUnqueueBuffers = (id, n, out) => {
  const s = sources.get(id);
  if (!s) return;
  for (let i = 0; i < n && s.queue.length; i++) {
    const e = s.queue.shift();
    if (s.cursor > 0) s.cursor--;
    if (out) P.si32(out + i * 4, e.buffer);
  }
};

// ---------------------------------------------------------------- listener
F.alListenerf = (p, v) => { if (p === AL.GAIN) { listener.gain = v; applyListener(); } };
F.alListener3f = (p, x, y, z) => {
  if (p === AL.POSITION) {
    listener.pos = [x, y, z];
    applyListener();
    for (const s of sources.values()) if (s.relative && s.panner) applySpatial(s);
  }
};
F.alListenerfv = (p, v) => {
  if (!v) return;
  if (p === AL.ORIENTATION) {
    listener.fwd = [P.f32(v), P.f32(v + 4), P.f32(v + 8)];
    listener.up = [P.f32(v + 12), P.f32(v + 16), P.f32(v + 20)];
    applyListener();
  } else if (p === AL.POSITION) F.alListener3f(p, P.f32(v), P.f32(v + 4), P.f32(v + 8));
  else if (p === AL.GAIN) F.alListenerf(p, P.f32(v));
};
F.alListeneri = () => {};
F.alGetListenerf = (p, out) => { if (out) P.sf32(out, p === AL.GAIN ? listener.gain : 0); };
