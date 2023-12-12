package com;

import java.util.Scanner;

public class app14 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        System.out.println("请输入日期：");
        int day = scanner.nextInt();
        scanner.close();

        int[] run = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] ping = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum=0;

        boolean runNina=false;
        if((year%4==0 && year%100!=0) || year%400==0){
             runNina=true;
        }
        if(runNina == true){
            while(month-1>0){
                sum +=run[month-2];
                month--;
            }
        }else {
            while (month-1>0){
                sum +=ping[month-2];
                month--;
            }
        }
        sum+=day;
        System.out.println(sum);


    }



}

//输入某年某月某日，判断这一天是这一年的第几天？
//1.程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。