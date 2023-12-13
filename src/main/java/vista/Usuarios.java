package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SENA
 */
public class Usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
    }

    public JPanel getjPausu() {
        return jPausu;
    }

    public void setjPausu(JPanel jPausu) {
        this.jPausu = jPausu;
    }

    public JLabel getjLbnuevo_usuario() {
        return jLbnuevo_usuario;
    }

    public void setjLbnuevo_usuario(JLabel jLbnuevo_usuario) {
        this.jLbnuevo_usuario = jLbnuevo_usuario;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPausu;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPausu = jPanel2;
    }

    public JButton getjButtoguardar() {
        return jButtoguardar;
    }

    public void setjButtoguardar(JButton jButtoguardar) {
        this.jButtoguardar = jButtoguardar;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JComboBox<String> getjCbBoxselec_sexo() {
        return jCbBoxselec_sexo;
    }

    public void setjCbBoxselec_sexo(JComboBox<String> jCbBoxselec_sexo) {
        this.jCbBoxselec_sexo = jCbBoxselec_sexo;
    }

    public JComboBox<String> getjComboBoxcargo() {
        return jComboBoxcargo;
    }

    public void setjComboBoxcargo(JComboBox<String> jComboBoxcargo) {
        this.jComboBoxcargo = jComboBoxcargo;
    }

    public JDateChooser getjDateChooserFecha_nacimiento() {
        return jDateChooserFecha_nacimiento;
    }

    public void setjDateChooserFecha_nacimiento(JDateChooser jDateChooserFecha_nacimiento) {
        this.jDateChooserFecha_nacimiento = jDateChooserFecha_nacimiento;
    }

    public JPasswordField getjPasinsert_clave() {
        return jPasinsert_clave;
    }

    public void setjPasinsert_clave(JPasswordField jPasinsert_clave) {
        this.jPasinsert_clave = jPasinsert_clave;
    }

    public JTextField getjTextinser_direccion() {
        return jTextinser_direccion;
    }

    public void setjTextinser_direccion(JTextField jTextinser_direccion) {
        this.jTextinser_direccion = jTextinser_direccion;
    }

    public JTextField getjTextinsert_correo() {
        return jTextinsert_correo;
    }

    public void setjTextinsert_correo(JTextField jTextinsert_correo) {
        this.jTextinsert_correo = jTextinsert_correo;
    }

    public JTextField getjTextinsert_login() {
        return jTextinsert_login;
    }

    public void setjTextinsert_login(JTextField jTextinsert_login) {
        this.jTextinsert_login = jTextinsert_login;
    }

    public JTextField getjTextinsert_telefono() {
        return jTextinsert_telefono;
    }

    public void setjTextinsert_telefono(JTextField jTextinsert_telefono) {
        this.jTextinsert_telefono = jTextinsert_telefono;
    }

    public JTextField getjTextinsert_ususario() {
        return jTextinsert_ususario;
    }

    public void setjTextinsert_ususario(JTextField jTextinsert_ususario) {
        this.jTextinsert_ususario = jTextinsert_ususario;
    }

    public JTextField getjTextisert_nombre() {
        return jTextisert_nombre;
    }

    public void setjTextisert_nombre(JTextField jTextisert_nombre) {
        this.jTextisert_nombre = jTextisert_nombre;
    }

   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPausu = new javax.swing.JPanel();
        jLbnuevo_usuario = new javax.swing.JLabel();
        jLabusuario = new javax.swing.JLabel();
        jTextinsert_ususario = new javax.swing.JTextField();
        jLabnombre = new javax.swing.JLabel();
        jTextisert_nombre = new javax.swing.JTextField();
        jLabtelefono = new javax.swing.JLabel();
        jTextinsert_telefono = new javax.swing.JTextField();
        jLabcorreo = new javax.swing.JLabel();
        jTextinsert_correo = new javax.swing.JTextField();
        jLabdireccion = new javax.swing.JLabel();
        jTextinser_direccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCbBoxselec_sexo = new javax.swing.JComboBox<>();
        jLabcargo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextinsert_login = new javax.swing.JTextField();
        jLabinsert_clave = new javax.swing.JLabel();
        jPasinsert_clave = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButtoguardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxcargo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jDateChooserFecha_nacimiento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPausu.setBackground(new java.awt.Color(225, 112, 186));

        jLbnuevo_usuario.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLbnuevo_usuario.setText("NUEVO USUARIO");

        jLabusuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabusuario.setText("Usuario");

        jTextinsert_ususario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextinsert_ususarioActionPerformed(evt);
            }
        });

        jLabnombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabnombre.setText("Nombre");

        jTextisert_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextisert_nombreActionPerformed(evt);
            }
        });

        jLabtelefono.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabtelefono.setText("Telefono");

        jLabcorreo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabcorreo.setText("Correo");

        jLabdireccion.setText("Dirección");

        jTextinser_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextinser_direccionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Sexo");

        jCbBoxselec_sexo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCbBoxselec_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBoxselec_sexoActionPerformed(evt);
            }
        });

        jLabcargo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabcargo.setText("Cargo");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Login");

        jLabinsert_clave.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabinsert_clave.setText("Clave");

        jButtoguardar.setText("Guardar");

        jLabel2.setText("*");

        jLabel3.setText("*");

        jLabel4.setText("*");

        jLabel6.setText("*");

        jLabel7.setText("*");

        jLabel8.setText("*");

        jLabel9.setText("*");

        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Fecha de Nacimiento");

        jDateChooserFecha_nacimiento.setDateFormatString("yyyy-MM-dd");

        jLabel12.setText("*");

        jLabel13.setText("*");

        javax.swing.GroupLayout jPausuLayout = new javax.swing.GroupLayout(jPausu);
        jPausu.setLayout(jPausuLayout);
        jPausuLayout.setHorizontalGroup(
            jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPausuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLbnuevo_usuario)
                .addGap(216, 216, 216))
            .addGroup(jPausuLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabcargo)
                    .addComponent(jLabel1)
                    .addComponent(jLabinsert_clave)
                    .addComponent(jLabel11)
                    .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabdireccion))
                    .addGroup(jPausuLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabusuario)
                            .addComponent(jLabtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabcorreo))))
                .addGap(71, 71, 71)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextisert_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPausuLayout.createSequentialGroup()
                        .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextinser_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCbBoxselec_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextinsert_ususario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextinsert_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextinsert_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextinsert_login)
                                    .addGroup(jPausuLayout.createSequentialGroup()
                                        .addComponent(jPasinsert_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                                    .addComponent(jComboBoxcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jDateChooserFecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addGap(10, 10, 10)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPausuLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButtoguardar))
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPausuLayout.setVerticalGroup(
            jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPausuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLbnuevo_usuario)
                .addGap(29, 29, 29)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextinsert_ususario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabusuario)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabnombre)
                    .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextisert_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextinsert_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabtelefono)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPausuLayout.createSequentialGroup()
                        .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextinsert_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabcorreo))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPausuLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)))
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCbBoxselec_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabdireccion)
                    .addComponent(jTextinser_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jDateChooserFecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(48, 48, 48)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabcargo)
                    .addComponent(jComboBoxcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextinsert_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPausuLayout.createSequentialGroup()
                        .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabinsert_clave)
                            .addGroup(jPausuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPasinsert_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPausuLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButtoguardar)
                        .addGap(25, 25, 25))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPausu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPausu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextisert_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextisert_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextisert_nombreActionPerformed

    private void jTextinser_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextinser_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextinser_direccionActionPerformed

    private void jCbBoxselec_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBoxselec_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbBoxselec_sexoActionPerformed

    private void jTextinsert_ususarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextinsert_ususarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextinsert_ususarioActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoguardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCbBoxselec_sexo;
    private javax.swing.JComboBox<String> jComboBoxcargo;
    private com.toedter.calendar.JDateChooser jDateChooserFecha_nacimiento;
    private javax.swing.JLabel jLabcargo;
    private javax.swing.JLabel jLabcorreo;
    private javax.swing.JLabel jLabdireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabinsert_clave;
    private javax.swing.JLabel jLabnombre;
    private javax.swing.JLabel jLabtelefono;
    private javax.swing.JLabel jLabusuario;
    private javax.swing.JLabel jLbnuevo_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasinsert_clave;
    private javax.swing.JPanel jPausu;
    private javax.swing.JTextField jTextinser_direccion;
    private javax.swing.JTextField jTextinsert_correo;
    private javax.swing.JTextField jTextinsert_login;
    private javax.swing.JTextField jTextinsert_telefono;
    private javax.swing.JTextField jTextinsert_ususario;
    private javax.swing.JTextField jTextisert_nombre;
    // End of variables declaration//GEN-END:variables

    public Object getjButtonNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
