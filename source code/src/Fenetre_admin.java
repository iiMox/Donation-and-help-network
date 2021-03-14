import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;


public class Fenetre_admin extends JFrame {

	private JPanel contentPane;
	private JPanel panel_accueil,panel_dons,panel_jobs,panel_stats,panel_separator0,panel_separator1,panel_separator2,panel_separator3,panel_separator4,panel_separator5,panel_separator6,accueil_container,dons_container,jobs_container,stats_container,profil_container;
	private JLabel stat1_number,stat2_number,stat3_number,stat4_number,stat5_number,stat6_number;
	private JTable table,table1,table_users;
	private DefaultTableModel model,model1,model_users; 
	
	/**
	 * Create the frame.
	 */
	
	void getStats( String date1, String date2) {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select count(*) as c1 from Dons where date_don<TO_DATE(?,'dd-MM-yyyy HH24:MI') and date_don>TO_DATE(?,'dd-MM-yyyy HH24:MI')");
			oc.stmt.setString(1, date1);
			oc.stmt.setString(2, date2);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat1_number.setText(String.valueOf(oc.rs.getInt("c1")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c2 from Dons where etat ='Actif' and date_don<TO_DATE(?,'dd-MM-yyyy HH24:MI') and date_don>TO_DATE(?,'dd-MM-yyyy HH24:MI')");
			oc.stmt.setString(1, date1);
			oc.stmt.setString(2, date2);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat2_number.setText(String.valueOf(oc.rs.getInt("c2")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c3 from Dons where etat ='En attend' and date_don<TO_DATE(?,'dd-MM-yyyy HH24:MI') and date_don>TO_DATE(?,'dd-MM-yyyy HH24:MI')");
			oc.stmt.setString(1, date1);
			oc.stmt.setString(2, date2);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat3_number.setText(String.valueOf(oc.rs.getInt("c3")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c4 from jobs where date_Job<TO_DATE(?,'dd-MM-yyyy HH24:MI') and date_job>TO_DATE(?,'dd-MM-yyyy HH24:MI')");
			oc.stmt.setString(1, date1);
			oc.stmt.setString(2, date2);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat4_number.setText(String.valueOf(oc.rs.getInt("c4")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c5 from jobs where etat ='Actif' and date_Job<TO_DATE(?,'dd-MM-yyyy HH24:MI') and date_job>TO_DATE(?,'dd-MM-yyyy HH24:MI')");
			oc.stmt.setString(1, date1);
			oc.stmt.setString(2, date2);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat5_number.setText(String.valueOf(oc.rs.getInt("c5")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c6 from jobs where etat ='En attend' and date_Job<TO_DATE(?,'dd-MM-yyyy HH24:MI') and date_job>TO_DATE(?,'dd-MM-yyyy HH24:MI')");
			oc.stmt.setString(1, date1);
			oc.stmt.setString(2, date2);
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat6_number.setText(String.valueOf(oc.rs.getInt("c6")));
			}
			oc.con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	void getAllStats() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt = oc.con.prepareStatement("Select count(*) as c1 from Dons");
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat1_number.setText(String.valueOf(oc.rs.getInt("c1")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c2 from Dons where etat ='Actif'");
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat2_number.setText(String.valueOf(oc.rs.getInt("c2")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c3 from Dons where etat ='En attend'");
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat3_number.setText(String.valueOf(oc.rs.getInt("c3")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c4 from jobs");
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat4_number.setText(String.valueOf(oc.rs.getInt("c4")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c5 from jobs where etat ='Actif'");
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat5_number.setText(String.valueOf(oc.rs.getInt("c5")));
			}
			
			oc.stmt = oc.con.prepareStatement("Select count(*) as c6 from jobs where etat ='En attend'");
			oc.rs = oc.stmt.executeQuery();
			if(oc.rs.next()) {
				stat6_number.setText(String.valueOf(oc.rs.getInt("c6")));
			}
			oc.con.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void actualiserAcceuil() {
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		int nb=0;
		int x=30;
		try {
			oc.stmt = oc.con.prepareStatement("select * from dons where etat='En attend' order by date_don Desc");
			oc.rs= oc.stmt.executeQuery();
			while(oc.rs.next() & nb<3) {
				accueil_container.add(new AccueilPosteContainer(oc.rs.getString("title"),oc.rs.getString("description"),oc.rs.getString("wilaya"),x));
				nb++;
				x+=227;
			}
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		
		oc.initialize();
		nb=0;
		x=30;
		try {
			oc.stmt = oc.con.prepareStatement("select * from Jobs where etat='En attend' order by date_job Desc");
			oc.rs= oc.stmt.executeQuery();
			while(oc.rs.next() & nb<3) {
				accueil_container.add(new AccueilOffreContainer(oc.rs.getString("titre"),oc.rs.getString("description"),oc.rs.getString("wilaya"),x));
				nb++;
				x+=227;
			}
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void actualiserDon() {
		model.setRowCount(0);
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt=oc.con.prepareStatement("Select * From Dons order by date_don DESC");
	
			oc.rs=oc.stmt.executeQuery();
			while(oc.rs.next()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Timestamp sql_date = oc.rs.getTimestamp("date_don");
				java.util.Date utilDate = new java.util.Date(sql_date.getTime());
				String dt = formatter.format(utilDate);
				model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("title"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("categorie"), oc.rs.getString("wilaya"), oc.rs.getString("etat")});
			}
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void actualiserJob() {
		OracleConnection oc = new OracleConnection();
		model1.setRowCount(0);
		oc.initialize();
		try {
			oc.stmt=oc.con.prepareStatement("Select * From Jobs order by date_job DESC");
	
			oc.rs=oc.stmt.executeQuery();
			while(oc.rs.next()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Timestamp sql_date = oc.rs.getTimestamp("date_job");
				java.util.Date utilDate = new java.util.Date(sql_date.getTime());
				String dt = formatter.format(utilDate);
				model1.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("titre"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("wilaya"), oc.rs.getString("Salaire"), oc.rs.getString("duration"), oc.rs.getString("etat")});
			}
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public void actualiserUsers() {
		model_users.setRowCount(0);
		OracleConnection oc = new OracleConnection();
		oc.initialize();
		try {
			oc.stmt=oc.con.prepareStatement("Select * From Users where type='user' order by ID DESC");
			oc.rs=oc.stmt.executeQuery();
			while(oc.rs.next()) {
				if(oc.rs.getTimestamp("DATE_NAISSANCE")!=null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					Timestamp sql_date = oc.rs.getTimestamp("DATE_NAISSANCE");
					java.util.Date utilDate = new java.util.Date(sql_date.getTime());
					String dt = formatter.format(utilDate);
					model_users.addRow(new Object[]{oc.rs.getInt("id"), oc.rs.getString("username"), oc.rs.getString("password"), oc.rs.getString("email"), oc.rs.getString("nom"), oc.rs.getString("prenom"), dt, oc.rs.getString("adresse"), oc.rs.getString("wilaya"), oc.rs.getInt("tel")});
				} else {
					model_users.addRow(new Object[]{oc.rs.getInt("id"), oc.rs.getString("username"), oc.rs.getString("password"), oc.rs.getString("email"), oc.rs.getString("nom"), oc.rs.getString("prenom"), "", oc.rs.getString("adresse"), oc.rs.getString("wilaya"), oc.rs.getInt("tel")});
				}
				
			}
			oc.con.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
	}
	
	public Fenetre_admin() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				actualiserAcceuil();
				actualiserDon();
				actualiserJob();
				actualiserUsers();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		stat1_number = new JLabel();
        stat2_number = new JLabel();
        stat3_number = new JLabel();
        stat4_number = new JLabel();
        stat5_number = new JLabel();
        stat6_number = new JLabel();
		
		setTitle("Fen\u00EAtre administrateur");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre_user.class.getResource("/images/login_icon.png")));
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(29, 191, 115));
		panel.setBounds(1, 1, 290, 727);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(92, 20, 106, 47);
		panel.add(lblNewLabel);
		
		
		panel_accueil = new JPanel();
		panel_accueil.setBackground(Color.decode("#1db36d"));		
		panel_accueil.addMouseListener(new MouseAdapter() {
			/*@Override
			public void mouseEntered(MouseEvent e) {
				panel_accueil.setBackground(Color.decode("#1db36d"));

			}*/
			/*@Override
			public void mouseExited(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
			}*/
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(Color.decode("#1db36d"));
				panel_dons.setBackground(panel.getBackground());
				panel_jobs.setBackground(panel.getBackground());
				panel_stats.setBackground(panel.getBackground());
				
				accueil_container.setVisible(true);
				dons_container.setVisible(false);
				jobs_container.setVisible(false);
				stats_container.setVisible(false);
				profil_container.setVisible(false);
				
				actualiserAcceuil();
			}
		});
		panel_accueil.setBackground(new Color(29, 191, 115, 0));
		panel_accueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_accueil.setBounds(0, 101, 290, 98);
		panel.add(panel_accueil);
		panel_accueil.setLayout(null);
		
		JLabel accueil_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/home_icon.png")));
		accueil_icon.setLocation(20, 25);
		accueil_icon.setSize(40, 40);
		panel_accueil.add(accueil_icon);
		
		JLabel lblNewLabel_1 = new JLabel("Accueil");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(70, 25, 120, 45);
		panel_accueil.add(lblNewLabel_1);
		
		panel_dons = new JPanel();
		panel_dons.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_dons.setBackground(new Color(29, 191, 115, 0));
		panel_dons.setBounds(0, 201, 290, 98);
		panel.add(panel_dons);
		panel_dons.setLayout(null);
		panel_dons.addMouseListener(new MouseAdapter() {
			/*@Override
			public void mouseEntered(MouseEvent e) {
				panel_dons.setBackground(Color.decode("#1db36d"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_dons.setBackground(panel.getBackground());
			}*/
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
				panel_dons.setBackground(Color.decode("#1db36d"));
				panel_jobs.setBackground(panel.getBackground());
				panel_stats.setBackground(panel.getBackground());
				
				accueil_container.setVisible(false);
				dons_container.setVisible(true);
				jobs_container.setVisible(false);
				stats_container.setVisible(false);
				profil_container.setVisible(false);
				
				actualiserDon();
			}
		});
		
		JLabel dons_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/donation_icon.png")));
		dons_icon.setLocation(20, 25);
		dons_icon.setSize(40, 40);
		panel_dons.add(dons_icon);
		
		JLabel lblNewLabel_2 = new JLabel("Les dons");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(70, 25, 120, 36);
		panel_dons.add(lblNewLabel_2);
		
		panel_jobs = new JPanel();
		panel_jobs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_jobs.setBackground(new Color(29, 191, 115, 0));
		panel_jobs.setBounds(0, 301, 290, 98);
		panel.add(panel_jobs);
		panel_jobs.setLayout(null);
		panel_jobs.addMouseListener(new MouseAdapter() {
			/*@Override
			public void mouseEntered(MouseEvent e) {
				panel_jobs.setBackground(Color.decode("#1db36d"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_jobs.setBackground(panel.getBackground());
			}*/
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
				panel_dons.setBackground(panel.getBackground());
				panel_jobs.setBackground(Color.decode("#1db36d"));
				panel_stats.setBackground(panel.getBackground());
				
				accueil_container.setVisible(false);
				dons_container.setVisible(false);
				jobs_container.setVisible(true);
				stats_container.setVisible(false);
				profil_container.setVisible(false);
				
				actualiserJob();
			}
		});
		
		JLabel jobs_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/job_icon.png")));
		jobs_icon.setLocation(20, 25);
		jobs_icon.setSize(40, 40);
		panel_jobs.add(jobs_icon);
		
		JLabel lblNewLabel_3 = new JLabel("Les offres");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(70, 25, 210, 36);
		panel_jobs.add(lblNewLabel_3);
		
		panel_stats = new JPanel();
		panel_stats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_stats.setBackground(new Color(29, 191, 115, 0));
		panel_stats.setBounds(0, 401, 290, 98);
		panel.add(panel_stats);
		panel_stats.setLayout(null);
		panel_stats.addMouseListener(new MouseAdapter() {
			/*@Override
			public void mouseEntered(MouseEvent e) {
				panel_stats.setBackground(Color.decode("#1db36d"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_stats.setBackground(panel.getBackground());
			}*/
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
				panel_dons.setBackground(panel.getBackground());
				panel_jobs.setBackground(panel.getBackground());
				panel_stats.setBackground(Color.decode("#1db36d"));
				
				accueil_container.setVisible(false);
				dons_container.setVisible(false);
				jobs_container.setVisible(false);
				stats_container.setVisible(true);
				profil_container.setVisible(false);
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				java.util.Date utilDate = new Date();
				String dt = formatter.format(utilDate);
				utilDate.setHours(00);
				utilDate.setMinutes(00);
				String dt2 = formatter.format(utilDate);
				getStats(dt,dt2);
			}
		});
		
		JLabel stats_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/stats_icon.png")));
		stats_icon.setLocation(20, 25);
		stats_icon.setSize(40, 40);
		panel_stats.add(stats_icon);
		
		JLabel lblNewLabel_4 = new JLabel("Statistiques");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(70, 29, 141, 33);
		panel_stats.add(lblNewLabel_4);
		
		JPanel panel_profile = new JPanel();
		panel_profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_profile.setBackground(Color.decode("#4b6584"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_profile.setBackground(Color.decode("#1dbf73"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
				panel_dons.setBackground(panel.getBackground());
				panel_jobs.setBackground(panel.getBackground());
				panel_stats.setBackground(panel.getBackground());
				
				accueil_container.setVisible(false);
				dons_container.setVisible(false);
				jobs_container.setVisible(false);
				stats_container.setVisible(false);
				profil_container.setVisible(true);
				
				actualiserUsers();

			}
		});
		panel_profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_profile.setBackground(Color.decode("#1dbf73"));
		panel_profile.setBounds(0, 629, 144, 98);
		panel.add(panel_profile);
		panel_profile.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Utilisateurs");
		lblNewLabel_5.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 58, 144, 25);
		panel_profile.add(lblNewLabel_5);
		
		JPanel panel_logout = new JPanel();
		panel_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Est-ce que vous voulez déconnecter", "Confirmation", JOptionPane.YES_NO_OPTION);

				if (opcion == 0) { //The ISSUE is here
					Fenetre_authentification.main(null);
					setVisible(false);
					dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_logout.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_logout.setBackground(Color.decode("#1dbf73"));
			}
		});
		panel_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_logout.setBackground(Color.decode("#1dbf73"));
		panel_logout.setBounds(146, 629, 144, 98);
		panel.add(panel_logout);
		panel_logout.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Sortir");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(35, 58, 74, 25);
		panel_logout.add(lblNewLabel_6);
		
		JLabel profile_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/profile_icon.png")));
		profile_icon.setLocation(56, 13);
		profile_icon.setSize(32, 32);
		panel_profile.add(profile_icon);
		
		JLabel logout_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/logout_icon.png")));
		logout_icon.setLocation(56, 13);
		logout_icon.setSize(32, 32);
		panel_logout.add(logout_icon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#c0c0c0"));
		panel_1.setBounds(291, 0, 1, 729);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#c0c0c0"));
		panel_2.setBounds(0, 0, 1008, 1);
		getContentPane().add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.decode("#c0c0c0"));
		panel_1_1.setBounds(1007, 0, 1, 729);
		getContentPane().add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#c0c0c0"));
		panel_2_1.setBounds(0, 728, 1008, 1);
		getContentPane().add(panel_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.decode("#c0c0c0"));
		panel_1_2.setBounds(0, 0, 1, 729);
		getContentPane().add(panel_1_2);
		
		panel_separator0 = new JPanel();
		panel_separator0.setBackground(Color.WHITE);
		panel_separator0.setBounds(0, 99, 290, 2);
		panel.add(panel_separator0);
		
		panel_separator1 = new JPanel();
		panel_separator1.setBackground(Color.WHITE);
		panel_separator1.setBounds(0, 199, 290, 2);
		panel.add(panel_separator1);
		
		panel_separator2 = new JPanel();
		panel_separator2.setBackground(Color.WHITE);
		panel_separator2.setBounds(0, 299, 290, 2);
		panel.add(panel_separator2);
		
		panel_separator3 = new JPanel();
		panel_separator3.setBackground(Color.WHITE);
		panel_separator3.setBounds(0, 399, 290, 2);
		panel.add(panel_separator3);
		
		panel_separator4 = new JPanel();
		panel_separator4.setBackground(Color.WHITE);
		panel_separator4.setBounds(0, 499, 290, 2);
		panel.add(panel_separator4);
		
		panel_separator5 = new JPanel();
		panel_separator5.setBackground(Color.WHITE);
		panel_separator5.setBounds(0, 627, 290, 2);
		panel.add(panel_separator5);
		
		panel_separator6 = new JPanel();
		panel_separator6.setBackground(Color.WHITE);
		panel_separator6.setBounds(144, 627, 2, 100);
		panel.add(panel_separator6);
		
		JPanel panel_containers = new JPanel();
		panel_containers.setBackground(Color.WHITE);
		panel_containers.setBounds(293, 1, 715, 727);
		getContentPane().add(panel_containers);
		panel_containers.setLayout(null);
		
		accueil_container = new JPanel();
		accueil_container.setBounds(0, 0, 715, 727);
		panel_containers.add(accueil_container);
		accueil_container.setLayout(null);
		
		JPanel accueil_panel_3 = new JPanel();
		accueil_panel_3.setBorder(UIManager.getBorder("TextField.border"));
		accueil_panel_3.setBackground(Color.WHITE);
		accueil_panel_3.setBounds(30, 30, 654, 80);
		accueil_container.add(accueil_panel_3);
		accueil_panel_3.setLayout(null);
		
		JLabel accueil_lblNewLabel_7 = new JLabel("ACCUEIL");
		accueil_lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		accueil_lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 25));
		accueil_lblNewLabel_7.setBackground(Color.WHITE);
		accueil_lblNewLabel_7.setBounds(217, 20, 220, 40);
		accueil_panel_3.add(accueil_lblNewLabel_7);
		
		JLabel accueil_lblNewLabel_8 = new JLabel("Postes r\u00E9cents");
		accueil_lblNewLabel_8.setFont(new Font("Open Sans", Font.BOLD, 20));
		accueil_lblNewLabel_8.setBounds(30, 140, 150, 20);
		accueil_container.add(accueil_lblNewLabel_8);
		
		JSeparator accueil_separator_1 = new JSeparator();
		accueil_separator_1.setBackground(Color.WHITE);
		accueil_separator_1.setForeground(Color.WHITE);
		accueil_separator_1.setBounds(30, 170, 654, 2);
		accueil_container.add(accueil_separator_1);
		
		actualiserAcceuil();
				
		JButton accueil_postes_voirplus = new JButton("Voir plus ..");
		accueil_postes_voirplus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
				panel_dons.setBackground(Color.decode("#1db36d"));
				panel_jobs.setBackground(panel.getBackground());
				panel_stats.setBackground(panel.getBackground());
				
				accueil_container.setVisible(false);
				dons_container.setVisible(true);
				jobs_container.setVisible(false);
				stats_container.setVisible(false);
				profil_container.setVisible(false);
			}
		});
		accueil_postes_voirplus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accueil_postes_voirplus.setBackground(Color.decode("#1DBF73"));
		accueil_postes_voirplus.setBorder(null);
		accueil_postes_voirplus.setForeground(Color.WHITE);
		accueil_postes_voirplus.setFont(new Font("Open Sans", Font.BOLD, 13));
		accueil_postes_voirplus.setBounds(559, 350, 125, 35);
		accueil_container.add(accueil_postes_voirplus);
		
		JLabel accueil_lblNewLabel_9 = new JLabel("Offres r\u00E9cents");
		accueil_lblNewLabel_9.setFont(new Font("Open Sans", Font.BOLD, 20));
		accueil_lblNewLabel_9.setBounds(30, 400, 150, 20);
		accueil_container.add(accueil_lblNewLabel_9);
		
		JSeparator accueil_separator_2 = new JSeparator();
		accueil_separator_2.setForeground(Color.WHITE);
		accueil_separator_2.setBackground(Color.WHITE);
		accueil_separator_2.setBounds(30, 430, 654, 2);
		accueil_container.add(accueil_separator_2);
		
		JButton accueil_offres_voirplus = new JButton("Voir plus ..");
		accueil_offres_voirplus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_accueil.setBackground(panel.getBackground());
				panel_dons.setBackground(panel.getBackground());
				panel_jobs.setBackground(Color.decode("#1db36d"));
				panel_stats.setBackground(panel.getBackground());
				
				accueil_container.setVisible(false);
				dons_container.setVisible(false);
				jobs_container.setVisible(true);
				stats_container.setVisible(false);
				profil_container.setVisible(false);
			}
		});
		accueil_offres_voirplus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accueil_offres_voirplus.setForeground(Color.WHITE);
		accueil_offres_voirplus.setFont(new Font("Open Sans", Font.BOLD, 13));
		accueil_offres_voirplus.setBorder(null);
		accueil_offres_voirplus.setBackground(new Color(29, 191, 115));
		accueil_offres_voirplus.setBounds(559, 612, 125, 35);
		accueil_container.add(accueil_offres_voirplus);
		
		dons_container = new JPanel();
		dons_container.setVisible(false);
		dons_container.setBounds(0, 0, 715, 727);
		panel_containers.add(dons_container);
		dons_container.setLayout(null);
		
		JPanel dons_panel_3 = new JPanel();
		dons_panel_3.setBounds(30, 30, 654, 80);
		dons_panel_3.setBorder(UIManager.getBorder("TextField.border"));
		dons_panel_3.setBackground(Color.WHITE);
		dons_container.add(dons_panel_3);
		dons_panel_3.setLayout(null);
		
		JLabel dons_lblNewLabel_7 = new JLabel("LES POSTES DE DON");
		dons_lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		dons_lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 25));
		dons_lblNewLabel_7.setBounds(177, 20, 300, 40);
		dons_panel_3.add(dons_lblNewLabel_7);
		
		JLabel lblNewLabel_7_dons = new JLabel("Etat de l'article :");
		lblNewLabel_7_dons.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNewLabel_7_dons.setBounds(30, 157, 120, 20);
		dons_container.add(lblNewLabel_7_dons);
		
		String groupes_dons[] = {"Actif","En attend","Fermer","Tous"};
		
		table = new JTable();
		
		model = (DefaultTableModel)table.getModel();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		scrollPane.setBounds(30, 203, 654, 450);
		scrollPane.setViewportView(table);
		model.addColumn("CODE");
		model.addColumn("TITLE");
		model.addColumn("DESCRIPTION");
		model.addColumn("DATE CREATION");
		model.addColumn("POPRIETAIRE");
		model.addColumn("CATEGORIE");
		model.addColumn("WILAYA");
		model.addColumn("ETAT");
		table.getColumnModel().getColumn(3).setWidth(100);
		dons_container.add(scrollPane);
		table.setBorder(null);
		table.setRowHeight(30);
		table.setFont(new Font("Open Sans", Font.PLAIN, 15));
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(300);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(200);
		table.getColumnModel().getColumn(5).setMinWidth(200);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		
		OracleConnection oc = new OracleConnection();
		oc.initialize();		
		
		JComboBox etat_dons = new JComboBox(groupes_dons);
		etat_dons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				if(etat_dons.getSelectedItem().equals("Actif")) {
					
					oc.initialize();
					
					try {
						oc.stmt=oc.con.prepareStatement("Select * From Dons where etat='Actif' order by date_don DESC");
						oc.rs=oc.stmt.executeQuery();
						while(oc.rs.next()) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
							Timestamp sql_date = oc.rs.getTimestamp("date_don");
							java.util.Date utilDate = new java.util.Date(sql_date.getTime());
							String dt = formatter.format(utilDate);
							model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("title"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("categorie"), oc.rs.getString("wilaya"), oc.rs.getString("etat")});
						}
						oc.con.close();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
					}
					
				} else if(etat_dons.getSelectedItem().equals("En attend")) {

					oc.initialize();
					
					try {
						oc.stmt=oc.con.prepareStatement("Select * From Dons where etat='En attend' order by date_don DESC");
						oc.rs=oc.stmt.executeQuery();
						while(oc.rs.next()) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
							Timestamp sql_date = oc.rs.getTimestamp("date_don");
							java.util.Date utilDate = new java.util.Date(sql_date.getTime());
							String dt = formatter.format(utilDate);
							model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("title"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("categorie"), oc.rs.getString("wilaya"), oc.rs.getString("etat")});
						}
						oc.con.close();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
					}
					
				} else if(etat_dons.getSelectedItem().equals("Fermer")) {

					oc.initialize();
					
					try {
						oc.stmt=oc.con.prepareStatement("Select * From Dons where etat='Fermer' order by date_don DESC");
						oc.rs=oc.stmt.executeQuery();
						while(oc.rs.next()) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
							Timestamp sql_date = oc.rs.getTimestamp("date_don");
							java.util.Date utilDate = new java.util.Date(sql_date.getTime());
							String dt = formatter.format(utilDate);
							model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("title"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("categorie"), oc.rs.getString("wilaya"), oc.rs.getString("etat")});
						}
						oc.con.close();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
					}
					
				} else {

					oc.initialize();
					
					try {
						oc.stmt=oc.con.prepareStatement("Select * From Dons order by date_don DESC");
						oc.rs=oc.stmt.executeQuery();
						while(oc.rs.next()) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
							Timestamp sql_date = oc.rs.getTimestamp("date_don");
							java.util.Date utilDate = new java.util.Date(sql_date.getTime());
							String dt = formatter.format(utilDate);
							model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("title"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("categorie"), oc.rs.getString("wilaya"), oc.rs.getString("etat")});
						}
						oc.con.close();
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
					}
					
				}
			}
		});
		etat_dons.setSelectedItem("Tous");
		etat_dons.setFont(new Font("Open Sans", Font.PLAIN, 13));
		etat_dons.setBackground(Color.WHITE);
		etat_dons.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		etat_dons.setBorder(null);
		etat_dons.setBounds(150, 157, 120, 20);
		dons_container.add(etat_dons);
		
		JSeparator separator_dons = new JSeparator();
		separator_dons.setForeground(Color.WHITE);
		separator_dons.setBounds(30, 185, 654, 2);
		dons_container.add(separator_dons);
		
		JLabel delete_icon_don = new JLabel(new ImageIcon(Mes_Offres.class.getResource("/images/remove.png")));
		delete_icon_don.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {
					int opcion = JOptionPane.showConfirmDialog(null, "Es-tu sur de supprimer l'article?", "Confirmation", JOptionPane.YES_NO_OPTION);

					if (opcion == 0) { 
						Don d = new Don();
						d.setCode((int)table.getValueAt(table.getSelectedRow(), 0));
						d.supprimer_don();
					}
				}
			}
		});
		delete_icon_don.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete_icon_don.setLocation(644, 135);
		delete_icon_don.setSize(40, 40);
		dons_container.add(delete_icon_don);
		
		JButton btnchanger_etat = new JButton("CHANGER ETAT");
		btnchanger_etat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnchanger_etat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {
					
					Changer_etat_don c = new Changer_etat_don((int)table.getValueAt(table.getSelectedRow(), 0));
					c.setVisible(true);
				}
			}
		});
		btnchanger_etat.setForeground(Color.WHITE);
		btnchanger_etat.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnchanger_etat.setBorder(null);
		btnchanger_etat.setBackground(Color.RED);
		btnchanger_etat.setBounds(270, 660, 175, 50);
		dons_container.add(btnchanger_etat);
			
		jobs_container = new JPanel();
		jobs_container.setVisible(false);
		jobs_container.setBounds(0, 0, 715, 727);
		panel_containers.add(jobs_container);
		jobs_container.setLayout(null);
		
		JPanel jobs_panel_3 = new JPanel();
		jobs_panel_3.setBounds(30, 30, 654, 80);
		jobs_panel_3.setBorder(UIManager.getBorder("TextField.border"));
		jobs_panel_3.setBackground(Color.WHITE);
		jobs_container.add(jobs_panel_3);
		jobs_panel_3.setLayout(null);
		
		JLabel jobs_lblNewLabel_7 = new JLabel("LES OFFRES D'EMPLOI");
		jobs_lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		jobs_lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 25));
		jobs_lblNewLabel_7.setBounds(177, 20, 300, 40);
		jobs_panel_3.add(jobs_lblNewLabel_7);
		
		JLabel lblNewLabel_7_jobs = new JLabel("Etat de l'offre :");
		lblNewLabel_7_jobs.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNewLabel_7_jobs.setBounds(30, 157, 120, 20);
		jobs_container.add(lblNewLabel_7_jobs);
		
		table1 = new JTable();
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBorder(UIManager.getBorder("TextField.border"));
		scrollPane1.setBounds(30, 203, 654, 450);
		scrollPane1.setViewportView(table1);
		model1 = (DefaultTableModel)table1.getModel();
		model1.addColumn("CODE");
		model1.addColumn("TITLE");
		model1.addColumn("DESCRIPTION");
		model1.addColumn("DATE CREATION");
		model1.addColumn("PROPRIETAIRE");
		model1.addColumn("WILAYA");
		model1.addColumn("SALAIRE");
		model1.addColumn("DUREE");
		model1.addColumn("ETAT");
		table1.getColumnModel().getColumn(3).setWidth(100);
		jobs_container.add(scrollPane1);
		table1.setBorder(null);
		table1.setRowHeight(30);
		table1.setFont(new Font("Open Sans", Font.PLAIN, 15));
		table1.getColumnModel().getColumn(0).setMinWidth(40);
		table1.getColumnModel().getColumn(1).setMinWidth(200);
		table1.getColumnModel().getColumn(2).setMinWidth(300);
		table1.getColumnModel().getColumn(3).setMinWidth(150);
		table1.getColumnModel().getColumn(4).setMinWidth(200);
		table1.getColumnModel().getColumn(5).setMinWidth(200);
		table1.getColumnModel().getColumn(6).setMinWidth(200);
		table1.getColumnModel().getColumn(7).setMinWidth(100);		
		
		JComboBox etat_jobs = new JComboBox(groupes_dons);
		etat_jobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					DefaultTableModel dtm1 = (DefaultTableModel) table1.getModel();
					dtm1.setRowCount(0);
					if(etat_jobs.getSelectedItem().equals("Actif")) {
						
						oc.initialize();
						
						try {
							oc.stmt=oc.con.prepareStatement("Select * From Jobs where etat='actif' order by date_job DESC");
							
							oc.rs=oc.stmt.executeQuery();
							while(oc.rs.next()) {
								SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
								Timestamp sql_date = oc.rs.getTimestamp("date_job");
								java.util.Date utilDate = new java.util.Date(sql_date.getTime());
								String dt = formatter.format(utilDate);
								model1.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("titre"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("wilaya"), oc.rs.getString("Salaire"), oc.rs.getString("duration"), oc.rs.getString("etat")});
							}
							oc.con.close();
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
						}
						
					} else if(etat_jobs.getSelectedItem().equals("En attend")) {

						oc.initialize();
						
						try {
							oc.stmt=oc.con.prepareStatement("Select * From Jobs where etat='en attend' order by date_Job DESC");
							oc.rs=oc.stmt.executeQuery();
							while(oc.rs.next()) {
								SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
								Timestamp sql_date = oc.rs.getTimestamp("date_job");
								java.util.Date utilDate = new java.util.Date(sql_date.getTime());
								String dt = formatter.format(utilDate);
								model1.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("titre"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("wilaya"), oc.rs.getString("Salaire"), oc.rs.getString("duration"), oc.rs.getString("etat")});
							}
							oc.con.close();
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
						}
						
					} else if(etat_jobs.getSelectedItem().equals("Fermer")) {

						oc.initialize();
						
						try {
							oc.stmt=oc.con.prepareStatement("Select * From Jobs where etat='fermer' order by date_job DESC");
							oc.rs=oc.stmt.executeQuery();
							while(oc.rs.next()) {
								SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
								Timestamp sql_date = oc.rs.getTimestamp("date_job");
								java.util.Date utilDate = new java.util.Date(sql_date.getTime());
								String dt = formatter.format(utilDate);
								model1.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("titre"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("wilaya"), oc.rs.getString("Salaire"), oc.rs.getString("duration"), oc.rs.getString("etat")});
							}
							oc.con.close();
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
						}
						
					} else {

						oc.initialize();
						
						try {
							oc.stmt=oc.con.prepareStatement("Select * From Jobs order by date_job DESC");
							oc.rs=oc.stmt.executeQuery();
							while(oc.rs.next()) {
								SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
								Timestamp sql_date = oc.rs.getTimestamp("date_job");
								java.util.Date utilDate = new java.util.Date(sql_date.getTime());
								String dt = formatter.format(utilDate);
								model1.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("titre"), oc.rs.getString("description"), dt, oc.rs.getString("owner"), oc.rs.getString("wilaya"), oc.rs.getString("Salaire"), oc.rs.getString("duration"), oc.rs.getString("etat")});
							}
							oc.con.close();
						} catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
						}
						
					}
				}
			
		});
		etat_jobs.setSelectedItem("Tous");
		etat_jobs.setFont(new Font("Open Sans", Font.PLAIN, 13));
		etat_jobs.setBackground(Color.WHITE);
		etat_jobs.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		etat_jobs.setBorder(null);
		etat_jobs.setBounds(150, 157, 120, 20);
		jobs_container.add(etat_jobs);
		
		JSeparator separator_jobs = new JSeparator();
		separator_jobs.setForeground(Color.WHITE);
		separator_jobs.setBounds(30, 185, 654, 2);
		jobs_container.add(separator_jobs);
		
		JLabel delete_icon_job = new JLabel(new ImageIcon(Mes_Offres.class.getResource("/images/remove.png")));
		delete_icon_job.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table1.getSelectionModel().isSelectionEmpty()) {
					int opcion = JOptionPane.showConfirmDialog(null, "Es-tu sur de supprimer l'offre?", "Confirmation", JOptionPane.YES_NO_OPTION);

					if (opcion == 0) { 
						Job j = new Job();
						j.setCode((int)table1.getValueAt(table1.getSelectedRow(), 0));
						j.supprimer_job();
					}
				}
			}
		});
		delete_icon_job.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete_icon_job.setLocation(644, 135);
		delete_icon_job.setSize(40, 40);
		jobs_container.add(delete_icon_job);
		
		JButton btnchanger_etat_job = new JButton("CHANGER ETAT");
		btnchanger_etat_job.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnchanger_etat_job.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table1.getSelectionModel().isSelectionEmpty()) {
					
					Changer_etat_job c1 = new Changer_etat_job((int)table1.getValueAt(table1.getSelectedRow(), 0));
					c1.setVisible(true);
				}
			}
		});
		btnchanger_etat_job.setForeground(Color.WHITE);
		btnchanger_etat_job.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnchanger_etat_job.setBorder(null);
		btnchanger_etat_job.setBackground(Color.RED);
		btnchanger_etat_job.setBounds(270, 660, 175, 50);
		jobs_container.add(btnchanger_etat_job);
		
		stats_container = new JPanel();
		stats_container.setVisible(false);
		stats_container.setBounds(0, 0, 715, 727);
		panel_containers.add(stats_container);
		stats_container.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(30, 185, 654, 2);
		stats_container.add(separator);
		
		JPanel stats_panel_3 = new JPanel();
		stats_panel_3.setBounds(30, 30, 654, 80);
		stats_panel_3.setBorder(UIManager.getBorder("TextField.border"));
		stats_panel_3.setBackground(Color.WHITE);
		stats_container.add(stats_panel_3);
		stats_panel_3.setLayout(null);
		
		JLabel stats_lblNewLabel_7 = new JLabel("STATISTIQUES");
		stats_lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		stats_lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 25));
		stats_lblNewLabel_7.setBounds(177, 20, 300, 40);
		stats_panel_3.add(stats_lblNewLabel_7);
		
		JLabel lblNewLabel_7 = new JLabel("Interval :");
		lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNewLabel_7.setBounds(30, 157, 70, 20);
		stats_container.add(lblNewLabel_7);
		
		String groupes[] = {"Aujourd'hui","7 Jours","Dernier Mois","1 AN","Tous"};
		
		JComboBox intervall = new JComboBox(groupes);
		intervall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(intervall.getSelectedItem().equals("Aujourd'hui")) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					java.util.Date utilDate = new Date();
					String dt = formatter.format(utilDate);
					utilDate.setHours(00);
					utilDate.setMinutes(00);
					String dt2 = formatter.format(utilDate);
					getStats(dt,dt2);
				} else if(intervall.getSelectedItem().equals("7 Jours")) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					java.util.Date utilDate = new Date();
					String dt = formatter.format(utilDate);
					utilDate.setDate(utilDate.getDate()-7);
					String dt2 = formatter.format(utilDate);
					getStats(dt,dt2);
				} else if(intervall.getSelectedItem().equals("Dernier Mois")) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					java.util.Date utilDate = new Date();
					String dt = formatter.format(utilDate);
					utilDate.setMonth(utilDate.getMonth()-1);
					String dt2 = formatter.format(utilDate);
					getStats(dt,dt2);
				} else if(intervall.getSelectedItem().equals("1 AN")) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					java.util.Date utilDate = new Date();
					String dt = formatter.format(utilDate);
					utilDate.setYear(utilDate.getYear()-1);
					String dt2 = formatter.format(utilDate);
					getStats(dt,dt2);
				} else {
					getAllStats();
				}
			}
		});

		intervall.setFont(new Font("Open Sans", Font.PLAIN, 13));
		intervall.setBackground(Color.WHITE);
		intervall.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		intervall.setBorder(null);
		intervall.setBounds(98, 157, 120, 20);
		stats_container.add(intervall);
		
		JPanel stat_containe1 = new JPanel();
		stat_containe1.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe1.setBackground(Color.WHITE);
		stat_containe1.setBounds(30, 225, 211, 200);
		stats_container.add(stat_containe1);
		stat_containe1.setLayout(null);
		
		JLabel stat1_title = new JLabel("Total articles");
		stat1_title.setForeground(Color.BLACK);
		stat1_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat1_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat1_title.setBounds(0, 20, 211, 20);
		stat_containe1.add(stat1_title);
		
		JLabel stat1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/heart-5.png")));
		stat1_icon.setLocation(44, 90);
		stat1_icon.setSize(32, 32);
		stat_containe1.add(stat1_icon);
		
		stat1_number.setForeground(Color.BLACK);
		stat1_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat1_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat1_number.setBounds(78, 56, 90, 100);
		stat_containe1.add(stat1_number);
		
		JPanel stat_containe2 = new JPanel();
		stat_containe2.setLayout(null);
		stat_containe2.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe2.setBackground(Color.WHITE);
		stat_containe2.setBounds(251, 225, 211, 200);
		stats_container.add(stat_containe2);
		
		JLabel stat2_title = new JLabel("Les articles actifs");
		stat2_title.setForeground(Color.BLACK);
		stat2_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat2_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat2_title.setBounds(0, 20, 211, 20);
		stat_containe2.add(stat2_title);
		
		JLabel stat2_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/heart green.png")));
		stat2_icon.setBounds(44, 90, 32, 32);
		stat_containe2.add(stat2_icon);
		
		stat2_number.setForeground(Color.BLACK);
		stat2_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat2_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat2_number.setBounds(78, 56, 90, 100);
		stat2_number.setForeground(new Color(29, 191, 115));
		stat_containe2.add(stat2_number);
		
		JPanel stat_containe3 = new JPanel();
		stat_containe3.setLayout(null);
		stat_containe3.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe3.setBackground(Color.WHITE);
		stat_containe3.setBounds(473, 225, 211, 200);
		stats_container.add(stat_containe3);
		
		JLabel stat3_title = new JLabel("Les articles en attends");
		stat3_title.setForeground(Color.BLACK);
		stat3_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat3_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat3_title.setBounds(0, 20, 211, 20);
		stat_containe3.add(stat3_title);
		
		JLabel stat3_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/heart red.png")));
		stat3_icon.setBounds(44, 90, 32, 32);
		stat_containe3.add(stat3_icon);
		
		stat3_number.setForeground(Color.BLACK);
		stat3_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat3_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat3_number.setBounds(78, 56, 90, 100);
		stat3_number.setForeground(new Color(231,14,14));
		stat_containe3.add(stat3_number);
		
		JPanel stat_containe4 = new JPanel();
		stat_containe4.setLayout(null);
		stat_containe4.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe4.setBackground(Color.WHITE);
		stat_containe4.setBounds(30, 475, 211, 200);
		stats_container.add(stat_containe4);
		
		JLabel stat4_title = new JLabel("Total offres");
		stat4_title.setForeground(Color.BLACK);
		stat4_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat4_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat4_title.setBounds(0, 20, 211, 20);
		stat_containe4.add(stat4_title);
		
		JLabel stat4_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/suitcase.png")));
		stat4_icon.setBounds(44, 90, 32, 32);
		stat_containe4.add(stat4_icon);
		
		stat4_number.setForeground(Color.BLACK);
		stat4_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat4_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat4_number.setBounds(78, 56, 90, 100);
		stat_containe4.add(stat4_number);
		
		JPanel stat_containe5 = new JPanel();
		stat_containe5.setLayout(null);
		stat_containe5.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe5.setBackground(Color.WHITE);
		stat_containe5.setBounds(251, 475, 211, 200);
		stats_container.add(stat_containe5);
		
		JLabel stat5_title = new JLabel("Les offres actifs");
		stat5_title.setForeground(Color.BLACK);
		stat5_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat5_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat5_title.setBounds(0, 20, 211, 20);
		stat_containe5.add(stat5_title);
		
		JLabel stat5_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/suitcase green.png")));
		stat5_icon.setBounds(44, 90, 32, 32);
		stat_containe5.add(stat5_icon);
		
		stat5_number.setForeground(Color.BLACK);
		stat5_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat5_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat5_number.setBounds(78, 56, 90, 100);
		stat5_number.setForeground(new Color(29, 191, 115));
		stat_containe5.add(stat5_number);
		
		JPanel stat_containe6 = new JPanel();
		stat_containe6.setLayout(null);
		stat_containe6.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe6.setBackground(Color.WHITE);
		stat_containe6.setBounds(473, 475, 211, 200);
		stats_container.add(stat_containe6);
		
		JLabel stat6_title = new JLabel("Les offres en attends");
		stat6_title.setForeground(Color.BLACK);
		stat6_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat6_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat6_title.setBounds(0, 20, 211, 20);
		stat_containe6.add(stat6_title);
		
		JLabel stat6_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/suitcase red.png")));
		stat6_icon.setBounds(44, 90, 32, 32);
		stat_containe6.add(stat6_icon);
		
		stat6_number.setForeground(Color.BLACK);
		stat6_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat6_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat6_number.setBounds(78, 56, 90, 100);
		stat6_number.setForeground(new Color(231,14,14));
		stat_containe6.add(stat6_number);
		
		profil_container = new JPanel();
		profil_container.setVisible(false);
		profil_container.setBounds(0, 0, 715, 727);
		panel_containers.add(profil_container);
		profil_container.setLayout(null);
		
		JPanel profil_panel_3 = new JPanel();
		profil_panel_3.setBorder(UIManager.getBorder("TextField.border"));
		profil_panel_3.setBackground(Color.WHITE);
		profil_panel_3.setBounds(30, 30, 654, 80);
		profil_container.add(profil_panel_3);
		profil_panel_3.setLayout(null);
		
		JLabel profil_lblNewLabel_7 = new JLabel("LES UTILISATEURS");
		profil_lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		profil_lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 25));
		profil_lblNewLabel_7.setBounds(177, 20, 300, 40);
		profil_panel_3.add(profil_lblNewLabel_7);
		
		table_users = new JTable();
		table_users.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane_users = new JScrollPane();
		scrollPane_users.setBorder(UIManager.getBorder("TextField.border"));
		scrollPane_users.setBounds(30, 200, 654, 467);
		scrollPane_users.setViewportView(table_users);
		model_users = (DefaultTableModel)table_users.getModel();
		model_users.addColumn("ID");
		model_users.addColumn("USERNAME");
		model_users.addColumn("PASSWORD");
		model_users.addColumn("EMAIL");
		model_users.addColumn("NOM");
		model_users.addColumn("PRENOM");
		model_users.addColumn("DATE NAISSANCE");
		model_users.addColumn("ADRESSE");
		model_users.addColumn("WILAYA");
		model_users.addColumn("TEL");
		table_users.getColumnModel().getColumn(3).setWidth(100);
		profil_container.add(scrollPane_users);
		table_users.setBorder(null);
		table_users.setRowHeight(30);
		table_users.setFont(new Font("Open Sans", Font.PLAIN, 15));
		table_users.getColumnModel().getColumn(0).setMinWidth(40);
		table_users.getColumnModel().getColumn(1).setMinWidth(200);
		table_users.getColumnModel().getColumn(2).setMinWidth(200);
		table_users.getColumnModel().getColumn(3).setMinWidth(200);
		table_users.getColumnModel().getColumn(4).setMinWidth(200);
		table_users.getColumnModel().getColumn(5).setMinWidth(200);
		table_users.getColumnModel().getColumn(6).setMinWidth(200);
		table_users.getColumnModel().getColumn(7).setMinWidth(300);
		table_users.getColumnModel().getColumn(8).setMinWidth(200);
		table_users.getColumnModel().getColumn(9).setMinWidth(200);
		
		JLabel delete_icon = new JLabel(new ImageIcon(Mes_Offres.class.getResource("/images/remove.png")));
		delete_icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table_users.getSelectionModel().isSelectionEmpty()) {
					int opcion = JOptionPane.showConfirmDialog(null, "Es-tu sur de supprimer l'utilisateur?", "Confirmation", JOptionPane.YES_NO_OPTION);

					if (opcion == 0) { 
						User u = new User();
						u.setUsername((String)table_users.getValueAt(table_users.getSelectedRow(), 1));
						u.supprimer_user();
					}
				}
			}
		});
		delete_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete_icon.setLocation(644, 135);
		delete_icon.setSize(40, 40);
		profil_container.add(delete_icon);
		
		JPanel search_panel = new JPanel();
		search_panel.setLocation(466, 135);
		search_panel.setSize(150,40);
		search_panel.setLayout(null);
		profil_container.add(search_panel);
		
		
		JLabel search_image = new JLabel( new ImageIcon("C:\\Users\\Client Fractal\\Desktop\\Projet GL\\Gestion_Cabinet\\images\\magnifying-glass.png"));
		search_image.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		search_image.setLocation(110, 2);
		search_image.setSize(50, 25);
		search_panel.add(search_image);
		
		JTextField search = new JTextField();
		search.setFont(new Font("Open Sans", Font.PLAIN, 12));
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel dm = new DefaultTableModel();
				dm = (DefaultTableModel) table_users.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
				table_users.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search.getText()));
			}
		});
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		search.setLocation(0, 0);
		search.setForeground(Color.GRAY);
		search.setSize(150,40);
		search.setText("Rechercher");
		search.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(search.getText().equals("Rechercher")) {
					search.setText("");
				}
				
				search.setForeground(Color.GRAY);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(search.getText().equals("")) {
					search.setText("Rechercher");
				}
				
				search.setForeground(Color.GRAY);
			}
		});
		search_panel.add(search);
		
		
		// End Search
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}
