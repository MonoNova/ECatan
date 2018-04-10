package Access;
import java.sql.*;

import com.mysql.jdbc.CommunicationsException;

public class DatabaseAdapter {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/";
	private final String DB = "catan";

	private final String USERNAME = "root";
	private final String PASSWORD = "";

	private static DatabaseAdapter instance = null;

	private Connection connection = null;

	private DatabaseAdapter() {
		try {
			System.out.println("Connecting to DB: " + DB_URL + DB);
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL + DB, USERNAME, PASSWORD);
			System.out.println("DB adapter connection success.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseAdapter getInstance() {
		if (instance == null) {
			instance = new DatabaseAdapter();
		}
		return instance;
	}
	
	public ResultSet executeSelectQuery(String queryString) {
		Statement sqlstatement = null;
		ResultSet result = null;
		try {
			sqlstatement = connection.createStatement();
			System.out.println("Retrieving records from the table...");
			result = sqlstatement.executeQuery(queryString);
		} catch (SQLException e) {
			System.out.println("SQL SELECT Query could not be executed!");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean executeNormalQuery(String queryString, QueryType queryType) {
		Statement sqlstatement = null;
		int result = 0;
		try {
			sqlstatement = connection.createStatement();
			result = sqlstatement.executeUpdate(queryString);
			System.out.println("Succesfully " + getQueryTypeName(queryType) + " record(s).");
			sqlstatement.close();
		} catch (SQLException e) {
			System.out.println("SQL INSERT Query could not be executed!");
			e.printStackTrace();
		}
		return result != 0;
	}
	
	private String getQueryTypeName(QueryType queryType) {
		switch(queryType) {
		case DELETE:
			return "deleted";
		case INSERT:
			return "inserted";
		case UPDATE:
			return "updated";
		default:
			return null;
		}
	}
}
