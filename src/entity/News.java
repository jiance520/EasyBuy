package entity;

public class News {

	private int id;
	private String title;
	private String content;
	private String ctime;
	
	
	public News(int id, String title, String content, String ctime) {
		this();
		setId(id);
		setTitle(title);
		setContent(content);
		setCtime(ctime);
	}
	
	public News() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
}
