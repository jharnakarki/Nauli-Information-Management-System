<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp" />
	<div class="container">
		<article>
			<div class="row">
				<h2>Add a new Employee</h2>
			</div>
			<br />
			<div class="row">

				<form method="POST" action="addEmployee" />
				<div class="form-group">
					<label>Name</label> 
					<input class="form-control" type="text" name="name" />
				</div>
				<div class="form-group">
					<label>Age</label> 
					<input class="form-control" type="Number" name="age" />
				</div>
				<div class="form-group">
					<label>Address</label> 
					<input class="form-control" type="text" name="address" />
				</div>
				<div class="form-group">
					<label>Phone</label>
					 <input class="form-control" type="Number" name="phone" />
				</div>
				<div class="form-group">
					<label>Position</label>
					 <input class="form-control" type="text" name="pos" />
				</div>
				<div class="form-group">
					<label>Salary</label>
					<input class="form-control" type="Number" name="salary" />
				</div>
				
				<button class="btn btn-primary" type="submit">Add</button>
			</form>
			</div>
		</article>
	</div>
<jsp:include page="common/footer.jsp" />