package UnitTests;

import java.sql.ResultSet;
import java.sql.SQLException;

import Access.DatabaseAdapter;
import Access.QueryType;
import junit.framework.*;

public class DatabaseAdapterTest extends TestCase {

	private String testTable = "testtable";

	public void testDatabaseRetrieval() {
		String query = "SELECT * FROM " + testTable + " LIMIT 1";
		ResultSet rs = DatabaseAdapter.getInstance().executeSelectQuery(query);

		try {
			if (rs.next()) {
				assertEquals(299, rs.getInt("testX"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testDatabaseInsertion() {
		String query = "INSERT INTO " + testTable + " (testX, testY, testString, testDouble) VALUES (420, 1337, 'JUnit Test', 8.91)";
		assertEquals(true, DatabaseAdapter.getInstance().executeNormalQuery(query, QueryType.INSERT));
	}
	
	public void testDatabaseDeletion() {
		String query = "DELETE FROM " + testTable + " WHERE testX = 420 AND testY = 1337";
		assertEquals(true, DatabaseAdapter.getInstance().executeNormalQuery(query, QueryType.DELETE));
	}
}
