package modelo;

/**
 *Clase dedicada exclusivamente a la conexión con la base de datos
 */

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    
    private static final String base = "libros";
    private static final String password = "elrincon1920";
    private static final String user = "root";
    private static final String url = "jdbc:mysql://localhost:3306/" + base + "?serverTimezone=UTC";
    
    public static Connection getConexion() throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        
        try{
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(conexion.url, conexion.user, conexion.password);
        
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Connection error");
            
        }
            
            
        return con;
        
    }
    
}