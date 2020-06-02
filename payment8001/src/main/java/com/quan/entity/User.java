package com.quan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 *
 * @author Quan
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
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

}