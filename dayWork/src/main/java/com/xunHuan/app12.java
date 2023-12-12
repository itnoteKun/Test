package com;

import java.util.Scanner;

public class app12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入当月利润：");
        long profit = scanner.nextLong();
        scanner.close();
        double jin = 0;
        if (profit<=10){
            jin=profit * 0.1;
        }else if(profit<=20){
            jin = (profit-10)*0.075 + 10*0.1;
        }else if (profit<=40){
            jin = 10*0.1 + 10*0.075 + (profit-20)*0.05;
        }else if (profit<=60){
            jin = 10*0.1 + 10*0.075 + 20*0.05 + (profit-40)*0.03;
        }else if (profit<=100) {
            jin = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20*0.03 +(profit - 60) * 0.015;
        }else {
            jin = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20*0.03 + 40 * 0.015 + (profit-100)*0.01;
        }
        System.out.println("当月奖金："+jin+"W");



    }
    




}
