package com.work;

import java.util.Scanner;

public class keyWord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        key2 ad = new key2();
        boolean bo0=false;

        System.out.print("请输入用户名:");

        bo0 = ad.setnam(scanner.nextLine());
        System.out.print("请输入密码:");

        boolean bo1 = ad.setPassword(scanner.nextInt());
        if(bo1){
            System.out.println("不正确"+bo0);
        }else {
            System.out.print("请输入新密码：");
            ad.getPassword(scanner.nextInt());
            System.out.print("修改密码成功，您的密码为："+ad.password);
        }





    }

}
