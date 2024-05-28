package Vista;

import javax.swing.table.DefaultTableModel;
import Modelo.GestorPaciente;
import Modelo.Cita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ConsCitasInternalFrame extends javax.swing.JInternalFrame {

    private final GestorPaciente gestorPaciente;
    private final DefaultTableModel tabla;

    public ConsCitasInternalFrame() {
        initComponents();
        this.gestorPaciente = new GestorPaciente();
        String titulosTabla[] = {"ID", "Fecha", "Hora", "Paciente", "Medico"};
        tabla = new DefaultTableModel(null, titulosTabla);
        Tbl_datos.setModel(tabla);
        setTitle("CONSULTAR CITAS");
    }

    private void buscarCitas() {
        LinkedList<Cita> citas = gestorPaciente.obtenerCitas();
        tabla.setRowCount(0);
        for (Cita cita : citas) {
            Object[] fila = {cita.getId(), cita.getFecha(), cita.getHora(), cita.getPaciente(), cita.getMedico()};
            tabla.addRow(fila);
        }
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_datos = new javax.swing.JTable();
        btn_aceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        jScrollPane1.setViewportView(Tbl_datos);

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCitas();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(btn_aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JTable Tbl_datos;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
