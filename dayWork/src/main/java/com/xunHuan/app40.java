package com.xunHuan;

public class app40 {
    public static void main(String[] args) {
        String[] strings = {"cak", "fjkro", "fix", "rox", "lond"};

        System.out.println("原始字符串数组:");
        for (String str : strings) {
            System.out.print(str + " ");
        }

        customQuickSort(strings, 0, strings.length - 1);

        System.out.println("\n排序后:");
        for (String str : strings) {
            System.out.print(str + " ");
        }
    }

    public static void customQuickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            customQuickSort(arr, low, pivotIndex - 1);
            customQuickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
