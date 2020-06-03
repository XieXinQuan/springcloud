package com.quan.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/1/11
 */
//@Configuration
public class RedisConfig extends CachingConfigurerSupport {

//
//    @Bean
//    public RedisTemplate<String, Object> stringSerializerRedisTemplate(RedisTemplate redisTemplate){
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setValueSerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        redisTemplate.setHashValueSerializer(redisSerializer);
//
//        return redisTemplate;
//
//    }
}
