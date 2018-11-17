package p;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import b.UserB;
import e.User;
import javafx.scene.control.PasswordField;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RegisterFrame extends JFrame {

	
	private JTextField Usertxt;
	private JPasswordField passwordField;
	private MainFrame main;
	private JTextField Idtxt;
	private JTextField Nametxt;
	
	
	public RegisterFrame(MainFrame main) {
		this.main = main;
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblRegister.setBounds(171, 11, 174, 64);
		getContentPane().add(lblRegister);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(81, 121, 65, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(81, 146, 77, 14);
		getContentPane().add(lblPassword);
		
		Idtxt = new JTextField();
		Idtxt.setBounds(171, 95, 160, 20);
		getContentPane().add(Idtxt);
		Idtxt.setColumns(10);
		
		Usertxt = new JTextField();
		Usertxt.setBounds(171, 120, 160, 20);
		getContentPane().add(Usertxt);
		Usertxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 145, 160, 20);
		getContentPane().add(passwordField);
		
		JLabel labelName = new JLabel("Name ");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelName.setBounds(81, 171, 46, 14);
		getContentPane().add(labelName);
		
		JLabel labelId = new JLabel("Id");
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelId.setBounds(81, 96, 46, 14);
		getContentPane().add(labelId);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(171, 170, 160, 20);
		getContentPane().add(Nametxt);
		Nametxt.setColumns(10);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinish.setBounds(278, 212, 89, 23);
		btnFinish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				User employee = new User();
				employee.setId(Integer.parseInt(Idtxt.getText()));
				employee.setUsername(Usertxt.getText());
				employee.setPassword(passwordField.getText());
				employee.setFullname(Nametxt.getText());
				
				UserB b = new UserB();
				try {
					b.addEmp(employee);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnFinish);
	}
}
