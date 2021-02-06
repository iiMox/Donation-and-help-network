import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PosteJob extends JPanel {

	/**
	 * Create the panel.
	 */
	public PosteJob(int code) {
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
		
		JLabel duration = new JLabel("");
		duration.setOpaque(true);
		duration.setBackground(Color.decode("#4b6584"));
		duration.setForeground(Color.WHITE);
		duration.setHorizontalAlignment(SwingConstants.CENTER);
		duration.setFont(new Font("Open Sans", Font.BOLD, 14));
		duration.setBounds(10, 204, 180, 25);
		add(duration);
		
		JLabel wilaya = new JLabel("Wilaya");
		wilaya.setOpaque(true);
		wilaya.setHorizontalAlignment(SwingConstants.CENTER);
		wilaya.setForeground(Color.WHITE);
		wilaya.setFont(new Font("Open Sans", Font.BOLD, 14));
		wilaya.setBackground(new Color(29,191,115));
		wilaya.setBounds(410, 204, 180, 25);
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
		date.setBounds(440, 55, 150, 14);
		add(date);
		
		JLabel salaire = new JLabel("");
		salaire.setOpaque(true);
		salaire.setHorizontalAlignment(SwingConstants.CENTER);
		salaire.setForeground(Color.WHITE);
		salaire.setFont(new Font("Open Sans", Font.BOLD, 14));
		salaire.setBackground(Color.RED);
		salaire.setBounds(210, 204, 180, 25);
		add(salaire);
		
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select * from jobs where code =?");
			oc.stmt.setInt(1, code);
			oc.rs= oc.stmt.executeQuery();
			while(oc.rs.next()) {
				title.setText(oc.rs.getString("titre"));
				desc.setText(oc.rs.getString("description"));
				owner.setText(oc.rs.getString("owner"));
				wilaya.setText(oc.rs.getString("wilaya"));
				duration.setText("La durée : " + oc.rs.getInt("duration") + " jrs");
				salaire.setText("Le salaire : " + oc.rs.getString("salaire") + " DA");
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Timestamp sql_date = oc.rs.getTimestamp("date_job");
				java.util.Date utilDate = new java.util.Date(sql_date.getTime());
				String dt = formatter.format(utilDate);
				date.setText(dt);
			}
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}

	
	}
}
