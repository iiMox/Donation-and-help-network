import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Fenetre_admin {

	private JFrame frmFentreAdministrateur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_admin window = new Fenetre_admin();
					window.frmFentreAdministrateur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenetre_admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFentreAdministrateur = new JFrame();
		frmFentreAdministrateur.setTitle("Fen\u00EAtre administrateur");
		frmFentreAdministrateur.getContentPane().setBackground(Color.WHITE);
		frmFentreAdministrateur.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1dbf73"));
		panel.setBounds(1, 1, 290, 727);
		frmFentreAdministrateur.getContentPane().add(panel);
		frmFentreAdministrateur.setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre_user.class.getResource("/images/login_icon.png")));
		frmFentreAdministrateur.setBounds(100, 100, 1024, 768);
		frmFentreAdministrateur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(50, 45, 190, 47);
		panel.add(lblNewLabel);
		
		JPanel panel_dons = new JPanel();
		panel_dons.setBackground(Color.decode("#1dbf73"));
		panel_dons.setBounds(0, 225, 290, 50);
		panel.add(panel_dons);
		
		JPanel panel_jobs = new JPanel();
		panel_jobs.setBackground(Color.decode("#1dbf73"));
		panel_jobs.setBounds(0, 325, 290, 50);
		panel.add(panel_jobs);
		
		JPanel panel_stats = new JPanel();
		panel_stats.setBackground(Color.decode("#1dbf73"));
		panel_stats.setBounds(0, 425, 290, 50);
		panel.add(panel_stats);
		
		JPanel panel_separator1 = new JPanel();
		panel_separator1.setBackground(Color.WHITE);
		panel_separator1.setBounds(0, 199, 290, 2);
		panel.add(panel_separator1);
		
		JPanel panel_separator2 = new JPanel();
		panel_separator2.setBackground(Color.WHITE);
		panel_separator2.setBounds(0, 299, 290, 2);
		panel.add(panel_separator2);
		
		JPanel panel_separator3 = new JPanel();
		panel_separator3.setBackground(Color.WHITE);
		panel_separator3.setBounds(0, 399, 290, 2);
		panel.add(panel_separator3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#c0c0c0"));
		panel_1.setBounds(291, 0, 1, 729);
		frmFentreAdministrateur.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#c0c0c0"));
		panel_2.setBounds(0, 0, 1008, 1);
		frmFentreAdministrateur.getContentPane().add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.decode("#c0c0c0"));
		panel_1_1.setBounds(1007, 0, 1, 729);
		frmFentreAdministrateur.getContentPane().add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#c0c0c0"));
		panel_2_1.setBounds(0, 728, 1008, 1);
		frmFentreAdministrateur.getContentPane().add(panel_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.decode("#c0c0c0"));
		panel_1_2.setBounds(0, 0, 1, 729);
		frmFentreAdministrateur.getContentPane().add(panel_1_2);
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmFentreAdministrateur.setLocation(dim.width/2-frmFentreAdministrateur.getSize().width/2, dim.height/2-frmFentreAdministrateur.getSize().height/2);
	}
}
