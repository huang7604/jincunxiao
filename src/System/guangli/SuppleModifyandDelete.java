package System.guangli;
import javax.swing.*;

import System.datemodel.Item;
import System.datemodel.Suppleman;
import System.sql.SuppleSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
public class SuppleModifyandDelete extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField supplename;
	private JTextField address;
	private JTextField shortname;
	private JTextField postid;
	private JTextField phone;
	private JTextField fax;
	private JTextField managename;
	private JTextField managephone;
	private JTextField bankname;
	private JTextField Email;
	private JButton modifybutton;
	private JButton deletebutton;
	private JComboBox<String> combobox;
	private HashMap<String,Item> map=new HashMap<String,Item>();
	public SuppleModifyandDelete()
	{
		setBounds(100,100,600,400);
		setVisible(true);
		setLayout(new GridBagLayout());
		supplename=new JTextField();
		address=new JTextField();
		shortname=new JTextField();
		postid=new JTextField();
		phone=new JTextField();
		fax=new JTextField();
		managename=new JTextField();
		managephone=new JTextField();
		bankname=new JTextField();
		Email=new JTextField();
		modifybutton=new JButton("修改");
		modifybutton.addActionListener(new ModifyListener());
		deletebutton=new JButton("删除");
		deletebutton.addActionListener(new DeleteListener());
	    combobox=new JComboBox<String>();
	    combobox.setPreferredSize(new Dimension(230,30));
	    combobox.addActionListener(new ComboBoxListener());
		supplename.setEditable(false);
		JLabel l1=new JLabel("供应商全称");
		JLabel l2=new JLabel("地址");
		JLabel l3=new JLabel("简称");
		JLabel l4=new JLabel("邮政编码");
		JLabel l5=new JLabel("电话");
		JLabel l6=new JLabel("传真");
		JLabel l7=new JLabel("联系人");
		JLabel l8=new JLabel("联系人电话");
		JLabel l9=new JLabel("开户银行");
		JLabel l10=new JLabel("E-Mail");
		JLabel l11=new JLabel("选择供应商");
		modifybutton.setFocusable(false);
		deletebutton.setFocusable(false);
		setupcomponent(l1,0,0,1,0,false);
		setupcomponent(supplename,1,0,3,380,true);
		setupcomponent(l2,0,1,1,0,false);
		setupcomponent(address,1,1,3,380,true);
		setupcomponent(l3,0,2,1,0,false);
		setupcomponent(shortname,1,2,1,110,true);
		setupcomponent(l4,2,2,1,0,false);
		setupcomponent(postid,3,2,1,110,true);
		setupcomponent(l5,0,3,1,0,false);
		setupcomponent(phone,1,3,1,110,true);
		setupcomponent(l6,2,3,1,0,false);
		setupcomponent(fax,3,3,1,110,true);
		setupcomponent(l7,0,4,1,0,false);
		setupcomponent(managename,1,4,1,110,true);
		setupcomponent(l8,2,4,1,0,false);
		setupcomponent(managephone,3,4,1,110,true);
		setupcomponent(l9,0,5,1,0,false);
		setupcomponent(bankname,1,5,1,110,true);
		setupcomponent(l10,2,5,1,0,false);
		setupcomponent(Email,3,5,1,110,true);
		setupcomponent(l11,0,6,1,0,false);
		setupcomponent(combobox,1,6,2,0,true);
		JPanel p1=new JPanel();
		p1.add(modifybutton);
		p1.add(deletebutton);
		setupcomponent(p1,3,6,1,0,false);
		initcombobox();
	}
	public void setupcomponent(JComponent component,int gridx,int gridy,int gridwidth,int idapx,boolean fill)
	{
		final GridBagConstraints con=new GridBagConstraints();
		con.gridx=gridx;
		con.gridy=gridy;
		con.insets=new Insets(5,1,3,1);
		if(gridwidth>1)
		{
			con.gridwidth=gridwidth;
		}
		if(idapx>0)
		{
			con.ipadx=idapx;
		}
		if(fill)
		{
			con.fill=GridBagConstraints.HORIZONTAL;
		}
		add(component,con);
	}
	class DeleteListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Item item=map.get(supplename.getText());
			int i=new SuppleSql().deleteSupple(item);
			if(i==0)
			{
				JOptionPane.showMessageDialog(SuppleModifyandDelete.this, "删除不成功");
			}
			else
			{
				String str=item.getName();
				map.remove(str);
				combobox.removeItem(str);
				JOptionPane.showMessageDialog(SuppleModifyandDelete.this, "删除成功");
			}
			
		}
		
	}
	class ModifyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Suppleman supple=new Suppleman();
			String id=map.get(supplename.getText()).getId();
			supple.setId(id);
			supple.setName(supplename.getText());
			supple.setShorttname(shortname.getText());
			supple.setAddress(address.getText());
			supple.setPost_id(postid.getText());
			supple.setPhone(phone.getText());
			supple.setFax(fax.getText());
			supple.setManagename(managename.getText());
			supple.setManagenamephone(managephone.getText());
			supple.setEmaild(Email.getText());
			supple.setBank_name(bankname.getText());
			int i=new SuppleSql().updateSupple(supple, map.get(supplename.getText()));
			if(i==0)
			{
				JOptionPane.showMessageDialog(SuppleModifyandDelete.this, "修改不成功");
			}
			else
			{
				JOptionPane.showMessageDialog(SuppleModifyandDelete.this, "修改成功");
			}
		}
	}
	class ComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str=(String)combobox.getSelectedItem();
			if(map.containsKey(str))
			{
				Item item=map.get(str);
				ResultSet set=new SuppleSql().SelectSupple("select * from supple where id='"+item.getId()+"';");
				try
				{
					while(set.next())
					{
						supplename.setText(set.getString("name"));
					    bankname.setText(set.getString("bank_name"));
						Email.setText(set.getString("email"));
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
	private void initcombobox()
	{
		String sql="select id,name from supple;";
		ResultSet set=new SuppleSql().SelectSupple(sql);
		String str=null;
		try
		{
			while(set.next())
			{
				Item item=new Item();
				item.setId(set.getString("id"));
				str=set.getString("name");
				item.setName(str);
				map.put(str, item);
				combobox.addItem(str);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	public String str()
	{
		return map.toString();
	}
	

}
