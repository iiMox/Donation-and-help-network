import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PosteDon extends JPanel {
	
	public JLabel owner;
	
	public void getTel(String Owner) {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select tel From Users where username = ?");
			oc.stmt.setString(1, Owner);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				owner.setText(Owner+" | Tel : 0"+oc.rs.getInt("tel"));
			}
			oc.con.close();			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion � la base de donn�es");
		}
	}

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
		categorie.setBounds(10, 204, 200, 25);
		add(categorie);
		
		JLabel wilaya = new JLabel("Wilaya");
		wilaya.setOpaque(true);
		wilaya.setHorizontalAlignment(SwingConstants.CENTER);
		wilaya.setForeground(Color.WHITE);
		wilaya.setFont(new Font("Open Sans", Font.BOLD, 14));
		wilaya.setBackground(new Color(29,191,115));
		wilaya.setBounds(440, 204, 150, 25);
		add(wilaya);
		
		owner = new JLabel("Username");
		owner.setFont(new Font("Open Sans", Font.PLAIN, 14));
		owner.setBounds(10, 54, 450, 15);
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
		date.setBounds(440, 55, 150, 14);
		add(date);
		
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select * From Dons where code = ?");
			oc.stmt.setInt(1, code);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				title.setText(oc.rs.getString("title"));
				getTel(oc.rs.getString("owner"));
				desc.setText(oc.rs.getString("description"));
				categorie.setText(oc.rs.getString("categorie"));
				wilaya.setText(oc.rs.getString("wilaya"));
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Timestamp sql_date = oc.rs.getTimestamp("date_don");
				java.util.Date utilDate = new java.util.Date(sql_date.getTime());
				String dt = formatter.format(utilDate);
				date.setText(dt);
			}
			oc.con.close();			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion � la base de donn�es");
		}

	}
}
