package cn.edu.dao;

import java.util.List;    
import cn.edu.bean.Article;

public interface ArticleDao {
	//插入文章
	public void insertArticle(Article article);    
    //通过主键获取文章
	public Article getArticleByPrimaryKey(Integer id);
	//通过主键删除文章
    public void deleteByPrimaryKey(Integer id); 
    //通过用户id删除文章
    public void deleteByUserId(String userId);
    //修改文章数据
    public void updateArticle(Article article);    
    //获取所有文章
    public List<Article> getAllArticle();
    //获取用户文章
    public List<Article> getUserArticle(String userId);
	//通过标题获取文章
    public List<Article> getArticleByTitle(String title);
    
}
