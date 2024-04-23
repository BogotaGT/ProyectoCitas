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
import javax.swing.JButton;
import Modelo.Paciente;

public class GestorPacienteControl implements ActionListener {
    private GestorPaciente gestorPaciente;
    private ConsPacienteInternalFrame consultarPacienteVista;
    

    public GestorPacienteControl(ConsPacienteInternalFrame consultarPacienteVista) {
        this.consultarPacienteVista = consultarPacienteVista;
        this.gestorPaciente = new GestorPaciente();
        this.conn = Recurso.Conexion.conector(); // Se inicializa la conexión
        this.consultarPacienteVista.Buscar = new JButton();
        this.consultarPacienteVista.Buscar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consultarPacienteVista.Buscar) {
            String parametro = "";
        if (consultarPacienteVista.rdb_identificacion.isSelected()) {
            parametro = "pacIdentificacion";
        }
        else if (consultarPacienteVista.rdb_nombres.isSelected()) {
            parametro = "pacNombres";
        }
        else if (consultarPacienteVista.rdb_apellidos.isSelected()) {
            parametro = "pacApellidos";
        }
        if (consultarPacienteVista.rdb_genero.isSelected()) {
            parametro = "pacGenero";
        }
       
        String valor = consultarPacienteVista.txt_valor.getText();

        LinkedList<Paciente> pacientes = gestorPaciente.getPacientesByParametro(parametro, valor);

        DefaultTableModel modelo = (DefaultTableModel) consultarPacienteVista.Tbl_datos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de llenarla
        for (Paciente paciente : pacientes) {
            Object[] fila = {paciente.getIdentificacion(), paciente.getNombres(), paciente.getApellidos(),
                             paciente.getFechaNacimiento(), paciente.getGenero()};
            modelo.addRow(fila);
        }
    }

    }
}
    
                
