/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.*;
import java.io.*;
import ITC557Assignment2.Controller.*;
import ITC557Assignment2.Service.AbstractDbService;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;

import java.lang.*;

/**
 *
 * @author webgig
 */
public class Router {
    public HttpServletRequest request;
    public HttpServletResponse response;
    private static ServletContext context;  
    

    public static final String host = "/";
    public static final String home = "/";
    public static final String login = "/login";
    public static final String logout = "/logout";
            
    
    public  Router(HttpServletRequest request, HttpServletResponse response){
      this.request  = request;
      this.response = response;
    }
    
    /*private static void setRoutes()
    {       
        if(routes == null)
        {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
            routes.put("entrar", host + entrar);
            routes.put("sair", host + sair);
        }
    }   

    public static HashMap<String, String> getRoutes()
    {
        setRoutes();

        return routes;
    }

    public static String getRoute(String destin)
    {
        setRoutes();

        return routes.get(destin);
    }
    */
    public Object route(){
      String path = request.getPathInfo().toString();
        
      String[] paths = path.split("/");
      
      String controllerSufix  = "Controller";
      String controllerClass  = "Index";
      String controllerAction = "index";
      String actionParam      =  null;
      
      if(paths.length>=1){
          controllerClass = paths[0];
          
          if(paths.length>=2){
           controllerAction = paths[1];
          
           if(paths.length>=3)
             actionParam  = paths[2]; 
          }
      }
      
      String fullyQualifiedControllerClass = "ITC557Assignment2.Controller."+Character.toUpperCase(controllerClass.charAt(0)) + controllerClass.substring(1) + "Controller";

      String fullyQualifiedControllerAction =  controllerAction + "Action";

      try{
            
        Class<?> c = Class.forName(fullyQualifiedControllerClass);
         
        //Step2 - instantiate an object of the class abov
        Object o = c.newInstance();
        //Prepare array of the arguments that your function accepts, lets say only one string here
        Class[] paramTypes = new Class[1];
        paramTypes[0]= String.class;

        //Instantiate an object of type method that returns you method name
        Method m = c.getMethod(fullyQualifiedControllerAction, paramTypes);
       
        //invoke method with actual params
        Object result = m.invoke(o, actionParam);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

        return result;  
            
            
      } catch (Exception e){
         e.printStackTrace();
      }
      
      return null;
      
    }
      
   /* Called by Listener */  
    public static void setServletContext(ServletContext context){  
        Router.context = context;  
    }  
    /* Use this method to access context from any location */  
    public static ServletContext getServletContext(){  
        return Router.context;  
    }  
    
     
}
