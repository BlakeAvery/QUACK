import os
import subprocess
import socket
import time
import datetime
def main():
    print("Done with Init!")
    loop()
def loop():
    while True:
        e = subprocess.check_output(['cat', '/sys/class/gpio/gpio35/value'])
        print(e)
        if e.startswith("0"):
            alert()
def alert():
    print("Alert!")
    sendMessage()
def sendMessage():
    cunt = socket.socket()
    print("Trying to connect")
    cunt.connect(("192.168.43.178", 8051))
    timememe = datetime.datetime.now()
    print("Connected!")
    cunt.send(socket.gethostname() + ",40.54.1560,73.8.0690," + timememe.strftime("%Y-%m-%d %H:%M:%S") + "," + "alert_msg\r")
    print("Alert sent, sleepytime for 30 secs")
    time.sleep(30)
if __name__ == "__main__":
    main()
