package com.quan.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
@Table(name = "failure_email")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class FailureEmail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String exceptionType;

    private String exceptionReason;

    @CreatedDate
    private Date createTime;
}
