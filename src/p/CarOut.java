package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import b.TransportB;
import e.Transpost;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CarOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private UserFrame user;
	private Transpost trans;
	private TransportB b;
	private JLabel lblNhapId;

	public CarOut(UserFrame user) {
		super(user, "Xe ra", true);
		this.user = user;
		setAlwaysOnTop(true);

		setBounds(100, 100, 450, 300);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel1 = new JPanel();
		contentPanel.add(panel1, BorderLayout.NORTH);
		lblNhapId = new JLabel("Nhap ID");
		lblNhapId.setBounds(85, 11, 46, 14);
		panel1.add(lblNhapId);

		textField = new JTextField();
		textField.setBounds(141, 8, 186, 20);
		panel1.add(textField);
		textField.setColumns(10);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				trans = new Transpost();
				trans.setId(Integer.parseInt(textField.getText()));
				trans.setTimeOut(new java.sql.Time(date.getTime()));

				b = new TransportB();
				try {
					b.setTimeOut(trans);
					SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
					String d1 =format.format(trans.getTimeIn());
					String d2 = format.format(trans.getTimeOut());
					b.tinh(Long.parseLong(d1),Long.parseLong(d2));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					user.initModel();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(CarOut.this, "Xe da out");
				CarOut.this.setVisible(false);
			}
		});
		btnFinish.setBounds(229, 227, 89, 23);
		contentPanel.add(btnFinish, BorderLayout.SOUTH);

	}
}