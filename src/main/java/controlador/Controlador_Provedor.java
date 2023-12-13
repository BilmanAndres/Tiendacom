
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Modelo_Proveedor;
import vista.Principal;
import vista.Proveedores;


public class Controlador_Provedor implements ActionListener {

    Proveedores pro = new Proveedores();
    Principal pri = new Principal();
    Modelo_Proveedor mod_pro = new Modelo_Proveedor();

    public Controlador_Provedor() {
         pro.getjButtonguardar_Provedores().addActionListener(this);
         pro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         pro.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent y) {
                Controlador_Principal con_pri = new Controlador_Principal();
                con_pri.vista();
            }
        });    }
    
//    public void Contr_clien() {
//
//        pro.addWindowListener(new WindowAdapter() {
//            public void windowClosed(WindowEvent y) {
//                Controlador_Principal con_pri = new Controlador_Principal();
//                con_pri.vista();
//            }
//        });
//
//    }
    
    
     public void iniciarProveedor() {
        
        pri.setVisible(false);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);

        pro.getJCboxsexo_pro().addItem("Seleccione...");
        Map<String, Integer> dato = mod_pro.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            pro.getJCboxsexo_pro().addItem(sexo);

        }
//        pro.getjComboBoxtipo_docume().addItem("Seleccione...");
//         Map<String, Integer> dat = mod_pro.llenarCombo("tipo_documento");
//         for (String documen : dat.keySet()){
//             pro.getjComboBoxtipo_docume().addItem(documen);
//         }
//         
//        pro.getjComboBoxtipo_persona().addItem("Selecione..,");
//        Map<String, Integer> da = mod_pro.llenarCombo("tipo_persona");
//        for (String tipo: da.keySet()){
//            pro.getjComboBoxtipo_persona().addItem(tipo);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent y) {
        if (y.getSource().equals(pro.getjButtonguardar_Provedores())) {
            if (((pro.getjTxtinserIdprovedor().getText().isEmpty()) || pro.getjComboBoxtipo_docume().getSelectedItem().equals("Seleccione...")// (pro.getjTxtinsertipo_docu().getText().isEmpty())
                    || (pro.getjTxtinserNombre().getText().isEmpty())
                    || (pro.getJCboxsexo_pro().getSelectedItem().equals("Seleccione..."))
                    || (pro.getjTxtinserCorreo().getText().isEmpty())
                    || (pro.getjTxtinserTelefono().getText().isEmpty())
                    || (pro.getjTxtinserDirecc().getText().isEmpty())
                    || (pro.getjComboBoxtipo_persona().getSelectedItem().equals("Seleccione...")
                    || pro.getjDateChorFecha_provee().getDate() == null))) {
                JOptionPane.showMessageDialog(null, "FALTA INFORMACION EN LOS CAMPOS");
                //}
            } else {

                JOptionPane.showMessageDialog(null, "!!RESGISTRADO!!");
                String valorSexo = pro.getJCboxsexo_pro().getSelectedItem().toString();
//                String ValorDocumen = pro.getjComboBoxtipo_docume().getSelectedItem().toString();
//                String ValorPerso = pro.getjComboBoxtipo_persona().getSelectedItem().toString();

                int sexo = mod_pro.llenarCombo("sexo").get(valorSexo);
//                int documen = mod_pro.llenarCombo("tipo_documento").get(ValorDocumen);
//                int tipo = mod_pro.llenarCombo("tipo_persona").get(ValorPerso);

                java.util.Date fech = pro.getjDateChorFecha_provee().getDate();
                long fe = fech.getTime();
                java.sql.Date fecha = new Date(fe);
                
                mod_pro.setIdpro(Integer.parseInt(pro.getjTxtinserIdprovedor().getText()));
                mod_pro.setTipo_docu(pro.getjComboBoxtipo_docume().getSelectedItem().toString());
                mod_pro.setNom(pro.getjTxtinserNombre().getText());
                mod_pro.setIdsex(sexo);
                mod_pro.setCorr(pro.getjTxtinserCorreo().getText());
                mod_pro.setTele(pro.getjTxtinserTelefono().getText());
                mod_pro.setDirec(pro.getjTxtinserDirecc().getText());
                mod_pro.setTi_po(pro.getjComboBoxtipo_persona().getSelectedItem().toString());
                mod_pro.setFech_naci(fecha);
                
               
                
                if (pro.getjButtonguardar_Provedores().getText().equals("Guardar")){
                   mod_pro.insertarProvedor();
                   mod_pro.limpiarProvee(pro.getjPanelprovee().getComponents());
                    
                } else {
                    mod_pro.actualizarProveedor();
                    pro.setVisible(false);
                    pro.dispose();
                    mod_pro.mostrarTablaProveedor(pri.getTable_provee(), "", "Provedores");
                    pro.dispose();
                }  
                //java.sql.Date fecha = new Date(fe);
            }
        }
    }
    
    void actulizarProeedor(int doc) {
        mod_pro.buscar_provee(doc);
      
        pro.getjTxtinserIdprovedor().setEnabled(false);
        pro.getjComboBoxtipo_docume().setEnabled(false);
        pro.getjTxtinserIdprovedor().setText(String.valueOf(doc));
        pro.getjTxtinserNombre().setText(mod_pro.getNom());
        pro.getjTxtinserCorreo().setText(mod_pro.getCorr());
        pro.getjTxtinserDirecc().setText(mod_pro.getDirec());
        pro.getjTxtinserTelefono().setText(mod_pro.getTele());
        pro.getjDateChorFecha_provee().setDate(mod_pro.getFech_naci());
        
        Map< String, Integer> dato = (mod_pro.llenarCombo("sexo"));
        for (String sexo : dato.keySet()) {
            pro.getJCboxsexo_pro().addItem(sexo);
        }
        String ValorSexo = mod_pro.obtenerSeleccion(dato, mod_pro.getIdsex());//.obtenerSelecion(dato, mode_usu.getIdsex());
        pro.getJCboxsexo_pro().setSelectedItem(ValorSexo);
        
       pri.setVisible(false);
       pro.getjLnuvo_provee().setText("Actualizar Proveedor");
       pro.setLocationRelativeTo(null);
       pro.getjButtonguardar_Provedores().setText("Actualizar");
       pro.setVisible(true);
        
    }
    public void eliminarProvedor(int Doc) {
        int resp = JOptionPane.showConfirmDialog(null, "Eliminar Provedor? \n" + Doc,
                "Eliminar Provedor", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            mod_pro.setIdpro(Doc);
            mod_pro.eliminarProveedor();
            mod_pro.mostrarTablaProveedor(pri.getTable_provee(),"", "Provedore "   );
   
        }
    }
}