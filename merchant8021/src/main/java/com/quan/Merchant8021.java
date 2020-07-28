package com.quan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
@EnableDiscoveryClient
public class Merchant8021 {
    public static void main(String[] args) {
        SpringApplication.run(Merchant8021.class, args);
    }
}
