package com.xunHuan;

import java.util.ArrayList;
import java.util.Scanner;

public class app35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("数组长度: ");
        int listLen = scanner.nextInt();
        int i = 0;
        ArrayList<Integer> aList = new ArrayList<Integer>();
        while (i<listLen) {
            aList.add(scanner.nextInt());
            i++;
        }
        System.out.println(aList);

        modifyArray(aList);
    }

    private static void modifyArray(ArrayList<Integer> aList) {
        int maxIndex = 0;
        int minIndex = 0;
        int max = aList.get(0);
        int min = aList.get(0);

        for (int i = 1; i < aList.size(); i++) {
            if (aList.get(i) > max) {
                max = aList.get(i);
                maxIndex = i;
            }
            if (aList.get(i) < min) {
                min = aList.get(i);
                minIndex = i;
            }
        }

        // 交换最大值和第一个元素
        int temp = aList.get(0);
        aList.set(0, max);
        aList.set(maxIndex, temp);

        // 交换最小值和最后一个元素
        temp = aList.get(aList.size() - 1);
        aList.set(aList.size() - 1, min);
        aList.set(minIndex, temp);

        System.out.println("Modified Array: " + aList);
    }
}
