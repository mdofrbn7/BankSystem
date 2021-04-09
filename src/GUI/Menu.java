package GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.ImageIcon;
//import javax.swing.Icon;



public class Menu extends JFrame implements GlobalVers{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Banking System Menu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 735, 480);
		contentPane = new JPanel();
		contentPane.setBackground(backgroundColor);
		contentPane.setForeground(SystemColor.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBankingSystem = new JLabel("BANK RECORD MANAGER");
		lblBankingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankingSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBankingSystem.setBounds(0, 69, 700, 59);
		contentPane.add(lblBankingSystem);
		
		


		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(!GUIForm.addaccount.isVisible())
			{
				GUIForm.addaccount.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
			}


			}

		});
		btnNewButton.setBackground(buttonColor);
		btnNewButton.setBounds(120, 166, 150, 50);
		contentPane.add(btnNewButton);

		
		JButton btnDepositToAccount = new JButton("Deposit");
		btnDepositToAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.depositacc.isVisible())
				{
					GUIForm.depositacc.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
				
			}
		});
		btnDepositToAccount.setBackground(buttonColor);
		btnDepositToAccount.setBounds(280, 166, 150, 50);
		contentPane.add(btnDepositToAccount);
		
		JButton btnWithdrawFromAccount = new JButton("Withdraw");
		btnWithdrawFromAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.withdraw.isVisible())
				{
					GUIForm.withdraw.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
				
				
			}
			
		});
		btnWithdrawFromAccount.setBackground(buttonColor);
		btnWithdrawFromAccount.setBounds(440, 166, 150, 50);
		contentPane.add(btnWithdrawFromAccount);
		//ONe layer done.......................

		
		JButton btnDisplayAccountList = new JButton("Account List");
		btnDisplayAccountList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(!GUIForm.displaylist.isVisible())
				{
					GUIForm.displaylist.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
				
			}
		});
		btnDisplayAccountList.setBackground(buttonColor);
		btnDisplayAccountList.setBounds(120, 250, 150, 50);
		contentPane.add(btnDisplayAccountList);

		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!GUIForm.depositacc.isVisible())
				{
					GUIForm.about.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}

			}
		});
		btnAbout.setBackground(buttonColor);
		btnAbout.setBounds(280, 250, 150, 50);
		contentPane.add(btnAbout);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getComponent(0), "Thanks For Using") ;
//				FileIO.Write();
				System.exit(0);
			}
		});
		btnExit.setBackground(exitColor);
		btnExit.setBounds(440, 250, 150, 50);
		contentPane.add(btnExit);





	}


}
