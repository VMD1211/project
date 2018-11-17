package da;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import e.User;

public class UserDA {
	public List<User> getAllUser() {
		
		return null;
	}
	public boolean checkUser(String username, String password) throws ClassNotFoundException, SQLException {
		String sql="SELECT * FROM employee WHERE username =? AND password =?";
		PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			return true;
		
		return false;
		
	}
	
	public boolean insertUser(int id_em, String username, String password, String name) throws ClassNotFoundException,SQLException {		
		String sql ="INSERT INTO employee VALUES (?,?,?,?,'NULL')";
		PreparedStatement stm = ConnectionUtil.getConnection().prepareStatement(sql);
		stm.setInt(1, id_em);
		stm.setString(2, username);
		stm.setString(3, password);
		stm.setString(4, name);
		
		int result = stm.executeUpdate();
		
		return result >0;
	}
	
}
