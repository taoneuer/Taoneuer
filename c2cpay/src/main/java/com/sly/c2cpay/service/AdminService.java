package com.sly.c2cpay.service;

import com.sly.c2cpay.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminService {
    Admin findById(String id);
    /**
     * 管理员根据用户名和密码登录
     * @param adminname
     * @param password
     * @return
     */
    Admin login(String adminname, String password);

    /**
     * 管理员注册
     */
    Admin register(String adminname, String password);

    /**
     * 管理员查看所有用户信息
     * @return
     */
    List<User> findUser();


    /**
     * 查询所有用户发布的商品
     * @return
     */
    List<ProductInfo> findGoods();
    /**
     * 查询所有交易信息
     * @return
     */
    List<TradeRecord> findTradeRecord();
    /**
     * 管理员根据用户id查询用户
     */
    User searchUser(String userID);

    /**
     * 违规用户账号封锁
     */
    boolean changeStatus(String userID);

    /**
     * 管理员删除指定id用户
     */
    Integer delete(String userId);
    /**
     * 管理员新增指定id用户
     */
    Integer adduser(String userId,String userPassword);

    /**
     * 重置用户密码
     */
    boolean resetPassword(String userId);

    /**
     * 查看名为某物品的所有商品
     */
    List<ProductInfo> searchProduct(String productName);

    /**
     * 据物品id搜索物品
     */
    ProductInfo searchByProductid(String productId);

    /**
     * 查看某类物品
     */
    List<ProductInfo> searchByProductCategory(String productCategory);

    /**
     * 删除违规商品
     */
    Integer deleteProduct(String productId);
    /**
     * 添加违规商品
     */
    Integer addProduct(String productId,String productName,String productCategory,String productPrice,String ownerId);
    /**
     * 查看用户状态
     */
    Integer searchStatus(String userID);

    /**
     * 根据订单号查询销售订单
     */
    TradeRecord searchByTradeId(String tradeId);
    /**
     * 删除订单
     */
    Integer deletetraderecord(String id);
}
