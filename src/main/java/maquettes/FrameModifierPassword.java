package maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bibliotheque.ProjetBibliotheque.dao.ControleBibliothecaire;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameModifierPassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	
	
	private ControleBibliothecaire controleBib;
	private JButton btnContinuer;
	private JPasswordField txtNewPassword;
	private JButton btnValider;
	private JLabel lblActuelMot_1;
	private JLabel lblActuelMot;
	private JLabel lblNewLabel;
	private String login;
	
	private boolean validite;
	
	private JPanel panel;
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModifierPassword frame = new FrameModifierPassword();
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
	public FrameModifierPassword() {
		
		
		/*
		 * Initialisation
		 */
		controleBib= new ControleBibliothecaire();
		
		
		
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(62, 30, 532, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 10, 153, 47);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(FrameModifierPassword.class.getResource("/images/loginImages/user.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblActuelMot = new JLabel("Actuel mot de passe");
		lblActuelMot.setBounds(10, 87, 153, 47);
		panel.add(lblActuelMot);
		lblActuelMot.setIcon(new ImageIcon(FrameModifierPassword.class.getResource("/images/loginImages/lock.png")));
		lblActuelMot.setToolTipText("Actual password");
		lblActuelMot.setForeground(Color.BLACK);
		lblActuelMot.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtLogin = new JTextField();
		txtLogin.setBounds(211, 11, 283, 47);
		panel.add(txtLogin);
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLogin.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(211, 87, 283, 47);
		panel.add(txtPassword);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnContinuer = new JButton("Continuer");
		btnContinuer.setBounds(412, 172, 120, 34);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				validite= verifier(txtLogin.getText(), txtPassword.getText());
				
				if (validite) {
					JOptionPane.showMessageDialog(null, "Valide", "Correspondant", JOptionPane.NO_OPTION);
					login= txtLogin.getText();
					panel2.setVisible(true);
					txtNewPassword.requestFocus();
					txtLogin.setEnabled(false);
					txtPassword.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Erreur", "Non correspondant", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(btnContinuer);
		
		panel2 = new JPanel();
		panel2.setBounds(62, 300, 532, 109);
		contentPane.add(panel2);
		panel2.setVisible(false);
		panel2.setLayout(null);
		
		lblActuelMot_1 = new JLabel("Nouveau mot de passe");
		lblActuelMot_1.setIcon(new ImageIcon(FrameModifierPassword.class.getResource("/images/loginImages/lock.png")));
		lblActuelMot_1.setToolTipText("New password");
		lblActuelMot_1.setForeground(Color.BLACK);
		lblActuelMot_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblActuelMot_1.setBounds(10, 10, 188, 47);
		panel2.add(lblActuelMot_1);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNewPassword.setBounds(208, 10, 283, 47);
		panel2.add(txtNewPassword);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean changer= changerMotDePasse(login, txtNewPassword.getText());
				
				if (changer) {
					JOptionPane.showMessageDialog(null, "Mot de passe modifié avec succès", "Succès", JOptionPane.DEFAULT_OPTION);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Modification echouée", "Erreur", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnValider.setIcon(new ImageIcon(FrameModifierPassword.class.getResource("/ecranPrincipale/icons8-ok-32.png")));
		btnValider.setBounds(416, 75, 116, 34);
		panel2.add(btnValider);
		
	}
	
	
	
	public boolean verifier(String login, String actualPassword) {
		boolean valider= false;
		valider= controleBib.verifier(login, actualPassword);
		return valider;
	}
	
	
	public boolean changerMotDePasse(String login, String newPassword) {
		boolean change= controleBib.changerMotDePasse(login, newPassword);
		return change;
	}
}
