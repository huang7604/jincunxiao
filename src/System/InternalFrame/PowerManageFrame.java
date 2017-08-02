package System.InternalFrame;
import javax.swing.*;

import java.awt.*;
public class PowerManageFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1=new JLabel("�û�����");
	private JLabel l2=new JLabel("��¼��");
	private JLabel l3=new JLabel("����");
	private JLabel l4=new JLabel("Ȩ��");
	private JLabel l5=new JLabel("ѡ���û�");
	private JTextField name=new JTextField();
	private JTextField username=new JTextField();
	private JTextField password=new JTextField();
	private JComboBox<String> power=new JComboBox<String>();
	private JComboBox<String> select=new JComboBox<String>();
	private JButton b1=new JButton("�޸�");
	private JButton b2=new JButton("�ر�");
	public PowerManageFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(10,10,600,500);
		setTitle("Ȩ�޹���");
		setLayout(new GridBagLayout());
	
		
		name.setEditable(false);
		username.setEditable(false);
		password.setEditable(false);
		power.setPreferredSize(new Dimension(100,20));
		power.addItem("����Ա");
		power.addItem("����Ա");
		select.setPreferredSize(new Dimension(100,20));
		
		setupcomponent(new JLabel(),0,0,1,0,false);
		setupcomponent(l1,0,1,1,0,false);
		setupcomponent(name,1,1,1,100,true);
		setupcomponent(l2,2,1,1,0,false);
		setupcomponent(username,3,1,1,100,true);
		setupcomponent(l3,0,2,1,0,false);
		setupcomponent(password,1,2,1,100,true);
		setupcomponent(l4,2,2,1,0,false);
		setupcomponent(power,3,2,1,100,true);
		setupcomponent(l5,0,3,1,0,false);
		setupcomponent(select,1,3,1,100,true);
		setupcomponent(b1,1,4,1,0,false);
		setupcomponent(b2,3,4,1,0,false);
		
		pack();
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
