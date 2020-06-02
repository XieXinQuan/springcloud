package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Stock9004 {
    public static void main(String[] args) {
        SpringApplication.run(Stock9004.class, args);
    }
}
