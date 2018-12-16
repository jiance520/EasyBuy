package entity;

/*
 * ¡Ù—‘
 */
public class Comment {

	private int id;
	private String content;
	private String ctime;
	private String reply;
	private String rtime;
	private String name;
	
	public Comment(int id, String content, String ctime, String reply,
			String rtime, String name) {
		this();
		setContent(content);
		setCtime(ctime);
		setId(id);
		setName(name);
		setReply(reply);
		setRtime(rtime);
	}
	public Comment() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
