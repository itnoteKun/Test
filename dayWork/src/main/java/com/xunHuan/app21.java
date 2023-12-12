package com.xunHuan;

//阶乘


public class app21 {
    public static void main(String[] args) {
        app21 app21=new app21();
        int num=0;
        for(int i=1;i<=20;i++){
            num=num+app21.leiCheng(i);
        }
        System.out.println(num);


    }

    public int leiCheng(int i){
        if (i==1){
            return 1;
        }else {
            return i*leiCheng(i-1);
        }

    }

}
