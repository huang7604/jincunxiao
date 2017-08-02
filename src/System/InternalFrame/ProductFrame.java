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
		tab.addTab("产品添加", null, p1, "添加");
		tab.addTab("产品删除修改", null, p2, "删除修改");
	    getContentPane().add(tab);
	    pack();
	}
	

}
