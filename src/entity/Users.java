package entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Users implements HttpSessionBindingListener{

	private String userId;
	private String userName;
	private String password;
	private String sex;
	private String birthday;
	private String idCode;
	private String email;
	private String mobile;
	private String address;
	private int status ;
	
	
	
	public Users(String userId, String userName, String password, String sex,
			String birthday, String idCode, String email, String mobile,
			String address, int status) {
		this();
		setAddress(address);
		setBirthday(birthday);
		setEmail(email);
		setIdCode(idCode);
		setMobile(mobile);
		setPassword(password);
		setSex(sex);
		setStatus(status);
		setUserId(userId);
		setUserName(userName);
	}
	public Users() {
		
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println(" --- 用户登录 ");
		
	}
	
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println(" --- 用户退出 ");
		
	}
	
}
