package com.xunHuan;

public class app47 {
    public static void main(String[] args) {


        int i=0;
        while (i<7){
            int number = (int) (Math.random() * 50 + 1);
            i++;
            System.out.print(number+"个"+"\t");
            for (int j=0;j<number;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }



}
