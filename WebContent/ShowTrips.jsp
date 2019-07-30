<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TripInfo"%>

<jsp:include page="common/header.jsp" />

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