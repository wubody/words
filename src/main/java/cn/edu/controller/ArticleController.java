package cn.edu.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.bean.*;
import cn.edu.service.ArticleService;
import cn.edu.service.UserService;
import cn.edu.uilt.*;
@Controller
public class ArticleController {
	
	//获取数据库服务
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    private static ArticleService articleService=(ArticleService)ac.getBean("articleService");
    private static UserService userService=(UserService)ac.getBean("userService");
    
	
    //发布文章
	@RequestMapping("addArticle.do")
	public String add(HttpServletRequest request, String title,String text)
			throws ServletException, IOException {
		//获取信息
		
		String userId=(String)request.getSession().getAttribute("userId");
		User user=userService.getUserByPrimaryKey(userId);
		int count=user.getArticle()+1;
		user.setArticle(count);
		userService.updateUser(user);
		request.getSession().setAttribute("count",count);
		String userName=(String)request.getSession().getAttribute("userName");
		String love1=request.getParameter("love");
		DtoS dts=new DtoS();
		String time=dts.getDate();
		Article article=null;
		article=new Article(userId,userName,time,title,text,0,0);
		articleService.insertArticle(article);
		return "hand.do";
		
	}
	
	//删除文章
	@RequestMapping("deleteArticle.do")
	public String  delete(HttpServletRequest request,
			@RequestParam(value = "id",required = false) String articleId)
			throws ServletException, IOException {
		//获取信息
		int id=Integer.parseInt(articleId);
		Article article=articleService.getArticleByPrimaryKey(id);
		String userId=article.getUserId();
		User user=userService.getUserByPrimaryKey(userId);
		int count=user.getArticle()-1;
		user.setArticle(count);	
		userService.updateUser(user);
		articleService.deleteByPrimaryKey(id);
		return "hand.do";
	}
	
	/*//修改文章
	@RequestMapping("updateArticle.do")
	public String updata(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取信息
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String title=request.getParameter("title");
		String text=request.getParameter("text");
		Article article=articleService.getArticleByPrimaryKey(id);
		article.setTitle(title);
		article.setText(text);
		articleService.updateArticle(article);
		return "";
	}*/
	
}
