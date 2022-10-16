package com.bibliotheque.ProjetBibliotheque;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Profil;
import com.bibliotheque.ProjetBibliotheque.controle.ControleLivres;

public class Essai extends JFrame {

	private JPanel contentPane;

	private ControleLivres controleLivres;
	
	EntityManagerFactory emf;
	EntityManager manager;
	private JTextField txtId;
	private JTextField txtDetails;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Essai frame = new Essai();
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
	public Essai() {
		
		emf= Persistence.createEntityManagerFactory("projetBibliotheque");
		manager= emf.createEntityManager();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblPhoto = new JLabel("");
		lblPhoto.setBorder(new LineBorder(Color.PINK));
		lblPhoto.setBounds(10, 39, 301, 223);
		contentPane.add(lblPhoto);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Profil profil= (Profil) manager.find(Profil.class, 3);
				
				String id= ""+profil.getId();
				
				txtId.setText(id);
				
				byte[] img= profil.getPhoto();
				
				ImageIcon imageIcon= new ImageIcon(img);
				
				Image image= imageIcon.getImage();
				
				Image im= image.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
				
				ImageIcon imageFinale= new ImageIcon(im);
				
				lblPhoto.setIcon(imageFinale);
			}
		});
		btnNewButton.setBounds(377, 102, 177, 44);
		contentPane.add(btnNewButton);
		
		txtId = new JTextField();
		txtId.setBounds(343, 203, 396, 59);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtDetails = new JTextField();
		txtDetails.setColumns(10);
		txtDetails.setBounds(343, 318, 396, 59);
		contentPane.add(txtDetails);
		
		controleLivres= new ControleLivres();
	}
}
