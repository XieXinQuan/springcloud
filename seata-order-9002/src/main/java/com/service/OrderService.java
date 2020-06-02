package com.service;

import com.entity.Order;
import com.repository.OrderRepository;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Service
@Slf4j
public class OrderService {
    @Resource
    OrderRepository orderRepository;
    @Resource
    StockService stockService;
    @Resource
    AccountService accountService;

    public Order save(Long userId, Long productId, Integer count, Integer money, Integer status){
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setCount(count);
        order.setMoney(new BigDecimal(money));
        order.setStatus(status);

        orderRepository.save(order);
        return order;
    }

    public Order select(Long id){
        Optional<Order> byId = orderRepository.findById(id);
        return byId.get();
    }

    public void update(Long id){
        Optional<Order> byId = orderRepository.findById(id);
        Order order = byId.get();
        order.setStatus(1);
        orderRepository.save(order);

    }


    @GlobalTransactional
    public void order(){

        Long productId = 1L;
        Long userId = 1L;

        Integer count = 5;
        Integer money = 20;
        log.info("Start Create A Order.");
        Order save = save(userId, productId, count, money, 0);
        log.info("Create Order Success, Order Status Is : {}.", "未完成");

        log.info("Start Call Stock Service...");
        log.info("Start Reduce Stock.");
        stockService.residue(productId, count);
        log.info("Reduce Product : {}, Num :{}, Operate Success.", productId, count);

        log.info("Start Call Account Service...");
        log.info("Start Reduce Account.");
        accountService.residue(userId, money);
        log.info("Reduce User : {}, Money : {}, Operate Success.", userId, money);

        log.info("Update Order Status Is {}.", "已完成");
        update(save.getId());
        log.info("Payment Success.");
        log.info("Trade End...");
    }
}
