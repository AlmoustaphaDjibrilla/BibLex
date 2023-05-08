package maquettes.gestionEleves;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Classe;
import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.controle.ControlesEleves;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;

import maquettes.FrameGestion;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class FrameAjoutEleve extends JDialog {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomEleve;
	private JTextField txtPrenomEleve;
	private JList<String> list;
	private JSpinner spMatriculeEleve;
	private CRUDEleve crudEleve;
	private ControlesEleves controlesEleves;
	private JLabel lblPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrameAjoutEleve dialog = new FrameAjoutEleve();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrameAjoutEleve() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAjoutEleve.class.getResource("/ajoutEleveImages/nom.png")));
		
		crudEleve= new CRUDEleve();
		controlesEleves= new ControlesEleves();
		
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		setModal(true);
		setDefaultCloseOperation(quitter());
		setTitle("Ajouter un nouvel élève");
		
		getContentPane().setBackground(new Color(255, 127, 80));
		setBounds(100, 100, 962, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Matricule\r\n");
			lblNewLabel.setForeground(new Color(255, 160, 122));
			lblNewLabel.setIcon(new ImageIcon(FrameAjoutEleve.class.getResource("/ajoutEleveImages/carte-didentite (1).png")));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(60, 6, 129, 62);
			contentPanel.add(lblNewLabel);
		}
		
		spMatriculeEleve = new JSpinner();
		spMatriculeEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		spMatriculeEleve.setBounds(199, 21, 353, 32);
		contentPanel.add(spMatriculeEleve);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(new Color(255, 160, 122));
		lblNewLabel_1.setIcon(new ImageIcon(FrameAjoutEleve.class.getResource("/ajoutEleveImages/carte-didentite (3).png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 78, 108, 48);
		contentPanel.add(lblNewLabel_1);
		
		txtNomEleve = new JTextField();
		txtNomEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNomEleve.setBounds(199, 85, 353, 34);
		contentPanel.add(txtNomEleve);
		txtNomEleve.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prénom");
		lblNewLabel_2.setForeground(new Color(255, 160, 122));
		lblNewLabel_2.setIcon(new ImageIcon(FrameAjoutEleve.class.getResource("/ajoutEleveImages/carte-didentite (2).png")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(60, 158, 108, 26);
		contentPanel.add(lblNewLabel_2);
		
		txtPrenomEleve = new JTextField();
		txtPrenomEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPrenomEleve.setColumns(10);
		txtPrenomEleve.setBounds(199, 154, 353, 34);
		contentPanel.add(txtPrenomEleve);
		
		JLabel lblNewLabel_3 = new JLabel("Classe");
		lblNewLabel_3.setForeground(new Color(255, 160, 122));
		lblNewLabel_3.setIcon(new ImageIcon(FrameAjoutEleve.class.getResource("/ajoutEleveImages/salle-de-classe.png")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(56, 251, 135, 83);
		contentPanel.add(lblNewLabel_3);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setModel(new AbstractListModel<String>() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			String[] values = new String[] {"SECONDE_C1", "SECONDE_C2", "PREMIERE_C", "PREMIERE_D", "TERMINALE_C", "TERMINALE_D"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		list.setBounds(199, 240, 129, 128);
		contentPanel.add(list);
		
		JButton btnAjouterEleve = new JButton("Ajouter\r\n");
		btnAjouterEleve.setIcon(new ImageIcon(FrameAjoutEleve.class.getResource("/ajoutEleveImages/icons8-ajouter-un-groupe-d'utilisateurs-homme-homme-32.png")));
		btnAjouterEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleve eleve= creer();
				if (eleve==null) {
					JOptionPane.showMessageDialog(null, "Les données saisies ne sont pas compatibles", "Problème rencontré", JOptionPane.ERROR_MESSAGE);
					reinitialiser();
				}
				else {
					//boolean creation= crudEleve.creer(eleve);
					boolean creation= controlesEleves.ajouterEleve(eleve);
					if (creation==true) {
						JOptionPane.showMessageDialog(null, eleve.getNom()+" ajouté(e)");
						reinitialiser();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Ajout non effectué", "Problème rencontré", JOptionPane.ERROR_MESSAGE);
						reinitialiser();
					}
				}
			}
		});
		btnAjouterEleve.setBounds(423, 386, 129, 48);
		contentPanel.add(btnAjouterEleve);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBackground(Color.DARK_GRAY);
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setIcon(new ImageIcon(FrameAjoutEleve.class.getResource("/modifierEleveImages/man (1).png")));
		lblPhoto.setBorder(new LineBorder(Color.ORANGE, 2));
		lblPhoto.setBounds(562, 21, 376, 403);
		contentPanel.add(lblPhoto);
		
		
	}
	
	/**
	 * Cette méthode permet de recuperer les donées saisies pour pouvoir créer yn nouvel élève
	 * @return Eleve
	 */
	public Eleve creer() {
		
		Eleve eleve;
		
		int indice= list.getSelectedIndex();
		String []val= {"SECONDE_C1", "SECONDE_C2", "PREMIERE_C", "PREMIERE_D", "TERMINALE_C", "TERMINALE_D"};
		//System.out.println("la classe choisie est: "+val[indice]);
		
		int mat=(Integer) spMatriculeEleve.getValue();
		String nom= txtNomEleve.getText();
		String prenom= txtPrenomEleve.getText();
		String classe= val[indice];
		
		
		if (mat==0 || nom==null || prenom==null || classe==null) {
			eleve= null;
		}
		else {
			eleve= new Eleve(mat, nom, prenom, classe);
		}
		
		return eleve;
	}
	
	
	/**
	 * Cette méthode va automatiquement réinitialiser les differents champs d'entrées
	 */
	public void reinitialiser() {
		spMatriculeEleve.setValue(0);
		txtNomEleve.setText("");
		txtPrenomEleve.setText("");
	}
	
	
	/**
	 * Cette méthode gère l'évenement où le bibliothecaire clique le boutton quitter
	 * La méthode ferme cette interface et ouvre l'interface de gestion
	 * @return int
	 */
	public int quitter() {
		int retour= JDialog.DISPOSE_ON_CLOSE;
		FrameGestion gestion= new FrameGestion();
		gestion.setVisible(true);
		return retour;
	}
}
