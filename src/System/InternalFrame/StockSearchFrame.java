package System.InternalFrame;
import javax.swing.*;

import System.guangli.StockSearchpane;


public class StockSearchFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockSearchFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("������Ϣ��ѯ");
		JPanel p1=new StockSearchpane();
		add(p1);
		pack();
	}
	

}
