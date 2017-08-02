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
		frame=new JFrame("进销存管理系统");
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
		baseManagepane.add(createbutton("客户信息管理","CustomerFrame"));
		baseManagepane.add(createbutton("商品信息管理","ProductFrame"));
		baseManagepane.add(createbutton("供应商信息管理","SuppleFrame")); 
		
		JPanel depotManagepane=new JPanel();
		depotManagepane.setBackground(new Color(215, 223, 194));
		depotManagepane.setLayout(new BoxLayout(depotManagepane,BoxLayout.X_AXIS));
		depotManagepane.add(createbutton("库存盘点","StorageFrame"));
		depotManagepane.add(createbutton("价格调整","PriceFrame")); 
		
		JPanel sellManagepane=new JPanel();
		sellManagepane.setBackground(new Color(215,223,194));
		sellManagepane.setLayout(new BoxLayout(sellManagepane,BoxLayout.X_AXIS));
		sellManagepane.add(createbutton("销售单","SellFrame"));
		sellManagepane.add(createbutton("销售退货","SellReturnFrame"));
		
		JPanel stockManagepane = new JPanel();// 进货管理面板
		stockManagepane.setBackground(new Color(215, 223, 194));
		stockManagepane.setLayout(new BoxLayout(stockManagepane,BoxLayout.X_AXIS));
		stockManagepane.add(createbutton("进货单","StockFrame"));
		stockManagepane.add(createbutton("进货退货","StockReturnFrame"));
		
		JPanel searchManagePanel = new JPanel();// 查询统计面板
		searchManagePanel.setBounds(0, 0, 600, 41);
		searchManagePanel.setBackground(new Color(215, 223, 194));
		searchManagePanel.setLayout(new BoxLayout(searchManagePanel, BoxLayout.X_AXIS));
		searchManagePanel.add(createbutton("客户信息查询","CustomerSearchFrame"));
		searchManagePanel.add(createbutton("商品信息查询","ProductSearchFrame"));
		searchManagePanel.add(createbutton("供应商信息查询","SuppleSearchFrame"));
		searchManagePanel.add(createbutton("销售信息查询","SellSearchFrame"));
		searchManagePanel.add(createbutton("销售退货查询","SellReturnSearch"));
		searchManagePanel.add(createbutton("入库查询","StockSearchFrame"));
		searchManagePanel.add(createbutton("入库退货查询","StockReturnSearch"));
		searchManagePanel.add(createbutton("销售排行","SellRank"));
		
		JPanel sysManagePanel = new JPanel();// 系统管理面板
		sysManagePanel.setBackground(new Color(215, 223, 194));
		sysManagePanel.setLayout(new BoxLayout(sysManagePanel, BoxLayout.X_AXIS));
		sysManagePanel.add(createbutton("操作员管理","UserAddFrame"));
		sysManagePanel.add(createbutton("更改密码","SetPasswordFrame"));
		sysManagePanel.add(createbutton("权限管理","PowerManageFrame"));
		sysManagePanel.add(createbutton("退出系统",""));
		
		tabbedpane.addTab("   基本信息管理    ", null, baseManagepane, "基本信息管理");
		tabbedpane.addTab("   销售管理   ", null, sellManagepane, "销售管理");
		tabbedpane.addTab("   进货管理   ", null, stockManagepane, "进货管理");
		tabbedpane.addTab("   库存管理   ", null, depotManagepane, "库存管理");
		tabbedpane.addTab("   查询统计   ", null, searchManagePanel, "查询统计");
		tabbedpane.addTab("   系统管理   ", null, sysManagePanel, "系统管理");
		
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
