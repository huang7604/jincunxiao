package System.guangli;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
public class Storagepane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField time = new JTextField(); // ����ʱ��
	private final JTextField varetynumber = new JTextField("0"); // Ʒ������
	private JTextField manage = new JTextField();// �̵�Ա
	private JTable table=new JTable();
	public Storagepane()
	{
		setVisible(true);
		setBounds(10,10,600,450);
		setLayout(new GridBagLayout());
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		inittable();
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(300,400));
		
		setupcomponent(new JLabel("�̵�Ա"),0,0,1,0,false);
		setupcomponent(manage,1,0,1,220,true);
		setupcomponent(new JLabel("�̵�ʱ��"),2,0,1,0,false);
		setupcomponent(time,3,0,1,220,true);
		setupcomponent(new JLabel("Ʒ������"),4,0,1,0,false);
		setupcomponent(varetynumber,5,0,1,220,true);
		setupcomponent(scrollpane,0,1,6,0,true);
		
		
		
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
		String[] colunmname={"��Ʒ����", "��Ʒ���", "��Ӧ��", "����", "��λ", "���", "����",
				"����", "��װ", "�̵�����", "��������"};
		((DefaultTableModel)table.getModel()).setColumnIdentifiers(colunmname);
		TableColumn column=table.getColumnModel().getColumn(0);
		column.setCellEditor( null);
	}

}
