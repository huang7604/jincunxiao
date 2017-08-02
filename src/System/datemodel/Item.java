package System.datemodel;
public class Item {
	public String id;
	public String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return id+name;
	}
	public boolean equals(Item item)
	{
		if(Item.this.id.equals(item.id)&&Item.this.name.equals(item.name))
			return true;
		else
		return false;
	}
	@Override
	public int hashCode()
	{
		return 37*17*id.hashCode();
	}
}
