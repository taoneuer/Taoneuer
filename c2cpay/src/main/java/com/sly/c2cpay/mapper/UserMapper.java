package com.sly.c2cpay.mapper;
import com.sly.c2cpay.pojo.Goods;
import com.sly.c2cpay.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户层dao接口
 */

public interface UserMapper {


    /**
     * 根据用户名和密码登录
     * @param userPassword
     * @param userId
     * @return
     */
    @Select("select * from user where user_id=#{userId} and user_password=#{userPassword}")
    User login(String userId, String userPassword);

    /**
     * 注册
     * @param user
     * @return
     */
    @Insert("insert into user (user_id,user_password,user_name,major,student_id,institute,address) values(#{userId},#{userPassword},#{userName},#{major},#{studentId},#{institute},#{address})")
    void register(User  user);

    @Select("select * from user where user_id=#{userId}")
    User findByName(String userId);

    /**
     * 动态SQL更新用户信息
     * @param user
     * @return
     */
    @UpdateProvider(value = UserProvider.class,method = "updateUser")
    int update(User user);

    /**
     * 修改用户密码
     * @param userPassword
     * @param userId
     * @return
     */
    @Update("UPDATE user SET user_password =#{userPassword} WHERE user_id=#{userId} ")
    Integer updatePassWord(String userPassword,String userId);



}
