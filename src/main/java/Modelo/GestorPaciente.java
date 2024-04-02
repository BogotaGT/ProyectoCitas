package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Recurso.Conexion;

public class GestorPaciente {
    private Conexion conn;

    public GestorPaciente() {
        conn = new Conexion(); // Obtener la conexión desde la clase Conexion
    }

    public void registrarPaciente(Paciente paciente) {
    try {
        String query = "INSERT INTO pacientes (pacIdentificacion, pacNombres, pacApellidos, pacFechaNacimiento,pacGenero, pacTelefono, pacDireccion) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.getConnection().prepareStatement(query);
        pst.setString(1, paciente.getIdentificacion());
        pst.setString(2, paciente.getNombres());
        pst.setString(3, paciente.getApellidos());
        pst.setString(4, paciente.getFechaNacimiento());
        pst.setString(5, paciente.getGenero());  // Cambiado a genero
        pst.setString(6, paciente.getTelefono()); 
        pst.setString(7, paciente.getDireccion());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Paciente Registrado");
        pst.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al registrar paciente: " + ex.getMessage());
    }
}


    public LinkedList<Paciente> getPacientesByParametro(String parametro, String valor) {
        LinkedList<Paciente> resultado = new LinkedList<>();
        String sql = "SELECT * FROM pacientes WHERE " + parametro + "=?";
        try {
            PreparedStatement pst = conn.getConnection().prepareStatement(sql); 
            pst.setString(1, valor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                resultado.add(new Paciente(rs.getString("pacIdentificacion"), rs.getString("pacNombres"),
                        rs.getString("pacApellidos"), rs.getString("pacFechaNacimiento"),rs.getString("pacGenero"), rs.getString("pacTelefono"),
                        rs.getString("pacDireccion")));
            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
}



