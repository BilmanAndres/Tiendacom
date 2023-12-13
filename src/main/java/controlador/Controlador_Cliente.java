//esta

package controlador;
//3
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Modelo_Cliente;
import vista.Clientes;
import vista.Principal;

public class Controlador_Cliente implements ActionListener {

    Clientes cli = new Clientes();
    Principal pri = new Principal();
    Modelo_Cliente mode_cli = new Modelo_Cliente();

    public Controlador_Cliente() {
        cli.getjButtguardar_cliente().addActionListener(this);
        cli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cli.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent y) {
                Controlador_Principal con_pri = new Controlador_Principal();
                con_pri.iniciarPrincipal(3);
            }
        });
    }

    public void Contr_clien() {

        pri.setVisible(false);
        cli.setLocationRelativeTo(null);
        cli.setVisible(true);

        cli.getjCoboxsexo().addItem("Seleccione...");
        Map<String, Integer> dato = mode_cli.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            cli.getjCoboxsexo().addItem(sexo);
        }
    }

////    public void Contr_clien(){
////       
////        cli.addWindowListener(new WindowAdapter() {
////            public void windowClosed(WindowEvent y) {
////             Controlador_Principal con_pri = new Controlador_Principal();
////             con_pri.iniciarPrincipal(2);
////             
////            }
////        });    
////        
////    }
////
////    public void controCliente() {
////        pri.setVisible(false);
////        cli.setLocationRelativeTo(null);
////        cli.setVisible(true);
////
////        cli.getjCoboxsexo().addItem("Seleccione...");
////        Map<String, Integer> dato = mode_cli.llenarCombo("sexo");
////        for (String sexo : dato.keySet()) {
////            cli.getjCoboxsexo().addItem(sexo);
////
////        }
////
////    }
    @Override
    public void actionPerformed(ActionEvent y) {
        if (y.getSource().equals(cli.getjButtguardar_cliente())) {
            if (((cli.getjTextcilente().getText().isEmpty()) || (cli.getjTextnombre().getText().isEmpty())
                    || (cli.getjTextelefono().getText().isEmpty())
                    || (cli.getjTextcorreo().getText().isEmpty()
                    || (cli.getjCoboxsexo().getSelectedItem().equals("Seleccione..."))
                    || (cli.getjDateChooser1().getDate() == null)))) {
                JOptionPane.showMessageDialog(null, "FALTA INFORMACION EN LOS CAMPOS");
                //}
            } else {

                JOptionPane.showMessageDialog(null, "!!RESGISTRADO!!");
                String valorSexo = cli.getjCoboxsexo().getSelectedItem().toString();
                int sexo = mode_cli.llenarCombo("sexo").get(valorSexo);
                java.util.Date fec = cli.getjDatefecha_clien().getDate();
                long fe = fec.getTime();
                java.sql.Date fecha = new Date(fe);

                mode_cli.setIdClien(Integer.parseInt(cli.getjTextcilente().getText()));
                mode_cli.setNom(cli.getjTextnombre().getText());
                mode_cli.setTel(cli.getjTextelefono().getText());
                mode_cli.setCorr(cli.getjTextcorreo().getText());
                mode_cli.setIdsex(sexo);
                mode_cli.setFech_naci(fecha);

                mode_cli.insertarCliente();
                mode_cli.limpiarClientes(cli.getjPanel_cliente().getComponents());

                if (cli.getjButtguardar_cliente().getText().equals("Guardar")) {
                    mode_cli.insertarCliente();
                    mode_cli.limpiarClientes(cli.getjPanel_cliente().getComponents());

                } else {
                    mode_cli.actualizarCliente();
                    cli.setVisible(false);
                    pri.getJtPrincipal().setSelectedIndex(4);
                    cli.dispose();
                    mode_cli.mostrarTablaCliente(pri.getTable_client(), "", "Cliente");
                    cli.dispose();
                }
            }
        }
    }

    void actulizarClien(int doc) {
        mode_cli.buscarCliente(doc);
        
        
        cli.getjTextcilente().setEnabled(false);
        cli.getjTextcilente().setText(String.valueOf(doc));
        cli.getjTextnombre().setText(mode_cli.getNom());
        cli.getjTextelefono().setText(mode_cli.getTel());
        cli.getjTextcorreo().setText(mode_cli.getCorr());
        cli.getjDatefecha_clien().setDate(mode_cli.getFech_naci());

        // llamar sexo
        Map< String, Integer> dato = (mode_cli.llenarCombo("sexo"));
        for (String sexo : dato.keySet()) {
            cli.getjCoboxsexo().addItem(sexo);

        }
        //OBTENER EL VALOR GURADADO EN LA BASSE DE DATOS
        String ValorSexo = mode_cli.obtenerSeleccion(dato, mode_cli.getIdsex());
        cli.getjCoboxsexo().setSelectedItem(ValorSexo);

        cli.getjLnuevo_cli().setText("Actualizar Cliente");

        pri.setVisible(false);
        cli.setLocationRelativeTo(null);
        cli.getjButtguardar_cliente().setText("Actualizar");
        cli.setVisible(true);

    }

    void eliminarCliente(int doc) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al cliente? \n" + doc,
                "Eliminar Cliente", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            mode_cli.setIdClien(doc);
            mode_cli.eliminarCliente();
            mode_cli.mostrarTablaCliente(pri.getTable_provee(), "Cliente", "Cliente");

        }
    }
}
