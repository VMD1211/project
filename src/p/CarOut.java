package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import b.AreaB;
import b.TransportB;
import e.Area;
import e.Transpost;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class CarOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private UserFrame user;
	private Transpost trans;
	private TransportB b;
	private JLabel lblNhapId;
	private long tongTime;
	private double tongTien;
	private AreaB aB;

	public CarOut(UserFrame user) {
		super(user, "Xe ra", true);
		setTitle("CHECK OUT");
		this.user = user;
		setAlwaysOnTop(true);

		setBounds(100, 100, 450, 90);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel1 = new JPanel();
		contentPanel.add(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblNhapId = new JLabel("ID");
		lblNhapId.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(lblNhapId);

		textField = new JTextField();
		panel1.add(textField);
		textField.setColumns(10);

		JButton btnFinish = new JButton("Ticket");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				trans = new Transpost();
				trans.setId(Integer.parseInt(textField.getText()));
				trans.setTimeOut(new java.sql.Time(date.getTime()));

				b = new TransportB();

				try {
					b.setTimeOut(trans);
					String timeOut = String.valueOf(trans.getTimeOut());
					SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
					Date d1 = null;
					Date d2 = null;
					try {
						d1 = format.parse(b.getTimeIn(trans));
						d2 = format.parse(timeOut);
						long diff = d2.getTime() - d1.getTime();

						if (diff / (60 * 60 * 1000) < 1) {
							tongTime = diff / (60 * 1000);
							tongTien = 3000;

						} else {
							tongTime = diff / (60 * 60 * 1000);
							if (b.getType(trans).equals("Car")) {
								tongTien = tongTime * 5000;
							} else if (b.getType(trans).equals("MotorBike")) {
								tongTien = tongTime * 3000;
							} else {
								tongTien = tongTime * 1000;
							}

						}

					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// in ticket

				try {
					FileOutputStream f = new FileOutputStream("C:\\Users\\Admin\\Desktop\\ticket.txt");
					PrintWriter output = new PrintWriter(f);
					output.println(String.valueOf("Ngay:" + " " + java.time.LocalDate.now()));
					output.println(String.valueOf("So id:" + " " + trans.getId()));
					output.println("Name:" + " " + b.getName(trans));
					output.println("Bien so:" + " " + b.getBienSo(trans));
					output.println("Loai:" + " " + b.getType(trans));
					output.println("Time In:" + " " + b.getTimeIn(trans));
					output.println("Time Out:" + " " + trans.getTimeOut());
					output.println("Tong tien:" + " " + tongTien);
					output.close();
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				

			}
		});
		contentPanel.add(btnFinish);

		JButton btnTicket = new JButton("Finish");
		btnTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trans = new Transpost();
				trans.setId(Integer.parseInt(textField.getText()));
				b = new TransportB();
				try {
					
					//them cho
					Area car = new Area();
					car.setArea("Car");
					Area motor = new Area();
					motor.setArea("MotorBike");
					Area bike= new Area();
					bike.setArea("Bike");
					aB = new AreaB();
					if(b.getType(trans).equals("Car")) {
						aB.addQuantity(car);
					}else if(b.getType(trans).equals("MotorBike")) {
						aB.addQuantity(motor);
					}else {
						aB.addQuantity(bike);
					}
					
					user.initQuantity(car, motor, bike);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					b.deleteTrans(trans);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		contentPanel.add(btnTicket);

	}
}