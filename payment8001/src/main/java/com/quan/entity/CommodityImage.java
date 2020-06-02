package com.quan.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "commodity_image")
@Data
@Entity
public class CommodityImage {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long commodityId;
    private String fileName;
    private String size;
    private Byte status;
    private String imageUrl;
    private String createUser;
    private String updateUser;
    private Timestamp createTime;
    private Timestamp updateTime;

}
