package com.work4;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class InputF {
    public static void main(String[] args) throws IOException {
        File file =new File("D:/idea_project/dayWork/src/com/work4/pet_test.template");
//        FileOutputStream fileOutputStream = new FileOutputStream("D:/idea_project/dayWork/src/com/work4/pet.template");
        FileOutputStream fileOutputStream=new FileOutputStream(file);   //文件输出流
        OutputStreamWriter writer=new OutputStreamWriter(fileOutputStream,"UTF-8"); //写入流
//        writer.append("你好！\n");
//        writer.append("");
//        FileInputStream fileInputStream=new FileInputStream(file);

        FileReader fileReader=new FileReader(file);
        BufferedReader bf=new BufferedReader(fileReader);



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("请输入:");
        do {
            str = br.readLine();
            writer.append(str+"\n");

        } while (!str.equals("end"));
        String line;
        while ((line=bf.readLine())!=null){
            System.out.println(line);
        }

        bf.close();
        fileReader.close();
        br.close();
        writer.close();
        fileOutputStream.close();



    }


}
