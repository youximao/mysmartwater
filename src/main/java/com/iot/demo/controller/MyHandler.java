package com.iot.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyHandler extends TextWebSocketHandler {

    public String myip;

    public HashMap<String,WebSocketSession> hashMap=new HashMap<String,WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        //System.out.println(message);
            if (!this.hashMap.containsKey(session.getRemoteAddress()))
            this.hashMap.put(session.getRemoteAddress().getHostString(),session);
        System.out.println(message.getPayload());

        try {
            session.sendMessage(new TextMessage("ke yi de"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        /*hashMap.forEach((key,value)-> {
            try {
                value.sendMessage(new TextMessage(msg));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/
        for(Map.Entry<String,WebSocketSession> set: hashMap.entrySet()){
            WebSocketSession webSocketSession=set.getValue();
            try {
                // 默认第一个是树莓派的
                webSocketSession.sendMessage(new TextMessage(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }
    // 删除全部 只留下树莓派的那一个
    public HashMap<String,WebSocketSession> delectOther(String mes){
        if(hashMap.containsKey(mes)) {
            WebSocketSession socketSession = hashMap.get(mes);
            hashMap.clear();
            hashMap.put(mes,socketSession);
        }else{

            hashMap.clear();}


        return hashMap;
    }
    // 删除全部的
    public Boolean delectAll(){
        hashMap.clear();
        return true;
    }
    //获取当前在线的websocket
    public HashMap<String,WebSocketSession> getHashMap(){
        return this.hashMap;
    }

    public String getMyip() {
        return myip;
    }

    public void setMyip(String myip) {
        this.myip = myip;
    }
}
