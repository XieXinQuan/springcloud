package com.quan.controller.interview;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/14
 */
public class TimeoutInterrupt {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadTimeout threadTimeoutFirst = new ThreadTimeout(3);
        threadTimeoutFirst.setName("threadTimeoutFirst");
        Future futureFirst = executorService.submit(threadTimeoutFirst);
        try {

            futureFirst.get(2, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            System.out.println("中断异常");
        }catch (ExecutionException e){
            System.out.println("执行异常");
        }catch (TimeoutException e){
            System.out.println("超时异常");
            if (!futureFirst.isDone()) futureFirst.cancel(true);
        }finally {
            executorService.shutdown();
        }

    }
}
class ThreadTimeout extends Thread{
    long milliseconds;
    ThreadTimeout(int milliseconds){
        this.milliseconds = milliseconds * 1000L;
    }
    @SneakyThrows
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " Enter.");
        Thread.sleep(milliseconds);
        System.out.println(thread.getName() + " End.");
    }
}
