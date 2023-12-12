package com.xunHuan;

import com.sun.jmx.snmp.SnmpNull;

import java.util.Scanner;

public class app25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个5位数:");
        int number = scanner.nextInt();
        app24 app24=new app24();
        int weishu=app24.weiShu(number);
        if(weishu!=5){
            System.out.println("您输入的不是5位数");
        }else {
            app25 app25=new app25();
            app25.HuiWenShu(number);
        }



    }

    private void HuiWenShu(int number) {
        int ge, shi, bai, qian, wan;
        wan = number / 10000;
        qian = number / 1000 % 10;
        bai = number / 100 % 10;
        shi = number / 10 % 10;
        ge = number % 10;
        if (wan == ge) {
            if (qian == shi) {
                System.out.println(number + "是回文数");
            } else {
                System.out.println(number + "不是回文数");
            }
        } else System.out.println(number + "不是回文数");


    }


}
