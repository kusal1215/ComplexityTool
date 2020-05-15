<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="couplingweight.css">
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
	
	%>

	<!--Navigation bar-->
	<section id="nav-bar">
		<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-brand" href="#"><img src="codelogo.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="index.jsp">HOME</a></li>
					<li class="nav-item"><a class="nav-link" href="CodeUpload.jsp">CODE
							UPLOAD</a></li>
					<li class="nav-item"><a class="nav-link" href="#services">SERVICES</a>
					</li>
					<li class="nav-item"><a class="nav-link " href="#contact">CONTACT</a>
					</li>
				</ul>
			</div>
		</nav>
	</section>

	<section id="background">

		<h1>Coupling</h1>

		<form action="CouplingService" method="post">
			<table class="table table-striped table-dark"
				style="margin-top: 40px;">


				<tr>
					<th scope="col">Coupling Type</th>
					<th scope="col">weight</th>
				</tr>
				<tbody>
					<tr>
						<th scope="row">A recursive call</th>
						<td><input id="row1" name="row1" value="2"></td>


					</tr>
					<tr>
						<th scope="row">A regular method calling another regular
							method in same file</th>
						<td><input id="row2" name="row2" value="2"></td>

					</tr>
					<tr>
						<th scope="row">A regular method calling another regular
							method in different file</th>
						<td><input id="row3" name="row3" value="3"></td>

					</tr>
					<tr>
						<th scope="row">A regular method calling recursive method in
							the same file</th>
						<td><input id="row4" name="row4" value="3"></td>


					</tr>
					<tr>
						<th scope="row">A regular method calling recursive method in
							the different file</th>
						<td><input id="row5" name="row5" value="4"></td>

					</tr>


					<tr>
						<th scope="row">A recursive method calling another recursive
							method in the same file</th>
						<td><input id="row6" name="row6" value="4"></td>


					</tr>



					<tr>
						<th scope="row">A recursive method calling another recursive
							method in the different file</th>
						<td><input id="row7" name="row7" value="5"></td>

					</tr>


					<tr>
						<th scope="row">A recursive method calling regular method in
							the same file</th>
						<td><input id="row8" name="row8" value="3"></td>

					</tr>



					<tr>
						<th scope="row">A recursive method calling regular method in
							the different file</th>
						<td><input id="row9" name="row9" value="4"></td>

					</tr>

					<tr>
						<th scope="row">A regular method referencing global variable
							in the same file</th>
						<td><input id="row10" name="row10" value="1"></td>

					</tr>

					<tr>
						<th scope="row">A regular method referencing global variable
							in the different file</th>
						<td><input id="row11" name="row11" value="2"></td>

					</tr>

					<tr>
						<th scope="row">A recursive method calling referencing global
							variable in the same file</th>
						<td><input id="row12" name="row12" value="1"></td>

					</tr>


					<tr>
						<th scope="row">A recursive method calling referencing global
							variable in the different file</th>
						<td><input id="row13" name="row13" value="2"></td>

					</tr>



				</tbody>

			</table>
			<input type="hidden" name="weightId" value="<%=val%>">
			<button class="btn btn-success btn-md" type="submit" type="submit">Save</button>
		</form>
	</section>

	<!----Footer-->
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