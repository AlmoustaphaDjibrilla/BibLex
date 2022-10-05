package maquettes.gestionEmprunts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;
import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEmprunt;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class FrameAccorderEmprunt extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomEleve;
	private JTextField txtTitreLivre;
	private JTextField txtQteLivre;
	private JSpinner spMatriculeEleve;
	private JButton btnRechercherEleve;
	private JTextField txtIsbnLivre;
	private JButton btnRechercherLivre;
	private JButton btnAnnuler;
	private JButton btnValider;
	
	private CRUDEleve crudEleve;
	private CRUDLivre crudLivre;
	private CRUDEmprunt crudEmprunt;
	
	
	private Eleve eleve;
	private Livre livre;
	private JPanel panel;
	private JPanel panel_2;
	private JTextField txtClasseEleve;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAccorderEmprunt frame = new FrameAccorderEmprunt();
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
	public FrameAccorderEmprunt() {
		
		/*
		 * Initialiser les crud
		 */
		crudEleve= new CRUDEleve();
		crudLivre= new CRUDLivre();
		crudEmprunt= new CRUDEmprunt();
		
		
		
		setFocusableWindowState(true);
		toFront();
		setAutoRequestFocus(true);
		setBackground(new Color(143, 188, 143));
		setTitle("Accorder un emprunt");
		setSize(896, 146);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 877, 703);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GREEN, 4));
		panel.setBounds(36, 130, 818, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(46, 22, 114, 29);
		panel.add(lblNewLabel_1);
		
		txtNomEleve = new JTextField();
		txtNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomEleve.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtNomEleve.setEditable(false);
		txtNomEleve.setBounds(196, 18, 511, 35);
		panel.add(txtNomEleve);
		txtNomEleve.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Classe");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(46, 95, 62, 13);
		panel.add(lblNewLabel_4);
		
		txtClasseEleve = new JTextField();
		txtClasseEleve.setHorizontalAlignment(SwingConstants.CENTER);
		txtClasseEleve.setEditable(false);
		txtClasseEleve.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtClasseEleve.setBounds(196, 89, 511, 29);
		panel.add(txtClasseEleve);
		txtClasseEleve.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE, 3));
		panel_2.setBounds(36, 32, 818, 63);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricule élève");
		lblNewLabel.setBounds(39, 18, 114, 35);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		spMatriculeEleve = new JSpinner();
		spMatriculeEleve.setBounds(175, 18, 250, 35);
		panel_2.add(spMatriculeEleve);
		spMatriculeEleve.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnRechercherEleve = new JButton("Rechercher\r\n");
		btnRechercherEleve.setIcon(new ImageIcon(FrameAccorderEmprunt.class.getResource("/modifierEleveImages/icons8-trouver-l'utilisateur-homme-32 (1).png")));
		btnRechercherEleve.setBounds(489, 18, 258, 35);
		panel_2.add(btnRechercherEleve);
		
		/*
		 * Clic sur le bouton de recherche d'élève 
		 */
		
		btnRechercherEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int matriculeEleve=(Integer) spMatriculeEleve.getValue();
				
				eleve= rechercherEleve(matriculeEleve);
				
				controlerEleve(eleve);
			}
		});
		btnRechercherEleve.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.ORANGE, 3));
		panel_3.setBounds(36, 334, 824, 51);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN livre");
		lblNewLabel_2.setBounds(38, 12, 97, 30);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtIsbnLivre = new JTextField();
		txtIsbnLivre.setBounds(207, 10, 225, 30);
		panel_3.add(txtIsbnLivre);
		txtIsbnLivre.setHorizontalAlignment(SwingConstants.CENTER);
		txtIsbnLivre.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtIsbnLivre.setColumns(10);
		
		btnRechercherLivre = new JButton("Rechercher\r\n");
		btnRechercherLivre.setIcon(new ImageIcon(FrameAccorderEmprunt.class.getResource("/frameEmpruntImages/icons8-google-web-recherche-32.png")));
		btnRechercherLivre.setBounds(504, 8, 240, 35);
		panel_3.add(btnRechercherLivre);
		
		/*
		 * Clic sur le bouton de recherche de livre
		 */
		
		btnRechercherLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String isbn= txtIsbnLivre.getText();
				
				livre= crudLivre.chercherLivre(isbn);
				
				controlerLivre(livre);
			}
		});
		btnRechercherLivre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GREEN, 3));
		panel_4.setBounds(36, 432, 824, 113);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Titre");
		lblNewLabel_3.setBounds(33, 10, 97, 43);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtTitreLivre = new JTextField();
		txtTitreLivre.setBounds(140, 9, 511, 43);
		panel_4.add(txtTitreLivre);
		txtTitreLivre.setEditable(false);
		txtTitreLivre.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitreLivre.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtTitreLivre.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantité");
		lblNewLabel_3_1.setBounds(33, 63, 111, 43);
		panel_4.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtQteLivre = new JTextField();
		txtQteLivre.setBounds(140, 69, 225, 30);
		panel_4.add(txtQteLivre);
		txtQteLivre.setEditable(false);
		txtQteLivre.setHorizontalAlignment(SwingConstants.CENTER);
		txtQteLivre.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtQteLivre.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.ORANGE, 3));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(412, 577, 442, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon(FrameAccorderEmprunt.class.getResource("/modifierEleveImages/icons8-enregistrer-et-fermer-32.png")));
		btnValider.setBounds(191, 9, 241, 48);
		panel_1.add(btnValider);
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		/*
		 * Clic sur le bouton Valider
		 */
		
		btnValider.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int qteLivre= livre.getQuantite();
				
				boolean empruntPossible= controlerQuantiteLivre(qteLivre);
				
				// Quantite suffisante
				if (empruntPossible) {
					Emprunt emprunt= new Emprunt(eleve, livre);
					int nouvelEmprunt= crudEmprunt.accorderEmprunt(emprunt);
					
					if (nouvelEmprunt==2) {
						
						JOptionPane.showMessageDialog(null, "Nouvel emprunt enregistré avec succès \n\tNuméro d'emprunt: "+emprunt.getId());
						dispose();
					}
					
					else if (nouvelEmprunt==1) {
						JOptionPane.showMessageDialog(null, 
								"L'élève a déjà "+eleve.getNombreEmpruntsEnCours()+" emprunts en cours",
								"Excès d'emprunt",
								JOptionPane.ERROR_MESSAGE);
					}
					
					else {
						JOptionPane.showMessageDialog(null, 
								"Désolé, l'emprunt n'a pas pu être enregistré",
								"Emprunt non enregistré",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		} );
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(FrameAccorderEmprunt.class.getResource("/images/loginImages/cancel.png")));
		btnAnnuler.setBounds(10, 10, 141, 48);
		panel_1.add(btnAnnuler);
		
		/*
		 * Clic sur le bouton annuler
		 */
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annuler();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		

	}
	
	
	
	
	/**
	 * Rechercher un élève à travers un numero de matricule
	 * @param matriculeEleve
	 * @return Eleve
	 */
	public Eleve rechercherEleve(int matriculeEleve) {
		Eleve eleve= null;
		eleve= crudEleve.rechercher(matriculeEleve);
		return eleve;
	}
	
	
	
	/**
	 * Rechercher un livre à travers une  chaine isbn
	 * @param isbn
	 * @return Livre
	 */
	public Livre rechercherLivre(String isbn) {
		Livre livre= null;
		livre= crudLivre.chercherLivre(isbn);
		return livre;
	}
	
	
	/**
	 * Utiliser l'eleve passé en parametre et poursuivre la transaction pour l'emprunt
	 * @param eleve
	 */
	public void controlerEleve(Eleve eleve) {
		
		if (eleve==null) {  // l'élève est introuvable
			JOptionPane.showMessageDialog(null, 
					"L'élève avec la matricule "+spMatriculeEleve.getValue()+" est introuvable dans la base de données",
					"Elève introuvable",
					JOptionPane.ERROR_MESSAGE);
			
			//Afficher uniquement la zone de saisie de la matricule
			setSize(896, 146);
			txtNomEleve.setText("");
			txtClasseEleve.setText("");
			spMatriculeEleve.setValue(0);
			spMatriculeEleve.requestFocus();
		}
		
		else {  //l'élève est trouvé
			
			txtNomEleve.setText(eleve.getNom()+" "+eleve.getPrenom());
			txtClasseEleve.setText(eleve.getClasse());
			
			//Elargir l'interface pour poursuivre l'emprunt vers l'isbn du livre
			setSize(877, 441);
			
			txtIsbnLivre.requestFocus();
			
		}
	}
	
	
	
	/**
	 * Utiliser le livre passé en parametre et poursuivre la transaction pour l'emprunt
	 * @param livre
	 */
	public void controlerLivre(Livre livre) {
		
		if (livre==null) {   //le livre est introuvable
			
			JOptionPane.showMessageDialog(null, 
					"Le livre avec l'indice ISBN: "+txtIsbnLivre.getText()+" est introuvable dans la base de données",
					"Livre introuvable",
					JOptionPane.ERROR_MESSAGE);
			txtIsbnLivre.setText("");
			txtIsbnLivre.requestFocus();
			
			//Masquer les autres infos du livre
			setSize(877, 441);
		}
		
		else {     // l'élève est trouvé
			
			txtTitreLivre.setText(livre.getTitre());
			txtQteLivre.setText(""+livre.getQuantite()+"");
			
			//Elargir l'interface pour poursuivre l'emprunt
			setSize(896, 717);
		}
		
	}
	
	
	
	/**
	 * Enregistrer un emprunt dans la base de données en renvoyant true, false si l'enregistrement n'a pas eu lieu
	 * @param emprunt
	 * @return boolean
	 */
	public int accorderEmprunt(Emprunt emprunt) {
		int accord= 0;
		accord= crudEmprunt.accorderEmprunt(emprunt);
		return accord;
	}
	
	
	
	/**
	 * Verifier si la quantite du livre est suffisante pour permettre un emprunt
	 * @param quantiteLivre
	 * @return boolean
	 */
	public boolean controlerQuantiteLivre(int quantiteLivre) {
		boolean control= false;
		
		if (quantiteLivre <= 0) { //Qté insuffisante pour accorder un emprunt
			JOptionPane.showMessageDialog(null, 
					"Quantité du livre insuffisante",
					"Conditions insatisfaites",
					JOptionPane.ERROR_MESSAGE);
			control= false;
		}
		
		else {  //Qte suffisante;
			
			control= true;
		}
		
		return control;
	}
	
	
	
	/**
	 * Annuler le processus d'accord d'emprunt
	 */
	public void annuler() {
		eleve= null;
		livre= null;
		spMatriculeEleve.setValue(0);
		txtNomEleve.setText("");
		txtClasseEleve.setText("");
		txtIsbnLivre.setText("");
		txtTitreLivre.setText("");
		txtQteLivre.setText("");
		
		spMatriculeEleve.requestFocus();
		
		setSize(896, 146);
	}
}
