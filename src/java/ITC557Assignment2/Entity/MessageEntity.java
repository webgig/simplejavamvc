/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Entity;
import java.util.*;

/**
 *
 * @author webgig
 */
public class MessageEntity {
    
    private int id;
    
    private int user_id;
    
    private int to;
    
    private int cc;
    
    private String subject;
    
    private String message;
    
    private int status;
    
    private Date  created;
    
    
    public int getId(){
        return id;
    }
    
    public int getUserId(){
        return user_id;
    }
    
    public int getTo(){
        return to;
    }
    
    public int getCc(){
        return cc;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public String getMessage(){
        return message;
    }
    
    public Date getCreated(){
        return created;
    }
    
    public int getStatus(){
        return status;
    }
    
    
    public MessageEntity setId(int id){
        this.id = id;
     return this;  
    }
    
    public MessageEntity setUserId(int user_id){
        this.user_id = user_id;
     return this;
    }
    
    public MessageEntity setTo(int to){
        this.to = to;
     return this;
    }
    
    public MessageEntity setCc(int cc){
        this.cc = cc;
     return this;
    }
        
    public MessageEntity setMessage(String message){
        this.message = message;
     return this;       
    }
    
    public MessageEntity setSubject(String subject){
        this.subject = subject;
     return this;       
    }
    
    public MessageEntity setCreated(Date created){
        this.created = created;
      return  this;
    }
    
    public MessageEntity setStatus(int status){
        this.message = message;
      return  this;
    }
    
    
    
}
