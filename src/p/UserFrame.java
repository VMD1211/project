package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import b.TransportB;


import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnDelete;
	private JButton btnAdd;
	private DefaultTableModel model;
	private TransportB transportB;
	private MainFrame main;
	private JTextField searchtxt;
	private JButton btnSearch;

	public void initModel() throws SQLException{
		model = transportB.getAllTrans();
		table.setModel(model);
	}
	/**
	 * Create the frame.
	 */
	public UserFrame(MainFrame main) {
		this.main = main;
		transportB = new TransportB();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 338);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			initModel();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		btnAdd = new JButton("Xe vao");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarIn carIn = new CarIn(UserFrame.this);
				carIn.setVisible(true);
			}
		});
		
		btnDelete = new JButton("Xe ra");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarOut carOut = new CarOut(UserFrame.this);
				carOut.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(btnAdd, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(4)
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		panel_1.add(btnSearch);
		
		searchtxt = new JTextField();
		panel_1.add(searchtxt);
		searchtxt.setColumns(30);


				
	}
}
