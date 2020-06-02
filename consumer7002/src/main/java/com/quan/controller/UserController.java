package com.quan.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@RestController
@RequestMapping("/test")
public class UserController extends BaseController{
    @Resource
    HttpServletRequest request;
    @Resource
    RedisTemplate redisTemplate;

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

        return "sessionId:" + request.getSession().getId();
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        Map<String, String> map = new HashMap<>(2);
        map.put("name", username);
        map.put("password", password);
        String value = JSON.toJSONString(map);
        redisTemplate.opsForValue().set("USER_TOKEN" + username, value, 3, TimeUnit.MINUTES);
        return "Success";
    }

    @RequestMapping("info")
    public String info(){
        Object user = redisTemplate.opsForValue().get("USER");
        System.out.println(user);
        return "";
    }


}
