<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/ITC557Assignment2/assets/ico/favicon.png">
    <title>Signin</title>
    <!-- Bootstrap core CSS -->
    <link href="/ITC557Assignment2/assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/ITC557Assignment2/assets/css/application.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="/ITC557Assignment2/assets/js/html5shiv.js"></script>
      <script src="/ITC557Assignment2/assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
      
    <div class="container">
       
            
      <form class="form-signin" action="register" method="post">
            <%
            if(session.getAttribute("error")!=null){
              
           %>
           <div class="alert alert-danger">
               <%=session.getAttribute("error")%>
           </div>
           <%
            }
           %>
            <h2 class="form-signin-heading">Please provide your details</h2>
            <input  name="fname" type="text" class="form-control" placeholder="First Name" autofocus>
            <input  name="lname" type="text" class="form-control" placeholder="Last Name" autofocus>
            <input  name="email" type="text" class="form-control" placeholder="Email">
            <input  name="username" type="text" class="form-control" placeholder="Username">
            <input  name="password" type="password" class="form-control" placeholder="Password">
            <textarea  name="address" class="" rows="5" cols="50"></textarea>            
            <input  name="phone"   type="text" class="form-control" placeholder="Phone Number">
            <input  name="dob"     type="text" class="form-control" placeholder="Birthdate">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            <span><a href="/ITC557Assignment2/">Login</a></span>
      </form>
        
    </div>
  </body>
</html>