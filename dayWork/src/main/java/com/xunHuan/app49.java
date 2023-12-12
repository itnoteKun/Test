package com.xunHuan;

import java.util.Scanner;

public class app49 {
    public static void main(String[] args) {
        String mainArr="Hello,hello,china,Hello";
        System.out.println("字符串:"+mainArr);
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入要查找的子字符串:");
        String arr_1=scanner.nextLine();
        System.out.println("子字符串的个数为:"+countString(mainArr,arr_1));

    }

    private static int countString(String mainArr1,String arr1_1){
        int count=0;
        int index=0;
        index = mainArr1.indexOf(arr1_1,index);

        while (index>=0){
            count++;
            index= mainArr1.indexOf(arr1_1,index+arr1_1.length());
        }
        return count;
    }


}
