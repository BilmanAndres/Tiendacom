/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author SENA
 */
public class Producto extends javax.swing.JFrame {

    /**
     * Creates new form Producto
     */
    public Producto() {
        initComponents();
    }

    public JTextArea getjTextDescripcion() {
        return jTextDescripcion;
    }

    public void setjTextDescripcion(JTextArea jTextDescripcion) {
        this.jTextDescripcion = jTextDescripcion;
    }

    public JTextField getjTxtImagen() {
        return jTxtImagen;
    }

    public void setjTxtImagen(JTextField jTxtImagen) {
        this.jTxtImagen = jTxtImagen;
    }

    public JPanel getjPanelproduct() {
        return jPanelproduct;
    }

    public void setjPanelproduct(JPanel jPanelproduct) {
        this.jPanelproduct = jPanelproduct;
    }

    public JPanel getjPanel1() {
        return jPanelproduct;
    }

    public JLabel getjLblnuev_product() {
        return jLblnuev_product;
    }

    public void setjLblnuev_product(JLabel jLblnuev_product) {
        this.jLblnuev_product = jLblnuev_product;
    }

    public JLabel getId_producto() {
        return id_producto;
    }

    public void setId_producto(JLabel id_producto) {
        this.id_producto = id_producto;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanelproduct = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextField getId_produc() {
        return id_produc;
    }

    public void setId_produc(JTextField id_produc) {
        this.id_produc = id_produc;
    }

    public JButton getjBtnguardar_prod() {
        return jBtnguardar_prod;
    }

    public void setjBtnguardar_prod(JButton jBtnguardar_prod) {
        this.jBtnguardar_prod = jBtnguardar_prod;
    }

    public JButton getjBtnimage() {
        return jBtnimage;
    }

    public void setjBtnimage(JButton jBtnimage) {
        this.jBtnimage = jBtnimage;
    }

    public JTextArea getjTextArimagen() {
        return jTextDescripcion;
    }

    public void setjTextArimagen(JTextArea jTextArimagen) {
        this.jTextDescripcion = jTextArimagen;
    }

    public JTextField getjTxtdescrip_pro() {
        return jTxtImagen;
    }

    public void setjTxtdescrip_pro(JTextField jTxtdescrip_pro) {
        this.jTxtImagen = jTxtdescrip_pro;
    }

    public JTextField getjTxtnom_prod() {
        return jTxtnom_prod;
    }

    public void setjTxtnom_prod(JTextField jTxtnom_prod) {
        this.jTxtnom_prod = jTxtnom_prod;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelproduct = new javax.swing.JPanel();
        jLblnuev_product = new javax.swing.JLabel();
        jLblnombre = new javax.swing.JLabel();
        jLblimagen = new javax.swing.JLabel();
        jLbldescrion = new javax.swing.JLabel();
        jTxtnom_prod = new javax.swing.JTextField();
        jTxtImagen = new javax.swing.JTextField();
        jBtnimage = new javax.swing.JButton();
        jBtnguardar_prod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDescripcion = new javax.swing.JTextArea();
        id_producto = new javax.swing.JLabel();
        id_produc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblnuev_product.setText("NUEVO PRODUCTO");

        jLblnombre.setText("NOMBRE");

        jLblimagen.setText("IMAGEN");

        jLbldescrion.setText("DESCRIPCIÓN");

        jTxtnom_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtnom_prodActionPerformed(evt);
            }
        });

        jTxtImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtImagenActionPerformed(evt);
            }
        });

        jBtnimage.setText("imag");

        jBtnguardar_prod.setText("GUARDAR");
        jBtnguardar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnguardar_prodActionPerformed(evt);
            }
        });

        jTextDescripcion.setColumns(20);
        jTextDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextDescripcion);

        id_producto.setText("ID Producto");

        javax.swing.GroupLayout jPanelproductLayout = new javax.swing.GroupLayout(jPanelproduct);
        jPanelproduct.setLayout(jPanelproductLayout);
        jPanelproductLayout.setHorizontalGroup(
            jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelproductLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(id_producto)
                        .addComponent(jLblnombre)
                        .addComponent(jLbldescrion))
                    .addGroup(jPanelproductLayout.createSequentialGroup()
                        .addComponent(jLblimagen)
                        .addGap(13, 13, 13)))
                .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelproductLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelproductLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jTxtImagen)
                        .addGap(43, 43, 43)
                        .addComponent(jBtnimage)
                        .addGap(80, 80, 80))
                    .addGroup(jPanelproductLayout.createSequentialGroup()
                        .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelproductLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jTxtnom_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelproductLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(id_produc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelproductLayout.createSequentialGroup()
                .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelproductLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLblnuev_product))
                    .addGroup(jPanelproductLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jBtnguardar_prod)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelproductLayout.setVerticalGroup(
            jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelproductLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLblnuev_product)
                .addGap(18, 18, 18)
                .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_producto)
                    .addComponent(id_produc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblnombre)
                    .addComponent(jTxtnom_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelproductLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanelproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnimage)))
                    .addGroup(jPanelproductLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLbldescrion)
                        .addGap(70, 70, 70)
                        .addComponent(jLblimagen)))
                .addGap(36, 36, 36)
                .addComponent(jBtnguardar_prod)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelproduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelproduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtnom_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtnom_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtnom_prodActionPerformed

    private void jTxtImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtImagenActionPerformed

    private void jBtnguardar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnguardar_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnguardar_prodActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id_produc;
    private javax.swing.JLabel id_producto;
    private javax.swing.JButton jBtnguardar_prod;
    private javax.swing.JButton jBtnimage;
    private javax.swing.JLabel jLbldescrion;
    private javax.swing.JLabel jLblimagen;
    private javax.swing.JLabel jLblnombre;
    private javax.swing.JLabel jLblnuev_product;
    private javax.swing.JPanel jPanelproduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextDescripcion;
    private javax.swing.JTextField jTxtImagen;
    private javax.swing.JTextField jTxtnom_prod;
    // End of variables declaration//GEN-END:variables
}
