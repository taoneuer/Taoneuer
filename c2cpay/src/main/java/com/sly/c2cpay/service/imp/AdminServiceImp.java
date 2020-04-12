package com.sly.c2cpay.service.imp;

import com.sly.c2cpay.mapper.AdminMapper;
import com.sly.c2cpay.pojo.*;
import com.sly.c2cpay.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Resource
    private AdminMapper adminMapper;


    /**
     * 管理员登录
     * @param admin_id
     * @param admin_password
     * @return
     */
    //@Override注解标记的方法声明，如果没有覆写或者实现超类的方法声明，或者不是覆写Object的public方法，那么编译就会报错。
    //有助于我们尽早发现这样的错误：本来想声明一个“覆写”方法，却偶然声明成“重载”方法。
    @Override
    public Admin login(String admin_id, String admin_password) {
        return adminMapper.login(admin_id, admin_password);
    }

    @Override
    public Admin findById(String id) {return adminMapper.findById(id);}


    /**
     * 管理员注册
     */
    @Override
    //如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中
    @Transactional(propagation = Propagation.REQUIRED)
    public Admin register(String adminname, String password) {
        Admin a = adminMapper.findById(adminname);
        if (a==null){
            //用户名不存在，注册用户
            adminMapper.register(adminname,password);
        }
        return  a;
    }

    /**
     * 分页查看所有用户
     * @return
     */
    @Override
    public List<User> findUser() {
        return adminMapper.findUser();
    }


    /**
     * 查看所有商品信息
     * @return
     */
    @Override
    public List<Goods> findGoods() {
        return adminMapper.findGoods();
    }

    /**
     * 根据id找用户
     * @param userID
     * @return
     */
    @Override
    public User searchUser(String userID){return adminMapper.searchUser(userID);}

    /**
     * 删除用户账号
     * @param userId
     * @return
     */
    @Override
    public Integer delete(String userId){ return adminMapper.delete(userId);}



    /**
     * 修改用户账号状态
     * @param userID
     * @return
     */
    @Override
    public boolean changeStatus(String userID)
    {
        if(adminMapper.searchStatus(userID)==0)
            return adminMapper.updateStatus(1,userID);
        else
            return adminMapper.updateStatus(0,userID);
    }

    @Override

    public Integer searchStatus(String userID)
    {
        return adminMapper.searchStatus(userID);
    }
    @Override
    public boolean resetPassword(String userId){return adminMapper.resetPassword(userId);}

    @Override
    public  List<ProductInfo>  searchProduct(String productName){return adminMapper.searchProduct(productName);}

    @Override
    public  ProductInfo searchByProductid(String productId){return adminMapper.searchByProductid(productId);}
    /**
     * 查看某类物品
     * @return
     */
    @Override
    public List<ProductInfo> searchByProductCategory(String productCategory){ return adminMapper.searchByProductCategory(productCategory);}

    /**
     * 删除违规商品
     */
    @Override
    public Integer deleteProduct(String productId){return adminMapper.deleteProduct(productId);}

    /**
     * 根据订单号查询销售订单
     */
    @Override
    public TradeRecord searchByTradeId(String tradeId){return adminMapper.searchByTradeId(tradeId);}


}
