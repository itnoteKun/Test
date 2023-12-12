package com.xunHuan;

import java.util.Scanner;

//求一个3*3矩阵对角线元素之和
//1.程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
public class app29 {
    public static void main(String[] args) {
        int[][] a=new int[3][3];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                a[i][j]=scanner.nextInt();
            }
        }
        matrSum(a);



    }
    private static void matrSum(int[][] a){
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[i].length;j++){
                if(i==j) sum1 += a[i][j];
                if(j==a.length-i-1) sum2 += a[i][j];
            }
        System.out.println("矩阵对角线之和分别是："+sum1+"和"+sum2);
    }

}
