package System.InternalFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import System.guangli.SuppleSearchpane;
public class SuppleSearchFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SuppleSearchFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SuppleSearchpane();
		tab.addTab("供应商查询", null, p1, "查询");
		getContentPane().add(tab);
		pack();
	}
	

}
