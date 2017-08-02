package System.guangli;
import javax.swing.*;

import java.awt.*;

import javax.swing.table.*;
public class SellRankpane extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> year=new JComboBox<String>();
	private JLabel l1=new JLabel("��");
	private JComboBox<String> monts=new JComboBox<String>();
	private JLabel l2=new JLabel("�·ݵ�������Ϣ����");
	private JComboBox<String> money=new JComboBox<String>();
	private JLabel l3=new JLabel("��  ��");
	private JComboBox<String> method=new JComboBox<String>();
	private JButton b1=new JButton("ȷ��");
	private JTable table=new JTable();
	public SellRankpane()
	{
		 setBounds(10,10,600,500);
		 setVisible(true);
		 setLayout(new GridBagLayout());
		 
		 year.setPreferredSize(new Dimension(200,20));
		 for(int i=2000;i<2030;i++)
		 {
			 year.addItem(String.valueOf(i));
		 }
		 
		 monts.setPreferredSize(new Dimension(100,20));
		 for(int i=1;i<13;i++)
		 {
			 monts.addItem(String.valueOf(i));
		 }
		 
		 method.setPreferredSize(new Dimension(200,20));
		 method.addItem("��������");
		 method.addItem("��������");
		 
		money.setPreferredSize(new Dimension(100,20));
		money.addItem("���");
		money.addItem("����");
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		initable();
		JScrollPane pane=new JScrollPane(table);
		pane.setPreferredSize(new Dimension(400,400));
		pane.setAutoscrolls(true);
		
		setupcomponent(year,0,0,1,0,false);
		setupcomponent(l1,1,0,1,0,false);
		setupcomponent(monts,2,0,1,0,false);
		setupcomponent(l2,3,0,1,0,false);
		setupcomponent(money,4,0,1,0,false);
		setupcomponent(l3,5,0,0,0,false);
		setupcomponent(method,6,0,1,0,false);
		setupcomponent(b1,7,0,1,0,false);
		
		final GridBagConstraints gcon=new GridBagConstraints();
		gcon.gridwidth=8;
		gcon.gridx=0;
		gcon.gridy=1;
		gcon.weighty=1.0;
		gcon.insets= new Insets(0, 1, 5, 10);
		gcon.fill=GridBagConstraints.BOTH;
		
		add(pane,gcon);
		
	}
	private void initable()
	{
		String[] str={"��Ʒ���", "��Ʒ����", "���۽��", "��������",
				"���", "����", "��λ", "���", "��װ", "����", "��׼�ĺ�","���","��Ӧ��"};
		((DefaultTableModel)table.getModel()).setColumnIdentifiers(str);
	}
	private void setupcomponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill)
	{
		final GridBagConstraints con=new GridBagConstraints();
		con.gridx=gridx;
		con.gridy=gridy;
		con.insets=new Insets(1,1,0,3);
		if(gridwidth>0)
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

}
