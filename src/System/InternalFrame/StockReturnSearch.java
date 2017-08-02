package System.InternalFrame;

import javax.swing.*;

import System.guangli.StockReturnSearchpane;



public class StockReturnSearch extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StockReturnSearch()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("进货退货信息查询");
		JPanel p1=new StockReturnSearchpane();
		add(p1);
		pack();
	}
}