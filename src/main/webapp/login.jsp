<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> ようこそ <%= session.getAttribute("userName") %> さん。 </h2>
	
	<form action="/Memo/InsertMemoServlet" method="post">
		<input class=""
			type="text"
			name="memoTitle"
			size="100"
			placeholder="Title"
		>
		<br/>
		<textarea class=""
			rows="5"
			cols="80"
			name="memoContent"
			placeholder="Content"
		></textarea>
		<br/>
		<button class=""
		        type="submit" 
		        value="insert"
		>登録</button>
	</form>
	
	<!-- <p><a href="/Memo/LogoutServlet">ログアウト</a></p> -->
	<form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>
</html>