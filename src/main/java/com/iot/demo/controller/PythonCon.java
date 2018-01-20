package com.iot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pysent")
public class PythonCon {

    @RequestMapping("/here")
    @ResponseBody
    public Object getIsRight(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result","okk");
        return jsonObject;
    }
}
