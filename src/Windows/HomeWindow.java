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

public class HomeWindow extends BasePanel {

	private JLabel mLabel;
	private JButton mBtnScreenOne;
	private JButton mBtnScreenTwo;
	private JButton mBtnScreenThree;
	
	public HomeWindow(MasterGuiWindow mainWindow) {
		
		super(mainWindow);
	}
	
	@Override
	protected void initialiseComponents() {
		mLabel = new JLabel("", JLabel.CENTER);
		mBtnScreenOne = new JButton("Customer Orders");
		mBtnScreenTwo = new JButton("Purchase Orders");
		mBtnScreenThree = new JButton("Pick Customer Order");
		
		setLayout(new GridLayout(5, 1));
		mLabel.setText("Main Window");
		add(mLabel);
		add(mBtnScreenOne);
		add(mBtnScreenTwo);
		add(mBtnScreenThree);
	
		setVisible(true);
	}
	
	@Override
	protected void addEvents() {
		
		mBtnScreenOne.setActionCommand("GoToCustomerOrders");
		mBtnScreenTwo.setActionCommand("GoToPurchaseOrders");
		mBtnScreenThree.setActionCommand("GoToPickingOrders");
		mBtnScreenOne.addActionListener(new ButtonClickListener());
		mBtnScreenTwo.addActionListener(new ButtonClickListener());
		mBtnScreenThree.addActionListener(new ButtonClickListener());
	}
	
	private class ButtonClickListener implements ActionListener {
		
		public void actionPerformed(ActionEvent ae) {
			
			String command = ae.getActionCommand();
			
			switch(command) {
			
			case "GoToCustomerOrders":
				mMainWindow.openWindow(new PickingOrderWindow(mMainWindow));
				break;
			case "GoToPurchaseOrders":
				mMainWindow.openWindow(new PurchaseOrderWindow(mMainWindow));
				break;
			case "GoToPickingOrders":
				mMainWindow.openWindow(new PickingOrderWindow(mMainWindow));
				break;
			default:
				break;
			}
		}
	}
}
