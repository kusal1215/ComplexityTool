<%@page import="java.util.*"%>
<%@page import="model.InheritanceComplexity" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="Inhetritance.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    
          <!--Navigation bar-->
        <section id="nav-bar">
              <nav class="navbar navbar-expand-lg navbar-light">
              <a class="navbar-brand" href="#"><img src="codelogo.png"></a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="ITPMHome/index.jsp">HOME</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="UserPanel.jsp">USER PANEL</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#services">SERVICES</a>
                  </li>
                     <li class="nav-item">
                    <a class="nav-link " href="#contact">CONTACT</a>
                  </li>
                </ul>
              </div>
            </nav>   
        </section>
        
        <%
		String val = (String) request.getAttribute("Value");
		ArrayList<InheritanceComplexity> list = (ArrayList) request.getAttribute("List");
		//ArrayList list2 = (ArrayList) request.getAttribute("List2");
	%>

        

     <section id="background" style="">
     <h1>Inhetitance</h1> 

            <table class="table table-striped table-dark" style="margin-top: 40px;">
              <thead>
                  <tr>
                        <th scope="col">Count</th>
                        <td scope="col"> Class Name</td>
						<td scope="col">indirect</td>
						<td scope="col">direct</td>
						<td scope="col">total</td>
						<td scope="col">Ci</td>
                  </tr>
              </thead>
              <tbody>
               </tr>
			
		<%
			//if ((list != null)&&(list2 != null)) {
			if ((list != null)) {
	
				for (int i = 0; i < list.size(); i++) {
		%>

		<tr>
		
			 <td width="119"><%=i+1%></td>
			 <td width="119"><%=list.get(i).getLine()%></td>
			 <td width="119"><%=list.get(i).getInditect()%></td>
			 <td width="119"><%=list.get(i).getDirect()%></td>
			 <td width="119"><%=list.get(i).getTotal()%></td>
			 <td width="119"><%=list.get(i).getCi()%></td>
		</tr>

		<%
					 }
			}
		%>
              </tbody>
          </table>
        
    </section>  
    
                        <!----Footer-->
        <section id="footer">
            <div class="container text-center">
                <h5>Payment Methods</h5>
                <p>Payment methods we accept:</p>
                <i class="fa fa-cc-amex"></i>
                <i class="fa fa-cc-visa"></i>
                <i class="fa fa-cc-jcb"></i>
                <i class="fa fa-cc-mastercard"></i>
                <i class="fa fa-cc-diners-club"></i>
            </div>
        </section>

</body>
</html>