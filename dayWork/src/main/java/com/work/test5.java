package com.work;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入Java成绩:");
        int a = scanner.nextInt();
        System.out.println("请输入C成绩:");
        int b = scanner.nextInt();
        System.out.println("请输入DB成绩:");
        int c = scanner.nextInt();
        int sum;
        float jun;
        test5_class ts5 = new test5_class();
        sum = ts5.sumgrd(a,b,c);
        jun = ts5.jun(a,b,c);
        System.out.println("总成绩为："+sum);
        System.out.println("平均分为："+jun);






    }

}
