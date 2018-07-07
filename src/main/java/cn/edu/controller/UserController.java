package cn.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bean.*;
import cn.edu.service.ArticleService;
import cn.edu.service.CommentService;
import cn.edu.service.UserService;;

@Controller
public class UserController {
	
	//获取数据库服务
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    private static UserService userService=(UserService)ac.getBean("userService");
    private static ArticleService articleService=(ArticleService)ac.getBean("articleService");
    private static CommentService commentService=(CommentService)ac.getBean("commentService");
	
    //首页
    @RequestMapping(value = "hand.do")
	public ModelAndView hand(Model model){
    	
    	List<Article> articleList=articleService.getAllArticle();
		return new ModelAndView("homepage.jsp","articleList",articleList);
	}
    //登陆页
    @RequestMapping(value = "login.do")
	public String go(Model model){
    	
    	return "login.jsp";
	}
    //p->ad
    @RequestMapping(value = "adminA.do")
   	public ModelAndView adminA(Model model){
       	
       	List<Article> articleList=articleService.getAllArticle();
   		return new ModelAndView("adminArticle.jsp","articleList",articleList);
   	}
    //a->p
    @RequestMapping(value = "adminP.do")
   	public ModelAndView adminP(Model model){
    	List<User> userList=userService.getAllUser();
		//model.addAttribute("list", userList);
		return new ModelAndView("adminPeople.jsp","userList",userList);
       	
   	}
	//登陆验证
	@RequestMapping(value = "in.do")
	public ModelAndView in(HttpServletRequest request,
			String userId,String userPassword,Model model){
		User user=null;
		user=userService.getUserByPrimaryKey(userId);
		if(user==null){
			return new ModelAndView("login.jsp", "error", "用户名错误");
		}else{
			//判断密码是否正确
			if(userPassword.compareTo(user.getUserPassword())==0){
				//根据用户类型导向不同用户页,1为管理员，0为普通用户
				if(user.getUserType()==1){
					List<Article> articleList=articleService.getAllArticle();
					request.getSession().setAttribute("userId","admin");
					request.getSession().setAttribute("username","admin");
					request.getSession().setAttribute("userType", "1");
					
					return new ModelAndView("adminArticle.jsp","articleList",articleList);
				}else{
					List<Article> articleList=articleService.getUserArticle(userId);
					int love=0,i=0;
					for(;i<articleList.size();i++){
						Article a=(Article)articleList.get(i);
						love=love+a.getLove();
					}
					articleList=articleService.getAllArticle();
					int count=user.getArticle();
					request.getSession().setAttribute("userId", userId);
					request.getSession().setAttribute("userName", user.getUserName());
					request.getSession().setAttribute("userType", "0");
					request.getSession().setAttribute("love",love);
					request.getSession().setAttribute("count",count);
					return new ModelAndView("homepage.jsp","articleList",articleList);
			    }	
			}else{
				
				return new ModelAndView("login.jsp", "error", "密码错误");
			}
			
		}
		
	}
	//进入个人中心
	@RequestMapping(value = "personal.do")
	public ModelAndView personal(HttpServletRequest request){
		String userId=(String)request.getSession().getAttribute("userId");
		
		List<Article> articleList=articleService.getUserArticle(userId);
		return new ModelAndView("userpage.jsp","articleList",articleList);
	}
	
	//搜索框查找用户或文章
	@RequestMapping(value = "find.do")
	public ModelAndView find(HttpServletRequest request,Model model,
			String find,String findType)
			throws ServletException, IOException {
		
		//根据查找类型查找信息 0为用户姓名，1为文章标题
		if(findType.compareTo("0")==0){
			List<User> userList=userService.getUserByUserName(find);
			//model.addAttribute("list", userList);
			return new ModelAndView("homepage.jsp","userList",userList);
		}else{
			List<Article> articleList=articleService.getArticleByTitle(find);
			//model.addAttribute("list", articleList);
			return new ModelAndView("homepage.jsp","articleList",articleList);
		}
	}
	
	//进入文章页
	@RequestMapping(value = "gotext.do")
	public ModelAndView goText(@RequestParam(value = "id",required = false) String articleId,
			HttpServletRequest request,Model model){
		int id=Integer.parseInt(articleId);
		Article article=articleService.getArticleByPrimaryKey(id);
		List<Comment> commentList=commentService.getCommentByArticleId(id);
		model.addAttribute("commentList", commentList);
		return new ModelAndView("article.jsp", "article", article);
	}
	
	//添加用户
	@RequestMapping(value = "addUser.do")
	public ModelAndView add(String userId,String userPassword,String userPassword1,String userName,String userSex,
			HttpServletRequest request)
			throws ServletException, IOException {
		//判断user账号是否存在
		User user=null;
		user=userService.getUserByPrimaryKey(userId);
		if(user==null){	
			if(userPassword.compareTo(userPassword1)==0){
				user=new User(userId,userPassword,userName,userSex,0,0);
				userService.insertUser(user);
				request.getSession().setAttribute("userId", userId);
				request.getSession().setAttribute("userName", userName);
				request.getSession().setAttribute("userType", "0");
				request.getSession().setAttribute("love",0);
				request.getSession().setAttribute("count",0);
				return new ModelAndView("hand.do");
			}else{
				return new ModelAndView("login.jsp", "error", "密码不一致");
			}
		}else{
		    return new ModelAndView("login.jsp", "error", "账号已存在");
		}
	}
	
	//删除用户
	@RequestMapping(value = "deleteUser.do")
	public String delete(HttpServletRequest request,@RequestParam(value = "id",required = false) String userId)
			throws ServletException, IOException {
		//获取信息
		articleService.deleteByUserId(userId);
		userService.deleteByPrimaryKey(userId);
		return "adminP.do";
	}
	
	/*//修改密码
	@RequestMapping(value = "updataPassword.do")
	public void updataPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取信息
		String userId=request.getParameter("userId");
		String userPassword=request.getParameter("userPassword");
		String newPassword=request.getParameter("newpassword");
		String newPassword1=request.getParameter("newPassword1");
		User user=userService.getUserByPrimaryKey(userId);
		//判断密码是否正确
		if(user.getUserPassword().compareTo(userPassword)==0){
			
		}else{
			//判断新密码是否一样
			if(newPassword.compareTo(newPassword1)==0){
				user.setUserPassword(newPassword);
				userService.updateUser(user);
			}else{
				
			}
		}
		
	}*/
	
	//修改用户基本信息
	@RequestMapping(value = "updateUser.do")
	public String updata(HttpServletRequest request,String userName,String userPassword,String userSex)
			throws ServletException, IOException {
		//获取信息
		String userId=(String)request.getSession().getAttribute("userId");
		User user=userService.getUserByPrimaryKey(userId);
		String userName1=user.getUserName();
		user.setUserName(userName);	
		user.setUserSex(userSex);
		user.setUserPassword(userPassword);
		userService.updateUser(user);
		//判断修改后用户名字是否一样 ，一样则不需要修改文章表用户姓名，不一样则修改
		if(userName.compareTo(userName1)==0){
			
		}else{
			request.getSession().setAttribute("userName",userName);
			List<Article> articleList=articleService.getUserArticle(userId);
			int i=0;
			while(i>articleList.size()){
				Article article=(Article)articleList.get(i++);
				article.setUserName(userName);
				articleService.updateArticle(article);
			}
		}
		return "hand.do";
	}
	
}