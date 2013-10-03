/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;
/**
 *
 * @author webgig
 */
public class NewUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //try {
            /* TODO output your page here. You may use following sample code. */
            newUser(request,response);
            
        //} finally {            
            //out.close();
        //}
    }
    
      protected void newUser(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
        
          PrintWriter out = response.getWriter();
        

        try{
            
            String username = request.getParameter("username").toString();
            String password = request.getParameter("password").toString();
            String fname    = request.getParameter("fname").toString();
            String lname    = request.getParameter("lname").toString();
            String address  = request.getParameter("address").toString();
            String email    = request.getParameter("email").toString();
            String phone    = request.getParameter("phone").toString();
            
            //Loading Sun's JDBC ODBC Driver 
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
            
            //Connect to playerDB Data source
	    Database db = (Database) getServletContext().getAttribute("db");
            

            //sql to add a new player
            String sql = "INSERT INTO users(fname, lname, email, phone , address, username,password,created) VALUES(?,?,?,?,?,?,?,?)";
            //insert a record into the player table.

            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            
            pstmt.clearParameters();

            
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, address);
            pstmt.setString(6, username);
            pstmt.setString(7, password);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            Date d = new Date(System.currentTimeMillis());
	    
            out.println(dateFormat.format(d));

            pstmt.setString(8,dateFormat.format(d));
            

            pstmt.executeUpdate();
            //rsPlayer.close();//Close the result set
            pstmt.close();//Close statement
            db.getConnection().close(); //Close database Connection
            //redirect to the JSP for displaying player details
            //res.sendRedirect("/displayPlayer.jsp"); 
        } catch(Exception e){
            out.println(e.getMessage());
        } //Print trapped error.
         
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
