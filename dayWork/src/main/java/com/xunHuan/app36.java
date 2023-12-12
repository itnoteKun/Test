package com.xunHuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class app36 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(43);
        numList.add(23);
        numList.add(321);
        numList.add(901);
        numList.add(1131);

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        ArrayList newArray = changeList(numList, m);
        System.out.println(newArray);
    }

    private static ArrayList<Integer> changeList(ArrayList<Integer> numList, int m) {
        List<Integer> leftList = numList.subList(0, m);
        List<Integer> rightList = numList.subList(m, numList.size());

        ArrayList<Integer> newList = new ArrayList<Integer>();
        newList.addAll(rightList);
        newList.addAll(leftList);

        return newList;
    }
}
