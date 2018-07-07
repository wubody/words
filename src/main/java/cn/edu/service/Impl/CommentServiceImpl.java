package cn.edu.service.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.bean.Comment;
import cn.edu.dao.*;
import cn.edu.service.*;
@Service("commentService")  
public class CommentServiceImpl implements CommentService{
	
	@Resource    
    private CommentDao commentDao;
	
	@Override
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.insertComment(comment);
	}

	@Override
	public List<Comment> getCommentByArticleId(int articleId) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByArticleId(articleId);
	}

}
