package GUI;
import Bank.Bank;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddSavingsAccount extends JFrame implements GlobalVers{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField balanceTxtField;
	private JTextField maxWlimTxtField;

	/**
	 * Create the frame.
	 */
	public AddSavingsAccount() {
		setTitle("Add Savings Account ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(backgroundColor);
		
		JLabel lblAddCurrentAccount = new JLabel("Add Savings Account ");
		lblAddCurrentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddCurrentAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCurrentAccount.setBounds(10, 11, 414, 34);
		contentPane.add(lblAddCurrentAccount);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 72, 124, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(144, 69, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalance.setBounds(10, 118, 124, 14);
		contentPane.add(lblBalance);
		
		balanceTxtField = new JTextField();
		balanceTxtField.setColumns(10);
		balanceTxtField.setBounds(144, 115, 254, 20);
		contentPane.add(balanceTxtField);
		
		JLabel lblMaximumWithdrawLimit = new JLabel("Maximum Withdraw Limit:");
		lblMaximumWithdrawLimit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaximumWithdrawLimit.setBounds(10, 163, 150, 14);
		contentPane.add(lblMaximumWithdrawLimit);
		
		maxWlimTxtField = new JTextField();
		maxWlimTxtField.setColumns(10);
		maxWlimTxtField.setBounds(165, 160, 245, 20);
		contentPane.add(maxWlimTxtField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            String name=textField.getText();
                            int balance = Integer.parseInt(balanceTxtField.getText());
                            int maxWlim = Integer.parseInt(maxWlimTxtField.getText());
                            Bank bank = new Bank();
                            try {
                                bank.addAccount(name, balance, maxWlim);
                                JOptionPane.showMessageDialog(getComponent(0),"Added Successfully");
                                dispose();
                                } catch (Exception e1) {
                                       JOptionPane.showMessageDialog(getComponent(0),e1);
                                }

                        }
                });

        btnAdd.setBackground(buttonColor);
        btnAdd.setBounds(86, 209, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        textField.setText(null);
                        balanceTxtField.setText(null);
                        maxWlimTxtField.setText(null);

                }
        });
        btnReset.setBackground(buttonColor);
        btnReset.setBounds(309, 209, 89, 23);
        contentPane.add(btnReset);
        }
}
