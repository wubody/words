<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script>
				function toSignup()
				{
					document.getElementById("login").style.display="none";
					document.getElementById("signup").style.display="block";
				}

				function toLogin()
				{
					document.getElementById("login").style.display="block";
					document.getElementById("signup").style.display="none";
				}
	</script>

    <link rel="stylesheet" type="text/css" href = "${pageContext.request.contextPath}/BLOG/css/login.css" />

	
	<title>博客-登录</title>
</head>
<body>


	
	<div class="bg" id="bg" >
	<script>document.getElementById("bg").style.height=window.screen.availHeight+"px";</script>

			<div class="login" id="login" >
				<script>

					var left=window.screen.availWidth/2-(432/2);
					document.getElementById("login").style.left=left+"px";
					
				</script>

				<div class="head">

					<p class="logo">博客</p>
					<p class="slogan">欢迎使用 </p>

				</div>
				<form action="in.do" method="post">
				<div class="input">
					
					<c:if test="${!empty error}">
                             <font color="red"><c:out value="${error}"/></font>
                    </c:if>
					<input type="text" class="username" name="userId"value="请输入用户名" onclick="this.value='';focus()">
					<!--  <div style="display:${UI}">账号错误</div>-->
					<input type="password" class="password" name="userPassword" value="请输入密码" onclick="this.value='';this.type='password';focus()">
				
					<!--  <div style="display:${UP}">密码错误</div>-->
					<button style="background-color: #0f88eb;
						height: 50px;
						width: 300px;
						border-radius: 2px 2px 2px 2px;
						margin:0 auto;
						margin-top: 32px;
						border:1px solid #0f88eb;
						margin-left:66px;
						color:white;"
						>登录</button>
				
				</div>
			    </form>	
			    
				<div class="toSignup" id="toSignup">

					<a href="#" onclick="toSignup()">没有账号？注册</a>

				</div>
				
				
			</div>

			<div class="signup" id="signup" style="height:780px">
					<script>
	
						var left=window.screen.availWidth/2-(432/2);
						document.getElementById("signup").style.left=left+"px";
						
					</script>
	
					<div class="head">
	
						<p class="logo">博客</p>
						<p class="slogan">欢迎使用 </p>
	
					</div>

                    <form action="addUser.do" method="post">
					<div class="input">
						<c:if test="${!empty error1}">
                             <font color="red"><c:out value="${error1}"/></font>
                        </c:if>
						<input type="text" class="username" name="userId" value="请输入账号" onclick="this.value='';focus()">
						<input type="text" class="username" name="userName" value="请输入用户名" onclick="this.value='';focus()">
						<input type="text" class="password" name="userPassword" value="请输入密码" onclick="this.value='';this.type='password';focus()">
						<input type="text" class="password" name="userPassword1" value="请确认密码" onclick="this.value='';this.type='password';focus()">
						
						<br>
						<input type="radio" name="userSex" value="男" checked style="margin-left:66px;margin-top:16px;">男
					 	<input type="radio" name="userSex" value="女"  >女
					 	<br>
						<button style="background-color: #0f88eb;
						height: 50px;
						width: 300px;
						border-radius: 2px 2px 2px 2px;
						margin:0 auto;
						margin-top: 32px;
						border:1px solid #0f88eb;
						margin-left:66px;
						color:white;">注册</button>
	
					</div>
					</form>	
					<div class="toLogin">
	
						<a href="#" onclick="toLogin()">已有账号？登录</a>
	
					</div>
				
				</div>

	</div>

	
	

</body>
</html>