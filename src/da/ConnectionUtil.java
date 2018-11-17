package da;
import java.sql.*;

public class ConnectionUtil {
	private static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (con == null) {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/car_manager";
			String user = "root";
			String password = "123456";
			con = DriverManager.getConnection(url, user, password);
		}
		return con;
	}
}
