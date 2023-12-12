package com;

public class zuoye {
    public static void main(String[] args) {
        System.out.println("如下为直角三角形：");
        zhiJiao();
        System.out.println("下图为梯形：");
        tiXing();
        System.out.println("等腰三角形：");
        dengYao();
        System.out.println("下为菱形：");
        lx();


    }
    //菱形
    private static void lx(){
        int a=1;//第i行所需要打印*的数
        int d=7;//长
        int h = (d+1)/2;//行数
        for (int i=1;i<=h;i++){
            int kong=(d-a)/2;
            while (kong!=0){
                System.out.print(" ");
                kong--;
            }
            for (int j=1;j<=a;j++){
                System.out.print("*");
            }
            System.out.println();
            a+=2;
        }
        a-=4;
        for (int z=1; z<=h-1;z++){

            int kong=(d-a)/2;
            while (kong!=0){
                System.out.print(" ");
                kong--;
            }
            for (int x=1;x<=a;x++){
                System.out.print("*");
            }
            System.out.println();
            a-=2;
        }







    }

    /* 等腰直角
        *
       ***
      *****
    */
    private static void dengYao(){
        int a=1;//第i行所需要打印*的数
        int d=7;//低长
        int h = (d+1)/2;//行数
        for (int i=1;i<=h;i++){
            int kong=(d-a)/2;
            while (kong!=0){
                System.out.print(" ");
                kong--;
            }
            for (int j=1;j<=a;j++){
                System.out.print("*");
            }
            System.out.println();
            a+=2;



        }
    }


    //梯形
//    ***
//   *****
//  *******
    private static void tiXing(){
        int a=3;    //上底边
        int b=7;  //下底边长
        int h=3; //横数
        for(int i=1;i<=h;i++){
            int kong=(b-a)/2;
            while (kong!=0){
                System.out.print(" ");
                kong--;
            }
            for (int j=1;j<=a;j++){
                System.out.print("*");
            }

            System.out.println();
            a+=2;

        }


    }

    // 直角
    private static void zhiJiao() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


}
