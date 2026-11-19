# mc-web (MIT License): each TeaVM green thread always resumes as its own Java thread (Thread.currentThread()).
import sys
p = sys.argv[1]; s = open(p).read()
if 'mcwebJT' in s:
    print('threadid: already applied'); sys.exit(0)
a = "TeaVMThread.prototype.suspend = function(callback) {"
assert a in s
s = s.replace(a, a + " if (!this.mcwebJT) this.mcwebJT = $rt_getThread();", 1)
b = """TeaVMThread.prototype.run = function() {
    $rt_currentNativeThread = this;"""
assert b in s
s = s.replace(b, b + "\n    if (this.mcwebJT) $rt_setThread(this.mcwebJT);", 1)
open(p, 'w').write(s)
print('threadid: applied')
