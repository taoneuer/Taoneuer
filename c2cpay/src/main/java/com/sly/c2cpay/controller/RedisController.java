package com.sly.c2cpay.controller;

import com.sly.c2cpay.pojo.ResultInfo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

        @Resource
        private StringRedisTemplate redisTmpl;

        @GetMapping("/add")
        public ResultInfo add(){
            redisTmpl.opsForValue().set("name", "xdclass");
            return new ResultInfo(0, null, "ok", "");
        }

    @GetMapping("/get")
    public ResultInfo get(){
        String name = redisTmpl.opsForValue().get("name");
        return new ResultInfo(0, name, "ok", "");
    }
}
