<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp" isErrorPage="false"%>
	
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TruckInfo"%>
<%@ page import="com.naulitraders.model.TripInfo"%>

<jsp:include page="../common/header.jsp" />
<div class="container">
	<article>
		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
					: "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";
			
			TripInfo tripInfo = (TripInfo) request.getAttribute("tripInfo");
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Edit Trip</h2>
		</div>
		<br />
		<div class="row">

			<form method="post" action="editTrip?tripId=<%= tripInfo.getTripId() %>">
			
				<!--  tripId is hidden over here so database update can happen -->
				<input type="hidden" name="tripId" value="<%= tripInfo.getTripId() %>" />

				<div class="form-group">
					<label for="vehNum">Truck Number</label> 
					<input class="form-control" type="text" name="vehNum" value="<%= tripInfo.getTruckNumber() %>" disabled />
				</div>

				<div class="form-group">
					<label>Start Date</label> 
					<input class="form-control" type="Date" value="<%= tripInfo.getStartDate() %>" name="dtStart" />
				</div>

				<div class="form-group">
					<label>Ending Date</label> 
					<input class="form-control" type="Date" value="<%= tripInfo.getEndDate() %>" name="dtEnd" />
				</div>

				<div class="form-group">
					<label>Start Mileage</label> 
					<input class="form-control" value="<%= tripInfo.getStartMileage() %>" type="Number" name="maStart" />
				</div>

				<div class="form-group">
					<label>End Mileage</label> 
					<input class="form-control" value="<%= tripInfo.getEndMileage() %>" type="Number" name="maEnd" />
				</div>

				<div class="form-group">
					<label>Origin</label> <input class="form-control" type="text" value="<%= tripInfo.getOrigin() %>" name="org" />
				</div>

				<div class="form-group">
					<label>Multiple Destination</label> 
					<input class="form-control" value="<%= tripInfo.getMulDestination() %>" type="text" name="mulDes" />
				</div>

				<div class="form-group">
					<label>Revenue</label> 
					<input class="form-control" type="Number" value="<%= tripInfo.getRevenue() %>" min="1" name="rev" />
				</div>

				<div class="form-group">
					<label>Driver</label> 
					<input class="form-control" type="text" value="<%= tripInfo.getDriverName() %>" name="dName" />
				</div>

				<div class="form-group">
					<label>Remarks</label> 
					<textarea class="form-control" name="remarks" rows="10" cols="20">
						<%= tripInfo.getRemarks() %>
					</textarea>
				</div>

				<button class="btn btn-primary" type="submit">Update Trip</button>

			</form>
		</div>
	</article>




</div>


<jsp:include page="../common/footer.jsp" />