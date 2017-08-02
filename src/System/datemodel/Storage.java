package System.datemodel;

public class Storage {
	private String id=null;
	private String productname=null;
	private String shorttname=null;
	private String productaddress=null;
	private String unit=null;
	private String standard=null;
	private String packing=null;
	private Double price=null;
	private Integer number=null;
	public Storage()
	{
		
	}
	public Storage(String id)
	{
		this.id=id;
	}
	public Storage(String id,String productname,String shorttname,String productaddress,String unit,
			String standard,String packing,Double price,Integer number)
	{
		this.id=id;
		this.productname=productname;
		this.shorttname=shorttname;
		this.productaddress=productaddress;
		this.unit=unit;
		this.number=number;
		this.standard=standard;
		this.packing= packing;
		this.price=price;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setProductaddress(String productaddress)
	{
		this.productaddress=productaddress;
	}
	public String getProductname()
	{
		return productname;
	}
	public void setShorttname(String shorttname)
	{
		this.shorttname=shorttname;
	}
	public void setProductAddress(String productaddress)
	{
		this.productaddress=productaddress;
	}
	public void setUnit(String unit)
	{
		this.unit=unit;
	}
	public void setNumber(Integer number)
	{
		this.number=number;
	}
	public void setStandard(String standard)
	{
		this.standard=standard;
	}
	public void setPacking(String packing)
	{
		this.packing= packing;
	}
	public void setPrice(Double price)
	{
		this.price=price;
	}
	public String getId()
	{
		return id;
	}
	public String getProductaddress()
	{
		return productaddress;
	}
	public String getShorttname()
	{
		return shorttname;
	}
	public String getProductAddress()
	{
		return productaddress;
		
	}
	public String getUnit()
	{
		return unit;
	}
	public String getPacking()
	{
		return packing;
	}
	public String getStandard()
	{
		return standard;
	}
	public Integer getNumber()
	{
		return number;
	}
	public Double getPrice()
	{
		return price;
	}
}
