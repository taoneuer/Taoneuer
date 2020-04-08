package com.sly.c2cpay.controller.common;


import com.sly.c2cpay.pojo.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@RestController
@RequestMapping("/common")
public class CommonController {

    @PostMapping("/check")
    public ResultInfo checkCode(@RequestParam(value = "check_code",required = true) String CHECK_CODE,
                          HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("CHECK_CODE", CHECK_CODE);
        return new ResultInfo(0,null,"成功",request.getRequestURI());
    }
}
