// lwjgl-web: GLFW implemented on top of a <canvas>, DOM input events and WebGL2. MIT License.
const LW = globalThis.LWJGLWeb;
const P = LW.mem;
const F = LW.ffi;

const WINDOW = 0x40000010;
const MONITOR = 0x40000100;
const PRESS = 1, RELEASE = 0, REPEAT = 2;
const CURSOR = 0x33001, STICKY_KEYS = 0x33002, STICKY_MOUSE = 0x33003, LOCK_KEY_MODS = 0x33004, RAW_MOUSE = 0x33005;
const CURSOR_NORMAL = 0x34001, CURSOR_HIDDEN = 0x34002, CURSOR_DISABLED = 0x34003;

// KeyboardEvent.code -> GLFW key
const KEYS = {
  Space: 32, Quote: 39, Comma: 44, Minus: 45, Period: 46, Slash: 47, Semicolon: 59, Equal: 61,
  BracketLeft: 91, Backslash: 92, BracketRight: 93, Backquote: 96, IntlBackslash: 162,
  Escape: 256, Enter: 257, Tab: 258, Backspace: 259, Insert: 260, Delete: 261, ArrowRight: 262, ArrowLeft: 263,
  ArrowDown: 264, ArrowUp: 265, PageUp: 266, PageDown: 267, Home: 268, End: 269, CapsLock: 280, ScrollLock: 281,
  NumLock: 282, PrintScreen: 283, Pause: 284,
  Numpad0: 320, Numpad1: 321, Numpad2: 322, Numpad3: 323, Numpad4: 324, Numpad5: 325, Numpad6: 326, Numpad7: 327,
  Numpad8: 328, Numpad9: 329, NumpadDecimal: 330, NumpadDivide: 331, NumpadMultiply: 332, NumpadSubtract: 333,
  NumpadAdd: 334, NumpadEnter: 335, NumpadEqual: 336,
  ShiftLeft: 340, ControlLeft: 341, AltLeft: 342, MetaLeft: 343, ShiftRight: 344, ControlRight: 345, AltRight: 346,
  MetaRight: 347, ContextMenu: 348,
};
for (let i = 0; i < 10; i++) KEYS["Digit" + i] = 48 + i;
for (let i = 0; i < 26; i++) KEYS["Key" + String.fromCharCode(65 + i)] = 65 + i;
for (let i = 1; i <= 25; i++) KEYS["F" + i] = 289 + i;
const SCANCODE = {}; // GLFW key -> fake scancode
let sc = 1;
for (const k of Object.values(KEYS)) SCANCODE[k] = sc++;

const G = (LW.glfw = {
  canvas: null,
  gl: null,
  created: false,
  cursorMode: CURSOR_NORMAL,
  keys: new Uint8Array(512),
  mouse: new Uint8Array(8),
  cx: 0,
  cy: 0,
  events: [],
  cb: {},
  clipboard: "",
  title: "Minecraft",
  startTime: performance.now(),
  shouldClose: 0,
  focused: 1,
  width: 854,
  height: 480,
  fbw: 854,
  fbh: 480,
  vidmode: 0,
  monitorsArr: 0,
  pendingLock: false,
});

function mods(e) {
  return (e.shiftKey ? 1 : 0) | (e.ctrlKey ? 2 : 0) | (e.altKey ? 4 : 0) | (e.metaKey ? 8 : 0) |
    (e.getModifierState && e.getModifierState("CapsLock") ? 0x10 : 0) | (e.getModifierState && e.getModifierState("NumLock") ? 0x20 : 0);
}
function push(ev) {
  G.events.push(ev);
}
function measure() {
  const c = G.canvas;
  const r = c.getBoundingClientRect();
  const w = Math.max(1, Math.round(r.width)), h = Math.max(1, Math.round(r.height));
  const pr = LW.config.pixelRatio || 1;
  const fw = Math.max(1, Math.round(w * pr)), fh = Math.max(1, Math.round(h * pr));
  if (w !== G.width || h !== G.height) {
    G.width = w; G.height = h;
    push({ t: "size", w, h });
  }
  if (fw !== G.fbw || fh !== G.fbh) {
    G.fbw = fw; G.fbh = fh;
    c.width = fw; c.height = fh;
    push({ t: "fbsize", w: fw, h: fh });
  }
}
function scale() {
  return G.fbw / G.width;
}

function ensureCanvas() {
  if (G.canvas) return G.canvas;
  let c = document.getElementById("lwjgl-canvas");
  if (!c) {
    c = document.createElement("canvas");
    c.id = "lwjgl-canvas";
    c.style.cssText = "position:fixed;inset:0;width:100vw;height:100vh;display:block;outline:none;background:#000;z-index:10";
    document.body.appendChild(c);
  }
  c.tabIndex = 1;
  G.canvas = c;
  // input
  const keyHandler = (down) => (e) => {
    const key = KEYS[e.code] || -1;
    const m = mods(e);
    if (down && (e.ctrlKey || e.metaKey) && e.code === "KeyV" && navigator.clipboard && navigator.clipboard.readText) {
      push({ t: "clipboard", p: navigator.clipboard.readText().then((s) => (G.clipboard = s)).catch(() => {}) });
    }
    if (key > 0) {
      const action = down ? (G.keys[key] ? REPEAT : PRESS) : RELEASE;
      G.keys[key] = down ? 1 : 0;
      push({ t: "key", key, sc: SCANCODE[key] || 0, action, mods: m });
    }
    if (down && e.key && [...e.key].length === 1 && !e.ctrlKey && !e.metaKey) {
      push({ t: "char", cp: e.key.codePointAt(0), mods: m });
    }
    // keep the browser from acting on game keys
    if (!(e.ctrlKey && ["KeyR", "KeyW", "KeyT", "KeyN"].includes(e.code)) && e.code !== "F11" && e.code !== "F12") e.preventDefault();
  };
  window.addEventListener("keydown", keyHandler(true), true);
  window.addEventListener("keyup", keyHandler(false), true);
  c.addEventListener("mousedown", (e) => {
    c.focus();
    if (G.cursorMode === CURSOR_DISABLED && document.pointerLockElement !== c) lockPointer();
    const b = [0, 2, 1, 3, 4][e.button] ?? e.button;
    G.mouse[b] = 1;
    push({ t: "button", b, action: PRESS, mods: mods(e) });
    e.preventDefault();
  });
  window.addEventListener("mouseup", (e) => {
    const b = [0, 2, 1, 3, 4][e.button] ?? e.button;
    if (!G.mouse[b]) return;
    G.mouse[b] = 0;
    push({ t: "button", b, action: RELEASE, mods: mods(e) });
  });
  c.addEventListener("contextmenu", (e) => e.preventDefault());
  window.addEventListener("mousemove", (e) => {
    const s = scale();
    if (document.pointerLockElement === c) {
      G.cx += e.movementX * s;
      G.cy += e.movementY * s;
    } else {
      const r = c.getBoundingClientRect();
      G.cx = (e.clientX - r.left) * s;
      G.cy = (e.clientY - r.top) * s;
    }
    G.moved = true;
  });
  c.addEventListener("wheel", (e) => {
    let dx = e.deltaX, dy = e.deltaY;
    if (e.deltaMode === 0) { dx /= 100; dy /= 100; }
    else if (e.deltaMode === 2) { dx *= 3; dy *= 3; }
    push({ t: "scroll", x: -dx, y: -dy });
    e.preventDefault();
  }, { passive: false });
  c.addEventListener("mouseenter", () => push({ t: "enter", v: 1 }));
  c.addEventListener("mouseleave", () => push({ t: "enter", v: 0 }));
  window.addEventListener("focus", () => { G.focused = 1; push({ t: "focus", v: 1 }); });
  window.addEventListener("blur", () => {
    G.focused = 0;
    // release everything so keys do not stick
    for (let k = 0; k < G.keys.length; k++) if (G.keys[k]) { G.keys[k] = 0; push({ t: "key", key: k, sc: SCANCODE[k] || 0, action: RELEASE, mods: 0 }); }
    push({ t: "focus", v: 0 });
  });
  document.addEventListener("pointerlockchange", () => {
    if (document.pointerLockElement !== c && G.cursorMode === CURSOR_DISABLED) {
      // The browser released the pointer (usually Escape): tell the game Escape was pressed so it pauses.
      push({ t: "key", key: 256, sc: SCANCODE[256], action: PRESS, mods: 0 });
      push({ t: "key", key: 256, sc: SCANCODE[256], action: RELEASE, mods: 0 });
    }
  });
  new ResizeObserver(() => measure()).observe(c);
  window.addEventListener("resize", () => measure());
  c.addEventListener("dragover", (e) => e.preventDefault());
  return c;
}
function lockPointer() {
  const c = G.canvas;
  try {
    const r = c.requestPointerLock({ unadjustedMovement: true });
    if (r && r.catch) r.catch(() => c.requestPointerLock());
  } catch (e) {
    try { c.requestPointerLock(); } catch (e2) {}
  }
}

// ---------------------------------------------------------------- init / window
F.glfwInit = () => {
  ensureCanvas();
  return 1;
};
F.glfwTerminate = () => {};
F.glfwInitHint = () => {};
F.glfwInitAllocator = () => {};
F.glfwGetVersion = (a, b, c) => { if (a) P.si32(a, 3); if (b) P.si32(b, 4); if (c) P.si32(c, 0); };
F.glfwGetVersionString = () => LW.staticCString("3.4.0 lwjgl-web");
F.glfwGetPlatform = () => 0x00060004; // X11
F.glfwPlatformSupported = (p) => (p === 0x00060004 || p === 0x00060005 ? 1 : 0);
F.glfwGetError = (desc) => { if (desc) P.sptr(desc, 0); return 0; };
F.glfwSetErrorCallback = (cb) => { const o = G.cb.error || 0; G.cb.error = cb; return o; };
F.glfwDefaultWindowHints = () => {};
F.glfwWindowHint = () => {};
F.glfwWindowHintString = () => {};
F.glfwCreateWindow = (w, h, title, monitor, share) => {
  ensureCanvas();
  G.title = LW.cstr(title) || "Minecraft";
  document.title = G.title;
  if (!G.gl) {
    const gl = G.canvas.getContext("webgl2", {
      alpha: false, depth: true, stencil: true, antialias: false, premultipliedAlpha: false,
      preserveDrawingBuffer: false, powerPreference: "high-performance", desynchronized: false,
    });
    if (!gl) {
      LW.warn("WebGL2 is not available");
      return 0;
    }
    G.gl = gl;
    LW.gl.attach(gl);
  }
  G.width = -1; G.height = -1; G.fbw = -1; G.fbh = -1;
  measure();
  G.events.length = 0; // size events before the game set callbacks are irrelevant
  G.created = true;
  G.canvas.focus();
  return WINDOW;
};
F.glfwDestroyWindow = () => {};
F.glfwShowWindow = () => {};
F.glfwHideWindow = () => {};
F.glfwFocusWindow = () => G.canvas && G.canvas.focus();
F.glfwRequestWindowAttention = () => {};
F.glfwMaximizeWindow = () => {};
F.glfwIconifyWindow = () => {};
F.glfwRestoreWindow = () => {};
F.glfwWindowShouldClose = () => G.shouldClose;
F.glfwSetWindowShouldClose = (w, v) => { G.shouldClose = v; };
F.glfwSetWindowTitle = (w, t) => { G.title = LW.cstr(t); document.title = G.title; };
F.glfwSetWindowIcon = () => {};
F.glfwSetWindowSizeLimits = () => {};
F.glfwSetWindowAspectRatio = () => {};
F.glfwSetWindowPos = () => {};
F.glfwSetWindowSize = () => {};
F.glfwGetWindowPos = (w, x, y) => { if (x) P.si32(x, 0); if (y) P.si32(y, 0); };
F.glfwGetWindowSize = (w, x, y) => { measure(); if (x) P.si32(x, G.width); if (y) P.si32(y, G.height); };
F.glfwGetFramebufferSize = (w, x, y) => { measure(); if (x) P.si32(x, G.fbw); if (y) P.si32(y, G.fbh); };
F.glfwGetWindowFrameSize = (w, l, t, r, b) => { for (const p of [l, t, r, b]) if (p) P.si32(p, 0); };
F.glfwGetWindowContentScale = (w, x, y) => { if (x) P.sf32(x, scale()); if (y) P.sf32(y, scale()); };
F.glfwGetWindowOpacity = () => 1;
F.glfwSetWindowOpacity = () => {};
F.glfwGetWindowAttrib = (w, a) => {
  if (a === 0x20001) return G.focused; // FOCUSED
  if (a === 0x20002) return 0; // ICONIFIED
  if (a === 0x20004) return 1; // VISIBLE
  if (a === 0x20003) return 1; // RESIZABLE
  if (a === 0x22002) return 3; // CONTEXT_VERSION_MAJOR
  if (a === 0x22003) return 3; // CONTEXT_VERSION_MINOR
  if (a === 0x22008) return 0x32001; // OPENGL_PROFILE core
  if (a === 0x22001) return 0x30001; // CLIENT_API OpenGL
  return 0;
};
F.glfwSetWindowAttrib = () => {};
F.glfwGetWindowMonitor = () => (document.fullscreenElement ? MONITOR : 0);
F.glfwSetWindowMonitor = (w, monitor) => {
  try {
    if (monitor && !document.fullscreenElement) G.canvas.requestFullscreen().catch(() => {});
    else if (!monitor && document.fullscreenElement) document.exitFullscreen().catch(() => {});
  } catch (e) {}
};
F.glfwSetWindowUserPointer = (w, p) => { G.user = p; };
F.glfwGetWindowUserPointer = () => G.user || 0;

// ---------------------------------------------------------------- monitors
function vidmodePtr() {
  if (!G.vidmode) G.vidmode = LW.calloc(24);
  const w = Math.round(screen.width * (LW.config.pixelRatio || 1)), h = Math.round(screen.height * (LW.config.pixelRatio || 1));
  [w, h, 8, 8, 8, 60].forEach((v, i) => P.si32(G.vidmode + i * 4, v));
  return G.vidmode;
}
F.glfwGetPrimaryMonitor = () => MONITOR;
F.glfwGetMonitors = (count) => {
  if (!G.monitorsArr) { G.monitorsArr = LW.calloc(8); P.sptr(G.monitorsArr, MONITOR); }
  if (count) P.si32(count, 1);
  return G.monitorsArr;
};
F.glfwGetVideoMode = () => vidmodePtr();
F.glfwGetVideoModes = (m, count) => { if (count) P.si32(count, 1); return vidmodePtr(); };
F.glfwGetMonitorName = () => LW.staticCString("Browser");
F.glfwGetMonitorPos = (m, x, y) => { if (x) P.si32(x, 0); if (y) P.si32(y, 0); };
F.glfwGetMonitorWorkarea = (m, x, y, w, h) => { if (x) P.si32(x, 0); if (y) P.si32(y, 0); if (w) P.si32(w, screen.width); if (h) P.si32(h, screen.height); };
F.glfwGetMonitorPhysicalSize = (m, w, h) => { if (w) P.si32(w, 527); if (h) P.si32(h, 296); };
F.glfwGetMonitorContentScale = (m, x, y) => { if (x) P.sf32(x, 1); if (y) P.sf32(y, 1); };
F.glfwSetMonitorCallback = (cb) => { const o = G.cb.monitor || 0; G.cb.monitor = cb; return o; };
F.glfwSetGamma = () => {};

// ---------------------------------------------------------------- context
F.glfwMakeContextCurrent = () => {};
F.glfwGetCurrentContext = () => (G.created ? WINDOW : 0);
F.glfwSwapInterval = () => {};
F.glfwExtensionSupported = (name) => (LW.gl.extensionList().includes(LW.cstr(name)) ? 1 : 0);
F.glfwGetProcAddress = (name) => LW.symbol(LW.cstr(name));
// Frame counter + small FPS overlay (top-left). LW.fps.value holds the last 1 s measurement.
LW.fps = {
  value: 0, frames: 0, t0: performance.now(), el: null,
  frame() {
    this.frames++;
    const now = performance.now();
    if (now - this.t0 >= 1000) {
      this.value = (this.frames * 1000) / (now - this.t0);
      this.frames = 0; this.t0 = now;
      if (!this.el && typeof document !== 'undefined') {
        this.el = document.createElement('div');
        this.el.style.cssText = 'position:fixed;left:6px;top:6px;z-index:99;font:12px monospace;color:#fff;background:rgba(0,0,0,.55);padding:2px 6px;border-radius:4px;pointer-events:none';
        document.body.appendChild(this.el);
      }
      if (this.el) this.el.textContent = this.value.toFixed(1) + ' fps';
    }
  },
};
F.glfwSwapBuffers = () =>
  new Promise((resolve) => {
    // Returning to the browser event loop presents the WebGL frame.
    LW.gl.endFrame && LW.gl.endFrame();
    LW.fps.frame();
    requestAnimationFrame(() => resolve(0));
  });
// Vulkan through GLFW: unsupported
F.glfwVulkanSupported = () => 0;
F.glfwGetRequiredInstanceExtensions = (count) => { if (count) P.si32(count, 0); return 0; };
F.glfwInitVulkanLoader = () => {};

// ---------------------------------------------------------------- input
F.glfwGetKey = (w, k) => (k >= 0 && k < 512 ? G.keys[k] : 0);
F.glfwGetMouseButton = (w, b) => G.mouse[b] || 0;
F.glfwGetCursorPos = (w, x, y) => { if (x) P.sf64(x, G.cx); if (y) P.sf64(y, G.cy); };
F.glfwSetCursorPos = (w, x, y) => { G.cx = x; G.cy = y; };
F.glfwGetInputMode = (w, mode) => (mode === CURSOR ? G.cursorMode : 0);
F.glfwSetInputMode = (w, mode, value) => {
  if (mode !== CURSOR) return;
  G.cursorMode = value;
  const c = G.canvas;
  if (value === CURSOR_DISABLED) lockPointer();
  else if (document.pointerLockElement === c) document.exitPointerLock();
  c.style.cursor = value === CURSOR_NORMAL ? (G.cursorCss || "default") : "none";
};
F.glfwRawMouseMotionSupported = () => 0;
F.glfwGetKeyName = (key, scancode) => {
  if (key >= 65 && key <= 90) return LW.staticCString(String.fromCharCode(key + 32));
  if (key >= 48 && key <= 57) return LW.staticCString(String.fromCharCode(key));
  const map = { 32: " ", 39: "'", 44: ",", 45: "-", 46: ".", 47: "/", 59: ";", 61: "=", 91: "[", 92: "\\", 93: "]", 96: "`" };
  if (map[key]) return LW.staticCString(map[key]);
  return 0;
};
F.glfwGetKeyScancode = (key) => SCANCODE[key] || -1;
const CURSORS = { 0x36001: "default", 0x36002: "text", 0x36003: "crosshair", 0x36004: "pointer", 0x36005: "ew-resize", 0x36006: "ns-resize",
  0x36007: "nwse-resize", 0x36008: "nesw-resize", 0x36009: "move", 0x3600a: "not-allowed" };
const cursorObjs = new Map();
let nextCursor = 0x40001000;
F.glfwCreateStandardCursor = (shape) => { const id = (nextCursor += 16); cursorObjs.set(id, CURSORS[shape] || "default"); return id; };
F.glfwCreateCursor = () => { const id = (nextCursor += 16); cursorObjs.set(id, "default"); return id; };
F.glfwDestroyCursor = (c) => cursorObjs.delete(c);
F.glfwSetCursor = (w, c) => {
  G.cursorCss = cursorObjs.get(c) || "default";
  if (G.cursorMode === CURSOR_NORMAL && G.canvas) G.canvas.style.cursor = G.cursorCss;
};
F.glfwGetClipboardString = () => {
  if (G.clipPtr) LW.free(G.clipPtr);
  G.clipPtr = LW.newCString(G.clipboard || "");
  return G.clipPtr;
};
F.glfwSetClipboardString = (w, s) => {
  G.clipboard = LW.cstr(s) || "";
  try { navigator.clipboard && navigator.clipboard.writeText(G.clipboard).catch(() => {}); } catch (e) {}
};
F.glfwGetTime = () => (performance.now() - G.startTime) / 1000;
F.glfwSetTime = (t) => { G.startTime = performance.now() - t * 1000; };
F.glfwGetTimerValue = () => Math.round(performance.now() * 1000);
F.glfwGetTimerFrequency = () => 1000000;
F.glfwJoystickPresent = () => 0;
F.glfwGetJoystickAxes = (j, c) => { if (c) P.si32(c, 0); return 0; };
F.glfwGetJoystickButtons = (j, c) => { if (c) P.si32(c, 0); return 0; };
F.glfwGetJoystickHats = (j, c) => { if (c) P.si32(c, 0); return 0; };
F.glfwJoystickIsGamepad = () => 0;
F.glfwSetJoystickCallback = () => 0;
F.glfwUpdateGamepadMappings = () => 1;
F.glfwSetPreeditCursorRectangle = () => {};
F.glfwGetPreeditCursorRectangle = () => {};
F.glfwResetPreeditText = () => {};

// ---------------------------------------------------------------- callbacks
const CALLBACKS = {
  glfwSetKeyCallback: "key", glfwSetCharCallback: "char", glfwSetCharModsCallback: "charmods",
  glfwSetMouseButtonCallback: "button", glfwSetCursorPosCallback: "cursorpos", glfwSetCursorEnterCallback: "enter",
  glfwSetScrollCallback: "scroll", glfwSetDropCallback: "drop", glfwSetWindowPosCallback: "pos",
  glfwSetWindowSizeCallback: "size", glfwSetWindowCloseCallback: "close", glfwSetWindowRefreshCallback: "refresh",
  glfwSetWindowFocusCallback: "focus", glfwSetWindowIconifyCallback: "iconify", glfwSetWindowMaximizeCallback: "maximize",
  glfwSetFramebufferSizeCallback: "fbsize", glfwSetWindowContentScaleCallback: "cscale",
  glfwSetPreeditCallback: "preedit", glfwSetIMEStatusCallback: "imestatus", glfwSetPreeditCandidateCallback: "candidate",
};
for (const [fn, key] of Object.entries(CALLBACKS)) {
  F[fn] = (w, cb) => {
    const o = G.cb[key] || 0;
    G.cb[key] = cb;
    // The page's real size may already differ from the size the window was created with, and that change was
    // queued before anyone listened: report the current size to a newly registered size callback.
    if (cb && G.canvas && (key === "size" || key === "fbsize")) {
      measure();
      if (key === "size") push({ t: "size", w: G.width, h: G.height });
      else push({ t: "fbsize", w: G.fbw, h: G.fbh });
    }
    return o;
  };
}

const call = LW.invokeCallback;
function dispatch(ev) {
  const c = G.cb;
  switch (ev.t) {
    case "key": return c.key && call(c.key, "piiii", [WINDOW, ev.key, ev.sc, ev.action, ev.mods]);
    case "char":
      if (c.char) call(c.char, "pi", [WINDOW, ev.cp]);
      if (c.charmods) call(c.charmods, "pii", [WINDOW, ev.cp, ev.mods]);
      return;
    case "button": return c.button && call(c.button, "piii", [WINDOW, ev.b, ev.action, ev.mods]);
    case "scroll": return c.scroll && call(c.scroll, "pdd", [WINDOW, ev.x, ev.y]);
    case "enter": return c.enter && call(c.enter, "pi", [WINDOW, ev.v]);
    case "focus": return c.focus && call(c.focus, "pi", [WINDOW, ev.v]);
    case "size": return c.size && call(c.size, "pii", [WINDOW, ev.w, ev.h]);
    case "fbsize": return c.fbsize && call(c.fbsize, "pii", [WINDOW, ev.w, ev.h]);
    case "clipboard": return ev.p;
  }
}
function pollEvents() {
  measure();
  const evs = G.events;
  G.events = [];
  let i = 0;
  for (; i < evs.length; i++) {
    const ev = evs[i];
    if (ev.t === "key" || ev.t === "button") {
      // Deliver mouse movement that happened before this event first.
      flushMove();
    }
    dispatch(ev);
  }
  flushMove();
}
function flushMove() {
  if (G.moved) {
    G.moved = false;
    if (G.cb.cursorpos) call(G.cb.cursorpos, "pdd", [WINDOW, G.cx, G.cy]);
  }
}
F.glfwPollEvents = () => pollEvents();
LW.glfwPollDeferred = () => { LW.deferUpcalls = true; try { pollEvents(); } finally { LW.deferUpcalls = false; } };
F.glfwWaitEvents = () => pollEvents();
F.glfwWaitEventsTimeout = () => pollEvents();
F.glfwPostEmptyEvent = () => {};
