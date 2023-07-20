import junit.framework.TestCase;

import junit.framework.TestCase;
import java.sql.*;

public class JdbcAccessTest extends TestCase {
	public void testConnection() throws SQLException {
		JdbcAccess access = new JdbcAccess("test");
		Connection connection = null;
		try {
			connection = access.getConnection();
			assertFalse(connection.isClosed());
		}
		finally {
			connection.close();
		}
	}
}
