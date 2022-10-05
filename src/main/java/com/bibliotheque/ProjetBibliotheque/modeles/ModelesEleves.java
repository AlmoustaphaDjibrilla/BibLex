package com.bibliotheque.ProjetBibliotheque.modeles;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;

public class ModelesEleves extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String[] TITRES= { "MATRICULE", "NOM", "PRENOM", "CLASSE" };
	private final List<Eleve> lesEleves;
	
	
	public ModelesEleves(List<Eleve> eleves) {
		this.lesEleves= new ArrayList<Eleve>(eleves);
	}
	

	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesEleves.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return TITRES.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		Eleve eleve= getEleve(rowIndex);
		
		switch (columnIndex) {
		
			case 0:
				return eleve.getMatricule();
				
			case 1:
				return eleve.getNom();
				
			case 2:
				return eleve.getPrenom();
				
			case 3:
				return eleve.getClasse();

			default:
				return null;
		}
		
	}
	
	
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		
		case 0:
			return "MATRICULE";
			
		case 1:
			return "NOM";
			
		case 2:
			return "PRENOM";
			
		case 3:
			return "CLASSE";
			
		default:
			return null;
		}
	}

	public Eleve getEleve(int rowIndex) {
		Eleve eleve= lesEleves.get(rowIndex);
		return eleve;
	}
}
