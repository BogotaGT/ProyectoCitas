package Vista;

import Controlador.MedicoControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class RegistrarMedicoForm extends JInternalFrame implements ActionListener {
    private JTextField txtNombre, txtEspecialidad;
    private JButton btnRegistrar;
    private MedicoControl medicoControl;

    public RegistrarMedicoForm() {
        initComponents();
        medicoControl = new MedicoControl(this);
    }

    private void initComponents() {
        setTitle("Registrar Médico");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        add(txtEspecialidad);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            medicoControl.registrarMedico();
            
        }
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }
}

