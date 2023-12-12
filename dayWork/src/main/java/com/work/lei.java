package com.work;

import java.util.Scanner;

public class lei {
    public static void main(String[] args) {

        int come = 1;
        while (come==1){
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入姓名：");
            String name = scanner.nextLine();
            if(name=="n"){
                System.out.println("退出程序");
                come = 2;
                break;
            }
            System.out.print("请输入年龄：");
            int age = scanner.nextInt();
            scanner.close();
            if(age>18){
                System.out.println(name+"的年龄为："+age+",门票价格为：20元");
            }else{
                System.out.println(name+"的年龄为："+age+",门票免费");
            }

        }






    }
    private static void youRen(){

    }


}

