<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	
				

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/profile.css" />

	
	<title>博客-个人中心</title>
</head>
<body>
    
    <div class="navBG">

            <div class="nav">

                    <div class="logo">
            
                            <a href="hand.do"> 博客</a>
            
                    </div>
            
                    <div class="search">
            
                        <form action="find.do" method="post">
                            <select name="findType" id="">

                                <option  value="1">文章</option>
                                 <option  value="0">用户</option>
                            </select>
                    
                            <input type="text" name="find">
                            
                            <button>搜索</button>
            
                        </form>
            
                    </div>

                    <div class="setContainer">

                        <div class="set">

                            <button><a href="profile.jsp">个人中心</a></button>

                        </div>

                        <div class="set">

                            <button>登出</button>
    
                        </div>

                    </div>
            
            </div>

    </div>
   
    <div class="bg">

    </div>

    

    <div class="container">

            <div class="title" >个人中心</div>

 <form action="updateUser.do" method="post">
        <div class="setting">

            <p >用户名</p>

            <input type="text" name="userName" class="titleText" style="margin-top:48px;" value="<%=request.getSession().getAttribute("userName").toString() %> ">

        </div>

        <div class="setting">

            <p>性别</p>
    
          
                    <select name="userSex" id="">

                        <option value="男">男</option>
                         <option value="女">女</option>
                    </select>
          
    
         </div>

         <div class="setting">

                <p>密码</p>
        
                <input type="password" name="userPassword" class="titleText" >
        
         </div>

        <button>保存</button>
 </form>
        <button style="background-color:grey;margin-left:100px;">返回</button>
    </div>
            
            
    

</body>
</html>