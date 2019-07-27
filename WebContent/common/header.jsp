<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nauli</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="#">Nauli</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="home">Home</a>
					</li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Vehicle </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="ShowTrucks">Show Vehicle</a> <a
								class="dropdown-item" href="addVehicle">Add Vehicle</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Trip </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="NewTrip.jsp">Add Trip</a> <a
								class="dropdown-item" href="EditTrips.jsp">Edit Trip</a>
						</div></li>
					<li class="nav-item active"><a class="nav-link"
						href="addEmployee">Add Employee</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="Expense.jsp">Add Expense</a></li>
				</ul>
			</div>
		</div>

	</nav>