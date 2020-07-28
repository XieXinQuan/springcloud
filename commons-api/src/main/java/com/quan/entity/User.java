package com.quan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String name;

    private String shoreName;

    private String englishName;

    private String email;

    private Byte sex;

    private String iphone;

    private Byte status;

    private BigDecimal balance;

    private String password;

    private String encryptPassword;

    private Byte isVip;

    private Byte isMerchant;


}
