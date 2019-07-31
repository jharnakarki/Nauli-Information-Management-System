<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.ExpenseInfo"%>

<jsp:include page="common/header.jsp" />
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Page</title>

	<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
	
	<div class="container">
		<article>
			<div class="row">
				<h2>Expense</h2>
			</div>

			<br>


			<div class="row">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Truck Number</th>
							<th>Expense Date</th>
							<th>Amount</th>
							<th >Remarks</th>
						</tr>

					</thead>

					<tbody>
						<%
							List<ExpenseInfo> listOfExpenses = (ArrayList) request.getAttribute("listOfExpenses");

							for (ExpenseInfo expenseInfo : listOfExpenses) {
						%>
						<tr>
							<td><%=expenseInfo.getTruckNumber()%></td>
							<td><%=expenseInfo.getExpenseDate()%></td>
							<td><%=expenseInfo.getAmount()%></td>
							<td><%=expenseInfo.getRemarks()%></td>
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

	<jsp:include page="common/footer.jsp" />
</body>
</html>
