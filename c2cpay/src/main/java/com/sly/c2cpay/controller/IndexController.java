package com.sly.c2cpay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException, IOException {

        response.sendRedirect("/homepage.html");

    }
}
