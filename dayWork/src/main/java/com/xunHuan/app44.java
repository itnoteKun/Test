package com.xunHuan;

import java.util.Scanner;

public class app44 {
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void decomposeEven(int evenNumber) {
        for (int i = 2; i <= evenNumber / 2; i++) {
            if (isPrime(i) && isPrime(evenNumber - i)) {
                System.out.println(evenNumber + " = " + i + " + " + (evenNumber - i));
                return;
            }
        }
        System.out.println("无法找到两个素数之和来分解 " + evenNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int evenNumber = scanner.nextInt();
        if (evenNumber % 2 == 0) {
            decomposeEven(evenNumber);
        } else {
            System.out.println("输入不是偶数");
        }
    }
}
