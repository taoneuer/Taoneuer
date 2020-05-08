package com.sly.c2cpay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper包下的所有dao接口
@MapperScan("com.sly.c2cpay.mapper")
public class CtcPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtcPayApplication.class, args);
    }

}
