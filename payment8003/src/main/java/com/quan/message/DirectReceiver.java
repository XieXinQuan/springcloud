package com.quan.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/28
 */
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process(Map<String, Object> testMessage) {
        Long id = Long.parseLong(testMessage.get("id").toString());
        if (MessageUtil.contains(id)) {
            System.out.println("消息重复, 重复内容:" + testMessage.toString());
            return;
        }
        MessageUtil.add(id);
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
}
