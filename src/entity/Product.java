package entity;

/*
 * …Ã∆∑
 */
public class Product {

	private int id ;
	private String name;
	private String description;
	private double price;
	private int stock;
	private int parentId;
	private int childId;
	private String fileName;
	
	public Product(int id, String name, String description, double price,
			int stock, int parentId, int childId, String fileName) {
		this();
		setChildId(childId);
		setDescription(description);
		setFileName(fileName);
		setId(id);
		setName(name);
		setParentId(parentId);
		setPrice(price);
		setStock(stock);
	}
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
