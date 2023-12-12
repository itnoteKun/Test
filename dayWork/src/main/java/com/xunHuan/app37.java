package com.xunHuan;

import java.util.LinkedList;
import java.util.Scanner;

public class app37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 3;

        int survivor = findSurvivor(n, k);
        System.out.println("最后留下的是原来第 " + survivor + " 号的那位。");
    }

    public static int findSurvivor(int n, int k) {
        LinkedList<Integer> circle = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int index = 0;
        while (circle.size() > 1) {
            index = (index + k - 1) % circle.size();
            circle.remove(index);
        }
        return circle.get(0);
    }
}
