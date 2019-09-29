package controlador;

import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.modelo;
import vista.VistaP;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author AlumnadoTarde
 */
public class Controlador {

    ResultSet rs;
    public static VistaP objv;
    public static modelo objm;
    private static Connection cn = null;

    public Controlador(VistaP principal, modelo modelo) {
        
        objv = principal;
        objm = modelo;
        objv.vistaDeTablas(modelo.mostrar());
        addMouseListener();
        
        objv.getBtnAltas().addActionListener(new btnAltasBotonesClick());
        objv.getBtnBajas().addActionListener(new btnBajasActionPerformed());
        objv.getBtnModificaciones().addActionListener(new btnModificacionesActionPerformed());
        objv.getBtnSalir().addActionListener(new btnSalirActionPerformed());
    
    }

    private void addMouseListener() {   //El ratón espera a la escucha de lo que hay dentro de aquí
        
        objv.getTablaAlumnos().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){ //Al pulsar en una fila de la tabla con el ratón, hago que se recoja el text y lo muestre en la fila con el código que pone al lado
                
                int fila = objv.getTablaAlumnos().getSelectedRow();
                objv.getTxtDni().setText(String.valueOf(objv.getTablaAlumnos().getValueAt(fila, 1)));
                objv.getTxtRegistro().setText(String.valueOf(objv.getTablaAlumnos().getValueAt(fila, 0)));
                objv.getTxtNombre().setText(String.valueOf(objv.getTablaAlumnos().getValueAt(fila, 2)));
                objv.getTxtApellido1().setText(String.valueOf(objv.getTablaAlumnos().getValueAt(fila, 3)));
                objv.getTxtApellido2().setText(String.valueOf(objv.getTablaAlumnos().getValueAt(fila, 4)));
                
            }
        });
    }

    private static class btnAltasBotonesClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
           
        }

    }

    public class btnBajasActionPerformed implements ActionListener {

        public btnBajasActionPerformed() {

        }

        @Override
        public void actionPerformed(ActionEvent arg0) { //Al pulsar el botón de baja va al modelo y borra el registro seleccionado
            
            objm.darDeBaja(objv.getTxtRegistro().getText());
            
        }

    }

    public class btnModificacionesActionPerformed implements ActionListener {   //Modifica los datos del registro seleccionado desde el modelo

        public btnModificacionesActionPerformed() {

        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            
            objm.modificarDatos(objv.getTxtDni().getText(), objv.getTxtNombre().getText(), objv.getTxtApellido1().getText(),
                    objv.getTxtApellido2().getText(), objv.getTxtRegistro().getText());
            
        }
    }

    public class btnSalirActionPerformed implements ActionListener {

        public btnSalirActionPerformed() {

        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.exit(0);     //Cerrar con el botón, que lo hace poniendo un 0 en lugar de EXIT_ON_CLOSE porque éste da fallo
        }
    }

    public void ejecutar_consulta(String sql) throws SQLException {

        Statement stmt = (Statement) cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt.executeQuery(sql);
    }

}