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
		setTitle("�����˻���");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SellReturnpane();
		tab.addTab("�����˻�", null, p1, "�����˻�");
		getContentPane().add(tab);
		pack();
	}
	

}
