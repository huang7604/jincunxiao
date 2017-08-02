package System.guangli;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
public class StockReturnpane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField stockreturnid;
	private JComboBox<String> supplename;
	private JTextField supplemanage;
	private JComboBox<String> accountmethod;
	private JComboBox<String> productcom;
	private JTextField stockreturntime;
	private JTextField brokerage;
	private JTable table;
	private DefaultTableModel model;
	private JTextField varietynumber;
	private JTextField productnumber;
	private JTextField money;
	private JTextField conclusion;
	private JTextField manage;
	public StockReturnpane()
	{
		setVisible(true);
		setBounds(10,10,700,550);
		setLayout(new GridBagLayout());
		stockreturnid=new JTextField();
		supplename=new JComboBox<String>();
		supplename.setPreferredSize(new Dimension(100,20));
		supplemanage=new JTextField();
		accountmethod=new JComboBox<String>();
		accountmethod.setPreferredSize(new Dimension(100,20));
		accountmethod.addItem("�ֽ�");
		accountmethod.addItem("֧Ʊ");
		accountmethod.addItem("��������ת��");
		productcom=new JComboBox<String>();
		stockreturntime=new JTextField();
		brokerage=new JTextField();
		model=new DefaultTableModel();
		table=new JTable(model);
		inittable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(230,300));
		varietynumber=new JTextField();
		productnumber=new JTextField();
		money=new JTextField();
		conclusion=new JTextField();
		manage=new JTextField();
		
		JLabel l1=new JLabel("�����˻���");
		JLabel l2=new JLabel("��Ӧ��");
		JLabel l3=new JLabel("��Ӧ����ϵ��");
		JLabel l4=new JLabel("���㷽ʽ");
		JLabel l5=new JLabel("�˻�ʱ��");
		JLabel l6=new JLabel("������");
		JLabel l7=new JLabel("Ʒ������");
		JLabel l8=new JLabel("��������");
		JLabel l9=new JLabel("�ϼƽ��");
		JLabel l10=new JLabel("���ս���");
		JLabel l11=new JLabel("������Ա");
		
		setupcomponent(l1,0,0,1,0,false);
		setupcomponent(stockreturnid,1,0,1,50,true);
		setupcomponent(l2,2,0,1,0,false);
		setupcomponent(supplename,3,0,1,50,true);
		setupcomponent(l3,4,0,1,0,false);
		setupcomponent(supplemanage,5,0,1,100,true);
		setupcomponent(l4,0,1,1,0,false);
		setupcomponent(accountmethod,1,1,1,50,true);
		setupcomponent(l5,2,1,1,0,false);
		setupcomponent(stockreturntime,3,1,1,50,true);
		setupcomponent(l6,4,1,1,0,false);
		setupcomponent(brokerage,5,1,1,100,true);
		setupcomponent(scrollpane,0,2,6,1,true);
		setupcomponent(l7,0,3,1,0,false);
		setupcomponent(varietynumber,1,3,1,50,true);
		setupcomponent(l8,2,3,1,0,false);
		setupcomponent(productnumber,3,3,1,50,true);
		setupcomponent(l9,4,3,1,0,false);
		setupcomponent(money,5,3,1,50,true);
		setupcomponent(l10,0,4,1,0,false);
		setupcomponent(conclusion,1,4,1,50,true);
		setupcomponent(l11,2,4,1,0,false);
		setupcomponent(manage,3,4,1,50,true);
		JPanel p1=new JPanel();
		JButton b1=new JButton("���");
		b1.addActionListener(new AddListener());
		JButton b2=new JButton("�˻�");
		p1.add(b1);
		p1.add(b2);
		setupcomponent(p1,4,4,1,0,true);
		
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

	public static  void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
		      JFrame f=new JFrame();
		      f.setBounds(100, 100, 300, 600);
		      f.setVisible(true);
		      f.setTitle("text");
		      JScrollPane j=new JScrollPane(new  StockReturnpane());
		      j.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		      f.add(j);
			}
		});
	}

}
