#!/bin/bash
# mc-web TeaVM build round (MIT License): patch jars, then run TeaVM.
set -e
cd "$(dirname "$0")"
MC=${MC:-/home/claude/run/mc-web/site/mc}
L=${TVM_LIB:-/home/claude/tvm/lib}
ASM=$L/asm-9.10.1.jar:$L/asm-tree-9.10.1.jar:$L/asm-analysis-9.10.1.jar:$L/asm-commons-9.10.1.jar:$L/asm-util-9.10.1.jar
mkdir -p work
JVMDG=${JVMDG:-/home/claude/jvmdg/jvmdowngrader-2.0.1-all.jar}
rm -rf rt/out-mod
# 1. JDK classes TeaVM lacks (from this JDK), minus the ones we replace
if [ ! -f work/jdk-extra.jar ]; then
  rm -rf work/jdk && mkdir -p work
JVMDG=${JVMDG:-/home/claude/jvmdg/jvmdowngrader-2.0.1-all.jar}
rm -rf rt/out-mod/jdk
  jimage extract --dir work/jdk --include 'regex:/java.base/java/util/concurrent/.*' "$(dirname "$(dirname "$(readlink -f "$(which java)")")")/lib/modules"
  (cd work/jdk/java.base && rm -f java/util/concurrent/ForkJoin*.class java/util/concurrent/locks/LockSupport.class java/util/concurrent/Executors*.class java/util/concurrent/ThreadPoolExecutor*.class java/util/concurrent/ScheduledThreadPoolExecutor*.class java/util/concurrent/CopyOnWriteArraySet*.class && jar cf ../../jdk-extra.jar java)
fi
# 2. runtime overlay
rm -rf rt/out && mkdir -p rt/out
javac -nowarn --release 21 -cp "$L/teavm-jso-0.16.0.jar:$L/teavm-classlib-0.16.0.jar:$L/teavm-jso-apis-0.16.0.jar:$L/teavm-interop-0.16.0.jar:$MC/libraries/slf4j-api-2.0.17.jar:$MC/libraries/oshi-core-6.9.0.jar" -d rt/out $(find rt/src -name "*.java") 2>&1 | grep -v -E "Picked|Note:" || true
javac -nowarn --release 21 -cp "rt/out:$L/teavm-jso-0.16.0.jar:$L/teavm-interop-0.16.0.jar:$MC/java15/client.jar:$MC/libraries/guava-33.6.0-jre.jar:$MC/libraries/gson-2.14.0.jar:$MC/libraries/netty-common-4.2.15.Final.jar:$MC/libraries/netty-transport-4.2.15.Final.jar:$MC/libraries/netty-buffer-4.2.15.Final.jar:$MC/java15/text2speech-1.19.12.jar:$MC/libraries/jopt-simple-5.0.4.jar:$MC/libraries/brigadier-1.3.10.jar:$MC/java15/datafixerupper-10.0.21.jar" -d rt/out $(find rt/src-mc -name "*.java") 2>&1 | grep -v -E "Picked|Note:" || true
for m in rt/src-mod/*; do
  mn=$(basename "$m")
  javac -nowarn --patch-module "$mn=$m" -d rt/out-mod/$mn $(find "$m" -name "*.java") 2>&1 | grep -v -E "Picked|Note:" || true
  cp -r rt/out-mod/$mn/* rt/out/
done
LWJGL_CP=$(ls $MC/libraries/lwjgl-*.jar | tr '\n' ':')
javac -nowarn --release 21 -cp "rt/out:$L/teavm-jso-0.16.0.jar:$L/teavm-interop-0.16.0.jar:$LWJGL_CP" -d rt/out $(find rt/src-lwjgl -name "*.java") 2>&1 | grep -v -E "Picked|Note:" || true
(cd rt/out && unzip -q -o "$JVMDG" 'xyz/wagyourtail/jvmdg/exc/*')
cp -r rt/res/* rt/out/
# classes that must be patched together with the game (they pass remapped game types)
rm -rf work/bridge && mkdir -p work/bridge/mcweb/rt && mv rt/out/mcweb/rt/game work/bridge/mcweb/rt/ && (cd work/bridge && jar cf ../mc-bridge.jar .)
(cd rt/out && jar cf ../../work/rt.jar .)
# 3. patch everything into one jar
JARS="work/jdk-extra.jar work/mc-bridge.jar"
while read -r f; do [ -n "$f" ] && JARS="$JARS $MC/$f"; done < cp-game.txt
java -Xmx3g -cp "patcher/out:$ASM" Patch rules.txt work/patched.jar $JARS 2>&1 | grep -v "Picked" | grep -v "^WARN" || true
java -Xmx1g -cp "patcher/out:$ASM" Patch rules-rt.txt work/rt-patched.jar work/rt.jar 2>&1 | grep -v -E "Picked|^WARN" || true
printf "%s\n%s\n" "$PWD/work/rt-patched.jar" "$PWD/work/patched.jar" > work/cp.txt
