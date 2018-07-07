package cn.edu.bean;

public class User {
	private String userId;         
	private String userPassword;
	private String userName;
	private String userSex;
	private int userType;
	private int article;
	public User(){}
	public User(String userId,String userPassword,String userName,String userSex,int userType,int article){
		this.userId=userId;
		this.userPassword=userPassword;
		this.userName=userName;
		this.userSex=userSex;
		this.userType=userType;
		this.article=article;
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public int getArticle() {
		return article;
	}
	public void setArticle(int article) {
		this.article = article;
	}
	
	
}
