<%@page import="model.SizeComplexity"%>
<%@page import="java.util.*"%>
<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
                    <a class="nav-link" href="#top">HOME</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#about">ABOUT US</a>
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
		ArrayList<SizeComplexity> list2 = (ArrayList) request.getAttribute("List2");
		ArrayList<VariableComplexity> list3 = (ArrayList) request.getAttribute("List3");
		ArrayList<MethodsComplexity> list4 = (ArrayList) request.getAttribute("List4");
		ArrayList<Coupling> list5 = (ArrayList) request.getAttribute("List5");
		ArrayList<ControlStructures> list6 = (ArrayList) request.getAttribute("List6");
		//ArrayList list2 = (ArrayList) request.getAttribute("List2");
	%>

        

     <section id="background" style="">
     <h1>Program Complexity</h1> 
	<div id="table" style="overflow-x: auto;">
            <table class="table table-striped table-dark" style="margin-top: 40px;">
              <thead>
                  <tr>
                        <th scope="col">Line no</th>
                        <td scope="col">Program statements</td>
						<td scope="col">Cs</td>
						<td scope="col">Cv</td>
						<td scope="col">Cm</td>
						<td scope="col">Ci</td>
						<td scope="col">Ccp</td>
						<td scope="col">Ccs</td>
						<td scope="col">TCps</td>
						
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
			 <td width="119"><%=list2.get(i).getLine().replace("@@@", "\"")%></td>
			 <td width="119"><%=list2.get(i).getCountComplexity()%></td>
			 <td width="119"><%=list3.get(i).getComplexity()%></td>
			 <td width="119"><%=list4.get(i).getCm()%></td>
			 <td width="119"><%=list.get(i).getCi()%></td>
			 <td width="119"><%=list5.get(i).getCcp()%></td>
			 <td width="119"><%=list6.get(i).getCcs()%></td>
			 <td width="119"><%=list.get(i).getCi() + list2.get(i).getCountComplexity() + list4.get(i).getCm() + list3.get(i).getComplexity() + list5.get(i).getCcp() + list6.get(i).getCcs()%></td>
		</tr>

		<%
					 }
			}
		%>
              </tbody>
              <tfoot>
              	 <tr>
                        <th scope="col"></th>
                        <td scope="col">Total</td>
						<td scope="col">Cs</td>
						<td scope="col">Cv</td>
						<td scope="col">Cm</td>
						<td scope="col">Ci</td>
						<td scope="col">Ccp</td>
						<td scope="col">Ccs</td>
						<td scope="col">TCps</td>
						
                  </tr>
              </tfoot>
          </table>
          </div>
        
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