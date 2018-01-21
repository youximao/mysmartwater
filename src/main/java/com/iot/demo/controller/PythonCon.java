package com.iot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("/pysent")
public class PythonCon {

    @Autowired
    MyHandler myHandler;

    @RequestMapping("/havaip")
    @ResponseBody
    public Object haveIp(@RequestParam("ip")String ip){
        myHandler.setMyip(ip);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("reuslt","ok");
        return jsonObject;
    }

    @RequestMapping("/here")
    @ResponseBody
    public Object getIsRight(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result","okk");
        return jsonObject;
    }

    @RequestMapping("/upfile")
    public String getUpFile(){return "upfile";}

    @RequestMapping("/update")
    @ResponseBody
    public Object updateImage(@RequestParam("file")MultipartFile file){

        String sim= File.separator;
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
