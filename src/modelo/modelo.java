package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import javax.swing.JOptionPane;
import vista.VistaP;

/**
 *
 * @author AlumnadoTarde
 */
public class modelo {
    
    public static VistaP objv;
    private ResultSet rs;
    final String sql = "select * from alumnos";
    private Connection cn;
    
    public int Ejecutar_Sql_Actualizacion(String sql) {
        int i;
        try {
            Statement stmt = cn.createStatement();
            JOptionPane.showMessageDialog(null, sql);
             i = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            i = 0;
        }
        return i;
    }
    
    public modelo(){
        
    }
                   
    public ResultSet mostrar(){
        
        try {
            
            cn = conexion.getConexion();
            Statement stmt = (Statement) cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //Statement es una delaración (como select * ...)
            rs = stmt.executeQuery(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        return rs;
    }
    
    public void darDeBaja(String registro){
        
        
        String sqlDelete = "delete from alumnos where registro=" + registro;
        
        if (Ejecutar_Sql_Actualizacion(sqlDelete) > 0) {
            JOptionPane.showMessageDialog(null, "Baja Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
        
    }
    
    public void modificarDatos(String dni, String nombre, String apellido1, String apellido2, String registro){
        
        String sql = "update alumnos set dni='" + dni + "', nombre='" + nombre + "', "
        + "apellido1='" + apellido1 + "', apellido2='" + apellido2 + "' "
        + "where registro=" + registro;
        if (Ejecutar_Sql_Actualizacion(sql) > 0) {
            JOptionPane.showMessageDialog(null, "Modificación Correcta");
        } else {
            JOptionPane.showMessageDialog(null, "Ha Habido un Error");
        }
        
    }
       
}