/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
    }

    public JLabel getjLnuvo_provee() {
        return jLnuvo_provee;
    }

    public void setjLnuvo_provee(JLabel jLnuvo_provee) {
        this.jLnuvo_provee = jLnuvo_provee;
    }

    public JDateChooser getjDateChorFecha_provee() {
        return jDateChorFecha_provee;
    }

    public void setjDateChorFecha_provee(JDateChooser jDateChorFecha_provee) {
        this.jDateChorFecha_provee = jDateChorFecha_provee;
    }

    public JPanel getjPanelprovee() {
        return jPanelprovee;
    }

    public void setjPanelprovee(JPanel jPanelprovee) {
        this.jPanelprovee = jPanelprovee;
    }

    public JTextField getjTxtinserDirecc() {
        return jTxtinserDirecc;
    }

    public void setjTxtinserDirecc(JTextField jTxtinserDirecc) {
        this.jTxtinserDirecc = jTxtinserDirecc;
    }

    public JComboBox<String> getJCboxsexo_pro() {
        return JCboxsexo_pro;
    }

    public void setJCboxsexo_pro(JComboBox<String> JCboxsexo_pro) {
        this.JCboxsexo_pro = JCboxsexo_pro;
    }

    public JButton getjButtonguardar_Provedores() {
        return jButtonguardar_Provedores;
    }

    public void setjButtonguardar_Provedores(JButton jButtonguardar_Provedores) {
        this.jButtonguardar_Provedores = jButtonguardar_Provedores;
    }

    public JComboBox<String> getjComboBoxtipo_docume() {
        return jComboBoxtipo_docume;
    }

    public void setjComboBoxtipo_docume(JComboBox<String> jComboBoxtipo_docume) {
        this.jComboBoxtipo_docume = jComboBoxtipo_docume;
    }

    public JComboBox<String> getjComboBoxtipo_persona() {
        return jComboBoxtipo_persona;
    }

    public void setjComboBoxtipo_persona(JComboBox<String> jComboBoxtipo_persona) {
        this.jComboBoxtipo_persona = jComboBoxtipo_persona;
    }

    public JTextField getjTxtinserCorreo() {
        return jTxtinserCorreo;
    }

    public void setjTxtinserCorreo(JTextField jTxtinserCorreo) {
        this.jTxtinserCorreo = jTxtinserCorreo;
    }

    public JTextField getjTxtinserIdprovedor() {
        return jTxtinserIdprovedor;
    }

    public void setjTxtinserIdprovedor(JTextField jTxtinserIdprovedor) {
        this.jTxtinserIdprovedor = jTxtinserIdprovedor;
    }

    public JTextField getjTxtinserNombre() {
        return jTxtinserNombre;
    }

    public void setjTxtinserNombre(JTextField jTxtinserNombre) {
        this.jTxtinserNombre = jTxtinserNombre;
    }

    public JTextField getjTxtinserTelefono() {
        return jTxtinserTelefono;
    }

    public void setjTxtinserTelefono(JTextField jTxtinserTelefono) {
        this.jTxtinserTelefono = jTxtinserTelefono;
    }

  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelprovee = new javax.swing.JPanel();
        jLnuvo_provee = new javax.swing.JLabel();
        jLbidproveedor = new javax.swing.JLabel();
        jTxtinserIdprovedor = new javax.swing.JTextField();
        jLbinserTipo_docu = new javax.swing.JLabel();
        jLblinserNombre = new javax.swing.JLabel();
        jTxtinserNombre = new javax.swing.JTextField();
        jLblinserSexo = new javax.swing.JLabel();
        JCboxsexo_pro = new javax.swing.JComboBox<>();
        jLblcorreo = new javax.swing.JLabel();
        jTxtinserCorreo = new javax.swing.JTextField();
        jLbltelefono = new javax.swing.JLabel();
        jTxtinserTelefono = new javax.swing.JTextField();
        jComboBoxtipo_docume = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxtipo_persona = new javax.swing.JComboBox<>();
        jButtonguardar_Provedores = new javax.swing.JButton();
        jLbldirec_pro = new javax.swing.JLabel();
        jTxtinserDirecc = new javax.swing.JTextField();
        jLbfechapro = new javax.swing.JLabel();
        jDateChorFecha_provee = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLnuvo_provee.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLnuvo_provee.setText("NUEVO PROVEEDOR");

        jLbidproveedor.setText("Idproveedor");

        jLbinserTipo_docu.setText("Tipo de Documento");

        jLblinserNombre.setText("Nombre");

        jTxtinserNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtinserNombreActionPerformed(evt);
            }
        });

        jLblinserSexo.setText("Sexo");

        JCboxsexo_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCboxsexo_proActionPerformed(evt);
            }
        });

        jLblcorreo.setText("Correo");

        jTxtinserCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtinserCorreoActionPerformed(evt);
            }
        });

        jLbltelefono.setText("Telefono");

        jTxtinserTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtinserTelefonoActionPerformed(evt);
            }
        });

        jComboBoxtipo_docume.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione... Nit", "Pasaporte", "Otros" }));
        jComboBoxtipo_docume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtipo_documeActionPerformed(evt);
            }
        });

        jLabel2.setText("TIipo de Persona");

        jComboBoxtipo_persona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione... Juridica", "Natural" }));

        jButtonguardar_Provedores.setText("Guardar");

        jLbldirec_pro.setText("Dirección");

        jLbfechapro.setText("Fecha del Proveedor");

        jDateChorFecha_provee.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanelproveeLayout = new javax.swing.GroupLayout(jPanelprovee);
        jPanelprovee.setLayout(jPanelproveeLayout);
        jPanelproveeLayout.setHorizontalGroup(
            jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelproveeLayout.createSequentialGroup()
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLnuvo_provee))
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelproveeLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLbidproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelproveeLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblinserSexo)
                                    .addComponent(jLblinserNombre)
                                    .addComponent(jLblcorreo)
                                    .addComponent(jLbltelefono)
                                    .addComponent(jLbldirec_pro)
                                    .addComponent(jLabel2)
                                    .addComponent(jLbfechapro)))
                            .addGroup(jPanelproveeLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLbinserTipo_docu)))
                        .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelproveeLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelproveeLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTxtinserTelefono)
                                                .addComponent(jTxtinserCorreo)
                                                .addComponent(jTxtinserDirecc, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                            .addComponent(jComboBoxtipo_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTxtinserIdprovedor, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtinserNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxtipo_docume, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JCboxsexo_pro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanelproveeLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jDateChorFecha_provee, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButtonguardar_Provedores)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanelproveeLayout.setVerticalGroup(
            jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelproveeLayout.createSequentialGroup()
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLnuvo_provee)
                        .addGap(37, 37, 37)
                        .addComponent(jLbidproveedor))
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jTxtinserIdprovedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLbinserTipo_docu))
                    .addGroup(jPanelproveeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxtipo_docume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblinserNombre)
                    .addComponent(jTxtinserNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblinserSexo)
                    .addComponent(JCboxsexo_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblcorreo)
                    .addComponent(jTxtinserCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbltelefono)
                    .addComponent(jTxtinserTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbldirec_pro)
                    .addComponent(jTxtinserDirecc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxtipo_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelproveeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbfechapro)
                    .addComponent(jDateChorFecha_provee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButtonguardar_Provedores)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelprovee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelprovee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtinserNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtinserNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtinserNombreActionPerformed

    private void JCboxsexo_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCboxsexo_proActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCboxsexo_proActionPerformed

    private void jTxtinserCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtinserCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtinserCorreoActionPerformed

    private void jTxtinserTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtinserTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtinserTelefonoActionPerformed

    private void jComboBoxtipo_documeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtipo_documeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxtipo_documeActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCboxsexo_pro;
    private javax.swing.JButton jButtonguardar_Provedores;
    private javax.swing.JComboBox<String> jComboBoxtipo_docume;
    private javax.swing.JComboBox<String> jComboBoxtipo_persona;
    private com.toedter.calendar.JDateChooser jDateChorFecha_provee;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLbfechapro;
    private javax.swing.JLabel jLbidproveedor;
    private javax.swing.JLabel jLbinserTipo_docu;
    private javax.swing.JLabel jLblcorreo;
    private javax.swing.JLabel jLbldirec_pro;
    private javax.swing.JLabel jLblinserNombre;
    private javax.swing.JLabel jLblinserSexo;
    private javax.swing.JLabel jLbltelefono;
    private javax.swing.JLabel jLnuvo_provee;
    private javax.swing.JPanel jPanelprovee;
    private javax.swing.JTextField jTxtinserCorreo;
    private javax.swing.JTextField jTxtinserDirecc;
    private javax.swing.JTextField jTxtinserIdprovedor;
    private javax.swing.JTextField jTxtinserNombre;
    private javax.swing.JTextField jTxtinserTelefono;
    // End of variables declaration//GEN-END:variables

    public Object getjBtngardar_proveedorespr() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getjButtonNuevo1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
