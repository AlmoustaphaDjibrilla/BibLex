package com.bibliotheque.ProjetBibliotheque;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.engine.jdbc.ReaderInputStream;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.Entity.Profil;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args ) throws IOException
    {
    	/*
    	List<String> listes= new ArrayList<String>();
    	
    	for (Categorie cat: Categorie.values()) {
    		listes.add(cat.toString());
    	}
    	
    	for (String ct: listes) {
    		System.out.println(ct);
    	}
    	
    	String cheminPhoto= "D:\\Downloads\\IMG_6419 copy-compressed.jpg";
    	String cheminDetail= "D:\\Desktop\\detailAlmou.txt";
    	
    	File fichierPhoto= new File(cheminPhoto);
    	
    	InputStream input= new FileInputStream(fichierPhoto);
		
		int taillePhoto= (int) fichierPhoto.length();
		
		byte[] photo= new byte[taillePhoto];
		
		input.read(photo);
		
	
		File fichierDetail= new File (cheminDetail);
		
		Reader reader= new FileReader(fichierDetail);
		int tailleDetails= (int) fichierDetail.length();
		
		char[] details= new char[tailleDetails];
		reader.read(details);
    	
      */
    
    
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("projetBibliotheque");
    	
    	EntityManager manager= emf.createEntityManager();
    	
    	Profil profil= (Profil)manager.find(Profil.class, 2);
    }
}


