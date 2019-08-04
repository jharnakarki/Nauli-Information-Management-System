<jsp:include page="common/header.jsp" />
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TripInfo"%>

<div class="container">
	<article>
		<h2>Welcome to Naulis trader</h2>

		<div class="card">
			<div class="card-header">
				<h5 class="modal-title">Profit Loss Account</h5>
			</div>
			<div class="card-body">

				<div class="jumbotron row">
					<form method="GET" action="home" class="form-inline">
						<div class="form-group mb-1">
							<label for="vehicleNumber">Vehicle Number &nbsp; </label> <input
								type="text" class="form-control" name="vehicleNumber" required />
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
			</div>
		</div>
		
		<br />


		<div class="card">
			<div class="card-header">
				<h5 class="modal-title">Recent Trips</h5>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Truck Number</th>
							<th>Departure Date</th>
							<th>Revenue</th>
							<th>Driver Name</th>
						</tr>

					</thead>

					<tbody>
						<%
							List<TripInfo> listOfTrips = (ArrayList) request.getAttribute("listOfTrips");

							for (TripInfo tripInfo : listOfTrips) {
						%>
						<tr>
							<td><%=tripInfo.getTruckNumber()%></td>
							<td><%=tripInfo.getStartDate()%></td>
							<td><%=tripInfo.getRevenue()%></td>
							<td><%=tripInfo.getDriverName()%></td>
						</tr>

						<%
							}
						%>
						<tr>
						<tr>
					</tbody>
				</table>
			</div>
		</div>


	</article>
</div>

<jsp:include page="common/footer.jsp" />