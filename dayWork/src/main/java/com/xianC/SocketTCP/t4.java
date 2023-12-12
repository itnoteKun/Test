package com.xianC.SocketTCP;

import java.util.ArrayList;

public class t4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>(1);
        try{
            arrayList.add(5,2);
            System.out.println(arrayList);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
