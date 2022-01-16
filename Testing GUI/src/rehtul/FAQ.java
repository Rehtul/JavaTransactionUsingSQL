package rehtul;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

public class FAQ extends JFrame {

	private JPanel contentPane;

	List list;
	TextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQ frame = new FAQ();
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
	public FAQ() {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\luthe\\OneDrive\\Desktop\\IST 4070A\\FAQ.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(0,0);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Frequently Asked Questions:");
		lblNewLabel.setBounds(10, 2, 148, 14);
		contentPane.add(lblNewLabel);
		
		
		list = new List();
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection();
			}
		});
		list.setBounds(10, 32, 414, 20);
		list.add("Question 1: Can I Change My Account?");
		list.add("Question 2: Can I trade using My savings Account?");
		contentPane.add(list);
		
		textArea = new TextArea();
		textArea.setBounds(10, 69, 414, 160);
		contentPane.add(textArea);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conf();
			}
		});
		button.setBounds(161, 239, 70, 22);
		contentPane.add(button);
	}

	protected void conf() {
		// TODO Auto-generated method stub
		try {
			new Bankuser().setVisible(true);
			dispose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void selection() {
		// TODO Auto-generated method stub
		try {
			if(list.getSelectedIndex()==0)
			{
				textArea.setText("It depends on the account type"
						+ "\nGold - Allowed to change account"
						+ "\nDeluxe - Not Allowed to change account"
						+ "\nStandard - Not Allowed to change account");
			}
			if(list.getSelectedIndex()==1)
			{
				textArea.setText("It depends on the amount in the account and the minimum requirements"
						+ "\nYou must buy more than 100 shares"
						+ "\nMust be certified to trade with NSE"
						+ "\nShould be conversant with the concept of day closing");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
