<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<nav class="navbar navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="#">Nauli IMS</a>
		</div>
	</nav>
	<div class="container">
		<article>
			<div class="row">
				<h2>Login to Admin Panel</h2>
			</div>
			<br />
			<div class="row">
				<form method="POST" action="login">

					<div class="form-group">
						<label for="">Username</label> <input class="form-control"
							type="text" name="username" />
					</div>

					<div class="form-group">
						<label class="password">Password</label> <input
							class="form-control" type="Password" name="password" />

					</div>
					<button class="btn btn-primary" type="submit">Login</button>
				</form>
			</div>

		</article>
	</div>

</body>
</html>
<jsp:include page="common/footer.jsp" />
    