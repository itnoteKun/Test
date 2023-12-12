package com.xunHuan;

public class app23 {
    public static void main(String[] args) {
        app23 app23=new app23();

            System.out.println(app23.leiJia(5));
    }

    public int leiJia(int i){
        if (i==1){
            return 10;
        }else {
            return leiJia(i-1)+2;
        }
    }


}
