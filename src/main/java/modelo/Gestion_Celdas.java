//esta

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author SENA
 */
public class Gestion_Celdas extends DefaultTableCellRenderer{

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
        Component c =   super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof JButton) {
            JButton btn = (JButton) value;
            return btn;
        }
        if( value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            lbl.setFont(new java.awt.Font("Verdana",1,12));
            lbl.setForeground(new java.awt.Color(0,0,1));
            
            return lbl;
        }
        return c;
        
        
    } 
    
    
}
