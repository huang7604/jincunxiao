package System.datemodel;

public class Stockmain {
	private String id;
	private String varietynumber;
	private String money;
	private String conclusion;
	private String supplename;
	private String stocktime;
	private String manage;
	private String brokerage;
	private String accountmethod;//销售单，品种数，金额，验收结论，供应商，销售时间，操作员，经手人，结算方式。
	public Stockmain()
	{
		
	}
	public Stockmain(String id)
	{
		this.id=id;
	}
	public Stockmain(String id,String varietynumber,String money, 
			String conclusion,String supplename,String stocktime,String manage,String brokerage, String accountmethod)
	{
		this.id=id;
		this.varietynumber=varietynumber;
		this.money=money;
		this.conclusion=conclusion;
		this.supplename=supplename;
		this.stocktime=stocktime;
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
	public void setStocktime(String stocktime)
	{
		this.stocktime=stocktime;
		
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
	public String getStocktime()
	{
		return stocktime;
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


