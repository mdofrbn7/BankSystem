package GUI;

import Bank.Bank;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;



public class DepositAcc extends JFrame implements Serializable {

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
	public DepositAcc() {
		setTitle("Deposit To Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(backgroundColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepositToAccount = new JLabel("Deposit To Account");
		lblDepositToAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepositToAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositToAccount.setBounds(10, 11, 414, 36);
		contentPane.add(lblDepositToAccount);
		
		JLabel lblName = new JLabel("Account Number:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(0, 86, 140, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(145, 83, 205, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 147, 211, 20);
		contentPane.add(textField_1);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(0, 150, 111, 14);
		contentPane.add(lblAmount);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FileIO file=new FileIO();
				Bank bank =new Bank();
				String aacountNum=textField.getText();
                                int amt=Integer.parseInt(textField_1.getText());
                            try {
                                bank.deposit(aacountNum, amt);
                            } catch (InvalidAmount ex) {
                               JOptionPane.showMessageDialog(getComponent(0), ex);
                            } catch (AccNotFound ex) {
                                JOptionPane.showMessageDialog(getComponent(0),ex);
                            }
                                JOptionPane.showMessageDialog(getComponent(0),"Deposit Successful");
                                dispose();
                                textField.setText(null);
                                textField_1.setText(null);
                        }
		});
		btnDeposit.setBackground(buttonColor);
		btnDeposit.setBounds(73, 212, 89, 23);
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
