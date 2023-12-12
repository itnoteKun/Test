package com.feng;

public class Car_Person {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sell(Car type){
        System.out.println(this.name+"正在卖的车型:"+type.getType()+"\t编号:"+type.getId());
    }
    public void sell(Car2 type){
        System.out.println(this.name+"正在卖的车型:"+type.getType()+"\t编号:"+type.getId());
    }

    public void sell_num(Car type,int num){
        System.out.println(this.name+"正在卖的车型:"+type.getType()+"\t数量为:"+num);
    }
    public void sell_num(Car2 type,int num){
        System.out.println(this.name+"正在卖的车型:"+type.getType()+"\t数量为:"+num);
    }

}
