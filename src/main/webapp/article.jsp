<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
				

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/article.css" />

	
	<title>博客-文章</title>
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
   
        <div class="title">${article.title}</div>
        <p>

                <div class="username">${article.userName}</div>

                <div class="time">${article.time}</div>   

        </p> 
        <hr class="titleline">
       

        <div class="article">

              ${article.text}


        </div>
     
        <div class="comment">

            <div class="commentTitle">评论</div>

            <hr class="line">
           <form action="addComment.do?id=${article.id}" method="post">
            <div class="editComment">

                <textarea name="text" ></textarea>

                <div class="commentUser"><%=request.getSession().getAttribute("userName").toString() %></div>

                <button class="commentButton">提交</button>

            </div>
           </form>
            <div class="commentList">
             <c:forEach items="${commentList}" var="comment">
                <div class="commentCard">

                    <div class="commentText">

                        ${comment.text }

                    </div>

                    <div class="username">${comment.userName }</div>

                    <div class="time">${comment.time }</div>

                    <hr class="line">

                </div>
          </c:forEach>

                    

            </div>

        </div>

    </div>
    

    

</body>
</html>