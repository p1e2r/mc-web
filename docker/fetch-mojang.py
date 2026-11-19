#!/usr/bin/env python3
"""mc-web: download Minecraft Java Edition from Mojang's own servers onto this machine (MIT License).

Nothing of Mojang's is shipped in the mc-web image: client.jar, its libraries and the asset index are fetched
here, checked against the SHA-1 sums in Mojang's version manifest, and only used on this machine.

  fetch-mojang.py <dest-dir> [version]

Writes <dest>/client.jar, <dest>/libraries/*.jar, <dest>/assets/indexes/<id>.json, <dest>/version.json and
<dest>/java15/ (copies of the jars javac needs, with the class-file version lowered to 65 so a Java 21 javac can read
their signatures; the bytecode itself is never run from these copies).
"""
import concurrent.futures as cf
import hashlib
import json
import os
import sys
import urllib.request
import zipfile

MANIFEST = "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json"
COMPILE_ONLY = ["client.jar", "libraries/text2speech-1.19.12.jar", "libraries/datafixerupper-10.0.21.jar"]


def log(*a):
    print("[mojang]", *a, flush=True)


def sha1_of(path):
    h = hashlib.sha1()
    with open(path, "rb") as f:
        for b in iter(lambda: f.read(1 << 20), b""):
            h.update(b)
    return h.hexdigest()


def fetch(url, dest=None, sha1=None, tries=4):
    if dest and os.path.exists(dest) and (not sha1 or sha1_of(dest) == sha1):
        return None
    last = None
    for _ in range(tries):
        try:
            with urllib.request.urlopen(urllib.request.Request(url, headers={"User-Agent": "mc-web"}), timeout=60) as r:
                data = r.read()
            if sha1 and hashlib.sha1(data).hexdigest() != sha1:
                raise IOError("checksum mismatch for " + url)
            if not dest:
                return data
            os.makedirs(os.path.dirname(dest), exist_ok=True)
            with open(dest + ".part", "wb") as f:
                f.write(data)
            os.replace(dest + ".part", dest)
            return None
        except Exception as e:  # retry flaky downloads
            last = e
    raise SystemExit(f"download failed: {url}: {last}")


def allowed(lib):
    ok = True
    for rule in lib.get("rules", []):
        hit = "os" not in rule or rule["os"].get("name") == "linux"
        if hit:
            ok = rule["action"] == "allow"
    return ok


def lower_class_version(src, dst, major=65):
    """copy a jar, rewriting every class file's major version (javac only reads the signatures)."""
    tmp = dst + ".part"
    with zipfile.ZipFile(src) as zi, zipfile.ZipFile(tmp, "w", zipfile.ZIP_DEFLATED) as zo:
        for info in zi.infolist():
            b = zi.read(info)
            if info.filename.endswith(".class") and len(b) > 8 and b[:4] == b"\xca\xfe\xba\xbe":
                b = b[:6] + major.to_bytes(2, "big") + b[8:]
            zo.writestr(info, b)
    os.replace(tmp, dst)


def main():
    dest = os.path.abspath(sys.argv[1])
    version = sys.argv[2] if len(sys.argv) > 2 else "26.2"
    manifest = json.loads(fetch(MANIFEST))
    entry = next((v for v in manifest["versions"] if v["id"] == version), None)
    if not entry:
        raise SystemExit(f"unknown Minecraft version {version}")
    vjson = json.loads(fetch(entry["url"], sha1=entry.get("sha1")))
    os.makedirs(dest, exist_ok=True)
    with open(os.path.join(dest, "version.json"), "w") as f:
        json.dump(vjson, f)

    c = vjson["downloads"]["client"]
    log(f"Minecraft {version}: client.jar")
    fetch(c["url"], os.path.join(dest, "client.jar"), c["sha1"])

    jobs = []
    for lib in vjson["libraries"]:
        art = lib.get("downloads", {}).get("artifact")
        if not art or not allowed(lib) or ":natives-" in lib["name"]:
            continue
        jobs.append((art["url"], os.path.join(dest, "libraries", os.path.basename(art["path"])), art.get("sha1")))
    log(f"{len(jobs)} libraries")
    with cf.ThreadPoolExecutor(8) as ex:
        list(ex.map(lambda j: fetch(*j), jobs))

    ai = vjson["assetIndex"]
    fetch(ai["url"], os.path.join(dest, "assets", "indexes", ai["id"] + ".json"), ai["sha1"])
    log(f"asset index {ai['id']}")

    os.makedirs(os.path.join(dest, "java15"), exist_ok=True)
    for rel in COMPILE_ONLY:
        src = os.path.join(dest, rel)
        out = os.path.join(dest, "java15", os.path.basename(rel))
        if not os.path.exists(out) or os.path.getmtime(out) < os.path.getmtime(src):
            lower_class_version(src, out)
    log("done")


if __name__ == "__main__":
    main()
