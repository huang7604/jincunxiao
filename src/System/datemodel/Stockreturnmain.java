package System.datemodel;

public class Stockreturnmain {
	private String id;
	private String varietynumber;
	private String money;
	private String conclusion;
	private String supplename;
	private String stockreturntime;
	private String manage;
	private String brokerage;
	private String accountmethod;//���۵���Ʒ�����������ս��ۣ���Ӧ�̣�����ʱ�䣬����Ա�������ˣ����㷽ʽ��
	public Stockreturnmain()
	{
		
	}
	public Stockreturnmain(String id)
	{
		this.id=id;
	}
	public Stockreturnmain(String id,String varietynumber,String money, 
			String conclusion,String supplename,String stockreturntime,String manage,String brokerage, String accountmethod)
	{
		this.id=id;
		this.varietynumber=varietynumber;
		this.money=money;
		this.conclusion=conclusion;
		this.supplename=supplename;
		this.stockreturntime=stockreturntime;
		this.manage=manage;
		this. brokerage=brokerage;
		this.accountmethod=accountmethod;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setVarietynumber(String varietynumber)
	{
		this.varietynumber=varietynumber;
		
	}
	public void setMoney(String money)
	{
		this.money=money;
		
	}
	public void setConclusion(String conclusion)
	{
		this.conclusion=conclusion;
		
	}
	public void setStockreturntime(String stockreturntime)
	{
		this.stockreturntime=stockreturntime;
		
	}
	public void setManage(String manage)
	{
		this.manage=manage;
		
	}
	public void setBrokerage(String brokerage)
	{
		this. brokerage=brokerage;
	}
	public void setAccountmethod(String accountmethod)
	{
		this.accountmethod=accountmethod;
	}
	public void setSupplename(String supplename)
	{
		this.supplename=supplename;
	}
	public String getId()
	{
		return id;
	}
	public String getVarietynumber()
	{
		return varietynumber;
	}
	public String getMoney()
	{
		return money;
	}
	public String getConclusion()
	{
		return conclusion;
	}
	public String getCustomername()
	{
		return supplename;
		
	}
	public String getStockreturntime()
	{
		return stockreturntime;
	}
	public String getManage()
	{
		return manage;
		
	}
	public String getBrokerage()
	{
		return brokerage;
	}
	public String getAccountmethod()
	{
		return accountmethod;
	}
}
