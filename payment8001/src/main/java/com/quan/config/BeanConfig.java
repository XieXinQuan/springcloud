package com.quan.config;

import com.quan.entity.FtpEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/5
 */
@Component
public class BeanConfig {

    @Bean
    public FtpEntity ftpEntity(){
        return new FtpEntity();
    }

}
