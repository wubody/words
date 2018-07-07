package cn.edu.uilt;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date; 
public class DtoS {
	//获取时间并转换为String类型
	public String getDate(){
		Date d=new Date();
		 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=format.format(d);;
		return s;
	}

}
