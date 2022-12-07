package gongju;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableImage extends DefaultTableModel {
    public TableImage(Vector jilu, Vector ziduan) {
        super(jilu, ziduan);
    }

    public Class getColumnClass(int col) {
        return ((Vector) this.dataVector.elementAt(0)).elementAt(col).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
