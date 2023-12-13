package modelo;
//7

import controlador.Conexion;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Modelo_producto {

    private int idpr;
    private String nom, descri, ruta;
    private byte imagen[];

    public String getNom() {
        return nom;
    }

    public int getIdpr() {
        return idpr;
    }

    public void setIdpr(int idpr) {
        this.idpr = idpr;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public void buscarImagen() {
        JFileChooser archivos = new JFileChooser();
        String rutacarpeta = getClass().getClassLoader().getResource("procducto").getPath();
        File carpeta = new File(rutacarpeta);
        archivos.setCurrentDirectory(carpeta);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "JPG,PNG & GIF", "jpg", "png", "gif");
        archivos.setFileFilter(filtro);

        if (archivos.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            setRuta(archivos.getSelectedFile().getAbsolutePath());
        }

    }

    public byte[] obtenerImagen(String Espa) {
        try {
            File archivo = new File(Espa);
            byte[] ima = new byte[(int) archivo.length()];
            InputStream imgen = new FileInputStream(archivo);
            imgen.read(ima);
            return ima;
        } catch (Exception e) {
            return null;
        }
    }

    // public Object getjBtnimage() {
    //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    //public String getEspa() {
    //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    //public Object getjTextArimagen() {
    //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    public void insertarProducto() {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();

        String instProduct = "call into_producto(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(instProduct);
            ps.setInt(1, getIdpr());
            ps.setString(2, getNom());
            ps.setString(3, getDescri());
            ps.setBytes(4, getImagen());
            ps.setString(5, getRuta());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Guardado Exitoso");
            cn.close();
        } catch (SQLException y) {
            y.printStackTrace();
        }
        conect.cerraConexion();
    }

    public void limProduc(Component[] panel) {
        for (Object control : panel) {
            if (control instanceof JTextField) {
                ((JTextField) control).setText("");
            }
            if (control instanceof JScrollPane) {
                Component[] limp = ((JScrollPane) control).getViewport().getComponents();
                for (Object controltext : limp) {
                    if (control instanceof JTextArea) {
                        ((JTextArea) controltext).setText("");
                    }
                }
            }
        }
    }

    public void mostrarTablaProducto(JTable tabla, String valor, String NomPesta) {
        Conexion conet = new Conexion();
        Connection cn = conet.iniciarConexion();

        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setDefaultRenderer(new Gestion_Encabezado());
        tabla.setTableHeader(encabezado);

        tabla.setDefaultRenderer(Object.class, new Gestion_Celdas());

        JButton editar = new JButton("Editar");
        JButton eliminar = new JButton("Eliminar");
        //JButton agregar = new JButton();

        String[] titulo = {"IdProducto", "Nombre", "Descripcion", "imagen", "Precio", "Cantidad"};
//           String[] titulo = NomPesta.equals("producto") ? new String[]{"Código", "Imagen", "Producto", "Descripción", "Existencia", "Precio"} : new String[]{"Código", "Imagen", "Producto", "Descripción"};
        int total = titulo.length;
        if (NomPesta.equals("Producto")) {
            titulo = Arrays.copyOf(titulo, titulo.length + 2);
            titulo[titulo.length - 2] = "";
            titulo[titulo.length - 1] = "";

        } else {
           
            titulo = Arrays.copyOf(titulo, titulo.length + 1);
            titulo[titulo.length - 1] = "";
        }

        DefaultTableModel tablaProducto = new DefaultTableModel(null, titulo) {
            public boolean isCellEditable(int row, int column) {
                if (NomPesta.equals("")){
                    return column == 6;
                }else{
                return false;
                }
            }
        };

        String sqlProducto = valor.isEmpty() ? "select * from mostra_producto" : "call consul_producto('" + valor + "')";

        try {
            Object dato[] = new Object[total];

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlProducto);
            while (rs.next()) {
                try {
                    byte[] imag = rs.getBytes(5);
                    BufferedImage bfImag = null;
                    InputStream inStr = new ByteArrayInputStream(imag);

                    bfImag = ImageIO.read(inStr);

                    ImageIcon imagen = new ImageIcon(bfImag.getScaledInstance(64, 64, 0));
                    dato[4] = new JLabel(imagen);

                } catch (Exception e) {
                    dato[4] = new JLabel("No Imagenes");
                }
                dato[0] = rs.getInt(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(5);
                dato[5] = rs.getInt(6);

                Object[] fila = {dato[0], dato[1], dato[2], dato[4], dato[3], dato[5]};
                if (NomPesta.equals("Producto")) {
                    fila = Arrays.copyOf(fila, fila.length + 2);
                    fila[fila.length - 2] = editar;
                    fila[fila.length - 1] = eliminar;
                }else{
                    fila = Arrays.copyOf(fila, fila.length + 1);
                    fila[fila.length - 1] = false;
                }
               
//                cn.close(); 
              tablaProducto.addRow(fila);  
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tabla.setModel(tablaProducto);
        
//       if(NomPesta!="Producto"){
//           
//       }

        int numColumnas = tabla.getColumnCount();
         if (!NomPesta.equals("Producto")){
            int col = numColumnas -1; 
            TableColumn tc = tabla.getColumnModel().getColumn(col);
            tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
            
        }
        int[] tamanos = {100, 100, 100, 100, 100, 100, 50, 50};
        for (int j = 0; j < numColumnas; j++) {
            TableColumn columna = tabla.getColumnModel().getColumn(j);
            columna.setPreferredWidth(tamanos[j]);
        }
        conet.cerraConexion();

    }

    public void buscarProducto(int valor) {
        Conexion conect = new Conexion();
        Connection cn = conect.iniciarConexion();
        String sql = "call buscar_producto(" + valor + ")";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                setIdpr(rs.getInt(1));
                setNom(rs.getNString(2));
                setDescri(rs.getString(3));
                setImagen(rs.getBytes(4));//
                setRuta(rs.getString(5));
                cn.close();
            }
        } catch (SQLException y) {
            y.printStackTrace();
        }
    }

    public void eliminarProducto() {
        Conexion con = new Conexion();
        Connection cn = con.iniciarConexion();

        String eliminarProduc = "Call Eliminar_Producto(?)";
        try {
            PreparedStatement ps = cn.prepareStatement(eliminarProduc);
            ps.setInt(1, getIdpr());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Eliminado", "Producto Eliminado", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void actualizarProdcuto() {
        Conexion cone = new Conexion();
        Connection cn = cone.iniciarConexion();
        String sql = "call actu_producto(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getIdpr());
            ps.setString(2, getNom());
            ps.setString(3, getDescri());
            ps.setBytes(4, getImagen());
            ps.setString(6, getRuta());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro almacenamiento");
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
