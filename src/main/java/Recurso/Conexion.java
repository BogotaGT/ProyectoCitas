package Recurso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    String servidor = "jdbc:mysql://localhost:3306/";
    String bd = "bdsistemacitas";
    String user = "root";
    String password = "";
    
    Connection cx;

    public Conexion() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver"; // Definir el controlador JDBC
            Class.forName(driver);
            cx = DriverManager.getConnection(servidor + bd + "?serverTimezone=UTC", user, password);
            System.out.println("SE CONECTO A BD " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO A BD " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return cx;
    }

    public void desconectar() {
        try {
            cx.close();
            System.out.println("SE DESCONECTO DE BD " + bd);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarPaciente(String identificacion, String nombres, String apellidos, String fechaNacimiento, String genero) {
       try {
           String sql = "INSERT INTO pacientes (identificacion, nombres, apellidos, fecha_nacimiento, genero) VALUES (?, ?, ?, ?, ?)";
           PreparedStatement statement = cx.prepareStatement(sql);
           statement.setString(1, identificacion);
           statement.setString(2, nombres);
           statement.setString(3, apellidos);
           statement.setString(4, fechaNacimiento);
           statement.setString(5, genero);
           statement.executeUpdate();
           statement.close();
           JOptionPane.showMessageDialog(null, "Paciente registrado correctamente.");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al registrar paciente: " + ex.getMessage());
       }
   }
}
