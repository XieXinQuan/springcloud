package com.quan.controller;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/11
 */
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void add(ListNode listNode){
        //如果当前next为空
        if (next == null){
            next = listNode;
        }else {
            //获取最后一个
            ListNode ll = next;
            while (ll.next != null){
                ll = ll.next;
            }
            ll.next = listNode;
        }
    }
    public void addAndCreate(int val){
        //如果当前next为空
        if (next == null){
            next = new ListNode(val);
        }else {
            //获取最后一个
            ListNode ll = next;
            while (ll.next != null){
                ll = ll.next;
            }
            ll.next = new ListNode(val);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(3));
    }
}
