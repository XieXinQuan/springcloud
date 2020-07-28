package com.quan.leetcode;

import java.util.Arrays;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/11
 */
public class findMedianSortedArrays {
    public static void main(String[] args) {
        findMedianSortedArrays1(new int[]{1, 2}, new int[]{3, 4});
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int currNum2Index = 0;
        for (int i = 0; i < nums1.length; i++){
            while (currNum2Index < nums2.length && nums2[currNum2Index] <= nums1[i]){
                result[i+currNum2Index] = nums2[currNum2Index];
                currNum2Index ++;
            }
            result[i+currNum2Index] = nums1[i];
        }
        if (nums1.length + currNum2Index != result.length){
            while (currNum2Index < nums2.length){
                result[nums1.length + currNum2Index] = nums2[currNum2Index];
                currNum2Index ++;
            }
        }
        double res = 0.0;
        if (result.length % 2 == 0){
            res = (result[result.length / 2] + result[result.length / 2 - 1]) / 2.0;
        }else {
            res = result[result.length / 2];
        }
        System.out.println(Arrays.toString(result));
        System.out.println(res);
        return res;
    }
}
