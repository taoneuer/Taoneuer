package com.sly.c2cpay.service;

import com.sly.c2cpay.pojo.Goods;
import com.sly.c2cpay.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户层业务接口
 */
public interface UserService {


    User findByUserName(String username);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String  username,String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    User register(User  user);

    /**
     * 更新用户信息
     * @param user
     */
    int update(User user);

    /**
     * 修改用户密码
     * @param userPassword
     * @param userId
     * @return
     */
    Integer updatePassWord(String userPassword,String userId);





}
