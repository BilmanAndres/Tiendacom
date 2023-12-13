//esta


package modelo;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Gestion_Celd extends DefaultTableCellRenderer{

    public Component getTableCellRenderComponet(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setForeground(new java.awt.Color(0, 0, 0));
        c.setFont(new java.awt.Font("Verdana", 0, 18));
        if (value instanceof JButton){
            JButton butt  = (JButton)value;
            return butt;
        }
        if(value instanceof JLabel){
            JLabel lbl = (JLabel) value;
            lbl.setForeground(new java.awt.Color(0, 0, 1));
            lbl.setFont(new java.awt.Font("verdana", 0, 12));
        }
        return c;
    }

}
