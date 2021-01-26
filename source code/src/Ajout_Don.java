import java.awt.*;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ajout_Don extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblCatgorie;
	private JLabel lblWilaya;
	private JComboBox comboBox_1;
	private JButton btnAnnuler;

	public Ajout_Don(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajout_Don.class.getResource("/images/login_icon.png")));
		setTitle("Ajouter un article");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TextField.border"));
		panel.setBounds(30, 102, 544, 455);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(31, 33, 150, 30);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(212, 33, 300, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblDescription.setBounds(31, 96, 150, 200);
		panel.add(lblDescription);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(212, 96, 300, 200);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Open Sans", Font.PLAIN, 14));
		//textArea.setBorder(UIManager.getBorder("TextField.border"));
		textArea.setColumns(10);
		textArea.setBounds(0, 12, 300, 200);
		panel.add(scroll);
		
		lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblCatgorie.setBounds(31, 329, 150, 30);
		panel.add(lblCatgorie);
		
		String [] itemsCat = { "Maison & fournitures", "Elctromenager", "Informatique", "Elctronique", "Vetements & accessoires" };
		JComboBox comboBox = new JComboBox(itemsCat);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox.setBounds(212, 329, 300, 30);
		panel.add(comboBox);
		
		lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblWilaya.setBounds(31, 392, 150, 30);
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
		comboBox_1.setBounds(212, 392, 300, 30);
		panel.add(comboBox_1);
		
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				java.util.Date utilDate = new Date();
				String dt = formatter.format(utilDate);
				Don nv_don = new Don(textField.getText(),textArea.getText(),username,comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),"en attend",dt);
				nv_don.ajout_don();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(29,191,115));
		btnNewButton.setBounds(84, 583, 175, 50);
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
		btnAnnuler.setBounds(343, 583, 175, 50);
		contentPane.add(btnAnnuler);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 26, 544, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NOUVEL ARTICLE DE DON");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(122, 11, 300, 30);
		panel_1.add(lblNewLabel_1);
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}
