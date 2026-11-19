# mc-web (MIT License): JVM class-initialization semantics for TeaVM output.
#  1. class-init locking across green threads (a suspended static initializer no longer exposes a half-built class)
#  2. superclass-before-subclass initialization (TeaVM only initializes the class itself)
import sys, re
p = sys.argv[1]; s = open(p).read()
if 'mcwebClinitWait(' in s:
    print('clinitlock: already applied'); sys.exit(0)
N = r'[\w$]+'
parent = dict(re.findall(r'^(' + N + r'), "[^"\n]*", -?\d+, (' + N + r'), \[', s, re.M))
defined = set(re.findall(r'(?:^|let |, ?)(' + N + r')_\$callClinit = \(\) => \{', s, re.M))
asyncs = set(re.findall(r'\$rt_java\.(' + N + r')_\$_teavm_clinitCalled_\$ = false;', s)) & defined
def ancestor(n):
    seen = 0; c = parent.get(n)
    while c and c != '0' and seen < 64:
        if c in defined and c != 'jl_Object': return c
        c = parent.get(c); seen += 1
    return None
E = re.escape
st = dict(lock=0, superAsync=0, superSimple=0, skipped=0)
def fix_async(m):
    n = m.group(1); f = '$rt_java.' + n + '_$_teavm_clinitCalled_$'
    body = m.group(0)
    body = body.replace('''    if ($rt_resuming()) {
        $ptr = $rt_nativeThread().pop();
    } else if (''' + f + ''') {
        return;
    }''', '''    if ($rt_resuming()) {
        $ptr = $rt_nativeThread().pop();
        if ($ptr === 99) { let t = $rt_nativeThread(); t.status = 0; mcwebClinitWait(''' + f + ''', t, $rt_getThread(), $rt_setThread); return; }
    } else if (''' + f + ''') {
        mcwebClinitWait(''' + f + ''', $rt_nativeThread(), $rt_getThread(), $rt_setThread);
        return;
    }''', 1)
    body = body.replace(f + ' = true; globalThis.mcwebClinitStart', f + ' = ($rt_nativeThread() || true); globalThis.mcwebClinitStart', 1)
    body = re.sub(r'(' + E(n) + r'_\$callClinit = \$rt_eraseClinit\((?:\$rt_java\.)?' + E(n) + r'\);)', lambda k: k.group(1) + ' ' + f + ' = true;', body, 1)
    body = body.replace('globalThis.mcwebClinitError("' + n + '", e); throw e;', 'globalThis.mcwebClinitError("' + n + '", e); ' + f + ' = true; throw e;', 1)
    st['lock'] += 1
    a = ancestor(n)
    if a:
        old = 'globalThis.mcwebClinitStart("' + n + '");\n        $ptr = 1;\n    case 1:'
        if old in body:
            body = body.replace(old, 'globalThis.mcwebClinitStart("' + n + '");\n        $ptr = 98;\n    case 98:\n        ' + a + '_$callClinit();\n        if ($rt_suspending()) {\n            break main;\n        }\n        $ptr = 1;\n    case 1:', 1)
            st['superAsync'] += 1
    return body
s = re.sub(r'^(?:let )?(' + N + r')_\$callClinit = \(\) => \{\n    let \$ptr = 0;.*?\n    \$rt_nativeThread\(\)\.push\(\$ptr\);\n\}', lambda m: fix_async(m) if m.group(1) in asyncs else m.group(0), s, flags=re.M | re.S)
def fix_simple(m):
    n = m.group(1); a = ancestor(n)
    if not a: return m.group(0)
    if a in asyncs: st['skipped'] += 1; return m.group(0)
    st['superSimple'] += 1
    return m.group(0).replace(m.group(2), a + '_$callClinit();\n    ' + m.group(2), 1)
s = re.sub(r'(' + N + r')_\$callClinit = \(\) => \{\n    \1_\$callClinit = \$rt_eraseClinit\((?:\$rt_java\.)?\1\);\n    ((?:\$rt_java\.)?\1__clinit_\(\);)', fix_simple, s)
open(p, 'w').write(s)
print('clinitlock: classes', len(defined), 'async', len(asyncs), 'parents', len(parent), st)
