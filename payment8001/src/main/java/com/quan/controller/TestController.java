package com.quan.controller;

import com.quan.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/6
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${server.port}")
    Integer port;
    @Resource
    HttpServletRequest request;
    @RequestMapping("/getSession")
    public String getSessionId(){
        String token = request.getHeader(JwtUtil.header);
        System.out.println(token);
        String userInfo = JwtUtil.getSubjectFromToken(token);
        System.out.println(userInfo);
        return "currPort:" + port + ", Login User Info : " + userInfo;
    }
}
