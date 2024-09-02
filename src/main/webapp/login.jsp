<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="bean.MemoBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<% List<MemoBean> Lmb = (List<MemoBean>)session.getAttribute("returnLmb");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> ようこそ <%= session.getAttribute("userName") %> さん。 </h2>
	
 	<table>
	<%for(int i = 0; i < Lmb.size(); i++){%>
		<%MemoBean mb = (MemoBean)Lmb.get(i);%>
	 		<tr>
			<td><%=mb.getMemoUserId()%></td>
			<td><%=mb.getMemoTitle()%></td>
			<td><%=mb.getMemoContent()%></td>
			<td>
				<form action="/Memo/DeleteMemoServlet" method="post">
					<input type="hidden" value="<%=mb.getMemoTitle()%>" name="deleteId">
					<button class=""
				        type="submit" 
				        value="削除する"
				    >削除する</button>
				</form>
			</td>
		</tr>
	<% } %>
	</table>
	
	<!-- 
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
	 -->
	
	<!-- <p><a href="/Memo/LogoutServlet">ログアウト</a></p> -->
	
	<form action="<%= request.getContextPath() %>/insert.jsp" method="post">
		<input type="submit" value="新規メモ登録">
	</form>
	
	<form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
		<input type="submit" value="ログアウト">
	</form>

</body>
</html>