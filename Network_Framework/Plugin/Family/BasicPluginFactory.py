# Basic plugin family is a family of plugins that are used to create a basic network toolkit:
# it creates a scanner, an analyzer, and a reporter. Since there are several types of scanners, analyzers, and reporters,
# we need to create a factory class that creates the appropriate plugin based on the type of plugin requested.  


from Network_Framework.Plugin.Scanner.Port import PortScanner
from Network_Framework.Plugin.Scanner.Service import ServiceScanner
from Network_Framework.Plugin.Scanner.Protocol import ProtocolScanner
from Network_Framework.Plugin.Analyzer.Packet import PacketAnalyzer
from Network_Framework.Plugin.Analyzer.Network import NetworkAnalyzer
from Network_Framework.Plugin.Analyzer.Service import ServiceAnalyzer
from Network_Framework.Plugin.Reporter.Console import ConsoleReporter
from Network_Framework.Plugin.Reporter.HTML import HTMLReporter
from Network_Framework.Plugin.Reporter.JSON import JSONReporter
from Network_Framework.Abstract.NetworkPluginFactory import NetworkPluginFactory
from Network_Framework.Plugin.Analyzer.PacketAnalyzer import Analyzer


class BasicPluginFactory(NetworkPluginFactory):
    SCANNER_TYPES = {
        "port": PortScanner,
        "service": ServiceScanner,
        "protocol": ProtocolScanner
    }

    ANALYZER_TYPES = {
        "packet": PacketAnalyzer,
        "network": NetworkAnalyzer,
        "service": ServiceAnalyzer
    }

    REPORTER_TYPES = {
        "console": ConsoleReporter,
        "HTML": HTMLReporter,
        "JSON": JSONReporter
    }

    def scanner_types(self):
        return list(self.SCANNER_TYPES.keys())

    def analyzer_types(self):
        return list(self.ANALYZER_TYPES.keys())

    def reporter_types(self):
        return list(self.REPORTER_TYPES.keys())


    def create_scanner(self, type: str = "port"):
        if type in self.SCANNER_TYPES:
            return self.SCANNER_TYPES[type]()
        else:
            raise ValueError(f"Invalid scanner type: {type}")
        

    def create_analyzer(self, type: str = "packet"):
        if type in self.ANALYZER_TYPES:
            return self.ANALYZER_TYPES[type]()
        else:
            raise ValueError(f"Invalid analyzer type: {type}")


    def create_reporter(self, type: str = "console"):
        if type in self.REPORTER_TYPES:
            return self.REPORTER_TYPES[type]()
        else:
            raise ValueError(f"Invalid reporter type: {type}")
