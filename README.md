# mc-web

Real **Minecraft Java Edition 26.2** running in the browser: the actual game compiled to JavaScript with
[TeaVM](https://teavm.org), with WebGL2 graphics, Web Audio sound, worlds saved in the browser, a singleplayer
world server in a Web Worker, and multiplayer through a small WebSocket relay.

> **No Minecraft files are in this repository or the Docker image.** The container downloads Minecraft from
> Mojang's own servers and compiles it on your machine the first time it starts. Minecraft is a trademark of
> Mojang Synergies AB; this project is not affiliated with Mojang or Microsoft.

## Run it

```yaml
# compose.yml
services:
  mc-web:
    image: ghcr.io/p1e2r/mc-web:latest
    container_name: mc-web
    restart: unless-stopped
    ports: ["8090:8090"]
    volumes: ["./data:/data"]
```

```sh
docker compose up -d
```

Open `http://<your machine>:8090`.

- **First start:** the page shows a progress log while the container downloads Minecraft and compiles it.
  That takes about 5–20 minutes and needs about **8 GB of free RAM** for a few minutes. The page reloads into the
  game when it's done.
- **Later starts** are instant. After an image update the game is only recompiled if the compiler inputs changed
  (the old build keeps being served meanwhile).
- Use Chrome or Edge. Click in the game to capture the mouse.

## Multiplayer

Browsers can't open raw TCP connections, so the container includes a relay (WebSocket → Minecraft server) at
`/relay` on the same port. It's **off by default**. Turn it on with a `.env` next to `compose.yml`
(see [`.env.example`](.env.example)):

- **Behind Cloudflare Access** (recommended for anything public): set `CF_TEAM_DOMAIN`, `CF_ACCESS_AUD` and
  `PUBLIC_HOST`, then point a Cloudflare Tunnel at `http://<host>:8090`. Every relay connection must carry a valid
  Access login.
- **Trusted LAN only:** `INSECURE_NO_AUTH=1`.

`ALLOWED_TARGETS=*` allows any public server (private/LAN addresses stay blocked unless listed by name, e.g.
`*,smp=my-minecraft-container:25565`). Only **offline-mode** (cracked) servers work: the browser version can't do
Microsoft login. In the game use Multiplayer → Direct Connection and type the server address as usual.

## Settings (environment)

| Variable | Default | |
|---|---|---|
| `BUILD_HEAP` | `6g` | Java memory for the one-time compile; raise to `8g` if the log says it ran out |
| `FORCE_REBUILD` | – | `1` = recompile on next start |
| `ALLOWED_TARGETS` | `*` | servers the relay may connect to |
| `CF_TEAM_DOMAIN`, `CF_ACCESS_AUD`, `PUBLIC_HOST` | – | Cloudflare Access for the relay |
| `INSECURE_NO_AUTH` | – | `1` = relay without login (trusted networks only) |
| `MAX_CONNECTIONS_PER_USER`, `IDLE_TIMEOUT_SECONDS`, `ALLOWED_EMAILS` | `3`, `300`, – | relay limits |

## How it works

1. `docker/fetch-mojang.py` downloads `client.jar`, its libraries and the asset index from Mojang (SHA-1 checked).
2. `build/build-round.sh` compiles mc-web's runtime (threads, files, networking, LWJGL→WebGL/OpenAL glue) and
   rewrites the game's bytecode with `build/patcher` according to `build/rules.txt`.
3. TeaVM compiles everything to one `classes.js`; `build/postprocess.sh` patches TeaVM's runtime (class-init
   locks, green-thread fixes).
4. nginx serves the result; sounds are fetched from Mojang on first use and cached in the volume.

## License

mc-web's code is MIT licensed ([LICENSE](LICENSE)). Third-party components are listed in [NOTICE](NOTICE).
