//esta

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo_login;
import vista.Login;

public class Controlador_Login implements ActionListener {
    Modelo_login modlog = new Modelo_login();
    Login log = new Login();
    Controlador_Principal Vista = new Controlador_Principal();
    
    
    public Controlador_Login() {
        log.getjBttiniciar_seccion().addActionListener(this);
        log.getjButtmostrar().addActionListener(this);
       
    }
    
    public void iniciarVista(){
        log.setLocationRelativeTo(null);// creando la vista
        log.setTitle("Iniciar Sesion");
        log.setVisible(true);// VER LA VISTA 
    }

    @Override
    public void actionPerformed(ActionEvent y) {
        if (y.getSource().equals(log.getjButtmostrar())){
            if (log.getJpcontrasena().getEchoChar()== '\u2022'){
                log.getJpcontrasena().setEchoChar((char)0);
                
            }else{
                log.getJpcontrasena().setEchoChar('\u2022');
            }
        }
        if (y.getSource()==(log.getjBttiniciar_seccion())){
            modlog.setUsu( log.getTxtUsuario().getText());
            String pass = new String(log.getJpcontrasena().getPassword());
            modlog.setContra(pass);
            if (modlog.validar(modlog.getUsu(),modlog.getContra())){
                log.setVisible(false);
                Vista.iniciarPrincipal(0);
            }else{
                JOptionPane.showMessageDialog(null, "Pofavor Intentelo De Nuevo SU USUARIO O CONTRACEÑA SON INCORRECTO");
            }
        }
    }
    
    
    
}
