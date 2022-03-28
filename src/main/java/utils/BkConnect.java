package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BkConnect {
	private static Connection cnn;

	private static final String SERVER = "jdbc:sqlserver://localhost:1433;databaseName=bkaphr"; 
																								
	private static final String USERNAME = "yen";
	private static final String PASSWORD = "1234";

	private BkConnect() {
	}

	public static Connection getConnection() {
		if (cnn == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				cnn = DriverManager.getConnection(SERVER, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cnn;
	}
}
