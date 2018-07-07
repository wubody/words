<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
				

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/homepage.css" />

	
	<title>博客-用户搜索</title>
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

            <div class="title" style="font-size:36px;font-weight:600;color:black;float:left;margin-top:56px;margin-bottom:56px;">用户管理</div>
            <a href="adminA.do" style="margin-top:80px;float:left;width:300px;margin-left:16px;color:grey">切换到文章管理</a>

            <div class="article">

                
       <c:forEach items="${userList}" var="user">
                            <div class="card">

                                    <div class="title" >
            
                                        <a href="#" class="">${user.userName}</a>
            
                                    </div>
            
                                    <button style="background-color: white;	
                                    border: 0;
                                    width: 100px;
                                    height: 40px;
                                    color: #8590a6;	
                                    line-height: 40px;
                                    text-align: center;
                                    font-size: 15px;
                                    float: right;
                                    margin-top:26px;"><a href="deleteUser.do?id=${user.userId}">删除</a></button>

                                    <div class="func">
            
                                        <div class="item" id="love" style="margin-left:0;">${user.article}文章</div>
                                    </div>
            
                                </div>

                     </c:forEach>
                                   
            
            </div>
            
           

    </div>
    

    

</body>
</html>