import sys
import Adafruit_DHT
import time


DHT_SENSOR = Adafruit_DHT.DHT11
DHT_PIN = 4

while True:
    f= open("python output.txt","a+")
    humidity, temperature = Adafruit_DHT.read(DHT_SENSOR, DHT_PIN)
    if humidity is not None and temperature is not None:
        print("{0:0.1f} {1:0.1f}".format((((temperature-3) * 9/5) + 32), humidity))
        f.write(str((((temperature-3) * 9/5) + 32)))
        f.write("   ")
        f.write(str(humidity))
        f.write("\r\n")
        f.close()

    time.sleep(2);
      
