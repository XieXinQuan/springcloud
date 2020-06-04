package com.quan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/3
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
public class Message8011 {
    public static void main(String[] args) {
        SpringApplication.run(Message8011.class, args);
    }
}
