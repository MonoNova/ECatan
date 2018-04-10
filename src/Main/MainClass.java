package Main;
import Access.TestDAO;
import Controllers.MainController;
import Views.DebugFrame;
import Views.MainFrame;

public class MainClass {

	public static final boolean DEBUG_MODE = true;
	
	public static void main(String[] args) {
		MainController mainController = new MainController();
		TestDAO.getInstance().viewAllTestObjects();
	}

}
