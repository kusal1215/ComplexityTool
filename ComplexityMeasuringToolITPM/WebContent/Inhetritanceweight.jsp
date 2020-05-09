<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
        
     <link rel="stylesheet" href="Inhetritanceweight.css">
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
    
    <section id="background">
    
                <h1>Inheritance</h1>
    <form action="ciservice" method="post">
        <table  class="table table-striped table-dark" style="margin-top: 40px;">
          <tr>
            <th scope="col">program component</th>
              <th scope="col">weight</th>
          </tr>
             <tbody>
            <tr>
              <th scope="row">A class with no inheritance (direct or indirect)</th>
              <td><input id="Keyword" name="Keyword" value="0"></td>
             

            </tr>
                 <tr>
              <th scope="row">A class inheriting (directly or indirectly) from one user-defined class</th>
              <td><input id="Identifer" name="Identifer" value="1"></td>
             
            </tr>
                 <tr>
              <th scope="row">A class inheriting (directly or indirectly) from two user-defined classes</th>
              <td><input id="Operator" name="Operator" value="2"></td>
             

            </tr>
                 <tr>
              <th scope="row">A class inheriting (directly or indirectly) from three user-defined classes</th>
              <td><input id="Number" name="Number" value="3"></td>
              

            </tr>
                 <tr>
              <th scope="row">A class inheriting (directly or indirectly) from more than three user-defined classes</th>
              <td><input id="String" name="String" value="4"></td>
             

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