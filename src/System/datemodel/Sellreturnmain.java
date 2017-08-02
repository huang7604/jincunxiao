package System.datemodel;

public class Sellreturnmain {
	private String id;
	private String varietynumber;
	private String money;
	private String conclusion;
	private String customername;
	private String sellreturntime;
	private String manage;
	private String brokerage;
	private String accountmethod;//销售单，品种数，金额，验收结论，客户，销售时间，操作员，经手人，结算方式。
	public Sellreturnmain()
	{
		
	}
	public Sellreturnmain(String id)
	{
		this.id=id;
	}
	public Sellreturnmain(String id,String varietynumber,String money, 
			String conclusion,String customername,String sellreturntime,String manage,String brokerage, String accountmethod)
	{
		this.id=id;
		this.varietynumber=varietynumber;
		this.money=money;
		this.conclusion=conclusion;
		this.customername=customername;
		this.sellreturntime=sellreturntime;
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
	public void setSellreturntime(String sellreturntime)
	{
		this.sellreturntime=sellreturntime;
		
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
	public void setCustomername(String customername)
	{
		this.customername=customername;
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
		return customername;
		
	}
	public String getSellreturntime()
	{
		return sellreturntime;
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
