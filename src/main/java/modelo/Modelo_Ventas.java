/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Conexion;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Modelo_Ventas {
    public int fac, idcli, idusu, comprov, idprodccto, cant,deat, idfac;
    public String ti_pago;
    public float impues, total_falct, descue;
    public Date fecha_d;

    public int getDeat() {
        return deat;
    }

    public int getIdfac() {
        return idfac;
    }

    public void setIdfac(int idfac) {
        this.idfac = idfac;
    }

    public void setDeat(int deat) {
        this.deat = deat;
    }

    public int getIdprodccto() {
        return idprodccto;
    }

    public void setIdprodccto(int idprodccto) {
        this.idprodccto = idprodccto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public float getDescue() {
        return descue;
    }

    public void setDescue(float descue) {
        this.descue = descue;
    }

    
    public int getFac() {
        return fac;
    }

    public int getComprov() {
        return comprov;
    }

    public void setComprov(int comprov) {
        this.comprov = comprov;
    }

    public void setFac(int fac) {
        this.fac = fac;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public int getIdusu() {
        return idusu;
    }

    public void setIdusu(int idusu) {
        this.idusu = idusu;
    }

    public String getTi_pago() {
        return ti_pago;
    }

    public void setTi_pago(String ti_pago) {
        this.ti_pago = ti_pago;
    }

    public float getImpues() {
        return impues;
    }

    public void setImpues(float impues) {
        this.impues = impues;
    }

    public float getTotal_falct() {
        return total_falct;
    }

    public void setTotal_falct(float total_falct) {
        this.total_falct = total_falct;
    }

    public Date getFecha_d() {
        return fecha_d;
    }

    public void setFecha_d(Date fecha_d) {
        this.fecha_d = fecha_d;
    }
    
  
   //insertar venta
    public void insertarVenta() {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();
        String sql = "call into_factura(?,?,?,?,?)";

      try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setInt(1, getFac());
            ps.setInt(2, getIdcli());
            ps.setInt(3, getIdusu());
            ps.setInt(4, getComprov());
            ps.setString(5, getTi_pago());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Guardada");

            co.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerraConexion();
    }  
    //limpiar campos
    public void limpiarVe(Component[] panelventa) {
        for (Object limpiar : panelventa) {
            if (limpiar instanceof JTextField) {
                ((JTextField) limpiar).setText("");
            }
            if (limpiar instanceof JComboBox) {
                ((JComboBox) limpiar).setSelectedItem("Seleccione...");
            }
        }
    }
     public void mostrarTablaVenta(JTable tabla, String valor, String nompeste) {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();

        //Personalizar Encabezado
        JTableHeader encabeza = tabla.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabeza);

        //Personalizar Celdas
        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());

        JButton editar = new JButton();
        JButton agregar_producto = new JButton();
        JButton mostrar_detalle = new JButton();
        JButton imprimir_factuta = new JButton();

//        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png")));
//        agregar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-producto.png")));
//        mostrar_detalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura.png")));
//        imprimir_factuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimir.png")));

        String[] titulo = {"N°Factura", "Cliente", "Empleado", "Fecha de Compra", "Tipo de Pago",
            "Comprobante", "Impuesto", "Total"};
        int opcion = titulo.length;//tiene el tamaño original del titulo

        if (nompeste.equals("Venta")) {
            titulo = Arrays.copyOf(titulo, titulo.length + 4);
            titulo[titulo.length - 4] = "";
            titulo[titulo.length - 3] = "";
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";
        }
        DefaultTableModel tablaFact = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String sqlFactura;
        if (valor.equals("")) {
            sqlFactura = "SELECT * FROM mostrar_factura";
        } else {
            sqlFactura = "call consul_factura('" + valor + "')";
        }
        try {
            String[] dato = new String[titulo.length];
            Statement st = co.createStatement(); //Crea una consulta
            ResultSet rs = st.executeQuery(sqlFactura);
            while (rs.next()) {//Como todos los datos son del mismo tipo se puede hacer el ciclo
                for (int j = 0; j < opcion; j++) {
                    dato[j] = rs.getString(j + 1);
                }
                Object[] fila = {dato[0], dato[1], dato[2], dato[3],dato[4], dato[5], dato[6], dato[7]};
                if (nompeste.equals("Venta")) {
                    fila = Arrays.copyOf(fila, fila.length + 4);
                    fila[fila.length - 4] = editar;
                    fila[fila.length - 3] = agregar_producto;
                    fila[fila.length - 2] = mostrar_detalle;
                    fila[fila.length - 1] = imprimir_factuta;
                }
                tablaFact.addRow(fila);
            }
            co.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(tablaFact);
        //Darle Tamaño a cada Columna
        int cantColum = tabla.getColumnCount();
        int[] ancho = {100, 180, 100, 150, 100, 160, 100, 100, 30, 30, 30, 30};
        for (int j = 0; j < cantColum; j++) {
            TableColumn columna = tabla.getColumnModel().getColumn(j);
            columna.setPreferredWidth(ancho[j]);
        }
      conect.cerraConexion();
    }
     
    public boolean seleccionCheck(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Boolean seleccionar = (Boolean) tabla.getValueAt(i, 6);
            if (seleccionar != null && seleccionar) {
                Object can = tabla.getValueAt(i, 4);
                Object val = tabla.getValueAt(i, 5);
                if ((can == null || !can.toString().equals("0"))
                        && (val == null || !val.toString().equals("0"))) //para validar que alla informacion en los campos 
                {
                    return true;
                }
            }
        }
        return false;
    }
    
       public void agregarProductos(JTable tablaProduc, JTable tablaDetalle) {
        //Personalizar Encabezado
        JTableHeader encabeza = tablaDetalle.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tablaDetalle.setTableHeader(encabeza);
        //Personalizar Celdas
        tablaDetalle.setDefaultRenderer(Object.class, new Gestion_Celdas());

        Object[] titulo = {"Código", "Producto", "Decripción", "Cantidad", "Precio"};

        DefaultTableModel tabla_addProductos = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        };

        if (seleccionCheck(tablaProduc)) {
            for (int i = 0; i < tablaProduc.getRowCount(); i++) {
                Boolean seleccionar = (Boolean) tablaProduc.getValueAt(i, 6);
                if (seleccionar != null && seleccionar) {
                    Object dato[] = new Object[titulo.length];
                    dato[0] = tablaProduc.getValueAt(i, 0);
                    dato[1] = tablaProduc.getValueAt(i, 2);
                    dato[2] = tablaProduc.getValueAt(i, 3);
                    dato[3] = tablaProduc.getValueAt(i, 4);
                    dato[4] = tablaProduc.getValueAt(i, 5);
                    Object fila[] = {dato[0], dato[1], dato[2], dato[3], dato[4]};
                    tabla_addProductos.addRow(fila);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un producto y agregar la cantidad y el valor");
        }
        tablaDetalle.setModel(tabla_addProductos);
    }
    
       //insertar detalle factura  

    public void insertarDetalleFact() {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();
        String sql = "call inst_detalle_factura(?, ?, ?, ?)";

        try {
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setInt(1, getFac());
            ps.setInt(2, getIdfac());
            ps.setInt(3, getCant());
            ps.setFloat(4,  getDescue());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Guardada");

            co.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerraConexion();
       
    }
     
    
//TABLA DE VER
    public String[] buscarTablaDetalleFact(int valor, JTable tabla) {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();

        //Personalizar Encabezado
        JTableHeader encabeza = tabla.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabeza);

        //Personalizar Celdas
        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());

        String[] titulo = {"Código", "Producto", "Descripción", "Cantidad",
            "Descuento", "Total"};
        int opcion = titulo.length;//tiene el tamaño original del titulo

        DefaultTableModel tabladetalleFactcompr = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {

                String sql = "call detalle_factura_mostrar(" + valor + ")";
                String[] dato = null;

                return false;
            }
        };

        String sql = "call detalle_factura_mostrar(" + valor + ")";
        String[] dato = null;

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int total = rs.getMetaData().getColumnCount(); //Conocer el total de columnas de un registro de la base de datos
            dato = new String[total];
            while (rs.next()) {//Como todos los datos son del mismo tipo se puede hacer el ciclo
                for (int i = 0; i < total; i++) {
                    dato[i] = rs.getString(i + 1);
                }
                Object[] fila = {dato[8], dato[9], dato[10], dato[11], dato[12], dato[13]};

                tabladetalleFactcompr.addRow(fila);
            }
            co.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(tabladetalleFactcompr);
        //Darle Tamaño a cada Columna
        int cantColum = tabla.getColumnCount();
        int[] ancho = {10, 30, 70, 6, 30, 50};
        for (int i = 0; i < cantColum; i++) {
            TableColumn columna = tabla.getColumnModel().getColumn(i);
            columna.setPreferredWidth(ancho[i]);
        }
        conect.cerraConexion();
        return dato;
    }
     
    public void buscarVenta(int valor) {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();
        String sql = "call buscar_factura(" + valor + ")";

        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                setFac(rs.getInt(1));
                setFecha_d(rs.getDate(2));
                setIdcli(rs.getInt(3));
                setIdusu(rs.getInt(4));
                setComprov(rs.getInt(5));
                setTi_pago(rs.getString(6));
                setImpues(rs.getInt(7));
                setTotal_falct(rs.getFloat(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     //Para que al actualizar me muestre el dato que selecciono el usuario
    public String obtenerSeleccion(Map<String, Integer> info, int valor) {
        for (Map.Entry<String, Integer> seleccion : info.entrySet()) {
            if (seleccion.getValue() == valor) {
                return seleccion.getKey();
            }
        }
        return null;
    }
    
    //Actualizar factura 
    public void actualizarVenta() {
        Conexion conect = new Conexion();
        Connection con = conect.iniciarConexion();
        String sql = "call actualizar_factura(?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getFac());
            ps.setInt(2, getIdcli());
            ps.setInt(3, getIdusu());
            ps.setString(4, getTi_pago());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Información Actualizada");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conect.cerraConexion();
    }
}

