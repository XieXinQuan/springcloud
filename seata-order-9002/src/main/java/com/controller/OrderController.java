package com.controller;

import com.entity.Order;
import com.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/save")
    public String save(){
        orderService.save(1L, 1L, 5, 500, 0);
        return "Save Success";
    }

    @GetMapping("/select/{id}")
    public String select(@PathVariable("id") Long id){
        Order select = orderService.select(id);
        return select.toString();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id){
        orderService.update(id);
        return "Update Success";
    }


    @GetMapping("/order")
    public String order() {
        orderService.order();
        return "Payment Success, Please Wait Merchant Shipping...";


    }
}
