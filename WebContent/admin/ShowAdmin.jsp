<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.AdminInfo"%>

<jsp:include page="../common/header.jsp" />


<div class="container">
	<article>
		<div class="row">
			<h2>Manage Administrator</h2>
		</div>

		<br>


		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Admin Username</th>
						<th>Action</th>
					</tr>

				</thead>

				<tbody>
					<%
						List<AdminInfo> listOfAdmins = (ArrayList) request.getAttribute("listOfAdmins");

						for (AdminInfo adminInfo : listOfAdmins) {
					%>
					<tr>
						<td><%=adminInfo.getUsername()%></td>
						<td><a class="btn btn-sm btn-secondary"
							href="deleteAdmin?username=<%=adminInfo.getUsername()%>"
							title="Delete Admimn"><i class="fas fa-trash"></i></a></td>

					</tr>

					<%
						}
					%>
					<tr>
					<tr>
				</tbody>
			</table>
		</div>

	</article>
</div>

<jsp:include page="../common/footer.jsp" />
