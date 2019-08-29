<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TripInfo"%>

<jsp:include page="../common/header.jsp" />
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
				<h2>Trips</h2>
			</div>

			<br>


			<div class="row">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Truck Number</th>
							<th>Departure Date</th>
							<th>Arrived Date</th>
							<th>Start Mileage</th>
							<th>End Mileage</th>
							<th>Origin</th>
							<th>Multiple Destination</th>
							<th>Revenue</th>
							<th>Driver Name</th>
							<th>Remarks</th>
							<th>Action</th>
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
							<td><%=tripInfo.getEndDate()%></td>
							<td><%=tripInfo.getStartMileage()%></td>
							<td><%=tripInfo.getEndMileage()%></td>
							<td><%=tripInfo.getOrigin()%></td>
							<td><%=tripInfo.getMulDestination()%></td>
							<td><%=tripInfo.getRevenue()%></td>
							<td><%=tripInfo.getDriverName()%></td>
							<td><%=tripInfo.getRemarks()%></td>
							<td><a class="btn btn-sm btn-secondary"
								href="editTrip?tripId=<%=tripInfo.getTripId()%>"><i
									class="fas fa-pencil-alt">edit</i></a>
						</tr>

						<%
							}
						%>
						
					</tbody>
					
					
				</table>
				
			</div>

		</article>
	</div>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>
