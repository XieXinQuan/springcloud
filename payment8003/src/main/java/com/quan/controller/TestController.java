package com.quan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/28
 */
@RestController
public class TestController {
//    @Autowired
//    private StringRedisTemplate redisTemplate;
    @RequestMapping("/")
    public String helloWorld(HttpServletRequest request,
                             HttpServletResponse response){
        System.out.println(".......enter");
        String id = request.getSession().getId();
        System.out.println("session id : " + id);
        HttpSession session = request.getSession();
        Object isExists = session.getAttribute("isExists");
        if (isExists == null)
            session.setAttribute("isExists", true);

        return "Hello World!";
    }

}
