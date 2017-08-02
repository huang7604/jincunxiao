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
		setTitle("供应商信息管理");
		JTabbedPane tab=new JTabbedPane();
		JPanel addpane=new SuppleAddpane();
		JPanel delepane=new SuppleModifyandDelete();
		tab.addTab("供应商添加", null, addpane, "添加");
		tab.addTab("供应商修改删除", null, delepane,"修改删除");
		getContentPane().add(tab);
		pack();
		
	}
	

}
