package System.InternalFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import System.guangli.SuppleSearchpane;
public class SuppleSearchFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SuppleSearchFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		JTabbedPane tab=new JTabbedPane();
		JPanel p1=new SuppleSearchpane();
		tab.addTab("��Ӧ�̲�ѯ", null, p1, "��ѯ");
		getContentPane().add(tab);
		pack();
	}
	

}
