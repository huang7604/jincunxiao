package System.InternalFrame;
import javax.swing.*;
import System.guangli.*;
public class SuppleFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SuppleFrame()
	{
		setClosable(true);
		setVisible(true);
		setIconifiable(true);
		setTitle("��Ӧ����Ϣ����");
		JTabbedPane tab=new JTabbedPane();
		JPanel addpane=new SuppleAddpane();
		JPanel delepane=new SuppleModifyandDelete();
		tab.addTab("��Ӧ�����", null, addpane, "���");
		tab.addTab("��Ӧ���޸�ɾ��", null, delepane,"�޸�ɾ��");
		getContentPane().add(tab);
		pack();
		
	}
	

}
