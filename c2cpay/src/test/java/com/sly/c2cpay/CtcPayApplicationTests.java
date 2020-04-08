package com.sly.c2cpay;

import com.sly.c2cpay.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CtcPayApplicationTests {

    @Resource
    UserMapper userMapper;


    @Test
    public void contextLoads() {
    }



}
