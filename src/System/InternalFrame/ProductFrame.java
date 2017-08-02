package System.InternalFrame;
import javax.swing.*;

import System.guangli.PproductAddpane;
import System.guangli.ProductModifyandDelete;
public class ProductFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new PproductAddpane();
		JPanel p2=new ProductModifyandDelete();
		tab.addTab("��Ʒ���", null, p1, "���");
		tab.addTab("��Ʒɾ���޸�", null, p2, "ɾ���޸�");
	    getContentPane().add(tab);
	    pack();
	}
	

}
