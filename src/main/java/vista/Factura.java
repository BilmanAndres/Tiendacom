/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author SENA
 */
public class Factura extends javax.swing.JFrame {

    /**
     * Creates new form Factura
     */
    public Factura() {
        initComponents();
    }

    public JTextField getjTexid_fac() {
        return jTexid_fac;
    }

    public void setjTexid_fac(JTextField jTexid_fac) {
        this.jTexid_fac = jTexid_fac;
    }

    public JButton getBtnbuscar_Proveedor() {
        return btnbuscar_Proveedor;
    }

    public void setBtnbuscar_Proveedor(JButton btnbuscar_Proveedor) {
        this.btnbuscar_Proveedor = btnbuscar_Proveedor;
    }

    public JButton getBtnbuscar_usu() {
        return btnbuscar_usu;
    }

    public void setBtnbuscar_usu(JButton btnbuscar_usu) {
        this.btnbuscar_usu = btnbuscar_usu;
    }

    public JLabel getjLblnuev_fact() {
        return jLblnuev_fact;
    }

    public void setjLblnuev_fact(JLabel jLblnuev_fact) {
        this.jLblnuev_fact = jLblnuev_fact;
    }

    public JButton getjButtGuardarFact() {
        return jButtGuardarFact;
    }

    public void setjButtGuardarFact(JButton jButtGuardarFact) {
        this.jButtGuardarFact = jButtGuardarFact;
    }

    public JComboBox<String> getjCBoxtipo_pago() {
        return jCBoxtipo_pago;
    }

    public void setjCBoxtipo_pago(JComboBox<String> jCBoxtipo_pago) {
        this.jCBoxtipo_pago = jCBoxtipo_pago;
    }

    public JPanel getjPanelFactura() {
        return jPanelFactura;
    }

    public void setjPanelFactura(JPanel jPanelFactura) {
        this.jPanelFactura = jPanelFactura;
    }

    public JTextField getjTxtid_prove() {
        return jTxtid_prove;
    }

    public void setjTxtid_prove(JTextField jTxtid_prove) {
        this.jTxtid_prove = jTxtid_prove;
    }

    public JTextField getjTxtide_usu() {
        return jTxtide_usu;
    }

    public void setjTxtide_usu(JTextField jTxtide_usu) {
        this.jTxtide_usu = jTxtide_usu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelFactura = new javax.swing.JPanel();
        jLblnuev_fact = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCBoxtipo_pago = new javax.swing.JComboBox<>();
        jLblid_prove = new javax.swing.JLabel();
        jLblide_usuari = new javax.swing.JLabel();
        jTxtid_prove = new javax.swing.JTextField();
        jTxtide_usu = new javax.swing.JTextField();
        jButtGuardarFact = new javax.swing.JButton();
        btnbuscar_Proveedor = new javax.swing.JButton();
        btnbuscar_usu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTexid_fac = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblnuev_fact.setText("NUEVA FACTURA");

        jLabel1.setText("Tipo De Pago");

        jCBoxtipo_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionarr..", "Efectivo ", "Tarjeta de credito" }));
        jCBoxtipo_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxtipo_pagoActionPerformed(evt);
            }
        });

        jLblid_prove.setText("Identificador de Proveedor");

        jLblide_usuari.setText("Identificador del Usuaraio");

        jButtGuardarFact.setText("GUARDAR");

        btnbuscar_Proveedor.setText("Buscar Prove");

        btnbuscar_usu.setText("Buscar Usuario");

        jLabel3.setText("ID Factura");

        javax.swing.GroupLayout jPanelFacturaLayout = new javax.swing.GroupLayout(jPanelFactura);
        jPanelFactura.setLayout(jPanelFacturaLayout);
        jPanelFacturaLayout.setHorizontalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                        .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jButtGuardarFact))
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLblnuev_fact)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                        .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLblide_usuari)
                                    .addComponent(jLblid_prove)))
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3)))
                        .addGap(86, 86, 86)
                        .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCBoxtipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtid_prove, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(jTxtide_usu))
                                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbuscar_Proveedor)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(btnbuscar_usu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addComponent(jTexid_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelFacturaLayout.setVerticalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLblnuev_fact)
                .addGap(21, 21, 21)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTexid_fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCBoxtipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblid_prove)
                    .addComponent(jTxtid_prove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_Proveedor))
                .addGap(29, 29, 29)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblide_usuari)
                    .addComponent(jTxtide_usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_usu))
                .addGap(54, 54, 54)
                .addComponent(jButtGuardarFact)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBoxtipo_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxtipo_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxtipo_pagoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar_Proveedor;
    private javax.swing.JButton btnbuscar_usu;
    private javax.swing.JButton jButtGuardarFact;
    private javax.swing.JComboBox<String> jCBoxtipo_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblid_prove;
    private javax.swing.JLabel jLblide_usuari;
    private javax.swing.JLabel jLblnuev_fact;
    private javax.swing.JPanel jPanelFactura;
    private javax.swing.JTextField jTexid_fac;
    private javax.swing.JTextField jTxtid_prove;
    private javax.swing.JTextField jTxtide_usu;
    // End of variables declaration//GEN-END:variables
}