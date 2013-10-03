<%-- 
    Document   : index
    Created on : Sep 24, 2013, 11:56:56 PM
    Author     : webgig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
       // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
        //Connection connTennis = DriverManager.getConnection("jdbc:odbc:playerDSN");
        Class.forName("com.mysql.jdbc.Driver"); 

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itc557assignment2","root","");
        Statement st= con.createStatement(); 
        ResultSet rs=st.executeQuery("select * from users"); 
        //String sqlPlayers = "SELECT * FROM player";
       // ResultSet rsPlayers = st.executeQuery(sqlPlayers);
        
        while (rs.next())
            out.println("<p>" + rs.getString("name"));
        con.close();
        %>
        </body></html>
    </body>
</html>
