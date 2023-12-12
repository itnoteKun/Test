package com.xunHuan;

import java.util.Scanner;

public class app46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入第一组字符：");
        String str1 = scanner.nextLine();
        System.out.print("输入第二组字符：");
        String str2 = scanner.nextLine();
        scanner.close();

        String result = str1 + str2;
        System.out.print("拼接后的字符：");
        System.out.println(result);
    }
}
