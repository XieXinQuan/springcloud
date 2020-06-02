package com.quan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/2
 */
@Configuration
//设置session的默认在redis中的存活时间
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 60 * 2)
public class SessionConfig {
}
