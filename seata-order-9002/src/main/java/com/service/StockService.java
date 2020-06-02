package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@FeignClient(value = "Stock")
public interface StockService {
    @GetMapping("/residue/{id}/{count}")
    Integer residue(@PathVariable("id") Long id, @PathVariable("count") Integer count);
}
