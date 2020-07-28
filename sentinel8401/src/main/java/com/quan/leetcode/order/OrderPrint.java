package com.quan.leetcode.order;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/15
 */
public class OrderPrint {
    private AtomicInteger first = new AtomicInteger(0);
    private AtomicInteger second = new AtomicInteger(0);
    private OrderPrint(){

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.incrementAndGet();

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("second");
        }).start();
        new Thread(() -> {
            System.out.println("first");
        }).start();
        new Thread(() -> {
            System.out.println("third");
        }).start();

//        ThreadFirst first = new ThreadFirst();
//        ThreadSecond second = new ThreadSecond();
//        ThreadThird third = new ThreadThird();
//        first.start();
//        first.join();
//        second.start();
//        second.join();
//        third.start();
//        third.join();
    }
}
class ThreadFirst extends Thread{
    @Override
    public void run(){
        System.out.println("Start");
    }
}
class ThreadSecond extends Thread{
    @Override
    public void run(){
        System.out.println("Second");
    }
}
class ThreadThird extends Thread{
    @Override
    public void run(){
        System.out.println("Third");
    }
}
