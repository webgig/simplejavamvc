package ITC557Assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import java.io.*;
import java.util.regex.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.PrintWriter;

public class ValidateUser extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        //store_appForm_variables(session, request);
        
        
        if(validate(request))
           response.sendRedirect("main.jsp");
        else
           response.sendRedirect("index.jsp?invalid=true"); 
        
        
        //if (checking_appForm(session, request)){
            //call a function to add the new user to the database
          //  newUser(session);
         //   //send a redirect to the index page to login
          //  response.sendRedirect("/ITC557Assignment2/index.jsp");
       // } else
         //   response.sendRedirect("/ITC557Assignment2/newUser.jsp"); 
    }
    
    
    
    protected boolean validate(HttpServletRequest request) throws ServletException, IOException {
         HttpSession session = request.getSession(true);
        
         Database db = (Database) getServletContext().getAttribute("db");
         
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
        
         
         try{
            String sql  = "SELECT * FROM users WHERE username=? and password=?";

            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);

            pstmt.clearParameters();

            pstmt.setString(1, username);
            pstmt.setString(2, password);
             
            ResultSet rs  =  pstmt.executeQuery();
            
            if(rs.first()){
               session.setAttribute("username", rs.getString("username"));
               return true;
            } 
            
         } catch(Exception e){
             //return false;
         } 
         
        return false;
    }
    
    
    protected void store_appForm_variables(HttpSession session, HttpServletRequest request){
                //set session variables
                session.setAttribute("username", request.getParameter("username"));
                session.setAttribute("err_username","");
                session.setAttribute("password", request.getParameter("password"));
                session.setAttribute("err_password","");
                session.setAttribute("fname", request.getParameter("fname"));
                session.setAttribute("err_fname","");
                session.setAttribute("lname", request.getParameter("lname"));
                session.setAttribute("err_lname","");
                session.setAttribute("address", request.getParameter("address"));
                session.setAttribute("err_address","");
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("err_email","");
                session.setAttribute("reg_msg","");
    }

    protected boolean checking_appForm(HttpSession session, HttpServletRequest request) throws NumberFormatException{
            
        boolean result = true;
            
            String  reset  = (String)request.getParameter("reset");

            if(reset==null) reset = "";

            String submit = (String)request.getParameter("submit");

            if(submit==null) 
                submit = "";
                //clicked on reset 
            if(reset.equals("Reset")){
                //set session variables to blanks
                session.setAttribute("username", "");
                session.setAttribute("err_username","");
                session.setAttribute("password", "");
                session.setAttribute("err_password","");
                session.setAttribute("fname", "");
                session.setAttribute("err_fname","");
                session.setAttribute("lname", "");
                session.setAttribute("err_lname","");
                session.setAttribute("address", "");
                session.setAttribute("err_address","");
                session.setAttribute("email", "");
                session.setAttribute("err_email","");
                result = false;
            //clicked on submit 
            } else if(submit.equals("Submit")){

                String username =(String) session.getAttribute("username");
                String password =(String) session.getAttribute("password");
                String fname    =(String) session.getAttribute("fname");
                String lname    =(String) session.getAttribute("lname");
                String address  =(String) session.getAttribute("address");
                String email    =(String) session.getAttribute("email");

                //process name
                if(username==null||username.trim().length()==0||username.equals("")){
                    session.setAttribute("err_username","Please type your user name");
                    result=false;
                }


                if(password==null||password.trim().length()==0||password.equals("")){
                    session.setAttribute("err_password","Please type your password");
                    result=false;
                }


                if(fname == null||fname.trim().length()==0||fname.equals("")){
                    session.setAttribute("err_fname","Please type your first name");
                    result = false;
                }

                if(lname == null||lname.trim().length()==0||lname.equals("")){
                    session.setAttribute("err_lname","Please type your last name");
                    result = false;
                } 


                //process address
                if(address == null ||address.trim().length()==0||address.equals("")){
                    session.setAttribute("err_address", "Please type your address"); 
                    result = false;
                }

                if(email == null||email.trim().length()==0||email.equals("")){
                    session.setAttribute("err_name","Please type your email");
                    result = false;
                }

            } 

        return result;
    }

    //add a new user to the database
    protected void newUser(HttpSession session){

        try{
            
            String username = session.getAttribute("username").toString();
            String password = session.getAttribute("password").toString();
            String fname    = session.getAttribute("fname").toString();
            String lname    = session.getAttribute("lname").toString();
            String address  = session.getAttribute("address").toString();
            String email    = session.getAttribute("email").toString();
            
            //Loading Sun's JDBC ODBC Driver 
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
            
            //Connect to playerDB Data source
            Connection theConnection = DriverManager.getConnection("jdbc:odbc:newPlayer", "admin","");

            //sql to add a new player
            String sql = "INSERT INTO user(userId, password, firstName, lastName, address, email) VALUES(?,?,?,?,?,?)";
            //insert a record into the player table.

            PreparedStatement pstmt=theConnection.prepareStatement(sql);pstmt.clearParameters();

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, fname);
            pstmt.setString(4, lname);
            pstmt.setString(5, address);
            pstmt.setString(6, email);
            pstmt.executeUpdate();

            //rsPlayer.close();//Close the result set
            pstmt.close();//Close statement
            theConnection.close(); //Close database Connection
            //redirect to the JSP for displaying player details
            //res.sendRedirect("/displayPlayer.jsp"); 
        } catch(Exception e){
            System.out.println(e.getMessage());
        } //Print trapped error.
         
    }
}