package Vista;

import Controlador.PacienteControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class AgendarCitaForm extends JInternalFrame implements ActionListener {
    private JTextField txtFecha, txtHora, txtPaciente, txtMedico;
    private JButton btnAgendar;
    private PacienteControl pacienteControl;

    public AgendarCitaForm() {
        initComponents();
        pacienteControl = new PacienteControl(new RegPacienteInternalFrame());
    }

    private void initComponents() {
        setTitle("Agendar Cita");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Fecha:"));
        txtFecha = new JTextField();
        add(txtFecha);

        add(new JLabel("Hora:"));
        txtHora = new JTextField();
        add(txtHora);

        add(new JLabel("Paciente:"));
        txtPaciente = new JTextField();
        add(txtPaciente);

        add(new JLabel("Médico:"));
        txtMedico = new JTextField();
        add(txtMedico);

        btnAgendar = new JButton("Agendar");
        btnAgendar.addActionListener(this);
        add(btnAgendar);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgendar) {
            // Obtener los datos ingresados en el formulario
            String fecha = txtFecha.getText();
            String hora = txtHora.getText();
            String paciente = txtPaciente.getText();
            String medico = txtMedico.getText();

            // Llamar al método para guardar la cita en la base de datos
            pacienteControl.getGestorPacienteModelo().guardarCita(fecha, hora, paciente, medico);
        }
    }
}

