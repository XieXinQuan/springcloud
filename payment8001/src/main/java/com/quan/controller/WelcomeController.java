package com.quan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/20
 */
@Controller
public class WelcomeController {
    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Success";
    }
}
