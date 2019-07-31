<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../error.jsp" isErrorPage="false"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.naulitraders.model.EmployeeInfo"%>


<jsp:include page="../common/header.jsp" />
<div class="container">
	<article>
		<%
			Object messageType = (request.getAttribute("messageType") != null) ? request.getAttribute("messageType")
					: "";
			Object message = (request.getAttribute("message") != null) ? request.getAttribute("message") : "";

			EmployeeInfo employeeInfo = (EmployeeInfo) request.getAttribute("employeeInfo");
		%>

		<div class="row alert <%=messageType%>"><%=message%></div>
		<div class="row">
			<h2>Edit Employee</h2>
		</div>
		<br />
		<div class="row">
		
		

			<form method="post"
				action="editEmployee?empId=<%=employeeInfo.getEmpId()%>">

				<!--  tripId is hidden over here so database update can happen -->
				<input type="hidden" name="empId"
					value="<%=employeeInfo.getEmpId()%>" />


				<div class="form-group">
					<label>Name</label> <input class="form-control" type="text"
						name="name" value="<%=employeeInfo.getName()%>" />
				</div>
				<div class="form-group">
					<label>Position</label> <input class="form-control" type="text"
						name="position" value="<%=employeeInfo.getPosition()%>" />
				</div>
				<div class="form-group">
					<label>Phone Number</label> <input class="form-control" type="text"
						name="phoneNumber" min="1" value="<%=employeeInfo.getPhoneNumber()%>" />
				</div>
				<div class="form-group">
					<label>Salary</label> <input class="form-control" type="Number"
						name="salary" min="1" value="<%=employeeInfo.getSalary()%>"/>
				</div>

				<button class="btn btn-primary" type="submit">Update Employee</button>

			</form>
		</div>
	</article>




</div>


<jsp:include page="../common/footer.jsp" />