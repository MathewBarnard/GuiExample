package GuiFramework;
import javax.swing.JPanel;


public abstract class BasePanel extends JPanel {

	protected MasterGuiWindow mMainWindow;
	
	public BasePanel(MasterGuiWindow mainWindow) {
		
		mMainWindow = mainWindow;
		
		initialiseComponents();
		addEvents();
		
		mMainWindow.attachPanel(this);
	}
	
	protected void setMasterWindow(MasterGuiWindow mainWindow){
		
		mMainWindow = mainWindow;
	}
	
	protected abstract void initialiseComponents();
	protected abstract void addEvents();
}
