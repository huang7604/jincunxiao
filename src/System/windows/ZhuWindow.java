package System.windows;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
public class ZhuWindow {
	private JFrame frame;
	private JLabel backLabel;
	private JDesktopPane desktoppane;
	private HashMap<String,JInternalFrame> framemap=new HashMap<String,JInternalFrame>();
	public ZhuWindow()
	{
		frame=new JFrame("���������ϵͳ");
		frame.setVisible(true);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(170, 188, 120));
		frame.getContentPane().setLayout(new BorderLayout());
		frame.addComponentListener(new FrameListener());
		
		
		backLabel=new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updatebackLabel();  
		
		desktoppane=new JDesktopPane();
		desktoppane.add(backLabel,new Integer(Integer.MIN_VALUE));

		JTabbedPane tab=createJTabbedpane();
		frame.getContentPane().add(desktoppane);
		frame.getContentPane().add(tab,BorderLayout.NORTH);
	}
	private void updatebackLabel()
	{
		if(backLabel!=null)
		{
			int width=ZhuWindow.this.frame.getWidth();
			int height=frame.getHeight();
			backLabel.setSize(width,height);
			backLabel.setText("<html><body><image width='" +width
					+ "' height='" + (height - 110) + "'src="
					+ ZhuWindow.this.getClass().getResource("welcome.jpg")
					+ "></img></body></html>");
			
		}
	}
	private final class FrameListener extends ComponentAdapter 
	{
		public void componentResized(final ComponentEvent e)
		{
			updatebackLabel();
		}
	}
	static
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private JTabbedPane createJTabbedpane()
	{
		JTabbedPane tabbedpane=new JTabbedPane();
		tabbedpane.setFocusable(false);
		tabbedpane.setBackground(new Color(211, 230, 192));
		tabbedpane.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		JPanel baseManagepane=new JPanel();
		baseManagepane.setBackground(new Color(215, 223, 194));
		baseManagepane.setLayout(new BoxLayout(baseManagepane,BoxLayout.X_AXIS));
		baseManagepane.add(createbutton("�ͻ���Ϣ����","CustomerFrame"));
		baseManagepane.add(createbutton("��Ʒ��Ϣ����","ProductFrame"));
		baseManagepane.add(createbutton("��Ӧ����Ϣ����","SuppleFrame")); 
		
		JPanel depotManagepane=new JPanel();
		depotManagepane.setBackground(new Color(215, 223, 194));
		depotManagepane.setLayout(new BoxLayout(depotManagepane,BoxLayout.X_AXIS));
		depotManagepane.add(createbutton("����̵�","StorageFrame"));
		depotManagepane.add(createbutton("�۸����","PriceFrame")); 
		
		JPanel sellManagepane=new JPanel();
		sellManagepane.setBackground(new Color(215,223,194));
		sellManagepane.setLayout(new BoxLayout(sellManagepane,BoxLayout.X_AXIS));
		sellManagepane.add(createbutton("���۵�","SellFrame"));
		sellManagepane.add(createbutton("�����˻�","SellReturnFrame"));
		
		JPanel stockManagepane = new JPanel();// �����������
		stockManagepane.setBackground(new Color(215, 223, 194));
		stockManagepane.setLayout(new BoxLayout(stockManagepane,BoxLayout.X_AXIS));
		stockManagepane.add(createbutton("������","StockFrame"));
		stockManagepane.add(createbutton("�����˻�","StockReturnFrame"));
		
		JPanel searchManagePanel = new JPanel();// ��ѯͳ�����
		searchManagePanel.setBounds(0, 0, 600, 41);
		searchManagePanel.setBackground(new Color(215, 223, 194));
		searchManagePanel.setLayout(new BoxLayout(searchManagePanel, BoxLayout.X_AXIS));
		searchManagePanel.add(createbutton("�ͻ���Ϣ��ѯ","CustomerSearchFrame"));
		searchManagePanel.add(createbutton("��Ʒ��Ϣ��ѯ","ProductSearchFrame"));
		searchManagePanel.add(createbutton("��Ӧ����Ϣ��ѯ","SuppleSearchFrame"));
		searchManagePanel.add(createbutton("������Ϣ��ѯ","SellSearchFrame"));
		searchManagePanel.add(createbutton("�����˻���ѯ","SellReturnSearch"));
		searchManagePanel.add(createbutton("����ѯ","StockSearchFrame"));
		searchManagePanel.add(createbutton("����˻���ѯ","StockReturnSearch"));
		searchManagePanel.add(createbutton("��������","SellRank"));
		
		JPanel sysManagePanel = new JPanel();// ϵͳ�������
		sysManagePanel.setBackground(new Color(215, 223, 194));
		sysManagePanel.setLayout(new BoxLayout(sysManagePanel, BoxLayout.X_AXIS));
		sysManagePanel.add(createbutton("����Ա����","UserAddFrame"));
		sysManagePanel.add(createbutton("��������","SetPasswordFrame"));
		sysManagePanel.add(createbutton("Ȩ�޹���","PowerManageFrame"));
		sysManagePanel.add(createbutton("�˳�ϵͳ",""));
		
		tabbedpane.addTab("   ������Ϣ����    ", null, baseManagepane, "������Ϣ����");
		tabbedpane.addTab("   ���۹���   ", null, sellManagepane, "���۹���");
		tabbedpane.addTab("   ��������   ", null, stockManagepane, "��������");
		tabbedpane.addTab("   ������   ", null, depotManagepane, "������");
		tabbedpane.addTab("   ��ѯͳ��   ", null, searchManagePanel, "��ѯͳ��");
		tabbedpane.addTab("   ϵͳ����   ", null, sysManagePanel, "ϵͳ����");
		
		return tabbedpane;
		
		
	}
	private JButton createbutton(String name,String framename)
	{
		String imgUrl = "picture/ActionIcon/" + name + ".png";
		String imgUrl_roll = "picture/ActionIcon/" + name	+ "_roll.png";
		String imgUrl_down = "picture/ActionIcon/" + name	+ "_down.png";
		Icon icon=new ImageIcon(imgUrl);
		Icon icon_roll=null;
		Icon icon_down=null;
		if(imgUrl_roll!=null)
		{
			icon_roll=new ImageIcon(imgUrl_roll);
		}
		if(imgUrl_down!=null)
		{
			icon_down=new ImageIcon(imgUrl_down);
		}
		Action action=new openFrame(name,framename,icon);
		JButton button=new JButton(action);
		button.setMargin(new Insets(0,0,0,0));
		button.setHideActionText(true);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		if (icon_roll != null)
		{
			button.setRolloverIcon(icon_roll);
		}
		if (icon_down != null)
		{
			button.setPressedIcon(icon_down);
		}
		return button;
	}
	private JInternalFrame getFrame(String framename)
	{
		JInternalFrame frame=null;
		if(!framemap.containsKey(framename))
		{
			try
			{
				Class<?> fclass =Class.forName("System.InternalFrame."+framename);
				Constructor<?> constructor=fclass.getConstructor();
				frame=(JInternalFrame)constructor.newInstance();
				framemap.put(framename, frame);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			frame=framemap.get(framename);
		}
		return frame;
		
	}
	protected class openFrame extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String framename=null;
		public openFrame()
		{
			
		}
		public openFrame(String cname,String framename,Icon icon)
		{
			this.framename=framename;
			putValue(Action.NAME,cname);
			putValue(Action.SHORT_DESCRIPTION,cname);
			putValue(Action.SMALL_ICON,icon);
		}
		public void actionPerformed(ActionEvent e)
		{
			JInternalFrame jf=getFrame(framename);
			jf.addInternalFrameListener(new InternalFrameAdapter()
			{
				public void internalFrameClosed(InternalFrameEvent e)
				{
					framemap.remove(framename);
				}
			});
			if(jf.getDesktopPane()==null)
			{
				desktoppane.add(jf);
				jf.setVisible(true);
			}
			
			try
			{
				jf.setSelected(true);
			}
			catch(PropertyVetoException e1)
			{
				e1.printStackTrace();
			}
					
		}
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ZhuWindow();
			}
		});
	} 

}
