package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@FeignClient(value = "Account")
public interface AccountService {
    @GetMapping("/residue/{id}/{money}")
    Integer residue(@PathVariable("id") Long id, @PathVariable("money") Integer money);
}
