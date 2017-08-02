package System.guangli;
import javax.swing.*;

import System.datemodel.Item;
import System.datemodel.Product;
import System.sql.ProductSql;
import System.sql.SuppleSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
public class ProductModifyandDelete extends  JPanel{

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
	private JTextField supple1;
	private JTextField instodution;
	private JButton modifybutton;
	private JButton deletebutton;
	private JComboBox<String> combobox;
	private HashMap<String,Item> map=new HashMap<String,Item>();
	public ProductModifyandDelete()
	{
		setVisible(true);
		setBounds(10,10,460,330);
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
		JLabel l11=new JLabel("选择商品");
		JLabel l12=new JLabel("供应商");
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
		supple.addActionListener(new SuppleListener());
		supple1=new JTextField();
		supple1.setEditable(false);
		combobox=new JComboBox<String>();
		combobox.addActionListener(new ComboBoxListener());
		combobox.setPreferredSize(new Dimension(120,30));
		supple.setPreferredSize(new Dimension(220,30));
		modifybutton=new JButton("修改");
		modifybutton.addActionListener(new ModifyListener());
		deletebutton=new JButton("删除");
		deletebutton.addActionListener(new DeleteListener());
		setupComponent(l1,0,0,1,0,false);
		setupComponent(productname,1,0,3,280,true);
		setupComponent(l2,0,1,1,0,false);
		setupComponent(shortname,1,1,3,350,true);
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
		setupComponent(promission_id,1,5,3,280,true);
		setupComponent(l9,0,6,1,0,false);
		setupComponent(supple,1,6,2,180,true);
		setupComponent(l12,3,6,1,0,false);
		setupComponent(supple1,4,6,2,100,true);
		setupComponent(l10,0,7,1,0,false);
		setupComponent(instodution,1,7,3,280,true);
		JPanel p1=new JPanel();
		p1.add(modifybutton);
		p1.add(deletebutton);
		setupComponent(l11,0,8,1,0,false);
		setupComponent(combobox,1,8,2,100,true);
		setupComponent(p1,3,8,1,0,false);
		initSupple();
		initComboBox();
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
			Item item=map.get(productname.getText());
			int i=new ProductSql().deleteProduct(item);
			if(i==0)
			{
				JOptionPane.showMessageDialog(ProductModifyandDelete.this, "删除不成功");
			}
			else
			{
				JOptionPane.showMessageDialog(ProductModifyandDelete.this, "删除成功");
				combobox.removeItem(item.getName());
				map.remove(item.getName());
			}
		}
	}
	class ModifyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Item item=map.get(productname.getText());
			String id=item.getId();
			Product product=new Product(id,productname.getText(),
					shortname.getText(),
					address.getText(),
					unit.getText(),
					supple1.getText(),
					instodution.getText(),
					promission_id.getText(),
					number.getText(),
					standard.getText(),
					packing.getText());
			int i=new ProductSql().updateProduct(product, item);
			if(i==0)
			{
				JOptionPane.showMessageDialog(ProductModifyandDelete.this, "修改不成功");
			}
			else
			{
				JOptionPane.showMessageDialog(ProductModifyandDelete.this, "修改成功");
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
				ResultSet set=new ProductSql().SelectProduct("select * from product where id='"+item.getId()+"';");
				try
				{
					while(set.next())
					{
						productname.setText(set.getString("name"));
						shortname.setText(set.getString("shortname"));
						address.setText(set.getString("productaddress"));
						unit.setText(set.getString("unit"));;
						standard.setText(set.getString("standard"));
						packing.setText(set.getString("packing"));
						number.setText(set.getString("number"));
						instodution.setText(set.getString("introdution"));
						supple1.setText(set.getString("supple"));
						promission_id.setText(set.getString("promission_id"));
					}
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
	class SuppleListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str=(String)supple.getSelectedItem();
			if(!str.equals(supple1.getText()))
			{
				supple1.setText(str);
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
	private void initComboBox()
	{
		String sql="select id,name from product;";
		ResultSet set=new ProductSql().SelectProduct(sql);
		String str=null;
		try
		{
			while(set.next())
			{
				str=set.getString("name");
				combobox.addItem(str);
				Item item=new Item();
				item.setId(set.getString("id"));
				item.setName(str);
				map.put(str, item);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
}
