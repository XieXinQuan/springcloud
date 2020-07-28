package com.quan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@FeignClient(value = "http://payment")
@Component
public interface UserService {

//    @PostMapping(value = "/login")
//    String login(String username, String password);
//
//    @PostMapping(value = "/register")
//    String register(String username, String password, String code);

//    @PostMapping(value = "/login/code")
//    String code(@RequestParam("loginName") String loginName);

    @RequestMapping(value = "/test/getSession")
    String getSession();
}
