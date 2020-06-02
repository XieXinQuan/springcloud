package com.service;

import com.entity.Stock;
import com.repository.StockRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Service
public class StockService {
    @Resource
    StockRepository stockRepository;

    public Stock save(Long productId, Integer total, Integer used, Integer residue){
        Stock stock = new Stock();
//        stock.s
        stock.setProductId(productId);
        stock.setTotal(total);
        stock.setUsed(used);
        stock.setResidue(residue);
        stockRepository.save(stock);
        return stock;
    }

    public Stock select(Long id){
        Optional<Stock> byId = stockRepository.findById(id);
        return byId.get();

    }

    public void residue(Long productId, Integer count) {

        Stock stock = stockRepository.findByProductId(productId);

        if (count > stock.getResidue()) throw new RuntimeException("库存不足.");
        Integer residue = stock.getResidue() - count;
        Integer used = stock.getUsed() + count;
        stock.setResidue(residue);
        stock.setUsed(used);
        stockRepository.save(stock);
    }
}
