package com.xunHuan;

import java.util.Scanner;

//判断一个素数能被几个9整除
public class app45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个素数：");
        int prime = scanner.nextInt();

        if (isPrime(prime)) {
            int count = countNinesDivisible(prime);
            System.out.println("这个素数能被 " + count + " 个9整除。");
        } else {
            System.out.println("输入不是素数。");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countNinesDivisible(int prime) {
        int count = 0;
        while (prime % 9 == 0) {
            prime /= 9;
            count++;
        }
        return count;
    }



}
