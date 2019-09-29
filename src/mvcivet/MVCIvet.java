package mvcivet;

import controlador.Controlador;
import modelo.modelo;
import vista.VistaP;
/**
 *
 * @author AlumnadoTarde
 */

public class MVCIvet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        modelo m = new modelo();
        VistaP m2 = new VistaP();    
        Controlador c = new Controlador(m2,m);
        m2.setVisible(true);
    
    }
    
}
