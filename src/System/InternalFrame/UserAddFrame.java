package System.InternalFrame;
import javax.swing.*;

import java.awt.*;

import javax.swing.table.*;
public class UserAddFrame extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAddFrame()
	{
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(10,10,500,400);
		setTitle("����Ա����");
		JTabbedPane tab=new JTabbedPane();
		tab.addTab("����û�", null, addpanel(), "���");
		tab.addTab("ɾ���û�", null, deletepanel(), "ɾ��");
		add(tab);
		pack();
	}
	private void setupcomponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill,JPanel p1)
	{
		final GridBagConstraints con=new GridBagConstraints();
		con.gridx=gridx;
		con.gridy=gridy;
		con.insets=new Insets(5,5,5,5);
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
		p1.add(component,con);
	}
	private JPanel addpanel()
	{
		JPanel p1=new JPanel();
		p1.setBounds(10,10,500,400);
		p1.setLayout(new GridBagLayout());
		JLabel l1=new JLabel("�û�����");
	    JLabel l2=new JLabel("��¼��");
		JLabel l3=new JLabel("����");
		JLabel l4=new JLabel("ȷ������");
		JTextField name=new JTextField();
		JTextField username=new JTextField();
		JTextField password=new JTextField();
		JTextField surepassword=new JTextField();
		JButton b1=new JButton("���");
		JButton b2=new JButton("��д");
		
		setupcomponent(l1,0,0,1,0,false,p1);
		setupcomponent(name,1,0,1,300,true,p1);
		setupcomponent(l2,0,1,1,0,false,p1);
		setupcomponent(username,1,1,1,300,true,p1);
		setupcomponent(l3,0,2,1,0,false,p1);
		setupcomponent(password,1,2,1,300,true,p1);
		setupcomponent(l4,0,3,1,0,false,p1);
		setupcomponent(surepassword,1,3,1,300,true,p1);
		setupcomponent(b1,0,5,1,0,false,p1);
		setupcomponent(b2,1,5,1,0,false,p1);
	
		
		return p1;
	}
	private JPanel deletepanel()
	{
		JPanel p1=new JPanel();
		p1.setBounds(10,10,500,400);
		p1.setLayout(new GridBagLayout());
		String[] str={"�û�����", "��¼��", "����", "Ȩ��"};
		
		JTextField name=new JTextField();
		JTextField username=new JTextField();
		JTextField password=new JTextField();
		JLabel l1=new JLabel("�û�����");
	    JLabel l2=new JLabel("��¼��");
		JLabel l3=new JLabel("����");
		JButton b1=new JButton("ɾ��");
		JButton b2=new JButton("�ر�");
		JTable table=new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		((DefaultTableModel)table.getModel()).setColumnIdentifiers(str);
		JScrollPane pane=new JScrollPane(table);
		pane.setAutoscrolls(true);
		pane.setPreferredSize(new Dimension(300,200));
		
		setupcomponent(pane,0,0,6,100,true,p1);
		setupcomponent(l1,0,1,1,0,false,p1);
		setupcomponent(name,1,1,1,100,true,p1);
		setupcomponent(l2,2,1,1,0,false,p1);
		setupcomponent(username,3,1,1,100,true,p1);
		setupcomponent(l3,4,1,1,0,false,p1);
		setupcomponent(password,5,1,1,100,true,p1);
		setupcomponent(b1,0,2,1,0,false,p1);
		setupcomponent(b2,1,2,1,0,false,p1);
		
		return p1;
	}
	

}
