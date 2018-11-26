package p;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterFrame extends JFrame {

	
	private JTextField textField;
	private JPasswordField passwordField;
	private MainFrame main;

	
	
	public RegisterFrame(MainFrame main) {
		this.main = main;
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblRegister.setBounds(171, 11, 174, 64);
		getContentPane().add(lblRegister);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(81, 75, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(81, 108, 77, 14);
		getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(171, 74, 160, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 107, 160, 20);
		getContentPane().add(passwordField);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinish.setBounds(275, 170, 89, 23);
		getContentPane().add(btnFinish);
	}
}
