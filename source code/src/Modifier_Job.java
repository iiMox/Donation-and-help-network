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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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

public class Modifier_Job extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblWilaya;
	private JComboBox comboBox_1;
	private JButton btnAnnuler;
	private JFormattedTextField textField_salaire;
	private JTextField textField_duree;

	public Modifier_Job(int code) {
		OracleConnection oc = new OracleConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajout_Don.class.getResource("/images/login_icon.png")));
		setTitle("Modifier un offre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.setBounds(30, 94, 544, 570);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(31, 41, 150, 30);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(212, 41, 300, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblDescription.setBounds(31, 112, 150, 200);
		panel.add(lblDescription);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(212, 112, 300, 200);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Open Sans", Font.PLAIN, 14));
		//textArea.setBorder(UIManager.getBorder("TextField.border"));
		textArea.setColumns(10);
		textArea.setBounds(0, 93, 300, 200);
		panel.add(scroll);
		
		String [] itemsCat = { "Maison & fournitures", "Elctromenager", "Informatique", "Elctronique", "Vetements & accessoires" };
		
		lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblWilaya.setBounds(31, 353, 150, 30);
		panel.add(lblWilaya);
		
		String [] itemsWilaya = { "1- Adrar",
				"2- Chlef",
				"3- Laghouat",
				"4- Oum El Bouaghi",
				"5- Batna",
				"6- Bejaïa",
				"7- Biskra",
				"8- Béchar",
				"9- Blida",
				"10- Bouira",
				"11- Tamanrasset",
				"12- Tebessa",
				"13- Tlemcen",
				"14- Tiaret",
				"15- Tizi Ouzou",
				"16- Alger",
				"17- Djelfa",
				"18- Djijel",
				"19- Sétif",
				"20- Saïda",
				"21- Skikda",
				"22- Sidi Bel Abbès",
				"23- Annaba",
				"24- Guelma",
				"25- Constantine",
				"26- Médéa",
				"27- Mostaganem",
				"28- M'Sila",
				"29- Mascara",
				"30- Ouargla",
				"31- Oran",
				"32- El Bayadh",
				"33- Illizi",
				"34- Bordj Bou Arreridj",
				"35- Boumerdès",
				"36- El Tarf",
				"37- Tindouf",
				"38- Tissemsilt",
				"39- El Oued",
				"40- Khenchela",
				"41- Souk Ahras",
				"42- Tipaza",
				"43- Mila",
				"44- Aïn Defla",
				"45- Naâma",
				"46- Aïn Témouchent",
				"47- Ghardaia",
				"48- Relizane"};
		comboBox_1 = new JComboBox(itemsWilaya);
		comboBox_1.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(212, 353, 300, 30);
		panel.add(comboBox_1);
		
		JLabel lblSalaire = new JLabel("Salaire");
		lblSalaire.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblSalaire.setBounds(31, 424, 150, 30);
		panel.add(lblSalaire);
		
		textField_salaire = new JFormattedTextField();
		textField_salaire.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_salaire.setColumns(10);
		textField_salaire.setBounds(212, 424, 280, 30);
		panel.add(textField_salaire);
		
		JLabel lblDuree = new JLabel("Dur\u00E9e");
		lblDuree.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblDuree.setBounds(31, 495, 150, 30);
		panel.add(lblDuree);
		
		textField_duree = new JTextField();
		textField_duree.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_duree.setColumns(10);
		textField_duree.setBounds(212, 495, 200, 30);
		panel.add(textField_duree);
		
		JLabel lblNewLabel_2 = new JLabel("DA");
		lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 10));
		lblNewLabel_2.setBounds(497, 424, 15, 30);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{"Jours","Mois","Années"});
		comboBox_2.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(422, 495, 90, 30);
		panel.add(comboBox_2);
		
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("select * from Jobs where code=?");
			oc.stmt.setInt(1, code);
			oc.rs=oc.stmt.executeQuery();
			if(oc.rs.next()) {
				textField.setText(oc.rs.getString("titre"));
				textArea.setText(oc.rs.getString("description"));
				textField_salaire.setText(String.valueOf(oc.rs.getLong("salaire")));
				String w = oc.rs.getString("wilaya");
				int i = Integer.valueOf(w.charAt(0)-49);
				comboBox_1.setSelectedIndex(i);
				String d = oc.rs.getString("duration");
				String numberOnly= d.replaceAll("[^0-9]", "");
				textField_duree.setText(numberOnly);
				if(d.contains("J")) {
					comboBox_2.setSelectedIndex(0);
				} else if(d.contains("M")) {
					comboBox_2.setSelectedIndex(1);
				} else {
					comboBox_2.setSelectedIndex(2);
				}
			}
			oc.con.close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		
		JButton btnNewButton = new JButton("MODIFIER");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Job j = new Job();
				j.setCode(code);
				j.setTitle(textField.getText());
				j.setDescription(textArea.getText());
				j.setSalaire(Long.parseLong(textField_salaire.getText()));
				j.setDuree(textField_duree.getText() + " "+comboBox_2.getSelectedItem());
				j.setEtat("en attend");
				j.setWilaya((String)comboBox_1.getSelectedItem());
				j.modifier_job();

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(29,191,115));
		btnNewButton.setBounds(84, 686, 175, 50);
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
		btnAnnuler.setBounds(343, 686, 175, 50);
		contentPane.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 22, 544, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MODIFIER UN OFFRE D'EMPLOI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(72, 11, 400, 30);
		panel_1.add(lblNewLabel_1);
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}

}
