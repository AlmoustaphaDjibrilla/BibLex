package maquettes.gestionLivres;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Categorie;
import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.Entity.Niveau;
import com.bibliotheque.ProjetBibliotheque.controle.ControleLivres;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;

import maquettes.FrameGestion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAjoutLivre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIsbn;
	private JTextField txtTitre;
	
	private String[] lesNiveaux;
	private String[] lesCategories;
	private JButton btnOk;
	private JButton btnAnnuler;
	private JComboBox listNiveaux;
	private JSpinner spAnneeEdition;
	private JComboBox listCategories;
	
	private FrameGestion frameGestion;
	
	
	private CRUDLivre crud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrameAjoutLivre dialog = new FrameAjoutLivre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unchecked")
	public FrameAjoutLivre() {
		
		crud= new CRUDLivre();
		
		/*
		 * Initialiser les niveaux et les catégories des livres
		 */
		String[] lesNiveaux= {Niveau.SECONDE.toString(), Niveau.PREMIERE.toString(), Niveau.TERMINALE.toString(), Niveau.CONFONDU.toString()};
		
		Niveau[] niveaus= Niveau.values();

		Categorie[] categories= Categorie.values();
		
		
		/**
		 * 
		 */
		frameGestion= new FrameGestion();
		
		
		setModal(true);
		this.setTitle("Ajout de livre");
		setBounds(100, 100, 627, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(32, 178, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(41, 23, 77, 27);
		contentPanel.add(lblNewLabel);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtIsbn.setBounds(108, 20, 419, 32);
		contentPanel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(37, 81, 68, 32);
		contentPanel.add(lblNewLabel_1);
		
		txtTitre = new JTextField();
		txtTitre.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtTitre.setColumns(10);
		txtTitre.setBounds(108, 81, 419, 32);
		contentPanel.add(txtTitre);
		
		JLabel lblNewLabel_2 = new JLabel("Année");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(37, 158, 65, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("d'édition");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(22, 181, 81, 13);
		contentPanel.add(lblNewLabel_2_1);
		
		spAnneeEdition = new JSpinner();
		spAnneeEdition.setFont(new Font("Tahoma", Font.BOLD, 19));
		spAnneeEdition.setBounds(108, 158, 419, 36);
		contentPanel.add(spAnneeEdition);
		
		JLabel lblNewLabel_3 = new JLabel("Niveau");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(37, 258, 68, 13);
		contentPanel.add(lblNewLabel_3);
		
		listNiveaux = new JComboBox();
		listNiveaux.setModel( new DefaultComboBoxModel( niveaus ) );
		listNiveaux.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listNiveaux.setMaximumRowCount(16);
		listNiveaux.setBounds(108, 251, 419, 32);
		contentPanel.add(listNiveaux);
		
		JLabel lblNewLabel_3_1 = new JLabel("Catégorie");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(22, 325, 83, 20);
		contentPanel.add(lblNewLabel_3_1);
		
		listCategories = new JComboBox<Categorie>();
		listCategories.setModel(new DefaultComboBoxModel<Categorie>( categories ));
		listCategories.setMaximumRowCount(16);
		listCategories.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listCategories.setBounds(108, 319, 419, 32);
		contentPanel.add(listCategories);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				btnAnnuler = new JButton("Annuler");
				btnAnnuler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reinitialiser();
					}
				});
				btnAnnuler.setActionCommand("Cancel");
				buttonPane.add(btnAnnuler);
				
					btnOk = new JButton("OK");
					btnOk.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Livre nouvelLivre= creer();
							
							if (nouvelLivre==null) {
								JOptionPane.showMessageDialog(null, 
										"Les informations saisies ne sont pas compatibles",
										"Problème rencontré",
										JOptionPane.ERROR_MESSAGE);
								reinitialiser();
							}
							
							else {
								//boolean creation= crud.creer(nouvelLivre);
								
								ControleLivres controleLivres= frameGestion.getControleLivres();
								boolean creation=controleLivres.creerLivre(nouvelLivre);
								
								if (creation==false) {
									JOptionPane.showMessageDialog(null, 
											"Ajout non effectué",
											"Problème rencontre",
											JOptionPane.ERROR_MESSAGE);
									reinitialiser();
								}
								
								else {
									JOptionPane.showMessageDialog(null, nouvelLivre.getTitre()+" ajouté avec succès");
									reinitialiser();
									dispose();
								}
							}
						}
					});
					btnOk.setActionCommand("OK");
					buttonPane.add(btnOk);
					getRootPane().setDefaultButton(btnOk);
			
		
	}
	
	
	/**
	 * Cette méthode va récuperer les données des champs de saisies et créer un livre sur cette base
	 * @return livre
	 */
	public Livre creer() {
		Livre livre;
		
		String isbn= txtIsbn.getText();
		String titre= txtTitre.getText();
		int anneeEdition= (Integer) spAnneeEdition.getValue();
		Niveau niveau= (Niveau) listNiveaux.getSelectedItem();
		Categorie categorie= (Categorie) listCategories.getSelectedItem();
		
		if( isbn.equals("") || titre.equals("") || anneeEdition==0 || niveau==null || categorie==null ) {
			livre= null;
		}
		
		else {
			livre= new Livre(isbn, titre, anneeEdition, niveau, categorie);
		}
		
		return livre;
	}
	
	
	/**
	 * Cette méthode va simplement réinitialiser tous les champs de saisies
	 */
	public void reinitialiser() {
		txtIsbn.setText("");
		txtTitre.setText("");
		spAnneeEdition.setValue(0);
		listNiveaux.setSelectedItem(null);
		listCategories.setSelectedItem(null);
		txtIsbn.requestFocus();
	}
}
