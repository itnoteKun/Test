package com.feng;

public class student_1 {

    private String xm;
    private int xuehao;
    private String sex;
    private int age;
    private String class_;
    public void setStudent(int xuehao,String xm,String sex,int age,String class_){
        this.xm=xm;
        this.xuehao=xuehao;
        this.sex=sex;
        this.age=age;
        this.class_=class_;

    }
    public void setS(){
        System.out.println("我叫："+this.xm+"，今年"+this.age+"岁"+"\n现在就读于"+this.class_+",我的学号是：S"+this.xuehao);
    }


}
