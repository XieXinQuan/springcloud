package com.quan.controller;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/4/19
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        log.info("........testA..");
        TimeUnit.SECONDS.sleep(1L);
        return "........testA..";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info("........testB..");
        return "........testB..";
    }



    public static void main(String[] args) throws InterruptedException {

        A a = new A();
        Thread.sleep(5000L);
        String s = ClassLayout.parseInstance(a).toPrintable();
        System.out.println(s);
        synchronized (a){
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
//        synchronized (a){
//            System.out.println(ClassLayout.parseInstance(a).toPrintable());
//        }
    }

}
class A{
    int b = 5;

    public synchronized void lock(){
        while (true) {
            try {
                Thread.sleep(1000L);
                System.out.println("lock" + new SimpleDateFormat("mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
        }

    }
    public static void unlock(){
        while (true) {
            try {
                Thread.sleep(1000L);
                System.out.println("unlock" + new SimpleDateFormat("mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
        }

    }
}

class B{

}
