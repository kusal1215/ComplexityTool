<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
<title>Hotel Management</title>
<link rel="stylesheet" href="CodeUpload.css">
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

	<section id="background">
		<h1>Come Up with Your Code</h1>
		<div class="navbutton">
			<nav>
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-home-tab"
						data-toggle="tab" href="#nav-home" role="tab"
						aria-controls="nav-home" aria-selected="true">Java</a> <a
						class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
						href="#nav-profile" role="tab" aria-controls="nav-profile"
						aria-selected="false">C++</a>
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">

					<div class="container">
						<div class="row services">
							<div class="col-md-6 ">
								<h2
									style="margin-top: 30px; font-family: 'Sofia'; text-align: center">
									Paste Your <big style="color: red;">Code</big> Here <img
										src="giphy.gif" style="height: 60px;">
								</h2>

								<form>
									<div class="form-group">
										<textarea class="form-control"
											id="exampleFormControlTextarea1" rows="7"
											style="margin-top: 30px;"
											placeholder="place your code code here....."></textarea>
									</div>
									<div class="text-center">
										<button type="button" class="btn btn-success btn-lg" style="">Calculate</button>
									</div>
								</form>
							</div>

							<div class="col-md-6">
								<h2
									style="margin-top: 30px; font-family: 'Sofia'; text-align: center">
									Browse Your <big style="color: red;">File</big> Here <img
										src="giphy.gif" style="height: 60px;">
								</h2>
								<br>

								<form action="codeContent" method="post"
									enctype="multipart/form-data">
									<!--  <input type="text" name="description" /> -->
									<input type="file" name="file" class="btn btn-primary"
										style="margin-left: 50px;" /> <input type="submit"
										class="btn btn-success" />
								</form>
							</div>
						</div>
					</div>
				</div>

				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">

					<div class="container">
						<div class="row services">
							<div class="col-md-6 ">
								<h2
									style="margin-top: 30px; font-family: 'Sofia'; text-align: center">
									Paste Your <big style="color: red;">Code</big> Here <img
										src="giphy.gif" style="height: 60px;">
								</h2>

								<form>
									<div class="form-group">
										<textarea class="form-control"
											id="exampleFormControlTextarea1" rows="7"
											style="margin-top: 30px;"
											placeholder="place your code code here....."></textarea>
									</div>
									<div class="text-center">
										<button type="button" class="btn btn-success btn-lg" style="">Calculate</button>
									</div>
								</form>
							</div>

							<div class="col-md-6">
								<h2
									style="margin-top: 30px; font-family: 'Sofia'; text-align: center">
									Browse Your <big style="color: red;">File</big> Here <img
										src="giphy.gif" style="height: 60px;">
								</h2><br>

								<form action="codeContent" method="post"
									enctype="multipart/form-data">
									<!--  <input type="text" name="description" /> -->
									<input type="file" name="file" class="btn btn-primary"
										style="margin-left: 50px;" /> <input type="submit"
										class="btn btn-success" />
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
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