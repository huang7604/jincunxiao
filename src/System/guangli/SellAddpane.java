package System.guangli;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;









import System.datemodel.Customer;
import System.datemodel.Item;
import System.sql.CustomerSql;
import System.sql.ProductSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
public class SellAddpane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField sellid;
	private JTextField varietynumber;
	private JTextField money;
	private JTextField conclusion;
	private JComboBox<String> customername;
	private JTextField selltime;
	private JTextField manage;
	private JTextField brokerage;
	private JComboBox<String> accountmethod;
	private JTextField customermanage;
	private JTextField productnumber;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox<String> productcom;
	private List<Customer> list=new ArrayList<Customer>();
	private HashMap<String,Item> map=new HashMap<String,Item>();
	public SellAddpane()
	{
		setVisible(true);
		setBounds(10,10,700,450);
		setLayout(new GridBagLayout());
		sellid=new JTextField();
		varietynumber=new JTextField();
		money=new JTextField();
		conclusion=new JTextField();
		customername=new JComboBox<String>();
		selltime=new JTextField();
		manage=new JTextField();
		brokerage=new JTextField();
		customermanage=new JTextField();
		accountmethod=new JComboBox<String>();
		accountmethod.setPreferredSize(new Dimension(100,20));
		accountmethod.addItem("现金");
		accountmethod.addItem("支票");
		accountmethod.addItem("网上银行转账");
		model=new DefaultTableModel();
		table=new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane js=new JScrollPane(table);
		js.setAutoscrolls(true);
		js.setPreferredSize(new Dimension(100,300));
		productnumber=new JTextField();
		productcom=new JComboBox<String>();
		JLabel l1=new JLabel("销售单");
		JLabel l2=new JLabel("客户");
		JLabel l3=new JLabel("客户联系人");
		JLabel l4=new JLabel("结算方式");
		JLabel l5=new JLabel("销售时间");
		JLabel l6=new JLabel("经手人");
		JLabel l7=new JLabel("品种数量");
		JLabel l8=new JLabel("货物总数");
		JLabel l9=new JLabel("合计金额");
		JLabel l10=new JLabel("验收结论");
		JLabel l11=new JLabel("操作人员");
		setupcomponent(l1,0,0,1,0,false);
		setupcomponent(sellid,1,0,1,110,true);
		setupcomponent(l2,2,0,1,0,false);
		setupcomponent(customername,3,0,1,50,true);
		setupcomponent(l3,4,0,1,0,false);
		setupcomponent(customermanage,5,0,1,100,true);
		setupcomponent(l4,0,1,1,0,false);
		setupcomponent(accountmethod,1,1,1,50,true);
		setupcomponent(l5,2,1,1,0,false);
		setupcomponent(selltime,3,1,1,50,true);
		setupcomponent(l6,4,1,1,0,false);
		setupcomponent(brokerage,5,1,1,100,true);
		setupcomponent(js,0,2,6,1,true);
		setupcomponent(l7,0,3,1,0,false);
		setupcomponent(varietynumber,1,3,1,50,true);
		setupcomponent(l8,2,3,1,0,false);
		setupcomponent(productnumber,3,3,1,50,true);
		setupcomponent(l9,4,3,1,0,false);
		setupcomponent(money,5,3,1,100,true);
		setupcomponent(l10,0,4,1,0,false);
		setupcomponent(conclusion,1,4,1,50,true);
		setupcomponent(l11,2,4,1,0,false);
		setupcomponent(manage,3,4,1,50,true);
		JPanel p1=new JPanel();
		JButton b1=new JButton("添加");
		b1.addActionListener(new AddListener());
		JButton b2=new JButton("保存");
		p1.add(b1);
		p1.add(b2);
		setupcomponent(p1,4,4,1,0,true);
		productcom.addActionListener(new ProductcomListener());
		initcustomer();
		updateTable();
		inittable();
		
	}
	public void setupcomponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		final GridBagConstraints con=new GridBagConstraints();
		con.gridx=gridx;
		con.gridy=gridy;
	    con.insets=new Insets(5,1,3,1);
	    if(gridwidth>1)
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
	private void inittable()
	{
		String[] colunmname={"商品名称", "商品编号", "供应商", "产地", "单位", "规格", "单价",
				"数量", "包装", "批号", "批准文号"};
		((DefaultTableModel)table.getModel()).setColumnIdentifiers(colunmname);
		TableColumn column=table.getColumnModel().getColumn(0);
		DefaultCellEditor cell=new DefaultCellEditor(productcom);
		cell.setClickCountToStart(1);
		column.setCellEditor(cell);
	}
	class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.addRow(new Vector<String>());
		}
	}
	class ProductcomListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String key=(String)productcom.getSelectedItem();
			int row = table.getSelectedRow();
			if(map.containsKey(key))
			{
				Item item=map.get(key);
				ResultSet set=new ProductSql().SelectProduct("select * from product where id='"+item.getId()+"';");
				 try
				    {
				    	while(set!=null&&set.next())
				    	{
							table.setValueAt(set.getString("id"), row, 1);
							table.setValueAt(set.getString("supple"), row, 2);
							table.setValueAt(set.getString("productaddress"), row, 3);
							table.setValueAt(set.getString("unit"), row, 4);
							table.setValueAt(set.getString("standard"), row, 5);
							table.setValueAt("", row, 6);
							table.setValueAt("", row, 7);
							table.setValueAt(set.getString("packing"), row, 8);
							table.setValueAt(set.getString("number"), row, 9);
							table.setValueAt(set.getString("promission_id"), row, 10);
							
				    	}
				    }
				 catch(SQLException e1)
				    {
				    	e1.printStackTrace();
				    }
			}
		}
	}
	private void initcustomer()
	{
		ResultSet set=new CustomerSql().SelectCustomer("select * from customer;");
		String id1=null;
		String name1=null;
		String managename1=null;
		try{
			while(set!=null&&set.next())
			{
				id1=set.getString("id");
				name1=set.getString("name");
				managename1=set.getString("managename");
				Customer customer=new Customer();
				customer.setId(id1);
				customer.setName(name1);
				customer.setManagename(managename1);
				customername.addItem(name1);
				list.add(customer);
			}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	
	}
	private synchronized void updateTable() 
	{
		ResultSet set=new ProductSql().SelectProduct("select id,name from product;");
	    try
	    {
	    	while(set!=null&&set.next())
	    	{
	    		Item item=new Item();
	    		String str=set.getString("name");
	    		item.setId(set.getString("id"));
	    		item.setName(str);
	    		productcom.addItem(str);
	    		map.put(str, item);
	    		
	    	}
	    }
	    catch(SQLException e1)
	    {
	    	e1.printStackTrace();
	    }
	}
}


