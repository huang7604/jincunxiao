package System.guangli;
import javax.swing.*;

import java.awt.*;
public class PriceChange extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> productname;
	private JTextField price;
	private JTextField storagenumber;
	private JTextField money;
	private JLabel standard;
	private JLabel address;
	private JLabel shortname;
	private JLabel packing;
	private JLabel unit;
	private JButton b1; 
	private JButton b2;
	public PriceChange()
	{
		setVisible(true);
		setBounds(50,50,500,350);
		setLayout(new GridBagLayout());
		productname=new JComboBox<String>();
		productname.setPreferredSize(new Dimension(200,20));
		price=new JTextField();
		storagenumber=new JTextField();
		storagenumber.setEditable(false);
		money=new JTextField();
		money.setEditable(false);
		standard=new JLabel();
		standard.setForeground(Color.BLUE);
		standard.setPreferredSize(new Dimension(130, 21));
		address=new JLabel();
		address.setForeground(Color.BLUE);
		shortname=new JLabel();
		shortname.setForeground(Color.BLUE);
		packing=new JLabel();
		packing.setForeground(Color.BLUE);
		unit=new JLabel();
		unit.setForeground(Color.BLUE);
		b1=new JButton("确定");
		b2=new JButton("关闭");
		
		setupComponent(new JLabel("商品名称"),0,0,1,0,false);
		setupComponent(productname,1,0,1,1,true);
		setupComponent(new JLabel("规          格"),2,0,1,0,false);
		setupComponent(standard,3,0,1,1,true);
		setupComponent(new JLabel("产          地"),0,1,1,0,false);
		setupComponent(address,1,1,1,1,true);
		setupComponent(new JLabel("简          称"),2,1,1,0,false);
		setupComponent(shortname,3,1,1,1,true);
		setupComponent(new JLabel("包          装"),0,2,1,0,false);
		setupComponent(packing,1,2,1,1,true);
		setupComponent(new JLabel("单          位"),2,2,1,0,false);
		setupComponent(unit,3,2,1,1,true);
		setupComponent(new JLabel("单          价"),0,3,1,0,false);
		setupComponent(price,1,3,1,1,true);
		setupComponent(new JLabel("库存数量"),2,3,1,0,false);
		setupComponent(storagenumber,3,3,1,1,true);
		setupComponent(new JLabel("库存金额"),0,4,1,0,false);
		setupComponent(money,1,4,1,1,true);
		setupComponent(b1,1,5,1,0,false);
		setupComponent(b2,3,5,1,0,false);
		
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
