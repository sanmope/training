from abc import ABC, abstractmethod
class NetworkTook(ABC):
    @abstractmethod
    def execute(self):
        pass
    @abstractmethod
    def get_results(self):
        pass
