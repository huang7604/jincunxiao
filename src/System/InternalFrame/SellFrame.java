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
		setTitle("���۵�");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SellAddpane();
		tab.addTab("���۵����", null, p1, "���");
		getContentPane().add(tab);
		pack();
	}
	

}
