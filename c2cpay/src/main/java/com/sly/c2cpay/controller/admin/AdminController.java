package com.sly.c2cpay.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sly.c2cpay.pojo.*;
import com.sly.c2cpay.service.AdminService;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 根据用户名和密码登录
     * @param name
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)

    public ResultInfo login(@RequestParam(value = "admin_id",required = true)String name,
                        @RequestParam(value = "admin_password",required = true)String password,
                        HttpServletRequest request){
        Admin admin = adminService.login(name, password);
        if (admin==null){
            //登录失败
            return new ResultInfo(-1, null, "登录失败", request.getRequestURI());
        }else {
            //登录成功
            return new ResultInfo(0, admin, "登录成功", null);
        }
    }

    /**
     * 管理员注册
     */
    @PostMapping("/register")
    public  ResultInfo register(@RequestParam (value = "admin_id",required = true)String name,
                                @RequestParam(value = "admin_password",required = true)String password,
                                HttpServletRequest request){
        Admin a = adminService.register(name,password);
        if (a==null){
            //注册成功
            return  new ResultInfo(0, null, "注册成功", request.getRequestURI());
        }else {
            return  new ResultInfo(-1, null, "id已存在注册失败", request.getRequestURI());
        }

    }
    /**
     * 分页查看所有用户信息
     * @return
     */
    @GetMapping("/page")
    public Object page(@RequestParam(value = "start_page",defaultValue ="1")int startPage,
                           @RequestParam(value = "page_size",defaultValue = "5")int pageSize){

        Page<Object> objects = PageHelper.startPage(startPage, pageSize);
        List<User> user = adminService.findUser();
        PageInfo<User> userPageInfo = new PageInfo<>();
        userPageInfo.setTotal((int) objects.getTotal());
        userPageInfo.setPage(objects.getPages());
        userPageInfo.setPageNum(objects.getPageNum());
        userPageInfo.setList(user);

        return userPageInfo;
    }

    /**
     * 管理员查询所有商品信息
     * @return
     */
    @GetMapping("/goodslist")
    public List<Goods> findGoods(){
        return adminService.findGoods();
    }
    /**
     * 根据用户id找用户
     */
    @PostMapping("/searchUser")
    public ResultInfo searchUserID(@RequestParam(value = "userID",required = true) String userID,HttpServletRequest request)
    {
        User u=adminService.searchUser(userID);
        if(u==null)
        {
            //查找失败
            return new ResultInfo(-1, null, "该id用户不存在", request.getRequestURI());
        }
        else
            return new ResultInfo(0,u,"该用户存在",null);
    }

    /**
     * 修改用户账号状态
     */
    @PostMapping("/changestatus")
    public ResultInfo changeUserStatus(@RequestParam(value="userID",required=true)String userID,
                                       HttpServletRequest request)
    {
        boolean u=adminService.changeStatus(userID);
        if(!u)
        {//修改失败
            return new ResultInfo(-1, userID, "用户状态修改失败", request.getRequestURI());
        }
        else
        {//修改成功
            return new ResultInfo(0,userID,"用户状态修改成功", request.getRequestURI());
        }
    }
    @PostMapping("/readstatus")
    public ResultInfo readUserStatus(@RequestParam(value="userID",required=true)String userID,
                                       HttpServletRequest request)
    {
        User a;
        int u=adminService.searchStatus(userID);

            return new ResultInfo(0,u,"用户状态读取成功", request.getRequestURI());

    }
    /**
     * 用户账号的删除
     * @param id
     * @param request
     * @return
     */
    @DeleteMapping("/deleteuser")
    public ResultInfo deleteUser(@RequestParam(value="userID") String id,HttpServletRequest request){
        if(adminService.delete(id)==0)
            return  new ResultInfo(-1, null, "用户删除失败", request.getRequestURI());
        else
           return new ResultInfo(0, id,"用户删除成功", null);
    }

    /**
     * 用户密码重置
     * @param id
     * @param request
     * @return
     */
    @PostMapping("/resetpassword")
    public ResultInfo resetPassword(@RequestParam(value="userID",required = true)String id,HttpServletRequest request)
    {
        if(adminService.resetPassword(id))
        {
            return new ResultInfo(0,id, "密码重置成功", null);
        }
        else return  new ResultInfo(-1, null, "密码重置失败", request.getRequestURI());
    }

    @PostMapping("/searchProductTrade")
    public ResultInfo searchProductTrade(@RequestParam(value="productname",required =true)String name,HttpServletRequest request)
    {
        List<ProductInfo> goodslist=adminService.searchProduct(name);
        if(goodslist==null)
        {
            return  new ResultInfo(-1, goodslist, "不存在该名称的商品", request.getRequestURI());
        }
        else  return new ResultInfo(0,goodslist, "存在该名称的商品", null);
    }

    @PostMapping("/searchByProductId")
    public ResultInfo searchByProductid(@RequestParam(value="productID") String productId,HttpServletRequest request)
    {
        if(adminService.searchByProductid(productId)==null)
        {
            return  new ResultInfo(-1, null, "不存在该编号产品", request.getRequestURI());
        }
        else  return new ResultInfo(0,productId, "存在该产品该编号产品", null);
    }

    /**
     * 查看某类产品
     */
    @PostMapping("/searchByProductCategory")
    public ResultInfo searchByProductCategory(@RequestParam(value ="productcate",required = true) String productCategory, HttpServletRequest request){
        List<ProductInfo> ulist=adminService.searchByProductCategory(productCategory);
        if(ulist==null)
        {
            return  new ResultInfo(-1, null, "不存在该类型产品", request.getRequestURI());
        }
        else
            return new ResultInfo(0,ulist, "存在该产品该编号产品", null);
    }

    /**
     * 删除违规商品
     */
    @DeleteMapping("/deleteProductID")
    public ResultInfo deleteProductID(@RequestParam(value ="productID",required = true) String id, HttpServletRequest request){
       if(adminService.deleteProduct(id)==0)
        {
            return  new ResultInfo(-1, null, "该编号产品删除失败", request.getRequestURI());
        }
        else
            return new ResultInfo(0,id, "该编号产品删除成功", null);
    }

    @PostMapping("/searchTradeID")
    public ResultInfo searchTradeID(@RequestParam(value="tradeID",required = true)String tradeID,HttpServletRequest request)
    {
        TradeRecord trade_record= adminService.searchByTradeId(tradeID);
        if(trade_record==null)
            return  new ResultInfo(-1, trade_record, "不存在该编号订单", request.getRequestURI());
        else
            return new ResultInfo(0,trade_record, "存在该编号订单", null);
    }
}
