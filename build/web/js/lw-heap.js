// mc-web native heap for the TeaVM build (MIT License).
// "Native" memory is one resizable ArrayBuffer. Pointers are byte offsets into it. Java direct buffers are views of
// this same buffer (see mcweb.rt.Mem / TMcwebNio), so Java, LWJGL and WebGL share memory without copies.
(function () {
  const LW = (globalThis.LWJGLWeb = globalThis.LWJGLWeb || {});
  // Fixed size: WebGL rejects views of resizable ArrayBuffers, so the heap cannot grow.
  const cfg = Object.assign({ heapMB: 768 }, LW.config || {});
  const buf = new ArrayBuffer(cfg.heapMB * 1048576);
  LW.H = { buf, dv: new DataView(buf), u8: new Uint8Array(buf) };

  // Size classes: 16-byte steps up to 4 KB (free stacks per class), page-rounded first-fit above that.
  const SMALL = 4096;
  const bins = [];
  for (let i = 0; i <= SMALL >> 4; i++) bins.push([]);
  const large = []; // sorted [addr, size]
  const sizes = new Map(); // addr -> rounded size
  const aliases = new Map(); // aligned addr -> real addr
  let top = 4096; // keep page 0 unused so address 0 stays NULL
  let used = 0;

  function grow(need) {
    if (need > buf.byteLength) throw new Error(`[mc-web] native heap exhausted (${need} bytes needed, heap is ${cfg.heapMB} MB; raise LWJGLWeb.config.heapMB)`);
  }
  function bump(n) {
    const a = top;
    grow(a + n);
    top += n;
    return a;
  }
  function malloc(n) {
    n = n > 0 ? n : 1;
    let a, s;
    if (n <= SMALL) {
      s = (n + 15) & ~15;
      const bin = bins[s >> 4];
      a = bin.length ? bin.pop() : bump(s);
    } else {
      s = (n + 4095) & ~4095;
      a = 0;
      for (let i = 0; i < large.length; i++) {
        const f = large[i];
        if (f[1] >= s) {
          a = f[0];
          if (f[1] === s) large.splice(i, 1);
          else { f[0] += s; f[1] -= s; }
          break;
        }
      }
      if (!a) a = bump(s);
    }
    sizes.set(a, s);
    used += s;
    return a;
  }
  function free(p) {
    if (!p) return;
    const real = aliases.get(p);
    if (real !== undefined) { aliases.delete(p); p = real; }
    const s = sizes.get(p);
    if (s === undefined) return LW.warnOnce ? LW.warnOnce("badfree" + p, "free of unknown pointer", p) : undefined;
    sizes.delete(p);
    used -= s;
    if (s <= SMALL) { bins[s >> 4].push(p); return; }
    let i = 0;
    while (i < large.length && large[i][0] < p) i++;
    large.splice(i, 0, [p, s]);
    if (i + 1 < large.length && large[i][0] + large[i][1] === large[i + 1][0]) { large[i][1] += large[i + 1][1]; large.splice(i + 1, 1); }
    if (i > 0 && large[i - 1][0] + large[i - 1][1] === large[i][0]) { large[i - 1][1] += large[i][1]; large.splice(i, 1); }
  }
  function calloc(n, s) {
    const total = n * (s === undefined ? 1 : s);
    const p = malloc(total);
    LW.H.u8.fill(0, p, p + total);
    return p;
  }
  function blockSize(p) {
    const real = aliases.get(p);
    return real !== undefined ? sizes.get(real) - (p - real) : sizes.get(p) || 0;
  }
  function realloc(p, n) {
    if (!p) return malloc(n);
    const old = blockSize(p);
    if (n <= old && !aliases.has(p)) return p;
    const q = malloc(n);
    LW.H.u8.copyWithin(q, p, p + Math.min(old, n));
    free(p);
    return q;
  }
  function aligned(al, n) {
    if (al <= 16) return malloc(n);
    const real = malloc(n + al);
    const a = Math.ceil(real / al) * al;
    if (a !== real) aliases.set(a, real);
    return a;
  }
  LW.heap = { malloc, calloc, realloc, free, aligned, blockSize, owns: (p) => sizes.has(p) || aliases.has(p), stats: () => ({ top, used }) };
})();
