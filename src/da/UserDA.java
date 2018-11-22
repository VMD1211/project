package da;

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
		String sql = "SELECT * FROM employee WHERE username =? AND password =?";
		PreparedStatement stmt = ConnectionUtil.getConnection().prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);

		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			return true;

		return false;

	}
}
