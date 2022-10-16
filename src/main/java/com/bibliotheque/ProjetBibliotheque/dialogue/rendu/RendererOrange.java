package com.bibliotheque.ProjetBibliotheque.dialogue.rendu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererOrange extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setFont(getFont().deriveFont(Font.BOLD, 13));
		
		setHorizontalAlignment(CENTER);
		
		setForeground( new Color(255, 69, 0));
		
		setBackground(new Color(175, 238, 238));
		
		return this;
	}

}
