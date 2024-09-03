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
<style>
	body{
		height: 100vh;
	}
	.form-signin {
		max-width: 330px;
		padding: 1rem;
	}
</style>
</head>
<body class="d-flex align-items-center py-4">
<main class="form-signin w-100 m-auto">

	<form class="" action="/Memo/RegisterServlet" method="post">
		<p class="display-5 fw-bold mb-5">メモ帳アプリ</p>
		<h1 class="fs-5 fw-bold mb-3">アカウント新規登録</h1>
		<div class="form-floating mb-3">
			<input class="form-control rounded-3"
				type="text" 
				id="loginId"
				placeholder="Id" 
				name="loginId" 
				required 
				autofocus
			>
			<label for="loginId">Id</label>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control rounded-3"
				type="password"
				id="loginPass"
				placeholder="Password"
				name="loginPass"
				required
			>
			<label for="loginPass">loginPass</label>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control rounded-3"
			type="text"
			id="userName"
			placeholder="User Name"
			name="userName"
			required
			>
			<label for="userName">userName</label>
		</div>
		<button class="btn btn-primary w-100 py-2" type="submit">登録する</button>
		<hr class="my-4">
		<button onclick="location.href='login.html'" class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="button">ログインページ</button>
	</form>

</main>
</body>
</html>