package com.quan.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/11
 */
public class TestYearMonth {
    public static Map<Integer, Integer> map;

    static {
        map = new HashMap<>(12);
        map.put(1, 31);
        //预留字段
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = scan.nextInt();
        System.out.println("请输入月份:");
        int month = scan.nextInt();
        System.out.println("请输入天数:");
        int day = scan.nextInt();
        if (year % 4 == 0 && year % 100 != 0 && year %400 == 0) {
            map.put(2, 29);
        }
        int sum = 0;
        for (int i = 1; i < month; i++){
            sum += map.get(i + 1);
        }
        sum += day;
        System.out.println(sum);

    }
}
