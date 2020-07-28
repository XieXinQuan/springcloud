package com.quan.entity;

import cn.hutool.core.util.IdUtil;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@Table(name = "t_order")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class TOrder {
    public TOrder(Long userId, Long commodityId, BigDecimal price, Integer amount, BigDecimal totalPrice, Long shippingAddressId, Byte status){
        this.userId = userId;
        this.commodityId = commodityId;
        this.price = price;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.shippingAddressId = shippingAddressId;
        this.status = status;
        this.setSerialNumber(IdUtil.getSnowflake(1L, 1L).nextIdStr());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private Long userId;

    private Long commodityId;

    private BigDecimal price;

    private Integer amount;

    private BigDecimal totalPrice;

    private Long shippingAddressId;

    private Byte status;

    @CreatedBy
    private Long createUser;

    @LastModifiedBy
    private Long updateUser;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

}