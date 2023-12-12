package com.xunHuan;

public class app19 {
    public static void main(String[] args) {

        int h = 11;
        int a = 1;
        for (int b = 1; b <= 7; b++) {

            for (int i = 1; i <= a; i++) {
                System.out.print("*");
            }
            System.out.println();
            if(b<4){
                a+=2;
            }else a-=2;


        }


    }
}
