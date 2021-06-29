package Interpreter.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDB {

    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(
                "jdbc:mysql://https://amirrsm.000webhostapp.com/localhost:3306/id17150973_finalprojectdb"
        );
        dataSource.setUser("id17150973_root");
        dataSource.setPassword("Amirrez@1302");

        Connection connection = dataSource.getConnection();
        System.out.println("Connected");
        connection.close();

    }
}
