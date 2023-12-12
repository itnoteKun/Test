package connect_mysql;
//反射   结果集封装
import connect_mysql.dbConnection.DbConnection;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test1 {

    public static void main(String[] args) throws Exception {
        String driverClass = "com.mysql.jdbc.Driver";
        Class.forName(driverClass);
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "root";
//        String url = "jdbc:mysql://192.168.10.102:3306/spider_agronet?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";


        //注册JDBC驱动
        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //     开始实例化Stetement对象
        Statement statement = connection.createStatement();
        //
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);

        List<StudentMod> list = new ArrayList<>();
//        Class<?> classs = Class.forName("connect_mysql.StudentMod");

        while (resultSet.next()) {
            int s_id = resultSet.getInt("s_id");
            String s_name = resultSet.getString(2);
            String s_sex = resultSet.getString(3);
            String s_birthday = resultSet.getString(3);
            int s_class = resultSet.getInt(4);
            StudentMod studentMod = new StudentMod(s_id, s_name, s_sex, s_birthday, s_class);
            list.add(studentMod);

        }

        Field[] field = StudentMod.class.getDeclaredFields();

        for (StudentMod studentMod : list) {

            for (Field field1 : field) {
                field1.setAccessible(true);
                System.out.println(field1.getName() + ":" + field1.get(studentMod));

            }
        }


//        System.out.println(list);
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//        System.out.print(connection);

        connection.close();


    }


}
