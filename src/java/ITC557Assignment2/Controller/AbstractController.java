/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 *
 * @author webgig
 */
public class AbstractController {
    private  HttpServletRequest   request;
    private  HttpServletResponse  response;
    private  RequestDispatcher    dispatcher;
    private static ServletContext context;  

    
    public void setRequest(HttpServletRequest request){
        this.request =   request;
    }
    
    
    public void setResponse(HttpServletResponse response){
        this.response = response;
    }
    
    public void setDispatcher(RequestDispatcher   dispatcher){
        this.dispatcher = dispatcher;
    }
    
    
    public HttpServletRequest getRequest(){
        return request;
    }
    
    public HttpServletResponse getResponse(){
        return response;
    }
   
    public RequestDispatcher getDispatcher(){
        return dispatcher;
        //return getServletContext().getRequestDispatcher();
    }
    
    //public RequestDispatcher getDispatcher(){
     //   return dispatcher;
    //}
    /* Called by Listener */  
    public static void setServletContext(ServletContext context){  
        AbstractController.context = context;  
    }  
    /* Use this method to access context from any location */  
    public static ServletContext getServletContext(){  
        return AbstractController.context;  
    }  
    
    
}
