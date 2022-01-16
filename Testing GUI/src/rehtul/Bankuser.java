package rehtul;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Bankuser extends JFrame {

	private JPanel contentPane;
	
	JToggleButton UserToggleButton;
	JToggleButton GlobeToggleButton_1;
	JToggleButton Card2ToggleButton;
	
	Connection u1;
	ResultSet rsu1;
	PreparedStatement psu1;
	
	String username, password,dbala;
	int account, balance;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bankuser frame = new Bankuser();
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
	public Bankuser() {
		connectu1();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\R.jfif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 510);
		setLocation(0,0);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		panel.setBounds(0, 0, 734, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MZALENDO BANK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setBounds(285, 11, 131, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 255));
		panel_1.setBounds(0, 46, 78, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		UserToggleButton = new JToggleButton("");
		UserToggleButton.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\user.jpg"));
		UserToggleButton.setBounds(10, 50, 44, 42);
		panel_1.add(UserToggleButton);
		
		GlobeToggleButton_1 = new JToggleButton("");
		GlobeToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worldtrade();
			}
		});
		GlobeToggleButton_1.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Globe.jpg"));
		GlobeToggleButton_1.setBounds(10, 254, 48, 42);
		panel_1.add(GlobeToggleButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBorder(null);
		panel_2.setBounds(77, 46, 557, 182);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Deposit Cash");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(46, 124, 95, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Withdraw Cash");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(234, 124, 95, 14);
		panel_2.add(lblNewLabel_2);
		
		JToggleButton Card2ToggleButton = new JToggleButton("");
		Card2ToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Removemoney().setVisible(true);
				dispose();
			}
		});
		Card2ToggleButton.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Card2.jpg"));
		Card2ToggleButton.setBounds(222, 34, 121, 79);
		panel_2.add(Card2ToggleButton);
		
		JToggleButton Card1ToggleButton = new JToggleButton("");
		Card1ToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit();
			}
		});
		Card1ToggleButton.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Card1.jpg"));
		Card1ToggleButton.setBounds(30, 34, 121, 79);
		panel_2.add(Card1ToggleButton);
		
		JToggleButton Card3ToggleButton = new JToggleButton("");
		Card3ToggleButton.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Card4.jpg"));
		Card3ToggleButton.setBounds(399, 34, 107, 79);
		panel_2.add(Card3ToggleButton);
		
		JLabel lblNewLabel_3 = new JLabel("Generate Statement");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(385, 124, 136, 14);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Trade.jpg"));
		btnNewButton.setBounds(103, 268, 130, 80);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Trade");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(145, 359, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Loan.jpg"));
		btnNewButton_1.setBounds(296, 267, 130, 81);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Loans");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(337, 359, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Morgage");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Morgage.jpg"));
		btnNewButton_2.setBounds(476, 268, 130, 80);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Morgage");
		lblNewLabel_6.setBounds(511, 359, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.scrollbar);
		panel_3.setBounds(0, 442, 644, 29);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Contact Us");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Contact2.jpg"));
		btnNewButton_3.setBounds(0, 0, 167, 29);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Report");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report();
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\report.jpg"));
		btnNewButton_4.setBounds(170, 0, 160, 29);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Locate us");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contact();
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\Location.jpg"));
		btnNewButton_5.setBounds(332, 0, 160, 29);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("FAQ");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FAQ().setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\FAQ.jpg"));
		btnNewButton_6.setBounds(495, 0, 149, 29);
		panel_3.add(btnNewButton_6);
	}

	private void connectu1() {
		// TODO Auto-generated method stub
		try {
			u1 = DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root", null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void deposit() {
		// TODO Auto-generated method stub
		try {
			new Depositfunds().setVisible(true);
			dispose();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void worldtrade() {
		// TODO Auto-generated method stub
		try {
			if(GlobeToggleButton_1.isSelected())
			{
				UserToggleButton.disable();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void report() {
		// TODO Auto-generated method stub
		new Report().setVisible(true);
		dispose();
	}

	protected void contact() {
		// TODO Auto-generated method stub
		Desktop desk = Desktop.getDesktop();
		try {
			desk.browse(new URI("https://www.google.com/maps/dir//United+States+International+University+Africa,+USIU+Road,+Off+Thika+Road+(Exit+7/@-1.2491272,36.8213071,13z/data=!4m9!4m8!1m0!1m5!1m1!1s0x182f15f826d2697b:0x283746033cb1b5a5!2m2!1d36.8792139!2d-1.2180945!3e0"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
