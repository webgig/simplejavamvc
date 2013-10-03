<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <title>Signin</title>
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/application.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
       
            
        <form class="form-signin" action="user/authenticate" method="post">
        <%
         if(session.getAttribute("invalid")!=null && (Boolean)session.getAttribute("invalid")){
            session.setAttribute("invalid", false);
        %>
        <div class="alert alert-danger">
            <strong>Authentication Failure!</strong><br/> Invalid Username or Password
        </div>
        <%
         }
        %>
        
        <%
         if(session.getAttribute("success")!=null){
        %>
        <div class="alert alert-danger">
            <%=session.getAttribute("success")%>
        </div>
        <%
          session.removeAttribute("success");
        }
        %>
        
        <h2 class="form-signin-heading">Please sign in</h2>
        <input  name="username" type="text" class="form-control" placeholder="Email address" autofocus>
        <input  name="password" type="password" class="form-control" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <span><a href="user/register">Register</a></span>
      </form>

    </div>
        
  </body>
</html>
