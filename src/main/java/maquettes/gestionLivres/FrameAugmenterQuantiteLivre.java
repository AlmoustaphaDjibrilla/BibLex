package maquettes.gestionLivres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.Entity.Livre;
import com.bibliotheque.ProjetBibliotheque.dao.CRUDLivre;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAugmenterQuantiteLivre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIsbn;
	private JTextField txtTitre;
	private JSpinner spQteAjout;
	private JButton btnChercher;
	
	private CRUDLivre crudLivre;
	private JButton btnEnregistrer;
	
	private Livre livre;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtQteActuelle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrameAugmenterQuantiteLivre dialog = new FrameAugmenterQuantiteLivre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrameAugmenterQuantiteLivre() {
		
		crudLivre= new CRUDLivre();
		
		setModal(true);
		setTitle("Augmenter la quantité d'un livre");
		setBounds(100, 100, 761, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(184, 134, 11));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn livre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(41, 44, 109, 47);
		contentPanel.add(lblNewLabel);
		
		txtIsbn = new JTextField();
		txtIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtIsbn.setBounds(145, 52, 218, 37);
		contentPanel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn= txtIsbn.getText().toString().toUpperCase();
				livre= chercherLivre(isbn);
				remplir(livre);
			}
		});
		btnChercher.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnChercher.setBounds(441, 48, 176, 47);
		contentPanel.add(btnChercher);
		
		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(56, 183, 68, 37);
		contentPanel.add(lblNewLabel_1);
		
		txtTitre = new JTextField();
		txtTitre.setEditable(false);
		txtTitre.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTitre.setBounds(145, 179, 532, 51);
		contentPanel.add(txtTitre);
		txtTitre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantité");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(41, 389, 68, 29);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("à ajouter");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(41, 406, 75, 29);
		contentPanel.add(lblNewLabel_2_1);
		
		spQteAjout = new JSpinner();
		spQteAjout.setEnabled(false);
		spQteAjout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spQteAjout.setBounds(145, 401, 185, 37);
		contentPanel.add(spQteAjout);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enregistrer(livre);
			}
		});
		btnEnregistrer.setEnabled(false);
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnEnregistrer.setBounds(441, 393, 176, 47);
		contentPanel.add(btnEnregistrer);
		
		lblNewLabel_3 = new JLabel("Quantité");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(41, 293, 83, 37);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("actuelle");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(41, 324, 83, 20);
		contentPanel.add(lblNewLabel_4);
		
		txtQteActuelle = new JTextField();
		txtQteActuelle.setEditable(false);
		txtQteActuelle.setHorizontalAlignment(SwingConstants.CENTER);
		txtQteActuelle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtQteActuelle.setColumns(10);
		txtQteActuelle.setBounds(145, 293, 153, 37);
		contentPanel.add(txtQteActuelle);
	}
	
	
	/**
	 * La méthode va chercher le livre correspondant à l'ISBN passé en paramètre
	 * @param isbn
	 * @return livre
	 */
	public Livre chercherLivre(String isbn) {
		Livre livre= crudLivre.chercherLivre(isbn);
		return livre;
	}
	
	
	/**
	 * Remplir les différents champs par les infos du livre passé en paramètre
	 * @param livre
	 */
	public void remplir (Livre livre) {
		if (livre!=null) {
			txtTitre.setText(livre.getTitre());
			String qte= ""+livre.getQuantite()+"";
			txtQteActuelle.setText(qte);
			btnEnregistrer.setEnabled(true);
			spQteAjout.setEnabled(true);
			spQteAjout.requestFocus();
		}
		else {
			txtTitre.setText("");
			btnEnregistrer.setEnabled(false);
			txtIsbn.requestFocus();
		}
	}
	
	
	/**
	 * Cette méthode perme
	 * @return boolean
	 */
	public void enregistrer(Livre livre) {		
		int plus= (Integer) spQteAjout.getValue();
		
		if (plus > 0) {
			boolean augmentation= crudLivre.augmenterQuantiteLivre(livre.getIsbn(), plus);
			
			if (augmentation) {
				JOptionPane.showMessageDialog(null, "Quantité du livre "+livre.getTitre()+" augmentée");
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null,
						"Un problème est survenu, veuillez réessayer",
						"Augmentation non effectuée",
						JOptionPane.ERROR_MESSAGE);
				spQteAjout.requestFocusInWindow();
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null,
					"La quantité supplémentaire doit être strictement positive",
					"Augmentation non effectuée",
					JOptionPane.ERROR_MESSAGE);
			spQteAjout.requestFocusInWindow();
		}
	}
}
