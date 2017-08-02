package System.InternalFrame;
import javax.swing.*;

import java.awt.*;
public class SetPasswordFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1=new JLabel("用户姓名");
	private JLabel l2=new JLabel("登录名");
	private JLabel l3=new JLabel("旧密码");
	private JLabel l4=new JLabel("新密码");
	private JLabel l5=new JLabel("确认新密码");
	private JTextField oldpassword=new JTextField();
	private JTextField newpassword=new JTextField();
	private JTextField surepassword=new JTextField();
	private JButton b1=new JButton("确认");
	private JButton b2=new JButton("重写");
	public SetPasswordFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(10,10,400,300);
		setTitle("更改密码");
		setLayout(new GridBagLayout());
		
		setupcomponent(l1,0,0,1,0,false);
		setupcomponent(l2,0,1,1,0,false);
		setupcomponent(l3,0,2,1,0,false);
		setupcomponent(oldpassword,1,2,1,200,true);
		setupcomponent(l4,0,3,1,0,false);
		setupcomponent(newpassword,1,3,1,200,true);
		setupcomponent(l5,0,4,1,0,false);
		setupcomponent(surepassword,1,4,1,200,true);
		setupcomponent(b1,0,5,1,0,false);
		setupcomponent(b2,1,5,1,0,false);
	}
	private void setupcomponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		final GridBagConstraints con=new GridBagConstraints();
		con.gridx=gridx;
		con.gridy=gridy;
		con.insets=new Insets(1,1,0,3);
		if(gridwidth>0)
		{
			con.gridwidth=gridwidth;
		}
		if(ipadx>0)
		{
			con.ipadx=ipadx;
		}
		if(fill)
		{
			con.fill=GridBagConstraints.HORIZONTAL;
		}
		add(component,con);
	}
	
	

}
