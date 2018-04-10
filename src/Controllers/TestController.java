package Controllers;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Models.TestModel;
import Views.TestView;

public class TestController implements Observer{

	private int amountOfChanges = 0;
	
	private HashMap<Integer, TestModel> testModels = new HashMap<Integer, TestModel>();
	private TestView testView;
	
	private static TestController instance;

	public TestController() {
		this.testView = new TestView();
	}
	
	public static TestController getInstance() {
		if (instance == null) {
			instance = new TestController();
		}
		return instance;
	}
	
	public void addTestModel(TestModel testModel) {
		this.testModels.put(testModel.hashCode(), testModel);
	}

	public void changeTestModels() {
		for(TestModel testModel : testModels.values()) {
			testModel.change();
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		TestModel testModel = (TestModel) arg0;
		System.out.println("#" + testModel.hashCode() + " has changed.");
		
		amountOfChanges += 1;
		this.testView.updateCount(amountOfChanges);
	}
	
	public TestView getView() {
		return this.testView;
	}
}
