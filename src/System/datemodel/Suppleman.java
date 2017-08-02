package System.datemodel;

public class Suppleman {
	private String id=null;
	private String name=null;
	private String shorttname=null;
	private String address=null;
	private String phone=null;
	private String email=null;
	private String post_id=null;
	private String bank_name=null;
	private String fax_id=null;
	private String managename=null;
	private String managenamephone=null;
	public Suppleman()
	{
		
	}
	public  Suppleman(String id)
	{
		this.id=id;
	}
	public  Suppleman(String id,String name,String shorttname,String address,String phone,
			String email,String post_id,String bank_name,String fax_id,String managename,String managenamephone)
	{
		this.id=id;
		this.name=name;
		this.shorttname=shorttname;
		this.address=address;
		this.phone=phone;
		this.email=email;
		this.post_id=post_id;
		this.bank_name=bank_name;
		this.fax_id=fax_id;
		this.managename=managename;
		this.managenamephone=managenamephone;
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
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public void setEmaild(String email)
	{
		this.email=email;
	}
	public void setPost_id(String post_id)
	{
		this.post_id=post_id;
	}
	public void setBank_name(String bank_name)
	{
		this.bank_name=bank_name;
	}
	public void setFax(String fax_id)
	{
		this.fax_id=fax_id;
	}
	public void setManagename(String managename)
	{
		this.managename=managename;
	}
	public void setManagenamephone(String managenamephone)
	{
		this.managenamephone=managenamephone;
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
	public String getAddress()
	{
		return address;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public String getBankname()
	{
		return bank_name;
	}
	public String getPost_id()
	{
		return post_id;
	}
	public String getFax()
	{
		return fax_id;
	}
	public String getManagename()
	{
		return managename;
	}
	public String getManagenamephone()
	{
		return managenamephone;
	}

	}



