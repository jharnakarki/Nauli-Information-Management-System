<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="..//common/header.jsp" />
	<div class="container">
		<article>

			<div class="row">
				<h2>Create New Admin</h2>
			</div>
			<br />
			<%
				Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
						: "";
				Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";
			%>

			<div class="row alert <%=messageType%>"><%=message%></div>
			<div class="row">
				<form method="POST" action="addAdmins">

					<div class="form-group">
						<label for="">Username</label> <input class="form-control"
							type="text" name="username" />
					</div>

					<div class="form-group">
						<label class="password">Password</label> <input
							class="form-control" type="Password" name="password" />

					</div>
					<button class="btn btn-primary" type="submit">Add</button>
				</form>
			</div>

		</article>
	</div>

<jsp:include page="../common/footer.jsp" />