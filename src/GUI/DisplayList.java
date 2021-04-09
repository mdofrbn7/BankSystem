package GUI;
import java.awt.Color;
import javax.swing.DefaultListModel;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class DisplayList extends JFrame implements GlobalVers{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	static DefaultListModel<String> arr = new DefaultListModel<String>();
	private JPanel contentPane;
        public JTextArea infoTextarea ;
        

	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ })
	public DisplayList() {
            setTitle("Account List");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 649, 474);
            contentPane = new JPanel();
            contentPane.setBackground(backgroundColor);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblAccountList = new JLabel("Account List");
            lblAccountList.setFont(new Font("Tahoma", Font.BOLD, 18));
            lblAccountList.setHorizontalAlignment(SwingConstants.CENTER);
            lblAccountList.setBounds(0, 11, 623, 31);
            contentPane.add(lblAccountList);
            updateDB();
          
            JButton refreshButton = new JButton("Refresh");
            
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                          updateDB();
                  }
              });
		refreshButton.setBackground(Color.GRAY);
		refreshButton.setBounds(0, 0, 89, 23);
		contentPane.add(refreshButton);
                
                
                    infoTextarea = new JTextArea("");
                    infoTextarea.setEditable(false);
                    infoTextarea.setWrapStyleWord(true);
                    infoTextarea.setLineWrap(true);
                    infoTextarea.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 14));
                    JScrollPane scrollPane =new JScrollPane (infoTextarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
                    //scrollPane.setBounds(100,100,400,250);
                    scrollPane.setBounds(10, 66, 613, 358);
                    //getContentPane().add(scrollPane);
                    contentPane.add(scrollPane);
                    updateDB();
               
             
               
	}
        public void updateDB(){
              
            Connection c = null;
            Statement stmt = null;
             try {

                 c = DriverManager.getConnection("jdbc:sqlite:account_info.db");
                 c.setAutoCommit(false);
                 //JOptionPane.showMessageDialog(null,"Opened database successfully");

                 stmt = c.createStatement();
                 ResultSet rs = stmt.executeQuery( "SELECT * FROM accounts;" );
                 ResultSetMetaData rsmd = rs.getMetaData();
//                 int columnsNumber = rsmd.getColumnCount();
                
                 while ( rs.next() ) {
                     
                            
                            String id = rs.getString("id");
                            String  name = rs.getString("name");
                            int balance  = rs.getInt("Balance");
                            String  accType = rs.getString("accType");
                            int maxWithdrawLimit = rs.getInt("maxWithdrawLimit");
                            String  Institution = rs.getString("Institution");
                            String  TradeLicenceNo = rs.getString("TradeLicenceNo");
                        // rs.getString(i);
                        StringBuilder stringBuilder = new StringBuilder(100);
                        String data =" "+  stringBuilder.append("ID: ").append(id).append(" NAME: ").append(name).append(" BALANCE: ").append(balance).append(" \nACCOUNT_TYPE: ").append(accType).append(" \nMAXIMUM_WITHDRAW_LIMIT: ").append(maxWithdrawLimit).append(" \nINSTITUTION: ").append(Institution).append(" TRADE_LICENCE_NO: ").append(TradeLicenceNo).append("\n\n\n");
                         System.out.println(data);
                         infoTextarea.append(data);
                     
                     }
                      
                    
                   
   
            } catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
             }
             
             
             
             
         
            
        }
}
