package cn.edu.service;
import java.util.List;

import cn.edu.bean.Comment;
public interface CommentService {

	//插入评论
	public void insertComment(Comment comment);  
	//通过文章id获取评论
	public List<Comment> getCommentByArticleId(int articleId);

}
