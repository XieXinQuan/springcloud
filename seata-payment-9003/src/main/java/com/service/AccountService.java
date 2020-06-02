package com.service;

import com.entity.Account;
import com.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Service
public class AccountService {
    @Resource
    AccountRepository accountRepository;

    public Account save(Long id, Long userId, Integer total, Integer used, Integer residue){
        Account account = new Account();
//        account.setId(id);
        account.setUserId(userId);
        account.setTotal(total);
        account.setUsed(used);
        account.setResidue(residue);
        accountRepository.save(account);
        return account;
    }

    public Account select(Long id){
        Optional<Account> byId = accountRepository.findById(id);
        return byId.get();
    }

    public void residue(Long userId, Integer money) {
        Account account = accountRepository.findByUserId(userId);
        if (money > account.getResidue()) throw new RuntimeException("余额不足.");

        Integer residue = account.getResidue() - money;
        Integer used = account.getUsed() + money;
        account.setResidue(residue);
        account.setUsed(used);
        accountRepository.save(account);
    }

}
