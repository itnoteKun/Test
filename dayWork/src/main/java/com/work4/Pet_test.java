package com.work4;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Pet_test {
    public static final File file =new File("D:/idea_project/dayWork/src/com/work4/pet.txt");
    public static final File file_Mode =new File("D:/idea_project/dayWork/src/com/work4/pet.template");
    static {
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Read read=new Read();
        System.out.println("*********下面将开始获取您爱宠的信息*********");
        pet();
        System.out.println("输入完毕！感谢！");
        System.out.println("下面将显示您的信息：");
        read.read_all(file);




    }

    public static void pet() throws Exception{
        FileWriter fileWriter=new FileWriter(file);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        FileReader fileReader = new FileReader(file_Mode);
        BufferedReader bufferedReader=new BufferedReader(fileReader);

        String line;
        bufferedWriter.append("您好！\n");
        while ((line=bufferedReader.readLine())!=null){
            if (line.indexOf("{name}")!=-1) {
                Scanner scanner=new Scanner(System.in);
                System.out.print("请输入名字:");
                String re=scanner.nextLine();
                line = line.replace("{name}", re);
                System.out.print("请输入性别:");
                String re2=scanner.nextLine();
                line = line.replace("{sex}", re2);
                bufferedWriter.append(line+"\n");
//                System.out.println(line);
//                scanner.close();
            }else if (line.indexOf("{hobby}")!=-1){
                Scanner scanner=new Scanner(System.in);
                System.out.print("请输入爱好:");
                String re3=scanner.next();
                line = line.replace("{hobby}", re3);
                bufferedWriter.append(line);
                scanner.close();
            }
        }
        bufferedWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }




}
//
class Read{
    public void read_all(File file) throws Exception{
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        String arr;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }

    public void read(File file_Mode,File file) throws Exception{
        FileReader fileReader = new FileReader(file_Mode);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        Writer writer=new Writer();
        writer.writer2(file,"您好！");
        while ((line=bufferedReader.readLine())!=null){

            if (line.indexOf("{name}")!=-1) {
                Scanner scanner=new Scanner(System.in);
                System.out.print("请输入名字:");
                String re=scanner.nextLine();
                line = line.replace("{name}", re);
                System.out.print("请输入性别:");
                String re2=scanner.nextLine();
                line = line.replace("{sex}", re2);
                writer.writer2(file,line);
//                System.out.println(line);
//                scanner.close();
            }else if (line.indexOf("{hobby}")!=-1){
                Scanner scanner=new Scanner(System.in);
                System.out.print("请输入爱好:");
                String re3=scanner.next();
                line = line.replace("{hobby}", re3);
                writer.writer2(file,line);
                scanner.close();
            }

        }
        bufferedReader.close();
        fileReader.close();


    }



}

class Writer{
    public void writer2(File file,String string) throws Exception{
        FileWriter fileWriter=new FileWriter(file);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

        bufferedWriter.append("");
        bufferedWriter.close();
        fileWriter.close();
    }
}

