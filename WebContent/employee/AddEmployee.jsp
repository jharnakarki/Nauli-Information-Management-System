<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />


<div class="container">
	<article>
	
		<div class="row">
			<h2>Add a new Employee</h2>
		</div>
		<br />
		<div class="row">

			<form method="POST" action="addEmployee">
				<div class="form-group">
					<label>Name</label> <input class="form-control" type="text"
						name="name" />
				</div>
				<div class="form-group">
					<label>Position</label><select class="form-control" name="position">
					<option value="proprietor">Proprietor</option>
					<option value="Accountant">accountant</option>
					<option value="Driver">Driver</option>
					<option value="Driver Helper">Driver Helper</select>
					 <!-- <input class="form-control" type="text"
						name="position" /> -->
				</div>
				<div class="form-group">
					<label>Phone Number</label> <input class="form-control" type="text"
						name="phoneNumber"  min="1" />
				</div>
				<div class="form-group">
					<label>Salary</label> <input class="form-control" type="Number"
						name="salary"  min="1"/>
				</div>

				<button class="btn btn-primary" type="submit">Add Employee</button>
			</form>
		</div>
	</article>
</div>
<jsp:include page="../common/footer.jsp" />