package com.xunHuan;

import java.util.Enumeration;
import java.util.Scanner;

public class app24 {
    public static void main(String[] args) {
        app24 app24 = new app24();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字：");
        int number = scanner.nextInt();
        System.out.println("该数的位数为：" + app24.weiShu(number));

        app24.daoXu(number);


    }

    public int weiShu(int number) {
        int i = 1;
        int a = number / 10;
        while (a != 0) {
            i++;
            a = a / 10;
        }
        return i;
    }

    public void daoXu(int number) {
        int i = weiShu(number);
        System.out.print("倒序输出为:");
        for (int j = 1; j <= i; j++) {
            if (j == 1) {
                int a = number % 10;
                System.out.print(a+" ");
            } else {
                int a=number;
                for (int z = 1; z < j; z++) {
                    a = a / 10;
                }
                a=a%10;
                System.out.print(a+" ");
            }


        }


    }


}
