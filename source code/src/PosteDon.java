import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PosteDon extends JPanel {

	/**
	 * Create the panel.
	 */
	public PosteDon(int code) {
		setPreferredSize(new Dimension(600, 240));
		setBackground(Color.decode("#f0f0f0"));
		setBounds(new Rectangle(0, 0, 550, 400));		
		setBorder(UIManager.getBorder("TextField.border"));
		setLayout(null);
		
		JLabel title = new JLabel("New label");
		title.setFont(new Font("Open Sans", Font.BOLD, 15));
		title.setBounds(10, 11, 580, 40);
		add(title);
		
		JTextArea desc = new JTextArea("New labelggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggNew labelggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggNew labelggggggggggggggggggggggggggggggggggggggggggggggggg");
		JScrollPane sp = new JScrollPane(desc); 
		sp.setBorder(null);
		add(sp);
		sp.setBounds(10, 80, 580, 100);
		desc.setEditable(false);
		desc.setBorder(null);
		desc.setBackground(Color.decode("#f0f0f0"));
		desc.setLineWrap(true);
		desc.setFont(new Font("Open Sans", Font.PLAIN, 15));
		desc.setBounds(10, 65, 580, 100);
		
		JLabel categorie = new JLabel("Cat\u00E9gorie");
		categorie.setOpaque(true);
		categorie.setBackground(Color.decode("#4b6584"));
		categorie.setForeground(Color.WHITE);
		categorie.setHorizontalAlignment(SwingConstants.CENTER);
		categorie.setFont(new Font("Open Sans", Font.BOLD, 14));
		categorie.setBounds(10, 204, 90, 25);
		add(categorie);
		
		JLabel wilaya = new JLabel("Wilaya");
		wilaya.setOpaque(true);
		wilaya.setHorizontalAlignment(SwingConstants.CENTER);
		wilaya.setForeground(Color.WHITE);
		wilaya.setFont(new Font("Open Sans", Font.BOLD, 14));
		wilaya.setBackground(new Color(29,191,115));
		wilaya.setBounds(500, 204, 90, 25);
		add(wilaya);
		
		JLabel owner = new JLabel("Username");
		owner.setFont(new Font("Open Sans", Font.PLAIN, 14));
		owner.setBounds(10, 54, 125, 15);
		add(owner);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBorder(null);
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 50, 580, 2);
		add(separator);
		
		JLabel date = new JLabel("17-01-2021");
		date.setHorizontalAlignment(SwingConstants.RIGHT);
		date.setFont(new Font("Open Sans", Font.BOLD, 13));
		date.setBounds(500, 55, 90, 14);
		add(date);
		
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select * From Dons where code = ?");
			oc.stmt.setInt(1, code);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				title.setText(oc.rs.getString("title"));
				owner.setText(oc.rs.getString("owner"));
				desc.setText(oc.rs.getString("description"));
				categorie.setText(oc.rs.getString("categorie"));
				wilaya.setText(oc.rs.getString("wilaya"));
			}
			
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}

	}
}
