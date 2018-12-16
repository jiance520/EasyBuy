package entity;

public class Detail {

	private int id;
	private int orderId;
	private int productId;
	private int quantity;//商品数量
	private double cost;//价格
	
	public Detail(int id, int orderId, int productId, int quantity, double cost) {
		this();
		setCost(cost);
		setId(id);
		setOrderId(orderId);
		setProductId(productId);
		setQuantity(quantity);
	}
	public Detail() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
