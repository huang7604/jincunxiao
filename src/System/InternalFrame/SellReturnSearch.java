package System.InternalFrame;
import javax.swing.*;

import System.guangli.SellReturnSearchpane;


public class SellReturnSearch extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SellReturnSearch()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("�����˻���Ϣ��ѯ");
		JPanel p1=new SellReturnSearchpane();
		add(p1);
		pack();
	}

}