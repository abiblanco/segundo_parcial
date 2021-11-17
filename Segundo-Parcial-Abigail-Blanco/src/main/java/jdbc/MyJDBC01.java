package main.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC01 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root","");
            //connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String consultaSelect = "SELECT * FROM estudiante";
            ResultSet primerResultSet = statement.executeQuery(consultaSelect);

            //ResultSet resultSet = statement.executeQuery("select * from estudiante");
            //System.out.println(primerResultSet);
           /* while (primerResultSet.next()){
                System.out.println(primerResultSet.getString("nombre"));
            }
            System.out.println();*/
            while(primerResultSet.next()){
                System.out.println(primerResultSet.getString("id") + " " + primerResultSet.getString("dni") + " " + primerResultSet.getString("nombre") + " " + primerResultSet.getString("apellido"));
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


