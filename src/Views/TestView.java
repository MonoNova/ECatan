package Views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.TestController;

public class TestView extends JPanel {

	private JLabel countLabel;
	private JButton testButton;
	
	public TestView() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(500, 500));
		
		this.countLabel = new JLabel("No changes."); 
		this.testButton = new JButton("Change models.");
		
		this.testButton.addActionListener((ActionEvent) -> {
			TestController.getInstance().changeTestModels();
		});
		
		this.countLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(countLabel);
		this.add(testButton);
	}

	public void updateCount(int amountOfCounts) {
		this.countLabel.setText("Amount of changes: " + amountOfCounts);
	}
}
