package System.guangli;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


import System.datemodel.Suppleman;
import System.sql.SuppleSql;
public class SuppleAddpane extends JPanel{

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
	private JButton savebutton;
	private JButton resetbutton;
	public SuppleAddpane()
	{
		setBounds(100,100,460,300);
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
		savebutton=new JButton("保存");
		savebutton.addActionListener(new SaveListener());
		resetbutton=new JButton("重置");
		resetbutton.addActionListener(new ResetListener());
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
		savebutton.setFocusable(false);
		resetbutton.setFocusable(false);
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
		setupcomponent(savebutton,1,6,1,0,false);
		setupcomponent(resetbutton,3,6,1,0,false);
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
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			supplename.setText("");
		    bankname.setText("");
			Email.setText("");
			phone.setText("");
			managename.setText("");
			fax.setText("");
			managephone.setText("");
			postid.setText("");
			address.setText("");
			shortname.setText("");
		}
	}
	class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			SuppleSql sq=new SuppleSql();
			if(supplename.getText().isEmpty()
			        ||Email.getText().isEmpty()
			        ||phone.getText().isEmpty()
			        ||managename.getText().isEmpty()
			        ||fax.getText().isEmpty()
			        ||managephone.getText().isEmpty()
			        ||postid.getText().isEmpty()
			        ||address.getText().isEmpty()
			        ||shortname.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(SuppleAddpane.this, "请填写全部信息");
				return;
			}
			String name=supplename.getText();
			ResultSet set=sq.SelectSupple("select name from supple;");
			try
			{
				while(set!=null&&set.next())
				{
					if(name.equals(set.getString("name")))
					{
						JOptionPane.showMessageDialog(SuppleAddpane.this, "供应商信息已经存在");
						return;
					}
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			
			ResultSet set1=sq.SelectSupple("select max(id) from supple;");
			String id=null;
			try
			{
				while(set1.next())
				{
					id=set1.getString(1);
				}
			}
			catch(SQLException e2)
			{
				e2.printStackTrace();
			}
			if(id!=null)
			{
				String num=id.substring(3);
				Integer i=(Integer.parseInt(num)+1);
				if(i<10)
				{
					id="cys000"+i;
				}
				else if(i<100)
				{
					id="cys00"+i;
				}
				else if(i<1000)
				{
					id="cys0"+i;
				}
				else
				{
					id="cys"+i;
				}
			}
			else
			{
				id="cys0001";
			}
			Suppleman supple=new Suppleman();
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
			int i=sq.insertSupple(supple);
			if(i==0)
			{
				JOptionPane.showMessageDialog(SuppleAddpane.this, "保存不成功");
			}
			else
			{
				JOptionPane.showMessageDialog(SuppleAddpane.this, "保存成功");
			}
			
		}
	}
}
		