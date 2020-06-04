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
@Table(name = "send_message")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class SendMessage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long receiveUserId;

    private String emailAddress;

    private String message;

    private Long messageId;

    private Byte status;

    private Byte type;

    @CreatedDate
    private Date createTime;
}
