#!/bin/bash
# mc-web container entrypoint (MIT License): page server, multiplayer relay, and a one-time build of the game.
set -uo pipefail
DATA=/data
APP=/opt/mcweb
WANT="$(cat "$APP/BUILD_ID" 2>/dev/null || echo dev)-${MC_VERSION:-26.2}-${TEAVM_OPT:-SIMPLE}"
export MCWEB_BUILD_ID="$WANT"
mkdir -p "$DATA/assets/tmp" "$DATA/mc"
touch "$DATA/build.log"
chown -R www-data:www-data "$DATA/assets"   # nginx workers store downloaded sounds there

# 1) multiplayer relay (only with Cloudflare Access configured, or explicitly without auth)
if [ -n "${CF_TEAM_DOMAIN:-}" ] && [ -n "${CF_ACCESS_AUD:-}" ] || [ "${INSECURE_NO_AUTH:-}" = "1" ]; then
  (cd "$APP/relay" && while true; do node relay.js; echo "[relay] exited, restarting in 3 s"; sleep 3; done) &
else
  echo "[mc-web] multiplayer relay is OFF: set CF_TEAM_DOMAIN + CF_ACCESS_AUD (Cloudflare Access), or INSECURE_NO_AUTH=1 for a trusted LAN"
fi

# the page's own files (HTML/JS) don't need a recompile: always use the image's current copies
sync_web() {
  [ -d "$DATA/site" ] || return 0
  cp "$APP/build/site/index.html" "$APP/build/site/worker.js" "$DATA/site/" && cp "$APP/build/web/js/"* "$DATA/site/js/"
}

# 2) page server: the finished game if it is up to date, otherwise the "setting up" page
have=$(cat "$DATA/site/.build-id" 2>/dev/null || true)
if [ "$have" = "$WANT" ] && [ "${FORCE_REBUILD:-}" != "1" ]; then
  sync_web
  ln -sfn "$DATA/site" /srv/current
  echo "[mc-web] game is built ($WANT); serving on :8090"
  exec nginx -g "daemon off;"
fi
if [ -d "$DATA/site" ] && [ -s "$DATA/site/classes.js" ]; then
  sync_web
  ln -sfn "$DATA/site" /srv/current   # keep serving the previous build while the new one compiles
else
  ln -sfn "$APP/building" /srv/current
fi
nginx

# 3) build the game (first start, or after an image update)
echo "[mc-web] building the game ($WANT). First start takes ~5-20 minutes; progress: http://<host>:8090/"
: > "$DATA/build.log"
if "$APP/docker/build-game.sh" "$DATA" 2>&1 | tee -a "$DATA/build.log"; then
  ln -sfn "$DATA/site" /srv/current
  nginx -s reload
  echo "[mc-web] ready on :8090"
else
  echo "[build] BUILD FAILED" | tee -a "$DATA/build.log"
  echo "[mc-web] the build failed; the page shows the log. Fix the cause (usually memory: BUILD_HEAP / Docker memory), then restart."
fi

# keep the container running as long as nginx does
while kill -0 "$(cat /run/nginx.pid 2>/dev/null)" 2>/dev/null; do sleep 5; done
echo "[mc-web] nginx stopped"
exit 1
