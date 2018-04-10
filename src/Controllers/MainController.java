package Controllers;

import javax.swing.SwingUtilities;

import Main.MainClass;
import Views.DebugFrame;
import Views.MainFrame;

public class MainController {

	private boolean debugMode;
	private MainFrame mainFrame;
	private DebugFrame debugFrame;
	
	public MainController() {
		this.mainFrame = new MainFrame();
		
		Runnable mainFrameThread = new Runnable(){
			@Override
			public void run() {
				mainFrame.create();
			}
		};
		
		if(MainClass.DEBUG_MODE) {
			this.debugFrame = new DebugFrame();
			Runnable debugFrameThread = new Runnable(){
				@Override
				public void run() {
					debugFrame.create();
				}
			};
			
			SwingUtilities.invokeLater(debugFrameThread);
		}
		
		SwingUtilities.invokeLater(mainFrameThread);
	}
}
