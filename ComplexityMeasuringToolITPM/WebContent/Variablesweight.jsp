<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
        
     <link rel="stylesheet" href="Variablesweight.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
</head>
<body>

<%
		String val = (String) request.getAttribute("Value");
		//ArrayList list = (ArrayList) request.getAttribute("List");
		//out.println(val);
		
%>

         <!--Navigation bar-->
        <section id="nav-bar">
              <nav class="navbar navbar-expand-lg navbar-light">
              <a class="navbar-brand" href="#"><img src="codelogo.png"></a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="index.jsp">HOME</a></li>
					<li class="nav-item"><a class="nav-link" href="CodeUpload.jsp">CODE
							UPLOAD</a></li>
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
    
    <section id="background">
    
       <h1>Variables</h1>
               <form action="CVService" method="post">
        <table  class="table table-striped table-dark" style="margin-top: 40px;">
          <tr>
            <th scope="col">program component</th>
              <th scope="col">weight</th>
          </tr>
             <tbody>
            <tr>
              <th scope="row">Global variable</th>
              <td><input id="Globalvariable" name="Globalvariable" value="2"></td>
             

            </tr>
                 <tr>
              <th scope="row">Local variable </th>
              <td><input id="Localvariable" name="Localvariable" value="1"></td>
             
            </tr>
                 <tr>
              <th scope="row">Primitive data type variable</th>
              <td><input id="Primitivedatatypevariable" name="Primitivedatatypevariable"  value="1"></td>
             

            </tr>
                 <tr>
              <th scope="row">Composite data type variable </th>
              <td><input id="Compositedatatypevariable " name="Compositedatatypevariable" value="2"></td>
              

            </tr>
                 
            </tbody>


        </table>  
       	<input type="hidden" name="userId"  value="<%=val%>">  
      	 <button class="btn btn-success btn-md" type="submit" type="submit" value="<%=val%>" >Save</button>	
       </form>
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