import java.awt.*;

import javax.swing.*;


public class AccueilOffreContainer extends JPanel {

	public AccueilOffreContainer(String titre, String description, String wilaya, int x) {
		setBorder(UIManager.getBorder("TextField.border"));
		setBackground(Color.WHITE);
		setBounds(x, 445, 200, 150);
		setLayout(null);
		
		JLabel accueil_offre_1_title = new JLabel(titre);
		accueil_offre_1_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_offre_1_title.setBounds(10, 10, 180, 25);
		add(accueil_offre_1_title);
		
		JTextArea accueil_offre_1_desc = new JTextArea(2, 20);
		accueil_offre_1_desc.setText(description);
		accueil_offre_1_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_1_desc.setBounds(10, 40, 180, 70);
		accueil_offre_1_desc.setWrapStyleWord(true);
		accueil_offre_1_desc.setLineWrap(true);
		accueil_offre_1_desc.setOpaque(false);
		accueil_offre_1_desc.setEditable(false);
		accueil_offre_1_desc.setFocusable(false);
		accueil_offre_1_desc.setBackground(UIManager.getColor("Label.background"));
		add(accueil_offre_1_desc);
		
		JLabel accueil_offre_1_liocation = new JLabel(wilaya);
		accueil_offre_1_liocation.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_offre_1_liocation.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_1_liocation.setBounds(119, 121, 70, 16);
		add(accueil_offre_1_liocation);
		
		JLabel accueil_offre_1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_offre_1_icon.setBounds(100, 121, 16, 16);
		add(accueil_offre_1_icon);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(9, 37, 181, 1);
		add(panel);
	}
}
