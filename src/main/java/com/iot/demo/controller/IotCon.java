package com.iot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.WebSocketSession;

import java.io.*;
import java.util.HashMap;

@Controller
@RequestMapping("/iot")
public class IotCon {
    @RequestMapping("/iotcontroller")
    public String getIndexIotCon(){
        return "iotcontroller";
    }

    @RequestMapping("/gettest")
    @ResponseBody
    public Object getTest(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result","ok");
        return jsonObject;
    }
    @Autowired
    MyHandler handler;
    @RequestMapping("/sendpy/{str}")
    @ResponseBody
    public Object getSendPy(@PathVariable String str){
        handler.sendMessage(str);

        return new JSONObject().put("result","ok");
    }

    @RequestMapping("/nowperson")
    @ResponseBody
    public Object getNowPerson(){
        JSONObject jsonObject=new JSONObject();
        HashMap<String,WebSocketSession> hashMap=handler.getHashMap();
        jsonObject.put("size",hashMap.size());
        jsonObject.put("data",hashMap);

        return jsonObject;
    }


    @RequestMapping("/upfile")
    public String getUpFile(){return "upfile";}

    @RequestMapping("/update")
    @ResponseBody
    public Object updateImage(@RequestParam("file")MultipartFile file){

        String sim=File.separator;
        String path=".."+sim+file.getOriginalFilename();
        File file1=new File(path);

        try {
            BufferedOutputStream bufferedInputStream=new BufferedOutputStream(new FileOutputStream(file1));
            bufferedInputStream.write(file.getBytes());
            bufferedInputStream.flush();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result","okfile");
        return jsonObject;
    }
}
