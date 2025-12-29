#Crear un script que escanee los puerto tcp de una ip especifica, o localhost, y hacerlo con multithreading (concurrency)

import asyncio
import socket
import time

async def scan_port(host, port):
    _socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    _socket.settimeout(10)

    result = _socket.connect_ex((host,port))

    if result == 0:
        print(result, port)
    _socket.close()
    



async def scan_all_ports():
    tasks = [scan_port('127.0.0.1',port) for port in range(65535)]
    await asyncio.gather(*tasks, return_exceptions=True)

start = time.time()
scan_all_ports()
end = time.time()

print(end-start)
