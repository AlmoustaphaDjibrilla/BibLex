package com.bibliotheque.ProjetBibliotheque.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "Livre")
public class Livre {

	@Id
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "titre")
	private String titre;
	
	@Column(name = "anneeEdition")
	private int anneeEdition;
	
	@Column(name = "niveau")
	private String niveau;
	
	@Column(name = "categorie")
	private String categorie;
	
	@Column(name= "quantite")
	private int quantite;
	
	
	@Column(name="nombreEmprunts")
	private int nombreEmprunts;
	

	/*
	 * Constructeur
	 */
	public Livre() {
		
	}
	
	/*
	public Livre(String isbn, String titre, int anneeEdition) {
		this.isbn= isbn;
		this.titre= titre.substring(0, 1).toUpperCase() + titre.substring(1).toLowerCase();
		this.anneeEdition= anneeEdition;
	}
	
	public Livre(String isbn, String titre, int anneeEdition, Niveau niveau) {
		this.isbn= isbn;
		this.titre=  titre.substring(0, 1).toUpperCase() + titre.substring(1).toLowerCase();
		this.anneeEdition= anneeEdition;
		this.niveau= niveau.toString();
	}
	*/
	
	public Livre(String isbn, String titre, int anneeEdition, Niveau niveau, Categorie categorie) {
		this.isbn= isbn.toUpperCase();
		this.titre=  titre.substring(0, 1).toUpperCase() + titre.substring(1).toLowerCase();
		this.anneeEdition= anneeEdition;
		this.niveau= niveau.toString();
		this.categorie= categorie.toString();
		this.quantite= 1;
		this.nombreEmprunts= 0;
	}
	
	
	/*
	 * Les getters
	 */
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitre() {
		return titre;
	}

	public String getNiveau() {
		return niveau;
	}
	
	public String getCategorie() {
		return categorie;
	}

	public int getAnneeEdition() {
		return anneeEdition;
	}
	
	public int getQuantite() {
		return this.quantite;
	}
	
	
	public int getNombreEmprunts() {
		return this.nombreEmprunts;
	}
	
	
	/*
	 * Les setters
	 */
	
	public void setIsbn(String isbn) {
		this.isbn = isbn.toUpperCase();
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAnneeEdition(int anneeEdition) {
		this.anneeEdition = anneeEdition;
	}
	
	public void setQuantite(int nouvelleQuantite) {
		this.quantite= nouvelleQuantite;
	}
	
	
	
	public void setNombreEmprunts(int nouveauNombreEmprunt) {
		this.nombreEmprunts= nouveauNombreEmprunt;
	}
	
	
	
	/**
	 * Incrementer la quantité du livre
	 * @param plus
	 */
	public void augmenterQuantiteLivre(int plus) {
		this.quantite+= plus;
	}
	
	
	
	
	/**
	 * Décrémenter la quantité du livre et incrementer le nombre d'emprunts
	 * @param moins
	 */
	public void diminuerQuantite(int moins) {
		this.quantite-= moins;
		this.nombreEmprunts+=1;
	}

	
	/**
	 * Augmenter la quantite de nombre d'emprunts
	 */
	public void nouvelEmprunt() {
		this.nombreEmprunts+=1;
	}
	
	@Override
	public String toString() {
		return "Livre [isbn=" + isbn + ", titre=" + titre + ", anneeEdition=" + anneeEdition + ", niveau=" + niveau
				+ ", categorie=" + categorie + ", quantite=" + quantite + ", nombreEmprunts=" + nombreEmprunts + "]";
	}
	
	
}
