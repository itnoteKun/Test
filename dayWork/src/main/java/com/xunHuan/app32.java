package com.xunHuan;

import java.util.Scanner;

public class app32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = new String();
        do {
            numStr = Long.toString(scanner.nextLong());
            if (numStr.length() < 7) {
                System.out.println("少于七位，重新输入");
            }
        }while (numStr.length() < 7);

        System.out.println(numStr.substring(numStr.length()-7, numStr.length()-3));
    }
}
