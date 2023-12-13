
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.Modelo_Factura_Compra;
import modelo.Modelo_Proveedor;
import modelo.Modelo_Usuario;
import modelo.Modelo_Ventas;
import vista.Agregar_Detalle_Factura;
import vista.Buscar;
import vista.Buscar_Producto;
import vista.Factura;
import vista.Mostra_Detalle_Factura_Compr;
import vista.Principal;
import vista.Venta;

public class Controlador_Factura_Compr implements ActionListener, DocumentListener {

    Factura fac = new Factura();
    Principal pri = new Principal();
    Buscar bus = new Buscar();
    Modelo_Usuario mode_usu = new Modelo_Usuario();
    Modelo_Proveedor mod_pro = new Modelo_Proveedor();
    Modelo_Factura_Compra mod_faC = new Modelo_Factura_Compra();
    //
     Venta ven = new Venta();
     Modelo_Ventas mod_ven = new Modelo_Ventas();

     Agregar_Detalle_Factura deta_fact = new Agregar_Detalle_Factura ();
     
     //
    Buscar_Producto bus_pro = new Buscar_Producto();
    
    //
    Mostra_Detalle_Factura_Compr mostra_de = new Mostra_Detalle_Factura_Compr();
     
    public Controlador_Factura_Compr() {
        ven.getBut_guardarv().addActionListener(this);
        fac.getjButtGuardarFact().addActionListener(this);
        fac.getBtnbuscar_Proveedor().addActionListener(this);
        fac.getBtnbuscar_usu().addActionListener(this);
        bus.getTxtbuscar().getDocument().addDocumentListener(this);
        deta_fact.getBtnbuscar_prod().addActionListener(this);
        deta_fact.getBtnagregar().addActionListener(this);
        bus_pro.getTxtbuscar_produc().getDocument().addDocumentListener(this);
        deta_fact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostra_de.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bus_pro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fac.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Controlador_Principal Vista = new Controlador_Principal();
                Vista.iniciarPrincipal(4);
            }
        });

        bus.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fac.setVisible(true);
                bus.setVisible(false);
            }
        });
        
        deta_fact.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fac.dispose();
            }
        });
        
        bus_pro.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                deta_fact.setVisible(true);
            }
        });

    }
    
    public void agregarDetalle(int fac) {
        deta_fact.setVisible(true);
        deta_fact.setLocationRelativeTo(null);
        deta_fact.setTitle("Agregar Detalle");
        deta_fact.getLbfactura().setText(String.valueOf(fac));
    }

    public void controlFacturaCompra() {
        pri.setVisible(false);
        fac.setLocationRelativeTo(null);
        fac.setTitle("Nueva Fcatura Compra");
        fac.setVisible(true);
        buscarFactura();
    }
    
    public void buscarFactura() {
        bus.getTable_buscar_usu().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = bus.getTable_buscar_usu().rowAtPoint(e.getPoint());
                int colum = bus.getTable_buscar_usu().columnAtPoint(e.getPoint());

                if (bus.getjLbusuarios().getText().equals("Usuarios")) {
                    mode_usu.setIdUsu(Integer.parseInt(bus.getTable_buscar_usu().getValueAt(fila, 0).toString()));
                    if (colum == 9) {
                        bus.setVisible(false);
                        fac.setVisible(true);
                        Object idpro = mode_usu.getIdUsu();
                        fac.getjTxtide_usu().setText(idpro.toString());
                        JOptionPane.showMessageDialog(null, "Usuario Agregado");
                    }
                } else {
                    mod_pro.setIdpro(Integer.parseInt(bus.getTable_buscar_usu().getValueAt(fila, 0).toString()));
                    if (colum == 9) {
                        bus.setVisible(false);
                        fac.setVisible(true);
                        Object idpro = mod_pro.getIdpro();
                        fac.getjTxtid_prove().setText(idpro.toString());
                        JOptionPane.showMessageDialog(null, "Proveedor Agregado");
                    }
                }
            }
        });
        bus.getTxtbuscar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bus.getTxtbuscar().setText("");
                bus.getTxtbuscar().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
    }
    
        public void ver_Factura(int fact) {
        String dato[]= mod_faC.buscarTablaDetalleFactCompra(fact, mostra_de.getTablamostra_detalle_factura());
        mostra_de.getLblfact().setText(String.valueOf(fact));
        mostra_de.getLblprovee().setText(dato[1]);
        mostra_de.getLblusu().setText(dato[2]);
        mostra_de.getLblpagoti().setText(dato[3]);
        mostra_de.getLblcompro().setText(dato[4]);
        mostra_de.getLblfact().setText(dato[7]);
        mostra_de.getLblimpu().setText(dato[5]);
        mostra_de.getLblvalo().setText(dato[6]);
        mostra_de.setLocationRelativeTo(null);
        mostra_de.setVisible(true);
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(deta_fact.getBtnbuscar_prod())) {
            //configuración del boton por codigo
            JButton agregar = new JButton("Añadir");
            agregar.setForeground(new java.awt.Color(0, 153, 153));
            agregar.setFont(new java.awt.Font("Ed sheeran", 1, 18));
            agregar.setBounds(800, 100, 110, 35);
            bus_pro.getjPanelbuscar_produc().add(agregar);
            agregar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mod_faC.agregarDatos(bus_pro.getTablabuscar_produc(), deta_fact.getTabla_detalle());
                    bus_pro.setVisible(false);
                }
            });
            bus_pro.setVisible(true);
            bus_pro.setLocationRelativeTo(null);
            mod_pro.mostrarTablaProveedor(bus_pro.getTablabuscar_produc(), "", "Produ");
//Activar el TXTbuscar producto
            bus_pro.getTxtbuscar_produc().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bus_pro.getTxtbuscar_produc().setText("");
                    bus_pro.getTxtbuscar_produc().setForeground(new java.awt.Color(0, 0, 0));
                }
            });
//boton agregar en la caja de texto el producto             
            bus_pro.getTablabuscar_produc().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int fila = bus_pro.getTablabuscar_produc().rowAtPoint(e.getPoint());

//Activar el boton de agregar producto
                    mod_pro.setIdpro(Integer.parseInt(bus_pro.getTablabuscar_produc().getValueAt(fila, 0).toString()));
                }
            });
        }
        //boton agrgar producto en agregar detalle factura
        if (e.getSource().equals(deta_fact.getBtnagregar())) {
            JTable tabla = deta_fact.getTabla_detalle();
            try {
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    mod_faC.setIdf_com(Integer.parseInt(deta_fact.getLbfactura().getText()));
                    mod_faC.setIdPro(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                    mod_faC.setIdUsu(Integer.parseInt(tabla.getValueAt(i, 3).toString()));
                    mod_faC.setValor(Float.parseFloat(tabla.getValueAt(i, 4).toString()));

                    mod_faC.insertarDetaFactcompra();
                    System.out.println(i);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                deta_fact.dispose();
                JOptionPane.showMessageDialog(null, "Registro Almacenado");
            }
        }
        if (e.getSource().equals(fac.getBtnbuscar_usu())) {
            bus.getjLbusuarios().setText("Usuarios");
            //para producto
            JButton agr = new JButton("Añadir");
            agr.setBounds(826, 20, 110, 23);
            bus.getjPanelusuario().add(agr);
            
            //para producto
            agr.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
//                    mod_faC.agregarDatos(bus.getTxtbuscar(), detall.getpanel );
                    bus.setVisible(false);
                }
            });
            
            fac.setVisible(false);
            bus.setLocationRelativeTo(null);
            mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), "", "Nueva Factura");
            bus.setVisible(true);
            Border borde = BorderFactory.createTitledBorder(null, "Buscar Usuario",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Ed Sheeran", 1, 36),
                    new java.awt.Color(255, 204, 204));
            bus.getjPanelusuario().setBorder(borde);
        }

        if (e.getSource().equals(fac.getBtnbuscar_Proveedor())) {
            bus.getjLbusuarios().setText("Proveedor");
            fac.setVisible(false);
            bus.setLocationRelativeTo(null);
            mod_pro.mostrarTablaProveedor(bus.getTable_buscar_usu(), "", "Nueva Factura");
            bus.setVisible(true);
            Border borde = BorderFactory.createTitledBorder(null, "Buscar Proveedor",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Ed Sheeran", 1, 36),
                    new java.awt.Color(255, 204, 204));
            bus.getjPanelusuario().setBorder(borde);
        }

        if (e.getSource().equals(fac.getjButtGuardarFact())) {
            //validar campo
            if ((fac.getjTxtid_prove().getText().isEmpty())
                    || (fac.getjTxtide_usu().getText().isEmpty()) || (fac.getjTexid_fac().getText().isEmpty() || (fac.getjTxtid_prove().getText().isEmpty()))
                    || (fac.getjCBoxtipo_pago().getSelectedItem().equals("Seleccione..."))) {
                JOptionPane.showMessageDialog(null, "Ingrese información Nombre y Descripción");
            } else {
                mod_faC.setIdf_com(Integer.parseInt(fac.getjTxtid_prove().getText()));
                mod_faC.setIdPro(Integer.parseInt(fac.getjTxtid_prove().getText()));
                mod_faC.setIdUsu(Integer.parseInt(fac.getjTxtide_usu().getText()));
                mod_faC.setTipo_pago(fac.getjCBoxtipo_pago().getSelectedItem().toString());

            }
            if (fac.getjButtGuardarFact().getText().equals("Guardar")) {
                mod_faC.insertarFactcompra();
                mod_faC.limpiar(fac.getjPanelFactura().getComponents());
                fac.setVisible(false);
                fac.dispose();
            } else {
                mod_faC.actualizarFacturaCompra();
                fac.setVisible(false);
                fac.dispose();
                mod_faC.mostrarTablaFactCompra(pri.getTblFactura(), "", "Factura");
            }
        }
//        if (e.getSource().equals(factnuev.getBtncancelarfactcomp())) {
//            factnuev.dispose();
//        }
//////////
       if (e.getSource().equals(ven.getBut_guardarv())){
            bus.getjLbusuarios().setText("Venta");
            ven.setVisible(false);
            bus.setLocationRelativeTo(null);
            mod_ven.mostrarTablaVenta(bus.getTable_buscar_usu(), "", "Nueva Venta");
            bus.setVisible(true);
            Border borde = BorderFactory.createTitledBorder(null, "Buscar Venta",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Ed Sheeran", 1, 36),
                    new java.awt.Color(255, 204, 204));
            bus.getjPanelusuario().setBorder(borde);
       
       }
    }   
//Actualizar factura compra
    void actualizarFactcompra(int doc) {
        mod_faC.buscarFactcompra(doc);
        fac.getjTexid_fac().setText(String.valueOf(mod_faC.getIdf_com()));
        fac.getjTxtid_prove().setText(String.valueOf(mod_faC.getIdPro()));
        fac.getjTxtide_usu().setText(String.valueOf(mod_faC.getIdUsu()));
       

        //Llenar tipo de pago
        fac.getjCBoxtipo_pago().setSelectedItem(mod_faC.getTipo_pago());

        //Cambiar Titulo
        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Factura Compra",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Ed Sheeran", 1, 36),
                new java.awt.Color(255, 204, 204));
        fac.getjPanelFactura().setBorder(borde);
        pri.setVisible(false);
        fac.setLocationRelativeTo(null);
        fac.getjButtGuardarFact().setText("Actualizar");
        fac.setVisible(true);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
         if (bus.getjLbusuarios().getText().equals("Usuario")) {
            mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Factura");
        } else {
            mod_pro.mostrarTablaProveedor(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Factura");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (bus.getjLbusuarios().getText().equals("Usuario")) {
            mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Factura");
        } else {
            mod_pro.mostrarTablaProveedor(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Factura");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (bus.getjLbusuarios().getText().equals("Usuario")) {
            mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Factura");
        } else {
            mod_pro.mostrarTablaProveedor(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Factura");
        }
    }
}
