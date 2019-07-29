<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp" />
<div class="container">
	<article>

		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
					: "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Add a new Admin</h2>
		</div>
		<br />
		<div class="row">
			<form method="Post" action="addAdmin">
				<div class="form-group">
					<label>UserName</label> <input class="form-control" type="text"
						name="name" />
				</div>
				<div class="form-group">
					<label>Password</label> <input class="form-control" type="password"
						name="pass" />
				</div>
				<button class="btn btn-primary" type="submit">Create</button>

			</form>
		</div>
	</article>
</div>
<jsp:include page="common/footer.jsp" />
