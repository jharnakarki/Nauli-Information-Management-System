<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<div class="container">
	<article>
		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType") : "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Add a new Expenses</h2>
		</div>
		<br />
		<div class="row">

			<form method="POST" action="addExpense">
				<div class="form-group">
					<label>Truck Number</label> <input class="form-control" type="text"
						name="truckNumber" />
				</div>
				<div class="form-group">
					<label>Date</label> <input class="form-control" type="date"
						name="expenseDate"  />
				</div>
				<div class="form-group">
					<label>Amount</label> <input class="form-control" type="Number"
						name="amount" />
				</div>
				<div class="form-group">
					<label>remark</label> <input class="form-control" type="text"
						name="remarks"/>
				</div>
				

				<button class="btn btn-primary" type="submit">Add Expenses</button>
			</form>
		</div>
	</article>
</div>
<jsp:include page="../common/footer.jsp" />