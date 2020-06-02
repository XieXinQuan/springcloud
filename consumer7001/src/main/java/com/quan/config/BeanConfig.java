package com.quan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/18
 */
@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced
    public RestTemplate RestTemplate(){
        return new RestTemplate();
    }
}
