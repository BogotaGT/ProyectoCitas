package Vista;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class ConsPacienteInternalFrame extends javax.swing.JInternalFrame {

   public Controlador.GestorPacienteControl gestorpacienteControl;
   private DefaultTableModel tabla;
   public JButton Buscar;
   public javax.swing.JRadioButton rdb_fechaNacimiento;
   public javax.swing.JRadioButton rdb_telefono;
   public javax.swing.JRadioButton rdb_direccion;
   
   public ConsPacienteInternalFrame(){
    initComponents();
    gestorpacienteControl = new Controlador.GestorPacienteControl(this);
    String titulosTabla[] = {"Identificatión", "Nombres", "Apellidos", "Fecha Nacimiento", "Genero"};
    tabla = new DefaultTableModel(null, titulosTabla);
    Tbl_datos.setModel(tabla);
    btn_aceptar.addActionListener(gestorpacienteControl);
  // Crear el botón Buscar antes de asignarle un ActionListener
    Buscar = new javax.swing.JButton();
    // Asignar el botón Buscar al campo Buscar de la clase
   
    // Agregar ActionListener después de inicializar el botón
    Buscar.addActionListener(gestorpacienteControl);
       
    }

    public DefaultTableModel getTableModel() {
        return tabla;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdb_identificacion = new javax.swing.JRadioButton();
        rdb_nombres = new javax.swing.JRadioButton();
        rdb_apellidos = new javax.swing.JRadioButton();
        rdb_genero = new javax.swing.JRadioButton();
        txt_valor = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_datos = new javax.swing.JTable();

        rdb_identificacion.setText("Identificación");
        rdb_identificacion.setName(""); // NOI18N

        rdb_nombres.setText("Nombres");

        rdb_apellidos.setText("Apellidos");

        rdb_genero.setText("Sexo");

        txt_valor.setText("Valor a buscar:");
        txt_valor.setToolTipText("Valor a buscar:");
        txt_valor.setName("ValorTxt"); // NOI18N

        jTextField1.setName("ValorTxt"); // NOI18N

        btn_aceptar.setText("Aceptar");
        btn_aceptar.setName("AceptarBtn"); // NOI18N

        Tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tbl_datos.setName("ResultadosTbl"); // NOI18N
        jScrollPane1.setViewportView(Tbl_datos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdb_identificacion)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_nombres)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_apellidos)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_genero))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_valor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_aceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb_identificacion)
                    .addComponent(rdb_nombres)
                    .addComponent(rdb_apellidos)
                    .addComponent(rdb_genero))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valor)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Tbl_datos;
    public javax.swing.JButton btn_aceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JRadioButton rdb_apellidos;
    public javax.swing.JRadioButton rdb_genero;
    public javax.swing.JRadioButton rdb_identificacion;
    public javax.swing.JRadioButton rdb_nombres;
    public javax.swing.JLabel txt_valor;
    // End of variables declaration//GEN-END:variables

   
        }
    



