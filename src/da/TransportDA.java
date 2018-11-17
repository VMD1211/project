package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public List<Transpost> getAll() throws SQLException{
		List<Transpost> transports = new ArrayList<Transpost>();
		
		String sql = "SELECT id,name,bienso,loai  FROM transport";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			Transpost transpost = new Transpost(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			transports.add(transpost);
		}
		
		return transports;
	}
	public boolean insertTrans(int id, String name, String bienso, String loai) throws SQLException {
		
		String sql ="INSERT INTO transport (`id`,`name`,`bienso`,`loai`) VALUES (?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setString(3, bienso);
		statement.setString(4, loai);
		
		int result = statement.executeUpdate();
		
		return result >0;
	}
}


