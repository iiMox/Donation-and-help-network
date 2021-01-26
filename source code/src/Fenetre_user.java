import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

public class Fenetre_user extends JFrame {

	private JPanel contentPane;
	private JPanel panel_accueil,panel_dons,panel_jobs,panel_stats,panel_separator0,panel_separator1,panel_separator2,panel_separator3,panel_separator4,panel_separator5,panel_separator6,accueil_container,dons_container,jobs_container,stats_container,profil_container;
	private JTextField profil_nom;
	private JTextField profil_prenom;
	private JTextField profil_username;
	private JTextField profil_email;
	private JTextField profil_naissance;
	private JTextField profil_adresse;
	private JTextField profil_wilaya;
	private JTextField profil_tel;
	private JScrollPane scrollPane,scrollPane_jobs; 
	private JPanel scrollPanel,scrollPanel_jobs;

	/**
	 * Create the frame.
	 */
	public Fenetre_user(int ID) {
		User user = new User();
		user.getUserById(ID);
		
		scrollPanel = new JPanel();
		scrollPanel_jobs = new JPanel();
		
        scrollPane = new JScrollPane(scrollPanel);
        scrollPane_jobs = new JScrollPane(scrollPanel_jobs);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setResizable(false);
		setTitle("Fen\u00EAtre utilisateur");
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre_user.class.getResource("/images/login_icon.png")));
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
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
				scrollPane.setVisible(false);
				scrollPane_jobs.setVisible(false);
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
				scrollPane.setVisible(true);
				scrollPane_jobs.setVisible(false);
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
				scrollPane.setVisible(false);
				scrollPane_jobs.setVisible(true);
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
				scrollPane.setVisible(false);
				scrollPane_jobs.setVisible(false);
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
				scrollPane.setVisible(false);
				scrollPane_jobs.setVisible(false);
			}
		});
		panel_profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_profile.setBackground(Color.decode("#1dbf73"));
		panel_profile.setBounds(0, 629, 144, 98);
		panel.add(panel_profile);
		panel_profile.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Profile");
		lblNewLabel_5.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(35, 58, 74, 25);
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
		
		JPanel accueil_poste_container1 = new JPanel();
		accueil_poste_container1.setBorder(UIManager.getBorder("TextField.border"));
		accueil_poste_container1.setBackground(Color.WHITE);
		accueil_poste_container1.setBounds(30, 185, 200, 150);
		accueil_container.add(accueil_poste_container1);
		accueil_poste_container1.setLayout(null);
		
		JLabel accueil_poste_1_title = new JLabel("New label");
		accueil_poste_1_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_poste_1_title.setBounds(10, 11, 180, 25);
		accueil_poste_container1.add(accueil_poste_1_title);
		
		JLabel accueil_poste_1_desc = new JLabel("New label");
		accueil_poste_1_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_1_desc.setBounds(10, 40, 180, 70);
		accueil_poste_container1.add(accueil_poste_1_desc);
		
		JLabel accueil_poste_1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_poste_1_icon.setLocation(100, 121);
		accueil_poste_1_icon.setSize(16, 16);
		accueil_poste_container1.add(accueil_poste_1_icon);
		
		JLabel accueil_poste_1_liocation = new JLabel("wilaya");
		accueil_poste_1_liocation.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_poste_1_liocation.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_1_liocation.setBounds(119, 121, 70, 16);
		accueil_poste_container1.add(accueil_poste_1_liocation);
		
		JPanel accueil_poste_container2 = new JPanel();
		accueil_poste_container2.setBorder(UIManager.getBorder("TextField.border"));
		accueil_poste_container2.setBackground(Color.WHITE);
		accueil_poste_container2.setBounds(257, 185, 200, 150);
		accueil_container.add(accueil_poste_container2);
		accueil_poste_container2.setLayout(null);
		
		JLabel accueil_poste_2_title = new JLabel("New label");
		accueil_poste_2_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_poste_2_title.setBounds(10, 11, 180, 25);
		accueil_poste_container2.add(accueil_poste_2_title);
		
		JLabel accueil_poste_2_desc = new JLabel("New label");
		accueil_poste_2_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_2_desc.setBounds(10, 40, 180, 70);
		accueil_poste_container2.add(accueil_poste_2_desc);
		
		JLabel accueil_poste_2_location = new JLabel("wilaya");
		accueil_poste_2_location.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_poste_2_location.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_2_location.setBounds(119, 121, 70, 16);
		accueil_poste_container2.add(accueil_poste_2_location);
		
		JLabel accueil_poste_2_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_poste_2_icon.setBounds(100, 121, 16, 16);
		accueil_poste_container2.add(accueil_poste_2_icon);
		
		JPanel accueil_poste_container3 = new JPanel();
		accueil_poste_container3.setBorder(UIManager.getBorder("TextField.border"));
		accueil_poste_container3.setBackground(Color.WHITE);
		accueil_poste_container3.setBounds(484, 183, 200, 150);
		accueil_container.add(accueil_poste_container3);
		accueil_poste_container3.setLayout(null);
		
		JLabel accueil_poste_3_title = new JLabel("New label");
		accueil_poste_3_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_poste_3_title.setBounds(10, 11, 180, 25);
		accueil_poste_container3.add(accueil_poste_3_title);
		
		JLabel accueil_poste_3_desc = new JLabel("New label");
		accueil_poste_3_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_3_desc.setBounds(10, 40, 180, 70);
		accueil_poste_container3.add(accueil_poste_3_desc);
		
		JLabel accueil_poste_3_location = new JLabel("wilaya");
		accueil_poste_3_location.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_poste_3_location.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_poste_3_location.setBounds(119, 123, 70, 16);
		accueil_poste_container3.add(accueil_poste_3_location);
		
		JLabel accueil_poste_3_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_poste_3_icon.setBounds(100, 123, 16, 16);
		accueil_poste_container3.add(accueil_poste_3_icon);
		
		JLabel accueil_lblNewLabel_9 = new JLabel("Offres r\u00E9cents");
		accueil_lblNewLabel_9.setFont(new Font("Open Sans", Font.BOLD, 20));
		accueil_lblNewLabel_9.setBounds(30, 400, 150, 20);
		accueil_container.add(accueil_lblNewLabel_9);
		
		JSeparator accueil_separator_2 = new JSeparator();
		accueil_separator_2.setForeground(Color.WHITE);
		accueil_separator_2.setBackground(Color.WHITE);
		accueil_separator_2.setBounds(30, 430, 654, 2);
		accueil_container.add(accueil_separator_2);
		
		JPanel accueil_offre_container1_1 = new JPanel();
		accueil_offre_container1_1.setBorder(UIManager.getBorder("TextField.border"));
		accueil_offre_container1_1.setBackground(Color.WHITE);
		accueil_offre_container1_1.setBounds(30, 445, 200, 150);
		accueil_container.add(accueil_offre_container1_1);
		accueil_offre_container1_1.setLayout(null);
		
		JLabel accueil_offre_1_title = new JLabel("New label");
		accueil_offre_1_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_offre_1_title.setBounds(10, 11, 180, 25);
		accueil_offre_container1_1.add(accueil_offre_1_title);
		
		JLabel accueil_offre_1_desc = new JLabel("New label");
		accueil_offre_1_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_1_desc.setBounds(10, 40, 180, 70);
		accueil_offre_container1_1.add(accueil_offre_1_desc);
		
		JLabel accueil_offre_1_liocation = new JLabel("wilaya");
		accueil_offre_1_liocation.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_offre_1_liocation.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_1_liocation.setBounds(119, 121, 70, 16);
		accueil_offre_container1_1.add(accueil_offre_1_liocation);
		
		JLabel accueil_offre_1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_offre_1_icon.setBounds(100, 121, 16, 16);
		accueil_offre_container1_1.add(accueil_offre_1_icon);
		
		JPanel accueil_offre_container2_1 = new JPanel();
		accueil_offre_container2_1.setBorder(UIManager.getBorder("TextField.border"));
		accueil_offre_container2_1.setBackground(Color.WHITE);
		accueil_offre_container2_1.setBounds(257, 445, 200, 150);
		accueil_container.add(accueil_offre_container2_1);
		accueil_offre_container2_1.setLayout(null);
		
		JLabel accueil_offre_2_title = new JLabel("New label");
		accueil_offre_2_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_offre_2_title.setBounds(10, 11, 180, 25);
		accueil_offre_container2_1.add(accueil_offre_2_title);
		
		JLabel accueil_offre_2_desc = new JLabel("New label");
		accueil_offre_2_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_2_desc.setBounds(10, 40, 180, 70);
		accueil_offre_container2_1.add(accueil_offre_2_desc);
		
		JLabel accueil_offre_2_location = new JLabel("wilaya");
		accueil_offre_2_location.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_offre_2_location.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_2_location.setBounds(119, 121, 70, 16);
		accueil_offre_container2_1.add(accueil_offre_2_location);
		
		JLabel accueil_offre_2_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_offre_2_icon.setBounds(100, 121, 16, 16);
		accueil_offre_container2_1.add(accueil_offre_2_icon);
		
		JPanel accueil_offre_container3_1 = new JPanel();
		accueil_offre_container3_1.setBorder(UIManager.getBorder("TextField.border"));
		accueil_offre_container3_1.setBackground(Color.WHITE);
		accueil_offre_container3_1.setBounds(484, 445, 200, 150);
		accueil_container.add(accueil_offre_container3_1);
		accueil_offre_container3_1.setLayout(null);
		
		JLabel accueil_offre_3_title = new JLabel("New label");
		accueil_offre_3_title.setFont(new Font("Open Sans", Font.BOLD, 12));
		accueil_offre_3_title.setBounds(10, 11, 180, 25);
		accueil_offre_container3_1.add(accueil_offre_3_title);
		
		JLabel accueil_offre_3_desc = new JLabel("New label");
		accueil_offre_3_desc.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_3_desc.setBounds(10, 40, 180, 70);
		accueil_offre_container3_1.add(accueil_offre_3_desc);
		
		JLabel accueil_offre_3_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/location_icon.png")));
		accueil_offre_3_icon.setBounds(100, 123, 16, 16);
		accueil_offre_container3_1.add(accueil_offre_3_icon);
		
		JLabel accueil_offre_3_location = new JLabel("wilaya");
		accueil_offre_3_location.setHorizontalAlignment(SwingConstants.LEFT);
		accueil_offre_3_location.setFont(new Font("Open Sans", Font.PLAIN, 12));
		accueil_offre_3_location.setBounds(119, 123, 70, 16);
		accueil_offre_container3_1.add(accueil_offre_3_location);
		
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
		
		
		scrollPanel.setBackground(Color.WHITE);
		GridLayout gl_scrollPanel = new GridLayout();
		gl_scrollPanel.setColumns(1);
		gl_scrollPanel.setHgap(20);
		gl_scrollPanel.setVgap(20);
		gl_scrollPanel.setRows(0);
		scrollPanel.setLayout(gl_scrollPanel);
		scrollPanel.setBorder(new CompoundBorder(null, new EmptyBorder(20, 20, 20, 20)));
        scrollPanel.setSize(new Dimension(300, 300));       
        scrollPane.setVisible(false);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setSize(654, 500);
        scrollPane.setLocation(30, 150);
        
        Vector<Integer> v =new Vector<Integer>();
        OracleConnection oc = new OracleConnection();
        oc.initialize();
        try {
        	oc.stmt = oc.con.prepareStatement("Select * From Dons Where Etat='accepter'");
        	oc.rs = oc.stmt.executeQuery();
        	while(oc.rs.next()) {
        		v.add(oc.rs.getInt("code"));
        	}
        	oc.con.close();
        } catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
        }
        
        for(int i=0; i<v.size(); i++) {
        	scrollPanel.add(new PosteDon(v.get(i)));
        }
        
        dons_container.add(scrollPane);
        
        JButton mes_demandes_btn = new JButton("Mes postes des dons");
        mes_demandes_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Mes_Articles ma = new Mes_Articles(user.getUsername());
        		ma.setVisible(true);
        	}
        });
        mes_demandes_btn.setBackground(Color.decode("#4b6584"));
        mes_demandes_btn.setBorder(null);
        mes_demandes_btn.setForeground(Color.WHITE);
        mes_demandes_btn.setFont(new Font("Open Sans", Font.BOLD, 14));
        mes_demandes_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mes_demandes_btn.setBounds(30, 670, 200, 40);
        dons_container.add(mes_demandes_btn);
        
        JButton ajout_poste_btn = new JButton("Ajouter un poste");
        ajout_poste_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ajout_poste_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Ajout_Don ad = new Ajout_Don(user.getUsername());
        		ad.setVisible(true);
        	}
        });
        ajout_poste_btn.setBackground(new Color(29,191,115));
        ajout_poste_btn.setForeground(Color.WHITE);
        ajout_poste_btn.setFont(new Font("Open Sans", Font.BOLD, 14));
        ajout_poste_btn.setBorder(null);
        ajout_poste_btn.setBounds(484, 670, 200, 40);
        dons_container.add(ajout_poste_btn);
		
		jobs_container = new JPanel();
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
		
		
		GridLayout gl_scrollPanel_jobs = new GridLayout();
		gl_scrollPanel_jobs.setColumns(1);
		gl_scrollPanel_jobs.setHgap(20);
		gl_scrollPanel_jobs.setVgap(20);
		gl_scrollPanel_jobs.setRows(0);
		scrollPanel_jobs.setLayout(gl_scrollPanel_jobs);
		scrollPanel_jobs.setBackground(Color.WHITE);
		scrollPanel_jobs.setBorder(new CompoundBorder(null, new EmptyBorder(20, 20, 20, 20)));
		scrollPanel_jobs.setSize(new Dimension(300, 300));       
		scrollPane_jobs.setVisible(false);
        scrollPane_jobs.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_jobs.setSize(654, 500);
        scrollPane_jobs.setLocation(30, 150);
        
        Vector<Integer> v_jobs =new Vector<Integer>();
        try {
        	oc.stmt = oc.con.prepareStatement("Select * From Dons Where Etat='accepter'");
        	oc.rs = oc.stmt.executeQuery();
        	while(oc.rs.next()) {
        		v_jobs.add(oc.rs.getInt("code"));
        	}
        	oc.con.close();
        } catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
        }
        
        for(int j=0; j<v_jobs.size(); j++) {
        	scrollPane_jobs.add(new PosteDon(v_jobs.get(j)));
        }
        
        jobs_container.add(scrollPane_jobs);
        
        JButton mes_offres_btn = new JButton("Mes offres d'emploi");
        mes_offres_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        mes_offres_btn.setBackground(Color.decode("#4b6584"));
        mes_offres_btn.setBorder(null);
        mes_offres_btn.setForeground(Color.WHITE);
        mes_offres_btn.setFont(new Font("Open Sans", Font.BOLD, 14));
        mes_offres_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mes_offres_btn.setBounds(30, 670, 200, 40);
        jobs_container.add(mes_offres_btn);
        
        JButton ajout_offre_btn = new JButton("Ajouter un offre");
        ajout_offre_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ajout_offre_btn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        ajout_offre_btn.setBackground(new Color(29,191,115));
        ajout_offre_btn.setForeground(Color.WHITE);
        ajout_offre_btn.setFont(new Font("Open Sans", Font.BOLD, 14));
        ajout_offre_btn.setBorder(null);
        ajout_offre_btn.setBounds(484, 670, 200, 40);
        jobs_container.add(ajout_offre_btn);
		
		stats_container = new JPanel();
		stats_container.setBounds(0, 0, 715, 727);
		panel_containers.add(stats_container);
		stats_container.setLayout(null);
		
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
		
		JLabel stat1_title = new JLabel("Statistique 1");
		stat1_title.setForeground(Color.BLACK);
		stat1_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat1_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat1_title.setBounds(45, 20, 121, 20);
		stat_containe1.add(stat1_title);
		
		JLabel stat1_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/login_icon.png")));
		stat1_icon.setLocation(44, 90);
		stat1_icon.setSize(32, 32);
		stat_containe1.add(stat1_icon);
		
		JLabel stat1_number = new JLabel("50");
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
		
		JLabel stat2_title = new JLabel("Statistique 1");
		stat2_title.setForeground(Color.BLACK);
		stat2_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat2_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat2_title.setBounds(45, 20, 121, 20);
		stat_containe2.add(stat2_title);
		
		JLabel stat2_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/login_icon.png")));
		stat2_icon.setBounds(44, 90, 32, 32);
		stat_containe2.add(stat2_icon);
		
		JLabel stat2_number = new JLabel("50");
		stat2_number.setForeground(Color.BLACK);
		stat2_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat2_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat2_number.setBounds(78, 56, 90, 100);
		stat_containe2.add(stat2_number);
		
		JPanel stat_containe3 = new JPanel();
		stat_containe3.setLayout(null);
		stat_containe3.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe3.setBackground(Color.WHITE);
		stat_containe3.setBounds(473, 225, 211, 200);
		stats_container.add(stat_containe3);
		
		JLabel stat3_title = new JLabel("Statistique 1");
		stat3_title.setForeground(Color.BLACK);
		stat3_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat3_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat3_title.setBounds(45, 20, 121, 20);
		stat_containe3.add(stat3_title);
		
		JLabel stat3_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/login_icon.png")));
		stat3_icon.setBounds(44, 90, 32, 32);
		stat_containe3.add(stat3_icon);
		
		JLabel stat3_number = new JLabel("50");
		stat3_number.setForeground(Color.BLACK);
		stat3_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat3_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat3_number.setBounds(78, 56, 90, 100);
		stat_containe3.add(stat3_number);
		
		JPanel stat_containe4 = new JPanel();
		stat_containe4.setLayout(null);
		stat_containe4.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe4.setBackground(Color.WHITE);
		stat_containe4.setBounds(30, 475, 211, 200);
		stats_container.add(stat_containe4);
		
		JLabel stat4_title = new JLabel("Statistique 1");
		stat4_title.setForeground(Color.BLACK);
		stat4_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat4_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat4_title.setBounds(45, 20, 121, 20);
		stat_containe4.add(stat4_title);
		
		JLabel stat4_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/login_icon.png")));
		stat4_icon.setBounds(44, 90, 32, 32);
		stat_containe4.add(stat4_icon);
		
		JLabel stat4_number = new JLabel("50");
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
		
		JLabel stat5_title = new JLabel("Statistique 1");
		stat5_title.setForeground(Color.BLACK);
		stat5_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat5_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat5_title.setBounds(45, 20, 121, 20);
		stat_containe5.add(stat5_title);
		
		JLabel stat5_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/login_icon.png")));
		stat5_icon.setBounds(44, 90, 32, 32);
		stat_containe5.add(stat5_icon);
		
		JLabel stat5_number = new JLabel("50");
		stat5_number.setForeground(Color.BLACK);
		stat5_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat5_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat5_number.setBounds(78, 56, 90, 100);
		stat_containe5.add(stat5_number);
		
		JPanel stat_containe6 = new JPanel();
		stat_containe6.setLayout(null);
		stat_containe6.setBorder(UIManager.getBorder("TextField.border"));
		stat_containe6.setBackground(Color.WHITE);
		stat_containe6.setBounds(473, 475, 211, 200);
		stats_container.add(stat_containe6);
		
		JLabel stat6_title = new JLabel("Statistique 1");
		stat6_title.setForeground(Color.BLACK);
		stat6_title.setHorizontalAlignment(SwingConstants.CENTER);
		stat6_title.setFont(new Font("Open Sans", Font.BOLD, 16));
		stat6_title.setBounds(45, 20, 121, 20);
		stat_containe6.add(stat6_title);
		
		JLabel stat6_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/login_icon.png")));
		stat6_icon.setBounds(44, 90, 32, 32);
		stat_containe6.add(stat6_icon);
		
		JLabel stat6_number = new JLabel("50");
		stat6_number.setForeground(Color.BLACK);
		stat6_number.setHorizontalAlignment(SwingConstants.CENTER);
		stat6_number.setFont(new Font("Open Sans", Font.BOLD, 55));
		stat6_number.setBounds(78, 56, 90, 100);
		stat_containe6.add(stat6_number);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(30, 185, 654, 2);
		stats_container.add(separator);
		
		profil_container = new JPanel();
		profil_container.setBounds(0, 0, 715, 727);
		panel_containers.add(profil_container);
		profil_container.setLayout(null);
		
		JPanel profil_panel_3 = new JPanel();
		profil_panel_3.setBorder(UIManager.getBorder("TextField.border"));
		profil_panel_3.setBackground(Color.WHITE);
		profil_panel_3.setBounds(30, 30, 654, 80);
		profil_container.add(profil_panel_3);
		profil_panel_3.setLayout(null);
		
		JLabel profil_lblNewLabel_7 = new JLabel("Profil Personnel");
		profil_lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		profil_lblNewLabel_7.setFont(new Font("Open Sans", Font.BOLD, 25));
		profil_lblNewLabel_7.setBounds(217, 20, 220, 40);
		profil_panel_3.add(profil_lblNewLabel_7);
		
		JPanel profil_panel_4 = new JPanel();
		profil_panel_4.setBorder(UIManager.getBorder("TextField.border"));
		profil_panel_4.setBackground(Color.WHITE);
		profil_panel_4.setBounds(30, 140, 654, 557);
		profil_container.add(profil_panel_4);
		profil_panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Nom");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8.setBounds(94, 18, 170, 40);
		profil_panel_4.add(lblNewLabel_8);
		
		profil_nom = new JTextField();
		profil_nom.setEditable(false);
		profil_nom.setBorder(new LineBorder(Color.gray,1));
		profil_nom.setBounds(358, 18, 200, 40);
		profil_panel_4.add(profil_nom);
		profil_nom.setColumns(10);
		profil_nom.setText(user.getNom());
		
		JLabel lblNewLabel_8_1 = new JLabel("Prenom");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_1.setBounds(94, 76, 170, 40);
		profil_panel_4.add(lblNewLabel_8_1);
		
		profil_prenom = new JTextField();
		profil_prenom.setEditable(false);
		//profil_prenom.setBackground(UIManager.getColor(Color.red));
		profil_prenom.setBorder(new LineBorder(Color.gray,1));
		profil_prenom.setColumns(10);
		profil_prenom.setBounds(358, 76, 200, 40);
		profil_panel_4.add(profil_prenom);
		profil_prenom.setText(user.getPrenom());
		
		JLabel lblNewLabel_8_2 = new JLabel("Nom d'utilisateur");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_2.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_2.setBounds(94, 134, 190, 40);
		profil_panel_4.add(lblNewLabel_8_2);
		
		profil_username = new JTextField();
		profil_username.setEditable(false);
		profil_username.setBorder(new LineBorder(Color.gray,1));
		profil_username.setColumns(10);
		profil_username.setBounds(358, 134, 200, 40);
		profil_panel_4.add(profil_username);
		profil_username.setText(user.getUsername());
		
		JLabel lblNewLabel_8_3 = new JLabel("E-amil");
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_3.setBounds(94, 192, 170, 40);
		profil_panel_4.add(lblNewLabel_8_3);
		
		profil_email = new JTextField();
		profil_email.setEditable(false);
		profil_email.setBorder(new LineBorder(Color.gray,1));
		profil_email.setColumns(10);
		profil_email.setBounds(358, 192, 200, 40);
		profil_panel_4.add(profil_email);
		profil_email.setText(user.getEmail());
		
		JLabel lblNewLabel_8_4 = new JLabel("Date de naissance");
		lblNewLabel_8_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_4.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_4.setBounds(94, 250, 190, 40);
		profil_panel_4.add(lblNewLabel_8_4);
		
		profil_naissance = new JTextField();
		profil_naissance.setEditable(false);
		profil_naissance.setBorder(new LineBorder(Color.gray,1));
		profil_naissance.setColumns(10);
		profil_naissance.setBounds(358, 250, 200, 40);
		profil_panel_4.add(profil_naissance);
		//profil_naissance.setText(user.getDate_naissance());
		
		JLabel lblNewLabel_8_5 = new JLabel("Adresse");
		lblNewLabel_8_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_5.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_5.setBounds(94, 308, 170, 40);
		profil_panel_4.add(lblNewLabel_8_5);
		
		profil_adresse = new JTextField();
		profil_adresse.setEditable(false);
		profil_adresse.setBorder(new LineBorder(Color.gray,1));
		profil_adresse.setColumns(10);
		profil_adresse.setBounds(358, 308, 200, 40);
		profil_panel_4.add(profil_adresse);
		profil_adresse.setText(user.getAdresse());
		
		JLabel lblNewLabel_8_6 = new JLabel("Wilaya");
		lblNewLabel_8_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_6.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_6.setBounds(94, 366, 170, 40);
		profil_panel_4.add(lblNewLabel_8_6);
		
		profil_wilaya = new JTextField();
		profil_wilaya.setEditable(false);
		profil_wilaya.setBorder(new LineBorder(Color.gray,1));
		profil_wilaya.setColumns(10);
		profil_wilaya.setBounds(358, 366, 200, 40);
		profil_panel_4.add(profil_wilaya);
		profil_wilaya.setText(user.getWilaya());
		
		JLabel lblNewLabel_8_7 = new JLabel("T\u00E9l\u00E9phne");
		lblNewLabel_8_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_7.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_8_7.setBounds(94, 424, 170, 40);
		profil_panel_4.add(lblNewLabel_8_7);
		
		profil_tel = new JTextField();
		profil_tel.setEditable(false);
		profil_tel.setBorder(new LineBorder(Color.gray,1));
		profil_tel.setColumns(10);
		profil_tel.setBounds(358, 424, 200, 40);
		profil_panel_4.add(profil_tel);
		//profil_tel.setText(user.getTel());
		
		JButton edit_button = new JButton("Modifier");
		JButton save_button = new JButton("Enregistrer");
		edit_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profil_nom.setEditable(true);
				profil_nom.setBackground(UIManager.getColor(Color.WHITE));
				profil_prenom.setEditable(true);
				profil_prenom.setBackground(UIManager.getColor(Color.WHITE));
				profil_username.setEditable(true);
				profil_username.setBackground(UIManager.getColor(Color.WHITE));
				profil_email.setEditable(true);
				profil_email.setBackground(UIManager.getColor(Color.WHITE));
				profil_naissance.setEditable(true);
				profil_naissance.setBackground(UIManager.getColor(Color.WHITE));
				profil_adresse.setEditable(true);
				profil_adresse.setBackground(UIManager.getColor(Color.WHITE));
				profil_wilaya.setEditable(true);
				profil_wilaya.setBackground(UIManager.getColor(Color.WHITE));
				profil_tel.setEditable(true);
				profil_tel.setBackground(UIManager.getColor(Color.WHITE));
				
				save_button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						user.setUsername(profil_username.getText());
						user.setNom(profil_nom.getText());
						user.setPrenom(profil_prenom.getText());
						user.setEmail(profil_email.getText());
						//user.setDate_naissance(profil_naissance.getText());
						user.setAdresse(profil_adresse.getText());
						user.setWilaya(profil_wilaya.getText());
						//user.setTel(profil_tel.getText());
						user.modifier_user();
					}
				});
			}
		});
		edit_button.setBackground(Color.decode("#4b6584"));
		edit_button.setBorder(null);
		edit_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		edit_button.setFont(new Font("Open Sans", Font.BOLD, 14));
		edit_button.setForeground(Color.WHITE);
		edit_button.setBounds(58, 482, 140, 50);
		profil_panel_4.add(edit_button);
		
		JButton cancel_button = new JButton("Annuler");
		cancel_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				profil_nom.setText(user.getNom());
				profil_nom.setEditable(false);
				profil_prenom.setText(user.getPrenom());
				profil_prenom.setEditable(false);
				profil_username.setText(user.getUsername());
				profil_username.setEditable(false);
				profil_email.setText(user.getEmail());
				profil_email.setEditable(false);
				//profil_naissance.setText(user.getDate_naissance());
				profil_naissance.setEditable(false);
				profil_adresse.setText(user.getAdresse());
				profil_adresse.setEditable(false);
				profil_wilaya.setText(user.getWilaya());
				profil_wilaya.setEditable(false);
				//profil_tel.setText(user.getTel());
				profil_tel.setEditable(false);
				
				for( MouseListener al : save_button.getMouseListeners()) { // Remove Click Event
					save_button.removeMouseListener( al );
				  }
				
			}
		});
		cancel_button.setBorder(null);
		cancel_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancel_button.setBackground(Color.RED);
		cancel_button.setFont(new Font("Open Sans", Font.BOLD, 14));
		cancel_button.setForeground(Color.WHITE);
		cancel_button.setBounds(454, 482, 140, 50);
		profil_panel_4.add(cancel_button);
		
		save_button.setBorder(null);
		save_button.setForeground(Color.WHITE);
		save_button.setFont(new Font("Open Sans", Font.BOLD, 14));
		save_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		save_button.setBackground(new Color(29, 191, 115));
		save_button.setBounds(256, 482, 140, 50);
		profil_panel_4.add(save_button);
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}


