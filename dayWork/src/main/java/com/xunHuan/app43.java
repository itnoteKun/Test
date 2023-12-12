package com.xunHuan;

public class app43 {
    public static void main(String[] args) {
        int count = countOddNumbers();
        System.out.println("0到7所能组成的奇数个数为: " + count);
    }

    public static int countOddNumbers() {
        int count = 0;
        for (int a = 0; a <= 7; a++) {
            for (int b = 0; b <= 7; b++) {
                for (int c = 0; c <= 7; c++) {
                    for (int d = 0; d <= 7; d++) {
                        for (int e = 1; e <= 7; e += 2) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
