package com.xunHuan;

public class app41 {
    public static void main(String[] args) {
        System.out.println(findMinimumPeaches(1, 5));
    }

    public static int findMinimumPeaches(int x, int n) {
        if (n == 1) {
            return x;
        } else {
            return findMinimumPeaches((x * 5 + 1) / 4, n - 1);
        }
    }
}
