<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp" isErrorPage="false"%>
	
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TruckInfo"%>

<jsp:include page="../common/header.jsp" />
<div class="container">
	<article>
		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
					: "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Add a new Trip</h2>
		</div>
		<br />
		<div class="row">

			<form method="post" action="addTrip">

				<div class="form-group">
					<label for="vehNum">Truck Number</label> 
					<select class="form-control" name="vehNum" id="vehNum">
						<option value="NA">--Select Truck--</option> <!-- Not Available -->
						<%
							List<TruckInfo> truckInfos = (ArrayList) request.getAttribute("listOfActiveTrucks");
							
							for(TruckInfo truckInfo : truckInfos) {
								out.println("<option value='"+truckInfo.getTruckNumber()+"'>" + truckInfo.getTruckNumber() + "</option>");
							}
						%>
					</select>
				</div>

				<div class="form-group">
					<label>Start Date</label> <input class="form-control" type="Date"
						name="dtStart" />
				</div>

				<div class="form-group">
					<label>Ending Date</label> <input class="form-control" type="Date"
						name="dtEnd" />
				</div>

				<div class="form-group">
					<label>Start Mileage</label> <input class="form-control"
						type="Number" name="maStart" />
				</div>

				<div class="form-group">
					<label>End Mileage</label> <input class="form-control"
						type="Number" name="maEnd" />
				</div>

				<div class="form-group">
					<label>Origin</label> <input class="form-control" type="text"
						name="org" />
				</div>

				<div class="form-group">
					<label>Multiple Destination</label> <input class="form-control"
						type="text" name="mulDes" />
				</div>

				<div class="form-group">
					<label>Revenue</label> <input class="form-control" type="Number"
						min="1" name="rev" />
				</div>

				<div class="form-group">
					<label>Driver</label> <input class="form-control" type="text"
						name="dName" />
				</div>

				<div class="form-group">
					<label>Remarks</label> <textarea class="form-control" name="remarks" rows="10" cols="20"></textarea>
				</div>

				<button class="btn btn-primary" type="submit">Add</button>

			</form>
		</div>
	</article>




</div>


<jsp:include page="../common/footer.jsp" />
