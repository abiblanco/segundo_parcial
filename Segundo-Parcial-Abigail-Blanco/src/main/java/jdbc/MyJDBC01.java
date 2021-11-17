package main.java.jdbc;

import java.sql.*;

public class MyJDBC01 {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");

            Statement statement = connection.createStatement();
            String consultaSelect = "SELECT * FROM estudiante";
            ResultSet primerResultSet = statement.executeQuery(consultaSelect);


            while (primerResultSet.next()) {
                System.out.println(primerResultSet.getString("id") + " " + primerResultSet.getString("dni") + " " + primerResultSet.getString("nombre") + " " + primerResultSet.getString("apellido"));
            }
            System.out.println();

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException sqlException1) {
                    System.out.println(sqlException1);
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.out.println(sqlException);
            }
        }
    }
}


