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
		tab.addTab("��Ʒ��ѯ", null, p1, "��ѯ");
		getContentPane().add(tab);
		pack();
	}
	

}