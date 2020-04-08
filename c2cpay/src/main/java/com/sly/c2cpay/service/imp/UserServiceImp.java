package com.sly.c2cpay.service.imp;

import com.sly.c2cpay.mapper.UserMapper;
import com.sly.c2cpay.pojo.Goods;
import com.sly.c2cpay.pojo.User;
import com.sly.c2cpay.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * 根据user_id查找user信息
     * @param username
     * @return
     */
    @Override
    public User findByUserName(String username) {
        return userMapper.findByName(username);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    /**
     * 注册,该行为需要事务支持
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User register(User user) {
        User u = userMapper.findByName(user.getUserId());
        if (u==null){
            //用户名不存在，注册用户
            userMapper.register(user);
        }
        return  u;
    }


    /**
     * 更新用户信息
     * @param user
     */
    @Override
    public int update(User user) {
        int update = userMapper.update(user);
        return update<1?-1:update;
    }

    @Override
    public Integer updatePassWord(String userPassword, String userId) {
        return userMapper.updatePassWord(userPassword, userId);
    }


}
