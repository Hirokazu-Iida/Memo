<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>アカウント新規登録</h1>
	
	<form action="/Memo/RegisterServlet" method="post">
	<input class=""
		type="text" 
		id="loginId"
		placeholder="Id" 
		name="loginId" 
		required 
		autofocus
	> 
	<input class=""
		type="password"
		id="loginPass"
		placeholder="Password"
		name="loginPass"
		required
	>
	<input class=""
		type="text"
		id="userName"
		placeholder="User Name"
		name="userName"
		required
	>
	<button class=""
		type="submit" 
		value="register"
	>ログイン</button>
	</form>
	
	<p><a href="login.html">ログインページ</a></p>

</body>
</html>