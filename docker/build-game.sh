#!/bin/bash
# mc-web: build the browser version of Minecraft on this machine (MIT License).
#   build-game.sh <data-dir>
# Downloads Minecraft from Mojang into <data>/mc, compiles it to JavaScript with TeaVM and writes the finished
# game to <data>/site. Needs ~6 GB of free RAM for a few minutes.
set -eo pipefail
DATA=${1:-/data}
APP=${MCWEB_APP:-/opt/mcweb}
MC_VERSION=${MC_VERSION:-26.2}
export MC=$DATA/mc TVM_LIB=$APP/tvm/lib JVMDG=$APP/jvmdg.jar
L=$TVM_LIB
B=$APP/build
step() { echo "[build] $(date +%H:%M:%S) $*"; }

step "1/5 downloading Minecraft $MC_VERSION from Mojang"
python3 -I "$APP/docker/fetch-mojang.py" "$MC" "$MC_VERSION"

step "2/5 patching the game for the browser"
cd "$B"
./build-round.sh 2>&1 | grep -E "error:|classes=" || true
[ -s work/patched.jar ] || { echo "patching failed"; exit 1; }

step "3/5 compiling to JavaScript with TeaVM (the long part)"
rm -rf out && mkdir -p out
CP=$(ls "$L"/*.jar | tr '\n' ':')
java -Xmx${BUILD_HEAP:-6g} -Xss16m -XX:+UseSerialGC -Dtvm.lib="$L" -Dtvm.opt=${TEAVM_OPT:-SIMPLE} -Dtvm.fast=${TEAVM_FAST:-true} \
  -cp "$APP/tvm/drv:$CP" Spike / "$B/out" mcweb.rt.Boot "$B/work/cp.txt" 2>&1 | grep -E "PROBLEMS|Exception|Error" || true
if [ ! -s out/classes.js ]; then
  echo "TeaVM failed (out of memory? set BUILD_HEAP, e.g. 8g):"; grep -v "^\s*@" out/problems.txt 2>/dev/null | head -20; exit 1
fi

step "4/5 post-processing"
./postprocess.sh out/classes.js 2>&1 | grep -v -E "DeprecationWarning|body = re.sub" || true

step "5/5 assembling the site"
S=$DATA/site.new
rm -rf "$S" && mkdir -p "$S/js" "$S/mc/assets/indexes"
cp site/index.html site/worker.js "$S/"
cp web/js/* "$S/js/"
mv out/classes.js "$S/classes.js"
cp work/patched.jar.natives.json "$S/natives.json"
python3 -c "import json,sys; a=json.load(open('work/patched.jar.sigs.json')); a.update(json.load(open('work/rt-patched.jar.sigs.json'))); json.dump(a, open(sys.argv[1],'w'), separators=(',',':'))" "$S/sigs.json"
cp "$MC/client.jar" "$S/mc/client.jar"
cp "$MC"/assets/indexes/*.json "$S/mc/assets/indexes/"
for f in classes.js sigs.json natives.json; do gzip -6 -k -f "$S/$f"; done
echo "${MCWEB_BUILD_ID:-dev}" > "$S/.build-id"
rm -rf "$DATA/site.old"; [ -d "$DATA/site" ] && mv "$DATA/site" "$DATA/site.old"
mv "$S" "$DATA/site" && rm -rf "$DATA/site.old"
# the intermediate jars are large and only needed during a build
rm -rf work/patched.jar work/rt-patched.jar work/mc-bridge.jar work/rt.jar rt/out rt/out-mod out
step "done"
