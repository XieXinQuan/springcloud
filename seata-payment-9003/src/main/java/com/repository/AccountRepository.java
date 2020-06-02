package com.repository;

import com.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(Long userId);
}
