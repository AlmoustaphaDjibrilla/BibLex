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
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;

import maquettes.FrameGestion;

import javax.swing.ImageIcon;

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
		
		crudEleve= new CRUDEleve();
		
		
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		setModal(true);
		setDefaultCloseOperation(quitter());
		setTitle("Ajouter un nouvel élève");
		
		getContentPane().setBackground(new Color(255, 127, 80));
		setBounds(100, 100, 581, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 127, 80));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Matricule\r\n");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(81, 6, 108, 41);
			contentPanel.add(lblNewLabel);
		}
		
		spMatriculeEleve = new JSpinner();
		spMatriculeEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		spMatriculeEleve.setBounds(199, 10, 209, 32);
		contentPanel.add(spMatriculeEleve);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(81, 78, 83, 32);
		contentPanel.add(lblNewLabel_1);
		
		txtNomEleve = new JTextField();
		txtNomEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNomEleve.setBounds(199, 77, 209, 34);
		contentPanel.add(txtNomEleve);
		txtNomEleve.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prénom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(81, 148, 83, 26);
		contentPanel.add(lblNewLabel_2);
		
		txtPrenomEleve = new JTextField();
		txtPrenomEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPrenomEleve.setColumns(10);
		txtPrenomEleve.setBounds(199, 144, 209, 34);
		contentPanel.add(txtPrenomEleve);
		
		JLabel lblNewLabel_3 = new JLabel("Classe");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(81, 265, 69, 22);
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
		
		list.setBounds(199, 218, 129, 128);
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
					boolean creation= crudEleve.creer(eleve);
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
		btnAjouterEleve.setBounds(438, 308, 129, 48);
		contentPanel.add(btnAjouterEleve);
		
		
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
