/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import modelo.Modelo_Cliente;
import modelo.Modelo_Usuario;
import modelo.Modelo_Ventas;
import modelo.Modelo_producto;
import vista.Agregar_Detalle_Factura;
import vista.Buscar;
import vista.Buscar_Cliente;
import vista.Buscar_Producto;
import vista.Factura;
//import vista.Mostra_Detalle_Factura_Compr;
import vista.Mostrar_Detalle_Factura_Compra;
import vista.Principal;
import vista.Venta;


public class Controlador_Venta implements ActionListener, DocumentListener {
    Venta ven = new Venta();
    Principal pri = new Principal();
    Buscar bus = new Buscar();
    Buscar_Cliente bus_cli = new Buscar_Cliente();
    Modelo_Usuario mode_usu = new Modelo_Usuario();
    Modelo_Cliente mode_cli = new Modelo_Cliente();
    Modelo_Ventas mod_ven = new Modelo_Ventas();
    
    Agregar_Detalle_Factura deta_fact = new Agregar_Detalle_Factura ();

    Factura fac = new Factura();
    
    Buscar_Producto bus_pro = new Buscar_Producto();

    Mostrar_Detalle_Factura_Compra mostra_ven = new Mostrar_Detalle_Factura_Compra();

    Modelo_producto mode_prod = new Modelo_producto();
    public Controlador_Venta() {
        ven.getBut_guardarv().addActionListener(this);
        ven.getBtnidcli().addActionListener(this);
        ven.getBtnidusu().addActionListener(this);
        bus.getTxtbuscar().getDocument().addDocumentListener(this);
        bus_cli.getTxtTable_busCli().getDocument().addDocumentListener(this);
        ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mostra_ven.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ven.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Controlador_Principal pri = new Controlador_Principal();
                pri.iniciarPrincipal(5);
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
        mostra_ven.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                fac.dispose();
            }
        });
    }
    
    
    public void agregarDetalle(int fac) {
        deta_fact.setVisible(true);
        deta_fact.setLocationRelativeTo(null);
        deta_fact.setTitle("Agregar Detalle");
        deta_fact.getLbfactura().setText(String.valueOf(fac));
    }
 
    public void controlVenta() {
        pri.setVisible(false);
        ven.setLocationRelativeTo(null);
        ven.setTitle("Nueva Venta");
        ven.setVisible(true);
    }
    public void ver_FacturaVenta(int fact) {
        String dato[] = mod_ven.buscarTablaDetalleFact(fact, mostra_ven.getJtablavent());
        mostra_ven.getLblfact().setText(String.valueOf(fact));
        mostra_ven.getLblclient().setText(dato[1]);
        mostra_ven.getLblusua().setText(dato[2]);
        mostra_ven.getLblpagotip().setText(dato[3]);
        mostra_ven.getLblcompro().setText(dato[4]);
        mostra_ven.getLblimpues().setText(dato[5]);
        mostra_ven.getLblvalo().setText(dato[6]);
        mostra_ven.getLblfech().setText(dato[7]);
        mostra_ven.setLocationRelativeTo(null);
        mostra_ven.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource().equals(deta_fact.getBtnbuscar_prod())) {
            //configuración del boton por codigo
            JButton agregar = new JButton("Añadir");
            agregar.setForeground(new java.awt.Color(0, 153, 153));
            agregar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18));
            agregar.setBounds(800, 100, 110, 35);
            bus_pro.getjPanelbuscar_produc().add(agregar);
            agregar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mod_ven.agregarProductos(bus_pro.getTablabuscar_produc(), deta_fact.getTabla_detalle());
                    bus_pro.setVisible(false);
                }
            });
            bus_pro.setVisible(true);
            bus_pro.setLocationRelativeTo(null);
            mode_prod.mostrarTablaProducto(bus_pro.getTablabuscar_produc(), "", "Produ");
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
                    mode_prod.setIdpr(Integer.parseInt(bus_pro.getTablabuscar_produc().getValueAt(fila, 0).toString()));
                }
            });
        }
        //boton agrgar producto en agregar detalle factura
        if (e.getSource().equals(deta_fact.getBtnagregar())) {
            JTable tabla = deta_fact.getTabla_detalle();
            try {
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    mod_ven.setFac(Integer.parseInt(deta_fact.getLbfactura().getText()));
                    mod_ven.setIdprodccto(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                    mod_ven.setCant(Integer.parseInt(tabla.getValueAt(i, 3).toString()));
                    mod_ven.setDescue(Float.parseFloat(tabla.getValueAt(i, 4).toString()));
                    mod_ven.insertarDetalleFact();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                deta_fact.dispose();
                JOptionPane.showMessageDialog(null, "Registro Almacenado");
            }
        }
        if (e.getSource().equals(ven.getBtnidcli())) {
            ven.setVisible(false);
            bus_cli.setLocationRelativeTo(null);
            mode_cli.mostrarTablaCliente(bus_cli.getTable_buscar_cli(), "", "Factura Venta");
            bus_cli.setVisible(true);
            //Activar el TXTbuscar cliente
            bus_cli.getTxtTable_busCli().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bus_cli.getTxtTable_busCli().setText("");
                    bus_cli.setForeground(new java.awt.Color(0, 0, 0));
                }
            });
            //boton agregar en la caja de texto el cliente             
            bus_cli.getTable_buscar_cli().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int fila = bus_cli.getTable_buscar_cli().rowAtPoint(e.getPoint());
                    int colum = bus_cli.getTable_buscar_cli().columnAtPoint(e.getPoint());

//Activar el boton de agregar cliente
                    mode_cli.setIdClien(Integer.parseInt(bus_cli.getTable_buscar_cli().getValueAt(fila, 0).toString()));
                    if (colum == 8) {
                        bus_cli.setVisible(false);
                        ven.setVisible(true);
                        Object idcliente = mode_cli.getIdClien();
                        ven.getTxtclienv().setText(idcliente.toString());
                        JOptionPane.showMessageDialog(null, "Cliente Agregado");
                    }
                }
            });
        }
        if (e.getSource().equals(ven.getBtnidusu())) {
            ven.setVisible(false);
            bus.setLocationRelativeTo(null);
            mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), "", "Factura Venta");
            bus.setVisible(true);
            Border borde = BorderFactory.createTitledBorder(null, "Buscar Usuario",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                    new java.awt.Font("Yu Gothic UI", 1, 36),
                    new java.awt.Color(204, 0, 204));
            bus.getjPanelusuario().setBorder(borde);
//            //Activar el TXTbuscar cliente
            bus.getTxtbuscar().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bus.getTxtbuscar().setText("");
                    bus.getTxtbuscar().setForeground(new java.awt.Color(0, 0, 0));
                }
            });
//            //boton agregar en la caja de texto el usuario            
            bus.getTable_buscar_usu().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int fila = bus.getTable_buscar_usu().rowAtPoint(e.getPoint());
                    int colum = bus.getTable_buscar_usu().columnAtPoint(e.getPoint());

////Activar el boton de agregar usuario
                    mode_usu.setIdUsu(Integer.parseInt(bus.getTable_buscar_usu().getValueAt(fila, 0).toString()));
                    if (colum == 9) {
                        bus.setVisible(false);
                        ven.setVisible(true);
                        Object idusuario = mode_usu.getIdUsu();
                        ven.getTxtidusuv().setText(idusuario.toString());
                        JOptionPane.showMessageDialog(null, "Usuario Agregado");
                    }
                }
            });
        }
        if (e.getSource().equals(ven.getBut_guardarv())) {
//            //validar campos vacios
            if ((ven.getTxtidventa().getText().isEmpty() || (ven.getTxtclienv().getText().isEmpty()
                    || (ven.getTxtidusuv().getText().isEmpty() || (ven.getTxtcomprov().getText().isEmpty()
                    || (ven.getCombtipov().getSelectedItem().equals("Seleccione..."))))))) {
                JOptionPane.showMessageDialog(null, "Debe ingresar información en los campos de Nombre y Descripción");

            } else {
                mod_ven.setFac(Integer.parseInt(ven.getTxtidventa().getText()));
                mod_ven.setIdcli(Integer.parseInt(ven.getTxtclienv().getText()));
                mod_ven.setIdusu(Integer.parseInt(ven.getTxtidusuv().getText()));
                mod_ven.setComprov(Integer.parseInt(ven.getTxtcomprov().getText()));
                mod_ven.setTi_pago(ven.getCombtipov().getSelectedItem().toString());

                if (ven.getBut_guardarv().getText().equals("Guardar")) {
                    mod_ven.insertarVenta();
                    mod_ven.limpiarVe(ven.getPanelventa().getComponents());
                    ven.setVisible(false);
                    ven.dispose();
                } else {
                    mod_ven.actualizarVenta();
                    ven.setVisible(false);
                    ven.dispose();
                    mod_ven.mostrarTablaVenta(pri.getTblFactura(), "", "Factura");
                }
//            }
            }
//
//        if (e.getSource().equals(factventa.getBtncancelarventa())) {
//            factventa.dispose();
//        }
        }
    }
    
    void actualizarVenta(int doc) {
        mod_ven.buscarVenta(doc);
        ven.getTxtcomprov().setEnabled(false);
        ven.getTxtclienv().setEnabled(false);
        ven.getTxtclienv().setText(String.valueOf(mod_ven.getIdcli()));
        ven.getTxtidusuv().setText(String.valueOf(mod_ven.getIdusu()));
       

        //Llenar tipo de pago
        ven.getCombtipov().setSelectedItem(mod_ven.getTi_pago());

        //Cambiar Titulo
        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Venta",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Yu Gothic UI", 1, 36),
                new java.awt.Color(204, 0, 204));
        ven.getPanelventa().setBorder(borde);
        pri.setVisible(false);
        ven.setLocationRelativeTo(null);
        ven.getBut_guardarv().setText("Actualizar");
        ven.setVisible(true);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        mode_cli.mostrarTablaCliente(bus_cli.getTable_buscar_cli(), bus_cli.getTxtTable_busCli().getText(), "Nueva Venta");
        mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Venta");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        mode_cli.mostrarTablaCliente(bus_cli.getTable_buscar_cli(), bus_cli.getTxtTable_busCli().getText(), "Nueva Venta");
        mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Venta");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        mode_cli.mostrarTablaCliente(bus_cli.getTable_buscar_cli(), bus_cli.getTxtTable_busCli().getText(), "Nueva Venta");
        mode_usu.mostraTablaUsu(bus.getTable_buscar_usu(), bus.getTxtbuscar().getText(), "Nueva Venta");
    }
    
}
