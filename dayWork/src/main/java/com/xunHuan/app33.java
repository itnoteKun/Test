package com.xunHuan;

import java.util.ArrayList;

public class app33 {
    public static void main(String[] args) {
        int numRows = 10; // 想要打印的行数

        ArrayList<ArrayList<Integer>> yanghuiTriangle = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            if (i == 0) {
                row.add(1);
            } else {
                ArrayList<Integer> prevRow = yanghuiTriangle.get(i - 1);
                row.add(1); // 每一行的第一个数字为1
                for (int j = 1; j < i; j++) {
                    int num = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(num);
                }
                row.add(1); // 每一行的最后一个数字为1
            }
            yanghuiTriangle.add(row);
        }

        // 打印杨辉三角
        for (ArrayList<Integer> row : yanghuiTriangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
