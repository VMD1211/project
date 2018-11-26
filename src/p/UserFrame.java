package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import b.AreaB;
import b.TransportB;
import e.Area;

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

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel search;
	private JButton btnDelete;
	private JButton btnAdd;
	private DefaultTableModel model;
	private TransportB transportB;
	private Area area;

	private MainFrame main;
	private JTextField searchtxt;

	public void initModel() throws SQLException {
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
		setBounds(100, 100, 450, 300);

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
		panel.add(btnAdd);

		btnDelete = new JButton("Xe ra");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarOut carOut = new CarOut(UserFrame.this);
				carOut.setVisible(true);
			}
		});
		panel.add(btnDelete);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		search = new JLabel("Tim kiem");
		search.setFont(new Font("Tahoma", Font.BOLD, 15));
		search.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(search);

		searchtxt = new JTextField();
		panel_1.add(searchtxt);
		searchtxt.setColumns(30);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		area = new Area();
		
		JLabel label = new JLabel("Car:"+area.getQuantityCar()+"----"+"Motor:"+area.getQuantityMotor()+"----"+"Bike:"+ area.getQuantityBike());
		panel_2.add(label);
		
		

	}

}
