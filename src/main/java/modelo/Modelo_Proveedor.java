//esta

package modelo;
//6
import com.toedter.calendar.JDateChooser;
import controlador.Conexion;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
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


public class Modelo_Proveedor {
    
    private int idpro, idsex;
    private String nom, corr,tele, direc, tipo_docu, ti_po;
    private Date fech_naci;

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getTipo_docu() {
        return tipo_docu;
    }

    public void setTipo_docu(String tipo_docu) {
        this.tipo_docu = tipo_docu;
    }

    public String getTi_po() {
        return ti_po;
    }

    public void setTi_po(String ti_po) {
        this.ti_po = ti_po;
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

    public String getCorr() {
        return corr;
    }

    public void setCorr(String corr) {
        this.corr = corr;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
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
     public void insertarProvedor() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call into_provedores(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdpro());
            ps.setString(2, getTipo_docu());
            ps.setString(3, getNom());
            ps.setInt(4, getIdsex());
            ps.setString(5, getCorr());
            ps.setString(6, getTele());
            ps.setString(7, getDirec() );
            ps.setString(8, getTi_po());
            ps.setDate(9, (java.sql.Date) getFech_naci());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de almacenamineto", "Registro", idsex);
            cn.close();
            

        } catch (SQLException y) {
           JOptionPane.showMessageDialog(null, "Error", "Error", idsex);

        }
        conect.cerraConexion();
    }    
    public String obtenerSeleccion(Map< String, Integer > dato, int valor) {
       for(Map.Entry<String, Integer> seleccion : dato.entrySet()){
           if(seleccion.getValue()== valor){
               return seleccion.getKey();
           }
       } 
        return null;
    }
      public void limpiarProvee(Component[] panel) {
        for (Object control : panel) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");

            }
            if (control instanceof JComboBox) {
                ((JComboBox) control).setSelectedItem("Seleccione...");
            }
            if (control instanceof JDateChooser) {
                ((JDateChooser) control).setDate(null);
            }
        }
    }
      
     public void mostrarTablaProveedor(JTable tabla, String valor, String nomPesta){
         Conexion conect = new Conexion();
         Connection cn = conect.iniciarConexion();
         
        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");
        
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabezado);
        
        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());
        
        
        String[] titulo = {"Idproveedor","Tipo de Documento", "Nombre", "Sexo", "Correo", "Telefono", "Dirección", "Iipo de Persona","Fecha del Proveedor"};
        int total = titulo.length;
        
        if(nomPesta.equals("Provedores")){
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
            sqlCliente = "SELECT * FROM mostra_proveedor";
            
        } else {
           sqlCliente = "call consul_provedoree('" + valor + "')"; 
        }    
         try {
            String [] dato = new String [titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlCliente);
            while (rs.next()) {
                for (int j = 0; j < total; j++){
                    dato [j] = rs.getString(j + 1);
                }
                
                Object [] fila = {dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6],dato[7], dato[8]};
                if (nomPesta.equals("Provedores")){
                    fila = Arrays.copyOf(fila, fila.length+1);
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
        
        int numColumna = tabla.getColumnCount();
        int[] tamanos = {100, 150, 100, 100, 150, 100, 150, 100, 150, 30, 30};
        for (int j = 0; j < numColumna; j++) {
            TableColumn columna = tabla.getColumnModel().getColumn(j);
            columna.setPreferredWidth(tamanos[j]);

        }
     }
     public void buscar_provee(int valor) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call buscar_provee(" + valor + ")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs == null) {
                System.out.println("No hay registros");

            } else {
                while (rs.next()) {
                    setIdpro(rs.getInt(1));
                    setTipo_docu(rs.getString(2));
                    setNom(rs.getString(3));
                    setIdsex(rs.getInt(4));
                    setCorr(rs.getString(5));
                    setTele(rs.getString(6));
                    setDirec(rs.getString(7));
                    setTi_po(rs.getString(8));
                    setFech_naci(rs.getDate(9));

                }
                cn.close();
            }
        } catch (SQLException y) {
            y.printStackTrace();
        }
    }
//     
//         public String obtenerSeleccion(Map< String, Integer > dato, int valor) {
//       for(Map.Entry<String, Integer> seleccion : dato.entrySet()){
//           if(seleccion.getValue()== valor){
//               return seleccion.getKey();
//           }
//       } 
//        return null;
//    }
     
      public void actualizarProveedor() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();

        String sql = "call actu_provedores (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdpro());
            ps.setString(2, getTipo_docu());
            ps.setString(3, getNom());
            ps.setInt(4, getIdsex());
            ps.setString(5, getCorr());
            ps.setString(6, getTele());
            ps.setString(7, getDirec());
            ps.setString(8, getTi_po());
            ps.setDate(9, (java.sql.Date) getFech_naci());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Actualizada");
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public void eliminarProveedor() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();

        String sql = "call eliminar_provee(?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1,getIdpro());
            ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "¿Desea Eliminar el Registro?");
           cn.close(); 

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}
