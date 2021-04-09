package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import GUI.GlobalVers;

public class CreateTableOnDB implements GlobalVers {
	public static void createTable() {
		   // SQL statement for creating a new table 
		  String sql = "CREATE TABLE IF NOT EXISTS accounts (\n"  
	                + " id text PRIMARY KEY,\n"  
	                + " name text NOT NULL,\n"  
	                + " Balance integer,\n"
	                + " accType text NULL,\n"
                        + " maxWithdrawLimit integer NULL,\n"
                        + " Institution text NULL,\n"
                        + " TradeLicenceNo text NULL\n"
	                + ");";  
		  
		     try{  
		            Connection connection = DriverManager.getConnection(url);  
		            Statement statement = connection.createStatement();  
		            statement.execute(sql);  
		        } catch (SQLException e) {  
		            System.out.println(e.getMessage());  
		        } 
	}
	

}
