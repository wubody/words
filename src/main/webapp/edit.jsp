<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	
			
				

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/edit.css" />

	
	<title>博客-编辑</title>
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
<form action="addArticle.do" method="post">
    <div class="container">

        <div class="title">

            <p>标题</p>

            <input type="text" name="title" class="titleText">

        </div>

        <div class="article">

            <p>正文</p>

            <textarea name="text" id="" ></textarea>

        </div>

        <button>发布</button>
    </div>
</form>        
            
    

</body>
</html>