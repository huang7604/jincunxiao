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
		setTitle("客户信息管理");
		setClosable(true);
		setIconifiable(true);
		JTabbedPane tab=new JTabbedPane();
		JPanel addpanel=new CustomerAddpane();
		JPanel delpanel=new CustomerModifyandDeletePanel();
		tab.addTab("客户信息添加",null, addpanel, "客户添加");
		tab.addTab("客户信息修改和删除",null, delpanel, "客户修改");
		getContentPane().add(tab);
		pack();
	}
}
