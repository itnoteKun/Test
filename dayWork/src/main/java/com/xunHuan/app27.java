package com.xunHuan;

public class app27 {
    public static void main(String[] args) {

        int sum = 3;

        for (int i=3;i<=100; i++){
            for (int j=2;j<i;j++){
                if(i%j==0){
                    break;
                }else if(j==i-1){
                    System.out.println(i);
                    sum+=i;
                }
            }
        }
        System.out.println("100之间的素数和："+sum);
    }
}
