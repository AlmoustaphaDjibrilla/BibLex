package maquettes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bibliotheque.ProjetBibliotheque.Entity.Bibliothecaire;
import com.bibliotheque.ProjetBibliotheque.dao.ControleBibliothecaire;
import java.awt.Toolkit;

public class FrameLogin extends JFrame {

	/**
	 * 
	 */
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager manager;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JPasswordField txtPassword;
	

	
	private ControleBibliothecaire controleBib;
	
	private Bibliothecaire bib;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setTitle("Page d'authentification");
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
	public FrameLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/images/loginImages/1665063958680.jpg")));
		//initialiserConnection();
		
		controleBib= new ControleBibliothecaire();
		
		
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtLogin.setToolTipText("");
		txtLogin.setForeground(Color.BLACK);
		txtLogin.setBounds(478, 116, 153, 33);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/loginImages/user.png")));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(330, 106, 139, 43);
		contentPane.add(lblLogin);
		
		lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/loginImages/lock.png")));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(330, 184, 139, 43);
		contentPane.add(lblPassword);
		
		btnValider = new JButton("Valider");
		btnValider.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/loginImages/tick-mark (1).png")));
		btnValider.setBounds(514, 292, 117, 43);
		btnValider.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				boolean valide= controleBib.verifier(txtLogin.getText(), txtPassword.getText());
				//bib= controleBib.verifier2(txtLogin.getText(), txtPassword.getText());
				if (valide) {
					JOptionPane.showMessageDialog(null, "Reussi");
					reinitialiser();
					ouvrirEcranPrincipale();
				}
				else {
					JOptionPane.showMessageDialog(null, "Non correspondant", "Incompatibles", JOptionPane.ERROR_MESSAGE);
					reinitialiser();
					txtLogin.requestFocus();
				}
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		contentPane.add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/loginImages/cancel.png")));
		btnAnnuler.setBounds(352, 292, 117, 43);
		btnAnnuler.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				reinitialiser();
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				reinitialiser();
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		contentPane.add(btnAnnuler);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassword.setBounds(478, 184, 153, 33);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameLogin.class.getResource("/images/loginImages/bibliotheque.png")));
		lblNewLabel.setBounds(29, 10, 301, 423);
		contentPane.add(lblNewLabel);
	}
	
	
	
	/*
	 * Initialiser la connection avec la bd
	 */
	public void initialiserConnection() {
		entityManagerFactory= Persistence.createEntityManagerFactory("projetBibliotheque");
		manager= entityManagerFactory.createEntityManager();
	}
	
	/*
	 * Reinitialiser les champs login et password
	 */
	public void reinitialiser() {
		txtLogin.setText("");
		txtPassword.setText("");
		txtLogin.requestFocus();
	}
	
	/*
	 * Ouvrir ecran principale
	 */
	public void ouvrirEcranPrincipale() {
		this.dispose();
		FrameGestion ecranPrincipale= new FrameGestion();
		ecranPrincipale.setVisible(true);
	}
}
