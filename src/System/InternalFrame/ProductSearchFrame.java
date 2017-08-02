package System.InternalFrame;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import System.guangli.ProdctSearchpane;
public class ProductSearchFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductSearchFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new ProdctSearchpane();
		tab.addTab("产品查询", null, p1, "查询");
		getContentPane().add(tab);
		pack();
	}
	

}