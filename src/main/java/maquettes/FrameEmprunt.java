package maquettes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameEmprunt extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMatriculeResultat;
	private JTextField txtNomCompletResultat;
	private JTextField txtClasseResultat;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEmprunt frame = new FrameEmprunt();
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
	public FrameEmprunt() {
		setBounds(new Rectangle(175, 92, 776, 501));
		setPreferredSize(new Dimension(0, 0));
		setTitle("Accorder un emprunt\r\n");
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		getContentPane().setBounds(175, 92, 776, 501);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.ORANGE, 3));
		panel.setBounds(68, 35, 535, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMatricule = new JLabel("Matricule élève");
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMatricule.setBounds(10, 8, 121, 26);
		panel.add(lblMatricule);
		
		JSpinner spMatricule = new JSpinner();
		spMatricule.setFont(new Font("Tahoma", Font.BOLD, 20));
		spMatricule.setBounds(129, 8, 121, 32);
		panel.add(spMatricule);
		
		JButton btnIdentifierEleve = new JButton("Identifier l'élève\r\n");
		btnIdentifierEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherInfosEleve();
			}
		});
		btnIdentifierEleve.setIcon(new ImageIcon(FrameEmprunt.class.getResource("/frameEmpruntImages/icons8-trouver-l'utilisateur-homme-32.png")));
		btnIdentifierEleve.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnIdentifierEleve.setBounds(323, 4, 202, 40);
		panel.add(btnIdentifierEleve);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GREEN, 5));
		panel_1.setBounds(68, 106, 535, 168);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Matricule");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 10, 97, 28);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom complet");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 62, 102, 28);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Classe");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(25, 113, 110, 28);
		panel_1.add(lblNewLabel_3);
		
		txtMatriculeResultat = new JTextField();
		txtMatriculeResultat.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatriculeResultat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMatriculeResultat.setBounds(132, 10, 352, 28);
		panel_1.add(txtMatriculeResultat);
		txtMatriculeResultat.setColumns(10);
		
		txtNomCompletResultat = new JTextField();
		txtNomCompletResultat.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomCompletResultat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNomCompletResultat.setColumns(10);
		txtNomCompletResultat.setBounds(132, 62, 352, 28);
		panel_1.add(txtNomCompletResultat);
		
		txtClasseResultat = new JTextField();
		txtClasseResultat.setHorizontalAlignment(SwingConstants.CENTER);
		txtClasseResultat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtClasseResultat.setColumns(10);
		txtClasseResultat.setBounds(132, 120, 352, 28);
		panel_1.add(txtClasseResultat);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.ORANGE, 3));
		panel_2.setBounds(68, 334, 535, 50);
		getContentPane().add(panel_2);
		
		JLabel lblIsbnLivre = new JLabel("ISBN Livre");
		lblIsbnLivre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIsbnLivre.setBounds(32, 11, 93, 26);
		panel_2.add(lblIsbnLivre);
		
		JButton btnIdentifierLivre = new JButton("Identifier livre");
		btnIdentifierLivre.setIcon(new ImageIcon(FrameEmprunt.class.getResource("/frameEmpruntImages/icons8-google-web-recherche-32.png")));
		btnIdentifierLivre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnIdentifierLivre.setBounds(323, 4, 202, 40);
		panel_2.add(btnIdentifierLivre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(135, 9, 113, 32);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(Color.GREEN, 5));
		panel_1_1.setBounds(68, 428, 535, 168);
		getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ISBN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(25, 10, 97, 28);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Titre");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(25, 62, 102, 28);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Catégorie");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(25, 113, 110, 28);
		panel_1_1.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(132, 10, 352, 28);
		panel_1_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(132, 62, 352, 28);
		panel_1_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(132, 120, 352, 28);
		panel_1_1.add(textField_2);
		setBounds(100, 100, 774, 442);

	}
	
	public void afficherInfosEleve() {
		this.setSize(774, 442);
	}
}
