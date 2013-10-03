/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ITC557Assignment2.Controller.*;

/**
 *
 * @author webgig
 */
public class Dispatcher extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        //getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                              PrintWriter out = response.getWriter();
          route(request,response,out);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                PrintWriter out = response.getWriter();
        //Router router = new Router(request,response);
        

    }
    
    public void  route(HttpServletRequest request,HttpServletResponse response,  PrintWriter out)    
            throws ServletException, IOException {

      String uri = request.getPathInfo().toString();
        
      if(uri.startsWith("/")){
         //uri = uri.substring(1);
      }
      
      
      
      String controllerSufix  = "Controller";
      String controllerClass  = "Index";
      String controllerAction = "index";
      String actionParam      =  null;
      String[] paths = null;
      
      if(uri.length()>0)
         paths = uri.split("/");

      
      controllerClass = getServletName();

      if(paths.length>0){
             if(!paths[1].equals(""))
              controllerAction = paths[1];
          
         if(paths.length>2){
             if(!paths[2].equals(""))
              actionParam  = paths[2]; 
          }
      }
      
      
      out.print(controllerClass);
      out.print(controllerAction);

      
      if(controllerClass.equals("user")){
         UserController u =  new UserController(request,response);
          
         if(controllerAction.equals("register")){
             u.registerAction();
         } else if(controllerAction.equals("update")){
             u.updateAction();
         } else if(controllerAction.equals("authenticate")){
             u.authenticateAction();
         }
         
      } else if(controllerClass.equals("message")){
         MessageController m =  new MessageController(request,response);

          if(controllerAction.equals("sent"))
             m.sentAction();
          else if(controllerAction.equals("trash"))
             m.trashAction();
          else if(controllerAction.equals("inbox"))
             m.inboxAction();
          else if(controllerAction.equals("send"))
             m.sendAction();
         
      } else {
         IndexController i =  new IndexController(request,response);
          
         if(controllerAction.equals("create")){
             i.indexAction();
         }// else
            // request.getRequestDispatcher("index.jsp").forward(request,response);
                // i.indexAction();
      }
      
     
     //return "Sgr";
    }
    
    
    public Object  route1(HttpServletRequest request,HttpServletResponse response,  PrintWriter out ){
      String uri = request.getPathInfo().toString();
        
      if(uri.startsWith("/")){
         uri = uri.substring(1);
      }
              
      String[] paths = uri.split("/");
      
      String controllerSufix  = "Controller";
      String controllerClass  = "Index";
      String controllerAction = "index";
      String actionParam      =  null;
      
      
      
      //out.print(path);
      
      //for(int i = 0; i< paths.length;i++)
        //out.print("<br>" + i + paths[i]+"<br>" );
      
        
        
        
       if(paths.length>0){
           
          if(!paths[0].equals(""))
              controllerClass = paths[0];
          
          if(paths.length>1){       
             if(!paths[1].equals(""))
              controllerAction = paths[1];
          
         if(paths.length>2){
             if(!paths[2].equals(""))
              actionParam  = paths[2]; 
          }
           
        }          
       }
      
     // out.print(paths.length);
       //out.print(controllerAction);

     
      String fullyQualifiedControllerClass  = "ITC557Assignment2.Controller."+Character.toUpperCase(controllerClass.charAt(0)) + controllerClass.substring(1) + "Controller";
      String fullyQualifiedControllerAction =  controllerAction + "Action";

      //out.print(fullyQualifiedControllerAction);
     // out.print(fullyQualifiedControllerClass);
      
      try{
            
        Class<?> c = Class.forName(fullyQualifiedControllerClass);
        //Class<?> sc = c.getClass().getSuperclass();

         
        //Step2 - instantiate an object of the class abov
        Object o  = c.newInstance();
        //Object so = sc.newInstance();

        //Prepare array of the arguments that your function accepts, lets say only one string here
        Class[] paramTypes = new Class[1];
        paramTypes[0]= String.class;
        
        c.getClass().getSuperclass().getDeclaredMethod("setRequest", paramTypes).invoke(o, request);
        
        
        //Instantiate an object of type method that returns you method name
        Method m = c.getMethod(fullyQualifiedControllerAction, paramTypes);
        //m.setAccessible(true);
        
        
        //invoke method with actual params
        Object result = m.invoke(o, actionParam);
        
        
        //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

        return result;  
            
            
      } catch (Exception e){
         e.printStackTrace();
      }
     
      
      return 2;
     
    }
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
