package com.quan.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/3
 */
@Configuration
public class DirectRabbitConfig {
    //队列 起名：QuanDirectQueue
    @Bean
    public Queue QuanDirectQueue() {
        return new Queue("QuanDirectQueue",true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange QuanDirectExchange() {
        return new DirectExchange("QuanDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(QuanDirectQueue()).to(QuanDirectExchange()).with("QuanDirectRouting");
    }
}
