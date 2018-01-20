
import websocket
import mywebsocket



def on_message(ws, message):
    print(message);
    #ws.send("已收到");
    mywebsocket.readOp(message);


def on_error(ws, error):
    print(error)

def on_close(ws):
    print("### closed ###")

def on_open(ws):
    print("到 zhe")
    #print("zhe li")
    ws.send("jjj")


if __name__ == "__main__":
    ws = websocket.WebSocketApp("ws://192.168.1.100:5002/myHandler",
                                on_message = on_message,
                                on_error = on_error,
                                on_close = on_close)

    ws.on_open = on_open

    print("ok")

    ws.run_forever()

    #websocket.enableTrace(True)





