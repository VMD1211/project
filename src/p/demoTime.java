package p;

import java.sql.Time;
import java.util.Date;

import javax.swing.JLabel;

public class demoTime {
	public static void main(String[] args) {
		Date date = new Date();
		Time d1 = new java.sql.Time(date.getTime());
		System.out.println(String.valueOf(d1));
		
		
		
		
	}
}
