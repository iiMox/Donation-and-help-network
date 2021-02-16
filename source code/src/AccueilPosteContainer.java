import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AccueilPosteContainer extends JPanel {

	public AccueilPosteContainer(String titre, String description, String wilaya, int x) {
		setBorder(UIManager.getBorder("TextField.border"));
		setBackground(Color.WHITE);
		setBounds(x, 185, 200, 150);
		setLayout(null);
		
		JLabel accueil_poste_1_title = new JLabel(titre);
		accueil_poste_1_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_poste_1_title.setBounds(10, 11, 180, 25);
		add(accueil_poste_1_title);
		
		JTextArea accueil_poste_1_desc = new JTextArea();
		accueil_poste_1_desc.setText(description);
		accueil_poste_1_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_1_desc.setBounds(10, 40, 180, 70);
		accueil_poste_1_desc.setWrapStyleWord(true);
		accueil_poste_1_desc.setLineWrap(true);
		accueil_poste_1_desc.setOpaque(false);
		accueil_poste_1_desc.setEditable(false);
		accueil_poste_1_desc.setFocusable(false);
		accueil_poste_1_desc.setBackground(UIManager.getColor("Label.background"));
		add(accueil_poste_1_desc);
		
		JLabel accueil_poste_1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_poste_1_icon.setLocation(100, 121);
		accueil_poste_1_icon.setSize(16, 16);
		add(accueil_poste_1_icon);
		
		JLabel accueil_poste_1_liocation = new JLabel(wilaya);
		accueil_poste_1_liocation.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_poste_1_liocation.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_1_liocation.setBounds(119, 121, 70, 16);
		add(accueil_poste_1_liocation);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(9, 37, 181, 1);
		add(panel);
	}

}
