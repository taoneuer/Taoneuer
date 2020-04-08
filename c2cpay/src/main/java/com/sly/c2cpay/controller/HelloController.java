package com.sly.c2cpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller

public class HelloController {

@ResponseBody
    @RequestMapping("/hello")

    public String Hello() {
        return "Hello World";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
    map.put("hello","您好");
     return "success";
    }

}
