package com.quan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/30
 */
@Component
public class ShopNum {
    @Bean
    public Shop shop(){
        return new Shop(100);
    }
}
