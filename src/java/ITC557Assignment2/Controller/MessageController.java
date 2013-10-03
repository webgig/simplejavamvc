/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Controller;

import ITC557Assignment2.Entity.MessageEntity;
import ITC557Assignment2.Entity.UserEntity;
import ITC557Assignment2.Service.MessageService;
import ITC557Assignment2.Service.UserService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author webgig
 */
public class MessageController  extends AbstractController {
    private MessageService _msgService;
    private UserService _userService;

    
    public MessageController(HttpServletRequest request , HttpServletResponse response){
        super.setRequest(request);
        super.setResponse(response);
               
        _setMessageService(new MessageService());
        _setUserService(new UserService());

    }
    
    
    public void indexAction() throws ServletException, IOException {

        
        
    // try{
       //this.getRequest().getRequestDispatcher("test.jsp").forward(this.getRequest(),this.getResponse());
     //} catch(Exception e ) {
            
     //}
     
    }
    
    public void inboxAction() throws ServletException, IOException {
        
        //UserEntity current_user = (UserEntity)getRequest().getSession().getAttribute("current_user");
        //super.getResponse().getWriter().print(current_user.getUsername());
        getRequest().getRequestDispatcher("/main.jsp").forward(this.getRequest(),this.getResponse());
            
    }
    
    public void sentAction() throws ServletException, IOException {
        
        
       getRequest().getRequestDispatcher("main.jsp").forward(this.getRequest(),this.getResponse());
        
     
    }  
    
    
    public void sendAction() throws ServletException, IOException {
        
        String view = "/main.jsp";
     
        getRequest().getSession().setAttribute("error",null);
        //super.getResponse().getWriter().print(getRequest().getParameter("to").toString());
        
        if("POST".equals(this.getRequest().getMethod()))   { 

            try{
                // Get the current_user from sesion
               UserEntity    u,current_user = (UserEntity)getRequest().getSession().getAttribute("current_user");
               MessageEntity msg;
                
                
               String[] to = getRequest().getParameter("to").toString().split(",");
               String[] cc = getRequest().getParameter("cc").toString().split(",");
               //super.getResponse().getWriter().print(to[]);
                //super.getResponse().getWriter().print(u.getId());
                
                       
                 msg  = new MessageEntity();
                
                 
                 msg.setUserId(current_user.getId())
                    .setSubject(getRequest().getParameter("subject").toString())
                    .setMessage(getRequest().getParameter("message").toString())
                    .setStatus(1);
               
                 msg  = this._getMessageService().create(msg,getResponse().getWriter());
                 
                 msg.setCc(0);
                 msg.setTo(0);
                // Create Recipients 
                if(msg.getId()!=0){
                    // To
                   
                   for(int i = 0; i < to.length;i++){
                      u    = this._getUserService().findByEmailOrUsername(to[i], getResponse().getWriter());
                      msg.setTo(u.getId());
                      msg.setCc(0);
                      this._getMessageService().createReceipient(msg,getResponse().getWriter());
                   } 
                   
                   //CC
                   
                   for(int i = 0; i < cc.length;i++){
                      super.getResponse().getWriter().print(cc[i]);
                      u    = this._getUserService().findByEmailOrUsername(cc[i], getResponse().getWriter());
                      super.getResponse().getWriter().print(u.getId());
                        msg.setTo(0);
                      msg.setCc(u.getId());
                      this._getMessageService().createReceipient(msg,getResponse().getWriter());
                   } 
                }

               
                  //getRequest().getSession().setAttribute("success", "User registerd successfully!");
                  //getResponse().sendRedirect("/ITC557Assignment2/main.jsp");
                  //return;
                
                
            } catch(Exception e) {
             //  getRequest().getSession().setAttribute("error", e.getMessage());
               super.getResponse().getWriter().print("Controller"+e.getMessage());
               e.printStackTrace();
           }   
            
        } else {  
            view = "/main.jsp";
        }
       
        //getRequest().getRequestDispatcher(view).forward(getRequest(),getResponse());
        return;
      
    } 
    
    public void trashAction() throws ServletException, IOException {
        
        
        getRequest().getRequestDispatcher("main.jsp").forward(this.getRequest(),this.getResponse());
     
    }
    
    public String testAction(){
    
     return "IndexController testAction";
  
    }
    
    
     
    protected void _setMessageService(MessageService _msgService){
        this._msgService = _msgService;
    }
    
    protected MessageService _getMessageService(){
        return this._msgService;
    }
    
    
    protected void _setUserService(UserService _userService){
        this._userService = _userService;
    }
    
    protected UserService _getUserService(){
        return this._userService;
    }
    
    
    
}
