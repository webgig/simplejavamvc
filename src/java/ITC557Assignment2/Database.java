package ITC557Assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Database {
 
	private Connection conn = null;
        private String url;
        private String user_name;
        private String password;
 
	public Database(String url, String user_name, String password) {
                this.url       = url;
                this.user_name = user_name;
                this.password  = password;
                
		_openConnection();
	}
        
        
        public void _openConnection(){
            
               try {
                    
                    //if(this.conn==null){
                       Class.forName("com.mysql.jdbc.Driver");
                       this.conn = DriverManager.getConnection(this.url, this.user_name, this.password);
                    //}
                    
               }catch (ClassNotFoundException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               } catch (SQLException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               }
        }
        
	public Connection getConnection() {
             _openConnection();
            return this.conn;
        }
        
        public void closeConnection() {
            try {
                this.conn.close();
                this.conn = null;
            } catch (SQLException e) {
                 e.printStackTrace();
             }
        }
 
	public ResultSet runSql(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
}
