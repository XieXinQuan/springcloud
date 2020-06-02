package com.quan.message;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/28
 */
public class MessageUtil {
    public static Set<Long> messageSet = new HashSet<>();
    public static boolean contains(Long id){
        return messageSet.contains(id);
    }
    public static void add(Long id){
        messageSet.add(id);
    }
}
