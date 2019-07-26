<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="common/header.jsp" />
<div class="container">
	<article>
		<div class="row">
			<h2>Add a new Expense</h2>
		</div>
		<br />
		<div class="row">
			<form method="post" action="addExpenses"
				enctype="multipart/form-data" />
			<div class="form-group">
				<label>Vehicle Number</label> <input class="form-control"
					type="text" name="num" />
			</div>
			<div class="form-group">
				<label>Date</label> <input class="form-control" type="date"
					name="dat" />
			</div>
			<div class="form-group">
				<label>Amount</label> <input class="form-control" type="Number"
					name="amt" min="1" />
			</div>
			<div class="form-group">
				<label>Bill</label> <input class="form-control" type="file"
					name="bill" />
			</div>
			<div class="form-group">
				<label>Remarks</label> <input class="form-control" type="text"
					name="remarks" />
			</div>
			<button class="btn btn-primary" type="submit">Add</button>

			</form>
		</div>
	</article>
</div>
<jsp:include page="common/footer.jsp" />
