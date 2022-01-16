package rehtul;

import java.awt.BorderLayout;
import java.sql.*;
import java.time.LocalTime;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Removemoney extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	String accountno, amountentered,amountretrieved, withamount,password;
	int amount1,amount2,difference;
	
	Connection c1;
	PreparedStatement ps1;
	ResultSet rs1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Removemoney frame = new Removemoney();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Removemoney() {
		Connectmy1();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setResizable(false);
		setLocation(0,0);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter account number:");
		lblNewLabel.setBounds(10, 71, 156, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(218, 68, 246, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter card security code:");
		lblNewLabel_1.setBounds(10, 113, 156, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 110, 246, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter amount to withdraw:");
		lblNewLabel_2.setBounds(10, 155, 156, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 152, 246, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter password:");
		lblNewLabel_3.setBounds(10, 191, 132, 14);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 188, 246, 20);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 255));
		panel.setBounds(0, 0, 494, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("MZALENDO BANK");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(134, 11, 209, 24);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("WITHDRAW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawmoney();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(216, 227, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bankuser().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(358, 227, 104, 23);
		contentPane.add(btnNewButton_1);
	}

	private void Connectmy1() {
		// TODO Auto-generated method stub
		try {
			c1=DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root", null);
			String query = "select * from employees";
			ps1 = c1.prepareStatement(query);
			rs1=ps1.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void withdrawmoney() {
		// TODO Auto-generated method stub
		try {
			while(rs1.next())
			{
			accountno = textField.getText();
			password = passwordField.getText();
			amountentered = textField_2.getText();
			amountretrieved = rs1.getString(5);
			amount1 = Integer.parseInt(amountentered);
			amount2 = Integer.parseInt(amountretrieved);
			difference = amount2 - amount1;
			LocalTime ti = LocalTime.now();
			String query = "update employees set cash_available = ?"+" where account_number = ?";
			ps1 = c1.prepareStatement(query);
			ps1.setInt(1, difference);
			ps1.setString(2, textField.getText());
			
			if(accountno.equals(rs1.getString(4))&&password.equals(rs1.getString(3)))
			{
				if(amount1<=amount2&&amount1<70000)
				{
					JOptionPane.showMessageDialog(null, ti+"\nFunds successfully dispersed\nYou will recieve them shortly via M-PESA\nWithdrawn: "+amountentered+"\nNew Balance is: "+difference);
					dispose();
					new Bankuser().setVisible(true);
				}	
			}
			ps1.executeUpdate();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
