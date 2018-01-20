package com.iot.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebbaseCon {

    /*
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/send")
    public void getSend(){
        simpMessagingTemplate.convertAndSend("/chat","woeee");
    }



    @MessageMapping("/chartoserver")
    public void getCharToServer(String mes){
        System.out.println(mes);

    }
*/
    @Autowired
    MyHandler handler;

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }


    @RequestMapping("/login")
    public String getLogIn(){
        return "login";
    }

}

