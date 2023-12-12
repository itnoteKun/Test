package com.feng;

public class Car_start_stop {
    private String pinpai;
    private String xhao;
    private String color;
    private String speed;

    public void value(){
        this.pinpai="宝马";
        this.xhao="M6";
        this.color="蓝色";
        this.speed="370km/h";
    }

    public void value(String pinpai,String xhao){
        this.pinpai=pinpai;
        this.xhao=xhao;
        this.color="红色";
    }

    public void value(String pinpai,String xhao,String color,String speed){
        this.pinpai=pinpai;
        this.xhao=xhao;
        this.color=color;
        this.speed=speed;

    }

    public void start(){
        System.out.print(this.color+"的"+this.pinpai+this.xhao+"启动");
    }

    public void stop(){
        System.out.print(this.pinpai+this.xhao+"停止,该车时速可以达到"+this.speed);
    }


    public static void main(String[] args) {
        Car_start_stop car = new Car_start_stop();
        car.value();
        car.start();

    }


}
