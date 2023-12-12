package com.work2;

import java.util.ArrayList;
import java.util.Scanner;

public class keHu {

    public static ArrayList<String> arr =new ArrayList<String>();


    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);

        char ar='y';
        boolean bo=true;
        int i=0;
        while(ar=='y') {
            System.out.print("请输入客户的姓名:");
            String name = scanner.next();
            arr.add(name);
            System.out.print("继续输入吗？(y/n):");
            ar = scanner.next().charAt(0);
            i++;
            if (ar=='n'){
                System.out.println("=========================");
            }
        }
        System.out.println("     客户姓名列表：          ");
        System.out.println("=========================");
        for(int y=0;y<i;y++){
            System.out.print(arr.get(y)+"\t");
        }


        System.out.print("\n请输入要修改的用户名:");
        String oldname = scanner.next();
        System.out.print("请输入修改后的用户名:");
        String newname = scanner.next();

        for(int z = 0;z<1000;z++){
            if(arr.get(z).equals(oldname)){
                arr.set(z,newname);
                break;
            }
        }
        System.out.println("     客户姓名列表：          ");
        System.out.println("=========================");
        for(int y=0;y<i;y++){
            System.out.print(arr.get(y)+"\t");
        }

    }


    public boolean editName (String oldName, String newName){



        return true;
    }




}
