package com.quan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/28
 */
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;

}
