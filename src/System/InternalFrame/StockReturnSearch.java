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
		setTitle("�����˻���Ϣ��ѯ");
		JPanel p1=new StockReturnSearchpane();
		add(p1);
		pack();
	}
}