package cn.edu.bean;

public class Comment {
	private int id;
	private String userId;
	private String userName;
	private int articleId;
	private String time;
	private String text;
	public Comment(){}
	public Comment(String userId,String userName,int articleId,
			String time,String text){
		this.userId=userId;
		this.userName=userName;
		this.articleId=articleId;
		this.time=time;
		this.text=text;
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
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
