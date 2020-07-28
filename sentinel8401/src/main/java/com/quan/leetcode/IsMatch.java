package com.quan.leetcode;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/25
 */
public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("huanting", "huanting"));
    }
    public static boolean isMatch(String s, String p){
        //. 一个任意字符
        //* 0个或多个前一位的字符
        if (".*".equals(p)) return true;

        p = p.replaceAll("[*]+", "*");
        //当前s的下标
        int currIndex = 0;
        //当前正则p的下标
        int currRegIndex = 0;
        //遍历正则表达式:
        //1. 正常字母?
        //          匹配? 后一位有* ? 有:while->
        //          不匹配? 后一位有* ? 有?通过:不通过
        //2. 正常
        while (currRegIndex < p.length()){
            char regChar = p.charAt(currRegIndex);
            //. or *
            if (regChar == '.'){
                currIndex++;
                currRegIndex++;
            }else if (regChar == '*'){
                if (currRegIndex == 0) return false;
                //前一个字符

            }else {
                if (regChar != s.charAt(currIndex) && (currIndex + 1 < s.length() && s.charAt(currIndex + 1) != '*')){
                    return false;
                    //往后看一位
                }else if (p.charAt(currRegIndex + 1) == '*'){
                    currRegIndex += 2;
                    //找到不相等的下标
                    while (currIndex < s.length() && s.charAt(++currIndex) == regChar);
                }else {
                    currIndex ++;
                    currRegIndex ++;
                }
            }
        }

        return false;
    }
}
