package System.InternalFrame;
import javax.swing.*;

import System.guangli.PriceChange;


public class PriceFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PriceFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("价格调整");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new PriceChange();
		tab.addTab("价格调整", null, p1, "调整");
	    getContentPane().add(tab);
	    pack();
	}
	

}
