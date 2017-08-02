package System.InternalFrame;
import javax.swing.*;

import System.guangli.StockAddpane;
public class StockFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("进货单");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new StockAddpane();
		tab.addTab("进货单", null, p1, "进货");
		getContentPane().add(tab);
		pack();
	}
	

}
