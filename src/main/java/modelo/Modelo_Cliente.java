//esta

package modelo;
//4
import com.toedter.calendar.JDateChooser;
import controlador.Conexion;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;



public class Modelo_Cliente {
     private int idClien, idsex ;
    private String nom, tel, corr ;
    private Date fech_naci;

    public int getIdClien() {
        return idClien;
    }

    public void setIdClien(int idClien) {
        this.idClien = idClien;
    }

    public int getIdsex() {
        return idsex;
    }

    public void setIdsex(int idsex) {
        this.idsex = idsex;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorr() {
        return corr;
    }

    public void setCorr(String corr) {
        this.corr = corr;
    }

    public Date getFech_naci() {
        return fech_naci;
    }

    public void setFech_naci(Date fech_naci) {
        this.fech_naci = fech_naci;
    }
    
     public Map<String, Integer> llenarCombo(String valor) {
         Conexion conect = new Conexion();
         Connection cn = conect.iniciarConexion();

        String sgl = "SELECT * FROM mostrar_"+valor;

        Map<String, Integer> llenar_combo = new HashMap<>();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sgl);
            while (rs.next()) {
                llenar_combo.put(rs.getString(2), rs.getInt(1));
            }
        } catch (SQLException y) {

            y.printStackTrace();
      
        }
        return llenar_combo;
     }
     

    public void insertarCliente() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call into_clien(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdsex());
            ps.setString(2, getNom());
            ps.setString(3, getTel());
            ps.setString(4, getCorr());
            ps.setInt(5, getIdsex());
            ps.setDate(6, (java.sql.Date) getFech_naci());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de almacenamineto", "Registro", idsex);
            cn.close();
            
        } catch (SQLException y) {
           JOptionPane.showMessageDialog(null, "Error", "Error", idsex);

        }
        conect.cerraConexion();
    }    
 public void limpiarClientes(Component[] panel) {
        for (Object vaciar : panel) {
            if (vaciar instanceof JTextField) {
                ((JTextField) vaciar).setText("");
            }

            if (vaciar instanceof JComboBox) {
                ((JComboBox) vaciar).setSelectedItem("Seleccione...");
                ((JComboBox) vaciar).setSelectedItem("Seleccionar:");
            }

            if (vaciar instanceof JDateChooser) {
                ((JDateChooser) vaciar).setDate(null);
            }
        }
    }
    public void mostrarTablaCliente(JTable tabla, String valor, String nomPesta) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");
        
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabezado);
        
        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());
        
        String[] titulo = {"Cedula","Nombre", "Telefono", "Correo", "Sexo", "Fecha De Nacimiento"};
        int total = titulo.length;
        
        if(nomPesta.equals("Cliente")){
            titulo = Arrays.copyOf(titulo, titulo.length+2);
            
            titulo [titulo.length -2] = "Editar";
            titulo[titulo.length-1] = "Eliminar";
        }
        
         DefaultTableModel tablaCliente = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         
        String sqlCliente;
        if (valor.equals("")){
            sqlCliente = "SELECT * FROM mostrar_cliente";
            
        } else {
           sqlCliente = "call consul_clientes('" + valor + "')"; 
        }
        try {
            String [] dato = new String [titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlCliente);
            while (rs.next()) {
                for (int j = 0; j < total; j++){
                    dato [j] = rs.getString(j + 1);
                }
                
                Object [] fila = {dato[0], dato[1], dato[2], dato[3], dato[4], dato[5]};
                if (nomPesta.equals("Cliente")){
                    fila = Arrays.copyOf(fila, fila.length+2);
                    fila[fila.length - 2] = editar;
                    fila[fila.length-1]= eliminar;
                }
                tablaCliente.addRow(fila);
            }
            cn.close();
            
        }catch (SQLException y) {
            y.printStackTrace();
        }
        tabla.setModel(tablaCliente);
        
        int numColumnas = tabla.getColumnCount();
        int [] tamanos = {100, 100, 100, 100, 150, 100, 80, 80};
         for (int j = 0; j < numColumnas; j++) {
            TableColumn columna = tabla.getColumnModel().getColumn(j);
            columna.setPreferredWidth(tamanos[j]);
        }
         
        conect.cerraConexion();
    }
    
     public void buscarCliente(int valor) {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();

        String sql = "call buscar_clien(" + valor + ")";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                setIdClien(rs.getInt(1));
                setNom(rs.getString(2));
                setTel(rs.getString(3));
                setCorr(rs.getString(4));
                setIdsex(rs.getInt(5));
                setFech_naci(rs.getDate(6));
                cn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
     
    public String obtenerSeleccion(Map<String, Integer> dato, int valor) {
        for (Map.Entry<String, Integer> seleccion : dato.entrySet()) {
            if (seleccion.getValue() == valor) {
                return seleccion.getKey();
            }
        }
        return null;
    }
    
     public void actualizarCliente() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();

        String sql = "call actu_cliente (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setInt(1, getIdClien()); 
            ps.setString(2, getNom());
            ps.setString(3, getTel());
            ps.setString(4, getCorr());
            ps.setInt(5, getIdsex());
            ps.setDate(6, (java.sql.Date) getFech_naci());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Actualizada");
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    public void eliminarCliente() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();

        String sql = "call eliminar_cli(?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1,getIdClien());
            ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "¿Desea Eliminar el Registro?");
           cn.close(); 

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
