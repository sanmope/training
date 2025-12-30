from abc import ABC, abstractmethod

class Scanner(NetworkTook):
    @abstractmethod
    def scan(self):
        pass

