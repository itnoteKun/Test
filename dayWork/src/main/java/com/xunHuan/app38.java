package com.xunHuan;

import java.util.Scanner;

public class app38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        System.out.println(getLength(str));
    }

    private static int getLength(String str) {
        int length =0;
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            length++;
        }

        return length;
    }
}
