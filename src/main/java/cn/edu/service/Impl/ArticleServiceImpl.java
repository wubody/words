package cn.edu.service.Impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.bean.Article;
import cn.edu.service.*;
import cn.edu.dao.*;
@Service("articleService")  
public class ArticleServiceImpl implements ArticleService{
	@Resource    
    private ArticleDao articleDao;
	
	public void insertArticle(Article article) {
		// TODO Auto-generated method stub
		articleDao.insertArticle(article);
	}
	

	public Article getArticleByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByPrimaryKey(id);
	}
	
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		articleDao.deleteByPrimaryKey(id);
	}

	
	public void deleteByUserId(String userId) {
		// TODO Auto-generated method stub
		articleDao.deleteByUserId(userId);
	}

	
    public void updateArticle(Article article){  
		// TODO Auto-generated method stub
		articleDao.updateArticle(article);
	}

	
	public List<Article> getAllArticle() {
		// TODO Auto-generated method stub
		return articleDao.getAllArticle();
	}


	@Override
	public List<Article> getUserArticle(String userId) {
		// TODO Auto-generated method stub
		return articleDao.getUserArticle(userId);
	}

	@Override
	public List<Article> getArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return articleDao.getArticleByTitle(title);
	}

	

	

}
