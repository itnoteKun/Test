package main.java.com.duoTai;

import java.util.Enumeration;
import java.util.Scanner;

public class drinks {
    public static void main(String[] args) {
        coffee coffee=new coffee();
        water water=new water();
        cole cole=new cole();

        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择饮料(1.咖啡 2.矿泉水 3.可乐)");
        int drk=scanner.nextInt();
        System.out.print("请输入购买容量:");
        int rong=scanner.nextInt();
        if(drk==1){
            coffee.rong=rong;
            coffee.buy();
        }else if(drk==2){
            water.rong=rong;
            water.buy();
        }else {
            cole.rong=rong;
            cole.buy();
        }



    }
}
abstract class drinking{
    int rong;
    abstract void buy();
}

class coffee extends drinking{
    public void buy(){
        String[] arr={"加糖","加奶","什么都不加"};

        Scanner scanner=new Scanner(System.in);
        System.out.print("请问是否要配料:(1.加糖 2.加奶 3.什么都不加):");
        int drk2=scanner.nextInt();

        System.out.println("名称：咖啡");
        System.out.println("添加配料:"+arr[drk2+1]);
        System.out.println("容量:"+this.rong);


    }
}
class water extends drinking{
    public void buy(){
        System.out.println("名称：矿泉水");
        System.out.println("容量:"+this.rong);
    }
}
class cole extends drinking{
    public void buy(){
        String[] arr={"加糖","什么都不加"};
        Scanner scanner=new Scanner(System.in);
        System.out.print("请问是否要配料:(1.加糖 2.什么都不加):");
        int drk2=scanner.nextInt();
        System.out.println("名称：可乐");
        System.out.println("配料添加:"+arr[drk2+1]);
        System.out.println("容量:"+this.rong);
    }
}


