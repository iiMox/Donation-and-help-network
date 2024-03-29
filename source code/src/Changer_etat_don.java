import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Changer_etat_don extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblCatgorie;
	private JLabel lblWilaya;
	private JTextField comboBox_1;
	private JButton btnAnnuler;
	private JTextField textField_1;

	public Changer_etat_don(int code) {
		OracleConnection oc = new OracleConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajout_Don.class.getResource("/images/login_icon.png")));
		setTitle("Changer l'etat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.setBounds(30, 104, 544, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(31, 30, 150, 30);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(212, 30, 300, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblDescription.setBounds(31, 90, 150, 200);
		panel.add(lblDescription);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(212, 90, 300, 200);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Open Sans", Font.PLAIN, 14));
		//textArea.setBorder(UIManager.getBorder("TextField.border"));
		textArea.setColumns(10);
		textArea.setBounds(0, 12, 300, 200);
		panel.add(scroll);
		
		lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblCatgorie.setBounds(31, 380, 150, 30);
		panel.add(lblCatgorie);
		
		JTextField comboBox = new JTextField();
		comboBox.setEditable(false);
		comboBox.setBounds(212, 380, 300, 30);
		panel.add(comboBox);
		
		lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblWilaya.setBounds(31, 440, 150, 30);
		panel.add(lblWilaya);
		
		comboBox_1 = new JTextField();
		comboBox_1.setEditable(false);
		comboBox_1.setBounds(212, 440, 300, 30);
		panel.add(comboBox_1);
		
		JLabel lblProprietere = new JLabel("Propri\u00E9taire");
		lblProprietere.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblProprietere.setBounds(31, 320, 150, 30);
		panel.add(lblProprietere);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(212, 320, 300, 30);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("CHANGER L'ETAT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Etat et = new Etat(code,"don");
				et.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(29,191,115));
		btnNewButton.setBounds(77, 631, 175, 50);
		contentPane.add(btnNewButton);
		
		btnAnnuler = new JButton("ANNULER");
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Es-tu sur ?", "Confirmation", JOptionPane.YES_NO_OPTION);

				if (opcion == 0) { //The ISSUE is here
					dispose();
				}
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnAnnuler.setBorder(null);
		btnAnnuler.setBackground(Color.RED);
		btnAnnuler.setBounds(330, 631, 175, 50);
		contentPane.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 27, 544, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Changer l'etat d'un article");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(122, 11, 300, 30);
		panel_1.add(lblNewLabel_1);
		
		oc.initialize();
		
		try {
			oc.stmt = oc.con.prepareStatement("Select * from Dons where code=?");
			oc.stmt.setInt(1, code);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				textField.setText(oc.rs.getString("title"));
				textArea.setText(oc.rs.getString("description"));
				textField_1.setText(oc.rs.getString("owner"));
				comboBox.setText(oc.rs.getString("categorie"));
				comboBox_1.setText(oc.rs.getString("wilaya"));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion � la base de donn�es");
		}
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}
