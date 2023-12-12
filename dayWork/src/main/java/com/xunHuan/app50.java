package com.xunHuan;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class app50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        PrintWriter printWriter;
        try {
            fileWriter = new FileWriter("D:\\idea_project\\dayWork\\src\\com\\xunHuan\\stud.txt");

            for (int i = 1; i <= 5; i++) {
                System.out.println("请输入第" + i + "个学生的信息:");
                System.out.print("学生号:");
                int number = scanner.nextInt();
                System.out.print("姓名:");
                String name = scanner.next();
                System.out.print("语文:");
                int grade1 = scanner.nextInt();
                System.out.print("数学:");
                int grade2 = scanner.nextInt();
                System.out.print("英语:");
                int grade3 = scanner.nextInt();
                double average = (grade1 + grade2 + grade3) / 3;
                fileWriter.write("学生"+i+"\n");
                fileWriter.write("学号："+number+"\n");
                fileWriter.write("姓名："+name+"\n");
                fileWriter.write("语文："+grade1+"\n");
                fileWriter.write("数学："+grade2+"\n");
                fileWriter.write("英语："+grade3+"\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
