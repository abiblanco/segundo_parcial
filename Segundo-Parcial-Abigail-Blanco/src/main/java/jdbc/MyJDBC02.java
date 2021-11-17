package main.java.jdbc;

import java.sql.*;

public class MyJDBC02 {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root","");
            connection.setAutoCommit(false);
           // Statement statement = connection.createStatement();
            PreparedStatement consultaPreparada = connection.prepareStatement("INSERT INTO estudiante (dni, nombre, apellido) VALUES (?, ?, ?);");

                consultaPreparada.setInt(1, 44258437);
                consultaPreparada.setString(2, "ABIGAIL");
                consultaPreparada.setString(3, "Blanco");
                consultaPreparada.executeUpdate();


            Statement statement = connection.createStatement();

            String consultaSql= "SELECT * FROM estudiante";
            ResultSet resultSet = statement.executeQuery("SELECT * FROM estudiante");



            connection.commit();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
            System.out.println();

        } catch (SQLException sqlException){
            System.out.println(sqlException);
            if(connection != null){
                try{
                    connection.rollback();
                } catch (SQLException sqlException1){
                    System.out.println(sqlException1);       }     }
        }finally{
            try{
                if(connection != null){
                    connection.close();                  }
            }catch (SQLException sqlException){
                System.out.println(sqlException);    }             }

    }
}
