package Recurso;

import Modelo.Cita;
import Modelo.Medico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    String servidor = "jdbc:mysql://localhost:3306/";
    String bd = "bdsistemacitas";
    String user = "root";
    String password = "";
    
    public Conexion() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver"; // Definir el controlador JDBC
            Class.forName(driver);
            System.out.println("SE CONECTO A BD " + bd);
        } catch (ClassNotFoundException ex) {
            System.out.println("NO SE CONECTO A BD " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(servidor + bd + "?serverTimezone=UTC", user, password);
        } catch (SQLException ex) {
            System.out.println("NO SE CONECTO A BD " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error al conectar a la base de datos", ex);
        }
    }

    public void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("SE DESCONECTO DE BD " + bd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        //Metodos adicionales
    public void insertarPaciente(String identificacion, String nombres, String apellidos, String fechaNacimiento, String genero) {
        String sql = "INSERT INTO pacientes (identificacion, nombres, apellidos, fecha_nacimiento, genero) VALUES (?, ?, ?, ?, ?)";
       try (Connection conn = getConnection();
           PreparedStatement statement = conn.prepareStatement(sql)) {
           statement.setString(1, identificacion);
           statement.setString(2, nombres);
           statement.setString(3, apellidos);
           statement.setString(4, fechaNacimiento);
           statement.setString(5, genero);
           statement.executeUpdate();
           JOptionPane.showMessageDialog(null, "Paciente registrado correctamente.");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al registrar paciente: " + ex.getMessage());
       }
   }

    // Método para obtener las citas agendadas desde la base de datos
    public LinkedList<Cita> obtenerCitas() {
        LinkedList<Cita> citas = new LinkedList<>();
        String sql = "SELECT fecha, hora, paciente, medico FROM citas";
        try  (Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                String paciente = resultSet.getString("paciente");
                String medico = resultSet.getString("medico");
                Cita cita = new Cita(fecha, hora, paciente, medico);
                citas.add(cita);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener citas: " + ex.getMessage());
        }
        return citas;
    }

    // Método para insertar un médico en la base de datos
    public void insertarMedico(String nombre, String especialidad) {
        String sql = "INSERT INTO medicos (nombre, especialidad) VALUES (?, ?)";
        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, especialidad);
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Médico registrado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar médico: " + ex.getMessage());
        }
    }

    public void insertarCita(String fecha, String hora, String paciente, String medico) {
        String sql = "INSERT INTO citas (fecha, hora, paciente, medico) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, fecha);
            statement.setString(2, hora);
            statement.setString(3, paciente);
            statement.setString(4, medico);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cita registrada correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar cita: " + ex.getMessage());
        }
    }

    // Método para obtener los médicos registrados desde la base de datos
    public LinkedList<Medico> obtenerMedicos() {
        LinkedList<Medico> medicos = new LinkedList<>();
        String sql = "SELECT nombre, especialidad FROM medicos";
        try (Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String especialidad = resultSet.getString("especialidad");
                Medico medico = new Medico(nombre, especialidad);
                medicos.add(medico);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener médicos: " + ex.getMessage());
        }
        return medicos;
    }
}

