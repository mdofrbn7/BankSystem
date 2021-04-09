package GUI;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login implements GlobalVers {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;


	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bank Record Manager");
		frame.getContentPane().setLayout(null);
                
		//frame.setBackground(backgroundColor);
		
		JLabel label = new JLabel("WELCOME TO BANK RECORD MANAGER", SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		//label.setBounds(147, 11, 700, 50);
		label.setSize( 700, 50);
		frame.getContentPane().add(label);
		
		JLabel lblLoginScreen = new JLabel("Login Screen", SwingConstants.CENTER);
		lblLoginScreen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoginScreen.setBounds(250, 63, 101, 23);

		frame.getContentPane().add(lblLoginScreen);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(55, 119, 64, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(55, 159, 64, 23);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(130, 121, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("admin");
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(130, 161, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String user,pass;
				textField.setText("admin");
				user="admin";
				//user=textField.getText();
				pass=textField_1.getText();
				if((user.equals("admin")&&(pass.equals("admin"))))
						{
							JOptionPane.showMessageDialog(frame.getComponent(0), "Login Successfully");
							frame.setVisible(false);
							
							GUIForm.menu.setVisible(true);
							
						}
				else
				{
					JOptionPane.showMessageDialog(frame.getComponent(0), "Login Failed");
				}
			}
		});
		btnLogin.setBackground(buttonColor);
		btnLogin.setBounds(260, 138, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}