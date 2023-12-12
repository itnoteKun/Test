package com;

import java.util.Scanner;

public class app15 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        scanner.close();

        if(x>y){
            int t = y;
            y = x;
            x = t;

        }
        if(x>z){
            int t = z;
            z = x;
            x = t;
        }

        if(y>z){
            int t = z;
            z = y;
            y = t;
        }
        System.out.println(x +" "+ y +" "+z);

    }
}
//输入三个整数x,y,z，请把这三个数由小到大输出。
//1.程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x> y则将x与y的值进行交换，然后再用x与z进行比较，如果x> z则将x与z的值进行交换，这样能使x最小。