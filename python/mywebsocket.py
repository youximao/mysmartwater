import shuibenggpio
import haveimages

def readOp(msg):
    op=msg.split("|")[0]
    print(op)
    if(op=="water"):
        shuibenggpio.water(msg.split("|")[1])
    elif(op=="image"):
        haveimages.takepic()
