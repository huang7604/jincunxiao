package System.InternalFrame;
import javax.swing.*;

import System.guangli.SellRankpane;
public class SellRank extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SellRank()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("销售排行");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SellRankpane();
		tab.addTab("销售排行", null, p1, "排行");
		getContentPane().add(tab);
		pack();
	}
	

}
