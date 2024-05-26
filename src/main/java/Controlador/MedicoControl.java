package Controlador;

import Modelo.GestorMedico;
import Vista.RegistrarMedicoForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicoControl implements ActionListener {
    private RegistrarMedicoForm medicoVista;
    private GestorMedico gestorMedico;

    public MedicoControl(RegistrarMedicoForm medicoVista) {
        this.medicoVista = medicoVista;
        this.gestorMedico = new GestorMedico();
        this.medicoVista.getBtnRegistrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == medicoVista.getBtnRegistrar()) {
            registrarMedico();
        }
    }

    public void registrarMedico() {
        String nombre = medicoVista.getTxtNombre().getText();
        String especialidad = medicoVista.getTxtEspecialidad().getText();
        gestorMedico.insertarMedico(nombre, especialidad);
    }
}
