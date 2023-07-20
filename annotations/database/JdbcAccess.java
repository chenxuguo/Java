
import java.sql.*;

public class JdbcAccess {
	private String url;
	private String database;
	private String user = "root";
	private String password = "123456";

	public JdbcAccess(String database) {
		this.database = database;
	}
	public void execute(String sql) throws SQLException {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} finally {
			close(connection);
		}
	}

	private void close(Connection connection) throws SQLException {
		if (connection != null)
			connection.close();
	}

	Connection getConnection() throws SQLException {
		if (url == null) {
			//loadDriver();
			url = "jdbc:mysql://172.17.0.2/" + database;
		}
		return DriverManager.getConnection(url, user, password);
	}

	private void loadDriver() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception cause) {
			throw new SQLException(cause.getMessage());
		}
	}
}
