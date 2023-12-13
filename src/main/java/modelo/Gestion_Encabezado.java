//esta

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author SENA
 */
public class Gestion_Encabezado implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent encabeza = null;
        encabeza = new JLabel((String) value);
        ((JLabel) encabeza).setHorizontalAlignment(SwingConstants.CENTER);//Centra el encabezado
        Object cellValue = value;
        encabeza.setFont(new java.awt.Font("Verdana", 1, 12));
        return encabeza;
    }
}
