<jsp:include page="common/header.jsp" />
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.naulitraders.model.ProfitLossAccount"%>
<%@ page import="com.naulitraders.model.TripInfo"%>
<%@ page import="com.naulitraders.model.TruckInfo"%>
<%@ page import="com.naulitraders.model.ExpenseInfo"%>

<div class="container">
	<article>
		<h2>Welcome to Nauli trader <% out.println(session.getAttribute("userName")); %> </h2>
				

		<div class="card">
			<div class="card-header">
				<h5 class="modal-title">Profit Loss Account</h5>
			</div>
			<div class="card-body">

				<div class="jumbotron row">
					<form method="GET" action="home" class="form-inline">
						<div class="form-group mb-1">
							<label for="vehicleNumber">Vehicle Number &nbsp; </label>
							
							<select class="form-control" name="vehicleNumber" required >
								<option value="NA">--Select Truck--</option>
								<!-- Not Available -->
								<%
									List<TruckInfo> truckInfos = (ArrayList) request.getAttribute("listOfTrucks");

									for (TruckInfo truckInfo : truckInfos) {
										out.println("<option value='" + truckInfo.getTruckNumber() + "'>" + truckInfo.getTruckNumber()
												+ "</option>");
									}
								%>
							</select>
						</div>
						<div class="form-group mb-2 mx-sm-3">
							<label for="startDate">Start Date &nbsp; </label> <input
								type="date" class="form-control" name="startDate" required />
						</div>

						<div class="form-group mb-2 mx-sm-3">
							<label for="endDate">End Date &nbsp; </label> <input type="date"
								class="form-control" name="endDate" required />
						</div>
						<button type="submit" class="btn btn-primary mb-1">Process</button>
					</form>

				</div>

				<%
					ProfitLossAccount pl = (ProfitLossAccount) request.getAttribute("profitLoss");

					if (pl != null) {
				%>
				<div class="row">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th>Date</th>
								<th>Particular</th>
								<th>Amount (DR)</th>
								<th>Date</th>
								<th>Particular</th>
								<th>Amount (CR)</th>
							</tr>
						</thead>

						<tbody>
							<%
								List<TripInfo> trips = pl.getTrips();
									List<ExpenseInfo> expenses = pl.getExpenses();

									Iterator<TripInfo> tripsIt = trips.iterator();
									Iterator<ExpenseInfo> expensesIt = expenses.iterator();

									while (tripsIt.hasNext() || expensesIt.hasNext()) {
							%>
							<tr>
								<%
									if (tripsIt.hasNext()) {
												TripInfo tripInfo = tripsIt.next();
								%>
								<td><%=tripInfo.getEndDate()%></td>
								<td>Trip Revenue</td>
								<td><%=tripInfo.getRevenue()%></td>
								<%
									} else {
								%>
								<td></td>
								<td></td>
								<td></td>
								<%
									}
								%>

								<%
									if (expensesIt.hasNext()) {
												ExpenseInfo expenseInfo = expensesIt.next();
								%>
								<td><%=expenseInfo.getExpenseDate()%></td>
								<td><%=expenseInfo.getRemarks()%></td>
								<td><%=expenseInfo.getAmount()%></td>
								<%
									} else {
								%>
								<td></td>
								<td></td>
								<td></td>
								<%
									}
								%>
							
							<tr>
								<%
									}
								%>

								<!--  show total -->
							<tr class="table-secondary">
								<td></td>
								<td></td>
								<td><%=pl.getTotalRevenue()%></td>
								<td></td>
								<td></td>
								<td><%=pl.getTotalExpenses()%></td>
							</tr>

							<!--  show profit loss -->
							<tr
								class="<%=pl.getProfitLoss() > 0 ? "table-success" : "table-danger"%>">
								<td colspan="5" class="text-right">Profit / Loss</td>
								<td><%=pl.getProfitLoss()%></td>
							</tr>


						</tbody>
					</table>
				</div>
				<%
					}
				%>
			</div>
		</div>

	</article>
</div>

<jsp:include page="common/footer.jsp" />