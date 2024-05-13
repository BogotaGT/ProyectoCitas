package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Recurso.Conexion; 
 
public class GestorPaciente {

    private Conexion cx;

    public GestorPaciente() {
        cx = new Conexion();
    }

    public LinkedList<Paciente> getPacientesByParametro(String parametro, String valor) {
        LinkedList<Paciente> pacientes = new LinkedList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = cx.getConnection();
            String sql = "SELECT * FROM pacientes WHERE " + parametro + " = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, valor);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente(
                    rs.getString("pacIdentificacion"), 
                    rs.getString("pacNombres"), 
                    rs.getString("pacApellidos"), 
                    rs.getString("pacFechaNacimiento"), 
                    rs.getString("pacGenero"));
                    pacientes.add(paciente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    cx.desconectar();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return pacientes;
        }

        public void registrarPaciente(String identificacion, String nombres, String apellidos, String fechaNacimiento, String genero) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = cx.getConnection();
                String sql = "INSERT INTO pacientes (pacIdentificacion, pacNombres, pacApellidos, pacFechaNacimiento, pacGenero) VALUES (?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, identificacion);
                ps.setString(2, nombres);
                ps.setString(3, apellidos);
                ps.setString(4, fechaNacimiento);
                ps.setString(5, genero);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
        
    