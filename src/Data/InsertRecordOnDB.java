package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import GUI.GlobalVers;

public class InsertRecordOnDB implements GlobalVers{
	  private Connection connect() {   
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
	
	public void insert(String id, String name, int Balance, String accType , int maxWithdrawLimit, String Institution, String TradeLicenceNo  ) {
		  String sql = "INSERT INTO accounts(id, name, Balance, accType, maxWithdrawLimit, Institution, TradeLicenceNo ) VALUES(?,?,?,?,?,?,?)";
		  
		  try {
			  Connection conn = this.connect();
	          PreparedStatement preparedStatement = conn.prepareStatement(sql);  
	          preparedStatement.setString(1, id);  
	          preparedStatement.setString(2, name);  
	          preparedStatement.setInt(3, Balance);
	          preparedStatement.setString(4, accType);
                  preparedStatement.setInt(5, maxWithdrawLimit);
                  preparedStatement.setString(6, Institution);
                  preparedStatement.setString(7, TradeLicenceNo);
                  
                  
                  
	          preparedStatement.executeUpdate();  
                  conn.close();
			  
		  }catch(SQLException e) {  
			  System.out.println(e.getMessage());  
		  }
		
	}

}
