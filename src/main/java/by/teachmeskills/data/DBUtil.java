package by.teachmeskills.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

        private  static String dbUrl = "jdbc:mysql://localhost:3306/APP?serverTimezone=UTC";
        private static String dbUsername = "root";
        private static String dbPassword ="1111";
    
        public static Connection getConnection(){
            Connection connection = null;


            try {
Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            } catch (SQLException | ClassNotFoundException throwables) {
                System.out.println(throwables.getMessage());
            }
            return connection;

        }
    }

