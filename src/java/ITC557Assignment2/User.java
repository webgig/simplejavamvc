/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ITC557Assignment2.*;

/**
 *
 * @author webgig
 */
public class User extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        session.setAttribute("invalid", false);
        
        String servletPath =  request.getPathInfo().toString();  
        PrintWriter out = response.getWriter();
           
        
    }
    
    protected void authenticate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        out.print(session.getAttribute("username"));

        
        /*
         * if(session.getAttribute("username")==null){  
            if(validate(request)){
               response.sendRedirect("/ITC557Assignment2/main.jsp");
            } else {
               response.sendRedirect("/ITC557Assignment2/index.jsp"); 
               session.setAttribute("invalid", true);
            }
        }
        * */
        
            
    
    }
     
    protected boolean validate(HttpServletRequest request) throws ServletException, IOException {
         HttpSession session = request.getSession();
        
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
    
    public void route(HttpServletRequest request){
        String servletPath =  request.getRequestURL().toString();  
       
        //if (servletPath.contains("login")) {  
            // System.out.println("Redirecting...");  
          ///return;  
       // }  
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        Router router = new Router(request,response);
        String path = request.getPathInfo().toString();
        
        //Class contextClass = PageContextHelper.getContextBoundedClass( "authentication");

        //out.print(123);
        //out.print(router.route());
        
        //out.print(paths.length);
       
        //out.print(path);
        
        
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
