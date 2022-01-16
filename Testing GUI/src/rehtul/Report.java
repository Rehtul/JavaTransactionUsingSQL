package rehtul;

import java.sql.*;
import java.time.LocalTime;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.net.URI;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Report extends JFrame {

	private JPanel contentPane;
	JEditorPane editorPane;
	
	Connection r1;
	PreparedStatement psr1;
	ResultSet rsr1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		connection1();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\report.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(0,0);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(61, 127, 349, 87);
		contentPane.add(editorPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendmail();
			}
		});
		btnNewButton.setBounds(172, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Describe your problem in the Box below:");
		lblNewLabel.setBounds(10, 37, 219, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 255));
		panel.setBounds(0, 0, 434, 26);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MZALENDO BANK");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(152, 0, 144, 25);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(61, 96, 349, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Subject:");
		lblNewLabel_2.setBounds(10, 99, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Body:");
		lblNewLabel_3.setBounds(10, 127, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Account No:");
		lblNewLabel_4.setBounds(10, 74, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 71, 335, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

	private void connection1() {
		// TODO Auto-generated method stub
		try {
			r1 = DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void sendmail() {
		// TODO Auto-generated method stub
		Desktop desk = Desktop.getDesktop();
		String report;
		editorPane.setContentType("text/plain");
		LocalTime ti = LocalTime.now();
		report = editorPane.getText();
		try {
			String query = "Insert into reports values(?,?,?)";
			psr1=r1.prepareStatement(query);
			psr1.setString(1, textField_1.getText());
			psr1.setString(2,textField.getText());
			psr1.setString(3, editorPane.getText());
			JOptionPane.showMessageDialog(null, "Report successfully sent");
			psr1.execute();
			
			dispose();
			new Bankuser().setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
