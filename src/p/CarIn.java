package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import b.TransportB;
import e.Transpost;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CarIn extends JFrame{

	private JPanel contentPane;
	private JTextField textField, textField_1,textField_2,textField_3;
	private JLabel id, name, bienso,loai;
	private JButton finish;
	private UserFrame user;
	private Transpost trans;
	private TransportB b;
	
	
	/**
	 * Create the application.
	 */
	
	public CarIn(UserFrame user) {
		this.user = user;
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		id = new JLabel("ID");
		panel.add(id);
		
		textField = new JTextField();
		textField.setColumns(14);
		panel.add(textField);
		
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
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		finish = new JButton("FINISH");
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trans = new Transpost();
				trans.setId(Integer.parseInt(textField.getText()));
				trans.setName(textField_1.getText());
				trans.setBienso(textField_2.getText());
				trans.setLoai(textField_3.getText());
				
				b = new TransportB();
				try {
					b.addTrans(trans);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel2.add(finish);
		
		
		
		
		
	}
}
