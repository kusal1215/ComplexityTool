<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="coupling.css">
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

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


	<%
		ArrayList lines = (ArrayList) request.getAttribute("lines");
	ArrayList line = (ArrayList) request.getAttribute("num");
	ArrayList Nr = (ArrayList) request.getAttribute("Nr");
	ArrayList Wr = (ArrayList) request.getAttribute("Wr");
	ArrayList Nmcms = (ArrayList) request.getAttribute("Nmcms");
	ArrayList Wmcms = (ArrayList) request.getAttribute("Wmcms");
	ArrayList Nrmcms = (ArrayList) request.getAttribute("Nrmcms");
	ArrayList Wrmcms = (ArrayList) request.getAttribute("Wrmcms");
	ArrayList Nrmcrms = (ArrayList) request.getAttribute("Nrmcrms");
	ArrayList Wrmcrms = (ArrayList) request.getAttribute("Wrmcrms");
	ArrayList Nmcrms = (ArrayList) request.getAttribute("Nmcrms");
	ArrayList Wmcrms = (ArrayList) request.getAttribute("Wmcrms");
	ArrayList Nmcrmd = (ArrayList) request.getAttribute("Different");
	%>

	<section id="background" style="">
		<h1>Coupling</h1>
		<div id="table" style="overflow-x: auto;">
			<table class="table table-striped table-dark"
				style="margin-top: 40px;">
				<thead>
					<tr>
						<th scope="col">Line No</th>
						<th scope="col">Program Statements</th>
						<th scope="col">Nr</th>
						<th scope="col">Nmcms</th>

						<th scope="col">Nmcmd</th>

						<th scope="col">Nmcrms</th>

						<th scope="col">Nmcrmd</th>
						<th scope="col">Nrmcrms</th>

						<th scope="col">Nrmcrmd</th>

						<th scope="col">Nrmcms</th>

						<th scope="col">Nrmcmd</th>

						<th scope="col">Nrmrgvs</th>

						<th scope="col">Nmrgvd</th>

						<th scope="col">Nrmrgvs</th>

						<th scope="col">Nrmrgvd</th>

						<th scope="col">Ccp</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (lines != null) {

						for (int i = 0; i < lines.size(); i++) {
					%>


					<tr>

						<td width="60"><%=line.get(i)%></td>

						<td width="60"><%=lines.get(i)%></td>

						<td width="60"><%=Nr.get(i)%></td>
						<%-- <td width="119"><%=Wr.get(i)%></td> --%>


						<td width="60"><%=Nmcms.get(i)%></td>
						<%-- <td width="119"><%=Wmcms.get(i)%></td> --%>
						<td width="60"><%=Nmcrmd.get(i)%></td>

						<td width="60"><%=Nrmcms.get(i)%></td>
						<%-- <td width="119"><%=Wrmcms.get(i)%></td> --%>
						<td width="60"><%=Nmcrmd.get(i)%></td>

						<td width="60"><%=Nrmcrms.get(i)%></td>
						<%-- <td width="119"><%=Wrmcrms.get(i)%></td> --%>
						<td width="60"><%=Nmcrmd.get(i)%></td>

						<td width="60"><%=Nmcrms.get(i)%></td>
						<%-- <td width="119"><%=Wmcrms.get(i)%></td> --%>
						<td width="60"><%=Nmcrmd.get(i)%></td>

						<%-- <td width="119"><%=lines.get(i)%></td> --%>


					</tr>
					<%
						}
					}
					%>
					<!-- <tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
				</tr>

				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>Larry</td>
					<td>the Bird</td>
					<td>@twitter</td>
				</tr>
				
 -->
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