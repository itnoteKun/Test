package com.work;

public class test4_user {
    private String[] name={"lucy","Mary"};
    private int[] pas={21,28};
    private String[] sex={"男","男"};
    private String[] time={"2011-01-08","2000-01-01"};
    private String[] dJi={"无敌小菜鸟","超级智多星"};

    public  void display(){
        for(int i=0;i<this.name.length;i++){
            System.out.println("大家好！我是"+name[i]+",今年"+pas[i]+"岁");
            System.out.println("我是"+time[i]+"注册的，目前的等级是："+dJi[i]);
            System.out.println("===================================");
        }
    }

}
