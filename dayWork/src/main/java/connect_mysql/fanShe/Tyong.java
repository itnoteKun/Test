package connect_mysql.fanShe;

import connect_mysql.StudentMod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tyong {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);

        Class classes = Class.forName("connect_mysql.StudentMod");
//        List<?> list = resultSet();

        System.out.println(resultSet);

        connection.close();
    }

//    public static List<?> resultToList(ResultSet resultSet,Class<?> classes) throws Exception{
//        List<Object> objects = new ArrayList<>();
//        int columnCount = resultSet.getMetaData().getColumnCount();
//        while (resultSet.next()){
//            Object object = classes.getDeclaredConstructor().newInstance();
//            for (int i=1;)
//        }
//
//        return objects;
//
//    }
//





}
