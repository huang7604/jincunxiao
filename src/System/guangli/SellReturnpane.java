package System.guangli;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.*;
public class SellReturnpane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField sellreturnid;
	private JComboBox<String> customername;
	private JTextField customermanage;
	private JComboBox<String> accountmethod;
	private JTextField sellreturntime;
	private JTextField brokerage;
	private JTable table;
	private DefaultTableModel model;
	private JTextField varietynumber;
	private JTextField productnumber;
	private JTextField money;
	private JTextField conclusion;
	private JTextField manage;
	private JComboBox<String> productcom;
	public SellReturnpane()
	{
		setVisible(true);
		setBounds(10,10,700,550);
		setLayout(new GridBagLayout());
		sellreturnid=new JTextField();
		customername=new JComboBox<String>();
		customername.setPreferredSize(new Dimension(70,20));
		customermanage=new JTextField();
		accountmethod=new JComboBox<String>();
		accountmethod.setPreferredSize(new Dimension(100,20));
		accountmethod.addItem("�ֽ�");
		accountmethod.addItem("֧Ʊ");
		accountmethod.addItem("��������ת��");
		sellreturntime=new JTextField();
		brokerage=new JTextField();
		model=new DefaultTableModel();
		table=new JTable(model);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(200,300));
		scrollpane.setAutoscrolls(true);
		varietynumber=new JTextField();
		productnumber=new JTextField();
		money=new JTextField();
		conclusion=new JTextField();
		manage=new JTextField();
		
		JLabel l1=new JLabel("�����˻���");
		JLabel l2=new JLabel("�ͻ�");
		JLabel l3=new JLabel("�ͻ���ϵ��");
		JLabel l4=new JLabel("���㷽ʽ");
		JLabel l5=new JLabel("�����˻�ʱ��");
		JLabel l6=new JLabel("������");
		JLabel l7=new JLabel("Ʒ������");
		JLabel l8=new JLabel("��������");
		JLabel l9=new JLabel("�ϼƽ��");
		JLabel l10=new JLabel("���ս���");
		JLabel l11=new JLabel("������Ա");
		productcom=new JComboBox<String>();
		
		setupcomponent(l1,0,0,1,0,false);
		setupcomponent(sellreturnid,1,0,1,50,true);
		setupcomponent(l2,2,0,1,0,false);
		setupcomponent(customername,3,0,1,50,true);
		setupcomponent(l3,4,0,1,0,false);
		setupcomponent(customermanage,5,0,1,50,true);
		setupcomponent(l4,0,1,1,0,false);
		setupcomponent(accountmethod,1,1,1,50,true);
		setupcomponent(l5,2,1,1,0,false);
		setupcomponent(sellreturntime,3,1,1,50,true);
		setupcomponent(l6,4,1,1,0,false);
		setupcomponent(brokerage,5,1,1,50,true);
		setupcomponent(scrollpane,0,2,6,1,true);
		setupcomponent(l7,0,3,1,0,false);
		setupcomponent(varietynumber,1,3,1,50,true);
		setupcomponent(l8,2,3,1,0,false);
		setupcomponent(productnumber,3,3,1,50,true);
		setupcomponent(l9,4,3,1,0,false);
		setupcomponent(money,5,3,1,110,true);
		setupcomponent(l10,0,4,1,0,false);
		setupcomponent(conclusion,1,4,1,50,true);
		setupcomponent(l11,2,4,1,0,false);
		setupcomponent(manage,3,4,1,50,true);
		JPanel p1=new JPanel();
		JButton b1=new JButton("���");
		b1.addActionListener(new AddListener());
		JButton b2=new JButton("����");
		p1.add(b1);
		p1.add(b2);
		setupcomponent(p1,4,4,1,0,true);
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
		String[] columnname={"��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "��λ", "���", "����",
				"����", "��װ", "����", "��׼�ĺ�"};
		((DefaultTableModel)table.getModel()).setColumnIdentifiers(columnname);
		TableColumn column=table.getColumnModel().getColumn(0);
		DefaultCellEditor cellEditor=new DefaultCellEditor(productcom);
		cellEditor.setClickCountToStart(1);
		column.setCellEditor(cellEditor);
	}
	class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.addRow(new Vector<String>());
		}
	}
	class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}
