package da;

import java.sql.*;

public class ConnectionUtil {
	private static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (con == null) {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/car_manager_2";
			String user = "root";
			String password = "12345678";
			con = DriverManager.getConnection(url, user, password);
		}
		return con;
	}
}
