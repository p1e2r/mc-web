# mc-web: Minecraft Java Edition in the browser, self-hosted (MIT License).
# This image contains only mc-web's own code and open-source tools. Minecraft itself is downloaded from Mojang
# and compiled on YOUR machine the first time the container starts (see docker/entrypoint.sh).
FROM eclipse-temurin:21-jdk-noble

RUN apt-get update \
 && apt-get install -y --no-install-recommends nginx python3 nodejs npm unzip ca-certificates curl \
 && rm -rf /var/lib/apt/lists/* /etc/nginx/sites-enabled/default

ARG JVMDG_VERSION=2.0.1
WORKDIR /opt/mcweb
COPY tvm/ tvm/
COPY build/ build/
COPY relay/ relay/
COPY docker/ docker/

# tools that don't depend on Minecraft are prepared at image build time
RUN set -e; L=tvm/lib; \
    curl -fsSL -o jvmdg.jar "https://repo1.maven.org/maven2/xyz/wagyourtail/jvmdowngrader/jvmdowngrader/${JVMDG_VERSION}/jvmdowngrader-${JVMDG_VERSION}-all.jar"; \
    javac -nowarn -cp "$(ls $L/*.jar | tr '\n' ':')" -d tvm/drv tvm/drv/Spike.java; \
    mkdir -p build/patcher/out; \
    javac -nowarn -cp "$L/asm-9.10.1.jar:$L/asm-tree-9.10.1.jar:$L/asm-analysis-9.10.1.jar:$L/asm-commons-9.10.1.jar:$L/asm-util-9.10.1.jar" \
      -d build/patcher/out build/patcher/src/Patch.java; \
    cd relay && npm install --omit=dev --no-audit --no-fund && cd ..; \
    mkdir -p building /srv && cp docker/building.html building/index.html && cp docker/nginx.conf /etc/nginx/nginx.conf; \
    chmod +x docker/*.sh docker/*.py build/*.sh; \
    (cd /opt/mcweb && find build tvm docker/build-game.sh docker/fetch-mojang.py -type f \
       ! -path 'build/web/*' ! -path 'build/site/*' ! -path 'build/patcher/out/*' ! -path 'tvm/drv/*.class' -print0 \
       | sort -z | xargs -0 sha1sum | sha1sum | cut -c1-12) > BUILD_ID; \
    chmod -R a+rX /opt/mcweb

ENV MC_VERSION=26.2 \
    BUILD_HEAP=6g \
    ALLOWED_TARGETS=*

VOLUME /data
EXPOSE 8090
HEALTHCHECK --interval=30s --timeout=5s --start-period=60s CMD curl -fs http://127.0.0.1:8090/ >/dev/null || exit 1
# The game is only recompiled when BUILD_ID (a hash of everything that goes into classes.js) changes.
ENTRYPOINT ["/opt/mcweb/docker/entrypoint.sh"]
