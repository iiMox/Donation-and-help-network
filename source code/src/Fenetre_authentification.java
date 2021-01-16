import java.awt.EventQueue;

import java.awt.event.*;

import javax.swing.*;


import java.awt.Color;
import java.awt.*;

import java.io.*;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;

public class Fenetre_authentification {

	private JFrame frmLogin;
	private JTextField username_field;
	private JPasswordField password_field;
	private JTextField textField;
	private JTextField txtEmail;
	private JPasswordField textField_2;
	private JPanel connexion_panel,creer_panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_authentification window = new Fenetre_authentification();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Fenetre_authentification() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre_authentification.class.getResource("/images/login_icon.png")));
		frmLogin.setTitle("Login / Sign up");
		frmLogin.getContentPane().setBackground(Color.white);
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 600, 400);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		connexion_panel = new JPanel();
		connexion_panel.setBackground(Color.decode("#1dbf73"));
		connexion_panel.setBounds(0, 0, 326, 361);
		frmLogin.getContentPane().add(connexion_panel);
		connexion_panel.setLayout(null);
		
		username_field = new JTextField();
		username_field.setFont(new Font("Open Sans", Font.PLAIN, 12));
		username_field.setForeground(Color.GRAY);
		
		/*Start Removing border */
		
		username_field.setBorder(new LineBorder(new Color(110, 110, 110)));
		username_field.setBackground(Color.white);
		
		/*End Removing border */
		
		username_field.setText("Nom d'utilisateur");
		username_field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (username_field.getText().equals("Nom d'utilisateur")) {
					username_field.setText("");
					username_field.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (username_field.getText().isEmpty()) {
					username_field.setForeground(Color.GRAY);
					username_field.setText("Nom d'utilisateur");
		        }
			}
		});
		username_field.setText("Nom d'utilisateur");
		username_field.setBounds(72, 97, 180, 35);
		connexion_panel.add(username_field);
		username_field.setColumns(10);
		username_field.setBorder(BorderFactory.createCompoundBorder(
				username_field.getBorder(), 
		        BorderFactory.createEmptyBorder(10, 20, 10, 5)));
		
		
		password_field = new JPasswordField();
		password_field.setEchoChar((char)0);
		password_field.setFont(new Font("Open Sans", Font.PLAIN, 12));
		password_field.setText("Mot de passe");
		password_field.setForeground(Color.GRAY);
		
		/*Start Removing border */
		
		password_field.setBorder(new LineBorder(new Color(110, 110, 110)));
		password_field.setBackground(Color.white);
		
		/*End Removing border */
		
		password_field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (password_field.getText().equals("Mot de passe")) {
					password_field.setText("");
					password_field.setForeground(Color.BLACK);
					password_field.setEchoChar('*');
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (password_field.getText().isEmpty()) {
					password_field.setForeground(Color.GRAY);
					password_field.setText("Mot de passe");
					password_field.setEchoChar((char)0);
		        }
			}
		});
		password_field.setColumns(10);
		password_field.setBounds(72, 163, 180, 35);
		connexion_panel.add(password_field);
		password_field.setBorder(BorderFactory.createCompoundBorder(
				password_field.getBorder(), 
		        BorderFactory.createEmptyBorder(10, 20, 10, 5)));
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = new User();
				user.setUsername(username_field.getText());
				user.setPassword(password_field.getText());
				user.userExiste();
				if(user.getType().equals("admin")) {
					Fenetre_admin fa = new Fenetre_admin();
					fa.setVisible(true);
					frmLogin.setVisible(false);
				}else if(user.getType().equals("user")) {
					Fenetre_user fu = new Fenetre_user(user.getId());
					fu.setVisible(true);
					frmLogin.setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(5, 259, 120, 35);
		connexion_panel.add(btnNewButton);
		btnNewButton.setBackground(Color.decode("#f7f7f7"));
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));
		JLabel lblNewLabel = new JLabel("Acceder a votre compte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 31, 190, 35);
		connexion_panel.add(lblNewLabel);
		
		JButton btnCreerUnCompte = new JButton("Cr\u00E9er un compte");
		btnCreerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connexion_panel.setVisible(false);
				creer_panel.setVisible(true);
			}
		});
		btnCreerUnCompte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreerUnCompte.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnCreerUnCompte.setBackground(new Color(247, 247, 247));
		btnCreerUnCompte.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));
		btnCreerUnCompte.setBounds(200, 259, 120, 35);
		connexion_panel.add(btnCreerUnCompte);
		
		JLabel lblNewLabel_1 = new JLabel("Ou bien");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_1.setBounds(130, 270, 65, 14);
		connexion_panel.add(lblNewLabel_1);
		
		creer_panel = new JPanel();
		creer_panel.setVisible(false);
		creer_panel.setLayout(null);
		creer_panel.setBackground(new Color(29, 191, 115));
		creer_panel.setBounds(0, 0, 326, 361);
		frmLogin.getContentPane().add(creer_panel);
		
		textField = new JTextField();
		textField.setText("Nom d'utilisateur");
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(110, 110, 110)));
		textField.setBackground(Color.WHITE);
		textField.setBounds(72, 97, 180, 35);
		creer_panel.add(textField);
		textField.setBorder(BorderFactory.createCompoundBorder(
				textField.getBorder(), 
		        BorderFactory.createEmptyBorder(10, 20, 10, 5)));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals("Nom d'utilisateur")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setForeground(Color.GRAY);
					textField.setText("Nom d'utilisateur");
		        }
			}
		});
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setFont(new Font("Open Sans", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new LineBorder(new Color(110, 110, 110)));
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(72, 163, 180, 35);
		creer_panel.add(txtEmail);
		txtEmail.setBorder(BorderFactory.createCompoundBorder(
				txtEmail.getBorder(), 
		        BorderFactory.createEmptyBorder(10, 20, 10, 5)));
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("E-mail")) {
					txtEmail.setText("");
					txtEmail.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setForeground(Color.GRAY);
					txtEmail.setText("E-mail");
		        }
			}
		});
		
		textField_2 = new JPasswordField();
		textField_2.setText("Mot de passe");
		textField_2.setEchoChar((char)0);
		textField_2.setForeground(Color.GRAY);
		textField_2.setFont(new Font("Open Sans", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(110, 110, 110)));
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(72, 229, 180, 35);
		creer_panel.add(textField_2);
		textField_2.setBorder(BorderFactory.createCompoundBorder(
				textField_2.getBorder(), 
		        BorderFactory.createEmptyBorder(10, 20, 10, 5)));
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_2.getText().equals("Mot de passe")) {
					textField_2.setText("");
					textField_2.setForeground(Color.BLACK);
					textField_2.setEchoChar('*');
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textField_2.getText().isEmpty()) {
					textField_2.setForeground(Color.GRAY);
					textField_2.setText("Mot de passe");
					textField_2.setEchoChar((char)0);
		        }
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Cr\u00E9er un compte");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblNewLabel_2.setBounds(67, 31, 190, 35);
		creer_panel.add(lblNewLabel_2);
		
		JButton btnCreerUnCompte_1 = new JButton("Cr\u00E9er un compte");
		btnCreerUnCompte_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user_add = new User();
				user_add.setUsername(textField.getText());
				user_add.setPassword(textField_2.getText());
				user_add.setEmail(txtEmail.getText());
				user_add.setType("user");
				user_add.ajout_user();
				connexion_panel.setVisible(true);
				creer_panel.setVisible(false);
				
			}
		});
		btnCreerUnCompte_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreerUnCompte_1.setFont(new Font("Open Sans", Font.BOLD, 12));
		btnCreerUnCompte_1.setBorder(BorderFactory.createLineBorder(Color.decode("#666")));
		btnCreerUnCompte_1.setBackground(new Color(247, 247, 247));
		btnCreerUnCompte_1.setBounds(102, 295, 120, 35);
		creer_panel.add(btnCreerUnCompte_1);
		
		JLabel backLabel = new JLabel(new ImageIcon(Fenetre_authentification.class.getResource("/images/back-arrow.png")));
		backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				connexion_panel.setVisible(true);
				creer_panel.setVisible(false);
			}
		});
		backLabel.setLocation(20, 36);
		backLabel.setSize(24, 24);
		creer_panel.add(backLabel);

	    JLabel imgLabel = new JLabel(new ImageIcon(Fenetre_authentification.class.getResource("/images/login_image_1.png")));
	    imgLabel.setLocation(354, 11);
	    imgLabel.setSize(200, 200);
	    frmLogin.getContentPane().add(imgLabel);
	    
	    JLabel lblNewLabel_3 = new JLabel("Sharing is caring");
	    lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_3.setFont(new Font("Open Sans", Font.BOLD, 16));
	    lblNewLabel_3.setBounds(377, 197, 155, 32);
	    lblNewLabel_3.setForeground(Color.decode("#1dbf73"));
	    frmLogin.getContentPane().add(lblNewLabel_3);
		
		
	    frmLogin.getContentPane().requestFocusInWindow();
		
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmLogin.setLocation(dim.width/2-frmLogin.getSize().width/2, dim.height/2-frmLogin.getSize().height/2);
		
	}
}
