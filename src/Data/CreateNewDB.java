package Data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import GUI.GlobalVers;

public class CreateNewDB implements GlobalVers {
	
	 public static void createNewDatabase() throws SQLException {  
	        try {  
	            Connection conn = DriverManager.getConnection(url);  
	            if (conn != null) {  
	                DatabaseMetaData meta = conn.getMetaData();  
	                System.out.println("The driver name is " + meta.getDriverName());  
	                System.out.println("A new database has been created.");  
	            } 
                    conn.close();
	   
	        } catch (SQLException e) {  
	            //System.out.println(e.getMessage());
                    throw e;
                    
	        }  
	    }  


}
