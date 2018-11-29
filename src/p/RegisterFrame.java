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
import javax.swing.JDialog;

public class RegisterFrame extends JDialog {

	
	private JTextField Usertxt;
	private JPasswordField passwordField;
	private MainFrame main;
	private JTextField Idtxt;
	private JTextField Nametxt;
	
	
	public RegisterFrame(MainFrame main) {
		super(main, true);
		this.main = main;
		setAlwaysOnTop(true);
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(171, 11, 174, 64);
		lblRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblRegister);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setBounds(93, 87, 65, 14);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(93, 112, 77, 14);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblPassword);
		
		Usertxt = new JTextField();
		Usertxt.setBounds(171, 86, 160, 20);
		getContentPane().add(Usertxt);
		Usertxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 111, 160, 20);
		getContentPane().add(passwordField);
		
		JLabel labelName = new JLabel("Name ");
		labelName.setBounds(93, 137, 46, 14);
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(labelName);
		
		//JLabel labelId = new JLabel("Id");
		//labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//labelId.setBounds(81, 96, 46, 14);
		//getContentPane().add(labelId);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(171, 137, 160, 20);
		getContentPane().add(Nametxt);
		Nametxt.setColumns(10);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setBounds(278, 212, 89, 23);
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFinish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				User employee = new User();
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
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 261);
		getContentPane().add(label);
	}
}
