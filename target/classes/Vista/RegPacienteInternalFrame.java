package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class RegPacienteInternalFrame extends javax.swing.JInternalFrame implements ActionListener {

    public RegPacienteInternalFrame() {
        initComponents();
        // Agregar listeners a los botones
        Nuevo.addActionListener(this);
        Registrar.addActionListener(this);
    }

    // Método actionPerformed para manejar eventos de acción
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Nuevo) {
            // Limpiar todos los campos del formulario
            txt_identificacion.setText("");
            txt_nombres.setText("");
            txt_apellidos.setText("");
            Dtd_fecha_nacimiento.setDate(null);
            rdb_masculino.setSelected(true);
            rdb_femenino.setSelected(false);
            rdb_otro.setSelected(false);
        } else if (e.getSource() == Registrar) {
            // Validar y registrar al paciente
            String identificacion = txt_identificacion.getText();
            String nombres = txt_nombres.getText();
            String apellidos = txt_apellidos.getText();
            // Validar que no falten datos obligatorios
            if (identificacion.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || Dtd_fecha_nacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
                return;
            }
            // Obtener la fecha de nacimiento en el formato deseado
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fecha_nacimiento = formato.format(Dtd_fecha_nacimiento.getDate());
            // Obtener el género seleccionado
            String genero = "";
            if (rdb_masculino.isSelected()) {
                genero = "Masculino";
            } else if (rdb_femenino.isSelected()) {
                genero = "Femenino";
            } else if (rdb_otro.isSelected()) {
                genero = "Otro";
            }
            // Aquí puedes agregar la lógica para registrar al paciente en la base de datos
            // Por ahora, mostraremos un mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Paciente registrado correctamente.");
            // También podrías llamar a un método en el controlador para manejar el registro del paciente
            // controlador.registrarPaciente(identificacion, nombres, apellidos, fecha_nacimiento, genero);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_identificacion = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        rdb_masculino = new javax.swing.JRadioButton();
        rdb_femenino = new javax.swing.JRadioButton();
        rdb_otro = new javax.swing.JRadioButton();
        Nuevo = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        Dtd_fecha_nacimiento = new com.toedter.calendar.JDateChooser();

        setTitle("REGISTRO DE PACIENTES");

        jLabel1.setText("IDENTIFICACION:");

        jLabel2.setText("NOMBRES:");

        jLabel3.setText("APELLIDOS:");

        jLabel4.setText("FECHA DE NACIMIENTO:");

        jLabel5.setText("Genero:");

        txt_identificacion.setName("IdentificacionTxt"); // NOI18N

        txt_nombres.setName("NombresTxt"); // NOI18N

        txt_apellidos.setName("ApellidosTxt"); // NOI18N

        rdb_masculino.setText("Masculino");

        rdb_femenino.setText("Femenino");

        rdb_otro.setText("Otro");

        Nuevo.setText("NUEVO");
        Nuevo.setName("NuevoBtn"); // NOI18N

        Registrar.setText("REGISTRAR");
        Registrar.setName("RegistrarBtn"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txt_nombres)
                            .addComponent(Dtd_fecha_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(Nuevo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Registrar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(36, 36, 36)
                            .addComponent(rdb_masculino)
                            .addGap(18, 18, 18)
                            .addComponent(rdb_femenino)
                            .addGap(18, 18, 18)
                            .addComponent(rdb_otro))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_apellidos))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Dtd_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdb_masculino)
                    .addComponent(rdb_femenino)
                    .addComponent(rdb_otro))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nuevo)
                    .addComponent(Registrar))
                .addGap(176, 176, 176))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser Dtd_fecha_nacimiento;
    public javax.swing.JButton Nuevo;
    public javax.swing.JButton Registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JRadioButton rdb_femenino;
    public javax.swing.JRadioButton rdb_masculino;
    public javax.swing.JRadioButton rdb_otro;
    public javax.swing.JTextField txt_apellidos;
    public javax.swing.JTextField txt_identificacion;
    public javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}