package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword())){
            System.out.println("Conexión establecida con Oracle."); //Mediante Maven
            String sql = "INSERT INTO empleado (" +
                    "ID, nombre, salario) " +
                    "VALUES (?,?,?)";
            /**
             * Uso de preparedStatement
             */
            PreparedStatement ps = conn.prepareStatement(sql);
            /**
             * indico el "índice" de la ? que quiero sustituir y el valor que quiero dar a la ?
             * puede ser el contenido o una variable
             */
            ps.setInt(1, 10);
            ps.setString(2, "Sergio");
            ps.setDouble(3, 2355.15);
            ps.executeUpdate();
            System.out.println("Empleado añadido con éxito");

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}