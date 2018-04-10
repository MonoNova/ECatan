package Views;

import javax.swing.JFrame;

import Controllers.TestController;

public class MainFrame extends JFrame {

	public MainFrame() {
		this.setTitle("Colonisten van Catan");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(TestController.getInstance().getView());
	}
	
	public void create() {
		this.pack();
		this.setVisible(true);
	}
}
