package com.duoTai;

import java.util.Scanner;

public class Houses {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("选择需要购买的房子（1.楼房，2.别墅）：");
        int number = scanner.nextInt();
        Houses h=new Houses();

        if (number==2){
            villa villa=new villa();
            villa.buy();

        }else {
            lou lou=new lou();
            lou.buy();
        }




    }


}

abstract class house{
    abstract void buy();
}

class villa extends house{
    public void buy(){
        System.out.println("名称:清凉别墅");
        System.out.println("价格:700万元");
        System.out.println("位置：八达岭");
        System.out.println("面积：300平米");
        System.out.println("拥有花园：3个");
    }
}
class lou extends house{
    public void buy(){
        System.out.println("名称:奢侈楼房");
        System.out.println("价格:10元");
        System.out.println("位置：地中海");
        System.out.println("面积：100平米");
        System.out.println("楼层：1层");
    }
}













