package Recurso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    static String bd = "bdsistemacitas";
    static String url = "jdbc:mysql://localhost:3305/";
    static String user = "root";
    static String password = "1234";
    static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection conector() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url + bd, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conexion = conector();
        if (conexion != null) {
            System.out.println("Conexión exitosa a la base de datos " + bd);
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Error al conectar a la base de datos " + bd);
        }
    }
}
