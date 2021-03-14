import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class Etat extends JFrame {

	private JPanel contentPane;

	public Etat(int code, String objet) {
		setTitle("Choisir l'etat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choisir l'etat");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
		lblNewLabel.setBounds(38, 27, 140, 30);
		contentPane.add(lblNewLabel);
		
		String groupes[] = {"Actif","En attend","Fermer"};
		
		JComboBox comboBox = new JComboBox(groupes);
		comboBox.setSelectedItem("En attend");
		comboBox.setBounds(216, 27, 130, 30);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("TERMINER");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objet.equals("don")) {
					Don d = new Don();
					d.setCode(code);
					d.setEtat((String)comboBox.getSelectedItem());
					d.changer_etat();
					dispose();
				} else {
					Job j = new Job();
					j.setCode(code);
					j.setEtat((String)comboBox.getSelectedItem());
					j.changer_etat();
					dispose();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(29,191,115));
		btnNewButton.setBounds(104, 84, 175, 50);
		getContentPane().add(btnNewButton);
		
		/* To center window in the middle*/
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
	}
}
