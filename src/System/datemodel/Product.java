package System.datemodel;

public class Product {
	private String id=null;
	private String name=null;
	private String shorttname=null;
	private String productaddress=null;
	private String unit=null;
	private String supple=null;
	private String introdution=null;
	private String promission_id=null;
	private String number=null;
	private String standard=null;
	private String packing=null;
	public Product()
	{
		
	}
	public Product(String id)
	{
		this.id=id;
	}
	public Product(String id,String name,String shorttname,String productaddress,String unit,
			String supple,String introdution,String promission_id,String number,String standard,String packing)
	{
		this.id=id;
		this.name=name;
		this.shorttname=shorttname;
		this.productaddress=productaddress;
		this.unit=unit;
		this.supple=supple;
		this.introdution=introdution;
		this.promission_id=promission_id;
		this.number=number;
		this.standard=standard;
		this.packing= packing;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
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
	public void setSupple(String supple)
	{
		this.supple=supple;
	}
	public void setIntrodution(String introdution)
	{
		this.introdution=introdution;
	}
	public void setPromission_id(String promission_id)
	{
		this.promission_id=promission_id;
	}
	public void setNumber(String number)
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
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
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
	public String getSupple()
	{
		return supple;
	}
	public String getIntrodution()
	{
		return introdution;
	}
	public String getPromission_id()
	{
		return promission_id;
	}
	public String getNumber()
	{
		return number;
	}
	public String getStandard()
	{
		return standard;
	}
	public String getPacking()
	{
		return packing;
	}
}
