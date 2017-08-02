package System.InternalFrame;
import javax.swing.*;

import System.guangli.SellReturnpane;

public class SellReturnFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SellReturnFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("销售退货单");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SellReturnpane();
		tab.addTab("销售退货", null, p1, "销售退货");
		getContentPane().add(tab);
		pack();
	}
	

}
