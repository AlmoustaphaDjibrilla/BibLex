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
import javax.swing.ImageIcon;

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
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setForeground(new Color(255, 160, 122));
		lblIsbn.setIcon(new ImageIcon(FrameAjoutLivre.class.getResource("/frameEmpruntImages/code-a-barre (1).png")));
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIsbn.setBounds(6, 18, 99, 36);
		contentPanel.add(lblIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtIsbn.setBounds(143, 20, 419, 32);
		contentPanel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setForeground(new Color(255, 160, 122));
		lblTitre.setIcon(new ImageIcon(FrameAjoutLivre.class.getResource("/frameEmpruntImages/titre (1).png")));
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitre.setBounds(6, 81, 83, 32);
		contentPanel.add(lblTitre);
		
		txtTitre = new JTextField();
		txtTitre.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtTitre.setColumns(10);
		txtTitre.setBounds(143, 81, 419, 32);
		contentPanel.add(txtTitre);
		
		JLabel lblAnnee = new JLabel("Année");
		lblAnnee.setForeground(new Color(255, 160, 122));
		lblAnnee.setIcon(new ImageIcon(FrameAjoutLivre.class.getResource("/frameEmpruntImages/evenements.png")));
		lblAnnee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAnnee.setBounds(6, 146, 115, 36);
		contentPanel.add(lblAnnee);
		
		JLabel lblEdition = new JLabel("d'édition");
		lblEdition.setForeground(new Color(255, 160, 122));
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEdition.setBounds(22, 181, 81, 13);
		contentPanel.add(lblEdition);
		
		spAnneeEdition = new JSpinner();
		spAnneeEdition.setFont(new Font("Tahoma", Font.BOLD, 19));
		spAnneeEdition.setBounds(143, 158, 419, 36);
		contentPanel.add(spAnneeEdition);
		
		JLabel lblNiveau = new JLabel("Niveau");
		lblNiveau.setForeground(new Color(255, 160, 122));
		lblNiveau.setIcon(new ImageIcon(FrameAjoutLivre.class.getResource("/frameEmpruntImages/classe (1).png")));
		lblNiveau.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNiveau.setBounds(6, 226, 115, 45);
		contentPanel.add(lblNiveau);
		
		listNiveaux = new JComboBox();
		listNiveaux.setModel( new DefaultComboBoxModel( niveaus ) );
		listNiveaux.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listNiveaux.setMaximumRowCount(16);
		listNiveaux.setBounds(143, 233, 419, 32);
		contentPanel.add(listNiveaux);
		
		JLabel lblCategorie = new JLabel("Catégorie");
		lblCategorie.setForeground(new Color(255, 160, 122));
		lblCategorie.setIcon(new ImageIcon(FrameAjoutLivre.class.getResource("/frameEmpruntImages/categories.png")));
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCategorie.setBounds(6, 305, 127, 40);
		contentPanel.add(lblCategorie);
		
		listCategories = new JComboBox<Categorie>();
		listCategories.setModel(new DefaultComboBoxModel<Categorie>( categories ));
		listCategories.setMaximumRowCount(16);
		listCategories.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listCategories.setBounds(143, 305, 419, 32);
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
