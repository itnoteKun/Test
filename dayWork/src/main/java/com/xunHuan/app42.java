package com.xunHuan;

public class app42 {
    public static void main(String[] args) {
        for (int num = 10; num <= 99; num++) {
            int leftSide = 809 * num;
            int rightSide = 800 * num + 9 * num + 1;

            if (leftSide == rightSide) {
                System.out.println("?? 代表的两位数是: " + num);
                System.out.println("809 * ?? 后的结果是: " + leftSide);
                break;
            }
        }
    }
}
