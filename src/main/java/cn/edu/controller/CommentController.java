package cn.edu.controller;


import javax.servlet.http.HttpServletRequest;
import cn.edu.bean.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.uilt.*;
import cn.edu.service.ArticleService;
import cn.edu.service.CommentService;;
@Controller
public class CommentController {
	//获取数据库服务
    private static ApplicationContext ac =new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    private static CommentService commentService=(CommentService)ac.getBean("commentService");
    private static ArticleService articleService=(ArticleService)ac.getBean("articleService");
    //添加评论
  	@RequestMapping("addComment.do")
    public String add(@RequestParam(value = "id",required = false) String id,HttpServletRequest request,String text){
  		
  		int articleId=Integer.parseInt(id);
  		String userId=(String)request.getSession().getAttribute("userId");
  		String userName=(String)request.getSession().getAttribute("userName");
  		DtoS dts=new DtoS();
  		String time=dts.getDate();
  		Comment comment=new Comment(userId,userName,articleId,time,text);
  		commentService.insertComment(comment);
  		Article article=articleService.getArticleByPrimaryKey(articleId);
  		int count=article.getComment()+1;
  		article.setComment(count);
  		articleService.updateArticle(article);;
  		return "hand.do";
    }
  	
}
