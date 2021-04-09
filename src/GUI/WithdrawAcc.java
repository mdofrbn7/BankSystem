package GUI;
import Bank.Bank;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;


public class WithdrawAcc extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	 public Color exitColor = new Color(177, 149, 130, 114);
	public Color buttonColor = new Color(165, 218, 226, 193);
	public Color backgroundColor = new Color(167, 173, 196, 225);

	/**
	 * Create the frame.
	 */
	public WithdrawAcc() {
		setTitle("Withdraw From Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(backgroundColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepositToAccount = new JLabel("Withdraw From Account");
		lblDepositToAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepositToAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositToAccount.setBounds(10, 11, 414, 36);
		contentPane.add(lblDepositToAccount);
		
		JLabel lblName = new JLabel("Account Number:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(0, 86, 140, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(145, 83, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 147, 216, 20);
		contentPane.add(textField_1);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(10, 150, 96, 14);
		contentPane.add(lblAmount);
		
		JButton btnDeposit = new JButton("Withdraw");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
                      
				Bank bank =new Bank();			
			
				String aacountNum=textField.getText();
				int amt=Integer.parseInt(textField_1.getText());
					try {
						
							
							bank.withdraw(aacountNum, amt);
							JOptionPane.showMessageDialog(getComponent(0),"Withdraw Successful");
							dispose();
						
		
						
					} catch (MaxBalance e1) {
						JOptionPane.showMessageDialog(getComponent(0), "Insufficient Balance");
						JOptionPane.showMessageDialog(getComponent(0),"Failed");
						textField.setText(null);
						textField_1.setText(null);
				
					} catch (AccNotFound e1) {
						JOptionPane.showMessageDialog(getComponent(0), "Sorry! Account Not Found");
						JOptionPane.showMessageDialog(getComponent(0),"Failed");
						textField.setText(null);
						textField_1.setText(null);
					
					} catch (MaxWithdraw e1) {
						JOptionPane.showMessageDialog(getComponent(0), "Maximum Withdraw Limit Exceed");
						JOptionPane.showMessageDialog(getComponent(0),"Failed");
						textField.setText(null);
						textField_1.setText(null);
						
					} catch (InvalidAmount e1) {
						JOptionPane.showMessageDialog(getComponent(0), "Invalid Amount");
						JOptionPane.showMessageDialog(getComponent(0),"Failed");
						textField.setText(null);
						textField_1.setText(null);
					}
				
				
					textField.setText(null);
					textField_1.setText(null);
				
				
				

			}
		});
		btnDeposit.setBackground(buttonColor);
		btnDeposit.setBounds(73, 212, 130, 23);
		contentPane.add(btnDeposit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(243, 212, 89, 23);
		contentPane.add(btnReset);
		btnReset.setBackground(buttonColor);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField.setText(null);
				textField_1.setText(null);
			}
		});
		
		
		
		
		
		
		
	}
}
