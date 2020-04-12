package com.sly.c2cpay.mapper;

import com.sly.c2cpay.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 管理员业务接口
 */

public interface AdminMapper {

    /**
     * 管理员登录
     * @param adminId
     * @param adminPassword
     * @return
     */
    @Select("select * from admin where admin_id=#{adminId} and admin_password=#{adminPassword}")
    Admin login(String adminId,String adminPassword);

    /**
     *管理员注册
     */
    @Insert("insert into admin (admin_id,admin_password) values(#{adminId},#{adminPassword})")
    void register(String adminId, String adminPassword);

    @Select("select * from admin where admin_id=#{adminId}")
    Admin findById(String adminId);

    /**
     * 管理员查看所有用户信息
     * @return
     */
    @Select("select * from user")
    List<User> findUser();


    /**
     * 查询所有发布的商品
     * @return
     */
    @Select("select * from product_info")
    List<Goods> findGoods();

    /**
     * 管理员根据用户id查询用户
     */
    @Select("select * from user where user_id=#{userId}")
    User searchUser(String userId);

    /**
     * 删除用户
     */
    @Delete("Delete from user where user_id=#{userId}")
    Integer delete(String userId);

    /**
     * 修改用户账号状态
     */
    @Update("UPDATE user SET status=#{userStatus} WHERE user_id=#{userId}")
   boolean updateStatus(int userStatus,String userId);

    /**
     * 查看用户账号状态
     */
    @Select("SELECT status from user where user_id=#{userId}")
    Integer searchStatus(String userId);

    /**
     * 重置用户密码
     */
    @Update("UPDATE user SET user_password=#{userId} WHERE user_id=#{userId}")
    boolean resetPassword(String userId);

    /**
     * 查看名为某物品的所有架上产品
     */
    @Select("select * from product_info WHERE product_name=#{productName}")
    List<ProductInfo>  searchProduct(String productName);

    /**
     *根据物品id搜索物品
     */
    @Select("select * from product_info WHERE product_id=#{productId}")
    ProductInfo searchByProductid(String productId);

    /**
     * 查看某类物品
     */
    @Select("select * from product_info WHERE product_category=#{productCategory}")
    List<ProductInfo> searchByProductCategory(String productCategory);


    /**
     * 删除违规商品
     */
    @Delete("delete from product_info WHERE product_id=#{productId}")
    Integer deleteProduct(String productId);

    /**
     * 根据订单号查询销售订单
     */
    @Select("select * from trade_record WHERE trade_id=#{tradeId}")
    TradeRecord searchByTradeId(String tradeId);

}
