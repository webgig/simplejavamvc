/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Service;

import ITC557Assignment2.*;
import javax.servlet.ServletContext;
import java.sql.Connection;
import javax.servlet.ServletContextListener;

/**
 *
 * @author webgig
 */
abstract public class AbstractDbService    {
    
    protected Database db = null;
    private static ServletContext context;  

    public AbstractDbService(){
       db = (Database) getServletContext().getAttribute("db");
    }
    
    protected Connection _getConnection(){
       return db.getConnection();
       
    }
    
    protected void _closeConnection(){
        db.closeConnection();
    }
    
    /* Called by Listener */  
    public static void setServletContext(ServletContext context){  
        AbstractDbService.context = context;  
    }  
    /* Use this method to access context from any location */  
    public static ServletContext getServletContext(){  
        return AbstractDbService.context;  
    }  
    
    
}
