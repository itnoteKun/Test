package com.work;

public class Admin {
    private String name;
    private int password;

    public void setName(String name){
        this.name = name;
    }
    public void getName(){
        System.out.print("姓名："+name+",");
    }

    public void setPassword(int password){
        this.password=password;
    }

    public void getPassword() {
        System.out.print("密码："+password);
        System.out.println();
    }
}
