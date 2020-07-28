package com.quan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/18
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaAuditing
//@EnableWebSecurity
@EnableDiscoveryClient
//@EnableRedisHttpSession
public class Application8001 {
    public static void main(String[] args) {
        SpringApplication.run(Application8001.class, args);
    }
}
