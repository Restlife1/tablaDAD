package modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivet
 */
public class VistaDeTablas  extends AbstractTableModel {

        ResultSet rs;
        ResultSetMetaData md; //contiene información sobre la estructura de un ResulSet,especialmente sobre sus nom campos
        int numColumnas;
        int numFilas;

        public VistaDeTablas(ResultSet rs) {
            this.rs = rs;
            try {
                md = (ResultSetMetaData) rs.getMetaData();
                this.rs.last();
                numFilas = this.rs.getRow();
                numColumnas = md.getColumnCount();

            } catch (SQLException ex) {
            }
        }

        @Override
        public int getRowCount() {
            return numFilas;
        }

        @Override
        public int getColumnCount() {
            return numColumnas;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            try {
                rs.absolute(rowIndex + 1);
                Object o = rs.getObject(columnIndex + 1);
                return o;
            } catch (SQLException ex) {
                return ex.toString();
            }

        }

}