/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Service;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import javax.servlet.ServletException;
import java.sql.*;
import ITC557Assignment2.Database;
import ITC557Assignment2.Entity.MessageEntity;

/**
 *
 * @author webgig
 */
public class MessageService  extends AbstractDbService {
     private   DateFormat dateFormat = null; 
     private   String _tableName     = "messages";
     private   String _tableName_receipient     = "messages_receipients";

    
     public MessageService(){
         dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     }
     
    
    
     public MessageEntity create(MessageEntity msg,PrintWriter out) {
        String sql ;
        
        try{
            //sql to add a new player
            sql = "INSERT INTO " + this._tableName + "(user_id,subject,message,created) VALUES (?,?,?,?)";
            
            PreparedStatement pstmt = super._getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.clearParameters();

            
            pstmt.setInt(1, msg.getUserId());
            pstmt.setString(2, msg.getSubject());
            pstmt.setString(3, msg.getMessage());
            pstmt.setString(4,dateFormat.format(new Date(System.currentTimeMillis())));
            
            if(pstmt.executeUpdate()!=0){  
               ResultSet rs = pstmt.getGeneratedKeys();
               rs.next();
               msg.setId(rs.getInt(1));
               return msg;
            } else 
               return null;
                    
            
        } catch(Exception e){
            out.print("Message Service : "+e.getMessage());
            e.printStackTrace();
        } //Print trapped error.
        
       return null;  
      }
     
    
    
     
     public boolean  createReceipient(MessageEntity msg,PrintWriter out){
        
        try{
                String sql   = "INSERT INTO " + this._tableName_receipient + "(msg_id,msg_to,msg_cc,status) VALUES(?,?,?,?)";
                PreparedStatement pstmt = super._getConnection().prepareStatement(sql);
                pstmt.clearParameters();
                out.print(msg.getCc());
                pstmt.setInt(1, msg.getId());
                pstmt.setInt(2, msg.getTo());
                pstmt.setInt(3, msg.getCc());
                pstmt.setInt(4,1);
               
                return pstmt.executeUpdate()!=0;
                
         } catch(Exception e){
            out.print("Message Service : "+e.getMessage());
            e.printStackTrace();
        } //Print trapped error.
        
       return false;  
     }
     
     public List<MessageEntity> listMessages(   ){
         String sql   =   "SELECT  msg.*, msg_rcpts.* " + this._tableName_receipient + " as msg "
                        + "LEFT INNER JOIN " + this._tableName_receipient + " as msg_rcpts on msg_rcpts.msg_id=msg.id "
                        + "WHERE msg_rcpts.to=? or msg_rcpts.cc=? AND msg.status = 1 " ;
           try{ 
                PreparedStatement pstmt = super._getConnection().prepareStatement(sql);
                pstmt.clearParameters();
                pstmt.setInt(1, msg.getId());
                pstmt.setInt(2, msg.getTo());
                
           } catch(Exception e){
               e.printStackTrace();
           }
           
            return pstmt.executeUpdate()!=0;  
     }
    
}
