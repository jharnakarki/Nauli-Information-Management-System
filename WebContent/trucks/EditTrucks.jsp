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

			TruckInfo truckInfo = (TruckInfo) request.getAttribute("truckInfo");
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Edit Trucks</h2>
		</div>
		<br />
		<div class="row">
			<form method="post"
				action="editTruckDetail?truckNumber=<%=truckInfo.getTruckNumber()%>">
				<div class="form-group">
					<label>Truck Number</label> <input type="text" class="form-control"
						 name="truckNumber" value="<%=truckInfo.getTruckNumber()%>"
						disabled />
				</div>

				<div class="form-group">
					<label>Brand</label> <input class="form-control" type="text"
						name="brand" value="<%=truckInfo.getBrand()%>" disabled />
				</div>
				<div class="form-group">
					<label>Model</label> <input class="form-control" type="Number"
						name="model" value="<%=truckInfo.getModel()%>" disabled />
				</div>
				<div class="form-group">
					<label>Capacity</label> <input class="form-control" type="Number"
						name="capacity" min="1" value="<%=truckInfo.getCapacity()%>"
						disabled />
				</div>
				<div class="form-group">
					<label>No.of Tyres</label> <input class="form-control"
						type="Number" name="tyres" min="1"
						value="<%=truckInfo.getTyres()%>" disabled />
				</div>
				<div class="form-group">
					<label>Year</label> <input class="form-control" type="number"
						min="1990" name="year" value="<%=truckInfo.getYear()%>" disabled />
				</div>
				<div class="form-group">
					<label>Status</label><select class="form-control" id="isStatus"
						name="isStatus" value="<%=truckInfo.getStatus()%>">
						<option value="active">Active</option>
						<option value="inactive">InActive</option>
						<option value="sold">Sold</option>
					</select>
				</div>

				<button class="btn btn-primary" type="submit">Update Truck
					Information</button>

			</form>
		</div>
	</article>




</div>


<jsp:include page="../common/footer.jsp" />