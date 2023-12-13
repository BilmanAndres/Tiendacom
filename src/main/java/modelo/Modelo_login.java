//esta

package modelo;
//5
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vista.Login;


public class Modelo_login {
    Conexion conect = new Conexion();
    Connection cn = conect.iniciarConexion();
    String usu, contra;
    Login lg = new Login();
    
    
    public Modelo_login (){
    
    }
     public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public boolean validar (String usuario, String contrasena){
        boolean result = false;
        String sql  = "call login(?,?)";
        
        try{
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                result = true;
            }
            System.out.println(result);
            if(result== true){
                cn.close();
                conect.cerraConexion();
            }
        }catch (SQLException y){
            y.printStackTrace();
        }
        
        return result ;
        
    }
    
}
