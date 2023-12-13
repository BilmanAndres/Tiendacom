
//esta
package modelo;
//1
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

public class Modelo_Usuario {

    private int idUsu, idsex, idcarg;
    private String nom, telef, corr, direc, logi, clav;
    private Date fech_naci;

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getIdsex() {
        return idsex;
    }

    public void setIdsex(int idsex) {
        this.idsex = idsex;
    }

    public int getIdcarg() {
        return idcarg;
    }

    public void setIdcarg(int idcarg) {
        this.idcarg = idcarg;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getCorr() {
        return corr;
    }

    public void setCorr(String corr) {
        this.corr = corr;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getLogi() {
        return logi;
    }

    public void setLogi(String logi) {
        this.logi = logi;
    }

    public String getClav() {
        return clav;
    }

    public void setClav(String clav) {
        this.clav = clav;
    }

    public Date getFech_naci() {
        return fech_naci;
    }

    public void setFech_naci(Date fech_naci) {
        this.fech_naci = fech_naci;
    }

    /*Creamos el metodo para llenar los combos a través de Map o diccionario*/
    public Map<String, Integer> llenarCombo(String valor) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        String sgl = "SELECT * FROM mostrar_" + valor;

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

    public void insertarUsuarios() {
        //Llamamos a la clase conexión
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call into_usuario(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdUsu());
            ps.setString(2, getNom());
            ps.setString(3, getTelef());
            ps.setString(4, getCorr());
            ps.setString(5, getDirec());
            ps.setInt(6, getIdsex());
            ps.setInt(7, getIdcarg());
            ps.setString(8, getLogi());
            ps.setString(9, getClav());
            ps.setDate(10, (java.sql.Date) getFech_naci());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de almacenamineto", "Registro", idsex);
            cn.close();
        } catch (SQLException y) {
            y.printStackTrace();

        }
        conect.cerraConexion();
    }

    public void limpiar(Component[] panel) {
        for (Object control : panel) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");

            }
            if (control instanceof JComboBox) {
                ((JComboBox) control).setSelectedItem("Seleccionar...");
            }
            if (control instanceof JDateChooser) {
                ((JDateChooser) control).setDate(null);
            }
        }

    }

    public void mostraTablaUsu(JTable tabla, String valor, String nomPesta) {
        Conexion conet = new Conexion();
        Connection cn = conet.iniciarConexion();
//        
        //Personalizar Encabezado
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabezado);

        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());

        JButton editar = new JButton();
        JButton eliminar = new JButton("Eli");
        JButton agregar = new JButton("Agregar");

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png")));
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png"))); //18/11/23 9:58am
        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.png")));
        // editar.setIcon(new java.swing.ImageIcon ( getClas().getResoucer( la ubicacion de la carpeta )));
        String[] titulo = {"Usuario", "Nombre", "Telefono", "Correo", "Sexo", "Dirección", "Cargo", "Fecha de Nacimiento", "Login"};
        int total = titulo.length;

        if (nomPesta.equals("Usuario")) {

            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "Editar";
            titulo[titulo.length - 1] = "Eliminar";

        } else {
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "Agregar";
        }

        DefaultTableModel tablaUsuario = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String sqlUsuario;
        if (valor.equals("")) {
            sqlUsuario = "SELECT * FROM mostrar_usuari";

        } else {
            sqlUsuario = "call consul_usuarios('" + valor + "')";
        }
        try {
            String[] dato = new String[titulo.length];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlUsuario);
            while (rs.next()) {
                for (int j = 0; j < total; j++) {
                    dato[j] = rs.getString(j + 1);
                }
                Object[] fila = {dato[0], dato[1], dato[2], dato[3], dato[5], dato[4], dato[6], dato[8], dato[7]};
                if (nomPesta.equals("Usuario")) {
                    fila = Arrays.copyOf(fila, fila.length + 2);

                    fila[fila.length - 2] = editar;
                    fila[fila.length - 1] = eliminar;
                } else {
                    fila = Arrays.copyOf(fila, fila.length +1);
                    fila[fila.length - 1] = agregar;
                }
                tablaUsuario.addRow(fila);
            }
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaUsuario);
        ///tamaño a cada columna
        int numColumna = tabla.getColumnCount();
        int[] tamanos = {100, 150, 100, 100, 150, 100, 150, 100, 150, 30, 30};
        for (int j = 0; j < numColumna; j++) {
            TableColumn columna = tabla.getColumnModel().getColumn(j);
            columna.setPreferredWidth(tamanos[j]);

        }
        conet.cerraConexion();
    }

    public void buscar_usuario(int valor) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call buscar_usu(" + valor + ")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs == null) {
                System.out.println("No hay registros");

            } else {
                while (rs.next()) {
                    setIdUsu(rs.getInt(1));
                    setNom(rs.getString(2));
                    setTelef(rs.getString(3));
                    setCorr(rs.getString(4));
                    setDirec(rs.getString(5));
                    setIdsex(rs.getInt(6));
                    setIdcarg(rs.getInt(7));
                    setLogi(rs.getString(8));
                    setClav(rs.getString(9));
                    setFech_naci(rs.getDate(10));

                }
                cn.close();
            }
        } catch (SQLException y) {
            y.printStackTrace();
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

     public void actualizarUsuaario() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String actu = "call actu_usuarios(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cn.prepareStatement(actu);
            ps.setInt(1, getIdUsu());
            ps.setString(2, getNom());
            ps.setString(3, getTelef());
            ps.setString(4, getCorr());
            ps.setString(5, getDirec());
            ps.setInt(6, getIdsex());
            ps.setInt(7, getIdcarg());
            ps.setString(8, getClav());
            ps.setDate(9, (java.sql.Date) getFech_naci());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información Actualizada");
            cn.close();
        } catch (SQLException y) {
            y.printStackTrace();

        } finally {
            conect.cerraConexion();
        }
    }

    public void eliminarUsuario() {
        Conexion conect = new Conexion();
        Connection con = conect.iniciarConexion();
        String sql = "call eliminar_usu(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getIdUsu());
            ps.executeUpdate();
            //  Icon elimina = new ImageIcon(getClass().getResource("/img/basura.png"));
            //    JOptionPane.showMessageDialog(null, "Registro Eliminado", "Eliminar Usuario", JOptionPane.PLAIN_MESSAGE, (Icon) elimina);
            JOptionPane.showMessageDialog(null, "¿Desea Eliminar el Registro?");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        conect.cerraConexion();
    }

}
