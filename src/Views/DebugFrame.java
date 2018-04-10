package Views;
import javax.swing.JFrame;

public class DebugFrame extends JFrame {

	private DebugPanel debugPanel;
	
	public DebugFrame() {
		this.setTitle("Debug Window");
		this.setLayout(null);
		this.setResizable(false);
		
		debugPanel = new DebugPanel();
		this.setContentPane(debugPanel);
	}
	
	public void create() {
		this.pack();
		this.setVisible(true);
	}
}
