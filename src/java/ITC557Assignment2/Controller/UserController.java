/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Controller;

import static ITC557Assignment2.Controller.AbstractController.getServletContext;
import ITC557Assignment2.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.PrintWriter;

import ITC557Assignment2.Service.*;
import ITC557Assignment2.Entity.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
/**
 *
 * @author webgig
 */
public class UserController extends AbstractController  {
    private UserService _userService;
    
    public UserController(HttpServletRequest request , HttpServletResponse response){
        super.setRequest(request);
        super.setResponse(response);
        
        _setUserService(new UserService());
    }
    
    public String indexAction(String s){
     
        return "Sagar";
    }
    
    public void registerAction() throws ServletException, IOException {
        String view = "/register.jsp";
     
        getRequest().getSession().setAttribute("error",null);
        
        if("POST".equals(this.getRequest().getMethod()))   { 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          
            
            try{
                
                if(_getUserService().userExists(getRequest().getParameter("username").toString(), getResponse().getWriter()))
                   throw new Exception("User with the given username already exists! Please try a different name!");
                
                
                UserEntity user = new UserEntity();
                
                //Format the date 
                Date d    = dateFormat.parse(getRequest().getParameter("dob"));
                
                
                user.setFName(getRequest().getParameter("fname").toString())
                    .setLName(getRequest().getParameter("lname").toString())
                    .setAddress(getRequest().getParameter("address").toString())
                    .setUserName(getRequest().getParameter("username").toString())
                    .setPassword(getRequest().getParameter("password").toString())
                    .setAddress(getRequest().getParameter("address").toString())
                    .setEmail(getRequest().getParameter("email").toString())
                    .setPhone(getRequest().getParameter("phone").toString())
                    .setDob(d);
                    
                
                user = this._getUserService().create(user,getResponse().getWriter());

                if(user==null)                     
                   throw new Exception("Error while registering you!");

                  getRequest().getSession().setAttribute("success", "User registerd successfully!");
                  getResponse().sendRedirect("/ITC557Assignment2/index.jsp");
                  return;
                
                
            } catch(Exception e) {
               getRequest().getSession().setAttribute("error", e.getMessage());
               e.printStackTrace();
            }   
            
        } else {  
            view = "/register.jsp";
        }
       
        getRequest().getRequestDispatcher(view).forward(getRequest(),getResponse());
        return;
    }
    
    public String updateAction(){
       return "UserController updateAction";
    }
    
    public void authenticateAction() throws ServletException, IOException {
        HttpSession session = null;
             
        if(this.getRequest()!=null)
            session = super.getRequest().getSession();
        
         String username = super.getRequest().getParameter("username");
         String password = super.getRequest().getParameter("password");
         
         PrintWriter out =  getResponse().getWriter();

         UserEntity user = _getUserService().validate(username, password,out);

         
         
         if(user!=null){
            super.getRequest().getSession().setAttribute("current_user", user);            
            super.getResponse().sendRedirect("/ITC557Assignment2/message/inbox");
         } else {
            super.getRequest().getSession().setAttribute("invalid", true);            
            super.getResponse().sendRedirect("/ITC557Assignment2/index.jsp"); 

         }
         
         
         
    }
    
    
    protected void _setUserService(UserService _userService){
        this._userService = _userService;
    }
    
    protected UserService _getUserService(){
        return this._userService;
    }
    
    
    
    
    
}
