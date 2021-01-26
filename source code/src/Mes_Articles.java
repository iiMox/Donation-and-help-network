
import java.awt.*;

import javax.swing.*;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Mes_Articles extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Mes_Articles(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mes_Articles.class.getResource("/images/login_icon.png")));
		setTitle("Mes articles de don");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 26, 544, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MES ARTICLE DE DON");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(122, 11, 300, 30);
		panel_1.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(30, 125, 544, 401);
		contentPane.add(table);
		
		OracleConnection oc = new OracleConnection();
		oc.initialize();

		try {
			oc.stmt=oc.con.prepareStatement("Select * From Dons where owner=?");
			oc.stmt.setString(1, username);

			oc.rs=oc.stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(oc.rs));

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
	}
}
