package com.quan;

import com.quan.config.MyBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/28
 */
@SpringBootTest
@WebAppConfiguration
public class Application8002 {

    @Autowired
    MyBean myBean;

    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void test(){
        String message = myBean.getMessage();
        System.out.println(message);
    }

    @After
    public void after(){
        System.out.println("after");
    }
}
