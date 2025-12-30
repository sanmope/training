from abc import ABC, abstractmethod

class Analyzer(NetworkTook):
    @abstractmethod
    def analyze(self):
        pass
