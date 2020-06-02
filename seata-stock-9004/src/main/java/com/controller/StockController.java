package com.controller;

import com.entity.Stock;
import com.service.StockService;
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
public class StockController {
    @Resource
    StockService stockService;


    @GetMapping("/save")
    public String save(){
        Stock save = stockService.save(1L, 200, 10, 190);
        return save.toString();
    }

    @GetMapping("/select/{id}")
    public String select(@PathVariable("id") Long id){
        Stock select = stockService.select(id);
        return select.toString();
    }

    @GetMapping("/residue/{productId}/{count}")
    public Integer residue(@PathVariable("productId") Long productId, @PathVariable("count") Integer count) {
        stockService.residue(productId, count);
        return 1;
    }

}
