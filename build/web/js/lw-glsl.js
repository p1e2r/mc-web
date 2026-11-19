// lwjgl-web: GLSL 1.50/3.30 core -> GLSL ES 3.00 translation. MIT License.
const LW = globalThis.LWJGLWeb;

const PRECISION = [
  "precision highp float;", "precision highp int;", "precision highp sampler2D;", "precision highp isampler2D;",
  "precision highp usampler2D;", "precision highp sampler2DArray;", "precision highp isampler2DArray;",
  "precision highp usampler2DArray;", "precision highp sampler3D;", "precision highp isampler3D;", "precision highp usampler3D;",
  "precision highp samplerCube;", "precision highp isamplerCube;", "precision highp usamplerCube;",
  "precision highp sampler2DShadow;", "precision highp samplerCubeShadow;", "precision highp sampler2DArrayShadow;",
].join("\n");

// Functions that exist in desktop GLSL 3.30 (or ES 3.1) but not in GLSL ES 3.00.
const POLYFILLS = {
  packUnorm4x8: "uint packUnorm4x8(vec4 v){uvec4 u=uvec4(round(clamp(v,0.0,1.0)*255.0));return u.x|(u.y<<8)|(u.z<<16)|(u.w<<24);}",
  unpackUnorm4x8: "vec4 unpackUnorm4x8(uint p){return vec4(float(p&255u),float((p>>8)&255u),float((p>>16)&255u),float((p>>24)&255u))/255.0;}",
  packSnorm4x8: "uint packSnorm4x8(vec4 v){ivec4 i=ivec4(round(clamp(v,-1.0,1.0)*127.0));uvec4 u=uvec4(i)&255u;return u.x|(u.y<<8)|(u.z<<16)|(u.w<<24);}",
  unpackSnorm4x8: "vec4 unpackSnorm4x8(uint p){ivec4 i=ivec4(int(p<<24)>>24,int(p<<16)>>24,int(p<<8)>>24,int(p)>>24);return clamp(vec4(i)/127.0,-1.0,1.0);}",
  bitfieldExtract: "int bitfieldExtract(int v,int o,int b){return b==0?0:(v<<(32-o-b))>>(32-b);}\nuint bitfieldExtract(uint v,int o,int b){return b==0?0u:(v>>uint(o))&((b==32)?0xFFFFFFFFu:((1u<<uint(b))-1u));}",
  findMSB: "int findMSB(uint v){if(v==0u)return -1;int r=0;for(int i=31;i>=0;i--){if((v>>uint(i))!=0u){r=i;break;}}return r;}\nint findMSB(int v){return v<0?findMSB(uint(~v)):findMSB(uint(v));}",
  findLSB: "int findLSB(uint v){if(v==0u)return -1;for(int i=0;i<32;i++){if(((v>>uint(i))&1u)!=0u)return i;}return -1;}\nint findLSB(int v){return findLSB(uint(v));}",
  bitCount: "int bitCount(uint v){v=v-((v>>1)&0x55555555u);v=(v&0x33333333u)+((v>>2)&0x33333333u);return int((((v+(v>>4))&0x0F0F0F0Fu)*0x01010101u)>>24);}\nint bitCount(int v){return bitCount(uint(v));}",
  fma: "float fma(float a,float b,float c){return a*b+c;}\nvec2 fma(vec2 a,vec2 b,vec2 c){return a*b+c;}\nvec3 fma(vec3 a,vec3 b,vec3 c){return a*b+c;}\nvec4 fma(vec4 a,vec4 b,vec4 c){return a*b+c;}",
};

// Find the end of a balanced parenthesised argument list starting at s[i] === "(".
function matchParen(s, i) {
  let depth = 0;
  for (let j = i; j < s.length; j++) {
    if (s[j] === "(") depth++;
    else if (s[j] === ")") { depth--; if (depth === 0) return j; }
  }
  return -1;
}
function splitTopLevel(s) {
  const out = [];
  let depth = 0, last = 0;
  for (let i = 0; i < s.length; i++) {
    const c = s[i];
    if (c === "(" || c === "[") depth++;
    else if (c === ")" || c === "]") depth--;
    else if (c === "," && depth === 0) { out.push(s.slice(last, i)); last = i + 1; }
  }
  out.push(s.slice(last));
  return out;
}

function translate(src, type) {
  let s = src.replace(/\r\n?/g, "\n");
  s = s.replace(/^[ \t]*#version[^\n]*$/gm, "");
  s = s.replace(/^[ \t]*#extension[^\n]*$/gm, "");
  s = s.replace(/\bnoperspective\b/g, "");
  s = s.replace(/\btexture2D\b/g, "texture").replace(/\btexture2DLod\b/g, "textureLod");
  // desktop "precision" qualifiers are fine; "layout(binding = N)" is GLSL 4.2, strip it
  s = s.replace(/layout\s*\(([^)]*)\)/g, (m, inner) => {
    const parts = inner.split(",").map((x) => x.trim()).filter((x) => !/^binding\s*=/.test(x));
    return parts.length ? `layout(${parts.join(", ")})` : "";
  });
  // Buffer textures -> 2D textures, indexed through a 4096-wide grid (see glTexBuffer in lw-gl.js).
  const bufferSamplers = [];
  s = s.replace(/\b(i|u)?samplerBuffer\s+(\w+)/g, (m, p, name) => {
    bufferSamplers.push(name);
    return `${p || ""}sampler2D ${name}`;
  });
  if (bufferSamplers.length) {
    let out = "";
    let i = 0;
    const re = /\btexelFetch\s*\(/g;
    let m;
    while ((m = re.exec(s))) {
      const open = m.index + m[0].length - 1;
      const close = matchParen(s, open);
      if (close < 0) break;
      const args = splitTopLevel(s.slice(open + 1, close));
      if (args.length === 2 && bufferSamplers.includes(args[0].trim())) {
        out += s.slice(i, m.index) + `texelFetch(${args[0].trim()}, ivec2((${args[1]}) % 4096, (${args[1]}) / 4096), 0)`;
        i = close + 1;
        re.lastIndex = close + 1;
      }
    }
    s = out + s.slice(i);
  }
  // Insert the implicit int->float conversions desktop GLSL allows (type-aware AST pass, lw-glslfix.js)
  if (LW.glslFix) {
    try {
      s = LW.glslFix(s, type);
    } catch (e) {
      LW.warn("GLSL conversion pass failed, compiling unmodified:", e && e.message);
      if (!LW._glslDumped) { LW._glslDumped = true; console.log("[lwjgl-web] GLSLSRC " + JSON.stringify(s)); }
    }
  }
  // Polyfills for functions missing from ES 3.00
  let poly = "";
  for (const [name, code] of Object.entries(POLYFILLS)) {
    if (new RegExp("\\b" + name + "\\s*\\(").test(s) && !new RegExp("\\b(uint|int|vec4|float)\\s+" + name + "\\s*\\(").test(s)) poly += code + "\n";
  }
  // gl_FragColor / gl_FragData (compat) -> explicit output
  let extra = "";
  if (type === 0x8b30 && /\bgl_Frag(Color|Data)\b/.test(s) && !/\bout\s+vec4\b/.test(s)) {
    extra = "out vec4 lwjgl_FragColor;\n";
    s = s.replace(/\bgl_FragColor\b/g, "lwjgl_FragColor").replace(/\bgl_FragData\s*\[\s*0\s*\]/g, "lwjgl_FragColor");
  }
  return "#version 300 es\n" + PRECISION + "\n" + extra + poly + "#line 1\n" + s;
}

LW.glsl = { translate };
