package System.guangli;
import javax.swing.*;

import java.awt.*;

import javax.swing.table.*;
public class SuppleSearchpane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel l1=new JLabel("查询条件");
	private JComboBox<String> name=new JComboBox<String>();
	private JComboBox<String> mothed=new JComboBox<String>();
	private JTextField search=new JTextField();
	private JButton searchbutton=new JButton("查询");
	private JButton output=new JButton("显示数据");
	private JTable table=new JTable();
	public SuppleSearchpane()
	{
		setBounds(100,100,460,300);
		setVisible(true);
		setLayout(new GridBagLayout());
		
		name.setPreferredSize(new Dimension(110,10));
		name.addItem("供应商全称");
		name.addItem("供应商简称");
		mothed.setPreferredSize(new Dimension(110,10));
		mothed.addItem("等    于");
		mothed.addItem("包     含");
		
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		initable();
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setAutoscrolls(true);
		
		
		setupComponent(l1,0,0,1,0,false);
		setupComponent(name,1,0,1,30,true);
		setupComponent(mothed,2,0,1,30,true);
		setupComponent(search,3,0,1,150,true);
		setupComponent(searchbutton,4,0,1,0,false);
		setupComponent(output,5,0,1,0,false);
		
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridwidth = 6;
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 0;
		gridBagConstraints_6.weighty = 1.0;
		gridBagConstraints_6.insets = new Insets(0, 1, 5, 10);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;
		
		add(scrollpane,gridBagConstraints_6);
		
	}
	private void initable()
	{
		String[] name=new String[]{"供应商ID", "供应商全称", "简称", "邮政编码",
				"地址", "电话", "传真", "联系人", "联系人电话", "开户银行", "电子信箱"};
		((DefaultTableModel)table.getModel()).setColumnIdentifiers(name);
	}
	public  void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		final GridBagConstraints gridbagconstraints=new GridBagConstraints();
		gridbagconstraints.gridx=gridx;
		gridbagconstraints.gridy=gridy;
		gridbagconstraints.insets=new Insets(5,1,3,1);
		if(gridwidth>1)
		{
			gridbagconstraints.gridwidth=gridwidth;
		}
		if(ipadx>0)
		{
			gridbagconstraints.ipadx=ipadx;
		}
		if(fill)
		{
			gridbagconstraints.fill=GridBagConstraints.HORIZONTAL;
		}
		add(component,gridbagconstraints);
	}
	
	

}
