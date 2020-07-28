package com.quan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommoditySearch {
    private Long id;

    private String title;

    private String name;

    private Byte category;

    private BigDecimal price;

    private Byte status;

    private String imageUrl;

    private Long shopId;

}
