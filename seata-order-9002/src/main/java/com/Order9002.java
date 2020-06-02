package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class Order9002 {
    public static void main(String[] args) {
        SpringApplication.run(Order9002.class, args);
    }

}
