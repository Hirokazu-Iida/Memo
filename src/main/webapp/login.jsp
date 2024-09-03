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
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<main>

<div class="container py-4">
	<div class="p-4 p-md-5 mb-4 bg-body-tertiary rounded-3">
		<div class="container-fluid px-0 py-4">
			<h1 class="display-5 fw-bold"><%= session.getAttribute("userName") %> さんのページです。</h1>
			<p class="col-md-8 fs-4 pb-2 pb-md-3">Sample text. Sample text. Sample text. Sample text. Sample text. Sample text. Sample text. Sample text. Sample text.</p>
			<div class="d-flex gap-3">
			<form action="<%= request.getContextPath() %>/insert.jsp" method="post">
				<button class="btn btn-primary btn-lg" type="submit">新規メモ登録</button>
			</form>
			<form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
				<button class="btn btn-outline-secondary btn-lg" type="submit">ログアウト</button>
			</form>
			</div>
		</div>
	</div>
	
	<div class="row align-items-md-stretch">

	<%for(int i = 0; i < Lmb.size(); i++){%>
		<%MemoBean mb = (MemoBean)Lmb.get(i);%>
		<div class="col-md-6 mb-4">
			<div class="h-100 p-4 p-md-5 text-bg-dark rounded-3">
				<h2><%=mb.getMemoTitle()%></h2>
				<p class="pb-2 pb-md-3"><%=mb.getMemoContent()%></p>
				<form action="/Memo/DeleteMemoServlet" method="post">
					<input type="hidden" value="<%=mb.getMemoId()%>" name="deleteId">
					<button class="btn btn-outline-light" type="submit">削除する</button>
				</form>
			</div>
		</div>
	<% } %>
	
		<div class="col-md-6 mb-4">
			<div class="h-100 p-4 p-md-5 bg-body-tertiary border rounded-3">
				<h2>新規メモ登録</h2>
				<p class="pb-2 pb-md-3">こちらからメモを登録することができます。</p>
				<form action="<%= request.getContextPath() %>/insert.jsp" method="post">
					<button class="btn btn-primary" type="submit">新規メモ登録</button>
				</form>
			</div>
		</div>
      
    </div>
</div>

</main>
</body>
</html>