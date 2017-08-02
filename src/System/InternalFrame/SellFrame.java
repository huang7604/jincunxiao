package System.InternalFrame;
import javax.swing.*;

import System.guangli.SellAddpane;
public class SellFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SellFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("销售单");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SellAddpane();
		tab.addTab("销售单添加", null, p1, "添加");
		getContentPane().add(tab);
		pack();
	}
	

}
