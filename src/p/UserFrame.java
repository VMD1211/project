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
import java.awt.Color;
import javax.swing.ImageIcon;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel search,status,quantity;
	private JButton btnDelete;
	private JButton btnAdd;
	private DefaultTableModel model;
	private TransportB transportB;
	private AreaB b;
	

	private MainFrame main;
	private JTextField searchtxt;

	public void initModel() throws SQLException {
		model = transportB.getAllTrans();
		table.setModel(model);
	}
	public void initQuantity(Area car,Area motor, Area bike) {
		try {
			quantity.setText("Car: "+" "+String.valueOf(b.getQuantity(car)+"-----"+"MotorBike:"+String.valueOf(b.getQuantity(motor))+"-----"+"Bike:"+String.valueOf(b.getQuantity(bike))));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
		contentPane.setBackground(Color.ORANGE);
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
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.EAST);

		btnAdd = new JButton("Xe vao");
		btnAdd.setIcon(new ImageIcon("D:\\video\\icons8-car-26.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarIn carIn = new CarIn(UserFrame.this);
				carIn.setVisible(true);
			}
		});
		panel.add(btnAdd);

		btnDelete = new JButton("Xe ra");
		btnDelete.setIcon(new ImageIcon("D:\\video\\icons8-sedan-26.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarOut carOut = new CarOut(UserFrame.this);
				carOut.setVisible(true);
			}
		});
		panel.add(btnDelete);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		contentPane.add(panel_1, BorderLayout.NORTH);

		search = new JLabel("Tim kiem");
		search.setFont(new Font("Tahoma", Font.BOLD, 15));
		search.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(search);

		searchtxt = new JTextField();
		panel_1.add(searchtxt);
		searchtxt.setColumns(30);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		//Quantity
		Area car = new Area();
		car.setArea("Car");
		Area motor = new Area();
		motor.setArea("MotorBike");
		Area bike = new Area();
		bike.setArea("Bike");
		quantity = new JLabel();
		b = new AreaB();
		initQuantity(car, motor,bike);
		panel_2.add(quantity);
		
		
		
		

	}

}
