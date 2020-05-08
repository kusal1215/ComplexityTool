<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="UserPanel.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Sofia'
	rel='stylesheet'>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<%
		String val = (String) request.getAttribute("Value");
		//ArrayList list = (ArrayList) request.getAttribute("List");
		
%>

	<!--Navigation bar-->
	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-brand" href="#"><img src="image/codelogo.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#top">HOME</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#about">ABOUT
							US</a></li>
					<li class="nav-item"><a class="nav-link" href="#services">SERVICES</a>
					</li>
					<li class="nav-item"><a class="nav-link " href="#contact">CONTACT</a>
					</li>
				</ul>
			</div>
		</nav>
	</section>

	<div id="background">

		<table class="table">

			<div class="card border-primary mb-3 border">
				<div class="card-body text-primary">
					<img class="image" src="image/2.jpg">

					<form action="PassSize" method="post">
						<button class="card border-primary mb-3 border" type="submit"
							name="submit" value="<%=val%>"
							style="text-decoration-style: solid; padding: 10px 70px 8px 70px; margin: 0 20px 0 10px">
							<font color=" #007bff">SIZE</font>
						</button>
					</form>

				</div>
			</div>


			<div class="card border-primary mb-3 border">
				<div class="card-body text-primary">
					<img class="image" src="image/2.jpg">

					<form action="PassVariable" method="post">
						<button class="card border-info mb-3 border" type="submit"
							name="submit" value="<%=val%>"
							style="text-decoration-style: solid; padding: 10px 70px 8px 70px; margin: 0 20px 0 10px">
							<font color=" #007bff">VARIABLES</font>
						</button>
					</form>

				</div>
			</div>





			<div class="card border-success mb-3 border">
				<div class="card-body text-primary">
					<img class="image" src="image/3.jpg">

					<form action="CmService" method="post">
						<button class="card border-success mb-3 border	" type="submit"
							name="submit" value="<%=val%>"
							style="text-decoration-style: solid; padding: 10px 70px 8px 70px; margin: 0 20px 0 10px">
							<font color=" #007bff">METHODS</font>
						</button>
					</form>

				</div>
			</div>




			<div class="card border-primary mb-3 border">
				<div class="card-body text-primary">
					<img class="image" src="image/4.jpg">

					<form action="ciservice" method="POST">
						<button class="card border-info mb-3 border" type="submit"
							name="submit" value="<%=val%>"
							style="text-decoration-style: solid; padding: 10px 70px 8px 70px; margin: 0 20px 0 10px">
							<font color=" #007bff">INHERITANCE</font>
						</button>
					</form>

				</div>
			</div>




			<div class="card border-warning mb-3 border">
				<div class="card-body text-primary">
					<img class="image" src="image/1.jpg">

					<form action="CouplingService" method="post">
						<button class="card border-warning mb-3 border" type="submit"
							name="submit" value="<%=val %>"
							style="text-decoration-style: solid; padding: 10px 70px 8px 70px; margin: 0 20px 0 10px">
							<font color=" #007bff">COUPLING</font>
						</button>
					</form>

				</div>
			</div>




			<div class="card border-info mb-3"
				style="max-width: 18rem; margin: 70px 0 0 130px; border-radius: 10px; float: left">
				<div class="card-body text-primary">
					<img class="image" src="image/2.jpg">

					<form action="ControlStructureService" method="post">
						<button class="card border-info mb-3 border" type="submit"
							name="submit" value="<%=val %>"
							style="text-decoration-style: solid; padding: 10px 20px 8px 20px; margin: 0 20px 0 5px">
							<font color=" #007bff">CONTROL STRUCTURE</font>
						</button>
					</form>

				</div>
			</div>




			<div class="card border-danger mb-3"
				style="max-width: 18rem; margin: 70px 0 100px 130px; border-radius: 10px; float: left">
				<div class="card-body text-primary">
					<img class="image" src="image/1.jpg">

					<form action="" method="post">
						<button class="card border-danger mb-3 border" type="submit"
							name="submit" value=""
							style="text-decoration-style: solid; padding: 10px 70px 8px 70px; margin: 0 20px 0 10px">
							<font color=" #007bff">COMPLEXITY</font>
						</button>
					</form>

				</div>
			</div>

		</table>

	</div>
	<section id="footer">
		<div class="container text-center">
			<h5>Payment Methods</h5>
			<p>Payment methods we accept:</p>
			<i class="fa fa-cc-amex"></i> <i class="fa fa-cc-visa"></i> <i
				class="fa fa-cc-jcb"></i> <i class="fa fa-cc-mastercard"></i> <i
				class="fa fa-cc-diners-club"></i>
		</div>
	</section>


</body>
</html>