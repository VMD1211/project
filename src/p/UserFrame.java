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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

import java.util.Vector;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel status,quantity;
	private JButton btnDelete;
	private JButton btnAdd;
	private DefaultTableModel model;
	private TransportB transportB;
	private AreaB b;
	

	private MainFrame main;
	private JTextField searchtxt;

	public static int findId(List<Vector> target, String searchInput) {
		for (int i = 0; i < target.size(); i++) {
			if (searchInput.equals(target.get(i).get(0)))
				return i;
		}
		return -1;
	}
	
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
		setTitle("LIST");
		this.main = main;
		transportB = new TransportB();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 325);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 35, 420, 205);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		try {
			initModel();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setBounds(407, 35, 148, 205);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);

		btnAdd = new JButton("Check In");
		btnAdd.setBounds(23, 5, 125, 23);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\icons8-car-filled-15.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarIn carIn = new CarIn(UserFrame.this);
				carIn.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(btnAdd);

		btnDelete = new JButton("Check Out");
		btnDelete.setBounds(23, 39, 125, 23);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\icons8-fiat-500-filled-15.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarOut carOut = new CarOut(UserFrame.this);
				carOut.setVisible(true);
			}
		});
		panel.add(btnDelete);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLUE);
		panel_1.setBounds(5, 5, 550, 30);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * WARNING!
				 * Those line of code is made for Java 10+, this line of code will not compiled in lower Java version.
				 * Change "var" to "String" if necessary
				 */
				var searchInput = searchtxt.getText();
				if (!Objects.isNull(searchtxt) || searchInput.length() > 0) {
					var data = model.getDataVector();
					var index = findId(data, searchInput);
					if (index != -1) {
						// TODO: Make something with the found index
						int a = Integer.parseInt(searchInput) - 1;
						JOptionPane.showMessageDialog(UserFrame.this, "ID: " + data.get(a).get(0) + "\nName: " + data.get(a).get(1) + "\nlicense plate: " + data.get(a).get(2) + "\nType: " + data.get(a).get(3) + "\nTime In: " + data.get(a).get(4));
					} else {
						JOptionPane.showMessageDialog(UserFrame.this, "Transport unvaluable");
						// TODO: Handle the case of not found the index
						
					}
				} else {
					//TODO: Fill "else" case
					JOptionPane.showMessageDialog(UserFrame.this,"please input id");
				}
			}
		});
		panel_1.add(btnSearch);
		

		searchtxt = new JTextField();
		searchtxt.setForeground(new Color(0, 0, 205));
		panel_1.add(searchtxt);
		searchtxt.setColumns(30);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 251, 550, 24);
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		
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
