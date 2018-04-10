package Views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DebugPanel extends JPanel{

	private JTextArea textArea;
	private JScrollPane scrollPane; 
	
	public DebugPanel() {
		this.setLayout(new BorderLayout());
		this.textArea = new JTextArea();
		this.textArea.setEditable(false);
		this.scrollPane = new JScrollPane(this.textArea);
		this.setPreferredSize(new Dimension(500, 500));
		
		System.setOut(new PrintStream(new OutputStream() {
	        @Override
	        public void write(int arg0) throws IOException {
	        	WriteMessage(arg0);
	        }
	    }));
		
		this.add(this.scrollPane, BorderLayout.CENTER);
	}
	
	public void WriteMessage(int textByte) {
		this.textArea.setText(this.textArea.getText() + (char)textByte);
	}
}
