package words;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.edu.uilt.*;
import cn.edu.bean.Article;
import cn.edu.service.ArticleService;

public class test2 {
	
	
	
	private ApplicationContext ac = null;

    
    private ArticleService articleService=null;
    Article article=null;
    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        
        articleService=(ArticleService)ac.getBean("articleService");
    }
	@Test
    public void getAll() {
        List<Article> articleList=articleService.getAllArticle();
        int i=articleList.size()-1;
        for(;i>=0;i--){
        	article=(Article)articleList.get(i);
       	    System.out.println(article.getId()+"  "+article.getUserId());
        }
    }
	/*@Test
	public void getById(){
		int i;
		article=articleService.getArticleByPrimaryKey(1);
		i=article.getId();
   	    System.out.println(article.getId()+"  "+article.getUserId());
   	    System.out.println(i);
	}
	@Test
	public void getByUserId(){
		List<Article> articleList=articleService.getUserArticle("123");
		int i=articleList.size()-1;
        for(;i>=0;i--){
        	article=(Article)articleList.get(i);
       	    System.out.println(article.getId()+"  "+article.getUserId());
        }
	}
	@Test
	public void getByTitle(){
		List<Article> articleList=articleService.getArticleByTitle("www");
		int i=articleList.size()-1;
        for(;i>=0;i--){
        	article=(Article)articleList.get(i);
       	    System.out.println(article.getId()+"  "+article.getUserId());
        }
	}
	@Test
	public void add(){
		DtoS dts=new DtoS();
		String time=dts.getDate();
		article=new Article("789","456",time,"123","wjq",1,1);
		articleService.insertArticle(article);
	}
	@Test
	public void deleteById(){
		articleService.deleteByPrimaryKey(3);
	}
	@Test
	public void deleteByUserId(){
		articleService.deleteByUserId("789");
	}
	@Test 
	public void updata(){
		article=articleService.getArticleByPrimaryKey(5);
		article.setText("ccc");
		articleService.updateArticle(article);
	}*/
	
}
