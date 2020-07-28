package com.quan.controller;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/14
 */
public class TestLock {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            TestSynchronizeClass.test();
        }).start();
        new Thread(() -> {

            TestSynchronizeClass.test();
        }).start();
    }

}
class TestSynchronizeClass{
    public synchronized static void test(){
        try{

            System.out.println("开始执行睡眠");
            Thread.sleep(5000l);
            System.out.println("睡眠结束");
        }catch (Exception e){
            System.out.println("异常"+e.getMessage());
        }
    }
}
class TestThread extends Thread{
    @SneakyThrows
    @Override
    public void run(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " Enter.");
        Thread.sleep(1500l);
        System.out.println(thread.getName() + " End.");
    }
}
