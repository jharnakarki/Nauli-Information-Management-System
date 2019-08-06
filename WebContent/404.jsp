<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 Not Found</title>
</head>
<body>

<% String message = request.getAttribute("404Message") !=  null ? (String) request.getAttribute("404Message") : ""; %>

<% if(message == "") { %>
<p>Oops, could not found the required object</p>

<% } else {
		out.println("<p>" + message + "</p>");
	
   }
%>
</body>
</html>