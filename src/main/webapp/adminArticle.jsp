<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
				

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/homepage.css" />

	
	<title>博客-文章管理</title>
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

            <div class="title" style="font-size:36px;font-weight:600;color:black;float:left;margin-top:56px;margin-bottom:56px;">文章管理</div>
            <a href="adminP.do" style="margin-top:80px;float:left;width:300px;margin-left:16px;color:grey">切换到用户管理</a>
            <div class="article">
   <c:forEach items="${articleList}" var="article">
                    <div class="card">

                        <div class="username">

                            ${article.userName}

                        </div>
                        <button style="background-color: white;	
                        border: 0;
                        width: 100px;
                        height: 56px;
                        color: #8590a6;	
                        line-height: 52px;
                        text-align: center;
                        font-size: 15px;
                        float: right;"><a href="deleteArticle.do?id=${article.id}">删除</a></button>

                        <div class="title">

                            <a href="gotext.do?id=${article.id}" class="">${article.title}</a>

                        </div>

                        <div class="func">

                            <div class="item" id="love" style="margin-left:0;">${article.love}喜欢</div>

                            <div class="item" id="comment">${article.comment}评论</div>

                            <div class="item" id="time">${article.time}</div>

                        </div>


                    </div>
               </c:forEach>
            </div>
            
           

    </div>
    

    

</body>
</html>