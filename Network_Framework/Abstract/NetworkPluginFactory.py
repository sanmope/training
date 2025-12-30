from abc import ABC, abstractmethod

class NetworkPluginFactory(ABC):
    @abstractmethod
    def scanner_types(self):
        pass

    @abstractmethod
    def analyzer_types(self):
        pass

    @abstractmethod
    def reporter_types(self):
        pass

    @abstractmethod
    def create_scanner(self, type: str):
        pass

    @abstractmethod
    def create_analyzer(self, type: str):
        pass

    @abstractmethod
    def create_reporter(self, type: str):
        pass
