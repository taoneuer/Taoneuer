package com.sly.c2cpay.controller.user;
import com.sly.c2cpay.pojo.ResultInfo;
import com.sly.c2cpay.pojo.User;
import com.sly.c2cpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ViewResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 用户控制器
 */

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 根据类型注入
     */
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param name
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResultInfo login(@RequestParam(value = "user_id",required = true)String name,
                            @RequestParam(value = "user_password",required = true)String password,
                            String check,
                            HttpServletRequest request){
        //验证码检验
//        HttpSession session = request.getSession();
//        String check_code =(String) session.getAttribute("CHECK_CODE");
//        if(check==null||!check.equalsIgnoreCase(check_code)){
//            return new ResultInfo(-1, null, "验证码错误", request.getRequestURI());
//        }
        User user = userService.login(name, password);
        if (user!=null){
            request.getSession().setAttribute("user", user);
            return new ResultInfo(0, user, "登陆成功", null);
        }else {
            return new ResultInfo(-1, null,"用户名或密码错误",request.getRequestURI());
        }
    }

    /**
     * 检测用户名是否存在
     * @param username
     * @return
     */
    @GetMapping("/exists")
    public ResultInfo exists(@RequestParam(value = "username") String username){
        User byUserName = userService.findByUserName(username);
        if (byUserName!=null){
            return new ResultInfo(-1);
        }
        return new ResultInfo(0);
    }

    /**
     * 注册
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/register")
    public  ResultInfo register(@RequestBody User user,HttpServletRequest request){
        User u = userService.register(user);
        if (u==null){
            //注册成功
            return  new ResultInfo(0, null, "注册成功", request.getRequestURI());
        }else {
            return  new ResultInfo(-1, null, "用户名已存在注册失败", request.getRequestURI());

        }

    }


    /**
     * 用户更新信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/update")
    public ResultInfo update(@RequestBody User user,HttpServletRequest request){
        int updateNum = userService.update(user);
        return updateNum<1?new ResultInfo(-1, null, "更新失败", request.getRequestURI()):
                            new ResultInfo(0, null, "更新成功", request.getRequestURI());

    }


    /**
     * 用户个人信息
     * @param request
     * @return
     */
    @GetMapping("/findUser")
    public ResultInfo findUser(HttpServletRequest request){
        User user =(User) request.getSession().getAttribute("user");
        return new ResultInfo(0, user, "用户信息", request.getRequestURI());
    }


    /**
     * 用户修改密码
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/updatePassword")
    public ResultInfo updatePassword(@RequestParam(value = "user_id",required = true) String username,
                                     @RequestParam(value = "user_password",required = true) String password,
                                     HttpServletRequest request){
        Integer integer = userService.updatePassWord(password, username);
        if (integer<1)
            return new ResultInfo(-1,null,"修改失败",request.getRequestURI());
            return new ResultInfo(0, null, "更新成功", request.getRequestURI());

    }


    /**
     * 查询其他用户信息
     * @param userId
     * @param request
     * @return
     */
    @GetMapping("/findUserById")
    public ResultInfo findUserById(@RequestParam(value = "user_id",required = true) String userId,
                                   HttpServletRequest request){
        User user = userService.findByUserName(userId);
        if (user==null){
            return  new ResultInfo(-1, null, "用户不存在", request.getRequestURI());
        }
            return  new ResultInfo(0, user, "查询成功", request.getRequestURI());
    }

    @GetMapping("/exit")
    public ResultInfo exit(HttpServletRequest request){

        HttpSession session = request.getSession();
        session.invalidate();
        return new ResultInfo(0);
    }












}
