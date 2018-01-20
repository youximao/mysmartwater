import RPi.GPIO as GPIO    
import time    

def water(tt):
     GPIO.setmode(GPIO.BCM)
     #GPIO.setwarnings(False)

     # 输出模式    
     gg = 17   
     print("out")
     GPIO.setup(gg, GPIO.OUT)    
     time.sleep(3)
     print("In")
     GPIO.setup(gg, GPIO.IN)    
     time.sleep(6)
     print("浇花完成")    
