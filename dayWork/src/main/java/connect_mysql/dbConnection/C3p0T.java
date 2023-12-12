package connect_mysql.dbConnection;

import connect_mysql.Information_Systom.Information;
import connect_mysql.StudentMod;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author csk
 * @date 2023/11/20 15:44
 */
public class C3p0T {
    private Connection connection = null;


    public void insertStudent(StudentMod studentMod) {
        connection = DbConnection.getConnection();
        String sql = "insert into student(s_id,s_name,s_sex,s_birthday,s_class) values(?,?,?,?,?)";
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(connection, sql, studentMod.getS_id(), studentMod.getS_name(), studentMod.getS_sex(), studentMod.getS_birthday(), studentMod.getS_class());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection);
        }

    }

    public List<StudentMod> selectList() {
        List<StudentMod> list = new ArrayList<StudentMod>();
        connection = DbConnection.getConnection();
        String sql = "select * from student";
        QueryRunner qr = new QueryRunner();
        BeanListHandler<StudentMod> beanListHandler = new BeanListHandler<>(StudentMod.class);
        try {
            list = qr.query(connection, sql, beanListHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeConnection(connection);
        }
        return list;
    }

    public static void main(String[] args) {
        C3p0T c3p0T = new C3p0T();
        //查询数据
        List<StudentMod> list = c3p0T.selectList();
        list.forEach(s -> System.out.println(s));
        //插入数据
        StudentMod ar = new StudentMod(111, "李四", "男", "1974-06-03 00:00:00", 95034);
        c3p0T.insertStudent(ar);

    }

}
