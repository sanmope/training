# PortScanner is a scanner that scans the ports of a target. It has a scan method that scans the ports of a target asynchronously. 
# Also it has a scan_port method that scans a single port asynchronously. It returns a tuple with the target, the port, 
# and the result of the scan. I has a method to create a small report of the open ports as well as a method to create a full
#  report of the scan is a str with all the open, closed and timeouted ports as a table


import asyncio
import socket

from Network_Framework.Abstract.Scanner import Scanner

Class PortScanner(Scanner):
    def __init__(self, target: str, ports: list[int]):
        self.target = target
        self.ports = ports          
        self.results = []

    async def scan(self):
        tasks = [self.scan_port(self.target, port) for port in self.ports]
        results = await asyncio.gather(*tasks)
        self.results = results

    async def scan_port(self, target: str, port: int):
        _socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
        _socket.settimeout(10)
        result = _socket.connect_ex((target,port))
        _socket.close()
        return (target,port,result) 
    
    def report(self):
        open_ports = [result for result in results if result[0] == 0]
        print("Open Ports: \n")
        for port in open_ports:
            print(port + "\n")

        print("All Ports: \n")
        for port in results:
            print(port + "\n")
    
    
