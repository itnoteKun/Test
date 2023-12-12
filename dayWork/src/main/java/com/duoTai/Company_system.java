package main.java.com.duoTai;

public class Company_system {

    public static void main(String[] args) {

    }
}

abstract class Company{
    int age;
    String name;
    String sex;
    int number;

    abstract void hello(); //抽象方法不写{}

}

class  Manager extends Company{
    int ziLi;
    public void hello(){

    }
}

class Employee extends Company{
    int value;
    public void hello(){

    }
}



