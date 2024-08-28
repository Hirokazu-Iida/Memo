<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> ようこそ <%= request.getAttribute("userName") %> さん。 </h2>
	
	<form action="/Memo/LoginServlet" method="post">
		<input class=""
			type="text"
			name="title"
			size="100"
			placeholder="Title"
		>
		<br/>
		<textarea class=""
			rows="5"
			cols="80"
			name="content"
			placeholder="Content"
		></textarea>
		<br/>
		<button class=""
		        type="submit" 
		        value="login"
		    >登録</button>
	</form>
	
	<!-- <p><a href="/Memo/LogoutServlet">ログアウト</a></p> -->
	<form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
    <input type="submit" value="ログアウト">
  </form>

</body>
</html>