<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.TruckInfo"%>
<div class="container">
	<article>
		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
					: "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Add a new Expenses</h2>
		</div>
		<br />
		<div class="row">

			<form method="POST" action="addExpense" enctype="multipart/form-data">
				<div class="form-group">
					<label>Truck Number</label>
					<!--<input class="form-control" type="text"
						name="truckNumber" />   -->
					<select class="form-control" name="truckNumber">

						<option value="NA">--Select Truck--</option>
						<%
							List<TruckInfo> truckInfos = (ArrayList) request.getAttribute("listOfActiveTrucks");

							for (TruckInfo truckInfo : truckInfos) {
								out.println("<option value='" + truckInfo.getTruckNumber() + "'>" + truckInfo.getTruckNumber()
										+ "</option>");
							}
						%>
					</select>
				</div>
				<div class="form-group">
					<label>Date</label> <input class="form-control" type="date"
						name="expenseDate" />
				</div>
				<div class="form-group">
					<label>Amount</label> <input class="form-control" type="Number"
						name="amount" min="1" />
				</div>
				<div class="form-group">
					<label for="receipt">Receipt</label>
					<input type="file" name="receipt" />
				</div>
				<div class="form-group">
					<label>Remark</label>
					<textarea class="form-control" name="remarks"></textarea>
				</div>


				<button class="btn btn-primary" type="submit">Add Expenses</button>
			</form>
		</div>
	</article>
</div>
<jsp:include page="../common/footer.jsp" />