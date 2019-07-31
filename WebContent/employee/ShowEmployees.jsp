<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.EmployeeInfo"%>

<jsp:include page="../common/header.jsp" />

<div class="container">
	<article>
		<div class="row">
			<h2>Trips</h2>
		</div>

		<br>

		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Phone Number</th>
						<th>Salary</th>
						</tr>
						
				</thead>

				<tbody>
					<% 
						List<EmployeeInfo> listOfEmployees = (ArrayList) request.getAttribute("listOfEmployees");

						for(EmployeeInfo employeeInfo : listOfEmployees) { %>
					<tr>
					<td><%= employeeInfo.getName() %></td>
						<td><%= employeeInfo.getPosition() %></td>
						<td><%= employeeInfo.getPhoneNumber() %></td>
						<td><%= employeeInfo.getSalary() %></td>
						
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