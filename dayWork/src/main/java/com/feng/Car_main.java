package com.feng;

public class Car_main {
    public static void main(String[] args) {
        Car car1 = new Car("type1","001");
        Car2 car2 = new Car2("typ2","002");
        Car_Person  sell= new Car_Person();
        sell.setName("caosk");
        sell.sell(car1);
        sell.sell(car2);
        sell.sell_num(car1,20);

    }
}
