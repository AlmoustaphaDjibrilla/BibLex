package maquettes.gestionEleves;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Eleve;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDEleve;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrameModifierEleve extends JDialog {

	/**
	 * 
	 */
	String[] values = new String[] {"SECONDE_C1", "SECONDE_C2", "PREMIERE_C", "PREMIERE_D", "TERMINALE_C", "TERMINALE_D"};
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomEleve;
	private JTextField txtPrenomEleve;
	private JList list;
	private JSpinner spMatriculeEleve;
	private JLabel lblPrenom;
	private JButton btnRechercher;
	private JButton btnEnregistrer;
	
	private CRUDEleve crud;

	private int ancienMatricule;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrameModifierEleve dialog = new FrameModifierEleve();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameModifierEleve() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameModifierEleve.class.getResource("/modifierEleveImages/bouton-modifier.png")));
		
		crud= new CRUDEleve();
		
		
		setModal(true);
		setBounds(100, 100, 760, 454);
		setTitle("Modifier les informations d'un élève");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("Matricule de l'élève");
			lblNewLabel.setForeground(new Color(255, 160, 122));
			lblNewLabel.setIcon(new ImageIcon(FrameModifierEleve.class.getResource("/ajoutEleveImages/carte-didentite (1).png")));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(36, 11, 223, 39);
			contentPanel.add(lblNewLabel);
		
			spMatriculeEleve = new JSpinner();
			spMatriculeEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
			spMatriculeEleve.setBounds(269, 10, 251, 39);
			contentPanel.add(spMatriculeEleve);
		
		
			JLabel lblNewLabel_1 = new JLabel("Nom");
			lblNewLabel_1.setForeground(new Color(255, 160, 122));
			lblNewLabel_1.setIcon(new ImageIcon(FrameModifierEleve.class.getResource("/ajoutEleveImages/carte-didentite (3).png")));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_1.setBounds(33, 110, 82, 31);
			contentPanel.add(lblNewLabel_1);
		
			txtNomEleve = new JTextField();
			txtNomEleve.setEnabled(false);
			txtNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
			txtNomEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtNomEleve.setBounds(173, 105, 563, 39);
			contentPanel.add(txtNomEleve);
			txtNomEleve.setColumns(10);
		
		
			
			lblPrenom = new JLabel("Prénom");
			lblPrenom.setForeground(new Color(255, 160, 122));
			lblPrenom.setIcon(new ImageIcon(FrameModifierEleve.class.getResource("/ajoutEleveImages/carte-didentite (2).png")));
			lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblPrenom.setBounds(33, 178, 114, 31);
			contentPanel.add(lblPrenom);
		
		
			txtPrenomEleve = new JTextField();
			txtPrenomEleve.setEnabled(false);
			txtPrenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
			txtPrenomEleve.setFont(new Font("Tahoma", Font.BOLD, 20));
			txtPrenomEleve.setColumns(10);
			txtPrenomEleve.setBounds(173, 173, 563, 39);
			contentPanel.add(txtPrenomEleve);
		
			JLabel lblNewLabel_2 = new JLabel("Classe");
			lblNewLabel_2.setForeground(new Color(255, 160, 122));
			lblNewLabel_2.setIcon(new ImageIcon(FrameModifierEleve.class.getResource("/ecranPrincipale/training.png")));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_2.setBounds(33, 299, 130, 83);
			contentPanel.add(lblNewLabel_2);
		
			list = new JList();
			list.setEnabled(false);
			list.setFont(new Font("Tahoma", Font.PLAIN, 20));
			list.setBounds(173, 255, 169, 162);
			list.setModel( new AbstractListModel() {
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			//String[] values = new String[] {"SECONDE_C1", "SECONDE_C2", "PREMIERE_C", "PREMIERE_D", "TERMINALE_C", "TERMINALE_D"};
			
			public int getSize() {
				return values.length;
			}
			
			
			public Object getElementAt(int index) {
				return values[index];
			}
			
			public int chercher(String val) {
				Integer position = null;
				
				for (int i=0; i<values.length; i++) {
					if (values[i].equals(val)) {
						position= i;
						break;
					}
				}
				return position;
			}
			});
			contentPanel.add(list);
		
			btnRechercher = new JButton("Rechercher");
			btnRechercher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Eleve eleve= chercher( (Integer) spMatriculeEleve.getValue());
					ancienMatricule= (Integer) spMatriculeEleve.getValue();
					remplirChamp(eleve);
				}
			});
			btnRechercher.setIcon(new ImageIcon(FrameModifierEleve.class.getResource("/ecranPrincipale/searching.png")));
			btnRechercher.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnRechercher.setBounds(570, 0, 176, 80);
			contentPanel.add(btnRechercher);
		
			btnEnregistrer = new JButton("Enregistrer");
			btnEnregistrer.setEnabled(false);
			
			//gerer le clic sur le boutton Enregistrer
			btnEnregistrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int matricule= (Integer) spMatriculeEleve.getValue();
					Eleve nouvelEleve= nouvelEleve();
					
					if (nouvelEleve!=null) { // Assurer que tous les champs sont saisis
						
						boolean modifier= modifier(ancienMatricule, nouvelEleve);
						
						if (modifier==true) { // la modification a eu lieu au niveau de la BD
							
							JOptionPane.showMessageDialog(null, "Modification effectuée avec succès");
							dispose();
						}
						else { // la modification n'a pas eu lieu au niveau de la BD
							
							JOptionPane.showMessageDialog(null, "Modification non effectuée", "Problème rencontré", JOptionPane.ERROR_MESSAGE);
						}
					}
					
					else { // Les champs ne sont pas tous corrects
						JOptionPane.showMessageDialog(null, "Modification non effectuée", "Problème rencontré", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnEnregistrer.setIcon(new ImageIcon(FrameModifierEleve.class.getResource("/modifierEleveImages/icons8-enregistrer-et-fermer-32.png")));
			btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEnregistrer.setBounds(601, 368, 145, 49);
			contentPanel.add(btnEnregistrer);
	}
	
	
	/**
	 * On cherche un éleve à partir de la matricule saisie
	 * @param matricule
	 * @return Eleve
	 */
	public Eleve chercher(int matricule) {
		Eleve eleve= crud.rechercher(matricule);
		return eleve;
	}

	
	/**
	 * Remplir les champs par les infos de l'élève
	 * @param eleve
	 */
	public void remplirChamp(Eleve eleve) {
		if (eleve!=null) {
			
			txtNomEleve.setText(eleve.getNom());
			txtNomEleve.setEnabled(true);
			
			txtPrenomEleve.setText(eleve.getPrenom());
			txtPrenomEleve.setEnabled(true);
			
			btnEnregistrer.setEnabled(true);
			
			String classe= eleve.getClasse();
			
			for (int i=0; i<values.length; i++) {
				if (values[i].equals(classe)) {
					list.setSelectedIndex(i);
					list.setEnabled(true);
					break;
				}
			}
		}
		
		else {
			txtNomEleve.setText("");
			txtNomEleve.setEnabled(false);
			
			txtPrenomEleve.setText("");
			txtPrenomEleve.setEnabled(false);
			
			list.clearSelection();
			list.setEnabled(false);
			
			btnEnregistrer.setEnabled(false);
		}
	}
	
	
	/**
	 * Créer un nouvel élève à partir des infos saisies par le bibliothecaire
	 * @return Eleve
	 */
	public Eleve nouvelEleve() {
		Eleve eleve=null;
		
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
	 * Effectuer la modification au niveau de la Base de données
	 * @param matricule
	 * @param nouvelEleve
	 * @return boolean
	 */
	public boolean modifier(int matricule, Eleve nouvelEleve) {
		boolean modifier= false;
		
		modifier= crud.modifier(matricule, nouvelEleve);
		
		return modifier;
	}
}
