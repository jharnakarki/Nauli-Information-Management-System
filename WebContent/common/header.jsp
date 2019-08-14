<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nauli</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- bring up fontawesome icons -->
<script src="https://kit.fontawesome.com/b36472b4d3.js"></script>

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
							<a class="dropdown-item" href="addVehicle">Add Vehicle</a> <a
								class="dropdown-item" href="ShowTrucks">Show Vehicle</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Trip </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="addTrip">Add Trip</a> <a
								class="dropdown-item" href="ShowTrips">Show Trip</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Employee</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="addEmployee">Add Employee</a> <a
								class="dropdown-item" href="ShowEmployees">Show Employee</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Expense</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="addExpense">Add Expense</a> <a
								class="dropdown-item" href="ShowExpenses">Show Expenses</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">admin</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="addAdmins">Create Admin</a> <a
								class="dropdown-item" href="ShowAdmin">Show Admin</a> <a
								class="dropdown-item" href="LogoutServlet">logout</a>
						</div></li>

				</ul>
			</div>
		</div>

	</nav>