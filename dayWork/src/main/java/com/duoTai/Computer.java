package main.java.com.duoTai;

import java.util.Scanner;

public class Computer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请选择购买的机器：（1.台式机 2.笔记本 3.PDA）:");
        int number=scanner.nextInt();
        if(number==1){
            taiShi ts=new taiShi();
            ts.display();
        }else if(number==2){
            bijiben bijiben=new bijiben();
            bijiben.display();
        }else if(number==3){
            Pda Pda=new Pda();
            Pda.display();
        }

    }
}

abstract class computer2{
    abstract void display();
}

class taiShi extends computer2{
    public void display(){
        System.out.println("详细清单（台式机）");
        System.out.println("名称： MyPal A696");
        System.out.println("品牌：惠普");
        System.out.println("处理器：Inter XScale");
        System.out.println("显示器：3.5英寸");
        System.out.println("电池类型：1300mAh充电时锂电池");
        System.out.println("TFT触控式屏幕");
    }
}
class bijiben extends computer2{
    public void display(){
        System.out.println("详细清单（笔记本）");
        System.out.println("名称：MateBook");
        System.out.println("品牌：华为");
        System.out.println("处理器：Inter 7");
        System.out.println("显示器：15.9英寸");
        System.out.println("电池类型：2300mAh充电时锂电池");
        System.out.println("144Hz屏幕");
    }

}

class Pda extends computer2{
    public void display(){
        System.out.println("详细清单（PDA）");
        System.out.println("名称：MateBook");
        System.out.println("品牌：PDA");
        System.out.println("处理器：Inter 7");
        System.out.println("显示器：12英寸");
        System.out.println("电池类型：2300mAh充电时锂电池");
        System.out.println("144Hz屏幕");
    }
}





//编写程序，接收用户输入的信息，选择购买计算机。可供选择的有：台式机、笔记本和 PDA
//设定：
//台式机
//属性：型号名称、品牌、处理器类型、显示器、机箱类型
//方法：信息描述
//笔记本
//属性：型号名称、品牌、处理器类型、显示器、电池
//方法：信息描述
//PDA
//属性：型号名称、品牌、处理
//器类型、显示器、电池、触摸屏
//方法：信息描述