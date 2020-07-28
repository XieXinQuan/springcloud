package com.quan.dao;

import com.quan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/1
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
