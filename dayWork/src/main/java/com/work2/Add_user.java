package com.work2;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_user {
    private String name;
    private int age;
    private boolean vip;

    public static void main(String[] args) {
        ArrayList<Add_user> name_list = new ArrayList<Add_user>();

//        Add_user arr=new Add_user();

        Scanner scanner = new Scanner(System.in);
        boolean bo = true;

        while (bo == true) {

            System.out.print("输入姓名：");
            String name = scanner.nextLine();
            System.out.print("输入年龄: ");
            int age = scanner.nextInt();//不接受回车

            scanner.nextLine();

            System.out.print("输入会员(y/n): ");
            String v=scanner.nextLine();
            boolean vip = v.equals("y");


            name_list.add(add_list(name,age,vip));

            System.out.print("是否继续（y/n）:");
//            scanner.nextLine();
            String countine = scanner.nextLine();
            bo = countine.equals("y");
        }
        for (Add_user user : name_list){
            System.out.print(user.name+"  "+user.age+"  "+user.vip);
        }

    }

    private static Add_user add_list(String name, int age, boolean bool){
        Add_user add=new Add_user();
        add.name=name;
        add.age=age;
        add.vip=bool;
        return add;
    }



}
