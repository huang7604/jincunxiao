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
		setTitle("������");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new StockAddpane();
		tab.addTab("������", null, p1, "����");
		getContentPane().add(tab);
		pack();
	}
	

}
