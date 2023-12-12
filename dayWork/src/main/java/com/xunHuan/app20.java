package com.xunHuan;

public class app20 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum = sum + (zi(i) / mu(i));
        }
        System.out.println(sum);

    }

    public static double zi(int i) {
        if (i == 1) {
            return 2;
        } else {
            return mu(i - 1) + zi(i - 1);
        }
    }

    public static double mu(int i) {
        if (i == 1) {
            return 1;
        } else {
            return zi(i - 1);
        }
    }


}
