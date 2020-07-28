package com.quan.message;

import com.alibaba.fastjson.JSONObject;
import com.quan.Enum.CommonByteEnum;
import com.quan.Enum.EmailType;
import com.quan.entity.FailureEmail;
import com.quan.entity.SendMessage;
import com.quan.repository.FailureEmailRepository;
import com.quan.repository.SendMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/3
 */
@Component
@RabbitListener(queues = "QuanDirectQueue")//监听的队列名称 TestDirectQueue
@Slf4j
public class DirectReceiver {
    @Resource
    SendMessageRepository sendMessageRepository;
    @Value("${spring.mail.username}")
    String from;
    @Resource
    JavaMailSender mailSender;
    @Resource
    FailureEmailRepository failureEmailRepository;

    @RabbitHandler
    public void process(Map<String, Object> messageMap) {
        if (messageMap == null) return;
        //如果是验证码 不需要入库
        if (EmailType.Code.getKey().equals(Byte.parseByte(messageMap.get("type").toString()))){
            log.info("发送验证码消息到:{},Content:{}", messageMap.get("emailAddress"), messageMap.get("message"));
//            EmailUtil.sendEmail(mailSender, from, messageMap.get("emailAddress"), "幻听科技", messageMap.get("message"), null);
            return;
        }
        Long id = Long.parseLong(messageMap.get("id").toString());

        //先判断缓存有没有， 再判断数据库
        if (MessageUtil.contains(id) || sendMessageRepository.findByMessageId(id) != null) {
            log.info("消息重复, 重复内容:{}", messageMap.toString());
            return;
        }
        MessageUtil.add(id);
        //发送消息 -- 入库
        SendMessage sendMessage = new SendMessage();
        try{
            sendMessage.setMessageId(Long.parseLong(messageMap.get("id").toString()));
            sendMessage.setStatus(CommonByteEnum.Normal.getKey());
            sendMessage.setReceiveUserId(Long.parseLong(messageMap.get("userId").toString()));
            sendMessage.setEmailAddress(messageMap.get("emailAddress").toString());
            sendMessage.setType(Byte.parseByte(messageMap.get("type").toString()));
            sendMessage.setMessage(messageMap.get("message").toString());
            sendMessageRepository.save(sendMessage);
            String title = "";
            EmailType[] values = EmailType.values();
            for (EmailType emailType : values){
                if (sendMessage.getType().equals(emailType.getKey())) title = emailType.getValue();
            }
            title += "通知";

//            EmailUtil.sendEmail(mailSender, from, sendMessage.getEmailAddress(), title, sendMessage.getMessage(), null);
        }catch (Exception exception){
            FailureEmail failureEmail = new FailureEmail();
            failureEmail.setContent(JSONObject.toJSONString(messageMap));
            failureEmail.setExceptionType(exception.getClass().getName());
            failureEmail.setExceptionReason(exception.getMessage());
            failureEmailRepository.save(failureEmail);
            log.info("exception", exception);
        }

    }
}