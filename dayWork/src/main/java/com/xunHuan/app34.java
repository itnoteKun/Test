package com.xunHuan;

import java.util.ArrayList;
import java.util.Scanner;

public class app34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(a);
        num.add(b);
        num.add(c);
        num.sort(null);

        System.out.println(num);
    }
}
