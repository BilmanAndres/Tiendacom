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


public class Clientes extends javax.swing.JFrame {

   
    public Clientes() {
        initComponents();
    }

    public JLabel getjLnuevo_cli() {
        return jLnuevo_cli;
    }

    public void setjLnuevo_cli(JLabel jLnuevo_cli) {
        this.jLnuevo_cli = jLnuevo_cli;
    }

    public JPanel getjPanel_cliente() {
        return jPanel_cliente;
    }

    public void setjPanel_cliente(JPanel jPanel_cliente) {
        this.jPanel_cliente = jPanel_cliente;
    }

    public JDateChooser getjDatefecha_clien() {
        return jDatefecha_clien;
    }

    public void setjDatefecha_clien(JDateChooser jDatefecha_clien) {
        this.jDatefecha_clien = jDatefecha_clien;
    }

    public JButton getjButtguardar_cliente() {
        return jButtguardar_cliente;
    }

    public void setjButtguardar_cliente(JButton jButtguardar_cliente) {
        this.jButtguardar_cliente = jButtguardar_cliente;
    }

    public JComboBox<String> getjCoboxsexo() {
        return JCoboxsexo;
    }

    public void setjCoboxsexo(JComboBox<String> jCoboxsexo) {
        this.JCoboxsexo = jCoboxsexo;
    }

    public JDateChooser getjDateChooser1() {
        return jDatefecha_clien;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDatefecha_clien = jDateChooser1;
    }

    public JTextField getjTextcilente() {
        return jTextcilente;
    }

    public void setjTextcilente(JTextField jTextcilente) {
        this.jTextcilente = jTextcilente;
    }

    public JTextField getjTextcorreo() {
        return jTextcorreo;
    }

    public void setjTextcorreo(JTextField jTextcorreo) {
        this.jTextcorreo = jTextcorreo;
    }

    public JTextField getjTextelefono() {
        return jTextelefono;
    }

    public void setjTextelefono(JTextField jTextelefono) {
        this.jTextelefono = jTextelefono;
    }

    public JTextField getjTextnombre() {
        return jTextnombre;
    }

    public void setjTextnombre(JTextField jTextnombre) {
        this.jTextnombre = jTextnombre;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_cliente = new javax.swing.JPanel();
        jLnuevo_cli = new javax.swing.JLabel();
        jLabcliente = new javax.swing.JLabel();
        jTextcilente = new javax.swing.JTextField();
        jLabnombre = new javax.swing.JLabel();
        jLabtelefono = new javax.swing.JLabel();
        jLabcorreo = new javax.swing.JLabel();
        jLabsexo = new javax.swing.JLabel();
        jLabfecha_nacimento = new javax.swing.JLabel();
        jTextnombre = new javax.swing.JTextField();
        jTextelefono = new javax.swing.JTextField();
        jTextcorreo = new javax.swing.JTextField();
        JCoboxsexo = new javax.swing.JComboBox<>();
        jDatefecha_clien = new com.toedter.calendar.JDateChooser();
        jButtguardar_cliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_cliente.setBackground(new java.awt.Color(255, 102, 204));
        jPanel_cliente.setForeground(new java.awt.Color(204, 0, 102));

        jLnuevo_cli.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLnuevo_cli.setText("NUEVO CLIENTE");

        jLabcliente.setText("IdCliente");

        jTextcilente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextcilenteActionPerformed(evt);
            }
        });

        jLabnombre.setText("Nombre");

        jLabtelefono.setText("Telefono");

        jLabcorreo.setText("Correo");

        jLabsexo.setText("sexo");

        jLabfecha_nacimento.setText("fecha_nacimineto");

        JCoboxsexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCoboxsexoActionPerformed(evt);
            }
        });

        jButtguardar_cliente.setText("GUARDAR");
        jButtguardar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtguardar_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_clienteLayout = new javax.swing.GroupLayout(jPanel_cliente);
        jPanel_cliente.setLayout(jPanel_clienteLayout);
        jPanel_clienteLayout.setHorizontalGroup(
            jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_clienteLayout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jLnuevo_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(jPanel_clienteLayout.createSequentialGroup()
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_clienteLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabnombre)
                            .addComponent(jLabcliente)
                            .addComponent(jLabtelefono)
                            .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabsexo)
                                .addComponent(jLabcorreo))))
                    .addGroup(jPanel_clienteLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabfecha_nacimento)))
                .addGap(69, 69, 69)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtguardar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatefecha_clien, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextcilente, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addComponent(jTextnombre)
                        .addComponent(jTextelefono)
                        .addComponent(jTextcorreo)
                        .addComponent(JCoboxsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_clienteLayout.setVerticalGroup(
            jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_clienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLnuevo_cli)
                .addGap(36, 36, 36)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabcliente)
                    .addComponent(jTextcilente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabnombre)
                    .addComponent(jTextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabtelefono)
                    .addComponent(jTextelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabcorreo)
                    .addComponent(jTextcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabsexo)
                    .addComponent(JCoboxsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabfecha_nacimento)
                    .addComponent(jDatefecha_clien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButtguardar_cliente)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextcilenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextcilenteActionPerformed
        
    }//GEN-LAST:event_jTextcilenteActionPerformed

    private void jButtguardar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtguardar_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtguardar_clienteActionPerformed

    private void JCoboxsexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCoboxsexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCoboxsexoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCoboxsexo;
    private javax.swing.JButton jButtguardar_cliente;
    private com.toedter.calendar.JDateChooser jDatefecha_clien;
    private javax.swing.JLabel jLabcliente;
    private javax.swing.JLabel jLabcorreo;
    private javax.swing.JLabel jLabfecha_nacimento;
    private javax.swing.JLabel jLabnombre;
    private javax.swing.JLabel jLabsexo;
    private javax.swing.JLabel jLabtelefono;
    private javax.swing.JLabel jLnuevo_cli;
    private javax.swing.JPanel jPanel_cliente;
    private javax.swing.JTextField jTextcilente;
    private javax.swing.JTextField jTextcorreo;
    private javax.swing.JTextField jTextelefono;
    private javax.swing.JTextField jTextnombre;
    // End of variables declaration//GEN-END:variables

    public Object getJCoboxsexo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getjButtonuevo_cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object JCoboxsexo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object jDateChooser1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
