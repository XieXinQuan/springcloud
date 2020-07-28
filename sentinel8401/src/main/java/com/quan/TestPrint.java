package com.quan;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/6/11
 */
public class TestPrint {
    public static void main(String[] args) {
        print(8);
    }

    /**
     *     *
     *    ***
     *   *****
     *  *******
     *   *****
     *    ***
     *     *
     */
    public static void print(int n){
        int [][] arr = new int[2*n-1][2*n-1];
        for (int i = 0; i < arr.length; i++){
            int num;
            if (n > (i + 1)) {
                num = 2 * (i+1) - 1;
            }else if (n == i + 1){
                num = 2*n-1;
            }else {
                num = 2*(2*n - (i+1))-1;
            }
            arr[i][n-1] = 1;
            for (int j = 1; j <= num / 2; j ++){
                arr[i][n-j-1] = 1;
                arr[i][n+j-1] = 1;
            }
        }
        goPrint(arr);
    }
    public static void goPrint(int [][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] == 0 ? " " : "*");
            }
            System.out.println();
        }
    }
}
