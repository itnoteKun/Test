package connect_mysql.dbConnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//c3p0
public class DbConnection {
    public static DataSource dataSource = new ComboPooledDataSource();//资源池

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con) {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }


}
