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
		setTitle("����̵�");
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new Storagepane();
		tab.addTab("�۸����", null, p1, "����");
	    getContentPane().add(tab);
	    pack();
	}
	

}
