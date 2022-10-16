package com.bibliotheque.ProjetBibliotheque.dialogue.rendu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererVert extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setFont(getFont().deriveFont(Font.BOLD, 13));
		
		setHorizontalAlignment(CENTER);
		
		setForeground( new Color(50, 205, 50));
		
		setBackground(new Color(255, 228, 196));
		
		return this;
	}


}
