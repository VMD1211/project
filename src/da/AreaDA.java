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

	public int getQuantity(String area) throws SQLException {
		String sql = "SELECT quantity FROM area WHERE area = ?";
		Statement stmt = con.createStatement();
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, area);
		ResultSet rs = statement.executeQuery();
		int quantity = 0;
		if (rs.next()) {
			quantity = rs.getInt(1);
		}

		return quantity;

	}

	public boolean deleteQuan(String area) throws SQLException {

		String sql = "UPDATE area SET quantity = quantity -1 WHERE area = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, area);

		int result = statement.executeUpdate();

		return result > 0;
	}

	public boolean addQuan(String area) throws SQLException {

		String sql = "UPDATE area SET quantity = quantity +1 WHERE area = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, area);

		int result = statement.executeUpdate();

		return result > 0;
	}

}
