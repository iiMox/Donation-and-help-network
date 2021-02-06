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
		accueil_offre_1_title.setBounds(10, 11, 180, 25);
		add(accueil_offre_1_title);
		
		JLabel accueil_offre_1_desc = new JLabel(description);
		accueil_offre_1_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_1_desc.setBounds(10, 40, 180, 70);
		add(accueil_offre_1_desc);
		
		JLabel accueil_offre_1_liocation = new JLabel(wilaya);
		accueil_offre_1_liocation.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_offre_1_liocation.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_1_liocation.setBounds(119, 121, 70, 16);
		add(accueil_offre_1_liocation);
		
		JLabel accueil_offre_1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_offre_1_icon.setBounds(100, 121, 16, 16);
		add(accueil_offre_1_icon);
	}

}
