package com.work3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Information {


    static LinkedList<QuestionInfo> question_list = new LinkedList<QuestionInfo>();
    static Scanner scanner = new Scanner(System.in);
    static QuestionInfo questionInfo = new QuestionInfo();
    static int count=0;
    static int addd=0;
    public static void main(String[] args) {

        question_list.add(questionInfo.question(1, "在Java中，以下合法的变量名是（）。", "_Sum", "var%", "9var", "My name", "Java", "A"));
        question_list.add(questionInfo.question(2, "以下关于Java类和对象描述正确的是（）。", "一个类只能有一个对象", "对象是类的具体实例", "对象是对现实世界中客观事物的抽象", "使用class关键字定义一个对象", "Java", "B"));
        question_list.add(questionInfo.question(3,"在WinForms中，消息框的返回值为（）类型。" , "MessageBox" , "DialogResult" , "Yes" , "No" , "JSP" , "B"));
        question_list.add(questionInfo.question(4,"在WinForms中，消息框的返回值为（）类型。" , "MessageBox" , "DialogResult" , "Yes" , "No" , "C#" , "B"));


        System.out.println("***********欢迎使用试题管理系统*********\n");
        int choice = 0;
        while (choice != 6) {
            System.out.print("请选择操作（1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题5.删除试题 6.退出系统）:");
            choice = scanner.nextInt();
            if (choice == 6) {
                System.out.println("系统已退出......祝您愉快!");
                break;
            }
            switch (choice){
                case 1:
                    show_question();
                    break;
                case 2:
                    consult();
                    break;
                case 3:
                    searchName();
                    break;
                case 4:
                    add();
                    break;
                case 5:
                    removeId();
                    break;
            }
        }

    scanner.close();
    }

//显示问题
    public static void show_question () {
        Iterator<QuestionInfo> iterator= question_list.iterator();
        while (iterator.hasNext()){//只是判断是否存在下一个元素
            QuestionInfo questionInfo=iterator.next();
            System.out.println(questionInfo.getQuestionId()+". "+questionInfo.getQuestion());
            System.out.println("\t选项A:"+questionInfo.getOptionA());
            System.out.println("\t选项B:"+questionInfo.getOptionB());
            System.out.println("\t选项C:"+questionInfo.getOptionC());
            System.out.println("\t选项D:"+questionInfo.getOptionD());
            System.out.println("答案:"+questionInfo.getAnswer());
        }
    }
    public static void  add(){
        System.out.println(question_list.size());
        System.out.print("请输入科目：（1.Java  2.C#  3.JSP）");
        String subject=scanner.next();
        System.out.print("请输入新的题干：");
        String question=scanner.next();
        System.out.print("请输入新的选项A：");
        String optionA = scanner.next();
        System.out.print("请输入新的选项B：");
        String optionB = scanner.next();
        System.out.print("请输入新的选项C：");
        String optionC = scanner.next();
        System.out.print("请输入新的选项D：");
        String optionD = scanner.next();
        System.out.print("请输入新的答案：");
        String answer = scanner.next();
        question_list.add(questionInfo.question(question_list.size()+1+count,question,optionA,optionB,optionC,optionD,subject,answer));
        System.out.println("添加成功!");
        addd++;
    }

    public static void consult(){
        System.out.print("请输入要查询的科目:（1.Java  2.C#  3.JSP）");
        int subject =scanner.nextInt();
        Iterator<QuestionInfo> Iterator= question_list.iterator();

        switch (subject){
            case 1:
                while (Iterator.hasNext()){
                    QuestionInfo questionInfo=Iterator.next();
                    if (questionInfo.getSubject().equals("Java")){
                        System.out.println(questionInfo.getQuestionId()+". "+questionInfo.getQuestion());
                        System.out.println("\t选项A:"+questionInfo.getOptionA());
                        System.out.println("\t选项B:"+questionInfo.getOptionB());
                        System.out.println("\t选项C:"+questionInfo.getOptionC());
                        System.out.println("\t选项D:"+questionInfo.getOptionD());
                        System.out.println("答案:"+questionInfo.getAnswer());
                    }
                }
                break;
            case 2:
                while (Iterator.hasNext()){
                    QuestionInfo questionInfo=Iterator.next();
                    if (questionInfo.getSubject()=="C#"){
                        System.out.println(questionInfo.getQuestionId()+". "+questionInfo.getQuestion());
                        System.out.println("\t选项A:"+questionInfo.getOptionA());
                        System.out.println("\t选项B:"+questionInfo.getOptionB());
                        System.out.println("\t选项C:"+questionInfo.getOptionC());
                        System.out.println("\t选项D:"+questionInfo.getOptionD());
                        System.out.println("答案:"+questionInfo.getAnswer());
                    }
                }
                break;
            case 3:
                while (Iterator.hasNext()){
                    QuestionInfo questionInfo=Iterator.next();
                    if (questionInfo.getSubject()=="JSP"){
                        System.out.println(questionInfo.getQuestionId()+". "+questionInfo.getQuestion());
                        System.out.println("\t选项A:"+questionInfo.getOptionA());
                        System.out.println("\t选项B:"+questionInfo.getOptionB());
                        System.out.println("\t选项C:"+questionInfo.getOptionC());
                        System.out.println("\t选项D:"+questionInfo.getOptionD());
                        System.out.println("答案:"+questionInfo.getAnswer());
                    }
                }
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
    }

    public static void searchName(){
        System.out.print("请输入题干:");
        String question = scanner.next();
        Iterator<QuestionInfo> iterator=question_list.iterator();
        while (iterator.hasNext()){
            QuestionInfo questionInfo=iterator.next();
            if (questionInfo.getQuestion().indexOf(question) != -1){
                System.out.println(questionInfo.getQuestionId()+". "+questionInfo.getQuestion());
                System.out.println("\t选项A:"+questionInfo.getOptionA());
                System.out.println("\t选项B:"+questionInfo.getOptionB());
                System.out.println("\t选项C:"+questionInfo.getOptionC());
                System.out.println("\t选项D:"+questionInfo.getOptionD());
                System.out.println("答案:"+questionInfo.getAnswer());
            }
        }
     }

    public static void removeId(){
//        boolean bo=true;
//        while (bo) {
//            System.out.print("请输入要删除题干的编号:");
//            int Id = scanner.nextInt();
//            if (Id < 0 || Id > question_list.size()) {
//                System.out.println("没有该编号，请重新输入");
//            }else {
//                question_list.remove(Id-1);
//                System.out.println("删除成功!");
//                count++;
//                bo=false;
//            }
//        }
        boolean bo=true;
        int size = question_list.size()+addd+count;//此处需要优化
        while (bo) {
            System.out.print("请输入要删除题干的编号:");
            int Id = scanner.nextInt();
            if (Id < 0||Id>size) {
                System.out.println("没有该编号，请重新输入");
            }else {
                question_list.remove(question_list.element().questionId=Id-1);
                System.out.println("删除成功!");
                count++;
                bo=false;
            }
        }



    }

}

class QuestionInfo {
    int questionId;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String subject;
    String answer;

    public QuestionInfo question(int questionId, String question, String optionA, String optionB, String optionC, String optionD, String subject, String answer) {
        QuestionInfo questionInfo = new QuestionInfo();
        questionInfo.question = question;
        questionInfo.questionId = questionId;
        questionInfo.optionA = optionA;
        questionInfo.optionB = optionB;
        questionInfo.optionC = optionC;
        questionInfo.optionD = optionD;
        questionInfo.subject = subject;
        questionInfo.answer = answer;
        return questionInfo;
    }


    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }


    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getQuestion() {
        return question;
    }

    public String getSubject() {
        return subject;
    }


}









