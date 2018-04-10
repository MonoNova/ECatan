package Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Random;

import Controllers.TestController;
import Models.TestModel;

public class TestDAO {
	public static final String TABLE_NAME = "testtable";
	
	private Random random = new Random();
	
	private static TestDAO instance = null;

	public static TestDAO getInstance() {
		if (instance == null) {
			instance = new TestDAO();
		}
		return instance;
	}
	
	public void createTestObject() {
		int testX = random.nextInt(1000);
		int testY = random.nextInt(1000);
		String testString = "#: " + random.nextInt(1000);
		Double testDouble = random.nextDouble();
		
		String SQLQuery = "INSERT INTO " + TABLE_NAME + " VALUES (" + testX + ", " + testY + ", \""+ testString + "\", " + testDouble + ")";
		System.out.println(SQLQuery);
		DatabaseAdapter.getInstance().executeNormalQuery(SQLQuery, QueryType.INSERT);
	}
	
	public void viewAllTestObjects() {
		String SQLQuery = "SELECT * FROM " + TABLE_NAME;
		ResultSet allTestObjects = DatabaseAdapter.getInstance().executeSelectQuery(SQLQuery);
		try {
			while (allTestObjects.next()) {
				TestModel testModel = new TestModel(allTestObjects.getInt("testX"), allTestObjects.getInt("testY"), allTestObjects.getString("testString"), allTestObjects.getDouble("testDouble"));
				testModel.addObserver(TestController.getInstance());
				TestController.getInstance().addTestModel(testModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
