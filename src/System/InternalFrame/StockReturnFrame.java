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
		setTitle("�����˻���");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new StockReturnpane();
		tab.addTab("�����˻���", null, p1, "�����˻�");
		getContentPane().add(tab);
		pack();
	}
	

}
