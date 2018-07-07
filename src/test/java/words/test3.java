package words;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bean.Article;
import cn.edu.service.ArticleService;
import cn.edu.service.*;
import cn.edu.bean.*;
public class test3 {
private ApplicationContext ac = null;

    
    private CommentService commentService =null;
    Comment comment =null;
    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        
        commentService =(CommentService )ac.getBean("commentService");
    }
	/*@Test
    public void get() {
		comment=new Comment("123","456",1,"123","123");
		commentService.insertComment(comment);
	}*/
	@Test
	public void add(){
		List<Comment> commentList=commentService.getCommentByArticleId(1);
		for(int i=0;i<commentList.size();i++){
			comment=(Comment)commentList.get(i);
			System.out.println(comment.getUserId());
		}
	}
	
}
