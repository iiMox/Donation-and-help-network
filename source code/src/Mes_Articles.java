
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.*;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Mes_Articles extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Mes_Articles(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mes_Articles.class.getResource("/images/login_icon.png")));
		setTitle("Mes articles de don");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextField.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 26, 824, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MES ARTICLE DE DON");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(262, 11, 300, 30);
		panel_1.add(lblNewLabel_1);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("TextField.border"));
		scrollPane.setBounds(30, 125, 824, 401);
		scrollPane.setViewportView(table);
		DefaultTableModel  model = (DefaultTableModel)table.getModel();
		model.addColumn("CODE");
		model.addColumn("TITLE");
		model.addColumn("DESCRIPTION");
		model.addColumn("DATE CREATION");
		model.addColumn("CATEGORIE");
		model.addColumn("WILAYA");
		model.addColumn("ETAT");
		table.getColumnModel().getColumn(3).setWidth(100);
		contentPane.add(scrollPane);
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
		
		OracleConnection oc = new OracleConnection();
		oc.initialize();

		try {
			oc.stmt=oc.con.prepareStatement("Select * From Dons where owner=? order by date_don DESC");
			oc.stmt.setString(1, username);

			oc.rs=oc.stmt.executeQuery();
			while(oc.rs.next()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Timestamp sql_date = oc.rs.getTimestamp("date_don");
				java.util.Date utilDate = new java.util.Date(sql_date.getTime());
				String dt = formatter.format(utilDate);
				model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("title"), oc.rs.getString("description"), dt, oc.rs.getString("categorie"), oc.rs.getString("wilaya"), oc.rs.getString("etat")});
			}
			oc.con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
		}
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		
	}
}
