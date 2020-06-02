package com.repository;

import com.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByProductId(Long productId);
}
