package System.InternalFrame;
import javax.swing.*;

import System.guangli.StockReturnpane;
public class StockReturnFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockReturnFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("进货退货单");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new StockReturnpane();
		tab.addTab("进货退货单", null, p1, "进货退货");
		getContentPane().add(tab);
		pack();
	}
	

}
