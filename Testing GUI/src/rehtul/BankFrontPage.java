package rehtul;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.List;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Button;

public class BankFrontPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankFrontPage frame = new BankFrontPage();
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
	public BankFrontPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocation(0,0);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 255));
		panel.setBounds(0, 0, 734, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\BANK LOGO.jpg"));
		lblNewLabel.setBounds(249, 11, 222, 98);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Banking Solution since 2008.\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD, 17));
		lblNewLabel_1.setBounds(217, 257, 300, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Comfort with acknowledging that your valuables and finance are in the safest hands in the industry");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Vivaldi", Font.BOLD, 17));
		lblNewLabel_2.setBounds(66, 291, 602, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\anniversary.jpg"));
		lblNewLabel_3.setBounds(287, 119, 152, 127);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thank you for choosing us");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Vivaldi", Font.BOLD, 17));
		lblNewLabel_4.setBounds(101, 336, 540, 28);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Discover the possibilites");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bankauthority().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(287, 406, 176, 28);
		contentPane.add(btnNewButton);
	}
}
