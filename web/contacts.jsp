<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/ITC557Assignment2/assets/ico/favicon.png">
    <title>Main</title>
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
    <header>
        <nav class="super"> 
            <a href="#">Search</a>
            <a href="#">Images</a>
            <a href="#">Maps</a>
            <a href="#">Play</a>
            <a href="#">YouTube</a>
            <a href="#">News</a>
        </nav>
        
        <div class="search">
            <img src="https://ssl.gstatic.com/ui/v1/icons/mail/logo_default.png" id="logo" />
            <div class="input-append">
                <input class="input-xlarge" id="appendedDropdownButton" type="text" />
                <div class="btn-group">
                    <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Search <span class="caret"></span></button>
                </div>
            </div>
            <nav class="pull-right"> 
                <a href="logout">Logout</a>
            </nav>
        </div>
        
        
        <div class="controls">
            <h1>Gmail</h1>

            <button class="btn dropdown-toggle" data-toggle="dropdown">
                <input type="checkbox" /><span class="caret"></span>
            </button>
            
            <button class="btn">Refresh</button>
            <button class="btn dropdown-toggle" data-toggle="dropdown">More<span class="caret"></span></button>
        </div>
         
    </header>
    
    <div id="side">
        <button class="btn btn-danger" id="compose-button"><a><i class="icon-edit"></i></a> Compose</i></button>
        <ul class="nav nav-list">
            <li class="active"><a id="inbox"><i class="icon-envelope"></i>Inbox</a></li>
            <li><a  id="sent"><i class="icon-envelope"></i>Sent</a></li>
            <li><a  id="trash"><i class="icon-trash"></i>Trash</a></li>
            <li><a id="inbox"><i class="icon-user"></i>Contacts</a></li>

        </ul>
    </div>

    <div id="content">
        <div id="compose" style="display:none">
            
            <form class="well" action="send" method="post">
                <div class="row">
                     <div class="span12">
                        
                        <div class="input-prepend">
                           <span class="add-on"><i class="icon-envelope"></i> To</span>
                           <input name="to" type="text" id="inputIcon" class="span2" style="" placeholder="Email address or Username">
                        </div>

                        <div class="input-prepend">
                           <span class="add-on"><i class="icon-envelope"></i> CC</span>
                           <input name="cc" type="text" id="inputIcon" class="span2" style="" placeholder="Email address or Username">
                        </div>

                        <div class="input-prepend">
                           <span class="add-on"><i class="icon-question-sign"></i> Subject</span>
                           <input name="subject" type="text" id="inputIcon" class="span2" style="" placeholder="Subject">
                        </div>

                         <label><i class="icon-comment"></i>  Message</label>
                        <textarea name="message" id="message" class="" rows="10"></textarea>
                    </div>
                </div>
                     <button type="submit" class="btn btn-primary pull-right">Send</button>
                </form>
            
            
        </div>
        
        <div id="messagelist">
        
            <h2>Unread</h2>
            <div class="unread-message">Woohoo! You've read all the messages in your inbox.</div>
            <h2>Everything Else</h2>
        
                <table class="table table-striped">
                <tr>
                    <th>Entry Header 1</th>
                    <th>Entry Header 2</th>
                    <th>Entry Header 3</th>
                    <th>Entry Header 4</th>
                </tr>
                <tr class="success">
                    <td>Entry First Line 1</td>
                    <td>Entry First Line 2</td>
                    <td>Entry First Line 3</td>
                    <td>Entry First Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Line 1</td>
                    <td>Entry Line 2</td>
                    <td>Entry Line 3</td>
                    <td>Entry Line 4</td>
                </tr>
                <tr>
                    <td>Entry Last Line 1</td>
                    <td>Entry Last Line 2</td>
                    <td>Entry Last Line 3</td>
                    <td>Entry Last Line 4</td>
                </tr>
            </table>
        </div>
    </div>
      
<footer>Footer</footer>
  </div>
      <script src="/ITC557Assignment2/assets/js/jquery.js"></script>
      <script src="/ITC557Assignment2/assets/js/application.js"></script>
  </body>
</html>
