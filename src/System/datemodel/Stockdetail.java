package System.datemodel;

public class Stockdetail {
	private Integer id;
	private String stockid;
	private String productid;
	private Double price;
	private Integer number;//表ID，进货ID，商品ID，价格，数量。
	public Stockdetail()
	{
		
	}
	public Stockdetail(Integer id)
	{
		this.id=id;
	}
	public Stockdetail(Integer id,String stockid,String productid,Double price,Integer number)
	{
		this.id=id;
		this.number=number;
		this.price=price;
		this.productid=productid;
		this.stockid=stockid;
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
	public void setStockid(String stockid)
	{
		this.stockid=stockid;
	}
	public int getId()
	{
		return id;
	}
	public String getSellid()
	{
		return stockid;
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
