
//esta
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Modelo_producto;
import vista.Principal;
import vista.Producto;

public class Controlador_Producto implements ActionListener {

    Producto prod = new Producto();
    Principal pri = new Principal();
    Modelo_producto mode_prod = new Modelo_producto();

    public Controlador_Producto() {
        prod.getjBtnguardar_prod().addActionListener(this);
        prod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

     public void iniciarProducto () {
        pri.setVisible(false);
        prod.setLocationRelativeTo(null);
        prod.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent y) {

        if (y.getSource().equals(prod.getjBtnimage())) {
            mode_prod.buscarImagen();
            File file = new File(mode_prod.getRuta());
            String archivo = file.getName();//obtiene solo el nombre de la ruta
            prod.getjTextArimagen().setText(archivo);
        }
        if (y.getSource().equals(prod.getjBtnguardar_prod())) {
            if (prod.getId_produc().getText().isEmpty()||prod.getjTxtnom_prod().getText().isEmpty()|| prod.getjTextArimagen().getText().isEmpty()|| prod.getjTxtdescrip_pro().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "FALTA INFORMACION EN LOS CAMPOS");
            }else {
            
                mode_prod.setIdpr(Integer.parseInt(prod.getId_produc().getText()));
                mode_prod.setNom(prod.getjTxtnom_prod().getText());
                mode_prod.setDescri(prod.getjTxtdescrip_pro().getText());
//                mode_prod.setRuta(prod.getjTextruta().getText());
                mode_prod.setImagen(mode_prod.obtenerImagen(mode_prod.getRuta()));
                
                
            } if(prod.getjBtnguardar_prod().getText().equals("Guardar")){
                mode_prod.eliminarProducto();
                mode_prod.limProduc(prod.getjPanelproduct().getComponents());
            }else {
            
                mode_prod.actualizarProdcuto();
                prod.setVisible(false);
                pri.getJtPrincipal().setSelectedIndex(1);
                mode_prod.mostrarTablaProducto(pri.getjTableProducto(), "", "Producto");
                prod.dispose();
            }
        }
            
    }
    public void actualizarProducto(int idpr){
        mode_prod.buscarProducto(idpr);
        prod.getId_produc().setEnabled(false);
        prod.getjTxtnom_prod().setText(mode_prod.getNom());
        prod.getjTxtdescrip_pro().setText(mode_prod.getDescri());
//        prod.getjTextruta().setText(mode_prod.getRuta());
        prod.getjTextArimagen().setEnabled(false);
        
        prod.getjLblnuev_product().setText("Actualizar Producto");
        pri.setVisible(false);
        prod.setLocationRelativeTo(null);
        prod.getjBtnguardar_prod().setText("Actualizar");
        
//        File file = new File(mode_prod.getIdpr());//.getRoute());
//        String archivo = file.getName();
//        prod.getjTextArimagen().setText(archivo);
//        
    }
    public void eliminarProducto(int idpr) {
        int resp = JOptionPane.showConfirmDialog(null, "Eliminar Producto? \n" + idpr,
                "Eliminar Producto", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            mode_prod.setIdpr(idpr);
            mode_prod.eliminarProducto();
            mode_prod.mostrarTablaProducto(pri.getjTableProducto(), "", "Producto");
//            modpro.setIdpro(idpr);
//            modpro.eliminarProducto();
//            modpro.mostrarTablaProducto(prin.getJtProducto(), "", "Producto");
        }

    }

}

  
     
