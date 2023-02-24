package Library;

import java.sql.*;
public class ConnectionClass {
	
	
	 Connection con;
	    Statement stmt;

	    ConnectionClass() {
	        try {

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","");
	            stmt = con.createStatement();
	            
	            if(con.isClosed()){
	            
	                System.out.println("Not Connected");
	            }
	            
	            else{
	            System.out.println("Connected");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
	    
	    public static void main(String[] args) {
	        new ConnectionClass();
	    }
}
