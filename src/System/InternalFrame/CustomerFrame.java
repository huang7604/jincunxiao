package System.InternalFrame;
import javax.swing.*;

import System.guangli.*;
public class CustomerFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerFrame()
	{
		setVisible(true);
		setTitle("�ͻ���Ϣ����");
		setClosable(true);
		setIconifiable(true);
		JTabbedPane tab=new JTabbedPane();
		JPanel addpanel=new CustomerAddpane();
		JPanel delpanel=new CustomerModifyandDeletePanel();
		tab.addTab("�ͻ���Ϣ���",null, addpanel, "�ͻ����");
		tab.addTab("�ͻ���Ϣ�޸ĺ�ɾ��",null, delpanel, "�ͻ��޸�");
		getContentPane().add(tab);
		pack();
	}
}
