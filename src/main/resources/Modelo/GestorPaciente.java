package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestorPaciente {
    private Connection conn;

    public GestorPaciente() {
        conn = Recurso.Conexion.conector(); // Obtener la conexión desde la clase Conexion
    }

    public void RegistrarPacientes(Paciente paciente) {
        try {
            String query = "INSERT INTO PACIENTE (PACIDENTIFICACION, PACNOMBRES, PACAPELLIDOS, PACFECHANACIMIENTO, PACGENERO) "
                         + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, paciente.getIdentificacion());
            pst.setString(2, paciente.getNombres());
            pst.setString(3, paciente.getApellidos());
            pst.setString(4, paciente.getFechaNacimiento());
            pst.setString(5, paciente.getGenero());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente Registrado");
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorPaciente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar paciente: " + ex.getMessage());
        }
    }

    public LinkedList<Paciente> getPacientesByParametro(int parametro, String valor) {
        LinkedList<Paciente> resultado = new LinkedList<>();
        String sql = "";
        switch (parametro) {
            case 1:
                sql = "SELECT * FROM PACIENTE WHERE PACIDENTIFICACION=?";
                break;
            case 2:
                sql = "SELECT * FROM PACIENTE WHERE PACNOMBRES=?";
                break;
            case 3:
                sql = "SELECT * FROM PACIENTE WHERE PACAPELLIDOS=?";
                break;
            case 4:
                sql = "SELECT * FROM PACIENTE WHERE PACGENERO=?";
                break;
        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, valor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                resultado.add(new Paciente(rs.getString("PACIDENTIFICACION"), rs.getString("PACNOMBRES"),
                        rs.getString("PACAPELLIDOS"), rs.getString("PACFECHANACIMIENTO"), rs.getString("PACGENERO"), telefono, direccion));
            }
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
}
