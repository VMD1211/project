package b;

import java.sql.SQLException;

import da.UserDA;
import e.User;

public class UserB {
	private UserDA uDA;

	public UserB() {
		uDA = new UserDA();
	}

	public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
		return uDA.checkUser(username, password);
	}
	public User addEmp(User emp) throws SQLException, ClassNotFoundException {
		uDA.insertUser(emp.getUsername(), emp.getPassword(), emp.getFullname());
		return emp;
	}
}
