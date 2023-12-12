package com.feng;

public class class_1 {
    private String name;
    private int number;
    private String[] kouhao = {"口号口号1","口号口号2"};

    public void setclass(String name,int number){
        this.name = name;
        this.number = number;
    }
    public void getclass(int number){
        System.out.println(this.name+"班的编号为:"+this.number);
        System.out.println("这个班级的口号："+this.kouhao[number]);
    }


}
