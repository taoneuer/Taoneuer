package com.sly.c2cpay.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisConfiguration {

    //分页插件
    @Bean
    public PageHelper pageHelper(){

        System.out.println("MyBatisPageHelper");
        PageHelper pageHelper=new PageHelper();
        Properties p = new Properties();
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);


        return pageHelper;
    }
}
