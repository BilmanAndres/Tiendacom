
//esta
package controlador;
//8b
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.io.File;
//import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import javax.swing.event.c;
import modelo.Modelo_Cliente;
import modelo.Modelo_Factura_Compra;
import modelo.Modelo_Proveedor;
import modelo.Modelo_Usuario;
import modelo.Modelo_Ventas;
import modelo.Modelo_producto;
import vista.Clientes;
import vista.Factura;
import vista.Mostra_Detalle_Factura_Compr;
import vista.Principal;
import vista.Producto;
import vista.Proveedores;
import vista.Usuarios;
import vista.Venta;

public class Controlador_Principal implements ActionListener, ChangeListener,DocumentListener {

    Principal pri = new Principal();
    Usuarios usu = new Usuarios();
    Modelo_Usuario mode_usu = new Modelo_Usuario();
    Controlador_Usuario con_usu = new Controlador_Usuario();
    Modelo_Cliente mode_cli = new Modelo_Cliente();
    
    

    

    ///
    Clientes cli = new Clientes();
    Controlador_Cliente contr_cli = new Controlador_Cliente();
    ///
    Proveedores pro = new Proveedores();
    Controlador_Provedor con_pro = new Controlador_Provedor();
    
    Modelo_Proveedor mod_pro = new Modelo_Proveedor();
    
     Factura fac = new Factura();
     Controlador_Factura_Compr con_fac_com = new Controlador_Factura_Compr();
     Modelo_Factura_Compra mod_fac_com = new Modelo_Factura_Compra();
    ///
    Producto prod = new Producto();
    Controlador_Producto con_prod  = new Controlador_Producto();
    
    Modelo_producto mode_prod = new Modelo_producto();
    
    ///
    Venta ven = new Venta();
    Modelo_Ventas mod_ven = new Modelo_Ventas();
    Controlador_Venta con_ven = new Controlador_Venta();
    
    Mostra_Detalle_Factura_Compr mos_detalle_fac =new  Mostra_Detalle_Factura_Compr();

    //jButtonuevo_cliente
    public Controlador_Principal() {
        pri.getjButon_produc().addActionListener(this);
        
        
        pri.getjButtonNuevo().addActionListener(this);
        pri.getjButtonuevo2().addActionListener(this);
        pri.getjButtonNuevo1().addActionListener(this);
        pri.getJtPrincipal().addChangeListener(this);
        
        pri.getTextbuscar_usu().addActionListener(this);
        pri.getJtPrincipal().addChangeListener(this);
        
        
        
        pri.getTextbuscar_usu().getDocument().addDocumentListener(this);
        pri.getTextbuscar_clie().getDocument().addDocumentListener(this);
      // pri.getTextbuscar_usu().getDocument().addDocumentListener(this);
        
        pri.getjTexbuscar_factura().getDocument().addDocumentListener(this);
        
        //pri.getgetjTabbedPane1().addActionMouseAdapter( this);
        
        usu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        prod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        pri.getjButon_produc().addActionListener(this);
        
        prod.getjBtnguardar_prod().addActionListener(this);
        
        prod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //
        pri.getjBtFactura().addActionListener(this);
        fac.getjButtGuardarFact().addActionListener(this);
        fac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //
        pri.getBtnenueva_venta().addActionListener(this);
        pri.getTxtbuscar_venta().getDocument().addDocumentListener(this);//1
        ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

////jButtonuevo_cliente
    public void vista() {
        pri.setLocationRelativeTo(null);// creando la vista
        pri.setTitle("Iniciar Sesion");
        pri.setVisible(true);// VER LA VISTA
        gesti_pesta();
        //
        // cli.setLocationRelativeTo(null);// 
        //cli.setTitle("Iniciar Clientes");
        //cli.setVisible(true);

    }
    public void iniciarPrincipal(int valor) {
        pri.setLocationRelativeTo(null);//Centra la ventana
        pri.setTitle("Principal");//Le da titulo a la ventana
        pri.setExtendedState(JFrame.MAXIMIZED_BOTH);//Maximiza la ventana
        pri.getJtPrincipal().setSelectedIndex(valor);//getTpPrincipal().setSelectedIndex(valor);
        pri.setVisible(true);//Se visualiza la ventana
        gestionUsuario();//llamo al metodo de Gestion usuario
        pri.getJtPrincipal().setSelectedIndex(valor);
    }
    
   public void gesti_pesta(){
      //if(pri.getjTabbedPane1().getSelectedIndex()== 0){
       
       //}ChangeEventChangeEvent
   }
     public void gestionUsuario() {
        mode_usu.mostraTablaUsu(pri.getTable_usuario(), "", "Usuario");
        pri.getTextbuscar_usu().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pri. getTextbuscar_usu().setText("");
                pri.getTextbuscar_usu().setForeground(Color.BLUE);
            }
        });
        //Para darle clic al boton de editar
        pri.getTable_usuario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                 pri. getTextbuscar_usu().setText("");
//                 pri.getTextbuscar_usu().setForeground(Color.BLUE);
                int fila = pri.getTable_usuario().rowAtPoint(e.getPoint());
                int colum = pri.getTable_usuario().columnAtPoint(e.getPoint());
                mode_usu.setIdUsu(Integer.parseInt(pri.getTable_usuario().getValueAt(fila, 0).toString()));
      

                if (colum == 9) {
                    pri.setVisible(false);
                    pri.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    con_usu.actulizarUsuario(mode_usu.getIdUsu());
                }
                if (colum == 10) {
                    con_usu.eliminarUsuario(mode_usu.getIdUsu());
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    mode_usu.mostraTablaUsu(pri.getTable_usuario(), "", "Usuario");
                    
                    
                    
                    con_usu.eliminarUsuario(mode_usu.getIdUsu());
                    mode_usu.mostraTablaUsu(pri.getTable_usuario(), "", "Usuario");
                }
            }
        });
    }
 
    public void gestionCliente() {
        mode_cli.mostrarTablaCliente(pri.getTable_client(), "", "Cliente");
        
        pri.getTextbuscar_clie().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pri.getTextbuscar_clie().setText("");
                pri.getTextbuscar_clie().setForeground(Color.red);
            }
        });
       
        pri.getTable_client().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = pri.getTable_client().rowAtPoint(e.getPoint());
                int colum = pri.getTable_client().columnAtPoint(e.getPoint());
                mode_cli.setIdClien(Integer.parseInt(pri.getTable_client().getValueAt(fila, 0).toString()));
                

                if (colum == 6) {
                    pri.setVisible(false);
                    pri.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    contr_cli.actulizarClien(mode_cli.getIdClien());
        
                }
                if (colum == 7) {
                    contr_cli.eliminarCliente(mode_cli.getIdClien());
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    mode_cli.mostrarTablaCliente(pri.getTable_client(), " ", "Cliente");
                   contr_cli.eliminarCliente(mode_cli.getIdClien());
                   mode_cli.mostrarTablaCliente(pri.getTable_client(), " ", "Cliente");
                   
                }
            }
        });
   
    }

    public void gestionProveedor() {
        mod_pro.mostrarTablaProveedor(pri.getTable_provee(), "", "Provedores");

        pri.getjTextbuscar_provvee().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pri.getjTextbuscar_provvee().setText("");
                pri.getjTextbuscar_provvee().setForeground(Color.red);
            }
        });

        pri.getTable_provee().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = pri.getTable_provee().rowAtPoint(e.getPoint());
                int colum = pri.getTable_provee().columnAtPoint(e.getPoint());
              

                //mode_cli.setIdClien(Integer.parseInt(pri.getTable_provee().getValueAt(fila, 0).toString()));

                if (colum == 9) {
                    pri.setVisible(false);
                    pri.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    con_pro.actulizarProeedor(colum);
                    
                } 
                
                if (colum == 10) {
                    
                    con_pro.eliminarProvedor(mod_pro.getIdpro());
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    mod_pro.mostrarTablaProveedor(pri.getTable_provee(), "", "Provedores");
                
              
                }
              
            }
        });
    }
    public void gestionProducto() {
        mode_prod.mostrarTablaProducto(pri.getjTableProducto(), "", "Producto");
       

        pri.getBuscar().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pri.getBuscar().setText("");
                pri.getBuscar().setForeground(Color.red);
            }
        });

        pri.getjTableProducto().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = pri.getjTableProducto().rowAtPoint(e.getPoint());
                int colum = pri.getjTableProducto().columnAtPoint(e.getPoint());
                mode_prod.setIdpr(Integer.parseInt(pri.getjTableProducto().getValueAt(fila, 0).toString()));
                
                
//                mode_cli.setIdClien(Integer.parseInt(pri.getjTableProducto().getValueAt(fila, 0).toString()));

                if (colum == 6) {
                    pri.setVisible(false);
                    pri.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    con_prod.actualizarProducto(mode_prod.getIdpr());
                    
                    
                } 
                
                if (colum == 7) {
                    con_prod.eliminarProducto(mode_prod.getIdpr());
                    mode_prod.mostrarTablaProducto(pri.getjTableProducto(), "", "Provedores");
                    
//                    con_prod
//                    con_prod
//                    con_pro.eliminarProvedor(mod_pro.getIdpro());
//                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    
//                    mod_pro.mostrarTablaProveedor(pri.getTable_provee(), "", "Provedores");
                
              
                }
              
            }
        });
    }
        
  

    public void gestionFacturacompra() {
       mod_fac_com.mostrarTablaFactCompra(pri.getTblFactura(), "", "Factura");
    
        pri.getjTexbuscar_factura().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pri.getjTexbuscar_factura().setText("");
                pri.getjTexbuscar_factura().setForeground(Color.red);
//                pri.getjTexbuscar_factura().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
        
        pri.getTblFactura().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = pri.getTblFactura().rowAtPoint(e.getPoint());
                int colum = pri.getTblFactura().columnAtPoint(e.getPoint());
                mod_fac_com.setIdf_com(Integer.parseInt(pri.getTblFactura().getValueAt(fila, 0).toString()));
                
                   if (colum == 8) {
                    pri.setVisible(false);
                    con_fac_com.actualizarFactcompra(mod_fac_com.getIdf_com());
                    con_fac_com.buscarFactura();
                    }
                     if (colum == 9) {
                    pri.setVisible(false);
                    con_fac_com.agregarDetalle(mod_fac_com.getIdf_com());
                    
                         }
                     
                     if (colum == 10) {
                    pri.setVisible(false);
                    mos_detalle_fac.setVisible(true);
                    mos_detalle_fac.setLocationRelativeTo(null);
                    
                     if (colum == 11) {
                    pri.setVisible(false);
                    }
                    
//                    con_fac_com.mod_fac_com.mostrarTablaDetalleFactCompra(mostradetalle.getJTablaMostrarDetalleFactura(), "", "Mostrarfact");
//                    //Activar el txt de la vista mostrar detalle
//                    mostradetalle.getTxtbuscardetalle().addMouseListener(new MouseAdapter() {
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            mostradetalle.getTxtbuscardetalle().setText("");
//                            mostradetalle.getTxtbuscardetalle().setForeground(new java.awt.Color(0, 0, 0));
//                        }
//                    });
                }
//
//                if (colum == 7) {
//                    pri.setVisible(false);
//                    pri.setExtendedState(JFrame.MAXIMIZED_BOTH);
//                    con_fac_com.actualizarFactcompra(mod_fac_com.getIdf_com());
//                    con_fac_com.buscarFactura();
//                    
//                }
            }
        });

    }

    public void gestionVenta() {
         mod_ven.mostrarTablaVenta(pri.getTabla_venta(), "", "Venta");
        pri.getTxtbuscar_venta().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pri.getTxtbuscar_venta().setText("");
                pri.getTxtbuscar_venta().setForeground(new java.awt.Color(0, 0, 0));
            }
        });
        //Para darle clic al boton de editar
        pri.getTabla_venta().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = pri.getTabla_venta().rowAtPoint(e.getPoint());
                int colum = pri.getTabla_venta().columnAtPoint(e.getPoint());
                mod_ven.setFac(Integer.parseInt(pri.getTabla_venta().getValueAt(fila, 0).toString()));

                if (colum == 8) {
                    pri.setVisible(false);
                    pri.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    con_ven.actualizarVenta(mod_ven.getFac());
                }
                if (colum == 9) {
                    pri.setVisible(false);
                    con_ven.agregarDetalle(mod_ven.getFac());
                }
                if (colum == 10) {
                    pri.setVisible(false);
                    con_ven.ver_FacturaVenta(mod_ven.getFac());
                }
                if (colum == 11) {
                    pri.setVisible(false);
                }
                
                
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent y) {

        if (y.getSource().equals(pri.getjButton_usu())) {
            pri.setVisible(false);
            con_usu.controUsuario();
            
        }
        if (y.getSource().equals(pri.getjButtonuevo_cli())) {
             pri.setVisible(false);
             contr_cli.Contr_clien();
           // contr_cli.controCliente();
        }
        if (y.getSource().equals(pri.getjButtonNuevo1())) {
             pri.setVisible(false);
             con_pro.iniciarProveedor();
//            con_pro.controCliente();
        }
        
//        if(y.getSource().equals(pri.getjButon_produc())){
//            pri.setVisible(false);
//           con_prod.controlPruducto();    
//           
//        }
        if(y.getSource().equals(pri.getjButon_produc())){
            prod.setVisible(false);
            con_prod.iniciarProducto();
             
        }
        if (y.getSource().equals(pri.getjBtFactura())){
            fac.setVisible(false);
            con_fac_com.controlFacturaCompra(); 
        }
        
        if (y.getSource().equals(pri.getBtnenueva_venta())){
            ven.setVisible(false);
            con_ven.controlVenta();
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccionar = pri.getjTabbedPane1().getSelectedIndex();
        System.out.println(" usted seleccion" + seleccionar);
        if (seleccionar == 0) {
            gestionUsuario();
        }
        if (seleccionar == 3) {
            gestionCliente();
        }
        if (seleccionar == 1) {
            gestionProveedor();
        }
        if (seleccionar == 2) {
            gestionProducto();
        }
        if (seleccionar == 4) {
            gestionFacturacompra();
        }
        if (seleccionar == 5) {
            gestionVenta();
        }
    }     

    @Override
    public void insertUpdate(DocumentEvent e) {
        mode_usu.mostraTablaUsu(pri.getTable_usuario(), pri.getTextbuscar_usu().getText(), "Usuario");
        mode_cli.mostrarTablaCliente(pri.getTable_client(), pri.getTextbuscar_clie().getText(), "Cliente");
        mod_pro.mostrarTablaProveedor(pri.getjTableProducto(), pri.getjTextbuscar_provvee().getText(), "Provedores");
        mod_fac_com.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Factura");
        mode_prod.mostrarTablaProducto(pri.getjTableProducto(), pri.getBuscar().getText(), "Producto");
        mod_ven.mostrarTablaVenta(pri.getTabla_venta(), pri.getTxtbuscar_venta().getText(), "Venta");

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
         mode_usu.mostraTablaUsu(pri.getTable_usuario(), pri.getTextbuscar_usu().getText(), "Usuario");
         mode_cli.mostrarTablaCliente(pri.getTable_client(), pri.getTextbuscar_clie().getText(), "Cliente");
         mod_pro.mostrarTablaProveedor(pri.getjTableProducto(), pri.getjTextbuscar_provvee().getText(), "Provedores");
         mod_fac_com.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Factura");
         mode_prod.mostrarTablaProducto(pri.getjTableProducto(), pri.getBuscar().getText(), "Producto");
         mod_ven.mostrarTablaVenta(pri.getTabla_venta(), pri.getTxtbuscar_venta().getText(), "Venta");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        mode_usu.mostraTablaUsu(pri.getTable_usuario(), pri.getTextbuscar_usu().getText(), "Usuario");
        mode_cli.mostrarTablaCliente(pri.getTable_client(), pri.getTextbuscar_clie().getText(), "Cliente");
        mod_pro.mostrarTablaProveedor(pri.getjTableProducto(), pri.getjTextbuscar_provvee().getText(), "Provedores");
        mod_fac_com.mostrarTablaFactCompra(pri.getTblFactura(), pri.getjTexbuscar_factura().getText(), "Factura");
        mode_prod.mostrarTablaProducto(pri.getjTableProducto(), pri.getBuscar().getText(), "Producto");
        mod_ven.mostrarTablaVenta(pri.getTabla_venta(), pri.getTxtbuscar_venta().getText(), "Venta");
    }
}



