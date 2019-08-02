<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.ExpenseInfo"%>

<jsp:include page="../common/header.jsp" />

	
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
							<th>Action</th>
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
							<td><a class="btn btn-sm btn-secondary" href="editExpense?expenseId=<%= expenseInfo.getExpenseId()%>"><i class="fas fa-pencil-alt">edit</i></a>
						
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
</body>
</html>
