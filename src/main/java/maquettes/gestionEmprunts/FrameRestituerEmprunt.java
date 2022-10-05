package maquettes.gestionEmprunts;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.Entity.Emprunt;
import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEmprunt;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class FrameRestituerEmprunt extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField txtMatriculeEleve;
	private JTextField txtNomEleve;
	private JTextField txtClasseEleve;
	private JTextField txtIsbnLivre;
	private JTextField txtTitreLivre;
	private JTextField txtQuantiteLivre;
	private JSpinner spIdEmprunt;
	private JButton btnRechercherEmprunt;
	private JButton btnAnnuler;
	private JButton btnRestituer;
	
	private CRUDEmprunt crudEmprunt;
	
	
	private Emprunt emprunt;
	private Livre livre;
	private Eleve eleve;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRestituerEmprunt frame = new FrameRestituerEmprunt();
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
	public FrameRestituerEmprunt() {
		
		/*
		 * Initialiser le crud Emprunt
		 */
		crudEmprunt= new CRUDEmprunt();

		emprunt= null;
		livre= null;
		eleve= null;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 787, 663);
		setTitle("Restituer un emprunt");
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.CYAN, 3));
		panel.setBounds(10, 10, 753, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N° Emprunt");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(53, 10, 115, 37);
		panel.add(lblNewLabel);
		
		spIdEmprunt = new JSpinner();
		spIdEmprunt.setFont(new Font("Tahoma", Font.BOLD, 18));
		spIdEmprunt.setBounds(225, 13, 219, 37);
		panel.add(spIdEmprunt);
		
		btnRechercherEmprunt = new JButton("Rechercher");
		
		/*
		 * Clic sur le bouton rechercher Emprunt
		 */
		
		btnRechercherEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id= (Integer) spIdEmprunt.getValue();
				emprunt= chercherEmprunt(id);
				remplirChamp(emprunt);
			}
		});
		btnRechercherEmprunt.setIcon(new ImageIcon(FrameRestituerEmprunt.class.getResource("/frameEmpruntImages/icons8-google-web-recherche-32.png")));
		btnRechercherEmprunt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRechercherEmprunt.setBounds(499, 10, 248, 37);
		panel.add(btnRechercherEmprunt);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informations sur l'\u00E9l\u00E8ve", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 107, 747, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Matricule");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(49, 23, 76, 41);
		panel_1.add(lblNewLabel_1);
		
		txtMatriculeEleve = new JTextField();
		txtMatriculeEleve.setEditable(false);
		txtMatriculeEleve.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatriculeEleve.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMatriculeEleve.setBounds(163, 26, 554, 32);
		panel_1.add(txtMatriculeEleve);
		txtMatriculeEleve.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(49, 74, 76, 41);
		panel_1.add(lblNewLabel_1_1);
		
		txtNomEleve = new JTextField();
		txtNomEleve.setEditable(false);
		txtNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomEleve.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtNomEleve.setColumns(10);
		txtNomEleve.setBounds(163, 77, 554, 32);
		panel_1.add(txtNomEleve);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Classe");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(49, 120, 76, 41);
		panel_1.add(lblNewLabel_1_1_1);
		
		txtClasseEleve = new JTextField();
		txtClasseEleve.setEditable(false);
		txtClasseEleve.setHorizontalAlignment(SwingConstants.CENTER);
		txtClasseEleve.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtClasseEleve.setColumns(10);
		txtClasseEleve.setBounds(163, 123, 554, 32);
		panel_1.add(txtClasseEleve);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Informations sur le livre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 320, 747, 171);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ISBN");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(50, 22, 76, 41);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		txtIsbnLivre = new JTextField();
		txtIsbnLivre.setEditable(false);
		txtIsbnLivre.setHorizontalAlignment(SwingConstants.CENTER);
		txtIsbnLivre.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtIsbnLivre.setColumns(10);
		txtIsbnLivre.setBounds(160, 25, 554, 32);
		panel_2.add(txtIsbnLivre);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Titre");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(50, 73, 76, 41);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		
		txtTitreLivre = new JTextField();
		txtTitreLivre.setEditable(false);
		txtTitreLivre.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitreLivre.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTitreLivre.setColumns(10);
		txtTitreLivre.setBounds(160, 74, 554, 32);
		panel_2.add(txtTitreLivre);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Quantité");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(50, 120, 76, 41);
		panel_2.add(lblNewLabel_1_1_1_1_1_1);
		
		txtQuantiteLivre = new JTextField();
		txtQuantiteLivre.setEditable(false);
		txtQuantiteLivre.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantiteLivre.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtQuantiteLivre.setColumns(10);
		txtQuantiteLivre.setBounds(160, 123, 554, 32);
		panel_2.add(txtQuantiteLivre);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.CYAN, 3));
		panel_3.setBounds(367, 526, 387, 73);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(FrameRestituerEmprunt.class.getResource("/images/loginImages/cancel.png")));
		btnAnnuler.setBounds(10, 10, 132, 53);
		panel_3.add(btnAnnuler);
		
		btnRestituer = new JButton("Restituer");
		
		/*
		 * Clic sur le bouton restituer emprunt
		 */
		
		btnRestituer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean restituer = restituerEmprunt(emprunt);
				if (restituer) {
					JOptionPane.showMessageDialog(null, "L'emprunt "+emprunt.getId()+" restitué avec succès");
					
					boolean conforme= dateRetourConforme(emprunt);
					
					if (conforme) {
						JOptionPane.showMessageDialog(null, "Emprunt remis dans les normes");
					}
					else {
						JOptionPane.showMessageDialog(null, "Emprunt remis en retard", "Alerte retard", JOptionPane.WARNING_MESSAGE);
					}
					
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Restitution non effectuée", "Problème rencontré", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRestituer.setIcon(new ImageIcon(FrameRestituerEmprunt.class.getResource("/ecranPrincipale/icons8-ok-32.png")));
		btnRestituer.setBounds(163, 10, 214, 53);
		panel_3.add(btnRestituer);
	}
	

	/**
	 * Chercher un emprunt grâce à son ID
	 * @param id
	 * @return Emprunt
	 */
	public Emprunt chercherEmprunt(int id) {
		Emprunt emprunt= crudEmprunt.chercherEmprunt(id);
		return emprunt;
	}
	
	
	
	/**
	 * Remplir les differents avec les infos de l'emprunt
	 * @param emprunt2
	 */
	protected void remplirChamp(Emprunt emprunt) {
		// TODO Auto-generated method stub
		
		if (emprunt!= null) {
			
			eleve= emprunt.getEleve();
			livre= emprunt.getLivre();
			
			
			// remplir les champs de l'élève
			txtMatriculeEleve.setText(eleve.getMatricule()+"");
			txtNomEleve.setText(eleve.getNom()+" "+eleve.getPrenom());
			txtClasseEleve.setText(eleve.getClasse());
			
			
			// remplir les champs du livre
			txtIsbnLivre.setText(livre.getIsbn());
			txtTitreLivre.setText(livre.getTitre());
			txtQuantiteLivre.setText(livre.getQuantite()+"");
			
			btnRestituer.setEnabled(true);
		}
		
		else {
			
			reinitialiser();
		}
		
	}
	
	
	
	/**
	 * Cette méthode permet de reinitialiser les differents champs 
	 */
	public void reinitialiser() {
		
		eleve= null;
		livre= null;
		
		// reinitialiser les champs de l'élève
		txtMatriculeEleve.setText("");
		txtNomEleve.setText("");
		txtClasseEleve.setText("");
					
					
		// reinitialiser les champs du livre
		txtIsbnLivre.setText("");
		txtTitreLivre.setText("");
		txtQuantiteLivre.setText("");
		
		btnRestituer.setEnabled(false);
	}
	
	
	
	/**
	 * Restituer un emprunt passé en paramètre
	 * @param emprunt
	 * @return boolean
	 */
	public boolean restituerEmprunt(Emprunt emprunt) {
		boolean restituer= false;
		restituer= crudEmprunt.restituerEmprunt(emprunt);
		return restituer;
	}
	
	
	
	
	/**
	 * Controler si un emprunt est remis dans les délais ou non
	 * @param emprunt
	 * @return boolean
	 */
	public boolean dateRetourConforme(Emprunt emprunt) {
		boolean conforme= false;
		
		if (emprunt!=null) {
			
			String dateRetour= emprunt.getDateRetour();
			
			LocalDate retour= LocalDate.parse(dateRetour);
			
			LocalDate maintenant= LocalDate.now();
			
			if ( maintenant.isAfter(retour) ) {
				conforme=false;
			}
			
			else {
				conforme= true;
			}
		}
		
		return conforme;
	}
}
