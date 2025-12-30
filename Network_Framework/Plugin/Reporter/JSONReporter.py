import json
class JSONReporter:
    def report(self, data):
        print(json.dumps({"report": data}))