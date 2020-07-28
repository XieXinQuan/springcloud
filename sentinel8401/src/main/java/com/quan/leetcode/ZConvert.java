package com.quan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/19
 */
public class ZConvert {
    public static void main(String[] args) {
        String str = convert("LEETCODEISHIRING", 4);
        System.out.println(str);
        System.out.println("LDREOEIIECIHNTSG".equals(str));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder result = new StringBuilder("");
        List<Integer> firstRowIndex = new ArrayList<>();

        for(int i = 0; i < numRows; i ++){
            //假设 numRows为4
            //第一行:1 -- 7 -- 13
            if (i == 0){
                //添加0
                result.append(s.charAt(0));
                firstRowIndex.add(0);
                while (firstRowIndex.get(firstRowIndex.size() - 1) + 2*(numRows-1) < s.length()){
                    result.append(s.charAt(firstRowIndex.get(firstRowIndex.size() - 1)+2*(numRows-1)));
                    firstRowIndex.add(firstRowIndex.get(firstRowIndex.size() - 1)+2*(numRows-1));
                }
                //预留一位
                firstRowIndex.add(firstRowIndex.get(firstRowIndex.size() - 1)+2*(numRows-1));

            }else {
                for (int j = 0; j < firstRowIndex.size(); j++){
                    Integer firstRow = firstRowIndex.get(j);
                    if (firstRow-(i) >= 0 && firstRow-(i) < s.length() && numRows != 2 && i != numRows - 1) result.append(s.charAt(firstRow-(i)));
                    if (firstRow+(i) < s.length()) result.append(s.charAt(firstRow+(i)));
                }
            }
        }

        return result.toString();
    }
}
