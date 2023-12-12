package com.xunHuan;

import java.util.Scanner;

public class app26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入星期几的第一个字母：");
        String code = scanner.nextLine();
        switch (code) {
            case "M":
                System.out.println("周一");
                break;
            case "T":
                System.out.print("请输入第二个字母:");
                String a = scanner.nextLine();
                if ("u".equals(a)) {
                    System.out.println("周二");
                } else if ("h".equals(a)) {
                    System.out.println("周四");
                }
                break;
            case "W":
                System.out.println("周三");
                break;
            case "F":
                System.out.println("周五");
                break;
            case "S":
                System.out.print("请输入第二个字母:");
                String b = scanner.nextLine();
                if ("a".equals(b)) {
                    System.out.println("周二");
                } else if ("u".equals(b)) {
                    System.out.println("周四");
                }
                break;
            default:
                System.out.println("输入错误");
                break;
        }


    }


}
