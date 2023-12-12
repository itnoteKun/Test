package com.xunHuan;
//将一个数组逆序输出。
//1.程序分析：用第一个与最后一个交换。
public class app31 {
    public static void main(String[] args) {
        int[] aList = new int[]{2, 3 ,5, 7, 9, 13, 16, 38};
        reversePrint(aList);
    }

    private static void reversePrint(int[] aList) {
        for (int i=aList.length-1; i>=0; i--) {
            System.out.print(aList[i]+" ");
        }
    }
}

