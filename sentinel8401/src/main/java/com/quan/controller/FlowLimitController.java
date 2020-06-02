package com.quan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/19
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        log.info("........testA..");
        TimeUnit.SECONDS.sleep(1L);
        return "........testA..";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info("........testB..");
        return "........testB..";
    }
}
