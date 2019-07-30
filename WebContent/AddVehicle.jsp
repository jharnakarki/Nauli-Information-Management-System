<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="common/header.jsp" />

<div class="container">

	<article>

		<% 

		Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType") : "";
		Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";

		%>

		<div class="row alert <%= messageType %>"><%= message %></div>
		<div class="row">
			<h2>Add a new vehicle</h2>
		</div>
		<br />
		<div class="row">
			<form method="POST" action="addVehicle">
				<div class="form-group">
					<label>Vehicle Number</label> <input class="form-control"
						type="text" name="num" required />
				</div>
				<div class="form-group">
					<label>Brand</label> <input class="form-control" type="text"
						name="brand" required />
				</div>
				<div class="form-group">
					<label>Model</label> <input class="form-control" type="Number"
						name="model" required />
				</div>
				<div class="form-group">
					<label>Capacity</label> <input class="form-control" type="Number"
						min="1" name="capacity" required />
					<p class="small">( Tons )</p>
				</div>
				<div class="form-group">
					<label>No.of Tyres</label> <input class="form-control"
						type="Number" min="4" name="tyres" required />
				</div>
				<div class="form-group">
					<label>Year</label> <input class="form-control" type="number"
						min="1990" name="year" required />
				</div>
				<div class="form-group">
					<label>Status</label><select id="isStatus" name="isStatus">
					<option id="active"> Active</option>
					 <option id="inactive">InActive</option>
					 <option id="sold"> Sold</option></select>
				</div>

				<button class="btn btn-primary" type="submit">Add</button>
			</form>
		</div>
	</article>
</div>

<jsp:include page="common/footer.jsp" />