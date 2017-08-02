package System.datemodel;

public class Stockreturndatail {
	private Integer id;
	private String stockreturnid;
	private String productid;
	private Double price;
	private Integer number;//表ID，进货ID，商品ID，价格，数量。
	public Stockreturndatail()
	{
		
	}
	public Stockreturndatail(Integer id)
	{
		this.id=id;
	}
	public Stockreturndatail(Integer id,String stockreturnid,String productid,Double price,Integer number)
	{
		this.id=id;
		this.number=number;
		this.price=price;
		this.productid=productid;
		this.stockreturnid=stockreturnid;
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
	public void setStockreturnid(String stockreturnid)
	{
		this.stockreturnid=stockreturnid;
	}
	public int getId()
	{
		return id;
	}
	public String getStockreturnid()
	{
		return stockreturnid;
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
