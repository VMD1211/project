package p;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import b.TransportB;
import e.Transpost;

import javax.swing.JButton;

public class CarOut extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private UserFrame user;
	private Transpost trans;
	private TransportB b;
	
	
	public CarOut(UserFrame user) {
		this.user = user;
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNhapId = new JLabel("Nhap ID");
		lblNhapId.setBounds(89, 103, 46, 14);
		getContentPane().add(lblNhapId);
		
		textField = new JTextField();
		textField.setBounds(145, 100, 186, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(229, 227, 89, 23);
		btnFinish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				trans = new Transpost();
				trans.setId(Integer.parseInt(textField.getText()));
				
				b = new TransportB();
				try {
					b.deleteTrans(trans);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(335, 227, 89, 23);
		getContentPane().add(btnCancel);
	}

}