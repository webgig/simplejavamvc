/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Service;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import ITC557Assignment2.Database;
import ITC557Assignment2.Entity.UserEntity;

/**
 *
 * @author webgig
 */
public class UserService  extends AbstractDbService {
     private   DateFormat dateFormat = null; 
     
     private   String _tableName = "users";

    
     public UserService(){
         dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     }
     
    
    
     public UserEntity create(UserEntity user,PrintWriter out) {
          
        try{
            
            //sql to add a new player
            String sql = "INSERT INTO " + this._tableName + "(fname, lname, email, phone , address, username,password,dob,created) VALUES(?,?,?,?,?,?,?,?,?)";
            //insert a record into the player table.

            
            PreparedStatement pstmt = super._getConnection().prepareStatement(sql);
            pstmt.clearParameters();

            
            pstmt.setString(1, user.getFName());
            pstmt.setString(2, user.getLName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getUsername());
            pstmt.setString(7, user.getPassword());
            pstmt.setString(8, dateFormat.format(user.getDob()));

            
            Date d = new Date(System.currentTimeMillis());
            pstmt.setString(9,dateFormat.format(d));
            pstmt.executeUpdate();

            pstmt.close();//Close statement
            super._getConnection().close(); //Close database Connection

            return user;
        } catch(Exception e){
            out.print(e.getMessage());
            e.printStackTrace();
        } //Print trapped error.
       return null;  
      }
     
    public void update(UserEntity user) {

        try{
           
            //sql to add a new player
            String sql = "UPDATE  " + this._tableName + " SET "
                                + "fname    = ?,"
                                + "lname    = ?,"
                                + "email    = ?,"
                                + "phone    = ?,"
                                + "address  = ?,"
                                + "username = ?,"
                                + "password = ? "
                                + "dob      = ? "
                                + "WHERE id = ?";

            //insert a record into the player table.
            
            PreparedStatement pstmt = _getConnection().prepareStatement(sql);
            pstmt.clearParameters();

            
            pstmt.setString(1, user.getFName());
            pstmt.setString(2, user.getLName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getUsername());
            pstmt.setString(7, user.getPassword());
            pstmt.setString(8, dateFormat.format(user.getDob()));
            
            Date d = new Date(System.currentTimeMillis());
            pstmt.setString(8,dateFormat.format(d));
            
            pstmt.executeUpdate(); // Fire the query

            
            pstmt.close();//Close statement
            _getConnection().close(); //Close database Connection

            
        } catch(Exception e){
            e.printStackTrace();
            
        } //Print trapped error.
      }
    
    public UserEntity validate(String username, String password,PrintWriter out){

         try{
            String sql  = "SELECT * FROM " + this._tableName + " WHERE username=? and password=?";

            PreparedStatement pstmt = super._getConnection().prepareStatement(sql);

            pstmt.clearParameters();

            pstmt.setString(1, username);
            pstmt.setString(2, password);
             
            ResultSet rs  =  pstmt.executeQuery();
            
            if(!rs.first())
               return null;
            
                out.print(rs.getString("id"));
                
                UserEntity u = new UserEntity();
               
                        u.setId(rs.getInt("id"))
                         .setUserName(rs.getString("username"))
                         .setFName(rs.getString("fname"))
                         .setLName(rs.getString("lname"))
                         .setAddress(rs.getString("address"))
                         .setPhone(rs.getString("email"))
                         .setEmail(rs.getString("phone"))
                         .setDob(dateFormat.parse(rs.getString("dob")))
                         .setCreated(dateFormat.parse(rs.getString("created")));
               
              _getConnection().close(); //Close database Connection
 
               return u;
           
            
         } catch(Exception e){
             //e.printStackTrace();
             out.print(e.getMessage());
         } 
         
         return null;
    }
    
    
    public UserEntity findByEmailOrUsername(String username_or_email,PrintWriter out){
        
         
         try{
            String sql  = "SELECT * FROM " + this._tableName + " WHERE username=? or email=?";

            PreparedStatement pstmt = super._getConnection().prepareStatement(sql);

            pstmt.clearParameters();

            pstmt.setString(1, username_or_email);
            pstmt.setString(2, username_or_email);
             
            ResultSet rs  =  pstmt.executeQuery();
            
            if(!rs.first())
               return null;
                
                UserEntity u = new UserEntity();
               
                        u.setId(rs.getInt("id"))
                         .setFName(rs.getString("fname"))
                         .setLName(rs.getString("lname"))
                         .setAddress(rs.getString("address"))
                         .setPhone(rs.getString("email"))
                         .setEmail(rs.getString("phone"))
                         .setPassword(rs.getString("password"))
                         .setDob(dateFormat.parse(rs.getString("dob")))
                         .setCreated(dateFormat.parse(rs.getString("created")));
               
                 super._closeConnection(); //Close database Connection
 
               return u;
         } catch(Exception e){
             //e.printStackTrace();
             out.print(e.getMessage());
         } 
         
         return null;
         
    }
    
    
    public boolean userExists(String username,PrintWriter out){

         try{
            String sql  = "SELECT * FROM " + this._tableName + " WHERE username=?";

            PreparedStatement pstmt = super._getConnection().prepareStatement(sql);

            pstmt.clearParameters();

            pstmt.setString(1, username);
             
            ResultSet rs  =  pstmt.executeQuery();
                    
            return rs.first();
            
         } catch(Exception e){
             
             out.print(e.getMessage());
             e.printStackTrace();
         } 
         
         return false;
    }
    
    
    
}
