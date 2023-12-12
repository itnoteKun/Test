package com.xunHuan;

import java.util.Scanner;

public class app30 {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11};
        Scanner scanner = new Scanner(System.in);
        int insertNum = scanner.nextInt();
        scanner.close();

        int[] newArry = numInsert(sortedArray, insertNum);
        for (int a : newArry) {
            System.out.print(a+" ");
        }
    }

    private static int[] numInsert(int[] sortedArray, int insertNum) {
        int insertIndex = insertIndex(sortedArray, insertNum);
        int[] newArray = new int[sortedArray.length + 1];

        for (int i = 0; i < insertIndex; i++) {
            newArray[i] = sortedArray[i];
        }

        newArray[insertIndex] = insertNum;

        for (int i = insertIndex + 1; i < newArray.length; i++) {
            newArray[i] = sortedArray[i - 1];
        }

        return newArray;
    }


    private static int insertIndex(int[] sortedArray, int insertNum) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (insertNum == sortedArray[mid]) {
                return mid;
            } else if (insertNum < sortedArray[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
