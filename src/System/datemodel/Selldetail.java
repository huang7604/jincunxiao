package System.datemodel;

public class Selldetail {
	private Integer id;
	private String sellid;
	private String productid;
	private Double price;
	private Integer number;//表ID，销售单ID，商品ID，价格，数量。
	public Selldetail()
	{
		
	}
	public Selldetail(Integer id)
	{
		this.id=id;
	}
	public Selldetail(Integer id,String sellid,String productid,Double price,Integer number)
	{
		this.id=id;
		this.number=number;
		this.price=price;
		this.productid=productid;
		this.sellid=sellid;
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
	public void setSellid(String sellid)
	{
		this.sellid=sellid;
	}
	public int getId()
	{
		return id;
	}
	public String getSellid()
	{
		return sellid;
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
