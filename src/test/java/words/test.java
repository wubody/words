package words;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.edu.service.*;
import cn.edu.bean.*;
public class test {
	private ApplicationContext ac = null;

    private UserService userService = null;
    User user=null;
    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        userService = (UserService) ac.getBean("userService");
        
    }
    
    /*@Test
    public void getByKey() {
	   user=userService.getUserByPrimaryKey("123");
	   System.out.println(user.getUserId()+"  "+user.getUserName());
	}
    @Test
    public void getAll() {
		List<User> userList=userService.getAllUser();
		int i=userList.size()-1;
		for(;i>=0;i--){
			user=(User)userList.get(i);
			System.out.println(user.getUserId()+"  "+user.getUserName());
		}
		
	}
    @Test
    public void getByUserName() {
    	List<User> userList=userService.getUserByUserName("456");
		int i=userList.size()-1;
		for(;i>=0;i--){
			user=(User)userList.get(i);
			System.out.println(user.getUserId()+"  "+user.getUserName());
		}
	}
	@Test
	public void add(){
		user=new User("789","789","456","男",0);
		userService.insertUser(user);
		user=new User("012","012","456","女",0);
		userService.insertUser(user);
	}
	@Test
	public void delete(){
		userService.deleteByPrimaryKey("789");
		userService.deleteByPrimaryKey("012");
	}*/
	@Test 
	public void updata(){
		user=userService.getUserByPrimaryKey("123");
		user.setUserName("lll");
		userService.updateUser(user);
	}
    
}
