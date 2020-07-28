package com.quan.controller.simulation;

import com.quan.controller.ListNode;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/12
 */
public class ProductOOM {
    public static void main1(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.addAndCreate(2);
        listNode.addAndCreate(3);
        listNode.addAndCreate(4);
        listNode.addAndCreate(5);
        System.out.println(listNode);
    }
    public static void main(String[] args) {
        new Thread(() -> {
            Thread thread = Thread.currentThread();
            thread.setName("QuanFirst");
            ListNode listNode = new ListNode(1);
//            List<Byte[]> byteList = new ArrayList<>();
//            Byte[] bytes;
            int i = 1;
            while (i++ < Integer.MAX_VALUE){
                try {
                    Thread.sleep(20l);
//                    bytes = new Byte[1024*1024*5];
//                    byteList.add(bytes);
                    listNode.addAndCreate(i);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Thread thread = Thread.currentThread();
            thread.setName("QuanSecond");
            while (true){
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Thread thread = Thread.currentThread();
            thread.setName("QuanThird");
            while (true){
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
