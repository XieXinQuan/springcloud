package com.quan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Message8012 {
    public static void main(String[] args) {
        SpringApplication.run(Message8012.class, args);
    }
}
