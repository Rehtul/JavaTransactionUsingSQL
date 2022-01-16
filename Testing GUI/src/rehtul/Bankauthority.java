package rehtul;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;


public class Bankauthority extends JFrame {

	Connection b1;
	ResultSet rv;
	PreparedStatement ps;
	
	JButton btnNewButton_1;
	
	String Username;
	String password;
	String username1;
	String id;
	String gender;
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtID;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bankauthority frame = new Bankauthority();
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
	public Bankauthority() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\profphoto.jpg"));
		connect1();
		setBackground(Color.WHITE);
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLocation(0,0);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 347, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelpic = new JLabel("");
		labelpic.setBounds(48, 147, 221, 119);
		labelpic.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\BANK LOGO.jpg"));
		panel.add(labelpic);
		
		JLabel Thanksdets = new JLabel("Thank you for banking with us..");
		Thanksdets.setFont(new Font("Rage Italic", Font.ITALIC, 24));
		Thanksdets.setForeground(new Color(245, 245, 245));
		Thanksdets.setBounds(31, 304, 289, 42);
		panel.add(Thanksdets);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(403, 110, 219, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Customer Credentials");
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 15));
		lblNewLabel.setBounds(414, 48, 181, 23);
		contentPane.add(lblNewLabel);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmation();
			}
		});
		loginButton.setBounds(444, 306, 151, 23);
		contentPane.add(loginButton);
		
		JLabel lblNewLabel_1 = new JLabel("User Name: ");
		lblNewLabel_1.setBounds(408, 97, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setBounds(408, 229, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(403, 176, 219, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Customer ID:");
		lblNewLabel_3.setBounds(410, 162, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Forgot Password");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetpassword();
			}
		});
		btnNewButton.setBounds(444, 359, 151, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(403, 241, 219, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("New User");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnNewButton_1.setBounds(444, 415, 151, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void resetpassword() {
		// TODO Auto-generated method stub
		Desktop desk = Desktop.getDesktop();
		try {
			desk.browse(new URI("https://myaccount.usiu.ac.ke/showLogin.cc"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void insert() {
		// TODO Auto-generated method stub
		try {
			Username=txtUsername.getText();
			password=passwordField.getText();
			id=txtID.getText();
			
			
			if(Username =="Admin") {
				btnNewButton_1.setEnabled(true);
			
			String query = "Insert into employees values(?,?,?)";
			ps=b1.prepareStatement(query);
			
			ps.setString(1,Username);
			ps.setString(2,id);
			ps.setString(3,password);
			
			ps.execute();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Record successfully added");
		
	}

	protected void confirmation() {
		// TODO Auto-generated method stub
		try {
			
			//rv.first();
			//while(rv.next())
			boolean found = false;
			while(rv.next()) {
			Username = rv.getString(1);
			id = rv.getString(2);
			password = rv.getString(3);
			
			if(txtUsername.getText().equals(rv.getString(1))&&txtID.getText().equals(rv.getString(2))&&passwordField.getText().equals(rv.getString(3)))
			{
				found = true;
				new Bankuser().setVisible(true);
				
				dispose();
			}
			}
			if(!found)
			{
				JOptionPane.showMessageDialog(null, "Incorrectname, Shutting Down");
				System.exit(0);
		
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void connect1() {
		// TODO Auto-generated method stub
		try {
			b1 = DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root", null);
			
			String query = "select * from employees";
			ps = b1.prepareStatement(query);
			rv=ps.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
