package Interpreter.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDB {

    public static MysqlDataSource dataSource;
    public static Connection connection = null;

    public ProjectDB() {
        dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://https://sajjad8080.000webhostapp.com/localhost:3306/id16404352_project");
        dataSource.setUser("id16404352_sajjaddb");
        dataSource.setPassword("@0G##<g%&3gy1wlT");

        connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println("Connected");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
