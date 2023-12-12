package com.feng;

public class zuCar {

    String brand;
    int num;
    int day;
    public int CalcRent(int day){
        return day;
    }

}

class Bus extends zuCar{
    private int seatcount;
    @Override
    public int CalcRent(int day){
        return 0;
    }

    public int CalcRent(int days,int seatCount){
        if(seatCount<=16){
            num=800*days;
        }
        else if(seatCount>16){
            num=1500*days;
        }
        System.out.println("费用为:"+num);
        return num;
    }

}

class car extends Bus{
    private String type;


    @Override
    public int CalcRent(int day) {

        return 0;
    }

    public int CalcRent(int days,String type){
        //
        if ("1".equals(type)) {
            num = 600 * days;
        } else if ("2".equals(type)) {
            num = 500 * days;
        } else if ("3".equals(type)) {
            num = 300 * days;
        } else {
            System.out.println("输入有误");
        }
        System.out.println("费用为"+num);
        return num;
    }
}

class test{
    public static void main(String[] args) {
        car car = new car();

        car.CalcRent(2,"1");




    }
}













