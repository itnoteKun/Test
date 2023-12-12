package com.work2;

import java.util.Arrays;

public class Custmoer {
    public static void main(String[] args) {
        String[] name={"Jakc","Ma","Jscg","Oad"};
        show(name);
    }
    public static void show(String[] name){
        System.out.println("排序前:");
        for(int i=0;i<name.length;i++){
            System.out.print(name[i]+"\t");
        }

        Arrays.sort(name);
        System.out.println("\n排序后:");
        for(int i=0;i<name.length;i++){
            System.out.print(name[i]+"\t");
        }
    }

}
