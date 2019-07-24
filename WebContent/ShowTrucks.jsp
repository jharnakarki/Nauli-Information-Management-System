<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nauli IMS - Show Trucks</title>
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
					<li class="nav-item active"><a class="nav-link" href="#">Home</a>
					</li>
					
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Vehicle </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="/ShowTrucks">Show Vehicle</a>
							<a class="dropdown-item" href="/AddTruck">Add Vehicle</a>
						</div>
					</li>
						
						
					<li class="nav-item active"><a class="nav-link"
						href="/AddTruck">Add Vehicle</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Trip </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="NewTrip.html">Add Trip</a> <a
								class="dropdown-item" href="EditTrips.java">Edit Trip</a>
						</div></li>
					<li class="nav-item active"><a class="nav-link"
						href="Employee.html">Add Employee</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="Expense.html">Add Expense</a></li>
				</ul>
			</div>
		</div>

	</nav>
	<div class="container">
		<article>
			<div class="row">
				<h2>Trucks</h2>
			</div>
			
			<div class="row">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Truck Number</th>
							<th>Make</th>
							<th>Model</th>
							<th>Capacity</th>
							<th>Tyres</th>
							<th>Year</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
						
						<tr>
					</tbody>
				</table>
			</div>
			
		</article>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>