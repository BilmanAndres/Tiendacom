
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

public class Modelo_Factura_Compra  {
    public int idf_com, idPro, idUsu, descu, compr;
    public float tipo_de_pago,total_compra, valor;
    public String tipo_pago;
    public Date fech ;
    
    ///

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    

    public int getIdf_com() {
        return idf_com;
    }

    public void setIdf_com(int idf_com) {
        this.idf_com = idf_com;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Date getFech() {
        return fech;
    }

    public void setFech(Date fech) {
        this.fech = fech;
    }
    
 //insertar factura compra
    public void insertarFactcompra() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call inst_factura_compra(?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdf_com());
            ps.setInt(2, getIdPro());
            ps.setInt(3, getIdUsu());
            ps.setString(4, getTipo_pago());
            ps.setDate(5, getFech());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Guardada");
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerraConexion();
    }   
    public void limpiar(Component[] panelfactcompra) {
        for (Object limpiar : panelfactcompra) {
            if (limpiar instanceof JTextField) {
                ((JTextField) limpiar).setText("");
            }
            if (limpiar instanceof JComboBox) {
                ((JComboBox) limpiar).setSelectedItem("Seleccione...");
            }
        }
    }
    
    public void mostrarTablaFactCompra(JTable tabla, String valor, String nompeste) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        
        //Personalizar Encabezado
        JTableHeader encabeza = tabla.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabeza);

        //Personalizar Celdas
        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());
        JButton editar = new JButton();
        JButton agregar_producto = new JButton("Actulalizar");
        JButton mostrar_detalle = new JButton();
        JButton imprimir_factuta = new JButton();
        
        String[] titulo = {"ID Factura Compra", "Nombre Proveedor", "Nombre Usuario", "Fecha_Factura",
            "Total_Compra",  "tipo_de_pago"};
        int total = titulo.length;//tiene el tamaño original del titulo
        
        if (nompeste.equals("Factura")) {
            titulo = Arrays.copyOf(titulo, titulo.length + 4);
            titulo[titulo.length - 4] = "";
            titulo[titulo.length - 3] = "";
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";
        }
        DefaultTableModel tablaFactCompr = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String sqlFactura;
        if (valor.equals("")) {
            sqlFactura = "SELECT * FROM mostrar_fact_com";
        }else {
            sqlFactura = "call consul_fact_com('" + valor + "')";
        }
        
        try {
            String[] dato = new String[titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlFactura);
            while (rs.next()) {//Como todos los datos son del mismo tipo se puede hacer el ciclo
                for (int j = 0; j < total; j++) {
                    dato[j] = rs.getString(j + 1);
                }
                Object[] fila = {dato[0], dato[1], dato[2], dato[3], dato[4], dato[5]};
                if (nompeste.equals("Factura")) {
                    fila = Arrays.copyOf(fila, fila.length + 4);
                    fila[fila.length - 4] = editar;
                    fila[fila.length - 3] = agregar_producto;
                    fila[fila.length - 2] = mostrar_detalle;
                    fila[fila.length - 1] = imprimir_factuta;
                }
                tablaFactCompr.addRow(fila);
            }
            cn.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(tablaFactCompr);
        //Darle Tamaño a cada Columna
        int cantColum = tabla.getColumnCount();
        int[] ancho = {100, 180, 100, 150, 100, 160, 30, 30, 30, 30};
        for (int j = 0; j < cantColum; j++) {
            TableColumn columna = tabla.getColumnModel().getColumn(j);
            columna.setPreferredWidth(ancho[j]);
            
        }
        conect.cerraConexion();
    }
    
     public void buscarFactcompra(int valor) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call buscar_fact_com(" + valor + ")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                
                setIdf_com(rs.getInt(1));
                setIdPro(rs.getInt(2));
                setIdUsu(rs.getInt(3));
                setTipo_pago(rs.getString(4));
                setFech(rs.getDate(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public String obtenerSeleccion(Map<String, Integer> info, int valor) {
        for (Map.Entry<String, Integer> seleccion : info.entrySet()) {
            if (seleccion.getValue() == valor) {
                return seleccion.getKey();
            }
        }
        return null;
    }
    public void actualizarFacturaCompra(){
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        
        String sql = "call actu_fact_com";
        try{
         PreparedStatement ps = cn.prepareStatement(sql);
         ps.setInt(1, getIdf_com());
         ps.setInt(2, getIdPro());
         ps.setInt(3, getIdUsu());
         ps.setString(4, getTipo_pago());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean seleciono (JTable tabla){
        int c = tabla.getColumnCount() -1 ;
        for(int j = 0; j < tabla.getRowCount(); j++){
            Boolean selc = (Boolean)tabla.getValueAt(j, c);
            if(selc != null && selc){
                return true;
            }
        }
        return false;
    }
    public void agregarDatos (JTable tablaProd, JTable tableDTable){
        
        JTableHeader encabeza = tableDTable.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tableDTable.setTableHeader(encabeza);
        tableDTable.setDefaultRenderer(Object.class, new Gestion_Celdas());

        Object [] titulo = {"Código", "Producto", "Decripción", "Cantidad","Precio"};
        
         DefaultTableModel tabla_ddProducto = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column==3 || column == 4;
            }
        };
        if (seleciono(tablaProd)){
            for(int j = 0; j < tablaProd.getRowCount(); j++){
            int c = tablaProd.getColumnCount() -1 ;
            Boolean selc = (Boolean)tablaProd.getValueAt(j, c);
            if(selc != null && selc){
                Object dato[] = new Object[titulo.length];
                dato[0] = tablaProd.getValueAt(j, 0);
                dato[1]= tablaProd.getValueAt(j, 2);
                dato[2]= tablaProd.getValueAt(j, 3);
                dato[3]= tablaProd.getValueAt(j, 2);
                dato[5]= tablaProd.getValueAt(j, 3);
                Object fila [] = {dato[0], dato[1], dato[2], dato[3], dato[4]};
                tabla_ddProducto.addRow(fila);

            }
        }
            
        }else{
        JOptionPane.showMessageDialog(null, "Debe selecionar un producto y agregar la cantidad y el valor");
        }
        
    }
    
       public void insertarDetaFactcompra() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call into_factu_com_prod(?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdf_com());
            ps.setInt(2, getIdPro());
            ps.setInt(3, getIdUsu());
            ps.setString(4, getTipo_pago());
            ps.setDate(5, getFech());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Guardada");
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        conect.cerraConexion();
    } 
    //TABLA DE VER
        public String[] buscarTablaDetalleFactCompra(int valor, JTable tabla) {
        Conexion conect = new Conexion();
        Connection co = conect.iniciarConexion();

        //Personalizar Encabezado
        JTableHeader encabeza = tabla.getTableHeader();
        encabeza.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabeza);

        //Personalizar Celdas
        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());

        String[] titulo = {"Código", "Producto", "Descripción", "Cantidad",
            "Valor Unitario", "Total"};
        int opcion = titulo.length;//tiene el tamaño original del titulo

        DefaultTableModel tabladetalleFactcompr = new DefaultTableModel(null, titulo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sql = "call factu_detalle_com_prod(" + valor + ")";
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
                Object[] fila = {dato[8],dato[9], dato[10], dato[11], dato[12], dato[13]};

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
        
}
    

