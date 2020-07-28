package com.quan.leetcode;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/18
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String res = longestPalindrome("ccc");
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) return "";
        if (s.length() == 1) return s;
        String res = "";
        int currIndex = 0;
        while (currIndex < s.length()){
            //找相同的
            if (currIndex + 1 < s.length() && s.charAt(currIndex) == s.charAt(currIndex + 1)){
                int startIndex = currIndex;
                int endIndex = currIndex + 1;
                while (startIndex >= 0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)){
                    startIndex --;
                    endIndex ++;
                }
                String str = s.substring(startIndex + 1, endIndex);
                if (res.length() < str.length()) res = str;
            }
            //找间隔相同
            if (currIndex - 1 >= 0 && currIndex + 1 < s.length() && s.charAt(currIndex - 1) == s.charAt(currIndex + 1)){
                int startIndex = currIndex - 1;
                int endIndex = currIndex + 1;
                while (startIndex >= 0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)){
                    startIndex --;
                    endIndex ++;
                }
                String str = s.substring(startIndex + 1, endIndex);
                if (res.length() < str.length()) res = str;
            }
            currIndex ++;
        }
        if (res.length() == 0) return s.substring(0, 1);
        return res;
    }
}
