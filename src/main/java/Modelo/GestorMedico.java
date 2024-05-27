package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Recurso.Conexion;

public class GestorMedico {
    private Conexion conexion;

    public GestorMedico() {
        conexion = new Conexion();
    }

    public void insertarMedico(String nombre, String especialidad) {
        Connection conn = conexion.getConnection();
        String sql = "INSERT INTO medicos (nombre, especialidad) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, especialidad);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}

