package com;

import java.util.Scanner;

public class tuzi {
    public static void main(String[] args) {
        int a=1;
        int b = 1;
        int c=0;
        int day =1;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入月份：");
        day = scan.nextInt();

        for(int i = 1 ;i<=day;i++){
            if(i==1||i==2){
                System.out.println(a);
            }else{
            c =a+b;
            a=b;
            b=c;
            System.out.println(c);}

        }
        scan.close();

        rabbit(day);
    }

    public static int rabbit(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return rabbit(n-1)+rabbit(n-2);
        }
    }





}







