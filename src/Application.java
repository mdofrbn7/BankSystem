
import Data.CreateNewDB;
import Data.CreateTableOnDB;

import java.awt.EventQueue;

import GUI.GUIForm;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
//       Connection con = null;
//        ResultSet rs = null;
//        String url="jdbc:sqlite:account_info.db";
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                   // createDB();
                    //CreateTableOnDB.createTable();
                    GUIForm.login.frame.setVisible(true);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e );
                }
            }
        });
    }
    public static void createDB(){
       
       
        Connection con = null;
        ResultSet rs = null;
        String url="jdbc:sqlite:account_info.db";
       String dbName ="account_info.db";
         CreateNewDB db = new CreateNewDB();
         try {
             con = DriverManager.getConnection(url);
             if(con !=null){
                rs = con.getMetaData().getCatalogs();
                while(rs.next()){
                    String catalogs = rs.getString(1);
                    if(dbName.equals(catalogs)){
                        System.out.println("the database "+dbName+" exists");
                    }
                    
                }
             }else{
                        try{
                             db.createNewDatabase();
                        }catch(SQLException x){
                            JOptionPane.showMessageDialog(null,x );
                        }
                    }
             con.close();
             rs.close();

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,ex );
        }
      
    }
}
