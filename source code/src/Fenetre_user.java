import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenetre_user {

	private JFrame frmFenetreUtilisateur;
	private JPanel panel_accueil,panel_dons,panel_jobs,panel_stats,panel_separator0,panel_separator1,panel_separator2,panel_separator3,panel_separator4,panel_separator5,panel_separator6,accueil_container,dons_container,jobs_container,stats_container,profil_container;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_user window = new Fenetre_user();
					window.frmFenetreUtilisateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenetre_user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFenetreUtilisateur = new JFrame();
		frmFenetreUtilisateur.setResizable(false);
		frmFenetreUtilisateur.setTitle("Fen\u00EAtre utilisateur");
		frmFenetreUtilisateur.getContentPane().setBackground(Color.WHITE);
		frmFenetreUtilisateur.setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre_user.class.getResource("/images/login_icon.png")));
		frmFenetreUtilisateur.setBounds(100, 100, 1024, 768);
		frmFenetreUtilisateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFenetreUtilisateur.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(29, 191, 115));
		panel.setBounds(1, 1, 290, 727);
		frmFenetreUtilisateur.getContentPane().add(panel);
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
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 25, 120, 45);
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
			}
		});
		
		JLabel dons_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/donation_icon.png")));
		dons_icon.setLocation(20, 25);
		dons_icon.setSize(40, 40);
		panel_dons.add(dons_icon);
		
		JLabel lblNewLabel_2 = new JLabel("Les dons");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(60, 25, 120, 36);
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
			}
		});
		
		JLabel jobs_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/job_icon.png")));
		jobs_icon.setLocation(20, 25);
		jobs_icon.setSize(40, 40);
		panel_jobs.add(jobs_icon);
		
		JLabel lblNewLabel_3 = new JLabel("Les offres de travail");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
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
			}
		});
		
		JLabel stats_icon = new JLabel(new ImageIcon(Fenetre_user.class.getResource("/images/stats_icon.png")));
		stats_icon.setLocation(20, 25);
		stats_icon.setSize(40, 40);
		panel_stats.add(stats_icon);
		
		JLabel lblNewLabel_4 = new JLabel("Statistiques");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(60, 29, 141, 33);
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
				accueil_container.setVisible(false);
				dons_container.setVisible(false);
				jobs_container.setVisible(false);
				stats_container.setVisible(false);
				profil_container.setVisible(true);
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
				int opcion = JOptionPane.showConfirmDialog(null, "Est-ce que vous voulez quitter", "Confirmation", JOptionPane.YES_NO_OPTION);

				if (opcion == 0) { //The ISSUE is here
					Fenetre_authentification.main(null);
					frmFenetreUtilisateur.setVisible(false);
					frmFenetreUtilisateur.dispose();
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
		frmFenetreUtilisateur.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#c0c0c0"));
		panel_2.setBounds(0, 0, 1008, 1);
		frmFenetreUtilisateur.getContentPane().add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.decode("#c0c0c0"));
		panel_1_1.setBounds(1007, 0, 1, 729);
		frmFenetreUtilisateur.getContentPane().add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#c0c0c0"));
		panel_2_1.setBounds(0, 728, 1008, 1);
		frmFenetreUtilisateur.getContentPane().add(panel_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.decode("#c0c0c0"));
		panel_1_2.setBounds(0, 0, 1, 729);
		frmFenetreUtilisateur.getContentPane().add(panel_1_2);
		
		JPanel panel_containers = new JPanel();
		panel_containers.setBackground(Color.WHITE);
		panel_containers.setBounds(293, 1, 715, 727);
		frmFenetreUtilisateur.getContentPane().add(panel_containers);
		panel_containers.setLayout(null);
		
		accueil_container = new JPanel();
		accueil_container.setBounds(0, 0, 715, 727);
		panel_containers.add(accueil_container);
		accueil_container.setLayout(null);
		
		/*dons_container = new JPanel();
		dons_container.setBounds(0, 0, 715, 727);
		panel_containers.add(dons_container);
		dons_container.setLayout(null);
		
		jobs_container = new JPanel();
		jobs_container.setBounds(0, 0, 715, 727);
		panel_containers.add(jobs_container);
		jobs_container.setLayout(null);
		
		stats_container = new JPanel();
		stats_container.setBounds(0, 0, 715, 727);
		panel_containers.add(stats_container);
		stats_container.setLayout(null);
		
		profil_container = new JPanel();
		profil_container.setBounds(0, 0, 715, 727);
		panel_containers.add(profil_container);
		profil_container.setLayout(null);*/
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmFenetreUtilisateur.setLocation(dim.width/2-frmFenetreUtilisateur.getSize().width/2, dim.height/2-frmFenetreUtilisateur.getSize().height/2);
	}
}
