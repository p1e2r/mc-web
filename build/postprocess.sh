#!/bin/bash
# mc-web: post-process TeaVM output (MIT License). Enables Java stack traces via mcwebDecodeStack.
f=$1
grep -q 'mcwebDecodeStack' "$f" || python3 - "$f" <<'PY'
import sys
p=sys.argv[1]; s=open(p).read()
for pre in ('$rt_java.', ''):   # SIMPLE builds namespace the runtime as $rt_java.*, ADVANCED/FULL don't
    a = pre + '$rt_fillStack = (err, ex) => {'
    i = s.find('\n' + a)
    if i >= 0:
        s = s[:i+1] + pre + '$rt_decodeStack = (s) => globalThis.mcwebDecodeStack(s);\n' + s[i+1:]
        break
else:
    print('postprocess: $rt_fillStack not found, stack decoding skipped')
open(p,'w').write(s)
PY
# log exceptions thrown by static initializers (TeaVM marks the class initialized before running <clinit>)
grep -q 'mcwebClinitError' "$f" || perl -0pi -e 's/(\n\s+)((?:\$rt_java\.)?([A-Za-z0-9_\$]+)__clinit_\(\);)(\n\s+if \(\$rt_suspending\(\)\) \{)/$1try { $2 } catch (e) { globalThis.mcwebClinitError("$3", e); throw e; }$4/g' "$f"
# remember where each class initialization started (debugging init-order problems)
grep -q 'mcwebClinitStart' "$f" || perl -pi -e 's/^(\s+)((?:\$rt_java\.)?([A-Za-z0-9_\$]+)_\$_teavm_clinitCalled_\$ = true;)$/$1$2 globalThis.mcwebClinitStart("$3");/' "$f"
grep -q 'globalThis.\$rt_java = \$rt_java' "$f" || python3 - "$f" <<'PY'
import sys
p=sys.argv[1]; s=open(p).read(); a='let $rt_java = {};'; b='let $rt_java = {}; globalThis.$rt_java = $rt_java;'
i=s.find('\n'+a)
assert i>=0, 'pattern not found: '+a
s=s[:i+1]+b+s[i+1+len(a):]
open(p,'w').write(s)
PY
# debugging hook: green-thread suspensions
grep -q 'mcwebOnSuspend' "$f" || python3 - "$f" <<'PY'
import sys
p=sys.argv[1]; s=open(p).read(); a='TeaVMThread.prototype.suspend = function(callback) {'; b='TeaVMThread.prototype.suspend = function(callback) { if (globalThis.mcwebOnSuspend) globalThis.mcwebOnSuspend(this);'
i=s.find('\n'+a)
assert i>=0, 'pattern not found: '+a
s=s[:i+1]+b+s[i+1+len(a):]
open(p,'w').write(s)
PY
python3 - "$f" <<'PY'
import sys
p=sys.argv[1]; s=open(p).read()
old="""        result = this.runner();
    } catch (e){
        result = e;"""
if 'green thread died' not in s and old in s:
    s=s.replace(old, old+""" try { console.error('[mcweb] green thread died: ' + e + '\\n' + (e && e.stack)); } catch (e2) {}""",1)
    open(p,'w').write(s)
PY
python3 - "$f" <<'PY'
import sys, re
p=sys.argv[1]; s=open(p).read()
if 'mcwebSetTimeout(' not in s:
    s=re.sub(r'(?<![\w.$])setTimeout\(', 'mcwebSetTimeout(', s)
    s=re.sub(r'(?<![\w.$])clearTimeout\(', 'mcwebClearTimeout(', s)
    open(p,'w').write(s)
PY
python3 "$(dirname "$0")/clinitlock.py" "$f"
python3 "$(dirname "$0")/threadid.py" "$f"
