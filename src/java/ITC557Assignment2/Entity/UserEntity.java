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
public class UserEntity implements java.io.Serializable {

    // Properties.
    private int    id;
    private String  fname;
    private String  lname;
    private String  email;
    private String  phone;
    private String  address;
    private String  username;
    private String  password;
    private Date    dob;
    private Date    created;

    // Getters.
    public int getId() { 
        return id; 
    }
    
    
    public String getFName() { 
        return fname; 
    }
    
    public String getLName() { 
        return lname; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public String getPhone() { 
        return phone; 
    }
    
    public String getAddress() { 
        return address; 
    }
    
    
    public String getUsername() { 
        return username; 
    }
    
    public String getPassword() { 
        return password; 
    }
    
    
    public Date getDob() { 
        return dob; 
    } 
    
    public Date getCreated() { 
        return created; 
    }

    
    // Setters.
    public UserEntity setId(int id) { 
        this.id = id; 
       
      return this;
    }
    
    public UserEntity setFName(String fname) { 
        this.fname = fname; 
        
      return this;  
    }
    
    public UserEntity setLName(String lname) { 
        this.lname = lname; 
        
      return this;  
    }
    
    public UserEntity setEmail(String email) { 
        this.email = email; 
        
      return this;  
    }
    
    public UserEntity setPhone(String phone) { 
        this.phone = phone; 
        
      return this;  
    }
    
    public UserEntity setAddress(String address) { 
        this.address = address; 
        
      return this;  
    }
    
   
    public UserEntity setUserName(String username) { 
        this.username = username; 
        
      return this;  
    }
    
    public UserEntity setPassword(String password) { 
        this.password = password; 
        
      return this;  
    }
    
    
    public UserEntity setDob(Date dob) { 
        this.dob = dob;
        
     return this;
    }
    
    public UserEntity setCreated(Date created) { 
        this.created = created;
        
     return this;
    }

   
    
    
}