package Models;

import java.util.Observable;

public class TestModel extends Observable{

	private int testX;
	private int testY;
	private String testString;
	private double testDouble;
	
	public TestModel(int testX, int testY, String testString, double testDouble) {
		this.testX = testX;
		this.testY = testY;
		this.testString = testString;
		this.testDouble = testDouble;
	}

	public void change() {
		this.setChanged();
		this.notifyObservers();
	}
	
}
