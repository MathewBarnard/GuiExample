package Windows;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GuiFramework.BasePanel;
import GuiFramework.MasterGuiWindow;

public class CustomerOrderWindow extends BasePanel {

	private JLabel mLabel;
	private JButton mBtnScreenOne;
	private JButton mBtnScreenTwo;
	private JButton mBtnScreenThree;
	private JButton mBtnBack;
	
	public CustomerOrderWindow(MasterGuiWindow mainWindow) {
		
		super(mainWindow);
	}
	
	@Override
	protected void initialiseComponents() {
		
		mLabel = new JLabel("", JLabel.CENTER);
		mBtnScreenOne = new JButton("Customer Orders");
		mBtnScreenTwo = new JButton("Purchase Orders");
		mBtnScreenThree = new JButton("Pick Customer Order");
		mBtnBack = new JButton("Back");
		
		setLayout(new GridLayout(5, 1));
		mLabel.setText("Customer Orders");
		add(mLabel);
		add(mBtnScreenOne);
		add(mBtnScreenTwo);
		add(mBtnScreenThree);
		add(mBtnBack);
		
		setVisible(true);
	}
	
	@Override
	protected void addEvents() {
		
		mBtnScreenOne.setActionCommand("GoToScreenOne");
		mBtnScreenTwo.setActionCommand("GoToScreenTwo");
		mBtnScreenThree.setActionCommand("GoToScreenThree");
		mBtnBack.setActionCommand("GoBack");
		
		mBtnScreenOne.addActionListener(new ButtonClickListener());
		mBtnScreenTwo.addActionListener(new ButtonClickListener());
		mBtnScreenThree.addActionListener(new ButtonClickListener());
		mBtnBack.addActionListener(new ButtonClickListener());
	}
	
	private class ButtonClickListener implements ActionListener {
		
		public void actionPerformed(ActionEvent ae) {
			
			String command = ae.getActionCommand();
			
			switch(command) {
			
			case "GoToScreenOne":
				mMainWindow.openWindow(new CustomerOrderWindow(mMainWindow));
				break;
			case "GoToScreenTwo":
				mMainWindow.openWindow(new PurchaseOrderWindow(mMainWindow));
				break;
			case "GoToScreenThree":
				mMainWindow.openWindow(new PickingOrderWindow(mMainWindow));
				break;
			case "GoBack":
				mMainWindow.closeWindow();
			default:
				break;
			}
		}
	}
}
