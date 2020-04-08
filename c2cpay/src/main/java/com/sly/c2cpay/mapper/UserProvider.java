package com.sly.c2cpay.mapper;

import com.sly.c2cpay.pojo.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * 生成SQL语句
 */
public class UserProvider {
    public String updateUser(final User user) {
        return new SQL() {{
            UPDATE("tab_user");

            //条件写法.
//            if (user.getSex() != null) {
//                SET("sex=#{sex}");
//            }
//            if (user.getName() != null) {
//                SET("name=#{name}");
//            }
//            if (user.getEmail() != null) {
//                SET("email=#{email}");
//            }
            WHERE("uid=#{uid}");
        }}.toString();
    }


}
