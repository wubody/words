package cn.edu.dao;
import java.util.*;
import cn.edu.bean.Comment;
public interface CommentDao {
	//插入评论
	public void insertComment(Comment comment);  
	//通过文章id获取评论
	public List<Comment> getCommentByArticleId(int articleId);

}
