package com.bibliotheque.ProjetBibliotheque;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ChargerImage extends JFrame {

	private JPanel contentPane;
	EntityManagerFactory emf;
	EntityManager manager;
	private JLabel lblPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChargerImage frame = new ChargerImage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChargerImage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPhoto = new JLabel("");
		lblPhoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				File fichierChoisi= getFichier();
				try {
					byte[] photo= getPicture(fichierChoisi);
					ImageIcon image= getImageIcon(photo);
					
					lblPhoto.setIcon(image);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblPhoto.setBorder(new LineBorder(Color.ORANGE));
		lblPhoto.setBounds(444, 10, 388, 284);
		contentPane.add(lblPhoto);
		
		
		emf= Persistence.createEntityManagerFactory("projetBibliotheque");
		manager= emf.createEntityManager();
		
		
		
		
	}
	
	public File getFichier() {
		File fichierChoisi= null;
		
		JFileChooser choix= new JFileChooser();
		choix.showOpenDialog(null);
		
		fichierChoisi= choix.getSelectedFile();
		
		return fichierChoisi;
	}

	public byte[] getPicture(File fichierChoisi) throws IOException {
		byte[] donnesPhoto;
		try {
			InputStream input= new FileInputStream(fichierChoisi);
			
			int taille= (int) fichierChoisi.length();
			donnesPhoto= new byte[taille];
			input.read(donnesPhoto);
			return donnesPhoto;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public ImageIcon getImageIcon(byte[] dataPictures) {
		
		ImageIcon img= new ImageIcon(dataPictures);
		
		Image image= img.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		
		img= new ImageIcon(image);
		
		return img;
		
	}
}
