package com.quan.controller;

import com.alibaba.fastjson.JSONObject;
import com.quan.service.UserService;
import com.quan.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class UserController {
    @Resource
    HttpServletRequest request;
    @Resource
    UserService userService;

    @RequestMapping("/getSession")
    public String test(){
        System.out.println("........................ start");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.println(s + " : " + header);
        }

        System.out.println("........................ end");

        String session = userService.getSession();
        return "sessionId:" + request.getSession().getId() + ", data: " + session;
    }

    @RequestMapping("/login/{username}/{password}")
    public Object login(@PathVariable("username") String name,
                        @PathVariable("password") String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uId", name);
        jsonObject.put("passwd", password);
        String token = JwtUtil.createToken(jsonObject.toString());

        return token;
    }
    @RequestMapping("/getUser")
    public String getUser(){
        String token = request.getHeader("token");
        String subject = JwtUtil.getSubjectFromToken(token);
        return subject;
    }

    @RequestMapping("/callPayment")
    public String callPayment(){
        String header = request.getHeader(JwtUtil.header);
        String subject = JwtUtil.getSubjectFromToken(header);
        System.out.println(header);
        log.info("subject : {}", subject);
        String session = userService.getSession();
        return session;
    }

}
