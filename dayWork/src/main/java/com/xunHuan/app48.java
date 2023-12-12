package com.xunHuan;

import java.util.Scanner;

public class app48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个四位数:");
        int number = scanner.nextInt();
        scanner.close();

        System.out.println("加密后："+AddPassword(number));


    }

    private static int AddPassword(int number) {
        int ge = (number % 10 + 5) % 10;
        int shi = (number / 10 % 10 + 5) % 10;
        int bai = (number / 100 % 10 + 5) % 10;
        int qian = (number / 1000 % 10 + 5) % 10;
        int numbers = ge * 1000 + shi * 100 + bai * 10 + qian;
        return numbers;

    }
}
