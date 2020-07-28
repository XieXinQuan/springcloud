package com.quan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/18
 */
@RestController
@Slf4j
public class ConsumerController {

    @Value("${server.port}")
    Integer port;
    @GetMapping("/")
    public String welcome(){
        return "Hello World! My Port Is : " + port;
    }

//    @Resource
//    UserService userService;

//    @PostMapping("/login")
//    public String login(@RequestParam("username") @Size(max = 5, min = 1, message = "用户名长度在1~5位") String username,
//                        @RequestParam("password") @Size(max = 18, min = 6, message = "密码的长度为6~18位") String password){
//
//        return userService.login(username, password);
//    }
//
//    @PostMapping("/register")
//    public String register(@RequestParam("username") @Size(max = 5, min = 1, message = "用户名长度在1~5位") String username,
//                           @RequestParam("password") @Size(max = 18, min = 6, message = "密码的长度为6~18位") String password,
//                           @RequestParam("code") @Size(max = 4, min = 4, message = "验证码的长度为4位") String code){
//
//        return userService.register(username, password, code);
//    }
//
//    @PostMapping("/code")
//    public String code(@RequestParam("loginName") String loginName){
//        return userService.code(loginName);
//    }

}
