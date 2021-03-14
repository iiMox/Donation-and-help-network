import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mes_Offres extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public Mes_Offres(String username) {
		OracleConnection oc = new OracleConnection();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mes_Articles.class.getResource("/images/login_icon.png")));
		setTitle("Mes offres d'emplois");
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
		
		JLabel lblNewLabel_1 = new JLabel("MES OFFRES D'EMPLOIS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblNewLabel_1.setBounds(262, 11, 300, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lock_icon = new JLabel(new ImageIcon(Mes_Articles.class.getResource("/images/lock.png")));
		lock_icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Est-ce que vous voulez fermer l'article ?", "Confirmation", JOptionPane.YES_NO_OPTION);

				if (opcion == 0) { //The ISSUE is here
					Job j = new Job();
					j.setCode((int)table.getValueAt(table.getSelectedRow(), 0));
					j.setEtat("Fermer");
					j.changer_etat();
				}
			}
		});
		lock_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lock_icon.setLocation(706, 80);
		lock_icon.setSize(40, 40);
		contentPane.add(lock_icon);
		
		JLabel edit_icon = new JLabel(new ImageIcon(Mes_Offres.class.getResource("/images/pencil (1).png")));
		edit_icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {
					Modifier_Job mj = new Modifier_Job((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
					mj.setVisible(true);
				}
			}
		});
		edit_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		edit_icon.setLocation(760, 80);
		edit_icon.setSize(40, 40);
		contentPane.add(edit_icon);
		
		JLabel delete_icon = new JLabel(new ImageIcon(Mes_Offres.class.getResource("/images/remove.png")));
		delete_icon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!table.getSelectionModel().isSelectionEmpty()) {
					int opcion = JOptionPane.showConfirmDialog(null, "Es-tu sur de supprimer l'article?", "Confirmation", JOptionPane.YES_NO_OPTION);

					if (opcion == 0) { 
						Job j = new Job();
						j.setCode((int)table.getModel().getValueAt(table.getSelectedRow(), 0));
						j.supprimer_job();
					}
				}
			}
		});
		delete_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete_icon.setLocation(814, 80);
		delete_icon.setSize(40, 40);
		contentPane.add(delete_icon);
		
		table = new JTable() {
			
			    @Override
			    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
			        Component comp = super.prepareRenderer(renderer, row, col);
			        Object value = getModel().getValueAt(row, 7);
			        
			        if (value.equals("Actif")) {
		                comp.setBackground(Color.green);
		                comp.setForeground(Color.black);
			        } else if (value.equals("En attend")) {
			            comp.setBackground(Color.red);
			            comp.setForeground(Color.white);
			        } else {
			        	comp.setBackground(Color.white);
			        }
			        return comp;
			    }
			
		};
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
		model.addColumn("WILAYA");
		model.addColumn("SALAIRE");
		model.addColumn("DUREE");
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
		table.getColumnModel().getColumn(7).setMinWidth(100);
		
		oc.initialize();

		try {
			oc.stmt=oc.con.prepareStatement("Select * From JObs where owner=? order by date_job DESC");
			oc.stmt.setString(1, username);

			oc.rs=oc.stmt.executeQuery();
			while(oc.rs.next()) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				Timestamp sql_date = oc.rs.getTimestamp("date_job");
				java.util.Date utilDate = new java.util.Date(sql_date.getTime());
				String dt = formatter.format(utilDate);
				model.addRow(new Object[]{oc.rs.getInt("code"), oc.rs.getString("titre"), oc.rs.getString("description"), dt, oc.rs.getString("wilaya"), oc.rs.getString("salaire"), oc.rs.getString("duration"), oc.rs.getString("etat")});
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
