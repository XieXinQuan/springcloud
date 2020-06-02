package com.repository;

import com.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
