package com.xunHuan;

import java.util.ArrayList;
import java.util.Scanner;

public class app28 {
    public static void main(String[] args) {
        int[] arr={23,21,3,46,35};
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int b=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=b;
                }
            }
        }
        for(int brr : arr){
            System.out.print(brr+" ");
        }

    }



}
