import java.awt.BorderLayout;

import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	Connection mydb;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test4 frame = new Test4();
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
	public Test4() {
		
		connection1();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(58, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(151, 50, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	private void connection1() {
		// TODO Auto-generated method stub
		try {
			mydb = DriverManager.getConnection("jdbc:mysql://localhost/clinic_system","root", null);
			
		}
		catch(Exception e)
		{
			//System.out.print(e);
			e.printStackTrace();
		}
	}
}
