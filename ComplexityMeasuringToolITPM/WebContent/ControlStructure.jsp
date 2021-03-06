<%@page import="model.ControlStructures"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control Structure</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="ControlStructure.css">
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



	<%
		
	ArrayList list = (ArrayList) request.getAttribute("List");

	ArrayList<ControlStructures> NCList = (ArrayList) request.getAttribute("NCList");
	%>




	<section id="background" style="">
		<h1>Control Structure</h1>
		<div id="table" style="overflow-x: auto;">
			<table class="table table-striped table-dark"
				style="margin-top: 40px;">
				<thead>
					<tr>
						<th scope="col">Line No</th>
						<th scope="col">Program Statements</th>
						<th scope="col">Wtcs</th>
						<th scope="col">Nic</th>
						<th scope="col">Ccspps</th>
						<th scope="col">Ccs</th>
					</tr>
				</thead>
				<tbody>


					<%
						if (list != null) {

						for (int i = 0; i < list.size(); i++) {
					%>


					<tr>

						<td width="119"><%=NCList.get(i).getLineNo()%></td>
						<td width="119"><%=NCList.get(i).getLine().replace("@@@", "\"")%></td>
						<td width="119"><%=NCList.get(i).getWtcs()%></td>
						<td width="119"><%=NCList.get(i).getNC()%></td>
						<td width="119"><%=NCList.get(i).getCcspps()%></td>
						<td width="119"><%=NCList.get(i).getCcs()%></td>
						
					</tr>

					<%
						}
					}
					%>

					
				</tbody>
			</table>
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