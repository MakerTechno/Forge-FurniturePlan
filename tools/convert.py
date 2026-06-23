import json
import sys

def convert_model(json_file):
    with open(json_file, "r", encoding="utf-8") as f:
        data = json.load(f)

    for elem in data.get("elements", []):
        name = elem.get("name", "unnamed")
        from_ = elem["from"]
        to = elem["to"]
        x, y, z = from_
        w, h, d = to[0] - x, to[1] - y, to[2] - z

        print(f'// Element: {name}')
        print(f'CubeDefinition {name} = new CubeDefinition()')
        print(f'    .model({x}f, {y}f, {z}f, {w}f, {h}f, {d}f)')

        for dir, face in elem.get("faces", {}).items():
            u0, v0, u1, v1 = face["uv"]
            print(f'    .{dir}({u0}f, {v0}f, {u1}f, {v1}f)')

        print(f'    .build();\n')

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python convert_model.py model.json")
    else:
        convert_model(sys.argv[1])
