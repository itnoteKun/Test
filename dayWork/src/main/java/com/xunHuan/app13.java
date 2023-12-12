package com;

public class app13 {
    public static void main(String[] args) {
        for (int i=1;i<100000;i++){
            double sqrt = Math.sqrt(Math.sqrt(i+100)+168);
            if(sqrt%1==0){
                System.out.println(i);
            }
        }
    }
}

//一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
//1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上168后再开方，如果开方后的结果满足如下条件，即是结果。请看具体分析：
