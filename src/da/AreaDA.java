package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import e.Area;
import e.Transpost;

public class AreaDA {
	private Connection con;

	public AreaDA() {
		// TODO Auto-generated constructor stub
		try {
			con = ConnectionUtil.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int setQuantityCar() throws SQLException {
		int x=0;
		String sql = "SELECT quantity FROM area WHERE area ='Car'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Area area =  new Area();
			x = rs.getInt(1);
			area.setQuantityMotor(x);
		}
		
		return x;
	}

	public int setQuantityMotor() throws SQLException {
		int x=0;
		String sql = "SELECT quantity FROM area WHERE area ='MotorBike'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Area area =  new Area();
			x = rs.getInt(1);
			area.setQuantityMotor(x);
		}
		return x;
	}

	public int setQuantityBike() throws SQLException {
		int x=0;
		String sql = "SELECT quantity FROM area WHERE area ='Bike'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Area area = new Area();
			x = rs.getInt(1);
			area.setQuantityBike(x);
		}
		return x;
	}
	
	public boolean deleteQuan(String name) throws SQLException {

		String sql = "UPDATE area SET quantity = quantity -1 WHERE area = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, name);
		

		int result = statement.executeUpdate();

		return result > 0;
	}

}
