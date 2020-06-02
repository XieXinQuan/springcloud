package com.quan.controller;

import com.alibaba.fastjson.JSON;
import com.quan.entity.User;
import com.quan.entity.UserInfo;
import com.quan.service.UserService;
import com.quan.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@RestController
@RequestMapping("/login")
@Slf4j
@Validated
public class UserController {

    @Resource
    UserService userService;



    @PostMapping("/login")
    public String login(@RequestParam("username") @Size(max = 5, min = 1, message = "用户名长度在1~5位") String username,
                        @RequestParam("password") @Size(max = 18, min = 6, message = "密码的长度为6~18位") String password){
        Long uId = userService.login(username, password);
        return token(uId);
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") @Size(max = 5, min = 1, message = "用户名长度在1~5位") String username,
                           @RequestParam("password") @Size(max = 18, min = 6, message = "密码的长度为6~18位") String password,
                           @RequestParam("email") @Email(message = "邮箱地址不合法") String email,
                           @RequestParam("code") @Size(max = 4, min = 4, message = "验证码的长度为4位") String code){
        Long uId = userService.registerUser(username, email, password, code);
        return token(uId);
    }


    @PostMapping("/code")
    public String code(@RequestParam("email") @Email String email) throws UnsupportedEncodingException, MessagingException {
        String code = userService.code(email);
        log.info("code : {}", code);
        return "验证码已发送.";
    }

    @PostMapping("/info")
    public Object info(){
        User user = userService.userInfo();
        return user;
    }

    private String tokenSubject(Long userId){
        UserInfo userInfo = new UserInfo();
        userInfo.setUId(userId);
        return JSON.toJSONString(userId);
    }

    private String token(Long userId){
        return JwtUtil.createToken(tokenSubject(userId));
    }
}
