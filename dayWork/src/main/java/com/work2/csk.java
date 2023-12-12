package com.work2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 用户信息类
 * 字段：name age vip
 */
public class csk {

    private String name;
    private int age;
    private boolean vip;

    @Override
    public String toString() {
        return name + "  " + age + "  " + vip;
    }

    public static csk creatUsreInfo(String name, int age, boolean vip) {
        //创建对象
        csk userInfo = new csk();

        //字段赋值
        userInfo.name = name;
        userInfo.age = age;
        userInfo.vip = vip;

        return userInfo;
    }

    //主函数
    public static void main(String[] args) {
        //定义一个包含有所有用户对象的ArrayList，元素类型为csk
        ArrayList<csk> user_list = new ArrayList<csk>();

        Scanner scanner = new Scanner(System.in);

        //声明一个布尔变量控制循环
        boolean ifContinue = true;

        //循环创建对象并添加进list中
        do {
            //信息收集
            System.out.print("输入姓名：");
            String name = scanner.nextLine();
            System.out.print("输入年龄: ");
            int age = scanner.nextInt();

            //消耗回车符，以免接收到空值
            scanner.nextLine();
            System.out.print("有没有vip？（有/没有） ");
            String vipInfo = scanner.nextLine();
            boolean vip = vipInfo.equals("有");

            //添加
            user_list.add(creatUsreInfo(name, age, vip));

            //是否继续
            System.out.print("继续？（y/n） ");
            String continueInfo = scanner.nextLine();
            ifContinue = continueInfo.equals("y");
        }while (ifContinue == true);

        //输入所有用户信息
        for (csk userInfo : user_list) {
            System.out.println(userInfo.toString());
        }
    }
}
