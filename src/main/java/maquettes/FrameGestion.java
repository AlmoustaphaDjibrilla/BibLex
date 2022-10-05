package maquettes;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Bibliothecaire;
import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.controle.ControleEmpruntsPenalites;
import com.bibliotheque.ProjetBibliotheque.controle.ControleLivres;
import com.bibliotheque.ProjetBibliotheque.controle.ControleRechercheLivre;
import com.bibliotheque.ProjetBibliotheque.controle.ControlesEleves;
import com.bibliotheque.ProjetBibliotheque.controle.ControlesEmpruntsEffectues;
import com.bibliotheque.ProjetBibliotheque.controle.ControlesEmpruntsEnCours;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;

import maquettes.gestionEleves.FrameAjoutEleve;
import maquettes.gestionEleves.FrameModifierEleve;
import maquettes.gestionEmprunts.FrameAccorderEmprunt;
import maquettes.gestionEmprunts.FrameRestituerEmprunt;
import maquettes.gestionLivres.FrameAjoutLivre;
import maquettes.gestionLivres.FrameAugmenterQuantiteLivre;
import javax.swing.JTextField;

public class FrameGestion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuGererEmprunts;
	private JMenu menuConsultationEmprunts;
	private JMenu menuGestionLivres;
	private Component horizontalStrut_1;
	private JMenu menuConsultationLivres;
	private Component horizontalStrut_2;
	private JMenu menuGestionEleves;
	private Component horizontalStrut_3;
	private JMenu menuRechercherLivres;
	private Component horizontalStrut_4;
	private JLabel lblBib;
	private JMenuItem mnAugmenterQteLivre;
	private JMenuItem mnLivresAbimes;
	private JMenuItem mnLivresBonEtats;
	private JMenuItem mnAccorderEmprunt;
	private JMenuItem mnRestituerEmprunt;
	private JMenuItem mnEmpruntEnCours;
	private JMenuItem mnEmpruntEffectues;
	private JMenu mnAjoutLivres;
	private JMenuItem mnNouveauLivre;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mnModifierEleve;

	
	private Bibliothecaire bib;
	private JButton btnQuitter;
	
	private FrameEmprunt emprunt;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	private ControlesEleves controleEleve;
	private ControlesEmpruntsEnCours controleEmpruntCours;
	private ControlesEmpruntsEffectues ctrEmpEffectues;
	private ControleLivres controleLivres;
	private ControleRechercheLivre controleRechercheLivre;
	private ControleEmpruntsPenalites controleEmpruntsPenalites;
	
	private JLabel titreTable;
	private JPanel panel;
	private JTextField txtRecherche;
	
	private final Action actionGestionEmprunt= new GestionEmpruntAction();
	private final Action actionRechercherLivres= new ActionRechercheLivre();
	private JMenuItem mnRechercheLivre;
	private Component verticalStrut_5;
	private JMenuItem mnPlusFrequentes;
	private Component verticalStrut_6;
	private JMenuItem mnMoinsFrequentes;
	private JMenu menuConsultationEleves;
	private Component horizontalStrut_5;
	private JMenuItem mnAfficherTousEleves;
	private JMenuItem mnElevesPenalites;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					FrameGestion frame = new FrameGestion();
					frame.setTitle("Ecran principal");
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameGestion() {
		
		controleEleve= new ControlesEleves();
		controleEmpruntCours= new ControlesEmpruntsEnCours();
		ctrEmpEffectues= new ControlesEmpruntsEffectues();
		controleLivres= new ControleLivres();
		controleEmpruntsPenalites= new ControleEmpruntsPenalites();
		
		//Definir le nom du bibliothecaire dans le label
		//lblBib.setText(bib.getNom().toString());
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1364, 691);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(101, 10, 1243, 59);
		contentPane.add(menuBar);
		
		menuGererEmprunts = new JMenu("Gérer emprunts");
		menuGererEmprunts.setAction(actionGestionEmprunt);
		menuGererEmprunts.setBackground(new Color(105, 105, 105));
		menuGererEmprunts.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/documents-folder.png")));
		menuGererEmprunts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuGererEmprunts);
		
		mnAccorderEmprunt = new JMenuItem("Accorder emprunt");
		
		/*
		 * Clic sur le menu acoorder emprunt
		 */
		
		mnAccorderEmprunt.addActionListener( new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				emprunt();
			}
			
		});
		mnAccorderEmprunt.setForeground(Color.RED);
		mnAccorderEmprunt.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-donner-un-cadeau-32.png")));
		mnAccorderEmprunt.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuGererEmprunts.add(mnAccorderEmprunt);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		menuGererEmprunts.add(verticalStrut);
		
		mnRestituerEmprunt = new JMenuItem("Restituer emprunt");
		
		/*
		 * Clic sur le bouton restituer emprunt
		 */
		mnRestituerEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				restituerEmprunt();
			}
		});
		mnRestituerEmprunt.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-rendre-un-livre-32.png")));
		mnRestituerEmprunt.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuGererEmprunts.add(mnRestituerEmprunt);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut);
		
		menuConsultationEmprunts = new JMenu("Consulter emprunts");
		menuConsultationEmprunts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuConsultationEmprunts.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/contact-book.png")));
		menuBar.add(menuConsultationEmprunts);
		
		mnEmpruntEnCours = new JMenuItem("En cours...");
		
		/*
		 * Afficher emprunts en cours
		 */
		
		mnEmpruntEnCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherEmpruntsCours();
			}
		});
		mnEmpruntEnCours.setForeground(Color.RED);
		mnEmpruntEnCours.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-en-cours-32.png")));
		mnEmpruntEnCours.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuConsultationEmprunts.add(mnEmpruntEnCours);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		menuConsultationEmprunts.add(verticalStrut_1);
		
		mnEmpruntEffectues = new JMenuItem("Effectués");
		
		/*
		 * Afficher les emprunts effectués
		 */
		
		mnEmpruntEffectues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				afficherEmpruntsEffectues();
			}
		});
		mnEmpruntEffectues.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnEmpruntEffectues.setBackground(Color.LIGHT_GRAY);
		mnEmpruntEffectues.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-ok-32.png")));
		menuConsultationEmprunts.add(mnEmpruntEffectues);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_1);
		
		menuGestionLivres = new JMenu("Gérer livres");
		menuGestionLivres.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/books-stack-of-three.png")));
		menuGestionLivres.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuGestionLivres);
		
		mnAjoutLivres = new JMenu("Ajouter livres");
		mnAjoutLivres.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuGestionLivres.add(mnAjoutLivres);
		
		mnNouveauLivre = new JMenuItem("Nouveau livre");
		mnNouveauLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ajoutLivre();
			}
		});
		mnNouveauLivre.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-new-32.png")));
		mnNouveauLivre.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnAjoutLivres.add(mnNouveauLivre);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		mnAjoutLivres.add(verticalStrut_2);
		
		mnAugmenterQteLivre = new JMenuItem("Augmenter quantité");
		mnAugmenterQteLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				augmenterQuantiteLivre();
			}
		});
		mnAugmenterQteLivre.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/ajouter-le-fichier.png")));
		mnAugmenterQteLivre.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnAjoutLivres.add(mnAugmenterQteLivre);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_2);
		
		menuConsultationLivres = new JMenu("Consulter livres\r\n");
		menuConsultationLivres.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/search.png")));
		menuConsultationLivres.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuConsultationLivres);
		
		mnLivresAbimes = new JMenuItem("Abîmés\r\n");
		mnLivresAbimes.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/papier.png")));
		mnLivresAbimes.setForeground(Color.RED);
		mnLivresAbimes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuConsultationLivres.add(mnLivresAbimes);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		menuConsultationLivres.add(verticalStrut_3);
		
		mnLivresBonEtats = new JMenuItem("Bon état");
		
		/*
		 * Afficher les livres dans la table
		 */
		
		mnLivresBonEtats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				afficherLivres();
			}
		});
		mnLivresBonEtats.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/shield.png")));
		mnLivresBonEtats.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuConsultationLivres.add(mnLivresBonEtats);
		
		verticalStrut_5 = Box.createVerticalStrut(20);
		menuConsultationLivres.add(verticalStrut_5);
		
		mnPlusFrequentes = new JMenuItem("Plus frequentés");
		mnPlusFrequentes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/*
		 * Afficher les livres les plus frequentrés
		 */
		
		mnPlusFrequentes.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				afficherLivresPlusFrequentes();
			}
		} );
		
		menuConsultationLivres.add(mnPlusFrequentes);
		
		verticalStrut_6 = Box.createVerticalStrut(20);
		menuConsultationLivres.add(verticalStrut_6);
		
		mnMoinsFrequentes = new JMenuItem("Moins frequentés");
		
		/*
		 * Afficher les livres moins frequentéqs
		 */
		mnMoinsFrequentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				afficherLivresMoinsFrequentes();
			}
		});
		mnMoinsFrequentes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuConsultationLivres.add(mnMoinsFrequentes);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_3);
		
		menuGestionEleves = new JMenu("Gérer élèves");
		menuGestionEleves.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-modifier-le-compte-32.png")));
		menuGestionEleves.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuGestionEleves);
		
		mntmNewMenuItem = new JMenuItem("Nouvel élève");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutEleve();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/graduated.png")));
		mntmNewMenuItem.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuGestionEleves.add(mntmNewMenuItem);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		menuGestionEleves.add(verticalStrut_4);
		
		mnModifierEleve = new JMenuItem("Modifier élève");
		mnModifierEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierEleve();
			}
		});
		mnModifierEleve.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/updating.png")));
		mnModifierEleve.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuGestionEleves.add(mnModifierEleve);
		
		horizontalStrut_4 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_4);
		
		menuConsultationEleves = new JMenu("Consulter Elèves");
		menuConsultationEleves.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/group.png")));
		menuConsultationEleves.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuConsultationEleves);
		
		mnAfficherTousEleves = new JMenuItem("Tous les élèves");
		mnAfficherTousEleves.setForeground(new Color(0, 100, 0));
		
		/*
		 * Clic pour afficher tous les élèves dans la table
		 */
		
		mnAfficherTousEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				afficherEleves();
			}
		});
		mnAfficherTousEleves.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuConsultationEleves.add(mnAfficherTousEleves);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		menuConsultationEleves.add(verticalStrut_7);
		
		mnElevesPenalites = new JMenuItem("Elèves en pénalité");
		
		/*
		 * Afficher les emprunts en pénalité
		 */
		
		mnElevesPenalites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherEmpruntsPenalites();
			}
		});
		mnElevesPenalites.setForeground(new Color(255, 0, 0));
		mnElevesPenalites.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuConsultationEleves.add(mnElevesPenalites);
		
		horizontalStrut_5 = Box.createHorizontalStrut(20);
		menuBar.add(horizontalStrut_5);
		
		menuRechercherLivres = new JMenu("Rechercher livres");
		menuRechercherLivres.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/search (1).png")));
		menuRechercherLivres.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuRechercherLivres.setAction(actionRechercherLivres);
		menuBar.add(menuRechercherLivres);
		
		mnRechercheLivre = new JMenuItem("Rechercher des livres");
		mnRechercheLivre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				txtRecherche.requestFocus();
			}
		});
		menuRechercherLivres.add(mnRechercheLivre);
		
		lblBib = new JLabel("Bonjour");
		lblBib.setBackground(new Color(255, 200, 0));
		lblBib.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/user (1).png")));
		lblBib.setForeground(Color.WHITE);
		lblBib.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBib.setBounds(0, 10, 91, 59);
		contentPane.add(lblBib);
		
		btnQuitter = new JButton("");
		btnQuitter.setToolTipText("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.setIcon(new ImageIcon(FrameGestion.class.getResource("/ecranPrincipale/icons8-fermer-la-fenêtre-32.png")));
		btnQuitter.setBounds(1287, 622, 63, 32);
		contentPane.add(btnQuitter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 172, 1245, 418);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		titreTable = new JLabel("");
		titreTable.setHorizontalAlignment(SwingConstants.CENTER);
		titreTable.setForeground(Color.WHITE);
		titreTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titreTable.setBackground(Color.ORANGE);
		titreTable.setBounds(101, 117, 946, 45);
		contentPane.add(titreTable);
		
		panel = new JPanel();
		panel.setBounds(1057, 79, 287, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtRecherche = new JTextField();
		txtRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecherche.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtRecherche.setBounds(10, 10, 197, 44);
		panel.add(txtRecherche);
		txtRecherche.setColumns(10);
		
		JButton btnValiderRecherche = new JButton("Ok");
		btnValiderRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				rechercheLivre(txtRecherche.getText());
			}
		});
		btnValiderRecherche.setBounds(217, 10, 60, 44);
		panel.add(btnValiderRecherche);
		
		JButton btnChangerPassword = new JButton("Changer mot de passe");
		btnChangerPassword.setToolTipText("Changer votre mot de passe");
		btnChangerPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameModifierPassword changePassword= new FrameModifierPassword();
				changePassword.setVisible(true);
			}
		});
		btnChangerPassword.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnChangerPassword.setBounds(0, 611, 116, 43);
		contentPane.add(btnChangerPassword);
		panel.setVisible(false);
		
		afficherEleves();
	}
	
	public void emprunt() {
		FrameAccorderEmprunt emprunt= new FrameAccorderEmprunt();
		emprunt.setVisible(true);
		
	}
	
	
	/*
	 * Cette méthode permet d'ajouter un nouvel élève à la base de données
	 */
	public void ajoutEleve() {
		FrameAjoutEleve ajouEl= new FrameAjoutEleve();
		this.setVisible(false);
		ajouEl.setVisible(true);
	}
	
	
	/**
	 * Cette méthode permet de modifier les infos d'un élève déja enregistré dans la base de données
	 */
	public void modifierEleve() {
		FrameModifierEleve modifier= new FrameModifierEleve();
		modifier.setVisible(true);
	}
	
	/**
	 * Cette méthode permet d'ajouter un nouveau livre dans la BD
	 */
	public void ajoutLivre() {
		FrameAjoutLivre ajoutLivre= new FrameAjoutLivre();
		ajoutLivre.setVisible(true);
	}
	
	
	/**
	 * 	Cette méthode permet d'augmenter la quantité d'un livre
	 */
	public void augmenterQuantiteLivre() {
		
		FrameAugmenterQuantiteLivre augmenter= new FrameAugmenterQuantiteLivre();
		augmenter.setVisible(true);
	}
	
	
	/**
	 * Cette méthode permet de restituer un emprunt
	 */
	public void restituerEmprunt() {
		
		FrameRestituerEmprunt restituer= new FrameRestituerEmprunt();
		restituer.setVisible(true);
	}
	
	
	
	/**
	 * Afficher tous les eleves dans une table
	 */
	public void afficherEleves() {
		controleLivres.chargerLivresBonEtats();
		table.setModel(controleEleve.getModeleEleves());
		titreTable.setText("Tous les élèves");
	}
	
	
	/**
	 * Afficher les livres les plus frequentés
	 */
	public void afficherLivresPlusFrequentes() {
		controleLivres.chargerLivresPlusFrequentes();
		table.setModel(controleLivres.getModeleLivre());
		titreTable.setText("Les livres les plus empruntés");
	}
	
	
	/**
	 * Afficher les livres les moins frequentés
	 */
	public void afficherLivresMoinsFrequentes() {
		
		controleLivres.chargerLivresMoinsFrequentes();
		table.setModel(controleLivres.getModeleLivre());
		titreTable.setText("Les livres les moins frequentés");
	}
	
	/**
	 * Afficher les emprunts en cours dans la table
	 */
	public void afficherEmpruntsCours() {
		table.setModel(controleEmpruntCours.getModeleEmpruntsCours());
		titreTable.setText("Les emprunts en cours (non rendus) ");
	}
	
	
	/**
	 * Afficher les emprunts effectués dans la table
	 */
	public void afficherEmpruntsEffectues() {
		table.setModel(ctrEmpEffectues.getModeleEmprunsEffectues());
		titreTable.setText("Les emprunts effectués (rendus) ");
	}
	
	
	/**
	 * Afficher les livres dans la table
	 */
	public void afficherLivres() {
		table.setModel(controleLivres.getModeleLivre());
		titreTable.setText("Les livres enregistrés");
	}
	
	
	/**
	 * Afficher les emprunts en pénalité
	 */
	public void afficherEmpruntsPenalites() {
		table.setModel(controleEmpruntsPenalites.getModelesEmpruntsPenalites());
		titreTable.setText("Les emprunts en pénalité");
	}
	
	public void rechercheLivre(String motRecherche) {
		controleRechercheLivre= new ControleRechercheLivre(motRecherche);
		table.setModel(controleRechercheLivre.getModRechLivre());
		titreTable.setText("Résultats de la recherche");
		txtRecherche.setText("");
		panel.setVisible(false);
	}
	
	
	private class GestionEmpruntAction extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
		
		public GestionEmpruntAction() {
			putValue(NAME, "Gérer les emprunts");
			putValue(SHORT_DESCRIPTION, "Accorder ou restituer un emprunt");
		}
	}
	
	
	
	private class ActionRechercheLivre extends AbstractAction{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
		public ActionRechercheLivre() {
			putValue(SHORT_DESCRIPTION, "Rechercher des livres par un indice de recherche");
			putValue(NAME, "Rechercher des livres");
		}
	}



	public ControleLivres getControleLivres() {
		return controleLivres;
	}

	public void setControleLivres(ControleLivres controleLivres) {
		this.controleLivres = controleLivres;
	}
}
