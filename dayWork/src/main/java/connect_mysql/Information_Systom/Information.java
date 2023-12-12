package connect_mysql.Information_Systom;

import connect_mysql.dbConnection.DbConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Information {

    private Connection con = null;
    static LinkedList<QuestionInfo> question_list = new LinkedList<QuestionInfo>();
    static Scanner scanner = new Scanner(System.in);
    static QuestionInfo questionInfo = new QuestionInfo();
    static int count=0;
    static int addd=0;
    static Information information=new Information();
    static List<QuestionInfo> list;
    public static void main(String[] args) {


//        information.insertData(questionInfo.question(2, "以下关于Java类和对象描述正确的是（）。", "一个类只能有一个对象", "对象是类的具体实例", "对象是对现实世界中客观事物的抽象", "使用class关键字定义一个对象", "Java", "B"));
//        information.insertData(questionInfo.question(3,"在WinForms中，消息框的返回值为（）类型。" , "MessageBox" , "DialogResult" , "Yes" , "No" , "JSP" , "B"));
//        information.insertData(questionInfo.question(4,"在WinForms中，消息框的返回值为（）类型。" , "MessageBox" , "DialogResult" , "Yes" , "No" , "C#" , "B"));

        list= (List<QuestionInfo>) information.selectData();
        list.forEach(s->question_list.add(s));
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

    public void deleteData(int id){
        con = DbConnection.getConnection();
        String sql = "delete from questions where questionId=?";
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(con,sql,id);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbConnection.closeConnection(con);
        }
    }
    public void insertData(QuestionInfo questionInfo){
        con = DbConnection.getConnection();
        String sql = "insert into questions (questionId,question,optionA,optionB,optionC,optionD,subject,answer) values(?,?,?,?,?,?,?,?)";
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(con, sql, questionInfo.getQuestionId(), questionInfo.getQuestion(), questionInfo.getOptionA(), questionInfo.getOptionB(), questionInfo.getOptionC(), questionInfo.getOptionD(), questionInfo.getSubject(), questionInfo.getAnswer());
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbConnection.closeConnection(con);
        }
    }

    public List<?> selectData(){
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        con = DbConnection.getConnection();
        String sql = "select * from questions";
        QueryRunner qr = new QueryRunner();
        BeanListHandler<QuestionInfo> beanListHandler = new BeanListHandler<>(QuestionInfo.class);
        try{
            list = qr.query(con,sql,beanListHandler);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbConnection.closeConnection(con);
        }
        return list;
    }


//显示问题
    public static void show_question () {
//        list= (List<QuestionInfo>) information.selectData();
//        list.forEach(s->question_list.add(s));
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
        information.insertData(questionInfo.question(question_list.size()+1+count,question,optionA,optionB,optionC,optionD,subject,answer));
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

        boolean bo=true;
        int size = question_list.size()+addd+count;//此处需要优化
        while (bo) {
            System.out.print("请输入要删除题干的编号:");
            int Id = scanner.nextInt();
            if (Id < 0||Id>size) {
                System.out.println("没有该编号，请重新输入");
            }else {
                information.deleteData(Id);
                question_list.remove(question_list.element().questionId=Id-1);
                System.out.println("删除成功!");
                count++;
                bo=false;
            }
        }



    }

}










