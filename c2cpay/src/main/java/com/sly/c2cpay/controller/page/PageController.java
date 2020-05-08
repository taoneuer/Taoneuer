package com.sly.c2cpay.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
    @RequestMapping("/upload")
    public String test(){
        return "upload";
    }


    @RequestMapping("/login")
    public  String login(){
        return "denglu";
    }

}
