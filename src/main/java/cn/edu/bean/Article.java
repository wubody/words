package cn.edu.bean;

public class Article {
	private int id;
	private String userId;
	private String userName;		
	private String time;
	private String title;
	private String text;
	private int love;
	private int comment;
	public Article(){}
	public Article(String userId,String userName,String time,
			String title,String text,int love,int comment){
		this.userId=userId;
		this.userName=userName;
		this.time=time;
		this.title=title;
		this.text=text;
		this.love=love;
		this.comment=comment;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	
	
	
}
