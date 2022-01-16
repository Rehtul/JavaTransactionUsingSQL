package rehtul;

import java.awt.BorderLayout;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Depositfunds extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	List list;
	JLabel Variant;
	Label Variant2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel Variant3;
	JButton btnNewButton_1;
	
	Connection d1;
	ResultSet rsd1;
	PreparedStatement psd1;
	
	String accountnumber1, accountnumber2,balance1,balance2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Depositfunds frame = new Depositfunds();
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
	public Depositfunds() {
		setTitle("Deposit funds");
		Depositconn();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Depositicon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 400);
		setResizable(false);
		setLocation(0,0);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		panel.setBounds(0, 0, 464, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MZALENDO BANK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(156, 11, 149, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deposit Via: ");
		lblNewLabel_1.setBounds(10, 77, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		list = new List();
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection();
			}
		});
		list.setBackground(new Color(51, 102, 255));
		list.setForeground(new Color(255, 255, 255));
		list.setBounds(94, 77, 360, 22);
		list.add("");
		list.add("Mobile transfer");
		list.add("Company Cheque");
		list.add("Personal Cheque");
		list.add("Remote Wired Transfer");
		list.add("Another Account");
		contentPane.add(list);
		
		Variant = new JLabel("");
		Variant.setBounds(10, 120, 401, 14);
		contentPane.add(Variant);
		
		textField = new JTextField();
		textField.setBounds(10, 145, 444, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Variant2 = new Label("");
		Variant2.setForeground(new Color(0, 0, 0));
		Variant2.setBounds(10, 182, 401, 22);
		contentPane.add(Variant2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 212, 444, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 271, 444, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		Variant3 = new JLabel("");
		Variant3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Variant3.setBounds(10, 246, 444, 14);
		contentPane.add(Variant3);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backhome();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Homeicon.jpg"));
		btnNewButton.setForeground(new Color(255, 153, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("CANCEL TRANSFER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terminate();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\terminateicon.jpg"));
		btnNewButton_1.setForeground(new Color(255, 0, 51));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(140, 327, 165, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PROCEED");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatebalance();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\tickcheck.jpg"));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 204, 0));
		btnNewButton_2.setBounds(346, 327, 108, 23);
		contentPane.add(btnNewButton_2);
	}

	private void Depositconn() {
		// TODO Auto-generated method stub
		try {
			d1 = DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root", null);
			String query = "select * from employees";
			psd1 = d1.prepareStatement(query);
			rsd1=psd1.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void updatebalance() {
		// TODO Auto-generated method stub
		try {
			while(rsd1.next())
			{
			accountnumber1 = textField.getText();
			accountnumber2 = rsd1.getString(4);
			balance1=textField_1.getText();
			balance2=rsd1.getString(5);
			int oldamount = Integer.parseInt(balance1);
			int newamount = Integer.parseInt(balance2);
			int total = oldamount + newamount;
			LocalTime ti = LocalTime.now();
			String query = "update employees set cash_available = ?"+" where account_number = ?";
			psd1 = d1.prepareStatement(query);
			psd1.setInt(1, total);
			psd1.setString(2, textField.getText());
			if(accountnumber1.equals(accountnumber2))
			{
				JOptionPane.showMessageDialog(null,ti+"\nFunds successfully depositted\nNew Account Balance is "+total);
			}
			psd1.executeUpdate();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void terminate() {
		// TODO Auto-generated method stub
		int a;
		a = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
		if(a==JOptionPane.YES_OPTION)
		{
			textField.setText(null);
			textField_1.setText(null);
			textField_2.setText(null);
			
		}
		if(a==JOptionPane.NO_OPTION)
		{
			System.exit(1);
		}
		if(a==JOptionPane.CANCEL_OPTION)
		{
			System.exit(1);
		}
	}

	protected void backhome() {
		// TODO Auto-generated method stub
		new Bankuser().setVisible(true);
		dispose();
	}

	protected void selection() {
		// TODO Auto-generated method stub
		try {
			if(list.getSelectedIndex()==1)
			{
				Variant.setText("Enter the account number below");
				Variant2.setText("Enter amount to deposit");
				Variant3.setText("Enter the M-PESA code below after sending the deposit to paybill 22222");
			}
			if(list.getSelectedIndex()==2)
			{
				Variant.setText("Enter the account number below");
				Variant2.setText("Enter amount to deposit");
				Variant3.setText("Enter the cheque REF/Company ID number below");
			}
			if(list.getSelectedIndex()==3)
			{
				Variant.setText("Enter the account number below");
				Variant2.setText("Enter amount to deposit");
				Variant3.setText("Enter the cheque REF/Bank Security ID number below");
			}
			if(list.getSelectedIndex()==4)
			{
				Variant.setText("Enter the account number below");
				Variant2.setText("Enter amount to depositted");
				Variant3.setText("Enter the routing number below");
			}
			if(list.getSelectedIndex()==5)
			{
				Variant.setText("Enter the Recieving account number below");
				Variant2.setText("Enter amount to depositted");
				Variant3.setText("Enter the Transferring code from other account below");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
