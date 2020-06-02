package com.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/21
 */
@Table(name = "t_storage")
@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;

}
