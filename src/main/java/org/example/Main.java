package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); Statement statement = conn.createStatement()){
            System.out.println("Conexión establecida con Oracle.");
            String sql = "INSERT INTO empleado (" +
                    "ID, nombre, salario) " +
                    "VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
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