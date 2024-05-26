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
        String sql = "SELECT * FROM pacientes WHERE " + parametro + " = ?";

    try (Connection conn = cx.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
         ps.setString(1, valor);
         try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente(
                    rs.getString("pacIdentificacion"), 
                    rs.getString("pacNombres"), 
                    rs.getString("pacApellidos"), 
                    rs.getString("pacFechaNacimiento"), 
                    rs.getString("pacGenero"));
                    pacientes.add(paciente);
                }
            }
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return pacientes;
        }

        public void registrarPaciente(String identificacion, String nombres, String apellidos, String fechaNacimiento, String genero) {
            String checkSql = "SELECT COUNT(*) FROM pacientes WHERE pacIdentificacion = ?";
            String insertSql = "INSERT INTO pacientes (pacIdentificacion, pacNombres, pacApellidos, pacFechaNacimiento, pacGenero) VALUES (?, ?, ?, ?, ?)";
            
         try (Connection conn = cx.getConnection();
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            PreparedStatement psInsert = conn.prepareStatement(insertSql)) {

           // Verificar si el paciente ya existe
           psCheck.setString(1, identificacion);
           try (ResultSet rs = psCheck.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                throw new SQLException("Duplicate entry for key 'PRIMARY'");
            }
        }

                //Insertar el nuevo paciente
                psInsert.setString(1, identificacion);
                psInsert.setString(2, nombres);
                psInsert.setString(3, apellidos);
                psInsert.setString(4, fechaNacimiento);
                psInsert.setString(5, genero);
                psInsert.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al registrar el paciente: " + e.getMessage(), e);
            }
        }

         // Nuevo método para obtener las citas agendadas
    public LinkedList<Cita> obtenerCitas() {
        return cx.obtenerCitas();
    }

    // Nuevo método para guardar una cita
    public void guardarCita(String fecha, String hora, String paciente, String medico) {
        cx.insertarCita(fecha, hora, paciente, medico);
    }

    // Nuevo método para obtener los médicos registrados
    public LinkedList<Medico> obtenerMedicos() {
        return cx.obtenerMedicos();
    }

    // Nuevo método para guardar un médico
    public void guardarMedico(String nombre, String especialidad) {
        cx.insertarMedico(nombre, especialidad);
    }
    }
        
    