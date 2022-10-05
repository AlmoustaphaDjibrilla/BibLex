package com.bibliotheque.ProjetBibliotheque.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Eleve")
public class Eleve implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="matricule")
	private int matricule;
	
	@Column(name="nom")
	private String nom;

	@Column(name="prenom")
	private String prenom;
	
	@Column(name="classe")
	private String classe;
	
	@Column (name = "nombreEmpruntsEnCours")
	private int nombreEmpruntsEnCours;
	
	@Column ( name = "nombreEmpruntsEffectues")
	private int nombreEmpruntsEffectues;
	
	public Eleve(int matricule, String nom, String prenom, Classe classe) {
		super();
		this.matricule = matricule;
		this.nom = nom.toUpperCase();
		this.prenom = prenom.substring(0,1).toUpperCase()+ prenom.substring(1).toLowerCase();
		this.classe = classe.toString();
	}
	
	public Eleve(String nom, String prenom, String classe) {
		this.nom=nom;
		this.prenom= prenom;
		this.classe= classe;
	}
	
	public Eleve() {
		
	}
	
	/*
	 * 
	 * Getters and setters
	 * 
	 */
	
	public Eleve(int matricule, String nom, String prenom, String classe) {
		// TODO Auto-generated constructor stub
		super();
		this.matricule = matricule;
		this.nom = nom.toUpperCase();
		this.prenom = prenom.substring(0,1).toUpperCase()+ prenom.substring(1).toLowerCase();
		this.classe = classe.toString();
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	
	
	public int getNombreEmpruntsEnCours() {
		return nombreEmpruntsEnCours;
	}

	public void setNombreEmpruntsEnCours(int nombreEmpruntsEnCours) {
		this.nombreEmpruntsEnCours = nombreEmpruntsEnCours;
	}

	public int getNombreEmpruntsEffectues() {
		return nombreEmpruntsEffectues;
	}

	public void setNombreEmpruntsEffectues(int nombreEmpruntsEffectues) {
		this.nombreEmpruntsEffectues = nombreEmpruntsEffectues;
	}
	
	
	public void nouvelEmprunt() {
		this.nombreEmpruntsEnCours+=1;
	}
	
	public void restituerEmprunt() {
		this.nombreEmpruntsEnCours-=1;
		this.nombreEmpruntsEffectues+=1;
	}

	@Override
	public String toString() {
		return "Eleve [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", classe=" + classe
				+ ", nombreEmpruntsEnCours=" + nombreEmpruntsEnCours + ", nombreEmpruntsEffectues="
				+ nombreEmpruntsEffectues + "]";
	}
}
