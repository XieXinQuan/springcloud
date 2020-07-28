package com.quan.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/20
 */
@Controller
public class WelcomeController {
    @Resource
    RabbitTemplate rabbitTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Success";
    }

    @GetMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(){
        Map<String,Object> map=new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
        map.put("hello", "World");
        map.put("id", 0l);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange

        rabbitTemplate.convertAndSend("QuanDirectExchange", "QuanDirectRouting", map);
        Boolean isGetLock = stringRedisTemplate.opsForValue().setIfAbsent("lockKey", "", 3l, TimeUnit.SECONDS);
        return isGetLock ? "Success" : "Failure";
    }
}
