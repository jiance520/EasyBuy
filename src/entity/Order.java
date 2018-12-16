package entity;

public class Order {

	private int id;
	private String userId;
	private String name;
	private String address;
	private String ctime;
	private double cost;//总价
	private int status;//订单状态
	private int type;//支付类型
	
	public Order(int id, String userId, String name, String address,
			String ctime, double cost, int status, int type) {
		this();
		setAddress(address);
		setCost(cost);
		setCtime(ctime);
		setId(id);
		setName(name);
		setStatus(status);
		setType(type);
		setUserId(userId);
	}
	public Order() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
