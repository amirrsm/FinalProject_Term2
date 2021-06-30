package Interpreter.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDB {

    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/fpdb");
        dataSource.setUser("root");
        dataSource.setPassword("7424468080");

        Connection connection = dataSource.getConnection();
        System.out.println("Connected");
        connection.close();

    }
}
