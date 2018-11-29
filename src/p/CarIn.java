package p;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import b.AreaB;
import b.TransportB;
import e.Area;
import e.Transpost;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CarIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1, textField_2, textField_3;
	private JLabel id, name, bienso, loai;
	private JButton finish;
	private UserFrame user;
	private Transpost trans;
	private TransportB b;
	private AreaB aB;
	private JList<String> list;
	private String[] type = { "Car", "MotorBike", "Bike" };

	/**
	 * Create the application.
	 */

	public CarIn(UserFrame user) {
		super(user, "Xe vao", true);
		setTitle("CHECK IN");
		this.user = user;

		setAlwaysOnTop(true);
		setBounds(100, 100, 452, 305);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 266);
		contentPanel.add(panel);
		panel.setLayout(null);

		name = new JLabel("Name");
		name.setForeground(new Color(255, 255, 0));
		name.setBounds(23, 8, 47, 14);
		panel.add(name);

		textField_1 = new JTextField();
		textField_1.setBounds(70, 5, 118, 20);
		textField_1.setColumns(14);
		panel.add(textField_1);

		bienso = new JLabel("License plate");
		bienso.setForeground(new Color(255, 255, 0));
		bienso.setBounds(208, 8, 78, 14);
		panel.add(bienso);

		textField_2 = new JTextField();
		textField_2.setBounds(296, 5, 118, 20);
		textField_2.setColumns(14);
		panel.add(textField_2);

		loai = new JLabel("Type");
		loai.setForeground(new Color(255, 255, 0));
		loai.setBounds(23, 33, 39, 24);
		panel.add(loai);

		textField_3 = new JTextField();
		textField_3.setBounds(198, 35, 118, 20);
		textField_3.setColumns(14);
		//panel.add(textField_3);

		/*list = new JList<String>(type);
		panel.add(list);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String type = "";
				type = list.getSelectedValue();
				textField_3.setText(type);
			}
		});*/
		finish = new JButton("FINISH");
		finish.setBounds(336, 232, 90, 23);
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date = new Date();
				trans = new Transpost();
				trans.setName(textField_1.getText());
				trans.setBienso(textField_2.getText());
				trans.setLoai(textField_3.getText());
				trans.setTimeIn(new java.sql.Time(date.getTime()));

				b = new TransportB();
				try {
					b.addTrans(trans);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					user.initModel();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Area car = new Area();
				car.setArea("Car");
				Area motor = new Area();
				motor.setArea("MotorBike");
				Area bike= new Area();
				bike.setArea("Bike");
				aB = new AreaB();
				if(textField_3.getText().equals("Car")) {
					try {
						aB.deleteQuantity(car);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(textField_3.getText().equals("MotorBike")) {
					try {
						aB.deleteQuantity(motor);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						aB.deleteQuantity(bike);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				user.initQuantity(car,motor,bike);
				

				JOptionPane.showMessageDialog(CarIn.this, "Da add thanh cong");

				CarIn.this.setVisible(false);

			}

		});
		panel.add(finish);
		
		JComboBox comboBox = new JComboBox(type);
		comboBox.setBounds(70, 34, 118, 22);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String type = "";
				type = (String) comboBox.getSelectedItem();
				textField_3.setText(type);
			}
		});
		panel.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\glasgow-prestwick-airport-parking - Copy.jpg"));
		label.setBounds(0, 0, 436, 266);
		panel.add(label);

	}
}
