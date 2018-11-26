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

import b.TransportB;
import e.Transpost;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class CarIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1, textField_2, textField_3;
	private JLabel id, name, bienso, loai;
	private JButton finish;
	private UserFrame user;
	private Transpost trans;
	private TransportB b;
	private JList<String> list;
	private String[] type = { "O to", " xe may", "xe dap" };

	/**
	 * Create the application.
	 */

	public CarIn(UserFrame user) {
		super(user, "Xe vao", true);
		this.user = user;

		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);

		name = new JLabel("Name");
		panel.add(name);

		textField_1 = new JTextField();
		textField_1.setColumns(14);
		panel.add(textField_1);

		bienso = new JLabel("Bien So");
		panel.add(bienso);

		textField_2 = new JTextField();
		textField_2.setColumns(14);
		panel.add(textField_2);

		loai = new JLabel("Loai");
		panel.add(loai);

		textField_3 = new JTextField();
		textField_3.setColumns(14);
		panel.add(textField_3);

		list = new JList<String>(type);
		panel.add(list);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String type = "";
				type = list.getSelectedValue();
				textField_3.setText(type);
			}
		});

		finish = new JButton("FINISH");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date = new Date();
				trans = new Transpost();
				trans.setName(textField_1.getText());
				trans.setBienso(textField_2.getText());
				trans.setLoai(textField_3.getText());
				trans.setTimeIn(new java.sql.Time(date.getTime()));
				//System.currentTimeMillis();
				
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
				JOptionPane.showMessageDialog(CarIn.this, "Da add thanh cong");

				CarIn.this.setVisible(false);

			}

		});
		panel.add(finish);

	}

}
