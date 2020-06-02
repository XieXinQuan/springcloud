package com.quan.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/18
 */
@Data
public class Commodity {
    private Long id;

    private String title;

    private String name;

    private String shortName;

    private String category;

    private Date createTime;

    private Date updateTime;

    private Long createUser;

    private Long updateUser;
}