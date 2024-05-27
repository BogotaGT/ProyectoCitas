package Controlador;

import Modelo.GestorMedico;
import Vista.RegistrarMedicoForm;

public class MedicoControl {
    private RegistrarMedicoForm medicoVista;
    private GestorMedico gestorMedico;

    public MedicoControl(RegistrarMedicoForm medicoVista) {
        this.medicoVista = medicoVista;
        this.gestorMedico = new GestorMedico();
    }

    public void registrarMedico() {
        String nombre = medicoVista.getTxtNombre().getText();
        String especialidad = medicoVista.getTxtEspecialidad().getText();
        gestorMedico.insertarMedico(nombre, especialidad);
    }
}



