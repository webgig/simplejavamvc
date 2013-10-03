package ITC557Assignment2;


import ITC557Assignment2.Service.AbstractDbService;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author webgig
 */
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext sc = event.getServletContext();
 
    	String url       = sc.getInitParameter("url");
    	String user_name = sc.getInitParameter("user_name");
    	String password  = sc.getInitParameter("password");
    	String database  = sc.getInitParameter("database");
    	Database db      = new Database(url + database, user_name, password);
    	//System.out.println("in the listener!!");
    	sc.setAttribute("db", db);
        AbstractDbService.setServletContext(sc);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
