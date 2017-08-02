package System.datemodel;

public class Sellreturndatail {
	private Integer id;
	private String sellreturnid;
	private String productid;
	private Double price;
	private Integer number;//表ID，销售单ID，商品ID，价格，数量。
	public Sellreturndatail()
	{
		
	}
	public Sellreturndatail(Integer id)
	{
		this.id=id;
	}
	public Sellreturndatail(Integer id,String sellreturnid,String productid,Double price,Integer number)
	{
		this.id=id;
		this.number=number;
		this.price=price;
		this.productid=productid;
		this.sellreturnid=sellreturnid;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public void setNumber(Integer number)
	{
		this.number=number;
	}
	public void setPrice(Double price)
	{
		this.price=price;
	}
	public void setProductid(String productid)
	{
		this.productid=productid;
	}
	public void setSellreturnid(String sellreturnid)
	{
		this.sellreturnid=sellreturnid;
	}
	public int getId()
	{
		return id;
	}
	public String getSellreturnid()
	{
		return sellreturnid;
	}
	public String getProduct()
	{
		return productid;
	}
	public Double getPrice()
	{
		return price;
	}
	public Integer getNumber()
	{
		return number;
	}

}

