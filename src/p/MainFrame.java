package p;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import b.UserB;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel mess;
	

	

	/**
	 * Create the application.
	 */
	

	
	public MainFrame() {
		setTitle("CAR MANAGER");
		
		setBounds(100, 100, 449, 248);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username ");
		lblUsername.setForeground(new Color(255, 255, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(69, 55, 87, 39);
		panel.add(lblUsername);
		
		mess = new JLabel();
		mess.setHorizontalAlignment(SwingConstants.CENTER);
		mess.setBounds(127, 162, 210, 14);
		panel.add(mess);
		
		textField = new JTextField();
		textField.setBounds(166, 66, 139, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password ");
		lblPassword.setForeground(new Color(255, 255, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(69, 86, 87, 39);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\icons8-password-15.png"));
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					UserB uB = new UserB();
					if(uB.checkLogin(textField.getText(), passwordField.getText())) {
						UserFrame userFrame = new UserFrame(MainFrame.this);
						userFrame.setVisible(true);
						MainFrame.this.setVisible(false);
						
						
					}
					else {
						mess.setText("Incorect username or password!");
						mess.setForeground(Color.RED);
						
						
						
						
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(190, 128, 89, 23);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 97, 139, 20);
		panel.add(passwordField);
		
		JLabel lblIf = new JLabel("Create new Employee");
		lblIf.setForeground(new Color(255, 255, 0));
		lblIf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIf.setBounds(10, 173, 210, 20);
		panel.add(lblIf);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame registerFrame = new RegisterFrame(MainFrame.this);
				registerFrame.setVisible(true);
				
			}
		});
		btnRegister.setBounds(334, 173, 89, 23);
		panel.add(btnRegister);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\exige02.jpg"));
		label.setBounds(0, 0, 434, 209);
		panel.add(label);
		
		
	}
}
