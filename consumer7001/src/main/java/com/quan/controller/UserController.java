package com.quan.controller;

import com.quan.annotation.NeedLogin;
import com.quan.entity.Result;
import com.quan.entity.User;
import com.quan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") @Size(max = 5, min = 1, message = "用户名长度在1~5位") String username,
                        @RequestParam("password") @Size(max = 18, min = 6, message = "密码的长度为6~18位") String password){
        Result<String> result = userService.login(username, password);
        return result.getData();
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") @Size(max = 5, min = 1, message = "用户名长度在1~5位") String username,
                           @RequestParam("password") @Size(max = 18, min = 6, message = "密码的长度为6~18位") String password,
                           @RequestParam("email") @Email(message = "邮箱地址不合法") String email,
                           @RequestParam("code") @Size(max = 4, min = 4, message = "验证码的长度为4位") String code){
        Result<String> result = userService.register(username, email, password, code);
        return result.getData();
    }


    @PostMapping("/code")
    public String code(@RequestParam("email") @Email String email) throws UnsupportedEncodingException {
        Result<String> result = userService.code(email);
        return result.getData();
    }

    @PostMapping("/info")
    @NeedLogin
    public Object info(){
        Result<User> result = userService.info();
        return result.getData();
    }

    @GetMapping("/applyMerchant")
    @NeedLogin
    public String applyMerchant(){
        Result<String> result = userService.applyMerchant();
        return result.getData();
    }

}
