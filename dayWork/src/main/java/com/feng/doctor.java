package com.feng;

public class doctor {
     String name;
     int age;
     String sex;
     String home;
     String work;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHome() {
        return home;
    }

    public String getSex() {
        return sex;
    }

    public String getWork() {
        return work;
    }
}

class junren extends doctor{
    private int junAge;

    public void setJunAge(int junAge) {
        this.junAge = junAge;

    }

    public int getJunAge() {
        return junAge;
    }
}
class test02{
    public static void main(String[] args) {
        doctor doctor=new doctor();
        doctor.setName("李四");
        doctor.setAge(21);
        doctor.setSex("男");
        doctor.setHome("内科");
        doctor.setWork("主任");
        System.out.println("姓名:"+doctor.name);
        System.out.println("年龄:"+doctor.age);
        System.out.println("所在科室:"+doctor.home);
        System.out.println("职位:"+doctor.work);


    }
}






