package com.quan.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/16
 */
@Configuration
public class SecurityConfig
//        extends WebSecurityConfigurerAdapter
{
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
        //权限
//        http.authorizeRequests().antMatchers("/**").permitAll();
//                .antMatchers("/login/**").permitAll()
//                .antMatchers("/commodity/category").permitAll()
//                .antMatchers("/commodity/vipCategory").hasRole("vip")
//                .antMatchers("/commodity/superVipCategory").hasRole("superVip");
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("vip").password(new BCryptPasswordEncoder().encode("123456")).roles("vip")
//                .and()
//                .withUser("superVip").password(new BCryptPasswordEncoder().encode("123456")).roles("superVip")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip", "superVip");
//    }
}
