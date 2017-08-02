package System.InternalFrame;
import javax.swing.*;

import System.guangli.CustomerSearchpane;
public class CustomerSearchFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerSearchFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("¿Í»§²éÑ¯");
		JPanel p1=new CustomerSearchpane();
		add(p1);
		pack();
	}
	

}
