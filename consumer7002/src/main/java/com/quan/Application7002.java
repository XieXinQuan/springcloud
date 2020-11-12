package com.quan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application7002 {
    public static void main(String[] args) {
        SpringApplication.run(Application7002.class, args);
    }
}
