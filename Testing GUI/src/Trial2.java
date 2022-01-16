import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Trial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		JPanel panel1 = new JPanel();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		
		
		
		label.setText("LANDING PAGE");
		label.setVerticalAlignment(JLabel.TOP); //set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		label.setBounds(500, 100, 550, 750); //set x,y position within frame as well as dimensions
		label.setForeground(new Color(0xFFFFFF)); //set font color of text
		label.setFont(new Font("MV Boli",Font.PLAIN,15)); //set font of text

		panel1.setBackground(Color.gray);
		panel1.setSize(420, 100);
		panel1.setBounds(20,30,550,40);//x-axis,y-axis,width,height of the thing.
		frame.add(panel1);
		
		button1.setBounds(20,80,250,15);
		button1.setSize(125,50);
		button1.setText("Maths");
		button1.setBackground(Color.gray);
		button1.setFocusable(false);
		frame.add(button1);
		
		button2.setBounds(150,80,250,15);
		button2.setSize(125,50);
		button2.setText("English");
		button2.setBackground(Color.gray);
		button2.setFocusable(false);
		frame.add(button2);
		
		button3.setBounds(280,80,250,15);
		button3.setSize(125,50);
		button3.setText("Science");
		button3.setBackground(Color.gray);
		button3.setBorder(new EtchedBorder(20));
		button3.setFocusable(false);
		frame.add(button3);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setTitle("Landing page");
		frame.add(label);
		
		frame.setResizable(true);
		frame.setPreferredSize(new Dimension(600,600));//Replace set Size with set dimensions since it works
		label.setBackground(Color.darkGray);
		label.setOpaque(true);
		
		
		
		frame.setVisible(true);
		frame.pack();
		
		
	}

}
