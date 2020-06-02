package com.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Table(name = "t_order")
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;
}
