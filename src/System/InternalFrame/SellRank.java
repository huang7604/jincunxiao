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
		setTitle("��������");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SellRankpane();
		tab.addTab("��������", null, p1, "����");
		getContentPane().add(tab);
		pack();
	}
	

}
