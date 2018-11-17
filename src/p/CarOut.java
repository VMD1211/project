package p;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CarOut extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private UserFrame user;
	
	
	public CarOut(UserFrame user) {
		this.user = user;
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNhapId = new JLabel("Nhap ID");
		lblNhapId.setBounds(85, 11, 46, 14);
		getContentPane().add(lblNhapId);
		
		textField = new JTextField();
		textField.setBounds(141, 8, 186, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(176, 39, 89, 23);
		getContentPane().add(btnSearch);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(229, 227, 89, 23);
		getContentPane().add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(335, 227, 89, 23);
		getContentPane().add(btnCancel);
	}

}
