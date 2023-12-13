///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package controlador;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import javax.swing.BorderFactory;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.border.Border;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import modelo.Modelo_Factura_Compra;
//import modelo.Modelo_Proveedor;
//import modelo.Modelo_Usuario;
//import vista.Buscar;
//import vista.Factura;
//import vista.Principal;
//
//
//public class Controlador_Factura_Compra implements ActionListener, DocumentListener {
//    Factura fac = new  Factura();
//    Principal pri = new Principal();
//    Modelo_Usuario mode_usu = new Modelo_Usuario();
//    Modelo_Proveedor mod_pro = new Modelo_Proveedor();
//    Modelo_Factura_Compra mod_faC = new Modelo_Factura_Compra();
//    Buscar bus = new Buscar ();
//
//    public Controlador_Factura_Compra() {
//       fac.getjButtGuardarFact().addActionListener(this);
//       fac.getjCBoxtipo_pago().addActionListener(this);
//       fac.getjTxtid_prove().addActionListener(this);
//       fac.getjTxtide_usu().addActionListener(this);
//       fac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//       fac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//       pri.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//       fac.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                Controlador_Principal Vista = new Controlador_Principal();
//                Vista.iniciarPrincipal(4);
//            }
//        });
//        
//    }
//
//    public void controlFacturaCompra() {
//        pri.setVisible(false);
//        fac.setLocationRelativeTo(null);
//        fac.setTitle("Nueva Fcatura Compra");
//        fac.setVisible(true);
//        buscarFactura();
//        
//    }
//
//
//    public void buscarFactura() {
//        pri.getTblFactura().addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                int fila = pri.getTblFactura().rowAtPoint(e.getPoint());
//                int colum = pri.getTblFactura().columnAtPoint(e.getPoint());
//
//                if (fac.getjLblnuev_fact().getText().equals("Usuario")) {
//                    mode_usu.setIdUsu(Integer.parseInt(pri.getTblFactura().getValueAt(fila, 0).toString()));
//                    if (colum == 9) {
//                        pri.setVisible(false);
//                        fac.setVisible(true);
//                        Object idusua = mode_usu.getIdUsu();
//                        fac.getjTxtide_usu().setText(idusua.toString());
//                        JOptionPane.showMessageDialog(null, "Usuario Agregado");
//                    }
//                } else {
//                    mod_pro.setIdpro(Integer.parseInt(pri.getTblFactura().getValueAt(fila, 0).toString()));
//                    if (colum == 9) {
//                        fac.setVisible(false);
//                        fac.setVisible(true);
//                        Object idpro = mod_pro.getIdpro();
//                        fac.getjTxtid_prove().setText(idpro.toString());
//                        JOptionPane.showMessageDialog(null, "Proveedor Agregado");
//                    }
//                }
//            }
//        });
//           pri.getjTexbuscar_factura().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                pri.getjTexbuscar_factura().setText("");
//                 pri.getjTexbuscar_factura().setForeground(new java.awt.Color(0, 0, 0));
//            }
//        });
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(fac.getBtnbuscar_usu())) {
//////            fac.getjLblnuev_fact().setText("Usuario");
//            fac.setVisible(false);
//            fac.setLocationRelativeTo(null);
//            mode_usu.mostraTablaUsu(pri.getTable_usuario(), "", "Nueva Factura");
//            fac.setVisible(true);
//            Border borde = BorderFactory.createTitledBorder(null, "Buscar Usuario",
//                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
//                    new java.awt.Font("Yu Gothic UI", 1, 36),
//                    new java.awt.Color(204, 0, 204));
//            fac.getjPanelFactura().setBorder(borde);
//        }
//        if (e.getSource().equals(fac.getBtnbuscar_Proveedor())) {
//            if ((fac.getjTxtid_prove().getText().isEmpty())
//                    || (fac.getjTxtide_usu().getText().isEmpty()) || (fac.getjTexid_fac().getText().isEmpty())
//                    || (fac.getjCBoxtipo_pago().getSelectedItem().equals("Seleccione..."))) {
//                JOptionPane.showMessageDialog(null, "IngresE información Nombre y Descripción");
//            } else {
//                mod_faC.setIdf_com(Integer.parseInt(fac.getjTxtid_prove().getText()));
//                mod_faC.setIdPro(Integer.parseInt(fac.getjTxtid_prove().getText()));
//                mod_faC.setIdUsu(Integer.parseInt(fac.getjTxtide_usu().getText()));
//                mod_faC.setTipo_pago(fac.getjCBoxtipo_pago().getSelectedItem().toString());
//            }
//            if (fac.getBtnbuscar_usu().getText().equals("Guardar")) {
//                mod_faC.insertarFactcompra();
//                mod_faC.limpiar(fac.getjPanelFactura().getComponents());
//            } else {
//                mod_faC.actualizarFacturaCompra();
//                fac.setVisible(false);
//                fac.dispose();
//                mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), "", "Factura");
//            }
//        }
//    }
//    void actualizarFactcompra(int doc) {
//        mod_faC.buscarFactcompra(doc);
//        fac.getjTexid_fac().setText(String.valueOf(mod_faC.getIdf_com()));
//        fac.getjTxtid_prove().setText(String.valueOf(mod_faC.getIdPro()));
//        fac.getjTxtide_usu().setText(String.valueOf(mod_faC.getIdUsu()));
//
////        //Llenar tipo de pago
//        fac.getjCBoxtipo_pago().setSelectedItem(mod_faC.getTipo_pago());
////        //Cambiar Titulo
//        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Factura Compra",
//                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
//                new java.awt.Font("Yu Gothic UI", 1, 36),
//                new java.awt.Color(255, 0, 102));//255,0,102
//        fac.getjPanelFactura().setBorder(borde);
//        pri.setVisible(false);
//        fac.setLocationRelativeTo(null);
//        fac.getjButtGuardarFact().setText("Actualizar");
//        fac.setVisible(true);
//    }
//
//    @Override
//    public void insertUpdate(DocumentEvent e) {
//        if (fac.getjLblnuev_fact().getText().equals("Usuario")) {
//            mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Nueva Factura");
//            
//        } else {
//            mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Nueva Factura");
//        }
//    }
//
//    @Override
//    public void removeUpdate(DocumentEvent e) {
//         if (fac.getjLblnuev_fact().getText().equals("Usuario")) {
//            mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Nueva Factura");
//            
//        } else {
//            mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Nueva Factura");
//        }
//    }
//
//    @Override
//    public void changedUpdate(DocumentEvent e) {
//        if (fac.getjLblnuev_fact().getText().equals("Usuario")) {
//            mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Nueva Factura");
//            
//        } else {
//            mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Nueva Factura");
//        }
//    }
//    
//}
