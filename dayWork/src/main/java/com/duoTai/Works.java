package com.duoTai;

import java.util.Scanner;

public class Works {
    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        System.out.print("请选择工作（1.测试,2.编码）:");
        int number=scanner.nextInt();
        if(number==1){
            Test_work work = new Test_work();
            work.work();
        }else if(number==2){
            bian_work work=new bian_work();
            work.work();
        }


    }
}


abstract class Work{
    String type;
    String work_name;
    int sum;
    int bugNum;


    abstract void work();
}

class Test_work extends Work{


    public void work(){
        this.type="压力测试";
        this.work_name="测试项目已经成功";
        this.sum=20;
        this.bugNum=5;
        System.out.println("工作名称："+this.work_name);
        System.out.println("工作类型："+this.type);
        System.out.println("编写用例个数："+this.sum);
        System.out.println("发现BUg数量："+this.bugNum);


    }
}

class bian_work extends Work{
    public void work(){
        this.type="程序编码";
        this.work_name="编码项目已经完成";
        this.sum=400;
        this.bugNum=4;
        System.out.println("工作名称："+this.work_name);
        System.out.println("工作类型："+this.type);
        System.out.println("编写代码个数："+this.sum);
        System.out.println("有BUg数量："+this.bugNum);
    }
}
















