import os
import time
import updateimage

def takepic():
  str = time.strftime("%Y-%m-%d-%H:%M:%S", time.localtime())
  print(str);
  os.system('fswebcam --no-banner -r 640x480 -S 50 --jpeg 100 --save '+str+'.png')

  print("拍照完毕");

  path = str+".png"
  updateimage.upimage(path);



