package com.quan.service;

import com.quan.entity.Result;
import com.quan.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@FeignClient(value = "http://user")
@Component
public interface UserService {

    @PostMapping("/user/login")
    Result<String> login(@RequestParam("username") String username, @RequestParam("password")String password);

    @PostMapping("/user/register")
    Result<String> register(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("email") String email,
                            @RequestParam("code")String code);


    @PostMapping("/user/code")
    Result<String> code(@RequestParam("email") String email) throws UnsupportedEncodingException;

    @PostMapping("/user/info")
    Result<User> info();

    @GetMapping("/applyMerchant")
    Result<String> applyMerchant();

}
