package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection; // Se agrega la importación para Connection
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelo.GestorPaciente;
import Modelo.Paciente;
import Vista.ConsPacienteInternalFrame;
import javax.swing.table.DefaultTableModel;

public class GestorPacienteControl implements ActionListener {
    private GestorPaciente pacientesModelo;
    private ConsPacienteInternalFrame consultarPacienteVista;
    private Connection conn; // Se agrega el atributo para Connection

    public GestorPacienteControl(ConsPacienteInternalFrame consultarPacienteVista) {
        this.consultarPacienteVista = consultarPacienteVista;
        this.pacientesModelo = new GestorPaciente();
        this.conn = Recurso.Conexion.conector(); // Se inicializa la conexión
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tmodelo;
        String valor = consultarPacienteVista.txt_valor.getText();
        int parametro = 0;
        if (consultarPacienteVista.rdb_identificacion.isSelected()) {
            parametro = 1;
        }
        if (consultarPacienteVista.rdb_nombres.isSelected()) {
            parametro = 2;
        }
        if (consultarPacienteVista.rdb_apellidos.isSelected()) {
            parametro = 3;
        }
        if (consultarPacienteVista.rdb_genero.isSelected()) {
            parametro = 4;
        }
        LinkedList<Paciente> pacientes = getPacientesByParametro(parametro, valor); // Llamada al método corregido

        String registro[] = new String[5];
        String[] Titulos = { "Identificacion", "Nombre", "Apellidos", "Fecha Nacimiento", "Genero" };
        tmodelo = new DefaultTableModel();
        tmodelo.setColumnIdentifiers(Titulos);
        for (Paciente p : pacientes) {
            registro[0] = p.getIdentificacion();
            registro[1] = p.getNombres();
            registro[2] = p.getApellidos();
            registro[3] = p.getFechaNacimiento();
            registro[4] = p.getGenero();
            tmodelo.addRow(registro);
        }
        consultarPacienteVista.Tbl_datos.setModel(tmodelo);
    }
    
    // Método corregido para obtener pacientes por parámetro
    private LinkedList<Paciente> getPacientesByParametro(int parametro, String valor) {
        LinkedList<Paciente> resultado = new LinkedList<Paciente>();
        String sql = "";
        switch (parametro) {
            case 1:
                sql = "SELECT * FROM PACIENTE WHERE PACIDENTIFICACION='" + valor + "'";
                break;
            case 2:
                sql = "SELECT * FROM PACIENTE WHERE PACNOMBRES='" + valor + "'";
                break;
            case 3:
                sql = "SELECT * FROM PACIENTE WHERE PACAPELLIDOS='" + valor + "'";
                break;
            case 4:
                sql = "SELECT * FROM PACIENTE WHERE PACGENERO='" + valor + "'";
                break;
        }
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                resultado.add(new Paciente(rs.getString("PACIDENTIFICACION"), rs.getString("PACNOMBRES"),
                        rs.getString("PACAPELLIDOS"), rs.getString("PACFECHANACIMIENTO"), rs.getString("PACGENERO"), telefono, direccion));
            }
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return resultado;
    }
}

                
