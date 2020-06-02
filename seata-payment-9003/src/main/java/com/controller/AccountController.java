package com.controller;

import com.entity.Account;
import com.service.AccountService;
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
public class AccountController {
    @Resource
    AccountService accountService;

    @GetMapping("/save")
    public String save(){
        Account save = accountService.save(1L, 1L, 200, 10, 190);
        return save.toString();
    }

    @GetMapping("/select/{id}")
    public String select(@PathVariable("id") Long id){
        Account select = accountService.select(id);
        return select.toString();
    }

    @GetMapping("/residue/{userId}/{money}")
    public Integer residue(@PathVariable("userId") Long userId, @PathVariable("money") Integer money) {
        accountService.residue(userId, money);
        return 1;
    }


}
