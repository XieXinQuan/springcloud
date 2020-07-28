package com.quan.controller;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/6
 */
public class ThreadLocalTest {
//    public static void main(String[] args) {
//        Thread thread = Thread.currentThread();
//        System.out.println(thread);
//
//    }


    public static void main(String[] args) throws ParseException {
        // 1、 \\d{4} 年，\\d{2}月，\\d{2}日匹配
        String date = "2016205";
        Pattern p = Pattern.compile("^\\d{4}\\d{2}$");
        Matcher match = p.matcher(date);
        if (date != null) {
            if (match.matches()) // 格式验证通过 yyyyMMdd
                System.out.println("Success");
        }
    }
}
