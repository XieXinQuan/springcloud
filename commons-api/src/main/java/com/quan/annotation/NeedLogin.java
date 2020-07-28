package com.quan.annotation;

import java.lang.annotation.*;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface NeedLogin {
    String message() default "Login Over Due";
}
