package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import Modelo.GestorPaciente;
import Modelo.Paciente;
import Vista.ConsPacienteInternalFrame;
import javax.swing.JButton;


public class GestorPacienteControl implements ActionListener {
    private GestorPaciente gestorPaciente;
    private ConsPacienteInternalFrame consultarPacienteVista;

    public GestorPacienteControl(ConsPacienteInternalFrame consultarPacienteVista) {
        this.consultarPacienteVista = consultarPacienteVista;
        this.gestorPaciente = new GestorPaciente();
        // Inicializar el botón Buscar antes de agregarle un ActionListener
        this.consultarPacienteVista.Buscar = new JButton(); // Inicialización del botón
        this.consultarPacienteVista.Buscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consultarPacienteVista.Buscar) {
            String parametro = "";
            if (consultarPacienteVista.rdb_identificacion.isSelected()) {
                parametro = "pacIdentificacion";
            } else if (consultarPacienteVista.rdb_nombres.isSelected()) {
                parametro = "pacNombres";
            } else if (consultarPacienteVista.rdb_apellidos.isSelected()) {
                parametro = "pacApellidos";
            } else if (consultarPacienteVista.rdb_fechaNacimiento.isSelected()) {
                parametro = "pacFechaNacimiento";
            } else if (consultarPacienteVista.rdb_telefono.isSelected()) {
                parametro = "pacTelefono";
            } else if (consultarPacienteVista.rdb_direccion.isSelected()) {
                parametro = "pacDireccion";
            }
            
            String valor = consultarPacienteVista.txt_valor.getText();

            LinkedList<Paciente> pacientes = gestorPaciente.getPacientesByParametro(parametro, valor);

            DefaultTableModel modelo = (DefaultTableModel) consultarPacienteVista.Tbl_datos.getModel();
            modelo.setRowCount(0); 
            for (Paciente paciente : pacientes) {
                Object[] fila = { paciente.getIdentificacion(), paciente.getNombres(), paciente.getApellidos(),
                        paciente.getFechaNacimiento(), paciente.getTelefono(), paciente.getDireccion() };
                modelo.addRow(fila);
            }
        }
    }
}

