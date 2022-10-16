package com.bibliotheque.ProjetBibliotheque.dialogue.rendu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererNoir extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setFont(getFont().deriveFont(Font.BOLD));
		
		setHorizontalAlignment(LEFT);
		
		
		return this;
	}
}
