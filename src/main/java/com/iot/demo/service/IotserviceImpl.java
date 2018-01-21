package com.iot.demo.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class IotserviceImpl {

    final String sim=File.separator;
    public List<String> getPicUrl(){
        List<String> list=null;
        list=getPicByFile(list);

        return list;
    }
    public List<String> getPicByFile(List<String> list){

        File file=new File(".."+sim);
        System.out.println(file.isDirectory());
        String [] fileurl=file.list();
        list= Arrays.asList(fileurl);
        return list;
    }
    public List<String> getPivByHttp(List<String> list){

        return list;
    }


}
