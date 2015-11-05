package GuiFramework;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Windows.HomeWindow;


public class MasterGuiWindow extends JFrame{

	private JFrame mMainFrame;				
	private Stack<BasePanel> mPanelStack;	
	
	public MasterGuiWindow() {
		
		super("This is a GUI example!");
		
		this.setSize(400, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		mPanelStack = new Stack<BasePanel>();
		
		HomeWindow mainWindow = new HomeWindow(this);
		
		mPanelStack.push(mainWindow);
		this.setVisible(true);
	}
	
	public void attachPanel(JPanel panel) {
		
		this.add(panel);
	}
	
	public void openWindow(BasePanel newWindow) {
		
		mPanelStack.peek().setVisible(false);
		mPanelStack.push(newWindow);
		mPanelStack.peek().setVisible(true);
		
		System.out.println("Number of open windows: " + mPanelStack.size());
		
		this.repaint();
	}
	
	public void closeWindow() {
		
		mPanelStack.peek().setVisible(false);
		mPanelStack.pop();
		mPanelStack.peek().setVisible(true);
		
		System.out.println("Number of open windows: " + mPanelStack.size());
		
		this.repaint();
	}
}
