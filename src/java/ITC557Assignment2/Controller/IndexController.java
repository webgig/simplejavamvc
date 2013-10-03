/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ITC557Assignment2.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author webgig
 */
public class IndexController  extends AbstractController {
    
    
    public IndexController(HttpServletRequest request , HttpServletResponse response){
        super.setRequest(request);
        super.setResponse(response);
    }
    
    
    public void indexAction() throws ServletException, IOException {

        
        
    // try{
       //this.getRequest().getRequestDispatcher("test.jsp").forward(this.getRequest(),this.getResponse());
     //} catch(Exception e ) {
            
     //}
     
    }
    
    public String testAction(){
    
     return "IndexController testAction";
  
    }
    
    
    
}
