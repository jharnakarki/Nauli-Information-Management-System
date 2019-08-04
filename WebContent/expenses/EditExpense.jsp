<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp" isErrorPage="false"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.ExpenseInfo"%>

<jsp:include page="../common/header.jsp" />
<div class="container">
	<article>
		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
					: "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";

			ExpenseInfo expenseInfo = (ExpenseInfo) request.getAttribute("expenseInfo");
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Edit Trip</h2>
		</div>
		<br />
		<div class="row">

			<form method="post"
				action="editExpense?expenseId=<%=expenseInfo.getExpenseId()%>">
				<!--  expenseId is hidden over here so database update can happen -->
				<input type="hidden" name="expenseId"
					value="<%=expenseInfo.getExpenseId()%>" />


				<div class="form-group">
					<label for="vehNum">Truck Number</label> <input
						class="form-control" type="text" name="vehNum"
						value="<%=expenseInfo.getTruckNumber()%>" disabled />
				</div>
				<div class="form-group">
					<label>Date</label> <input class="form-control" type="date"
						value="<%=expenseInfo.getExpenseDate()%>" name="expenseDate"  required />
				</div>
				<div class="form-group">
					<label>Amount</label> <input class="form-control" type="Number"
						name="amount" value="<%=expenseInfo.getAmount()%>" min="1" required />
				</div>
				<div class="form-group">
					<label>Remark</label> <input class="form-control" type="text"
						name="remarks" value="<%=expenseInfo.getRemarks()%>"  required/>
				</div>


				<button class="btn btn-primary" type="submit">Update
					Expenses</button>
			</form>

		</div>
	</article>




</div>


<jsp:include page="../common/footer.jsp" />