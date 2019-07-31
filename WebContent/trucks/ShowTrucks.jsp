<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TruckInfo"%>

<jsp:include page="../common/header.jsp" />

<div class="container">
	<article>
		<div class="row">
			<h2>Trucks</h2>
		</div>

		<br>

		<div class="row">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Truck Number</th>
						<th>Brand</th>
						<th>Model</th>
						<th>Capacity</th>
						<th>Tyres</th>
						<th>Year</th>
						<th>Status</th>
					</tr>
				</thead>

				<tbody>
					<% 
						List<TruckInfo> listOfTrucks = (ArrayList) request.getAttribute("listOfTrucks");

						for(TruckInfo truckInfo : listOfTrucks) { %>
					<tr>
						<td><%= truckInfo.getTruckNumber() %></td>
						<td><%= truckInfo.getBrand() %></td>
						<td><%= truckInfo.getModel() %></td>
						<td><%= truckInfo.getCapacity() %></td>
						<td><%= truckInfo.getTyres() %></td>
						<td><%= truckInfo.getYear() %></td>
						<td><%= truckInfo.getStatus() %></td>
						
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