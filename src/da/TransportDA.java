package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import e.Transpost;

public class TransportDA {
	private Connection con;

	public TransportDA() {
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

	public List<Transpost> getAll() throws SQLException {
		List<Transpost> transports = new ArrayList<Transpost>();

		String sql = "SELECT id,name,bienso,loai,time_in,time_out,ThanhToan  FROM transport";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Transpost transpost = new Transpost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getTime(5), rs.getTime(6), rs.getInt(7));
			transports.add(transpost);
		}
		

		return transports;
	}
	
	public boolean getTrans(int id) throws SQLException {

		String sql = "Select id, name, bienso, loai, time_in FROM transport where id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);

		int result = statement.executeUpdate();

		return result > 0;
	}
	
	public boolean insertTrans(int id, String name, String bienso, String loai, Time timeIn) throws SQLException {

		String sql = "INSERT INTO transport (`name`,`bienso`,`loai`,`time_in`) VALUES (?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);

		statement.setString(1, name);
		statement.setString(2, bienso);
		statement.setString(3, loai);
		statement.setTime(4, timeIn);

		int result = statement.executeUpdate();

		return result > 0;
	}
	
	public boolean setTimeOut(Time time, int id) throws SQLException {
		String sql = "UPDATE transport SET time_out = ? WHERE transport.id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setTime(1, time);
		statement.setInt(2, id);
		
		int result = statement.executeUpdate();
		
		return result >0;
		
	}
	
	public ResultSet getTimeIn(int id) throws SQLException {
		String sql = "SELECT time_in FROM transport WHERE transport.id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		
		return rs;
		
	}
	
	/*public boolean setTotal(int total, int id) throws SQLException {
		String sql = "UPDATE transport SET total = ? WHERE transport.id = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, total);
		statement.setInt(2, id);
		
		int result = statement.executeUpdate();
		
		return result >0;
	}*/

	
	// ....
}
