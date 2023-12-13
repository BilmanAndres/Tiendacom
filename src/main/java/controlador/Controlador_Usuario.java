//esta

package controlador;
//2
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import modelo.Modelo_Usuario;
import vista.Principal;
import vista.Usuarios;

public class Controlador_Usuario implements ActionListener {

    Usuarios usu = new Usuarios();
    Principal pri = new Principal();
    Modelo_Usuario mode_usu = new Modelo_Usuario();

    public void controUsuario() {

        pri.setVisible(false);
        usu.setLocationRelativeTo(null);
        usu.setVisible(true);

        usu.getjCbBoxselec_sexo().addItem("Seleccione...");
        Map<String, Integer> dato = mode_usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            usu.getjCbBoxselec_sexo().addItem(sexo);
        }

        usu.getjComboBoxcargo().addItem("Seleccione...");
        Map<String, Integer> datos = mode_usu.llenarCombo("cargo");
        for (String rol : datos.keySet()) {
            usu.getjComboBoxcargo().addItem(rol);
        }

    }

    public Controlador_Usuario() {
        usu.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent y) {
                Controlador_Principal con_pri = new Controlador_Principal();
                con_pri.iniciarPrincipal(0);
            }
        });
        usu.getjButtoguardar().addActionListener(this);
        usu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent y) {
        if (y.getSource().equals(usu.getjButtoguardar())) {
            if (((usu.getjTextinsert_ususario().getText().isEmpty()) || (usu.getjTextisert_nombre().getText().isEmpty())
                    || (usu.getjTextinsert_telefono().getText().isEmpty())
                    || (usu.getjCbBoxselec_sexo().getSelectedItem().equals("Seleccione..."))
                    || (usu.getjTextinser_direccion().getText().isEmpty())
                    || (usu.getjDateChooserFecha_nacimiento().getDate() == null)
                    || (usu.getjComboBoxcargo().getSelectedItem().equals("Seleccione...")
                    || (usu.getjTextinsert_login().getText().isEmpty())
                    || (usu.getjTextinsert_correo().getText().isEmpty())
                    || (usu.getjPasinsert_clave().getPassword() == null)))) {
                JOptionPane.showMessageDialog(null, "FALTA INFORMACION EN LOS CAMPOS");
                //}
            } else {
                String valorSexo = usu.getjCbBoxselec_sexo().getSelectedItem().toString();
                String valorCargo = usu.getjComboBoxcargo().getSelectedItem().toString();

                int sexo = mode_usu.llenarCombo("sexo").get(valorSexo);
                int cargo = mode_usu.llenarCombo("cargo").get(valorCargo);

                java.util.Date fech = usu.getjDateChooserFecha_nacimiento().getDate();
                long fe = fech.getTime();
                java.sql.Date fecha = new Date(fe);

                char[] contra = usu.getjPasinsert_clave().getPassword();
                String contrasena = String.valueOf(contra);

                mode_usu.setIdUsu(Integer.parseInt(usu.getjTextinsert_ususario().getText()));
                mode_usu.setNom(usu.getjTextisert_nombre().getText());
                mode_usu.setTelef(usu.getjTextinsert_telefono().getText());
                mode_usu.setCorr(usu.getjTextinsert_correo().getText());
                mode_usu.setDirec(usu.getjTextinser_direccion().getText());
                mode_usu.setIdsex(sexo);
                mode_usu.setIdcarg(cargo);//setIdcarg(idcarg);
                mode_usu.setLogi(usu.getjTextinsert_login().getText());
                mode_usu.setClav(contrasena);
                mode_usu.setFech_naci(fecha);

                if (usu.getjButtoguardar().getText().equals("Guardar")) {
                    mode_usu.insertarUsuarios();
                    mode_usu.limpiar(usu.getjPausu().getComponents());
                  //  mode_usu.limpiar(pri.getTable_usuario().getComponents());
                } else {
                    mode_usu.actualizarUsuaario();
                    usu.setVisible(false);
                    usu.dispose();
                   // pri.getJtPrincipal().setSelectedIndex(1);
                    
                    //pri.setVisible(true);
                   // mode_usu.mostraTablaUsu(pri.getTable_usuario(), "", "usuario"); //fecha comente 18/11/2023 hora = 9:46a.m.

                }
            }
        } //(usu.getjPasinsert_clave().getPassword() == null) ) )){
    }

    void actulizarUsuario(int doc) {
        mode_usu.buscar_usuario(doc);
        usu.getjTextinsert_ususario().setEnabled(false);
        usu.getjTextinsert_login().setEnabled(false);
        usu.getjTextinsert_ususario().setText(String.valueOf(doc));
        usu.getjTextisert_nombre().setText(mode_usu.getNom());
        usu.getjTextinsert_correo().setText(mode_usu.getCorr());
        usu.getjTextinser_direccion().setText(mode_usu.getDirec());
        usu.getjTextinsert_telefono().setText(mode_usu.getTelef());
        usu.getjPasinsert_clave().setText(mode_usu.getClav());
        usu.getjTextinsert_login().setText(mode_usu.getLogi());
        usu.getjDateChooserFecha_nacimiento().setDate(mode_usu.getFech_naci());

//LLLENAR SEXO
        Map<String, Integer> dato = mode_usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            usu.getjCbBoxselec_sexo().addItem(sexo);
        }
        // OBTENER EL VALOR GURADADO EN LA BASSE DE DATOS
        String ValorSexo = mode_usu.obtenerSeleccion(dato, mode_usu.getIdsex());//.obtenerSelecion(dato, mode_usu.getIdsex());
        usu.getjCbBoxselec_sexo().setSelectedItem(ValorSexo);

        //LLENAR CARGO
        Map<String, Integer> datos = mode_usu.llenarCombo("cargo");
        for (String cargo : datos.keySet()) {
            usu.getjComboBoxcargo().addItem(cargo);//.getCbxCargo().addItem(rol);
            // OBTENER EL VALOR GURADADO EN LA BASSE DE DATOS
            String valorRol = mode_usu.obtenerSeleccion(datos, mode_usu.getIdcarg());
            usu.getjComboBoxcargo().setSelectedItem(valorRol);//getCbxCargo().setSelectedItem(valorRol);
            // llenar tipo de documento
            //usu.getCmbtipodocu().setSelectedItem(mode_usu.getTipo_doc());
        }
        usu.getjLbnuevo_usuario().setText("Actualizar Usuario");

        pri.setVisible(false);
        usu.setLocationRelativeTo(null);
        usu.getjButtoguardar().setText("Actualizar");
        usu.setVisible(true);
        pri.setVisible(false);
    }

    void eliminarUsuario(int doc) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al usuario? \n" + doc,
                "Eliminar Usuario", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            mode_usu.setIdUsu(doc);
            mode_usu.eliminarUsuario();
            mode_usu.mostraTablaUsu(pri.getTable_usuario(), "Usuario Eliminado", "Usuario");
        }
    }
}
