<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp" />
<div class="container">
	<article>
		<div class="row">
			<h2>Add a new Trip</h2>
		</div>
		<br />
		<div class="row">

			<form method="post" action="TruckTrip" />
			<div class="form-group">
				<label>Truck Number</label> <input class="form-control" type="Text"
					name="vehNum" />
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
				<label>End Mileage</label> <input class="form-control" type="Number"
					name="maEnd" />
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
				<label>Remarks</label> <input class="form-control" type="Text"
					name="remarks" />
			</div>

			<button class="btn btn-primary" type="submit">Add</button>

			</form>
		</div>
	</article>




</div>


<jsp:include page="common/footer.jsp" />
