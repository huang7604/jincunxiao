package System.guangli;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import System.datemodel.Customer;
import System.sql.CustomerSql;
public class CustomerAddpane extends JPanel {

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
	private JButton saveButton;
	private JButton resetButton;
	public CustomerAddpane()
	{
		setBounds(10,10,460,300);
		setVisible(true);
		setLayout(new GridBagLayout());
		JLabel l1=new JLabel("�ͻ�ȫ��");
		JLabel l2=new JLabel("�ͻ���ַ");
		JLabel l3=new JLabel("�ͻ����");
		JLabel l4=new JLabel("��������");
		JLabel l5=new JLabel("�绰");
		JLabel l6=new JLabel("����");
		JLabel l7=new JLabel("��ϵ��");
		JLabel l8=new JLabel("��ϵ�绰");
		JLabel l9=new JLabel("E-Mail");
		JLabel l10=new JLabel("��������");
		JLabel l11=new JLabel("�����˻�");
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
		saveButton=new JButton("����");
		saveButton.addActionListener(new AddListener());
		resetButton=new JButton("����");
		resetButton.addActionListener(new ResetListener());
		saveButton.setFocusable(false);
		resetButton.setFocusable(false);
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
		setupComponent(saveButton,1,7,1,0,false);
		setupComponent(resetButton,3,7,1,0,false);
		
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
	
    class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			customername.setText("");
			account.setText("");
		    bankname.setText("");
			EMail.setText("");
			phone.setText("");
			managename.setText("");
			fax.setText("");
			managephone.setText("");
			postid.setText("");
			address.setText("");
			shortname.setText("");
		}
		
	}
class AddListener implements ActionListener
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
			JOptionPane.showMessageDialog(CustomerAddpane.this, "����дȫ����Ϣ");
			return;
		}
		try
		{
			Customer customer=new Customer();
			CustomerSql cs=new CustomerSql();
			ResultSet set=cs.SelectCustomer("select name from customer where name='"+customername.getText()+"';");
					if(set.next())
					{
						JOptionPane.showMessageDialog(CustomerAddpane.this, "�ͻ��Ѵ���...");
						return;
					}
			ResultSet set1=cs.SelectCustomer("select max(id) from customer;");
			String id=null;
			if(set1!=null&&set1.next())
			{
				id=set1.getString(1);
			}
			if(id==null)
			{
				id="kh0001";
			}
			else
			{
				String num=id.substring(2);
				Integer i=(Integer.parseInt(num)+1);
				if(i<10)
				{
					id="kh000"+i;
				}
				else if(i<100)
				{
					id="kh00"+i;
				}
				else if(i<1000)
				{
					id="ku0"+i;
				}
				else 
				{
					id="ku"+i;
				}
			}
			customer.setId(id);
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
			int i=cs.insertCustomer(customer);
			if(i==1)
			{
				JOptionPane.showMessageDialog(CustomerAddpane.this, "����ɹ�");
			}
			else
			{
				JOptionPane.showMessageDialog(CustomerAddpane.this, "���治�ɹ�");
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
	}
}
		

}
