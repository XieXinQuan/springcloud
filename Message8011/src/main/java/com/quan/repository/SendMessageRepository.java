package com.quan.repository;

import com.quan.entity.SendMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/4
 */
@Repository
public interface SendMessageRepository extends JpaRepository<SendMessage, Long> {
    SendMessage findByMessageId(Long messageId);
}
