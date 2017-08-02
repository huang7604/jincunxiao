package System.InternalFrame;

import javax.swing.*;

import System.guangli.Storagepane;
public class StorageFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StorageFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("库存盘点");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new Storagepane();
		tab.addTab("价格调整", null, p1, "调整");
	    getContentPane().add(tab);
	    pack();
	}
	

}
