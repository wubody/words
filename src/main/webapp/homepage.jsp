<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
				

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/homepage.css" />

	
	<title>博客-首页</title>
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

            <div class="article">
                <c:forEach items="${articleList}" var="article">
                    <div class="card">

                        <div class="username">

                            ${article.userName}

                        </div>

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
               
               <c:forEach items="${userList}" var="user">
                   <div class="card">

                                        <div class="title">
                
                                            <a href="#" class="">${user.userName}</a>
                
                                        </div>
                
                                        <div class="func">
                
                                            <div class="item" id="love" style="margin-left:0;">${user.article}文章</div>
                
                
                                        </div>
                
                                    </div>
               </c:forEach>
            </div>
     
            <div class="userinfo">
            
                <div class="username"><a href="personal.do"><%=request.getSession().getAttribute("userName").toString() %></a></div>

                <div class="userdata">

                    <div class="love">

                        <div class="num"><%=request.getSession().getAttribute("love")%></div>
                        喜欢

                    </div>

                    <div class="articleCount">

                            <div class="love">

                                    <div class="num"><%=request.getSession().getAttribute("count")%></div>
                                    文章
            
                                </div>

                    </div>

                </div>

                <div class="userpage"></div>
                
            </div>

    </div>
    

    

</body>
</html>