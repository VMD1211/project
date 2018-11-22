package b;

import java.sql.SQLException;

import da.UserDA;

public class UserB {
	private UserDA uDA;

	public UserB() {
		uDA = new UserDA();
	}

	public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
		return uDA.checkUser(username, password);
	}

}
