#!/usr/bin/env python3
"""mc-web local server (MIT License).

Serves this folder on http://localhost:8090. Minecraft's sound files (and a few other assets) are not bundled:
the first time the game asks for one, it is downloaded from Mojang's asset server into mc/assets/objects and
cached there, so later runs work offline.
"""
import http.server
import os
import re
import socketserver
import sys
import subprocess
import threading
import urllib.request

PORT = int(os.environ.get("PORT", "8090"))
ROOT = os.path.dirname(os.path.abspath(__file__))
ASSET = re.compile(r"^/mc/assets/objects/([0-9a-f]{2})/([0-9a-f]{40})$")
MOJANG = "https://resources.download.minecraft.net/{}/{}"
lock = threading.Lock()


def download(url):
    """urllib first; fall back to curl (macOS python.org builds often lack SSL root certificates)."""
    try:
        with urllib.request.urlopen(url, timeout=30) as r:
            return r.read()
    except Exception as e:
        try:
            return subprocess.run(["curl", "-fsSL", "--max-time", "60", url], check=True, capture_output=True).stdout
        except Exception:
            raise e


class Handler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *a, **kw):
        super().__init__(*a, directory=ROOT, **kw)

    def log_message(self, fmt, *args):
        pass  # quiet

    def end_headers(self):
        # the page fetches everything itself; let the browser cache assets but always revalidate the game code
        if self.path.startswith("/mc/assets/objects/"):
            self.send_header("Cache-Control", "public, max-age=31536000, immutable")
        else:
            self.send_header("Cache-Control", "no-cache")
        super().end_headers()

    def do_GET(self):
        m = ASSET.match(self.path.split("?")[0])
        if m:
            local = os.path.join(ROOT, "mc", "assets", "objects", m.group(1), m.group(2))
            if not os.path.exists(local):
                try:
                    data = download(MOJANG.format(m.group(1), m.group(2)))
                    with lock:
                        os.makedirs(os.path.dirname(local), exist_ok=True)
                        tmp = local + ".part"
                        with open(tmp, "wb") as f:
                            f.write(data)
                        os.replace(tmp, local)
                except Exception as e:  # offline or unknown object
                    sys.stderr.write("asset download failed: %s (%s)\n" % (self.path, e))
                    self.send_error(404)
                    return
        super().do_GET()


class Server(socketserver.ThreadingMixIn, http.server.HTTPServer):
    daemon_threads = True
    allow_reuse_address = True


if __name__ == "__main__":
    print("mc-web: open http://localhost:%d in Chrome or Edge (Ctrl+C to stop)" % PORT)
    with Server(("", PORT), Handler) as s:
        try:
            s.serve_forever()
        except KeyboardInterrupt:
            pass
