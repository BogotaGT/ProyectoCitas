package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import Modelo.GestorPaciente;
import Modelo.Paciente;
import Vista.RegPacienteInternalFrame;

public class PacienteControl implements ActionListener {
    RegPacienteInternalFrame pacienteVista;
    Paciente pacienteModelo;
    GestorPaciente gestorPacienteModelo;

    public PacienteControl(RegPacienteInternalFrame pacienteVista) {
        this.pacienteVista = pacienteVista;
        this.gestorPacienteModelo = new GestorPaciente();
        this.pacienteVista.Nuevo.addActionListener(this); // Agregar listener al botón "Nuevo"
        this.pacienteVista.Registrar.addActionListener(this); // Agregar listener al botón "Registrar"
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pacienteVista.Nuevo) { // Verificar si el evento proviene del botón "Nuevo"
            limpiarCampos(); // Llamar al método para limpiar los campos
        } else if (e.getSource() == pacienteVista.Registrar) { // Verificar si el evento proviene del botón "Registrar"
            registrarPaciente(); // Llamar al método para registrar al paciente
        }
    }
    
    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        pacienteVista.txt_identificacion.setText("");
        pacienteVista.txt_nombres.setText("");
        pacienteVista.txt_apellidos.setText("");
        pacienteVista.Dtd_fecha_nacimiento.setDate(null);
        pacienteVista.rdb_masculino.setSelected(true);
        pacienteVista.rdb_femenino.setSelected(false);
        pacienteVista.rdb_otro.setSelected(false);
    }
    
    // Método para registrar al paciente
    private void registrarPaciente() {
        String identificacion = pacienteVista.txt_identificacion.getText();
        String nombres = pacienteVista.txt_nombres.getText();
        String apellidos = pacienteVista.txt_apellidos.getText();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha_nacimiento = formato.format(pacienteVista.Dtd_fecha_nacimiento.getDate());
        String genero = "";
        if (pacienteVista.rdb_masculino.isSelected()) {
            genero = "M";
        } else if (pacienteVista.rdb_femenino.isSelected()) {
            genero = "F";
        } else if (pacienteVista.rdb_otro.isSelected()) {
            genero = "O";
        }
        
        String telefono = pacienteVista.txt_telefono.getText();
        String direccion = pacienteVista.txt_direccion.getText();
        
        pacienteModelo = new Paciente(identificacion, nombres, apellidos, fecha_nacimiento, genero, telefono, direccion);
        gestorPacienteModelo.registrarPaciente(pacienteModelo);
    }
}

