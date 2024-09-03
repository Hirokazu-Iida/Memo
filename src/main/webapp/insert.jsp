<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<%-- <h1 class="display-5 fw-bold"><%= session.getAttribute("userName") %> : 新規メモ登録ページ</h1> --%>
				<h1 class="display-5 fw-bold">新規メモ登録ページ</h1>
				<p class="col-md-8 fs-4 pb-2 pb-md-3">Sample text. Sample text. Sample text. Sample text. Sample text. Sample text. Sample text. Sample text. Sample text.</p>
				
				<form class="col-12 col-lg-auto mb-5 me-lg-auto" action="/Memo/InsertMemoServlet" method="post">
					<div class="form-floating mb-3">
						<input class="form-control"
							type="text"
							name="memoTitle"
							size="100"
							placeholder="Title"
							id="memoTitle"
							required
						>
						<label for="memoTitle">Title</label>
					</div>
					<div class="form-floating mb-3">
						<textarea class="form-control"
							style="height: 200px"
							rows="5"
							cols="80"
							name="memoContent"
							placeholder="Content"
							id="memoContent"
							required
						></textarea>
						<label for="memoContent">Content</label>
					</div>
					<button class="btn btn-primary btn-lg"
					        type="submit" 
					        value="insert"
					>登録する</button>
				</form>
				
				<div class="d-flex gap-3">
					<form action="<%= request.getContextPath() %>/login.jsp" method="post">
						<button class="btn btn-outline-secondary btn-lg" type="submit">戻る</button>
					</form>
					<form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
						<button class="btn btn-outline-secondary btn-lg" type="submit">ログアウト</button>
					</form>
				</div>
			</div>
		</div>
	</div>

 </main>
</body>
</html>