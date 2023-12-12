package com.xunHuan;

import java.util.Scanner;

public class app39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个正整数 n: ");
        int n = scanner.nextInt();

        double sum = 0.0;

        if (n % 2 == 0) {
            sum = calculateSumOfEven(n);
        } else {
            sum = calculateSumOfOdd(n);
        }

        System.out.println("计算结果为: " + sum);
    }

    public static double calculateSumOfEven(int n) {
        double sum = 0.0;
        for (int i = 2; i <= n; i += 2) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static double calculateSumOfOdd(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i += 2) {
            sum += 1.0 / i;
        }
        return sum;
    }
}
