package com.quan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisHttpSession
@EnableFeignClients
public class Application7001 {
    public static void main(String[] args) {
        SpringApplication.run(Application7001.class, args);
    }
}
