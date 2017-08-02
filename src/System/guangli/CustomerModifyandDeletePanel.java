package System.guangli;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;

import System.datemodel.Customer;
import System.datemodel.Item;
import System.sql.CustomerSql;
public class CustomerModifyandDeletePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField customername;
	private JTextField account;
	private JTextField bankname;
	private JTextField EMail;
	private JTextField phone;
	private JTextField managename;
	private JTextField fax;
	private JTextField managephone;
	private JTextField postid;
	private JTextField address;
	private JTextField shortname;
	private JComboBox<String> combobox;
	private JButton ModifyButton;
	private JButton DeleteButton;
	private Item item=null;
	private List<Item> list=new ArrayList<Item>();
	public CustomerModifyandDeletePanel()
	{
		setBounds(10,10,460,300);
		setVisible(true);
		setLayout(new GridBagLayout());
		JLabel l1=new JLabel("客户全称");
		JLabel l2=new JLabel("客户地址");
		JLabel l3=new JLabel("客户简称");
		JLabel l4=new JLabel("邮政编码");
		JLabel l5=new JLabel("电话");
		JLabel l6=new JLabel("传真");
		JLabel l7=new JLabel("联系人");
		JLabel l8=new JLabel("联系电话");
		JLabel l9=new JLabel("E-Mail");
		JLabel l10=new JLabel("开户银行");
		JLabel l11=new JLabel("银行账户");
		JLabel l12=new JLabel("选择客户");
		customername=new JTextField();
		account=new JTextField();
	    bankname=new JTextField();
		EMail=new JTextField();
		phone=new JTextField();
		managename=new JTextField();
		fax=new JTextField();
		managephone=new JTextField();
		postid=new JTextField();
		address=new JTextField();
		shortname=new JTextField();
		ModifyButton=new JButton("修改");
		ModifyButton.addActionListener(new ModifyListener());
		DeleteButton=new JButton("删除");
		DeleteButton.addActionListener(new DeleteListener());
		ModifyButton.setFocusable(false);
		DeleteButton.setFocusable(false);
		combobox=new JComboBox<String>();
		combobox.addActionListener(new SelectListener());
		customername.setEditable(false);
		combobox.setPreferredSize(new Dimension(230, 21));
		setupComponent(l1,0,0,1,0,false);
		setupComponent(customername,1,0,3,350,true);
		setupComponent(l2,0,1,1,0,false);
		setupComponent(address,1,1,3,350,true);
		setupComponent(l3,0,2,1,0,false);
		setupComponent(shortname,1,2,1,100,true);
		setupComponent(l4,2,2,1,0,false);
		setupComponent(postid,3,2,1,100,true);
		setupComponent(l5,0,3,1,0,false);
		setupComponent(phone,1,3,1,100,true);
		setupComponent(l6,2,3,1,0,false);
		setupComponent(fax,3,3,1,100,true);
		setupComponent(l7,0,4,1,0,false);
		setupComponent(managename,1,4,1,100,true);
		setupComponent(l8,2,4,1,0,false);
		setupComponent(managephone,3,4,1,100,true);
		setupComponent(l9,0,5,1,0,false);
		setupComponent(EMail,1,5,3,350,true);
		setupComponent(fax,3,3,1,100,true);
		setupComponent(l10,0,6,1,0,false);
		setupComponent(bankname,1,6,1,100,true);
		setupComponent(l11,2,6,1,0,false);
		setupComponent(account,3,6,1,100,true);
		setupComponent(l12,0,7,1,0,false);
		setupComponent(combobox,1,7,1,100,true);
		setupComponent(ModifyButton,2,7,1,0,false);
		setupComponent(DeleteButton,3,7,1,0,false);
		initCombobox();
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
	class DeleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int i=new CustomerSql().deleteCustomer(item);
			if(i==1)
			{
				JOptionPane.showMessageDialog(CustomerModifyandDeletePanel.this, "删除成功");
			}
			else
			{
				JOptionPane.showMessageDialog(CustomerModifyandDeletePanel.this, "删除不成功");
			}
			initCombobox();
		}
	}
	class ModifyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(customername.getText().isEmpty()
					||account.getText().isEmpty()
		            ||bankname.getText().isEmpty()
			        ||EMail.getText().isEmpty()
			        ||phone.getText().isEmpty()
			        ||managename.getText().isEmpty()
			        ||fax.getText().isEmpty()
			        ||managephone.getText().isEmpty()
			        ||postid.getText().isEmpty()
			        ||address.getText().isEmpty()
			        ||shortname.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(CustomerModifyandDeletePanel.this, "请填写全部信息");
				return;
			}
			Customer customer=new Customer();
			customer.setName(customername.getText());
			customer.setShorttname(shortname.getText());
			customer.setAddress(address.getText());
			customer.setPhone(phone.getText());
			customer.setEmaild(EMail.getText());
			customer.setFax(fax.getText());
			customer.setPost_id(postid.getText());
			customer.setAccount(account.getText());
			customer.setBank_name(bankname.getText());
			customer.setManagename(managename.getText());
			customer.setManagenamephone(managephone.getText());
			new CustomerSql().UpdateCustomer(customer, item);
		}
	}
	class SelectListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			CustomerSql c=new CustomerSql();
			String str=(String)combobox.getSelectedItem();
			for(Item item:list)
			{
				if(str.equals(item.getName()))
				{
					try
					{
					ResultSet set=c.SelectCustomer("select * from customer where id='"+item.getId()+"';");
					while(set.next())
					{
					customername.setText(set.getString("name"));
					account.setText(set.getString("account"));
				    bankname.setText(set.getString("bank_name"));
					EMail.setText(set.getString("email"));
					phone.setText(set.getString("phone"));
					managename.setText(set.getString("managename"));
					fax.setText(set.getString("fax_id"));
					managephone.setText(set.getString("managenamephone"));
					postid.setText(set.getString("post_id"));
					address.setText(set.getString("address"));
					shortname.setText(set.getString("shortname"));
					}
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
			}
		}
	}
	private void initCombobox()
	{
		ResultSet set=new CustomerSql().SelectCustomer("select id,name from customer");
		list.removeAll(list);
		combobox.removeAllItems();
		try
		{
		while(set.next())
		{
			Item it=new Item();
			it.setId(set.getString("id"));
			it.setName(set.getString("name"));
			list.add(it);
			combobox.addItem(it.getName());
		}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	

}
