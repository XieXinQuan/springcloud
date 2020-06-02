package com.quan.controller;

import com.quan.config.Shop;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/6
 */
@RestController
public class TestController {
    @GetMapping("/")
    public String welcome(){
        return "Hello World";
    }

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @Resource
    RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Shop shop;

    @GetMapping("/sendMessage")
    public String sendDirectMessage(@RequestParam(value = "id", required = false) Long id) {
        Map<String,Object> map=new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
        map.put("hello", "World");
        map.put("id", id == null ? 0L : id);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange

        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "Success";
    }

    @GetMapping("/singleton")
    public String singleton() throws InterruptedException {

        if (getLock()){
            return "Get Lock Success, Continue Operate.";
        }else {
            return "Get Lock Failure, End.";
        }

    }
    public Boolean getLock(){
        return stringRedisTemplate.opsForValue().setIfAbsent("lockKey", "", 3l, TimeUnit.SECONDS);
    }
    @GetMapping("/singleton2")
    public String singleton2() throws InterruptedException {
        System.out.println("...........enter");
        Thread.sleep(3000l);
        System.out.println("...........exit");
        return "Success";
    }

    public static void main(String[] args) {
        Shop shop = new Shop(20);

        System.out.println("开始抢购");

        for (int i = 0; i < 100; i++){
            Sell sell = new Sell(shop);
            new Thread(sell).start();
        }
        System.out.println("结束抢购");
    }


}
class Sell implements Runnable{
    Shop shop;
    public Sell(Shop shop){
        this.shop = shop;
    }
    @Override
    public void run() {
        try {
            if (shop.getNum() > 0){
                synchronized (shop) {
                    if (shop.getNum() > 0) {
                        System.out.println("开始扣减库存,目前剩余：" + shop.getNum());
                        Thread thread = Thread.currentThread();
                        shop.setNum(shop.getNum() - 1);
                        System.out.println("用户：" + thread.getName() + "抢到了一个商品,库存减一,当前剩余库存：" + shop.getNum());
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
