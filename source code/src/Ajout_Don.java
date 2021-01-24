import java.awt.*;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ajout_Don extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblCatgorie;
	private JLabel lblWilaya;
	private JComboBox comboBox_1;
	private JButton btnAnnuler;

	public Ajout_Don() {
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
		panel.setBounds(30, 20, 544, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 20, 150, 30);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(190, 20, 300, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblDescription.setBounds(20, 74, 150, 30);
		panel.add(lblDescription);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Open Sans", Font.PLAIN, 14));
		textArea.setBorder(UIManager.getBorder("TextField.border"));
		textArea.setColumns(10);
		textArea.setBounds(190, 74, 300, 200);
		panel.add(textArea);
		
		lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblCatgorie.setBounds(20, 300, 150, 30);
		panel.add(lblCatgorie);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox.setBounds(190, 300, 300, 30);
		panel.add(comboBox);
		
		lblWilaya = new JLabel("Wilaya");
		lblWilaya.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblWilaya.setBounds(20, 366, 150, 30);
		panel.add(lblWilaya);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(190, 366, 300, 30);
		panel.add(comboBox_1);
		
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(29,191,115));
		btnNewButton.setBounds(30, 591, 175, 50);
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
		btnAnnuler.setBounds(399, 591, 175, 50);
		contentPane.add(btnAnnuler);
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}
