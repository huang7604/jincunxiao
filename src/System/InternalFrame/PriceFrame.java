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
		setTitle("�۸����");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new PriceChange();
		tab.addTab("�۸����", null, p1, "����");
	    getContentPane().add(tab);
	    pack();
	}
	

}
