package System.InternalFrame;
import javax.swing.*;

import System.guangli.SellSearchpane;


public class SellSearchFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SellSearchFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("������Ϣ��ѯ");
		JPanel p1=new SellSearchpane();
		add(p1);
		pack();
	}
	

}
