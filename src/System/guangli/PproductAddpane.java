package System.guangli;
import javax.swing.*;

import System.datemodel.Product;
import System.sql.ProductSql;
import System.sql.SuppleSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PproductAddpane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField productname;
	private JTextField shortname;
	private JTextField address;
	private JTextField unit;
	private JTextField standard;
	private JTextField packing;
	private JTextField number;
	private JTextField promission_id;
	private JComboBox<String> supple;
	private JTextField instodution;
	private JButton savebutton;
	private JButton resetbutton;
	public PproductAddpane()
	{
		setBounds(10,10,460,330);
		setVisible(true);
		setLayout(new GridBagLayout());
		JLabel l1=new JLabel("产品名称");
		JLabel l2=new JLabel("产品简称");
		JLabel l3=new JLabel("产品生产地址");
		JLabel l4=new JLabel("单位");
		JLabel l5=new JLabel("规格");
		JLabel l6=new JLabel("包装");
		JLabel l7=new JLabel("批号");
		JLabel l8=new JLabel("批准文号");
		JLabel l9=new JLabel("供应商");
		JLabel l10=new JLabel("简介");
		productname=new JTextField();
		shortname=new JTextField();
		address=new JTextField();
		unit=new JTextField();
		standard=new JTextField();
		packing=new JTextField();
		number=new JTextField();
		promission_id=new JTextField();
		instodution=new JTextField();
		supple=new JComboBox<String>();
		supple.setPreferredSize(new Dimension(220,30));
		savebutton=new JButton("保存");
		savebutton.addActionListener(new SaveListener());
		resetbutton=new JButton("重置");
		resetbutton.addActionListener(new ResetListener());
		setupComponent(l1,0,0,1,0,false);
		setupComponent(productname,1,0,3,280,true);
		setupComponent(l2,0,1,1,0,false);
		setupComponent(shortname,1,1,3,280,true);
		setupComponent(l3,0,2,1,0,false);
		setupComponent(address,1,2,3,280,true);
		setupComponent(l4,0,3,1,0,false);
		setupComponent(unit,1,3,1,100,true);
		setupComponent(l5,2,3,1,0,false);
		setupComponent(standard,3,3,1,100,true);
		setupComponent(l6,0,4,1,0,false);
		setupComponent(packing,1,4,1,100,true);
		setupComponent(l7,2,4,1,0,false);
		setupComponent(number,3,4,1,100,true);
		setupComponent(l8,0,5,1,0,false);
		setupComponent(promission_id,1,5,3,330,true);
		setupComponent(l9,0,6,1,0,false);
		setupComponent(supple,1,6,3,280,true);
		setupComponent(l10,0,7,1,0,false);
		setupComponent(instodution,1,7,3,280,true);
		JPanel p=new JPanel();
		p.add(savebutton);
		p.add(resetbutton);
		setupComponent(p,4,7,1,0,false);
		initSupple();
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
			productname.setText("");
			shortname.setText("");
			address.setText("");
			unit.setText("");;
			standard.setText("");
			packing.setText("");
			number.setText("");
			promission_id.setText("");
			instodution.setText("");
		}
	}
	class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ProductSql ps=new ProductSql();
			if(productname.getText().isEmpty()||
			shortname.getText().isEmpty()||
			address.getText().isEmpty()||
			unit.getText().isEmpty()||
			standard.getText().isEmpty()||
			packing.getText().isEmpty()||
			number.getText().isEmpty()||
			promission_id.getText().isEmpty()||
			instodution.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(PproductAddpane.this, "信息不能为空");
				return ;
			}
			String sql="select name from product where name='"+productname.getText()+"';";
			ResultSet set=ps.SelectProduct(sql);
			try
			{
				if(set.next())
				{
					JOptionPane.showMessageDialog(PproductAddpane.this, "商品已存在！");
					return ;
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			ResultSet set1=ps.SelectProduct("select max(id) from product;");
			String id=null;
			try
			{
				while(set1.next())
				id=set1.getString(1);
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
				
				if(id!=null)
				{
					String num=id.substring(2);
					int i=(Integer.parseInt(num)+1);
					if(i<10)
					{
						id="sp000"+i;
					}
					else if(i<100)
					{
						id="sp00"+i;
					}
					else if(i<1000)
					{
						id="sp0"+i;
					}
					else
					{
						id="sp"+i;
					}
				}
				else
				{
					id="sp0001";
				}
			
			Product product=new Product(id,productname.getText(),
					shortname.getText(),
					address.getText(),
					unit.getText(),
					(String)supple.getSelectedItem(),
					instodution.getText(),
					promission_id.getText(),
					number.getText(),
					standard.getText(),
					packing.getText());
			int i=ps.insertProduct(product);
			if(i!=0)
			{
				JOptionPane.showMessageDialog(PproductAddpane.this, "保存成功");
			}
			else
			{
				JOptionPane.showMessageDialog(PproductAddpane.this, "保存不成功");
			}
			
		}
	}
	private void initSupple()
	{
		String sql="select name from supple;";
		ResultSet set=new SuppleSql().SelectSupple(sql);
		String str=null;
		try
		{
			while(set.next())
			{
				str=set.getString("name");
				supple.addItem(str);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
	

}
