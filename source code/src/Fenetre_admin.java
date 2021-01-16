import java.awt.*;
import javax.swing.*;


public class Fenetre_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Fenetre_admin() {
		setTitle("Fen\u00EAtre administrateur");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1dbf73"));
		panel.setBounds(1, 1, 290, 727);
		getContentPane().add(panel);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fenetre_user.class.getResource("/images/login_icon.png")));
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}
